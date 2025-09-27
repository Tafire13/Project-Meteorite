import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartFrame extends JFrame {
    StartFrame() {
        StartPanel panel = new StartPanel();
        setTitle("Start");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 200);
        setResizable(false);
        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        StartFrame frame = new StartFrame();
        frame.setVisible(true);
    }
}
class StartPanel extends JPanel {
    private JButton button;
    private JTextField field;
    private JLabel label;
    StartPanel() {
        setLayout(new  BorderLayout());
        setButton();
        setField();
        setLabel();
        add(createButtonPanel(button), BorderLayout.SOUTH);
        add(createFieldPanel(field, label), BorderLayout.CENTER);
    }

    public void setButton() {
        this.button = new JButton("Start");
        this.button.setFocusable(false);
        this.button.setBackground(Color.red);
        this.button.setPreferredSize(new Dimension(75, 50));
        this.button.addActionListener(new  ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int meteorCount = Integer.parseInt(field.getText());
                    MainFrame frame = new MainFrame(meteorCount);
                    frame.setVisible(true);
                    SwingUtilities.getWindowAncestor(button).dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a number", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public JButton getButton() {
        return button;
    }

    public void setField() {
        this.field = new JTextField();
        this.field.setPreferredSize(new Dimension(250, 50));
    }

    public JTextField getField() {
        return field;
    }

    public void setLabel() {
        this.label = new JLabel("Enter the number of meteorites you want :");
        this.label.setFont(new Font("Arial", Font.PLAIN, 16));
    }

    public JPanel createButtonPanel(JButton button) {
        JPanel SouthPanel = new JPanel();
        SouthPanel.add(button);
        return SouthPanel;
    }
    public JPanel createFieldPanel(JTextField field, JLabel label) {
        JPanel CenterPanel = new JPanel();
        CenterPanel.add(label);
        CenterPanel.add(field);
        return CenterPanel;
    }
}
