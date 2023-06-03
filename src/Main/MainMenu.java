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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author rabirabichannel
 */
public class MainMenu {
    
    User session = new User();
    
    
    public void startSession(String username, String password){
        
        session = new User(username, password, username);
        save();
    }
    
    public void saveBoolTarget(String name, String category, String date){
        
        read();
        session.addTargetBoolean(name, category, date);
        save();
    }
    
    public void saveTimerTarget(String name, String category, String date, long hour, long min){
        
        read();
        session.addTargetTimer(name, category, date, hour, min);
        save();
    }
    
    private void save(){
        JSONObject obj;
        
        obj = session.toJsonObject();
        
        try(FileWriter file = new FileWriter("session.json")){
            file.write(obj.toJSONString());
        }catch(IOException e ){
        }
        
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
