package week1.exercise6.p_2_32.ui;

import week1.exercise6.p_2_32.entity.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class GamePanel extends JPanel implements Runnable {
    //NAME APP
    private final String name = "Forest";

    //ENTITY
    private Forest forest;
    private final int maxScreenRow = 20;
    private final int maxScreenCol = 12;

    //SHOW SCREEN
    private final int tileSize = 10;
    public final int screenWith = tileSize * maxScreenRow; // 768 px
    public final int screenHeight = tileSize * maxScreenCol; // 576 px

    //THREAD
    private Thread threadMain;

    //FPS
    private int fps = 1;

    public GamePanel() {
        this.setName(name);
        this.setPreferredSize(new Dimension(screenWith, screenHeight));
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);

        startGameThread();

        forest = Forest.getInstance(maxScreenRow, maxScreenCol);
        forest.add(EAnimal.FISH, 1000);
        forest.add(EAnimal.BEAR, 20);
    }

    private void startGameThread() {
        threadMain = new Thread(this);
        threadMain.start();
    }

    @Override
    public void run() {
        final double drawInterval = 1_000_000_000 / fps;
        long lastTime = System.nanoTime();
        double delta = 0;
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (threadMain != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if (timer > 1_000_000_000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    private void update() {
        forest.go();
    }

    @Override
    public void paintComponent(Graphics gp) {
        super.paintComponent(gp);

        Graphics2D gp2D = (Graphics2D) gp;

        for (int i = 0; i < maxScreenRow; i++) {
            for (int j = 0; j < maxScreenCol; j++) {
                if (forest.getData()[i][j] != null) {
                    gp2D.drawImage(forest.getData()[i][j].getImage(), i * tileSize, j * tileSize, null);
                } else {
                    BufferedImage image = null;
                    try {
                        image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/image/entity/null.png")));
                    } catch (Exception ignored) {

                    }
                    gp2D.drawImage(image, i * tileSize, j * tileSize, tileSize, tileSize, null);
                }
            }
        }
        gp2D.dispose();
    }
}
