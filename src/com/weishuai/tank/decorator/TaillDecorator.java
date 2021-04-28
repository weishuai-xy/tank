package com.weishuai.tank.decorator;

import com.weishuai.tank.GameObject;

import java.awt.*;

public class TaillDecorator extends GODecorator{

    public TaillDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        this.x = go.x;
        this.y = go.y;
        System.out.println(x);
        System.out.println(y);
        go.paint(g);
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.drawLine(go.x, go.y, go.x + getWidth(), go.y + getHeight());
        g.setColor(c);
    }

    @Override
    public int getWidth() {
        return super.go.getWidth();
    }

    @Override
    public int getHeight() {
        return super.go.getHeight();
    }
}
