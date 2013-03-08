package com.siu.project;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by IntelliJ IDEA.
 * User: Chedly
 * Date: 23/04/12
 * Time: 10:35
 * To change this template use File | Settings | File Templates.
 */
public class Character {

    private String name;
    private long hp;
    private long strength;
    private long agility;

    public Character(String name, long hp, long strength, long agility) {
        this.name = name;
        this.hp = hp;
        this.strength = strength;
        this.agility = agility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getHp() {
        return hp;
    }

    public void setHp(long hp) {
        this.hp = hp;
    }

    public long getStrength() {
        return strength;
    }

    public void setStrength(long strength) {
        this.strength = strength;
    }

    public long getAgility() {
        return agility;
    }

    public void setAgility(long agility) {
        this.agility = agility;
    }
    public static Character createWarrior(){
        return new Character("Warrior",800, 10, 10);
    }

    public static Character createAssassin(){
        return new Character("Assassin",600, 10, 30);
    }

    public static Character createBerserk(){
        return new Character("Berserk",400,20,10);
    }
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
