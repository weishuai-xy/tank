package com.weishuai.tank.cor;

import com.weishuai.tank.Bullet;
import com.weishuai.tank.GameObject;
import com.weishuai.tank.Group;
import com.weishuai.tank.Tank;

public class TankTankCollider implements Collider{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank) {
            Tank t1 = (Tank) o1;
            Tank t2 = (Tank) o2;
            if (t1.getRect().intersects(t2.getRect())) {
                t1.prePoriotion();
                t2.prePoriotion();
            }

        }
        return true;
    }
}
