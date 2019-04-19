package AstarAlgorithm;

import java.util.Objects;

public class Point {
    int x,y;
    int F = 0; //F = G + H
    int G = 0;
    int H = 0;
    //G=移动代价+地形代价   H=Manhattan移动代价+Manhattan地形代价
    String parent = null;
    public Point(){}
    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "（" +
                "x=" + x +
                ", y=" + y +
                '）';
    }
}
