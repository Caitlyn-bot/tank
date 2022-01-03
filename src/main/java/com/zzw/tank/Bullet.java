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
    public static final int WIDTH = ResourceMgr.bulletD.getWidth();
    /**
     * 子弹的高度
     */
    public static final int HEIGHT = ResourceMgr.bulletD.getHeight();
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

    /**
     * 子弹的类型
     */
    private Group group = Group.BAD;

    public Bullet(int x, int y, Dir dir,Group group, TankFrame tf){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
    }

    public void paint(Graphics g){
        if(!living) {
            tf.bullets.remove(this);
        }
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD,x,y,null);
                break;
            default:
                g.drawImage(ResourceMgr.bulletD,x,y,null);
                break;
        }
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

    public void collideWith(Tank tank) {
        if (this.group == tank.getGroup()){
            return;
        }
        //TODO:用一个rect来记录子弹的位置
        Rectangle rect1 = new Rectangle(this.x,this.y,WIDTH,HEIGHT);
        Rectangle rect2 = new Rectangle(tank.getX(),tank.getY(),Tank.WIDTH,Tank.HEIGHT);
        if (rect1.intersects(rect2)){
            tank.die();
            this.die();
        }
    }

    private void die() {
        living = false;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
