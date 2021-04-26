package com.weishuai.tank.abstractfactory;

import com.weishuai.tank.Dir;
import com.weishuai.tank.Group;
import com.weishuai.tank.TankFrame;

public class RectFactry extends GameFactry{
    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        return null;
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tf) {
        return new RectExplode(x, y, tf);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new RectBullet(x, y, dir, group, tf);
    }
}
