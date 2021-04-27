package com.weishuai.tank.cor;

import com.weishuai.tank.Bullet;
import com.weishuai.tank.GameObject;
import com.weishuai.tank.Tank;
import com.weishuai.tank.Wall;

public class TankWallCollider implements Collider{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Wall && o2 instanceof Tank) {
            Wall w = (Wall) o1;
            Tank t = (Tank) o2;
            if (w.rect.intersects(t.rect)) {
                t.prePoriotion();
            }
        } else if (o1 instanceof Tank && o2 instanceof Wall) {
            collide(o2, o1);
        }
        return true;
    }
}
