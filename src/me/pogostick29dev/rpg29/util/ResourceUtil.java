package me.pogostick29dev.rpg29.util;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.URL;

public class ResourceUtil {

    private ResourceUtil() { }

    private static Class<?> clazz;

    public static void setup(Class<?> clazz) {
        this.clazz = clazz;
    }

    public static URL getResource(String path) {
        return clazz.getResource("/res/" + path);
    }

    public static InputStream getResourceAsStream(String path) {
        return clazz.getResourceAsStream("/res/" + path);
    }

    public static BufferedImage getBufferedImage(String path) {
        try {
            return ImageIO.read(getResource(path + ".png"));
        } catch (Exception e) {
            return null;
        }
    }

    public static ImageIcon getImage(String path) {
        return new ImageIcon(getBufferedImage(path));
    }

    public static ImageIcon getImage(String path, int width, int height) {
        return resizeImage(getImage(path), width, height);
    }

    public static ImageIcon resizeImage(ImageIcon image, int width, int height) {
        return new ImageIcon(image.getImage().getScaledInstance(width, height, 0));
    }
}
