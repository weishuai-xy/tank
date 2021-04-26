package com.weishuai.tank.abstractfactory;

import com.weishuai.tank.Dir;
import com.weishuai.tank.Group;
import com.weishuai.tank.TankFrame;

public abstract class GameFactry {
    public abstract BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf);
    public abstract BaseExplode createExplode(int x, int y, TankFrame tf);
    public abstract BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf);
}
