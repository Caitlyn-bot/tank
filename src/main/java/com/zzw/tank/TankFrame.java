package com.zzw.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 张志伟
 * @version v1.0
 */
public class TankFrame extends Frame {
    /**
     * 定义主战坦克
     */
    Tank myTank = new Tank(200,400,Dir.DOWN,Group.GOOD,this);
    /**
     * 定义子弹
     */
    List<Bullet> bullets = new ArrayList<>();
    /**
     * 定义敌方坦克
     */
    List<Tank> enemies = new ArrayList<>();
    /**
     * 定义爆炸
     */
    List<Explode> explodes = new ArrayList<>();
    /**
     * 游戏画面的宽度
     */
    static final int GAME_WIDTH = 800;
    /**
     * 游戏画面的高度
     */
    static final int GAME_HEIGHT = 600;

    public TankFrame(){
        //设置窗口初始大小
        this.setSize(GAME_WIDTH,GAME_HEIGHT);
        //窗口是否可以修改大小
        this.setResizable(true);
        //设置标题
        this.setTitle("tank war");
        //窗口设为可见
        this.setVisible(true);
        //添加监听事件，监听windowClosing事件
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        //添加键盘的监听事件
        this.addKeyListener(new MyKeyListener());
    }

    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    /**
     * 当窗口被改变时被自动调用
     * @param g 画笔
     */
    @Override
    public void paint(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量：" + bullets.size(),10,60);
        g.drawString("敌人的数量：" + enemies.size(),10,80);
        g.drawString("爆炸的数量：" + explodes.size(), 10, 100);
        g.setColor(c);
        //绘制坦克
        myTank.paint(g);
        //绘制子弹
        for (int i = 0; i < bullets.size();i++) {
            bullets.get(i).paint(g);
        }
        //绘制敌方坦克
        for (int i = 0; i < enemies.size();i++) {
            enemies.get(i).paint(g);
        }

        for (int i = 0; i < explodes.size(); i++) {
            explodes.get(i).paint(g);
        }

        for (int i = 0; i < bullets.size();i++) {
            for (int j = 0; j < enemies.size();j++) {
                bullets.get(i).collideWith(enemies.get(j));
            }
        }

    }

    /**
     * 处理键盘事件监听
     */
    class MyKeyListener extends KeyAdapter{
        /**
         * 通过四个布尔值确定坦克的上下左右方向，而不是直接移动坦克，实现斜着走
         */
        boolean bL = false;
        boolean bR = false;
        boolean bU = false;
        boolean bD = false;

        /**
         * 一个键被按下时调用
         * @param e
         */
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }
            /**
             * 设置坦克方向
             */
            setMainTankDir();

        }


        /**
         * 一个键被重开时调用
         * @param e
         */
        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                case KeyEvent.VK_CONTROL:
                    myTank.fire();
                    break;
                default:
                    break;
            }
            /**
             * 设置坦克方向
             */
            setMainTankDir();
        }

        /**
         * 设置主战坦克的方向
         */
        private void setMainTankDir(){
            //设置坦克状态为移动
            myTank.setMoving(true);
            //设置坦克的移动方向
            if (!bL && !bU && !bR && !bD) {
                myTank.setMoving(false);
            }else {
                if (bL) {
                    myTank.setDir(Dir.LEFT);
                }
                if (bU) {
                    myTank.setDir(Dir.UP);
                }
                if (bR) {
                    myTank.setDir(Dir.RIGHT);
                }
                if (bD) {
                    myTank.setDir(Dir.DOWN);
                }
            }
        }

    }

}
