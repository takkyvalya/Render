package com.valya;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main extends JFrame {

    static final int w = 1366;
    static final int h = 768;

    public static void draw(Graphics2D g) {
        //Создаем буффер в который рисуем кадр.
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        //Рисуем кадр.
        //Render.render(img);
        // Рисуется снежинка
        /*
        int A=400;
        int B=300;
        int R=100;
        for (int i=1;i<17;i++){
            int x=(int)(A + R*Math.cos((Math.PI / 8) * i));
            int y=(int)(B + R * Math.sin((Math.PI / 8 )* i));
            //System.out.println(x + " " + y);
            Render.renderLine(img,A,B ,x,y,new Color(30,30,30));
        }
        */
        //Рисуется многоугльник
        double A=400;
        double B=300;
        double R=100;
        for (double i=1;i<13;i++){
            double x=(A + R * Math.cos((Math.PI / 6) * i));
            double y=(B + R * Math.sin((Math.PI / 6 )* i));
            double x2=(A + R * Math.cos((Math.PI / 6) * (i+1)) );
            double y2=(B + R * Math.sin((Math.PI / 6 )* (i+1) ));
            //System.out.println(x + " " + y);
            Render.renderColorTriangle(img, A,B, x,y,x2,y2, new Color((int)i*20,0,0));
            //Render.renderLine(img,A,B ,x,y,new Color(30,30,30));
            //Render.renderLine(img,A,B ,x2,y2,new Color(30,30,30));
        }
        
        g.drawImage(img, 0, 0, null);
    }



    //магический код позволяющий всему работать, лучше не трогать
    public static void main(String[] args) throws InterruptedException {
        Main jf = new Main();
        jf.setSize(w, h);//размер экрана
        jf.setUndecorated(false);//показать заголовок окна
        jf.setTitle("Моя супер программа");
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.createBufferStrategy(2);
        //в бесконечном цикле рисуем новый кадр
        while (true) {
            long frameLength = 1000 / 60; //пытаемся работать из рассчета  60 кадров в секунду
            long start = System.currentTimeMillis();
            BufferStrategy bs = jf.getBufferStrategy();
            Graphics2D g = (Graphics2D) bs.getDrawGraphics();
            g.clearRect(0, 0, jf.getWidth(), jf.getHeight());
            draw(g);

            bs.show();
            g.dispose();

            long end = System.currentTimeMillis();
            long len = end - start;
            if (len < frameLength) {
                Thread.sleep(frameLength - len);
            }
        }

    }

    public void keyTyped(KeyEvent e) {
    }

    //Вызывается когда клавиша отпущена пользователем, обработка события аналогична keyPressed
    public void keyReleased(KeyEvent e) {

    }
}
