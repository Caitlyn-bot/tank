package com.zzw.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author 张志伟
 * @version v1.0
 */
public class TankFrame extends Frame {
    /**
     * 定义主战坦克
     */
    Tank myTank = new Tank(200,200,Dir.DOWN);
    /**
     * 定义子弹
     */
    Bullet bullet = new Bullet(220,220,Dir.DOWN);

    public TankFrame(){
        //设置窗口初始大小
        this.setSize(800,600);
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

    /**
     * 当窗口被改变时被自动调用
     * @param g 画笔
     */
    @Override
    public void paint(Graphics g){
        //绘制坦克
        myTank.paint(g);
        //绘制子弹
        bullet.paint(g);
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
