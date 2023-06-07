package Main;


import Pane.Calendar_Panel;
import User.User;
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
public class Main {
    
    LinkedList <User> users = new LinkedList<>();
    User session = new User();
    
    
    public boolean register(String username, String password){
        
        boolean saved = false;
        
        read();
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        user.setNick(username);
        
        boolean nameCheck=findSameName(username);
        if (nameCheck==false) {
            users.add(user);
            save(); 
            saved = true;
        } else {
            users.removeAll(users);
        }
        
        return saved;
    }
    
    public int login(String username, String password){
        
        read();
        
        int match = -1;
        int index = findUser(username);
        
        if (index !=-1) {
            
            if (users.get(index).getPassword().equals(password)) {
                match = index;
                
            }
        }
        
        return match;
    }
    
    public void startSession(String username, String password){
        
        session = new User(username, password, username);
        saveSession();
        Calendar_Panel cpanel = new Calendar_Panel();
        cpanel.setVisible(true);
    }
    
    private int findUser(String username){
        int index = -1;
        
        
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username)) {
                index = i;
            }
        }
        
        return index;
    }
    
    private boolean findSameName(String username){
        boolean sameName = false;
        
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username)) {
                sameName = true;
            }
        }
        return sameName;
    }
    
    private void saveSession(){
        JSONObject obj;
        
        obj = session.toJsonObject();
        
        try(FileWriter file = new FileWriter("session.json")){
            file.write(obj.toJSONString());
        }catch(IOException e ){
        }
        
    }
        
    
    private void save(){
        JSONArray jarray = new JSONArray();
        for (int i = 0; i < users.size(); i++) {
            jarray.add(users.get(i).toJsonObject());
        }
        
        try(FileWriter file = new FileWriter("user.json")){
            file.write(jarray.toJSONString());
        }catch(IOException e ){
        }
        
    }
    
    private void read(){
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

        
        User updateUser = new User(username, password,nick);
        users.add(updateUser);
    }
}
