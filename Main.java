import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;

import static com.sun.javafx.font.LogicalFont.SANS_SERIF;

public class Main {
    private static int tempo = 10;
    public static void main(String[] args) {

        JFrame frame = new JFrame("Meu Primeiro java Desktop");
        frame.setSize(300,200);
        frame.setLayout(null);

        JPanel panel = new JPanel();
        //panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Você é rapido? ");
        label.setBounds(0, 0, 260, 30);

        JCheckBox checkBox = new JCheckBox("Sim");
        checkBox.setBounds(20, 60, 100, 30);

        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED){
                    Random random = new Random();
                    Dimension size = frame.getSize();
                    int newX = random.nextInt(size.width - checkBox.getWidth());
                    int newy = random.nextInt(size.height - checkBox.getHeight());
                    checkBox.setSelected(false);
                    checkBox.setLocation(newX,newy);
               }
            }
        });

        JLabel labelTimer = new JLabel(Integer.toString(tempo));
        labelTimer.setBounds(20, 100, 100, 30);
            Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tempo --;
                labelTimer.setText(Integer.toString(tempo));
                if (tempo == 0 ){
                    ((Timer) e.getSource()).stop();
                    label.setText("Eu acho que não em.!");
                    labelTimer.setVisible(false);
                    checkBox.setVisible(false);
                }
            }
        });
        frame.add(label);
        frame.add(checkBox);
        frame.add(labelTimer);
        //frame.add(panel);

        timer.start();
        frame.setVisible(true);

    }
}