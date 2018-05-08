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
public class EnemyFactory {
    public Enemy makeEnemy(int newEnemyType){
        Enemy newEnemy = null;
       /* if(newEnemyType.equals("S")){
            return new SlimeEnemy();
        }else
        if(newEnemyType.equals("SK")){
            return new SkeletonEnemy();
        }else return null; */
       switch(newEnemyType){
           case 1:
               return new SlimeEnemy();
           case 2:
               return new SkeletonEnemy();
           default:
               return null; 
       }
    }
}
