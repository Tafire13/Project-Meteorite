import javax.swing.*;
import java.util.Random;

public class MainThread extends Thread{
    MainPanel panel;
    int index;
    MainThread(MainPanel panel, int index) {
        this.panel = panel;
        this.index = index;
    }

    @Override
    public void run() {
        while(true){
            panel.meteorite1X[index] += panel.meteoriteDX[index];
            panel.meteorite1Y[index] += panel.meteoriteDY[index];

            if (panel.meteorite1X[index] < 0 || panel.meteorite1X[index] + 50 > panel.getWidth()) {
                panel.meteoriteDX[index] = -panel.meteoriteDX[index];
                if(panel.speed[index] > 0) panel.speed[index]--;

            }
            if (panel.meteorite1Y[index] < 0 || panel.meteorite1Y[index] + 50 > panel.getHeight()) {
                panel.meteoriteDY[index] = -panel.meteoriteDY[index];
                if(panel.speed[index] > 0) panel.speed[index]--;

            }


                panel.repaint();
            try {
                sleep(panel.speed[index]);
            }catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
