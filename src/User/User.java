package User;
import Targets.*;
import java.util.ArrayList;
import org.json.simple.JSONObject;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ABUKU
 */
public class User {
    
    private String Username, Password, Nick;
    
    public User(String name, String pass, String nick){
        this.Username = name;
        this.Password = pass;
        this.Nick = nick;
    }
    
    public User(){
        
    }
   

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public String getNick() {
        return Nick;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setNick(String Nick) {
        this.Nick = Nick;
    }
    
    public void changeNick(String newNick){
        this.Nick = newNick;
    }
    
    public void addTargetBoolean(){
        
    }
    
    public void addTargetShared(){
        
    }
    
    public void addTargetTimer(){
        
    }
    
    public void deleteTarget(){
        
    }
    
    public JSONObject toJsonObject(){
        JSONObject jobject = new JSONObject();
        jobject.put("Username", Username);
        jobject.put("Password", Password);
        jobject.put("Nick", Nick);
        
        JSONObject User = new JSONObject();
        User.put("user", jobject);
        return User;
    }
    
    
}
