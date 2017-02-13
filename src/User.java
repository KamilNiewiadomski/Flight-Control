/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kamil
 */
class User {
    private short id, securityLevel;
    private String name, lastname, status;
    User(){
        this.setId((short)Engine.inputDouble(" "));
        this.setSecurityLevel((short)Engine.inputDouble(" "));
        this.setName(Engine.inputString(" "));
        this.setLastname(Engine.inputString(" "));
    }
    User(short id, short securityLevel, String name, String lastname){
        this.setId(id);
        this.setSecurityLevel(securityLevel);
        this.setName(name);
        this.setLastname(lastname);
    }
    void setId(short id){
        this.id = id;
    }
    void setSecurityLevel(short securityLevel){
        this.securityLevel = securityLevel;
    }
    void setName(String name){
        this.name = name;
    }
    void setLastname(String lastname){
        this.lastname = lastname;
    }
    void setStatus(String status){
        this.status = status;
    }
    short getId(){
        return this.id;
    }
    short getSecurityLevel(){
        return this.securityLevel;
    }
    String getName(){
        return this.name;
    }
    String getLastname(){
        return this.lastname;
    }
    String getStatus(){
        return this.status;
    }
}