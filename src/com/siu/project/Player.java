package com.siu.project;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by IntelliJ IDEA.
 * User: Chedly
 * Date: 23/04/12
 * Time: 10:33
 * To change this template use File | Settings | File Templates.
 */
public class Player {
    private String name;
    private Character character;
    private Weapon weapon;
    private Item item1;
    private Item item2;
    private boolean active = true;
    private long blocked= 0;

    public String getName() {
        return name;
    }


    public static Player createJoueurPredefini(){
      Weapon dague = null;
      dague = Weapon.createDague();
      Character assasin = null;
      assasin= Character.createAssassin();

        return new Player("Guillaume",assasin,dague);
    }
    public void setName(String name) {
        this.name = name;
    }

    public Player(String name, Character character, Weapon weapon) {
        this.name = name;
        this.character = character;
        this.weapon = weapon;
    }

    public Player(String name, Character character, Weapon weapon, Item item1, Item item2) {
        this.name = name;
        this.character = character;
        this.weapon = weapon;
        this.item1 = item1;
        this.item2 = item2;
    }

    public Character getCharacter() {
        return character;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Item getItem1() {
        return item1;
    }

    public Item getItem2() {
        return item2;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setItem1(Item item1) {
        this.item1 = item1;
    }

    public void setItem2(Item item2) {
        this.item2 = item2;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public long getBlocked() {
        return blocked;
    }

    public void setBlocked(long blocked) {
        this.blocked = blocked;
    }

    public void attack( Player player) {
        long x =(weapon.getDmg() * character.getStrength())/5;
        long y=(character.getAgility() / weapon.getPds())*x;
        long z=(x/player.getWeapon().getDef());
        player.getCharacter().setHp(player.getCharacter().getHp() - (x + y + z));
    }
    //x = (atq * dmg) / 5
    //y = (agi / pds) * x
    //z = x / def adverse

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
