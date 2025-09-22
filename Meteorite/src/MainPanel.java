import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;

public class MainPanel extends JPanel implements Runnable {
    Image Meteorite1 = Toolkit.getDefaultToolkit().createImage(System.getProperty("user.dir")+ File.separator+"src"+ File.separator+"Meteorite1.png");
    Image Meteorite2 = Toolkit.getDefaultToolkit().createImage(System.getProperty("user.dir")+ File.separator+"src"+ File.separator+"Meteorite2.png");
    Image Meteorite3 = Toolkit.getDefaultToolkit().createImage(System.getProperty("user.dir")+ File.separator+"src"+ File.separator+"Meteorite3.png");
    int []meteorite1X = new int[5];
    int []meteorite1Y = new int[5];
    Image[] Meteorite ={
            Meteorite1, Meteorite2,Meteorite3
    };
    int[] indexMeteorite = new int[5];
    MainPanel() {
        setBackground(Color.black);
        for (int i = 0; i < meteorite1X.length; i++) {
            meteorite1X[i] = (int)(Math.random()*740);
            meteorite1Y[i] = (int)(Math.random()*540);
            indexMeteorite[i] = (int)(Math.random()*Meteorite.length);
        }
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < meteorite1X.length; i++) {
            g.drawImage(Meteorite[indexMeteorite[i]], meteorite1X[i], meteorite1Y[i],50,50, this);

        }
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < meteorite1X.length; i++) {
                meteorite1X[i] += (int)(Math.random()*11) - 5;
                meteorite1Y[i] += (int)(Math.random()*11) - 5;
            }
            repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
