package exercise6.p_2_32.entity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.module.InvalidModuleDescriptorException;
import java.util.ConcurrentModificationException;
import java.util.Objects;

public class Animal implements Comparable {
    protected String name;
    protected boolean isMale;
    private final double power;
    private BufferedImage image;

    public Animal(String name, boolean isMale, double power) {
        this.name = name;
        this.isMale = isMale;
        this.power = power;
        loadImage();
    }
    public String getName() {
        return name;
    }

    public boolean isMale() {
        return isMale;
    }

    public double getPower() {
        return power;
    }

    public BufferedImage getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Animal[" +
                "name='" + name + '\'' +
                ", isMale=" + isMale +
                ", power=" + power +
                ']';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Animal animal) {
            return Double.compare(this.power, animal.power);
        } else {
            throw new ConcurrentModificationException();
        }
    }
    public void loadImage() {
        try {
            if (this instanceof Fish)
                image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/exercise6/image/entity/fish.jpg")));
            else if (this instanceof Bear)
                image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/exercise6/image/entity/bear.jpg")));
            else
                image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/exercise6/image/entity/null.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
