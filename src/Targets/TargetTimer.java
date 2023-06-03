/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Targets;


import java.time.LocalTime;
import java.util.Date;
import org.json.simple.JSONObject;

/**
 *
 * @author ABUKU
 */
public class TargetTimer extends Target {
    
    long durHour, durMin;
    
    public void setDurHour(long Hour){
        this.durHour = Hour;
    }
    
    public void setDurMin( long minute){
        this.durMin = minute;
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
    
    public long getDurationHour(){
        return this.durHour;
    }
    
    public long getDurationMin(){
        return this.durMin;
    }
    
    public TargetTimer(){
        
    }
    
    public TargetTimer(String name, Date date, String category, long hour, long minute){
        this.targetName = name;
        this.date = date;
        this.category = category;
        this.durHour = hour;
        this.durMin = minute;
        this.status=-1;
    }
    
     public JSONObject toJsonObject(){
        JSONObject jobject = new JSONObject();
        jobject.put("name", targetName);
        jobject.put("date", date);
        jobject.put("category", category);
        jobject.put("durHour", durHour);
        jobject.put("durMin", durMin);
        jobject.put("status", status);
        
        JSONObject targetShared = new JSONObject();
        targetShared.put("targetTimer", jobject);
        return targetShared;
    }
}
