package com.weishuai.tank;

public class DefaultFireStrategy implements FireStrategy{
    @Override
    public void fire(Tank t) {
        int bX = t.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = t.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        new Bullet(bX, bY, t.getDir(), t.group, t.tf);
        if (t.group == Group.GOOD) new Thread(() -> new Audio("audio/war1.wav"));
    }

//    private DefaultFireStrategy() {}
}
