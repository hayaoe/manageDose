/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Targets;

import org.json.simple.JSONObject;

/**
 *
 * @author ABUKU
 */
public class TargetTimer extends Target {
    
    int durHour, durMin;
    
    public void setDurHour(int Hour){
        this.durHour = Hour;
    }
    
    public void setDurMin( int minute){
        this.durMin = minute;
    }
    
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
    
    public int getDurationHour(){
        return this.durHour;
    }
    
    public int getDurationMin(){
        return this.durMin;
    }
    
    public TargetTimer(){
        
    }
    
    public TargetTimer(String name, String date, String category, int hour, int minute){
        this.targetName = name;
        this.date = date;
        this.category = category;
        this.durHour = hour;
        this.durMin = minute;
        this.status=-1;
        this.UID = generatorUID();
    }
    
    public TargetTimer(String name, String date, String category, int hour, int minute, int status, String UID){
        this.targetName = name;
        this.date = date;
        this.category = category;
        this.durHour = hour;
        this.durMin = minute;
        this.status = status;
        this.UID =UID;
    }
    
     public JSONObject toJsonObject(){
        JSONObject jobject = new JSONObject();
        jobject.put("name", targetName);
        jobject.put("date", date);
        jobject.put("category", category);
        jobject.put("durHour", durHour);
        jobject.put("durMin", durMin);
        jobject.put("status", status);
        jobject.put("UID", UID);
        
        JSONObject targetTimer = new JSONObject();
        targetTimer.put("targetTimer", jobject);
        return targetTimer;
    }
}
