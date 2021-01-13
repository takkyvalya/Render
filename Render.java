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
                img.setRGB(x, y, color.getRGB());
            }
        } else {
            while (x != x2 || y != y2) {
                f = f + (x1 - x2) * sx;
                if (f > 0) {
                    f = f - (y2 - y1) * sy;
                    x = x + sx;
                }
                y = y - sy;
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
