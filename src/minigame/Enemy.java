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
public class Enemy {
    private String name;
    private double speed;
    private double directionX;
    private double directionY;
    private double damage;
    
    public String getName(){
        return name;
    }
    public void setName(String newName){
        name = newName; 
    }
    
    public double getDamage(){
        return damage;
    }
    public void setDamage(double newDamage){
        damage = newDamage; 
    }
    
    public void followHero(){
        System.out.println(getName() + " is following you");
    }
    public void displayEnemy(){
        System.out.println(getName() + " is on screen");
    }
    public void enemyAttacks(){
        System.out.println(getName() + " attacks and does " + getDamage()
        + " damage to your character");
    }
}
