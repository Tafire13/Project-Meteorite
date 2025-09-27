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

            if(panel.meteorite1X[index] == panel.meteorite1Y[index]){

            }

            if (panel.meteorite1X[index] < 0 || panel.meteorite1X[index] + 50 > panel.getWidth()) {
                panel.meteoriteDX[index] = -panel.meteoriteDX[index];
                if(panel.speed[index] > 5) panel.speed[index]--;

            }
            if (panel.meteorite1Y[index] < 0 || panel.meteorite1Y[index] + 50 > panel.getHeight()) {
                panel.meteoriteDY[index] = -panel.meteoriteDY[index];
                if(panel.speed[index] > 5) panel.speed[index]--;

            }

            for (int i = 0; i < panel.meteorite1X.length; i++) {
                if (!panel.alive[i]) continue;

                for (int j = i + 1; j < panel.meteorite1X.length; j++) {
                    if (!panel.alive[j]) continue;

                    if (panel.meteorite1X[i] < panel.meteorite1X[j] + 50 &&
                            panel.meteorite1X[i] + 50 > panel.meteorite1X[j] &&
                            panel.meteorite1Y[i] < panel.meteorite1Y[j] + 50 &&
                            panel.meteorite1Y[i] + 50 > panel.meteorite1Y[j]) {

                        if (panel.speed[i] > panel.speed[j]) {
                            panel.speed[i] = panel.speed[i] - panel.speed[j];
                            panel.alive[j] = false;
                        } else if (panel.speed[i] < panel.speed[j]) {
                            panel.speed[j] = panel.speed[j] - panel.speed[i];
                            panel.alive[i] = false;
                        } else {
                            panel.alive[i] = false;
                            panel.alive[j] = false;
                        }
                    }
                }
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
