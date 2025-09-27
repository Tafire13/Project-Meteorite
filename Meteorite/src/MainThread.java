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
            if (!panel.alive[index]) return;

            panel.meteoriteX[index] += panel.meteoriteDX[index];
            panel.meteoriteY[index] += panel.meteoriteDY[index];

            if (panel.meteoriteX[index] < 0 || panel.meteoriteX[index] + 50 > panel.getWidth()) {
                panel.meteoriteDX[index] = -panel.meteoriteDX[index];
                if(panel.speed[index] > 5) panel.speed[index]--;

            }
            if (panel.meteoriteY[index] < 0 || panel.meteoriteY[index] + 50 > panel.getHeight()) {
                panel.meteoriteDY[index] = -panel.meteoriteDY[index];
                if(panel.speed[index] > 5) panel.speed[index]--;

            }

            for (int i = 0; i < panel.meteoriteX.length; i++) {
                if (i == index) continue;
                if (!panel.alive[i]) continue;
                if (!panel.alive[index]) break;

                if (panel.meteoriteX[index] < panel.meteoriteX[i] + 50 &&
                        panel.meteoriteX[index] + 50 > panel.meteoriteX[i] &&
                        panel.meteoriteY[index] < panel.meteoriteY[i] + 50 &&
                        panel.meteoriteY[index] + 50 > panel.meteoriteY[i]) {

                    if (panel.speed[index] < panel.speed[i]) {
                        panel.speed[index] += panel.speed[i];
                        panel.alive[i] = false;
                    } else if (panel.speed[index] > panel.speed[i]) {
                        panel.speed[i] += panel.speed[index];
                        panel.alive[index] = false;
                    } else {
                        if (Math.random() < 0.5) {
                            panel.alive[index] = false;
                        } else {
                            panel.alive[i] = false;
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
