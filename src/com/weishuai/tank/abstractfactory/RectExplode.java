package com.weishuai.tank.abstractfactory;

import com.weishuai.tank.Audio;
import com.weishuai.tank.ResourceMgr;
import com.weishuai.tank.TankFrame;

import java.awt.*;

public class RectExplode extends BaseExplode{
    public static int WIDTH = ResourceMgr.explodes[0].getWidth(), HEIGHT = ResourceMgr.explodes[0].getHeight();

    private int x, y;


    private boolean living = true;

    TankFrame tf = null;

    private int step = 0;


    public RectExplode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
        // 爆炸生音
        new Thread(() -> new Audio("audio/explode.wav").play()).start();
    }

    @Override
    public void paint(Graphics g) {

        Color c = g.getColor();
        g.fillRect(x, y, 10 * step, 10 * step);
        g.setColor(Color.RED);
        step++;

//        g.drawImage(ResourceMgr.explodes[step++], x, y, null);
        if (step >= ResourceMgr.explodes.length)
            tf.explodes.remove(this);
        g.setColor(c);
    }
}
