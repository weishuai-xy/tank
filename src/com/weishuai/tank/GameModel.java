package com.weishuai.tank;

import com.weishuai.tank.cor.BulletTankCollider;
import com.weishuai.tank.cor.Collider;
import com.weishuai.tank.cor.ColliderChain;
import com.weishuai.tank.cor.TankTankCollider;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {




    // 初始化坦克位置
    Tank myTank = new Tank(200, 400, Dir.DOWM, Group.GOOD, this);
//    List<Bullet> bullets = new ArrayList<>();
//    List<Tank> tanks = new ArrayList<>();
//    List<Explode> explodes = new ArrayList<>();

    ColliderChain chain = new ColliderChain();

    Collider collider = new BulletTankCollider();
    Collider collider2 = new TankTankCollider();
    List<GameObject> objects = new ArrayList<>();

    public void add(GameObject go) {
        this.objects.add(go);
    }

    public void remove(GameObject go) {
        this.objects.remove(go);
    }

    public GameModel () {
        int initTankCount = Integer.valueOf((String)(PropertyMgr.get("initTankCount")));
        // 默认加入五个敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            add(new Tank(50 + i * 80, 200, Dir.DOWM, Group.BAD, this));
        }
        add(new Wall(150,150,200,50));
        add(new Wall(550,150,200,50));
        add(new Wall(300,300,50,200));
        add(new Wall(550,300,50,200));

    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
//        g.drawString("子弹的数量" + objects.size(), 10,60);
//        g.drawString("敌人的数量" + tanks.size(), 10,80);
//        g.drawString("爆炸的数量" + explodes.size(), 10,100);
        g.setColor(c);
        // 画主坦克
        myTank.paint(g);
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(g);
        }

        // 互相碰撞
        for(int i = 0; i < objects.size() ; i++ ) {
            for(int j = i + 1; j < objects.size(); j++) {
                GameObject o1 = objects.get(i);
                GameObject o2 = objects.get(j);
                chain.collide(o1, o2);
            }
        }


        // 消灭坦克  碰撞检测
//        for (int i = 0; i < bullets.size() ; i++) {
//            for (int j = 0; j < tanks.size() ; j++) {
//                bullets.get(i).collideWidth(tanks.get(j));
//            }
//        }


    }

    public Tank getMainTank() {
        return myTank;
    }
}
