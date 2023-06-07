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
public class TargetBoolean extends Target {

    public void setName(String newName){
        this.targetName = newName;
    }
    
    public void setDate(String newDate){
        this.date = newDate;
    }
    
    public void setCategory(String newCategory){
        this.category = newCategory;
    }
    
    public void setStatus(int newStatus){
        this.status = newStatus;
    }
    
    public TargetBoolean(){
        
    }
    
    public TargetBoolean(String name, String date, String category){
        this.targetName = name;
        this.date = date;
        this.category = category;
        this.status=-1;
        this.UID = generatorUID();
    }
    
    public TargetBoolean(String name, String date, String category, int status, String UID){
        this.targetName = name;
        this.date = date;
        this.category = category;
        this.status= status;
        this.UID = UID;
    }
    
    public JSONObject toJsonObject(){
        JSONObject jobject = new JSONObject();
        jobject.put("name", targetName);
        jobject.put("date", date);
        jobject.put("category", category);
        jobject.put("status", status);
        jobject.put("UID", UID);
        
        JSONObject targetShared = new JSONObject();
        targetShared.put("targetBool", jobject);
        return targetShared;
    }
}
