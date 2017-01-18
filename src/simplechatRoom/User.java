package simplechatRoom;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class User {
    
    private String username;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public User(String username, Socket socket) {
        this.username = username;
        this.socket = socket;
    }
    
    public User(String username, Socket socket, PrintWriter out, BufferedReader in) {
        this.username = username;
        this.socket = socket;
        this.out = out;
        this.in = in;
    }

    public BufferedReader getBufferedReader() {
        return in;
    }
    public void setBufferedReader(BufferedReader in) {
        this.in = in;
    }
    public void setPrintWriter(PrintWriter out) {
        this.out = out;
    }
    
    public PrintWriter getPrintWriter() {
        return out;
    }

    public String getUsername() {
        return username;
    } 
    
    public Socket getSocket() {
        return socket;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    
}
