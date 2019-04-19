package AstarAlgorithm;

import javax.swing.*;

public class SimpleWindow extends JFrame {
    SimpleWindow(){
        setTitle("simpleWindow");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocation(520,200);
        setSize(400,400);
        setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.add(Box.createVerticalStrut(10));
        panel.add(new SimpleGride(340,280,20));
        setContentPane(panel);
    }
}
