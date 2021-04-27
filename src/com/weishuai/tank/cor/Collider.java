package com.weishuai.tank.cor;

import com.weishuai.tank.GameObject;

public interface Collider {
    boolean collide (GameObject o1, GameObject o2);
}
