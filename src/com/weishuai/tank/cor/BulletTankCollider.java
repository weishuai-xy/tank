package com.weishuai.tank.cor;

import com.weishuai.tank.*;

public class BulletTankCollider implements Collider{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank) {
            Bullet b = (Bullet) o1;
            Tank t = (Tank) o2;
            // TODO copy code from method

            if (b.getGroup() == t.getGroup()) return false;

            if (b.rect.intersects(t.rect)) {
                t.die();
                b.die();
                int eX = t.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
                int eY = t.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
                // 爆炸
                new Explode(eX, eY);
                return false;
            }
            return true;
        } else if (o1 instanceof Tank && o2 instanceof Bullet) {
            return collide(o2, o1);
        } else {
            return true;
        }

    }

    public boolean collideWidth(Tank tank) {

        return false;
    }

}
