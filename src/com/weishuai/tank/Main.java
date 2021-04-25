package com.weishuai.tank;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();

        int initTankCount = Integer.valueOf((String)(PropertyMgr.get("initTankCount")));
        // 默认加入五个敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            tankFrame.tanks.add(new Tank(50 + i * 80, 200, Dir.DOWM, Group.BAD, tankFrame));
        }
        while(true){
            Thread.sleep(50);
            tankFrame.repaint();
        }
    }
}
