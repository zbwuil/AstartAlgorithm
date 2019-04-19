package AstarAlgorithm;

import jdk.jshell.execution.Util;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ComplexGride extends JPanel {
    private int width,heigth;
    private int cellWidth;
    private int[][] map;
    private Point start_point;
    private Point end_point;
    private java.util.List<Point> path = new ArrayList<>();
    ComplexGride(int[][]m, int w,int h,int cell,Point s,Point e,java.util.List<Point> p){
        this.map = new int[m.length][m[0].length];
        for(int i=0;i<m.length;i++){
            this.map[i] = m[i].clone();
        }
        this.width = w;
        this.heigth = h;
        this.cellWidth = cell;
        this.start_point = new Point(s.x,s.y);
        this.end_point = new Point(e.x,e.y);
        this.path.addAll(p);
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
                if(map[i][j] ==2){
                    g.setColor(Color.blue);
                    g.fillRect(j*cellWidth,i*cellWidth,cellWidth,cellWidth);
                    g.setColor(Color.black);
                    g.drawRect(j*cellWidth,i*cellWidth,cellWidth,cellWidth);
                }
                if(map[i][j] ==4){
                    g.setColor(Color.yellow);
                    g.fillRect(j*cellWidth,i*cellWidth,cellWidth,cellWidth);
                    g.setColor(Color.black);
                    g.drawRect(j*cellWidth,i*cellWidth,cellWidth,cellWidth);
                }
            }
        }
            //start point
        g.setColor(Color.green);
        g.drawRect(start_point.y*cellWidth,start_point.x*cellWidth,cellWidth,cellWidth);
            //end point
        g.setColor(Color.red);
        g.drawRect(end_point.y*cellWidth,end_point.x*cellWidth,cellWidth,cellWidth);

        for(Point p :path){
            g.setColor(Color.green);
            g.fillRect(p.y*cellWidth,p.x*cellWidth,cellWidth,cellWidth);
            g.setColor(Color.black);
            g.drawRect(p.y*cellWidth,p.x*cellWidth,cellWidth,cellWidth);
        }
    }
}
