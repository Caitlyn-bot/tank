package com.zzw.tank;

import java.awt.*;

/**
 * 坦克
 * @author 张志伟
 * @version v1.0
 */
public class Tank {
    /**
     * x代表坦克所处的横坐标
     */
    private int x;
    /**
     * y代表坦克所处的纵坐标
     */
    private int y;
    /**
     * dir代表坦克的移动方向
     */
    private Dir dir = Dir.DOWN;
    /**
     * SPEED代表坦克的移动速度
     */
    private static final int SPEED = 10;

    public Tank(int x, int y, Dir dir){
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g){
        g.fillRect(x,y,50,50);

        switch (dir){
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;

        }
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }
}
