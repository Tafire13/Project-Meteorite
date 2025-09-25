import javax.swing.*;
import java.util.Random;

public class MainThread extends Thread{
    MainPanel panel;
    int index;
    int speed;
    MainThread(MainPanel panel, int index, int speed) {
        this.panel = panel;
        this.index = index;
        this.speed = speed;
    }

    @Override
    public void run() {
        while(true){
            panel.meteorite1X[index] += panel.meteoriteDX[index];
            panel.meteorite1Y[index] += panel.meteoriteDY[index];

            if (panel.meteorite1X[index] < 0 || panel.meteorite1X[index] + 50 > panel.getWidth()) {
                panel.meteoriteDX[index] = -panel.meteoriteDX[index];

            }
            if (panel.meteorite1Y[index] < 0 || panel.meteorite1Y[index] + 50 > panel.getHeight()) {
                panel.meteoriteDY[index] = -panel.meteoriteDY[index];
            }


                panel.repaint();
            try {
                sleep(speed);
            }catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
