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
public class CharacterFactory {
    public Character makeChar(String newCharType){
        Character newChar = null;
        if(newCharType.equals("Warrior")){
            return new WarriorChar();
        }else
        if(newCharType.equals("Ranger")){
            return new RangerChar();
        }else
        if(newCharType.equals("Mage")){
            return new MageChar();
        }else return null; 
    }
}
