package com.weishuai.tank.cor;

import com.weishuai.tank.GameObject;
import com.weishuai.tank.PropertyMgr;
import org.junit.platform.commons.util.StringUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ColliderChain implements Collider{

    private List<Collider> colliders = new LinkedList<>();

    public void add(Collider c) {
        colliders.add(c);
    }

    public ColliderChain() {
        try {
            String coliiderStr = (String) PropertyMgr.get("coliiders");
            System.out.println(coliiderStr);
            if (StringUtils.isNotBlank(coliiderStr)) {
                String[] split = coliiderStr.split(",");
                for (String className: split) {
                    Collider c = (Collider) Class.forName(className).getDeclaredConstructor().newInstance();
                    add(c);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean collide(GameObject o1, GameObject o2) {
        for (int i = 0; i < colliders.size(); i++) {
            if(!colliders.get(i).collide(o1, o2)) {
                return false;
            }
        }
        return true;
    }
}
