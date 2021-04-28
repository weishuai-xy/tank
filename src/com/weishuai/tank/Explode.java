package com.weishuai.tank;

import java.awt.*;

public class Explode extends GameObject {

    public static int WIDTH = ResourceMgr.explodes[0].getWidth(), HEIGHT = ResourceMgr.explodes[0].getHeight();


    private boolean living = true;

    private int step = 0;


    public Explode(int x, int y) {
        this.x = x;
        this.y = y;
        GameModel.getInstance().add(this);
        // 爆炸生音
        new Thread(() -> new Audio("audio/explode.wav").play()).start();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes[step++], x, y, null);
        if (step >= ResourceMgr.explodes.length)
            GameModel.getInstance().remove(this);
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

}
