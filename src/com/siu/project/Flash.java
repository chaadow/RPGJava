package com.siu.project;

import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: Chedly
 * Date: 24/04/12
 * Time: 23:20
 * To change this template use File | Settings | File Templates.
 */
public class Flash extends Item {



    public Flash(String name) {
        super(name);

    }
    public  static Flash createFlash(){
        return new Flash("Flash");
    }

    @Override
    public boolean use(Player player) {
        if(new Random().nextInt(2) % 2==0){
            player.setActive(false);
        }
        return true;
    }
}
