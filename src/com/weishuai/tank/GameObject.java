package com.weishuai.tank;

import java.awt.*;

public abstract class GameObject {
    // 位置
    public int x, y;

    public abstract void paint(Graphics g);

    public abstract int getWidth();
    public abstract int getHeight();
}
