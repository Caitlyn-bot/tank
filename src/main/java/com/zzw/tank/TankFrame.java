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

    int x = 200;
    int y = 200;
    /**
     * 默认初始主战坦克的方向是向下
     */
    Dir dir = Dir.DOWN;
    /**
     * SPEED代表坦克的移动速度
     */
    private static final int SPEED = 10;

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
            if (bL) {
                dir = Dir.LEFT;
            }
            if (bU) {
                dir = Dir.UP;
            }
            if (bR) {
                dir = Dir.RIGHT;
            }
            if (bD) {
                dir = Dir.DOWN;
            }
        }

    }

}
