package AstarAlgorithm;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class AstarAlgroithm {
    List<Point> openList = new ArrayList<>();
    List<Point> closeList = new ArrayList<>();
    List<Point> path = new ArrayList<>();
    int map[][];
    //String record[][];
    Point start;
    Point end ;
    AstarAlgroithm(int[][] p,int x1,int y1,int x2,int y2){
        this.map = new int[p.length][p[0].length];
        //this.record = new String[p.length][p[0].length];
        this.map = p.clone();
        this.start = new Point(x1,y1);
        this.end = new Point(x2,y2);
    }
    public List<Point> Astar(){  //find the path
        openList.add(start);
        Point cur_p = new Point();
        Point join_p;
        while(!openList.isEmpty()){  //
            cur_p = openList.get(0);
            closeList.add(cur_p);
            openList.remove(cur_p);
            if(cur_p.equals(end)){  //find the end point
                btStart(cur_p);
                return path;
            }
            // add the joint point to the openList
            if(cur_p.x -1 >= 0){  //上方有相邻点
                join_p = new Point(cur_p.x-1,cur_p.y);
                if(!closeList.contains(join_p) && map[join_p.x][join_p.y] !=-1){ //not in openList and walkable
                    join_p.parent = "S";
                    calPoint_F(join_p,end);  //F G H
                    if(openList.contains(join_p)){
                        if(openList.get(openList.indexOf(join_p)).G >= join_p.G){  //更优的选择替换
                            openList.set(openList.indexOf(join_p),join_p);
                        }
                    }else{
                        openList.add(join_p);
                    }

                }
                if(cur_p.y -1 >=0){ //左上方有
                    join_p = new Point(cur_p.x-1,cur_p.y-1);
                    if(!closeList.contains(join_p) && map[join_p.x][join_p.y] !=-1){ //not in openList and walkable
                        join_p.parent = "SE";
                        calPoint_F(join_p,end);  //F G H
                        if(openList.contains(join_p)){
                            if(openList.get(openList.indexOf(join_p)).G >= join_p.G){  //更优的选择替换
                                openList.set(openList.indexOf(join_p),join_p);
                            }
                        }else{
                            openList.add(join_p);
                        }
                    }
                }
                if(cur_p.y +1 <map[0].length){  //右上方有
                    join_p = new Point(cur_p.x-1,cur_p.y+1);
                    if(!closeList.contains(join_p) && map[join_p.x][join_p.y] !=-1){ //not in openList and walkable
                        join_p.parent = "SW";
                        calPoint_F(join_p,end);  //F G H
                        if(openList.contains(join_p)){
                            if(openList.get(openList.indexOf(join_p)).G >= join_p.G){  //更优的选择替换
                                openList.set(openList.indexOf(join_p),join_p);
                            }
                        }else{
                            openList.add(join_p);
                        }
                    }
                }
            }
            if(cur_p.x < map.length-1){ //下方有相邻点
                join_p = new Point(cur_p.x+1,cur_p.y);
                if(!closeList.contains(join_p) && map[join_p.x][join_p.y] !=-1){ //not in openList and walkable
                    join_p.parent = "N";
                    calPoint_F(join_p,end);  //F G H
                    if(openList.contains(join_p)){
                        if(openList.get(openList.indexOf(join_p)).G >= join_p.G){  //更优的选择替换
                            openList.set(openList.indexOf(join_p),join_p);
                        }
                    }else{
                        openList.add(join_p);
                    }
                }
                if(cur_p.y -1 >=0){ //左下方有
                    join_p = new Point(cur_p.x+1,cur_p.y-1);
                    if(!closeList.contains(join_p) && map[join_p.x][join_p.y] !=-1){ //not in openList and walkable
                        join_p.parent = "NE";
                        calPoint_F(join_p,end);  //F G H
                        if(openList.contains(join_p)){
                            if(openList.get(openList.indexOf(join_p)).G >= join_p.G){  //更优的选择替换
                                openList.set(openList.indexOf(join_p),join_p);
                            }
                        }else{
                            openList.add(join_p);
                        }
                    }
                }
                if(cur_p.y +1 <map[0].length){  //右下方有
                    join_p = new Point(cur_p.x+1,cur_p.y+1);
                    if(!closeList.contains(join_p) && map[join_p.x][join_p.y] !=-1){ //not in openList and walkable
                        join_p.parent = "NW";
                        calPoint_F(join_p,end);  //F G H
                        if(openList.contains(join_p)){
                            if(openList.get(openList.indexOf(join_p)).G >= join_p.G){  //更优的选择替换
                                openList.set(openList.indexOf(join_p),join_p);
                            }
                        }else{
                            openList.add(join_p);
                        }
                    }
                }
            }
            if(cur_p.y-1 >= 0){  //左边有相邻点
                join_p = new Point(cur_p.x,cur_p.y-1);
                if(!closeList.contains(join_p) && map[join_p.x][join_p.y] !=-1){ //not in openList and walkable
                    join_p.parent = "E";
                    calPoint_F(join_p,end);  //F G H
                    if(openList.contains(join_p)){
                        if(openList.get(openList.indexOf(join_p)).G >= join_p.G){  //更优的选择替换
                            openList.set(openList.indexOf(join_p),join_p);
                        }
                    }else{
                        openList.add(join_p);
                    }
                }
            }
            if(cur_p.y +1 <map[0].length){  //右边有相邻点
                join_p = new Point(cur_p.x,cur_p.y+1);
                if(!closeList.contains(join_p) && map[join_p.x][join_p.y] !=-1){ //not in openList and walkable
                    join_p.parent = "W";
                    calPoint_F(join_p,end);  //F G H
                    if(openList.contains(join_p)){
                        if(openList.get(openList.indexOf(join_p)).G >= join_p.G){  //更优的选择替换
                            openList.set(openList.indexOf(join_p),join_p);
                        }
                    }else{
                        openList.add(join_p);
                    }
                }
            }
            //openList中的point按F排序
            quickSortF(openList,0,openList.size()-1);
        }
        return path;
    }
    public void calPoint_F(Point p,Point end){  //calculate the F,G,H of a point
        int F = 0,G =0,H =0;
        if(p.parent.equals("N") || p.parent.equals("S")
                || p.parent.equals("W") || p.parent.equals("E")){
            G = 10 + map[p.x][p.y]*10 + findParent(p).G;  //移动代价 + 地形代价
        }else{
            G = 14 + map[p.x][p.y]*10 + findParent(p).G;
        }
        // Manhattan type to calculate H
        int x1 = p.x,y1 = p.y;
        int x2 = end.x ,y2 = end.y;
        if(x1 < x2){  //p在end的上方
            for(int i =x1; i<=x2; i++){
                H = H +10 +(map[i][y1] !=-1?map[i][y1] *10:0);
            }
            if(y1 < y2){  //p 在end的左上方
                for(int i=y1;i<=y2; i++){
                    H = H +10 + map[x2][i] !=-1? map[x2][i] *10 : 0;
                }
            }else{  //p 在end 的右上方
                for(int i= y1;i>=y2;i--){
                    H = H +10 + map[x2][i] !=-1? map[x2][i] *10 : 0;
                }
            }
        }else{  //p 在end的下方
            for(int i =x1; i >= x2; i--){
                H = H +10 +(map[i][y1] !=-1?map[i][y1] *10:0);
            }
            if(y1 < y2){  //p 在end的左上方
                for(int i=y1;i<=y2; i++){
                    H = H +10 +(map[x2][i] !=-1? map[x2][i] *10 : 0);
                }
            }else{  //p 在end 的右上方
                for(int i= y1;i>=y2;i--){
                    H = H +10 + (map[x2][i] !=-1? map[x2][i] *10 : 0);
                }
            }
        }
        p.G = G;
        p.H = H;
        p.F = G + H;
    }
    public void quickSortF(List<Point> list,int p,int r){
        if(p<r){
            int q = rand_partition(list,p,r);
            quickSortF(list,p,q);
            quickSortF(list,q+1,r);
        }
    }
    public int rand_partition(List<Point>list,int p,int r){
        int i =0;
        do{
            i= (int)(p+Math.random()*r);
        }while(i>=r);
        exchange(list,r,i);
        int x = list.get(r).F;
        i = p-1;
        for(int j=p;j<r;j++){
            if(list.get(j).F >= x){}
            else{
                i++;
                exchange(list,i,j);
            }

        }
        exchange(list,i+1,r);
        return i+1;
    }
    public void exchange(List<Point>list,int i,int j){
        //Collections.swap(Arrays.asList(A),i,j);
        Point t = list.get(i);
        list.set(i,list.get(j));
        list.set(j,t);
    }
    public void btStart(Point end){
        Point p = findParent(end);
        while (!p.equals(start)){
            //map[p.x][p.y] = 999;
            path.add(p);
            p = findParent(p);

        }
    }
    public Point findParent(Point p){
        int x=0,y=0;
        switch (p.parent){
            case "N":
                x = p.x -1;
                y = p.y;
                break;
            case "S":
                x = p.x +1;
                y = p.y;
                break;
            case "W":
                x = p.x;
                y = p.y -1;
                break;
            case "E":
                x = p.x;
                y = p.y +1;
                break;
            case "NW":
                x = p.x -1;
                y = p.y -1;
                break;
            case "NE":
                x = p.x -1;
                y = p.y +1;
                break;
            case "SW":
                x = p.x +1;
                y = p.y -1;
                break;
            case "SE":
                x = p.x +1;
                y = p.y +1;
                break;
            default:
                break;
        }
        return closeList.get(closeList.indexOf(new Point(x,y)));
    }
}
