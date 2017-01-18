package simplechatRoom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientLogic implements Runnable{
    private ArrayList<String> log;
    private ArrayList<String> userList;
    
    private Socket socket;
    private PrintWriter pW;
    private BufferedReader bR;
    
    private String name;
    
    private boolean connected;
    private boolean userListChanged;
    private boolean timeOut;
    
    public ClientLogic() {
        this.log = new ArrayList<>();
        this.userList = new ArrayList<>();
        
        this.name = "undefined";
        this.userListChanged = false;
        this.connected = false;
        this.timeOut = false;
        
    }
    
    public void connectToServer(String hostName, int port) {
        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress(hostName, port), 2000);
            //System.out.println(socket.getInetAddress()+":"+socket.getPort());
            pW = new PrintWriter(socket.getOutputStream(),true);
            bR = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            connected = true;

            //Add users connected to server
            String input;
            while (true) {
                input = bR.readLine();
                if (input.equals("usersAdded")) {
                    break;
                } else {
                    userList.add(input);
                }
            }
            userListChanged = true;
            
            Thread packetListener = new Thread(this,"packetListener");
            packetListener.start();
            
        } catch (IOException ex) {
            if (ex.getClass().equals(SocketTimeoutException.class)) {
                timeOut = true;
            }
            connected = false;
            Logger.getLogger(ClientLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void listenForPacket() {
        try {
            String newInput = bR.readLine();
            
            Thread t = new Thread(this,"t");
            t.start();
            

            if (!newInput.contains(":")&&
                    newInput.split(" ")[1].equals("connected")&&
                    log.isEmpty()) {
                name = newInput.split(" ")[0];
            } else if (newInput.startsWith(name+" has changed name to ")) {
                userList.remove(name);
                name = newInput.split(" ")[5];
                userList.add(name);
                userListChanged = true;
            } else if (!newInput.contains(":")&&
                    newInput.split(" ")[1].equals("has")&&
                    newInput.split(" ")[2].equals("changed")&&
                    newInput.split(" ")[3].equals("name")&&
                    newInput.split(" ")[4].equals("to")) {
                userList.remove(newInput.split(" ")[0]);
                userList.add(newInput.split(" ")[5]);
                userListChanged = true;
            } else if (!newInput.contains(":")&&
                    newInput.split(" ")[1].equals("connected")) {
                userList.add(newInput.split(" ")[0]);
                userListChanged = true;
            }
            
            
            log.add(newInput);
            
            System.out.println(newInput);
        } catch (IOException ex) {
            Logger.getLogger(ClientLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean userListChanged() {
        return userListChanged;
    }
    
    public boolean isConnected() {
        return connected;
    }
    
    public void sendMessage(String message) {
        pW.println("msg"+message);
    }
    
    public void sendLeave() {
        pW.println("lea");
    }
    
    public void setName(String newName) {
        pW.println("nmc"+newName);
    }
    
    public void setUserListChanged(boolean b) {
        userListChanged = b;
    }
    
    public String getName() {
        return name;
    }
    
    public void setTimeout(boolean b) {
        timeOut = b;
    }
    
    public ArrayList<String> getLog() {
        return log;
    }
    
    public ArrayList<String> getUserList() {
        return userList;
    }
    
    @Override
    public void run() {
        listenForPacket();
    }
    
    public static void main(String[] args) throws InterruptedException{
        ClientLogic client = new ClientLogic();
        //client.connectToServer("192.168.1.91", 4444);
        //client.setName("Billy");
        //client.sendMessage("hi");
        //Thread.sleep(100000);
    }

    
    
}


