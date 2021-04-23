package com.weishuai.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {

    // 初始化坦克位置
    Tank myTank = new Tank(200, 400, Dir.DOWM, this);
    List<Bullet> bullets = new ArrayList<>();
    List<Tank> tanks = new ArrayList<>();
    static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;

    /**
     * 窗口类 setSize setResizable setTitle  setVisible
     */
    public TankFrame() {
        setSize(GAME_WIDTH,GAME_HEIGHT);
        setResizable(false);
        setTitle("tank war");
        setVisible(true);

        // 增加键的监听事件
        this.addKeyListener(new MyKeyListener());
        // 关闭程序
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    // 用双缓冲解决闪烁问题
    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0,GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    /**
     * 窗口需要重新绘制的时候
     * @param g 画笔
     */
    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量" + bullets.size(), 10,60);
        g.drawString("敌人的数量" + tanks.size(), 10,80);
        g.setColor(c);
        // 画坦克
        myTank.paint(g);
        for (int i = 0; i < bullets.size(); i++) {
            // 画子弹
            bullets.get(i).paint(g);
        }
        for (int i = 0; i < tanks.size(); i++) {
            // 画子弹
            tanks.get(i).paint(g);
        }

        for (int i = 0; i < bullets.size() ; i++) {
            for (int j = 0; j < tanks.size() ; j++) {
                bullets.get(i).collideWidth(tanks.get(j));
            }
        }

    }

    class MyKeyListener extends KeyAdapter {
        // 四个方向状态
        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;

            }

            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
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
            setMainTankDir();
        }

        private void setMainTankDir() {


            if (!bL && !bU && !bR && !bD) {
                myTank.setMoving(false);
            } else {
                myTank.setMoving(true);
                if(bL) myTank.setDir(Dir.LEFT);
                if(bU) myTank.setDir(Dir.UP);
                if(bR) myTank.setDir(Dir.RIGHT);
                if(bD) myTank.setDir(Dir.DOWM);
            }
        }
    }

}
