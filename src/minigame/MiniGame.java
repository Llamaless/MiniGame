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
import java.util.Scanner;
import java.util.Random;
public class MiniGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EnemyFactory enemyFactory = new EnemyFactory();
        Enemy enemy = null; 
        CharacterFactory charFactory = new CharacterFactory(); 
        Character character = null; 
        
        Scanner input = new Scanner(System.in);
        System.out.print("Which Character (Warrior / Ranger/ Mage) \n");
        if(input.hasNextLine()){
            String charType = input.nextLine();
            character = charFactory.makeChar(charType); 
            if(character != null){
                Random rand = new Random();
                int randomNum = rand.nextInt((2 - 1) + 1) + 1;
        
                if(randomNum != 0){
                    //String typeOfEnemy = input.nextLine();
                    int typeOfEnemy = randomNum; 
                    enemy = enemyFactory.makeEnemy(typeOfEnemy);
                    if(enemy != null){
                        doStuffEnemy(enemy);
                    }else System.out.print("Please enter S or SK next time");
                }
            }else System.out.print("Please Enter a class next time"); 
        }
        
        double health = recieveHealth(character); 
        while(health > 0){
            double enemyDamage = enemyAttacks(enemy); 
            double charDamage = characterAttacks(character);
            health = health - enemyDamage; 
            System.out.print("Your health is now " + health + "\n");
        }System.out.print("You are now Dead.");
        //Enemy creation
        
    }
    public static void doStuffEnemy(Enemy anEnemy){
        anEnemy.displayEnemy();
        anEnemy.followHero();
    }
    
    public static double enemyAttacks(Enemy anEnemy){
        anEnemy.enemyAttacks();
        double attackDamage = anEnemy.getDamage(); 
        return attackDamage;
    }
    
    public static double characterAttacks(Character character){
        Scanner input = new Scanner(System.in);
        System.out.print("Choose Attack (1 / 2) \n");
        int attackType = input.nextInt();
        switch(attackType){
            case 1: 
                character.primaryAttack();
                character.enemyPrimaryDamage();
                double damage = character.getPrimaryDamage();
                return damage;
            case 2:
               character.secondaryAttack();
               character.enemySecondaryDamage();
               double damage2 = character.getSecondaryDamage();
               return damage2;
        }
        return 0.0;  
    }
    
    public static double recieveHealth(Character character){
        double charHealth = character.getHealth(); 
        return charHealth; 
    }
    
}
