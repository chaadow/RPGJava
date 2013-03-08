package com.siu.project;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by IntelliJ IDEA.
 * User: Chedly
 * Date: 12/04/12
 * Time: 18:21
 * To change this template use File | Settings | File Templates.
 */
public class Potion extends Item {

    private long hp ;
    private long atq;
    private long agi;

    public Potion(String name, long hp, long atq, long agi) {
        super(name);
        this.hp = hp;
        this.atq = atq;
        this.agi = agi;
    }

    public static Potion createLifePotion() {
        return new Potion("Potion de vie", 80, 0, 0);
    }
    public static Potion createForcePotion() {
        return new Potion("Potion de force", 0, 100, 0);
    }
    public static Potion createAgilityPotion() {
        return new Potion("Potion d agilite", 0, 0, 100);
    }
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);    //To change body of overridden methods use File | Settings | File Templates.
    }

    public long getHp() {
        return hp;
    }

    public void setHp(long hp) {
        this.hp = hp;
    }

    public long getAtq() {
        return atq;
    }

    public void setAtq(long atq) {
        this.atq = atq;
    }

    public long getAgi() {
        return agi;
    }

    public void setAgi(long agi) {
        this.agi = agi;
    }

    @Override
    public boolean use(Player player) {
        player.getCharacter().setStrength(player.getCharacter().getStrength()+atq);// on peut mettre directement set strength ?
        player.getCharacter().setHp(player.getCharacter().getHp()+hp);

        player.getCharacter().setAgility(player.getCharacter().getAgility()+agi);

        return false;
    }

}
