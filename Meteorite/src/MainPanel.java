import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;

public class MainPanel extends JPanel {
    Image Meteorite1 = Toolkit.getDefaultToolkit().createImage(System.getProperty("user.dir")+ File.separator+"src"+ File.separator+"Meteorite1.png");
    int []meteorite1X = new int[5];
    int []meteorite1Y = new int[5];
    MainPanel() {
        setBackground(Color.black);
        for (int i = 0; i < meteorite1X.length; i++) {
            meteorite1X[i] = (int)(Math.random()*740);
            meteorite1Y[i] = (int)(Math.random()*640);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < meteorite1X.length; i++) {
            g.drawImage(Meteorite1, meteorite1X[i], meteorite1Y[i],50,50, this);
        }
    }
}
