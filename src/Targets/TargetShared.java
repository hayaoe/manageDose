/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Targets;


import java.util.Date;
import org.json.simple.JSONObject;

/**
 *
 * @author ABUKU
 */
public class TargetShared extends Target{
    
    String owner;
    public TargetShared(){
        
    }
    
    public TargetShared(String name, String date, String category, String owner){
        this.targetName = name;
        this.date = date;
        this.category = category;
        this.status=-1;
        this.owner = owner;
    }
    
    public String getOwner(){
        return owner;
    }
    
    @Override
    public JSONObject toJsonObject(){
        JSONObject jobject = new JSONObject();
        jobject.put("name", targetName);
        jobject.put("date", date);
        jobject.put("category", category);
        jobject.put("status", status);
        jobject.put("owner",owner);
        
        JSONObject targetShared = new JSONObject();
        targetShared.put("targetShared", jobject);
        return targetShared;
    }
}
