package com.weishuai.tank;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();
        for (int i = 0; i < 5; i++) {
            tankFrame.tanks.add(new Tank(50 + i * 80, 200, Dir.DOWM, tankFrame));
        }
        while(true){
            Thread.sleep(50);
            tankFrame.repaint();
        }
    }
}
