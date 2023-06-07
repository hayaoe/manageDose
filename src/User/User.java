package User;

import Main.Main;
import Targets.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.UUID;
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

    
    private LinkedList<Target> listTarget;
    public User(String name, String pass, String nick) {
       
        this.listBool = new LinkedList<>();
        this.listTimer = new LinkedList<>();
        this.listShared = new LinkedList<>();
        
        this.Username = name;
        this.Password = pass;
        this.Nick = nick;
        this.UID = generatorUID();
        
    }
    
    public User(String name, String pass, String nick, String UID) {
        
        this.Username = name;
        this.Password = pass;
        this.Nick = nick;
        this.UID = UID;
        
    }
    
    private String generatorUID(){
        UUID randomId = UUID.randomUUID();

        // Mengonversi UUID menjadi string
        String idString = randomId.toString();
        return idString;
    }
    
    public void readSave(){
        
        String path = this.Username+"BoolTarget.json";
        readBool(path);
        path = this.Username+"TimerTarget.json";
        readTimer(path);
        saveBoolean();
        saveTimer();
        System.out.println(listBool.size());
        System.out.println(listTimer.size());
    }
    
    public void SaveRead(){
        saveBoolean();
        saveTimer();
        System.out.println(listBool.size());
        System.out.println(listTimer.size());
        String path = this.Username+"BoolTarget.json";
        readBool(path);
        path = this.Username+"TimerTarget.json";
        readTimer(path);
    }

    public User() {
        

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
        String path = this.Username+"BoolTarget.json";
        readBool(path);
        TargetBoolean newTBool;
        newTBool = new TargetBoolean(targetName,dueDate,category);
        listBool.add(newTBool);

        saveBoolean();
        path = this.Username+"BoolTarget.json";
        readBool(path);
    }

    public void addTargetShared(TargetShared target) {

        listShared.add(target);
        
        saveShared();
        String path = this.Username+"SharedTarget.json";
//        read(path);
    }

    public void addTargetTimer(String targetName, String category, String dueDate, int hour, int minute) {
        String path = this.Username+"TimerTarget.json";
        readTimer(path);
        
        TargetTimer newTimer;
        newTimer = new TargetTimer(targetName,dueDate,category, hour, minute);
        listTimer.add(newTimer);
        System.out.println(listTimer.peekLast().getStatus()+" status target pertama");
        
        saveTimer();
        path = this.Username+"TimerTarget.json";
        readTimer(path);
    }

    public void deleteTarget() {

    }
    
    public LinkedList getBool(){
        return this.listBool;
    }
    
    public LinkedList getTimer(){
        return this.listTimer;
    }
    
    public LinkedList getShared(){
        return this.listShared;
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
    
    private void readBool(String path){
        JSONParser jparser = new JSONParser();
        
        try(FileReader fReader = new FileReader(path)){
            
            Object object = jparser.parse(fReader);
            JSONArray uList = (JSONArray) object;
            System.out.println(uList);
            uList.forEach(use -> parseBoolean((JSONObject)use));
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void parseBoolean(JSONObject uList){
        JSONObject uListObj = (JSONObject) uList.get("targetBool");
        String date = (String) uListObj.get("date");
        String name = (String) uListObj.get("name");
        String kategory = (String) uListObj.get("category");
        Long status = (Long) uListObj.get("status");
        String id = (String) uListObj.get("UID");
        Integer stats = status.intValue();

        
        TargetBoolean updateBoolean = new TargetBoolean(name, date,kategory,stats, id);
        listBool.add(updateBoolean);
    }
    
    private void readTimer(String path){
        JSONParser jparser = new JSONParser();
        
        try(FileReader fReader = new FileReader(path)){
            
            Object object = jparser.parse(fReader);
            JSONArray uList = (JSONArray) object;
            
            uList.forEach(use -> parseTimer((JSONObject)use));
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void parseTimer(JSONObject uList){
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
        
        TargetTimer updateTimer = new TargetTimer(name, date,kategory, jam, menit, stats, id);
        listTimer.add(updateTimer);
    }
    
    private void readShared(String path){
        JSONParser jparser = new JSONParser();
        
        try(FileReader fReader = new FileReader(path)){
            
            Object object = jparser.parse(fReader);
            JSONArray uList = (JSONArray) object;
            System.out.println(uList);
            uList.forEach(use -> parseShared((JSONObject)use));
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void parseShared(JSONObject uList){
        JSONObject uListObj = (JSONObject) uList.get("targetShared");
        String date = (String) uListObj.get("date");
        String name = (String) uListObj.get("name");
        String kategory = (String) uListObj.get("category");
        String pemilik = (String) uListObj.get("owner");
        String id = (String) uListObj.get("UID");

        
        TargetShared updateShared = new TargetShared(name, date,kategory, id, pemilik);
        listShared.add(updateShared);
    }
    

}
