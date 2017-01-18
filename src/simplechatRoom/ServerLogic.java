package simplechatRoom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

public class ServerLogic implements Runnable {
    
    private ServerSocket serverSocket;
    
    private HashMap<String,User> userList;
    private ArrayList<String> chatLog;
    
    private int userNumber;
    
    public ServerLogic(int port) throws IOException {
        this.userList = new HashMap<>();
        this.chatLog = new ArrayList<>();
        
        this.userNumber = 0;
        
        openPort(port);
    }
    
    private void openPort(int portNumber) {
        try {
            serverSocket = new ServerSocket(portNumber);
            System.out.println("opened socket at "+java.net.InetAddress.getLocalHost()+":"+serverSocket.getLocalPort());
        } catch (IOException ex) {
            Logger.getLogger(ServerLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void listenForConnection() {
        try {
            //opens connection
            Socket clientSocket = serverSocket.accept();
            
            Thread t = new Thread(this,"t");
            t.start();
            
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            //setup user
            String userID = clientSocket.getInetAddress()+":"+clientSocket.getPort();
            addUser(userID, clientSocket, out, in);
            System.out.println(userList.get(userID).getUsername() +" connected "+userID);
            
            for (User user: userList.values()) {
                out.println(user.getUsername());
            }
            out.println("usersAdded");
            
            sendToAllUsers(userList.get(userID).getUsername()+" connected");

            //IO
            String inputLine;
            
            while(true) {
                inputLine = in.readLine();
                
                if (inputLine.length()<=2) {
                    continue;
                }
                
                if (inputLine.startsWith("msg")) {
                    String message = inputLine.substring(3);
                    recieveMessage(userID, message);
                    sendToAllUsers(userList.get(userID).getUsername() + ": " + message);
                }
                
                if (inputLine.startsWith("nmc")) {
                    String oldName = userList.get(userID).getUsername();
                    String newName = inputLine.substring(3);
                    recieveNameChange(userID, newName);
                    sendToAllUsers(oldName+" has changed name to "+newName);
                }
                
                if (inputLine.startsWith("lea")) {
                    sendToAllUsers(userList.get(userID).getUsername() + " has left the room");
                    userList.remove(userID);
                    break;
                }
            }
            
        } catch (IOException ex) {
            Logger.getLogger(ServerLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void sendToAllUsers(String string) {
        for (User user : userList.values()) {
            user.getPrintWriter().println(string);
        }
    }
    
    private String getUnusedUsername() {
        userNumber++;
        return "guest"+userNumber;
    }
    
    private void addUser(String userID, Socket clientSocket, PrintWriter out, BufferedReader in) {
        String newUsername = getUnusedUsername();
        User user = new User(newUsername,clientSocket, out, in);
        userList.put(userID, user);
    }
    
    private void recieveMessage(String userID, String message) {
        this.chatLog.add(userList.get(userID).getUsername() + ": " + message);
    }
    
    private void recieveNameChange(String userID, String newName) {
        userList.get(userID).setUsername(newName);
    }
    
    private void printChatLog() {
        for (int i=0; i<chatLog.size(); i++) {
            System.out.println(chatLog.get(i));
        }
    }       
    
    @Override
    public void run() {
        listenForConnection();
    }
    
    public static void main(String[] args) throws InterruptedException, InvocationTargetException {
        try {
            ServerLogic server = new ServerLogic(4444);//Change Port number here
            SwingUtilities.invokeAndWait(server);
        } catch (IOException ex) {
            Logger.getLogger(ServerLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
