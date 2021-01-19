package com.valya;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Render {

    public static void render(BufferedImage img) {
// img.setRGB(500, 300, new Color(255, 0, 200).getRGB());
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                img.setRGB(i, j, new Color(i * j % 256, (i + j) % 256, (i * i + j * j) % 256).getRGB());
            }
        }
    }
    public static void renderTriangle(BufferedImage img, int x1, int y1, int x2, int y2, int x3, int y3, Color color, Color color2) {

        for (int i = Math.min(x1, Math.min(x2, x3)); i <= Math.max(x1, Math.max(x2, x3)); i++) {
            for (int j = Math.min(y1, Math.min(y2, y3)); j <= Math.max(y1, Math.max(y2, y3)); j++) {
                double alpha=(double) ((j-x1) * (y3-y1) - (x3-x1)* (j-y1)) / (double) ((x2-x1) * (y3-y1)-(x3-x1)*(y2-y1));
                double beta=(double) ((x2-x1) * (j-y1) - (y2-y1) * (i-x1)) / (double) ((x2-x1) * (y3-y1)-(x3-x1)*(y2-y1));

                    //System.out.println(alpha + " " + beta + " ");

                //System.out.println(alpha + " " + beta + " ");
                //System.out.println(x2 * y3 - x3 * y2);
                if(alpha>0 && beta>0 && beta+alpha<=1){
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


 /*//Стоит начать с этого
    public static void renderLine(BufferedImage img, int x1, int y1, int x2, int y2, Color color) {
        img.setRGB(x1, y1, color.getRGB());
        img.setRGB(x2, y2, color.getRGB());
        if (x1 < x2) {
            float y = y1;
            for (int x = x1; x < x2; x++) {
                img.setRGB(x, (int) y, color.getRGB());
                y = (((float) y2 - (float) y1) / ((float) x2 - (float) x1)) * ((float) x - (float) x1) + y1;
            }
        } else if (x1 < x2) {
            float y = y1;
            for (int x = x2; x < x1; x++) {
                img.setRGB(x, (int) y, color.getRGB());
                y = (((float) y2 - (float) y1) / ((float) x2 - (float) x1)) * ((float) x - (float) x1) + y1;
            }
        } else {
            for (int y = y1; y <= y2; y++) {
                img.setRGB(x1, y, color.getRGB());
            }
        }
    }
}
  */
