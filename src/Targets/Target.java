/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Targets;


import java.util.UUID;
import org.json.simple.JSONObject;



/**
 *
 * @author ABUKU
 */
public abstract class Target {
    
    String targetName, UID;
    String date;
    String category;
    int status;
    
    public String getTargetName(){
        return this.targetName;
    }
    
    public String getCategory(){
        return this.category;
    }
    
    public String getDate(){
        return this.date;
    }
    
    public int getStatus(){
        return this.status;
    }
    
    public String getUID(){
        return this.UID;
    }
    
    abstract JSONObject toJsonObject();
    
    protected String generatorUID(){
        UUID randomId = UUID.randomUUID();

        // Mengonversi UUID menjadi string
        String idString = randomId.toString();
        return idString;
    }
}
