package com.siu.project;

/**
 * Created with IntelliJ IDEA.
 * User: Chedly
 * Date: 25/04/12
 * Time: 12:24
 * To change this template use File | Settings | File Templates.
 */
public class WeaponBoost extends Item {
    public WeaponBoost(String name) {
        super(name);
    }

    @Override
    public boolean use(Player player) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
