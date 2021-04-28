package com.weishuai.tank;

import java.awt.*;

public class Bullet extends GameObject {

    private static final int SPEED = 10;

    public static int WIDTH = ResourceMgr.bulletD.getWidth(), HEIGHT = ResourceMgr.bulletD.getHeight();

    public Rectangle rect = new Rectangle();

    private Dir dir;

    private boolean living = true;

    private Group group = Group.BAD;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Bullet(int x, int y, Dir dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
        GameModel.getInstance().add(this);
    }

    @Override
    public void paint(Graphics g) {
        if (!living) {
            GameModel.getInstance().remove(this);
        }
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            case DOWM:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
        }
        move();

    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

    private void move() {
        // 根据方向移动
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWM:
                y += SPEED;
                break;
            default:
                break;
        }

        rect.x = this.x;
        rect.y = this.y;

        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            living = false;
        }
    }



    public void die() {
        this.living = false;
    }
}
