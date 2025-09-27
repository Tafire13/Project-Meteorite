import javax.swing.JFrame;

public class MainFrame extends JFrame {
    MainFrame(int MeteoriteCount) {
        setTitle("Meteorite");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new MainPanel(MeteoriteCount));
    }
}
