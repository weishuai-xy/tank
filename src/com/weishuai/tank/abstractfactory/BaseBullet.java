package com.weishuai.tank.abstractfactory;

import com.weishuai.tank.Tank;

import java.awt.*;

public abstract class BaseBullet {
    public abstract void paint(Graphics g);
    public abstract void collideWidth(Tank tf);
}
