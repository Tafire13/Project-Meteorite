import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.util.Random;

public class MainPanel extends JPanel{
    Image Meteorite1 = Toolkit.getDefaultToolkit().createImage(System.getProperty("user.dir")+ File.separator+"src"+ File.separator+"Meteorite1.png");
    Image Meteorite2 = Toolkit.getDefaultToolkit().createImage(System.getProperty("user.dir")+ File.separator+"src"+ File.separator+"Meteorite2.png");
    Image Meteorite3 = Toolkit.getDefaultToolkit().createImage(System.getProperty("user.dir")+ File.separator+"src"+ File.separator+"Meteorite3.png");
    int []meteorite1X = new int[5];
    int []meteorite1Y = new int[5];
    int[] meteoriteDX = new int[5];
    int[] meteoriteDY = new int[5];
    int[] speed = new int[5];
    Image[] Meteorite ={
            Meteorite1, Meteorite2,Meteorite3
    };
    int[] indexMeteorite = new int[5];
    MainThread[] ThreadMeteor = new MainThread[5];
    MainPanel() {
        setBackground(Color.black);
        for (int i = 0; i < meteorite1X.length; i++) {
            meteorite1X[i] = new Random().nextInt(740)+40;
            meteorite1Y[i] = new Random().nextInt(540)+40;
            indexMeteorite[i] = (int)(Math.random()*Meteorite.length);

            meteoriteDX[i] = new Random().nextInt(5)-2;
            meteoriteDY[i] = new Random().nextInt(5)-2;
            if (meteoriteDX[i] == 0) meteoriteDX[i] = 1;
            if (meteoriteDY[i] == 0) meteoriteDY[i] = 1;

            speed[i] = new Random().nextInt(50)+1;

            ThreadMeteor[i] = new MainThread(this, i, speed[i]);
            ThreadMeteor[i].start();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < meteorite1X.length; i++) {
            g.drawImage(Meteorite[indexMeteorite[i]], meteorite1X[i], meteorite1Y[i],50,50, this);


        }
    }

}
