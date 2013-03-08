package com.siu.project;

/**
 * Created by IntelliJ IDEA.
 * User: Chedly
 * Date: 04/04/12
 * Time: 09:30
 * To change this template use File | Settings | File Templates.
 */
public abstract class Item {

    protected String name ;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract boolean use(Player player);
}
