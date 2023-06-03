package User;

import Main.Main;
import Targets.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ABUKU
 */
public class User {

    private String Username, Password, Nick, UID;
    private LinkedList<TargetBoolean> listBool;
    private LinkedList<TargetTimer> listTimer;
    private LinkedList<TargetShared> listShared;

    public User(String name, String pass, String nick) {
        this.listBool = new LinkedList<>();
        this.listTimer = new LinkedList<>();
        this.listShared = new LinkedList<>();
        this.Username = name;
        this.Password = pass;
        this.Nick = nick;
        
    }

    public User() {
        this.listBool = new LinkedList<>();

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

    public void changeNick(String newNick) {
        this.Nick = newNick;
    }

    public void addTargetBoolean(String targetName, String category, String dueDate) {
        TargetBoolean newTBool;
        newTBool = new TargetBoolean(targetName,dueDate,category);
        listBool.add(newTBool);
        
        saveBoolean();
        String path = this.Username+"BoolTarget.json";
        read(path);
    }

    public void addTargetShared(TargetShared target) {

        listShared.add(target);
        
        saveShared();
        String path = this.Username+"SharedTarget.json";
        read(path);
    }

    public void addTargetTimer(String targetName, String category, String dueDate, long hour, long minute) {
        TargetTimer newTimer;
        newTimer = new TargetTimer(targetName,dueDate,category, hour, minute);
        listTimer.add(newTimer);
        
        saveTimer();
        String path = this.Username+"TimerTarget.json";
        read(path);
    }

    public void deleteTarget() {

    }

    public JSONObject toJsonObject() {
        JSONObject jobject = new JSONObject();
        jobject.put("Username", Username);
        jobject.put("Password", Password);
        jobject.put("Nick", Nick);
        jobject.put("UID", UID);

        JSONObject User = new JSONObject();
        User.put("user", jobject);
        return User;
    }
    
    private void saveTimer(){
        
        String filename = this.Username+"TimerTarget.json";
        
        JSONArray jtimer = new JSONArray();

        for (int i = 0; i < listTimer.size(); i++) {
            jtimer.add(listTimer.get(i).toJsonObject());
        }
        
        try(FileWriter file = new FileWriter(filename)){
            file.write(jtimer.toJSONString());
        }catch(IOException e ){
        }
        
    }
    
    private void saveBoolean(){
        
        String filename = this.Username+"BoolTarget.json";
        JSONArray jbool = new JSONArray();
        
        for (int i = 0; i < listBool.size(); i++) {
            jbool.add(listBool.get(i).toJsonObject());
        }
        
        try(FileWriter file = new FileWriter(filename)){
            file.write(jbool.toJSONString());
        }catch(IOException e ){
        }
        
    }
    
    private void saveShared(){
        
        String filename = this.Username+"SharedTarget.json";

        JSONArray jshare = new JSONArray();


        for (int i = 0; i < listShared.size(); i++) {
            jshare.add(listShared.get(i).toJsonObject());
        }
        
        try(FileWriter file = new FileWriter(filename)){
            file.write(jshare.toJSONString());
        }catch(IOException e ){
        }
        
    }
    
    private void read(String path){
        JSONParser jparser = new JSONParser();
        
        try(FileReader fReader = new FileReader(path)){
            
            Object object = jparser.parse(fReader);
            JSONArray uList = (JSONArray) object;
            System.out.println(uList);
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
