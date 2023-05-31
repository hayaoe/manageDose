/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Targets;

import Time.Date;

/**
 *
 * @author ABUKU
 */
abstract class Target {
    
    String targetName;
    Date date;
    String category;
    int status;
    
    public String getTargetName(){
        return this.targetName;
    }
    
    public String getCategory(){
        return this.category;
    }
    
    public Date getDate(){
        return this.date;
    }
    
    public int getStatus(){
        return this.status;
    }
        
}
