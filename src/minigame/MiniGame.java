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
        
        Random rand = new Random();
        int randomNum = rand.nextInt((2 - 1) + 1) + 1;
        //Scanner input = new Scanner(System.in);
        //System.out.print("Which Enemy (S / SK)");
        if(/*input.hasNextLine()*/ randomNum != 0){
            //String typeOfEnemy = input.nextLine();
            int typeOfEnemy = randomNum; 
            enemy = enemyFactory.makeEnemy(typeOfEnemy);
            if(enemy != null){
                doStuffEnemy(enemy);
            }else System.out.print("Please enter S or SK next time");
        }
    }
    public static void doStuffEnemy(Enemy anEnemy){
        anEnemy.displayEnemy();
        anEnemy.followHero();
        anEnemy.enemyAttacks();
    }
    
}
