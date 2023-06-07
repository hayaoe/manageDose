/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import User.User;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author rabirabichannel
 */
public class MainMenu {
    
    User session = new User();
    
    

    
    public User getUser(){
        read();
        session.readSave();
        return session;
    }
    
    
    public void saveBoolTarget(String name, String category, String date){
        
        read();
        session.addTargetBoolean(name, category, date);
        
        
    }
    
    public void saveTimerTarget(String name, String category, String date, int hour, int min){
        
        read();
        session.addTargetTimer(name, category, date, hour, min);
        
    }
    
    public LinkedList getBool(){
        read();
        session.readSave();
        return session.getBool();
    }
    
    public LinkedList getTimer(){
        read();
        session.readSave();
        return session.getTimer();
    }
    
    public void readSave(){
        read();
        session.readSave();
    }
    
    private void read(){
        JSONParser jparser = new JSONParser();
        
        try(FileReader fReader = new FileReader("session.json")){
            
            Object object = jparser.parse(fReader);
            JSONObject jobj = (JSONObject)object;
            System.out.println(jobj);
            
            parseuList(jobj);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void parseuList(JSONObject uList){
        JSONObject uListObj = (JSONObject) uList.get("user");
        String username = (String) uListObj.get("Username");
        String password = (String) uListObj.get("Password");
        String nick = (String) uListObj.get("Nick");

        
        User sessionUser = new User(username, password,nick);
        session = sessionUser;
    }
}
