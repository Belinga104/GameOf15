import javax.swing.*;
import java.awt.*;

public class Vittoria extends JFrame {
    public Vittoria(String stringa) {
        super("VITTORIA");
        JPanel tutto = new JPanel();
        tutto.add(new JLabel(stringa,SwingConstants.CENTER));
        tutto.add(new JLabel(new ImageIcon(Frame.class.getResource("vittoria.jpg"))));
        tutto.setBackground(new Color(136,189,195));
        add(tutto);
        setSize(300,350);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
