package com.siu.project;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by IntelliJ IDEA.
 * User: Chedly
 * Date: 04/04/12
 * Time: 09:29
 * To change this template use File | Settings | File Templates.
 */
public class Weapon {

    private String name;
    private int dmg;
    private int def;
    private int pds;

    public Weapon(String name, int dmg, int def, int pds) {
        this.name = name;
        this.dmg = dmg;
        this.def = def;
        this.pds = pds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getPds() {
        return pds;
    }

    public void setPds(int pds) {
        this.pds = pds;
    }

    public static Weapon createEpee2Main(){
        return new Weapon("Two handed sword",30, 10, 50);
    }

    public static Weapon createEpee1main(){
        return new Weapon("One handed sword and shield",15, 20, 50);
    }

    public static Weapon createDague(){
        return new Weapon("Double dagger",10,5,5);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
