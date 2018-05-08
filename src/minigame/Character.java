/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minigame;

/**
 *
 * @author Kobej
 */
public class Character {
    private double speed;
    private double directionX;
    private double directionY;
    private double health;
    private String primaryAttack;
    private String secondaryAttack;
    private double primaryDamage;
    private double secondaryDamage; 
    
    public String getPrimaryName(){
        return primaryAttack;
    }
    public void setPrimaryName(String newAttack1){
        primaryAttack = newAttack1; 
    }
    
    public double getPrimaryDamage(){
        return primaryDamage;
    }
    public void setPrimaryDamage(double newDamage1){
        primaryDamage = newDamage1; 
    }
    
    public String getSecondaryName(){
        return secondaryAttack;
    }
    public void setSecondaryName(String newAttack2){
        secondaryAttack = newAttack2; 
    }
    
    public double getSecondaryDamage(){
        return secondaryDamage;
    }
    public void setSecondaryDamage(double newDamage2){
        secondaryDamage = newDamage2; 
    }
    
    public void primaryAttack(){
        System.out.println("You used " + getPrimaryName());
    }
    public void enemyPrimaryDamage(){
        System.out.println("The enemy took" + getPrimaryDamage());
    }
    
    public void secondaryAttack(){
        System.out.println("You used " + getSecondaryName());
    }
    public void enemySecondaryDamage(){
        System.out.println("The enemy took" + getSecondaryDamage());
    }
}
