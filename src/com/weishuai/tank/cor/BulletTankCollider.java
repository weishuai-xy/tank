package com.weishuai.tank.cor;

import com.weishuai.tank.Bullet;
import com.weishuai.tank.GameObject;
import com.weishuai.tank.Tank;

public class BulletTankCollider implements Collider{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank) {
            Bullet b = (Bullet) o1;
            Tank t = (Tank) o2;
            // TODO copy code from method
            if(b.collideWidth(t)) {
                return false;
            }
            return true;
        } else if (o1 instanceof Tank && o2 instanceof Bullet) {
            return collide(o2, o1);
        } else {
            return true;
        }

    }

}
