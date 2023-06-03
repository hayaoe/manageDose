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
    
    public TargetShared(){
        
    }
    
    public TargetShared(String name, String date, String category){
        this.targetName = name;
        this.date = date;
        this.category = category;
        this.UID = UID;
        this.status=-1;
    }
    
    public JSONObject toJsonObject(){
        JSONObject jobject = new JSONObject();
        jobject.put("name", targetName);
        jobject.put("date", date);
        jobject.put("category", category);
        jobject.put("status", status);
        jobject.put("UID", UID);
        
        JSONObject targetShared = new JSONObject();
        targetShared.put("targetShared", jobject);
        return targetShared;
    }
}
