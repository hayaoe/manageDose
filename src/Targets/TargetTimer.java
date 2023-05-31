/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Targets;

import Time.Date;
import java.time.LocalTime;
import org.json.simple.JSONObject;

/**
 *
 * @author ABUKU
 */
public class TargetTimer extends Target {
    
    LocalTime duration;
    
    public void setDuration(LocalTime newTime){
        this.duration = newTime;
    }
    
    public void setName(String newName){
        this.targetName = newName;
    }
    
    public void setDate(Date newDate){
        this.date = newDate;
    }
    
    public void setCategory(String newCategory){
        this.category = newCategory;
    }
    
    public void setStatus(int newStatus){
        this.status = newStatus;
    }
    
    public LocalTime getDuration(){
        return this.duration;
    }
    
    public TargetTimer(){
        
    }
    
    public TargetTimer(String name, Date date, String category, LocalTime duration){
        this.targetName = name;
        this.date = date;
        this.category = category;
        this.duration = duration;
        this.status=-1;
    }
    
     public JSONObject toJsonObject(){
        JSONObject jobject = new JSONObject();
        jobject.put("name", targetName);
        jobject.put("date", date);
        jobject.put("category", category);
        jobject.put("duration", duration);
        jobject.put("status", status);
        
        JSONObject targetShared = new JSONObject();
        targetShared.put("targetTimer", jobject);
        return targetShared;
    }
}
