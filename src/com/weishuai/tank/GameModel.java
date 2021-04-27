package com.weishuai.tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {


    // 初始化坦克位置
    Tank myTank = new Tank(200, 400, Dir.DOWM, Group.GOOD, this);
    java.util.List<Bullet> bullets = new ArrayList<>();
    java.util.List<Tank> tanks = new ArrayList<>();
    List<Explode> explodes = new ArrayList<>();

    public GameModel () {
        int initTankCount = Integer.valueOf((String)(PropertyMgr.get("initTankCount")));
        // 默认加入五个敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            tanks.add(new Tank(50 + i * 80, 200, Dir.DOWM, Group.BAD, this));
        }

    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量" + bullets.size(), 10,60);
        g.drawString("敌人的数量" + tanks.size(), 10,80);
        g.drawString("爆炸的数量" + explodes.size(), 10,100);
        g.setColor(c);
        // 画主坦克
        myTank.paint(g);
        for (int i = 0; i < bullets.size(); i++) {
            // 画子弹
            bullets.get(i).paint(g);
        }
        for (int i = 0; i < tanks.size(); i++) {
            // 画敌人坦克
            tanks.get(i).paint(g);
        }

        // 消灭坦克  碰撞检测
        for (int i = 0; i < bullets.size() ; i++) {
            for (int j = 0; j < tanks.size() ; j++) {
                bullets.get(i).collideWidth(tanks.get(j));
            }
        }

        for (int i = 0; i < explodes.size(); i++) {
            // 画敌人坦克
            explodes.get(i).paint(g);
        }
    }

    public Tank getMainTank() {
        return myTank;
    }
}
