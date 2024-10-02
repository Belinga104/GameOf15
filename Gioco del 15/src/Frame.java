import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Frame extends JFrame {

    private int IVuoto = 3, YVuoto = 3;

    private int mosse = 0;
    private JButton[][] jButtons = new JButton[4][4];
    private int secondi = 0, minuti = 0;
    private Container c = new Container();
    private JPanel nord = new JPanel();
    private JPanel center = new JPanel();

    private JLabel Stimer = new JLabel("Minuti:0 " + "Secondi:0");
    private Timer timer = new Timer(1000, e -> {

        secondi++;
        minuti = secondi /60;
        Stimer.setText("Minuti:" + minuti + " Secondi:" + (secondi-(minuti*60)));

    });
    private ArrayList<Integer> arrayList = new ArrayList<>();

    private JLabel Jmosse = new JLabel("Mosse: " + mosse);
    public Frame() {

        super("Gioco del 15");
        c.setLayout(new BorderLayout());
        nord.setLayout(new FlowLayout());

        for (int i = 0; i < 15; i++) {
            arrayList.add(i + 1);
        }
        Collections.shuffle(arrayList);
        Stimer.setForeground(new Color(242, 244, 243));
        Jmosse.setForeground(new Color(242, 244, 243));
        nord.add(Stimer);
        nord.add(Jmosse);
        nord.setBackground(new Color(24, 78, 119));
        center.setLayout(new GridLayout(4,4,3,3));
        center.setBackground(new Color(24, 78, 119));
        int n = 0;
        for (int i = 0; i < 4; i++) {
            for (int y = 0; y < 4; y++) {
                if (i == 3 && y == 3) {

                    jButtons[i][y] = new JButton();
                    jButtons[i][y].setBackground(new Color(26, 117, 159));
                    jButtons[i][y].setForeground(new Color(242, 244, 243));
                    jButtons[i][y].setVisible(false);
                    jButtons[i][y].setBorderPainted(false);
                    jButtons[i][y].addActionListener(e -> {
                            JButton button = (JButton) e.getSource();

                            int riga = -1, colonna = -1;
                            for (int j = 0; j < 4; j++) {
                                for (int k = 0; k < 4; k++) {
                                    if (jButtons[j][k] == button) {
                                        riga = j;
                                        colonna = k;
                                        break;
                                    }
                                }
                            }

                            if (IsVicino(riga, colonna)) {

                                timer.start();
                                mosse++;
                                Jmosse.setText("Mosse: " + mosse);
                                String temp = jButtons[riga][colonna].getText();
                                jButtons[riga][colonna].setText(jButtons[IVuoto][YVuoto].getText());
                                jButtons[IVuoto][YVuoto].setText(temp);
                                jButtons[IVuoto][YVuoto].setVisible(true);
                                jButtons[riga][colonna].setVisible(false);
                                IVuoto = riga;
                                YVuoto = colonna;
                                int conta = 0;

                                for (int j = 0; j < 4; j++) {
                                    for (int k = 0; k < 4; k++) {

                                        switch (j) {

                                            case 0 -> {
                                                switch (k) {

                                                    case 0 -> {
                                                        if (jButtons[j][k].getText().equals("1")) {
                                                            conta++;
                                                        }
                                                    }

                                                    case 1 -> {
                                                        if (jButtons[j][k].getText().equals("2")) {
                                                            conta++;
                                                        }
                                                    }

                                                    case 2 -> {
                                                        if (jButtons[j][k].getText().equals("3")) {
                                                            conta++;
                                                        }
                                                    }

                                                    case 3 -> {
                                                        if (jButtons[j][k].getText().equals("4")) {
                                                            conta++;
                                                        }
                                                    }
                                                }
                                            }

                                            case 1 -> {
                                                switch (k) {

                                                    case 0 -> {
                                                        if (jButtons[j][k].getText().equals("5")) {
                                                            conta++;
                                                        }
                                                    }

                                                    case 1 -> {
                                                        if (jButtons[j][k].getText().equals("6")) {
                                                            conta++;
                                                        }
                                                    }

                                                    case 2 -> {
                                                        if (jButtons[j][k].getText().equals("7")) {
                                                            conta++;
                                                        }
                                                    }

                                                    case 3 -> {
                                                        if (jButtons[j][k].getText().equals("8")) {
                                                            conta++;
                                                        }
                                                    }
                                                }
                                            }

                                            case 2 -> {
                                                switch (k) {

                                                    case 0 -> {
                                                        if (jButtons[j][k].getText().equals("9")) {
                                                            conta++;
                                                        }
                                                    }

                                                    case 1 -> {
                                                        if (jButtons[j][k].getText().equals("10")) {
                                                            conta++;
                                                        }
                                                    }

                                                    case 2 -> {
                                                        if (jButtons[j][k].getText().equals("11")) {
                                                            conta++;
                                                        }
                                                    }

                                                    case 3 -> {
                                                        if (jButtons[j][k].getText().equals("12")) {
                                                            conta++;
                                                        }
                                                    }
                                                }
                                            }

                                            case 3 -> {
                                                switch (k) {

                                                    case 0 -> {
                                                        if (jButtons[j][k].getText().equals("13")) {
                                                            conta++;
                                                        }
                                                    }

                                                    case 1 -> {
                                                        if (jButtons[j][k].getText().equals("14")) {
                                                            conta++;
                                                        }
                                                    }

                                                    case 2 -> {
                                                        if (jButtons[j][k].getText().equals("15")) {
                                                            conta++;
                                                        }
                                                    }

                                                    case 3 -> {
                                                        if (jButtons[j][k].getText().isEmpty()) {
                                                            conta++;
                                                        }
                                                    }
                                                }
                                            }
                                        }

                                    }
                                }
                                if (conta == 16) {
                                    timer.stop();
                                    new Vittoria("Hai Vinto in " + Stimer.getText() + "Mosse:" + mosse);
                                    setVisible(false);
                                    new Start();
                                } else {
                                    conta = 0;
                                }
                            }
                        });
                } else {

                    jButtons[i][y] = new JButton("" + arrayList.get(n));
                    n++;
                    jButtons[i][y].setBackground(new Color(26, 117, 159));
                    jButtons[i][y].setForeground(new Color(242, 244, 243));
                    jButtons[i][y].setBorderPainted(false);
                    jButtons[i][y].addActionListener(e -> {

                        JButton button = (JButton) e.getSource();

                        int riga = -1, colonna = -1;
                        for (int j = 0; j < 4; j++) {
                            for (int k = 0; k < 4; k++) {
                                if (jButtons[j][k] == button) {
                                    riga = j;
                                    colonna = k;
                                    break;
                                }
                            }
                        }

                        if (IsVicino(riga, colonna)) {

                            timer.start();
                            mosse++;
                            Jmosse.setText("Mosse: " + mosse);
                            String temp = jButtons[riga][colonna].getText();
                            jButtons[riga][colonna].setText(jButtons[IVuoto][YVuoto].getText());
                            jButtons[IVuoto][YVuoto].setText(temp);
                            jButtons[IVuoto][YVuoto].setVisible(true);
                            jButtons[riga][colonna].setVisible(false);
                            IVuoto = riga;
                            YVuoto = colonna;
                            int conta = 0;

                            for (int j = 0; j < 4; j++) {
                                for (int k = 0; k < 4; k++) {

                                    switch (j) {

                                        case 0 -> {
                                            switch (k) {

                                                case 0 -> {
                                                    if (jButtons[j][k].getText().equals("1")) {
                                                        conta++;
                                                    }
                                                }

                                                case 1 -> {
                                                    if (jButtons[j][k].getText().equals("2")) {
                                                        conta++;
                                                    }
                                                }

                                                case 2 -> {
                                                    if (jButtons[j][k].getText().equals("3")) {
                                                        conta++;
                                                    }
                                                }

                                                case 3 -> {
                                                    if (jButtons[j][k].getText().equals("4")) {
                                                        conta++;
                                                    }
                                                }
                                            }
                                        }

                                        case 1 -> {
                                            switch (k) {

                                                case 0 -> {
                                                    if (jButtons[j][k].getText().equals("5")) {
                                                        conta++;
                                                    }
                                                }

                                                case 1 -> {
                                                    if (jButtons[j][k].getText().equals("6")) {
                                                        conta++;
                                                    }
                                                }

                                                case 2 -> {
                                                    if (jButtons[j][k].getText().equals("7")) {
                                                        conta++;
                                                    }
                                                }

                                                case 3 -> {
                                                    if (jButtons[j][k].getText().equals("8")) {
                                                        conta++;
                                                    }
                                                }
                                            }
                                        }

                                        case 2 -> {
                                            switch (k) {

                                                case 0 -> {
                                                    if (jButtons[j][k].getText().equals("9")) {
                                                        conta++;
                                                    }
                                                }

                                                case 1 -> {
                                                    if (jButtons[j][k].getText().equals("10")) {
                                                        conta++;
                                                    }
                                                }

                                                case 2 -> {
                                                    if (jButtons[j][k].getText().equals("11")) {
                                                        conta++;
                                                    }
                                                }

                                                case 3 -> {
                                                    if (jButtons[j][k].getText().equals("12")) {
                                                        conta++;
                                                    }
                                                }
                                            }
                                        }

                                        case 3 -> {
                                            switch (k) {

                                                case 0 -> {
                                                    if (jButtons[j][k].getText().equals("13")) {
                                                        conta++;
                                                    }
                                                }

                                                case 1 -> {
                                                    if (jButtons[j][k].getText().equals("14")) {
                                                        conta++;
                                                    }
                                                }

                                                case 2 -> {
                                                    if (jButtons[j][k].getText().equals("15")) {
                                                        conta++;
                                                    }
                                                }

                                                case 3 -> {
                                                    if (jButtons[j][k].getText().isEmpty()) {
                                                        conta++;
                                                    }
                                                }
                                            }
                                        }
                                    }

                                }
                            }
                            if (conta == 16) {
                                timer.stop();
                                new Vittoria("Hai Vinto in: " + Stimer.getText() + " Mosse:" + mosse);
                                setVisible(false);
                                new Start();
                            } else {
                                conta = 0;
                            }
                        }
                    });
                }
                center.add(jButtons[i][y]);
            }
        }

        c.add(nord, BorderLayout.NORTH);
        c.add(center, BorderLayout.CENTER);
        add(c);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public boolean IsVicino(int x, int y) {
        if (x < 0 || x >= 4 || y < 0 || y >= 4) {
            return false;
        }
        int dx = Math.abs(x - IVuoto);
        int dy = Math.abs(y - YVuoto);
        return (dx == 1 && dy == 0) || (dx == 0 && dy == 1);
    }
}