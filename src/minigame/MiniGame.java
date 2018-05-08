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
                enemy = createEnemy(enemy, enemyFactory); 
            }else System.out.print("Please Enter a class next time"); 
        }
        fightSetUpStart(character, enemy); 
        
        //Enemy creation
        
    }
    
    public static Enemy createEnemy(Enemy enemy, EnemyFactory enemyFactory){
        Random rand = new Random();
        int randomNum = rand.nextInt((3 - 1) + 1) + 1;
        
        if(randomNum != 0){
            //String typeOfEnemy = input.nextLine();
            int typeOfEnemy = randomNum; 
            enemy = enemyFactory.makeEnemy(typeOfEnemy);
            if(enemy != null){
                doStuffEnemy(enemy);
                return enemy;
            }
        }
        return null; 
    }
    public static void doStuffEnemy(Enemy anEnemy){
        anEnemy.displayEnemy();
        anEnemy.followHero();
        anEnemy.enemyHealth();
    }
    
    public static double enemyAttacks(Enemy anEnemy){
        anEnemy.enemyAttacks();
        double attackDamage = anEnemy.getDamage(); 
        return attackDamage;
    }
    
    public static double enemyHealth(Enemy anEnemy){
        double health = anEnemy.getHealth();
        return health; 
    }
    
     public static double recieveHealth(Character character){
        character.characterHealth();
        double charHealth = character.getHealth(); 
        return charHealth; 
    }
    
    public static void fightSetUpStart(Character character, Enemy enemy){
        double characterHealth = recieveHealth(character);
        double enemyHealth = enemyHealth(enemy);
        fight(characterHealth, enemyHealth, character, enemy); 
    } 
    public static void fightSetUpNext(Character character, double characterHealth, Enemy enemy){
        System.out.print("Your health is " + characterHealth + "\n");
        double cHealth = characterHealth;
        double enemyHealth = enemyHealth(enemy);
        fight(characterHealth, enemyHealth, character, enemy); 
    }
    public static double characterAttacks(Character character){
        Scanner input = new Scanner(System.in);
        System.out.print("Choose Attack (1 / 2) \n");
        int attackType = input.nextInt();
        switch(attackType){
            case 1: 
                character.primaryAttack();
                double damage = character.getPrimaryDamage();
                return damage;
            case 2:
               character.secondaryAttack();
               double damage2 = character.getSecondaryDamage();
               return damage2;
        }
        return 0.0;  
    }
    
    public static int healthCheck(double cHealth, double eHealth){
        if(cHealth <= 0.0){
           System.out.print("You are dead \n");
           System.out.print("Thank you for playing");
           System.exit(0);
        }else{
            System.out.print("Your health is now " + cHealth + "\n");
            if(eHealth <= 0.0){
                System.out.print("You Have killed the enemy \n");
                return 1;
            }else{
                System.out.print(eHealth + " You must keep fighting   \n");
                return 0;
            }
        }
        return 0;
    }
    
    public static void fightAgain(Character character, double cHealth){
        EnemyFactory enemyFactory = new EnemyFactory();
        Enemy enemy = null; 
        Scanner input = new Scanner(System.in);
        System.out.print("Do you want to fight again? (Y / N) \n");
        String choice = input.nextLine();
        if(choice.equals("Y")){
            enemy = createEnemy(enemy, enemyFactory);
            fightSetUpNext(character, cHealth, enemy);
        }
        if(choice.equals("N")){
            System.out.print("Thank you for playing");
            System.exit(0); 
        }else System.out.print("Please eneter a valid choice next time");
    }
    
    public static void fight(double characterHealth, double enemyHealth, Character character, Enemy enemy){
        double eHealth = enemyHealth;
        double cHealth = characterHealth;
        int x = 0;
        while(x == 0){
            double enemyDamage = enemyAttacks(enemy); 
            double charDamage = characterAttacks(character);
            cHealth = cHealth - enemyDamage;  
            eHealth = eHealth - charDamage; 
            x = healthCheck(cHealth, eHealth); 
        }
        fightAgain(character, cHealth); 
    }
}
