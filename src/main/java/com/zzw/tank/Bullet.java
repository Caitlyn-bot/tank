package com.zzw.tank;

import java.awt.*;

/**
 * 子弹类
 * @author 张志伟
 * @version v1.0
 */
public class Bullet {
    /**
     * 定义子弹的速度
     */
    private static final int SPEED = 6;
    /**
     * 子弹的宽度
     */
    private static final int WIDTH = 10;
    /**
     * 子弹的高度
     */
    private static final int HEIGHT = 10;
    /**
     * x代表子弹所处的横坐标
     */
    private int x;
    /**
     * y代表子弹所处的纵坐标
     */
    private int y;
    /**
     * 子弹的方向
     */
    private Dir dir;

    private boolean living = true;

    TankFrame tf = null;

    public Bullet(int x, int y, Dir dir, TankFrame tf){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g){
        if(!living) {
            tf.bullets.remove(this);
        }
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x,y,WIDTH,HEIGHT);
        g.setColor(c);
        /**
         * 移动子弹
         */
        move();
    }
    private void move(){
        switch (dir) {
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
        if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            living = false;
        }

    }

}
