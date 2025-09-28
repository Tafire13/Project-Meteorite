import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.util.Random;

public class MainPanel extends JPanel {
    Image Meteorite1 = Toolkit.getDefaultToolkit().createImage(System.getProperty("user.dir")
            + File.separator + "src" + File.separator + "Meteorite1.png");
    Image Meteorite2 = Toolkit.getDefaultToolkit().createImage(System.getProperty("user.dir")
            + File.separator + "src" + File.separator + "Meteorite2.png");
    Image Meteorite3 = Toolkit.getDefaultToolkit().createImage(System.getProperty("user.dir")
            + File.separator + "src" + File.separator + "Meteorite3.png");
    Image BloomEffect = Toolkit.getDefaultToolkit().createImage(System.getProperty("user.dir")
            + File.separator + "src" + File.separator + "bloom.png");

    int[] meteoriteX;
    int[] meteoriteY;
    int[] meteoriteDX;
    int[] meteoriteDY;
    boolean[] blast;
    int[] speed;
    boolean[] alive;
    Image[] Meteorite = { Meteorite1, Meteorite2, Meteorite3 };
    int[] indexMeteorite;
    MainThread[] ThreadMeteor;

    MainPanel(int MeteoriteCount) {
        setBackground(Color.black);
        meteoriteX = new int[MeteoriteCount];
        meteoriteY = new int[MeteoriteCount];
        meteoriteDX = new int[MeteoriteCount];
        meteoriteDY = new int[MeteoriteCount];
        blast = new boolean[MeteoriteCount];
        speed = new int[MeteoriteCount];
        indexMeteorite = new int[MeteoriteCount];
        ThreadMeteor = new MainThread[MeteoriteCount];
        alive = new boolean[MeteoriteCount];

        for (int i = 0; i < meteoriteX.length; i++) {
            meteoriteX[i] = new Random().nextInt(800 - 80);
            meteoriteY[i] = new Random().nextInt(600 - 80);
            indexMeteorite[i] = (int) (Math.random() * Meteorite.length);

            meteoriteDX[i] = new Random().nextInt(5) - 2;
            meteoriteDY[i] = new Random().nextInt(5) - 2;
            if (meteoriteDX[i] == 0) meteoriteDX[i] = 1;
            if (meteoriteDY[i] == 0) meteoriteDY[i] = 1;

            speed[i] = new Random().nextInt(30) + 10;
            alive[i] = true;
            blast[i] = false;

            ThreadMeteor[i] = new MainThread(this, i);
            ThreadMeteor[i].start();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < meteoriteX.length; i++) {
            if (alive[i]) {
                g.drawImage(Meteorite[indexMeteorite[i]], meteoriteX[i], meteoriteY[i], 50, 50, this);
            }else if (!blast[i]) {
                g.drawImage(BloomEffect, meteoriteX[i], meteoriteY[i], 50, 50, this);
            }
        }
    }

}
