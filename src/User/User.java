package User;

import Main.Main;
import Targets.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

    private String Username, Password, Nick;
    private LinkedList<TargetBoolean> listBool;
    private LinkedList<TargetTimer> listTimer;
    private LinkedList<TargetShared> listShared;

    public User(String name, String pass, String nick) {
        this.listBool = new LinkedList<>();
        this.listTimer = new LinkedList<>();
        this.listShared = new LinkedList<>();
        String path = this.Username+"target.json";
        read(path);
        this.Username = name;
        this.Password = pass;
        this.Nick = nick;
        save();
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

    public void addTargetBoolean() {

    }

    public void addTargetShared() {

    }

    public void addTargetTimer() {

    }

    public void deleteTarget() {

    }

    public JSONObject toJsonObject() {
        JSONObject jobject = new JSONObject();
        jobject.put("Username", Username);
        jobject.put("Password", Password);
        jobject.put("Nick", Nick);

        JSONObject User = new JSONObject();
        User.put("user", jobject);
        return User;
    }
    
    private void save(){
        
        String filename = this.Username+"target.json";
        JSONArray jbool = new JSONArray();
        JSONArray jshare = new JSONArray();
        JSONArray jtimer = new JSONArray();
        
        for (int i = 0; i < listBool.size(); i++) {
            jbool.add(listBool.get(i).toJsonObject());
        }
        for (int i = 0; i < listShared.size(); i++) {
            jshare.add(listShared.get(i).toJsonObject());
        }
        for (int i = 0; i < listTimer.size(); i++) {
            jtimer.add(listTimer.get(i).toJsonObject());
        }
        
        try(FileWriter file = new FileWriter(filename)){
            file.write(jbool.toJSONString());
            file.write(jshare.toJSONString());
            file.write(jtimer.toJSONString());
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
