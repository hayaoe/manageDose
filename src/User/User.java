package User;
import Targets.*;
import java.util.ArrayList;
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
    private TargetBoolean targetBoolean;
    private TargetShared targetShared;
    private TargetTimer targetTimer;
    private User friends;

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
    
    public void addFriend(User user){
        friends = user;
    }
    
    
}
