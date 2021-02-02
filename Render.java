package com.valya;


import java.awt.*;
import java.awt.image.BufferedImage;

public class Render {

    public static void render(BufferedImage img) {
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
        //Рисует треугольник с градиентом
        //Render.renderGrColorTriangle(img,130,145,564,470,452,155);

    }
    public static void renderGrColorTriangle(BufferedImage img, double x1, double y1, double x2, double y2, double x3, double y3){
        for (int i = (int) Math.min(x1, Math.min(x2, x3)); i <= Math.max(x1, Math.max(x2, x3)); i++) {
            for (int j = (int) Math.min(y1, Math.min(y2, y3)); j <= Math.max(y1, Math.max(y2, y3)); j++) {
                //Color r=new Color(255-Math.abs(i-x1),255-Math.abs(i-x2), 255-Math.abs(i-x3));
                double alpha= ((i-x1) * (y3-y1) - (x3-x1)* (j-y1)) /  ((x2-x1) * (y3-y1)-(x3-x1)*(y2-y1));
                double beta=(double) ((x2-x1) * (j-y1) - (y2-y1) * (i-x1)) / ((x2-x1) * (y3-y1)-(x3-x1)*(y2-y1));
                if(alpha>=0 && beta>=0 && beta+alpha<=1){
                    img.setRGB((int)i,(int) j,(new Color((int)(alpha*255),(int)(beta*255),(int)((1 - beta - alpha)*255))).getRGB());
                }
            }
        }
    }
    public static void renderColorTriangle(BufferedImage img, double x1, double y1, double x2, double y2, double x3, double y3, Color color){
        for (int i = (int) Math.min(x1, Math.min(x2, x3)); i <= Math.max(x1, Math.max(x2, x3)); i++) {
            for (int j = (int) Math.min(y1, Math.min(y2, y3)); j <= Math.max(y1, Math.max(y2, y3)); j++) {
                //Color r=new Color(255-Math.abs(i-x1),255-Math.abs(i-x2), 255-Math.abs(i-x3));
                double alpha= ((i-x1) * (y3-y1) - (x3-x1)* (j-y1)) /  ((x2-x1) * (y3-y1)-(x3-x1)*(y2-y1));
                double beta=(double) ((x2-x1) * (j-y1) - (y2-y1) * (i-x1)) / ((x2-x1) * (y3-y1)-(x3-x1)*(y2-y1));
                if(alpha>=0 && beta>=0 && beta+alpha<=1){
                    img.setRGB((int)i,(int) j,color.getRGB());
                }
            }
        }
    }


    public static void renderTriangle(BufferedImage img, int x1, int y1, int x2, int y2, int x3,  int y3, Color color, Color color2){
        for (int i = Math.min(x1, Math.min(x2, x3)); i <= Math.max(x1, Math.max(x2, x3)); i++) {
            for (int j = Math.min(y1, Math.min(y2, y3)); j <= Math.max(y1, Math.max(y2, y3)); j++) {
                double alpha=(double) ((i-x1) * (y3-y1) - (x3-x1)* (j-y1)) / (double) ((x2-x1) * (y3-y1)-(x3-x1)*(y2-y1));
                double beta=(double) ((x2-x1) * (j-y1) - (y2-y1) * (i-x1)) / (double) ((x2-x1) * (y3-y1)-(x3-x1)*(y2-y1));
                if(alpha>=0 && beta>=0 && beta+alpha<=1){
                    img.setRGB(i,j,color2.getRGB());
                }
            }
        }
        img.setRGB(x1, y1, color.getRGB());
        img.setRGB(x2, y2, color.getRGB());
        img.setRGB(x3, y3, color.getRGB());

    }




    public static void renderLine(BufferedImage img, int x1, int y1, int x2, int y2, Color color) {
        img.setRGB(x1,y1,color.getRGB());
        int sy = 1;
        int sx = 1;
        if (y2 - y1 < 0) {
            sy = -1;
        }
        if (x1 - x2 < 0) {
            sx = -1;
        }
        int f = 0;
        int x = x1;
        int y = y1;
        if (Math.abs(y2 - y1) < Math.abs(x1 - x2)) {
            while (x != x2 || y != y2) {
                f = f + (y2 - y1) * sy;
                if (f > 0) {
                    f = f - (x1 - x2) * sx;
                    y = y + sy;
                }
                x = x - sx;
                //System.out.println(x + " " + y + "first");
                img.setRGB(x, y, color.getRGB());
            }
        } else {
            while (x != x2 || y != y2) {
                f = f + (x1 - x2) * sx;
                if (f > 0) {
                    f = f - (y2 - y1) * sy;
                    x = x - sx;
                }
                y = y + sy;
                //System.out.println(x+" "+y);
                img.setRGB(x, y, color.getRGB());
            }
        }
    }
}
