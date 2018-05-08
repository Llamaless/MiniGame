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
    private double health; 
    
    public String getName(){
        return name;
    }
    public void setName(String newName){
        name = newName; 
    }
    
    public double getDamage(){
        /*
        The damage and enemy can do
        */
        return damage;
    }
    public void setDamage(double newDamage){
        damage = newDamage; 
    }
    
    public double getHealth(){
        return health;
    }
    public void setHealth(double newHealth){
        health = newHealth; 
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
    public void enemyHealth(){
        System.out.println("Enemy health is " + getHealth());
    }
}
