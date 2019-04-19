package AstarAlgorithm;

import javax.swing.*;
import java.awt.*;

public class ComplexFirstGride extends JPanel {
    private int width,heigth;
    private int cellWidth;
    private int[][] map;
    ComplexFirstGride(int[][] m,int w, int h, int cell){
        this.map = new int[m.length][m[0].length];
        for(int i=0;i<m.length;i++){
            this.map[i] = m[i].clone();
        }

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

    }

}
