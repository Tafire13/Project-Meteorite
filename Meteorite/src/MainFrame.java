import javax.swing.JFrame;

public class MainFrame extends JFrame {
    MainFrame() {
        setTitle("Meteorite");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new MainPanel());
    }
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
    }
}
