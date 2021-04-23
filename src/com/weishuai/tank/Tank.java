package com.weishuai.tank;

import java.awt.*;

public class Tank {
    private int x, y;
    private Dir dir = Dir.DOWM;
    private static final int speed = 10;

    public Tank(int x, int y, Dir dir) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
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

    public static int getSpeed() {
        return speed;
    }

    public void paint(Graphics g) {
        g.fillRect(x,y ,50,50);
        // 根据方向移动
        switch (dir) {
            case LEFT:
                x -= speed;
            case UP:
                y -= speed;
            case RIGHT:
                x += speed;
            case DOWM:
                y += speed;
        }
    }
}
