package AstarAlgorithm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

public class ComplexWindow extends JFrame {
    JPanel leftpanel = new JPanel();
    JPanel rightpanle = new JPanel();
    JTextArea timetext = new JTextArea("\t算法运行结果显示\n\n\n");
    JTextField startText = new JTextField("10,4",10);
    JTextField endText = new JTextField("0,35",10);

    ComplexFirstGride firstGride;
    ComplexGride gride;
    ComplexWindow(){
        setTitle("complexWindow");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocation(200,130);
        setSize(1000,480);
        setVisible(true);

        createLeftPanel();
        createRightPanel();
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        panel.add(leftpanel,BorderLayout.CENTER);
        panel.add(rightpanle,BorderLayout.EAST);
        setContentPane(panel);
    }
    public void createLeftPanel(){  //显示地图
        leftpanel.setLayout(new BoxLayout(leftpanel,BoxLayout.Y_AXIS));
        leftpanel.add(Box.createVerticalStrut(10));
        firstGride = new ComplexFirstGride(map,800,400,20);
        leftpanel.add(firstGride);
        leftpanel.add(Box.createVerticalStrut(10));
    }
    public void createRightPanel(){  //显示数据

        rightpanle.setLayout(new BorderLayout());
        JLabel start_label = new JLabel("起点(x,y)：");
        start_label.setFont(new Font("谐体",Font.BOLD|Font.ITALIC,12));
        start_label.setAlignmentY(Component.TOP_ALIGNMENT);
        start_label.setBorder(BorderFactory.createEmptyBorder(4,5,0,5));
        startText.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,18));


        JLabel end_label = new JLabel("终点(x,y)：");
        end_label.setFont(new Font("谐体",Font.BOLD|Font.ITALIC,12));
        end_label.setAlignmentY(Component.TOP_ALIGNMENT);
        end_label.setBorder(BorderFactory.createEmptyBorder(4,5,0,5));
        endText.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,18));

        JButton startButton = new JButton("开始");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String startPoint = startText.getText();
                String endPoint = endText.getText();
                if(startPoint ==null|| endPoint ==null){
                    JOptionPane.showMessageDialog(null,"没有输入",
                            "Waring",JOptionPane.ERROR_MESSAGE);
                }else{
                    String[] startp = startPoint.split(",");
                    String[] endp = endPoint.split(",");
                    int x1 = Integer.parseInt(startp[0]);
                    int y1 = Integer.parseInt(startp[1]);
                    int x2 = Integer.parseInt(endp[0]);
                    int y2 = Integer.parseInt(endp[1]);
                    if(map[x1][y1] ==-1 ){
                        JOptionPane.showMessageDialog(null,"起点为墙",
                                "Waring",JOptionPane.ERROR_MESSAGE);
                    }else if(map[x2][y2] ==-1){
                        JOptionPane.showMessageDialog(null,"终点为墙",
                                "Waring",JOptionPane.ERROR_MESSAGE);
                    }else{
                        Point start_point = new Point(x1,y1);
                        Point end_point = new Point(x2,y2);

                        AstarAlgroithm as = new AstarAlgroithm(map,x1,y1,x2,y2);

                        long start = System.currentTimeMillis();
                        //
                        java.util.List<Point> path = as.Astar();
                        //
                        long end = System.currentTimeMillis();
                        gride = new ComplexGride(map,800,400,20,start_point,end_point,path);
                        leftpanel.removeAll();
                        leftpanel.add(Box.createVerticalStrut(10));
                        //firstGride = new ComplexFirstGride(map,800,400,20);
                        leftpanel.add(gride);
                        leftpanel.add(Box.createVerticalStrut(10));
                        leftpanel.updateUI();
                        leftpanel.repaint();
                        timetext.setText("\t算法运行结果显示\n\n\n");
                        timetext.append("  起点为:"+start_point.toString()+"\n\n");
                        timetext.append("  终点为："+end_point.toString()+"\n\n");
                        timetext.append("  运行A*算法花费时间："+String.valueOf(end-start)+"ms");

                        System.out.println(x1);
                    }

                }



            }
        });

        JPanel north = new JPanel();
        north.setLayout(new GridLayout(3,2,2,20));

        north.add(start_label);
        north.add(startText);
        north.add(end_label);
        north.add(endText);
        north.add(startButton);


        timetext.setFont(new Font("宋体",Font.ITALIC,16));
        timetext.setForeground(Color.BLUE);
        timetext.setEnabled(false);
        //timetext.setLineWrap(true);
        JPanel textPanel = new JPanel();
        textPanel.add(timetext,BorderLayout.CENTER);

        rightpanle.add(north,BorderLayout.NORTH);
        rightpanle.add(timetext,BorderLayout.CENTER);

    }

    private int[][] map = {
            {0,0,0,-1,0,0,0,-1,0,0,0,0,-1,0,0,0,0,0,0,0,0,0,0,0,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4},
            {0,0,0,0,0,0,0,-1,0,0,0,0,-1,0,0,0,0,0,0,0,0,0,0,0,0,4,4,4,4,4,4,4,4,4,2,4,4,4,4,4},
            {-1,-1,-1,-1,-1,-1,0,-1,-1,-1,-1,0,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,4,4,4,4,4,4,4,2,4,4,4,4,4,4},
            {0,0,0,0,0,0,0,0,-1,0,0,0,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,4,4,4,4,4,4,2,4,4,4,4,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,4,4,4,4,4,4,4,2,4,4,0,0,0,0},

            {0,0,0,0,0,0,0,-1,-1,0,0,0,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,4,4,4,4,4,2,2,0,0,0,0,0},
            {0,0,-1,-1,-1,-1,-1,-1,0,0,0,0,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,4,4,4,4,4,2,2,0,0,0,0,0},
            {0,0,-1,0,0,-1,0,-1,0,0,0,0,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,4,4,4,2,2,2,-1,0,0,0},
            {0,0,0,0,0,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,0,0,0,0},
            {0,0,0,0,0,-1,0,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,0,-1,0,0,0},

            {0,0,-1,0,0,-1,0,-1,-1,0,0,0,0,0,0,0,0,0,0,-1,-1,-1,0,0,0,0,0,0,-1,0,0,0,2,2,0,2,2,0,0,0},
            {0,0,-1,-1,-1,-1,0,0,-1,0,0,0,0,0,0,0,0,0,0,-1,-1,-1,0,0,0,0,0,0,0,0,0,-1,2,0,2,2,0,0,0,0},
            {0,0,0,-1,0,0,0,0,-1,0,0,0,-1,0,0,0,0,0,0,-1,-1,-1,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0,0,0,0},
            {0,0,0,-1,0,0,0,0,-1,-1,0,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,2,2,2,0,0,0,0,0},
            {0,0,0,-1,0,0,0,0,-1,0,0,0,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,0,0,0,0,0},

            {0,0,0,-1,-1,-1,-1,-1,-1,0,0,0,-1,0,0,0,0,0,0,0,0,0,0,0,-1,-1,0,0,0,0,0,2,2,2,0,0,0,0,0,0},
            {0,0,0,-1,0,0,0,0,0,0,0,0,-1,0,0,0,0,0,0,0,0,0,0,0,-1,-1,0,0,0,0,0,2,2,2,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,-1,0,0,0,0,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,0,0,0,0,0,0,0},
            {0,0,0,-1,0,0,0,-1,0,0,0,0,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,0,0,0,0,0,0,0,0},
            {0,0,0,-1,0,0,0,-1,0,0,0,0,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,0,0,0,0,0,0,0,0,0}
    };
}
