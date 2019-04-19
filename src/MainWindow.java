package AstarAlgorithm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainWindow extends JFrame {
    private JButton sbutton = new JButton("   简单应用 ");
    private JButton cbutton = new JButton("精灵王子找宝藏");

    public static void main(String[] args) throws Exception{

        MainWindow m = new MainWindow();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));//垂直布局

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.X_AXIS));
        buttonPanel.add(Box.createHorizontalStrut(50));
        buttonPanel.add(m.sbutton);
        buttonPanel.add(Box.createHorizontalStrut(80));
        buttonPanel.add(m.cbutton);

        panel.add(Box.createVerticalStrut(30));
        panel.add(buttonPanel);
        panel.add(Box.createVerticalStrut(30));
        m.setContentPane(panel);
        run(m,450,140);

        ActionListener sal = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //m.setVisible(false);
                new SimpleWindow();
            }
        };
        ActionListener cal = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //m.setVisible(false);
                new ComplexWindow();
            }
        };
        m.sbutton.addActionListener(sal);
        m.cbutton.addActionListener(cal);


    }
    public static void run(final JFrame f,final int width,final int heigth){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                f.setTitle(f.getClass().getSimpleName());
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setSize(width,heigth);
                f.setLocation(500,300);
                f.setVisible(true);
            }
        });
    }

}
