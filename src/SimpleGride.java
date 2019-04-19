package AstarAlgorithm;

import javax.swing.*;
import java.awt.*;

public class SimpleGride extends JPanel {
    private int width,heigth;
    private int cellWidth;
    private int[][] map= {
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},

            {0,0,0,0,0,0,-1,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,-1,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,-1,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,-1,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,-1,-1,0,0,0,0,0,0,0,0},

            {0,0,0,0,0,0,0,0,-1,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,-1,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},

    };
    SimpleGride(int w,int h,int cell){
        this.width = w;
        this.heigth = h;
        this.cellWidth = cell;
    }
    public void paint(Graphics g){
        int row = (int)(heigth/cellWidth);
        for(int i=0;i<=row;i++){
            g.drawLine(0,i*cellWidth,width,i*cellWidth);

        }
        int column = (int)(width/cellWidth);
        for(int i=0;i<=column;i++){
            g.drawLine(i*cellWidth,0,i*cellWidth,heigth);
        }
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                if(map[i][j] == -1){
                    g.setColor(Color.gray);
                    g.fillRect(j*cellWidth,i*cellWidth,cellWidth,cellWidth);
                    g.setColor(Color.black);
                    g.drawRect(j*cellWidth,i*cellWidth,cellWidth,cellWidth);

                }
            }
        }
        //start point
        g.setColor(Color.green);
        g.drawRect(3*cellWidth,8*cellWidth,cellWidth,cellWidth);
        //end point
        g.setColor(Color.red);
        g.drawRect(14*cellWidth,9*cellWidth,cellWidth,cellWidth);


        AstarAlgroithm as = new AstarAlgroithm(map,8,3,9,14);
        System.out.println("开始A*算法：");
        long start = System.currentTimeMillis();
        //
        java.util.List<Point> path = as.Astar();
        //
        long end = System.currentTimeMillis();
        System.out.println("结束A*算法.用时："+(end-start)+"ms");
        for(Point p :path){
            g.setColor(Color.green);
            g.fillRect(p.y*cellWidth,p.x*cellWidth,cellWidth,cellWidth);
            g.setColor(Color.black);
            g.drawRect(p.y*cellWidth,p.x*cellWidth,cellWidth,cellWidth);
        }
    }
}
