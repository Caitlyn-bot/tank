package com.zzw.tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 坦克
 * @author 张志伟
 * @version v1.0
 */
public class Tank {
    /**
     * 坦克的宽度
     */
    public static final int WIDTH = ResourceMgr.tankD.getWidth();
    /**
     * 坦克的高度
     */
    public static final int HEIGHT = ResourceMgr.tankD.getHeight();
    /**
     * 用于生成随机数
     */
    private Random random = new Random();
    /**
     * 区分坦克的类型
     */
    private Group group = Group.BAD;
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
     * moving代表坦克是否正在移动
     */
    private boolean moving = false;
    /**
     * living代表坦克是否存活
     */
    private boolean living = true;
    /**
     * SPEED代表坦克的移动速度
     */
    private static final int SPEED = 10;

    private TankFrame tf;


    public Tank(int x, int y, Dir dir, Group group, TankFrame tf){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
    }

    public void paint(Graphics g){
        if (!living){
            tf.enemies.remove(this);
            return;
        }
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.tankL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD,x,y,null);
                break;
            default:
                g.drawImage(ResourceMgr.tankD,x,y,null);
                break;
        }
        /**
         * 移动坦克
         */
        move();
    }

    private void move(){
        if (!moving){
            return;
        }
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
        if (random.nextInt(10) > 8){
            this.fire();
        }
    }

    /**
     * 发射子弹
     */
    public void fire(){
        int bX = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        Bullet bullet = new Bullet(bX,bY,this.dir,this.group,tf);
        tf.bullets.add(bullet);
    }

    public void die() {
        this.living = false;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }


}
