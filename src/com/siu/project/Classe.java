package com.siu.project;

/**
 * Created by IntelliJ IDEA.
 * User: Chedly
 * Date: 04/04/12
 * Time: 09:41
 * To change this template use File | Settings | File Templates.
 */
public class Classe {

    private Integer hp;
    private Integer atq;
    private Integer agi;

    public Classe(Integer hp, Integer atq, Integer agi) {
        this.hp = hp;
        this.atq = atq;
        this.agi = agi;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public void setAtq(Integer atq) {
        this.atq = atq;
    }

    public void setAgi(Integer agi) {
        this.agi = agi;
    }

    public Integer getHp() {
        return hp;
    }

    public Integer getAtq() {
        return atq;
    }

    public Integer getAgi() {
        return agi;
    }
}
