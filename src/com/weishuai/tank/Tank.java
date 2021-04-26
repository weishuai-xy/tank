package com.weishuai.tank;

import com.weishuai.tank.abstractfactory.BaseTank;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class Tank extends BaseTank {
    int x, y;
    private Dir dir = Dir.DOWM;
    private static final int SPEED = 5;

    private boolean moving = true;

    public static int WIDTH = ResourceMgr.goodTankU.getWidth(), HEIGHT = ResourceMgr.goodTankU.getHeight();

    public Rectangle rect = new Rectangle();

    private Random random = new Random();
    // 持有对象的引用
    public TankFrame tf = null;

    private boolean living = true;

    Group group = Group.BAD;

    FireStrategy fs = new FourDirFireStrategy();

    public Tank(int x, int y, Dir dir,Group group, TankFrame tf) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
        if (group == Group.GOOD) {
            String goodFsName = (String) PropertyMgr.get("goodFs");
            try {
                fs = (FireStrategy) Class.forName(goodFsName).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        else {
            String badFsName = (String) PropertyMgr.get("badFs");
            try {
                fs = (FireStrategy) Class.forName(badFsName).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
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
        return SPEED;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public void paint(Graphics g) {
        if (!living) tf.tanks.remove(this);
        switch (dir) {
            case LEFT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankL : ResourceMgr.badTankL, x, y, null);
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankU : ResourceMgr.badTankU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankR : ResourceMgr.badTankR, x, y, null);
                break;
            case DOWM:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankD : ResourceMgr.badTankD, x, y, null);
                break;
        }
        move();

    }

    private void move() {
        if (!moving) return;
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

        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            this.fire();
        }
        if (this.group == Group.BAD && random.nextInt(100) > 95)
            randomDir();
        // 边界检测
        boundsCheck();

        rect.x = this.x;
        rect.y = this.y;
    }

    /**
     * 边界检测
     */
    private void boundsCheck() {
        if (this.x < 0) x = 0;
        else if (this.y < 30) y = 30;
        else if (this.x > TankFrame.GAME_WIDTH - Tank.WIDTH) x = TankFrame.GAME_WIDTH - Tank.WIDTH;
        else if (this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT) y = TankFrame.GAME_HEIGHT - Tank.HEIGHT;
    }

    private void randomDir() {

        this.dir = Dir.values()[random.nextInt(4)];
    }

    public void fire() {
        fs.fire(this);
    }

    public void die() {
        this.living = false;
    }
}
