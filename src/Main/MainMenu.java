/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Targets.TargetBoolean;
import Targets.TargetTimer;
import User.User;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
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
    
   Map <String, User> userMap = new HashMap<>();

    
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
        reeedSave();
        return session.getBool();
    }
    
    public LinkedList getTimer(){
        read();
        reeedSave();
        return session.getTimer();
    }
    
    public void reeedSave(){
        session.readSave();
    }
    
    private void read(){
        JSONParser jparser = new JSONParser();
        
        try(FileReader fReader = new FileReader("session.json")){
            
            Object object = jparser.parse(fReader);
            JSONObject jobj = (JSONObject)object;
            System.out.println(jobj);
            
            parseSession(jobj);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void readUsers(){
        JSONParser jparser = new JSONParser();
        
        try(FileReader fReader = new FileReader("user.json")){
            
            Object object = jparser.parse(fReader);
            JSONArray uList = (JSONArray) object;
            
            uList.forEach(use -> parseuList((JSONObject)use));
            
            
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
        String uid = (String) uListObj.get("UID");

        
        User newUser = new User(username, password,nick,uid);
        userMap.put(uid, newUser);
    }
    
    private void parseSession(JSONObject uList){
        JSONObject uListObj = (JSONObject) uList.get("user");
        String username = (String) uListObj.get("Username");
        String password = (String) uListObj.get("Password");
        String nick = (String) uListObj.get("Nick");

        
        User sessionUser = new User(username, password,nick);
        session = sessionUser;
    }
    
    public Map getUsersMap(){
        return userMap;
    }
    
    public void saveSelectedBoolean(TargetBoolean save){
        
        String filename = "selectedbool.json";
        JSONObject selected = save.toJsonObject();
       
        
        
        try(FileWriter file = new FileWriter(filename)){
            file.write(selected.toJSONString());
        }catch(IOException e ){
        }
        
    }
    
    public TargetBoolean readSelectedBool(){
        JSONParser jparser = new JSONParser();
        TargetBoolean selected = new TargetBoolean();
        try(FileReader fReader = new FileReader("selectedbool.json")){
            
            Object object = jparser.parse(fReader);
            selected = parseBoolean((JSONObject)object);
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return selected;
    }
    
    private TargetBoolean parseBoolean(JSONObject uList){
        JSONObject uListObj = (JSONObject) uList.get("targetBool");
        String date = (String) uListObj.get("date");
        String name = (String) uListObj.get("name");
        String kategory = (String) uListObj.get("category");
        Long status = (Long) uListObj.get("status");
        String id = (String) uListObj.get("UID");
        Integer stats = status.intValue();
        TargetBoolean selectedBoolean = new TargetBoolean(name, date,kategory,stats, id);
        return selectedBoolean;
    }
    
    public void saveSelectedTimer(TargetTimer save){
        
        String filename = "selectedtimer.json";
        JSONObject selected = save.toJsonObject();
       
        try(FileWriter file = new FileWriter(filename)){
            file.write(selected.toJSONString());
        }catch(IOException e ){
        }
        
    }
    
    public TargetTimer readSelectedTimer(){
        JSONParser jparser = new JSONParser();
        TargetTimer selected = new TargetTimer();
        try(FileReader fReader = new FileReader("selectedtimer.json")){
            
            Object object = jparser.parse(fReader);
            selected = parseTimer((JSONObject)object);
            System.out.println(selected);
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return selected;
    }
    
    private TargetTimer parseTimer(JSONObject uList){
        JSONObject uListObj = (JSONObject) uList.get("targetTimer");
        String date = (String) uListObj.get("date");
        String name = (String) uListObj.get("name");
        String kategory = (String) uListObj.get("category");
        Long hour = (Long) uListObj.get("durHour");
        Long minute = (Long) uListObj.get("durMin");
        Long status = (Long) uListObj.get("status");
        String id = (String) uListObj.get("UID");
        Integer stats = status.intValue();
        Integer jam = hour.intValue();
        Integer menit = minute.intValue();
        
        TargetTimer selectedTimer = new TargetTimer(name, date,kategory, jam, menit, stats, id);
        return selectedTimer;
    }
}
