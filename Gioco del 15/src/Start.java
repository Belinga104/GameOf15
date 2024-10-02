import javax.swing.*;
import java.awt.*;
public class Start extends JFrame {
    public Start() {

        JLabel rigioco = new JLabel("Vuoi rigiocare?",SwingConstants.CENTER);
        rigioco.setBackground(new Color(24, 78, 119));
        JButton jButton = new JButton("SI");
        jButton.addActionListener(e -> {
            new Frame();
            setVisible(false);
        });
        jButton.setBackground(new Color(26, 117, 159));
        jButton.setForeground(new Color(242, 244, 243));
        JButton jb = new JButton("NO");
        jb.setBackground(new Color(26, 117, 159));
        jb.setForeground(new Color(242, 244, 243));
        jb.addActionListener(e -> setVisible(false));
        Container container = new Container();
        container.setLayout(new GridLayout(3,1));
        container.add(rigioco);
        container.add(jb);
        container.add(jButton);
        this.add(container);
        this.setSize(100,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

}
