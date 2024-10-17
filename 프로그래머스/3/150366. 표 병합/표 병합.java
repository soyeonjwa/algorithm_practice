import java.util.*;
import java.awt.Point;

class Solution {
    
    static int[][] parents = new int[51][51];
    static HashMap<Integer, Point> position = new HashMap<>();
    static String[][] values = new String[51][51];
    
    public ArrayList<String> solution(String[] commands) {
        ArrayList<String> answer = new ArrayList<>();
        
        for(int i=0;i<51;i++){
            for(int j=0;j<51;j++){
                if(j==0) continue;
                parents[i][j] = i*50+j;
                position.put(i*50+j, new Point(i,j));
                values[i][j] = "";
            }
        }
        for(int i=1;i<=4;i++){
            for(int j=1;j<=4;j++){
                System.out.print(parents[i][j]+" ");
            }
            System.out.println();
        }            System.out.println();

        
        for(String s : commands){
            System.out.println(s);
            StringTokenizer st = new StringTokenizer(s);
            
            String c = st.nextToken();
            if(c.equals("UPDATE")){
                if(st.countTokens()==2){
                    update2(st.nextToken(), st.nextToken());
                }
                else{
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    String v = st.nextToken();
                    
                    update1(x,y,v);
                }
            }
            else if(c.equals("MERGE")){
                int r1 = Integer.parseInt(st.nextToken());
                int c1 = Integer.parseInt(st.nextToken());
                int r2 = Integer.parseInt(st.nextToken());
                int c2 = Integer.parseInt(st.nextToken());
                merge(r1, c1, r2, c2);
            }
            else if(c.equals("UNMERGE")){
                int r1 = Integer.parseInt(st.nextToken());
                int c1 = Integer.parseInt(st.nextToken());
                unmerge(r1,c1);
            }
            else{
                int r1 = Integer.parseInt(st.nextToken());
                int c1 = Integer.parseInt(st.nextToken());
                int p = findParent(r1,c1);
                Point pp = position.get(p);
                
                if(values[pp.x][pp.y].equals("")){
                    answer.add("EMPTY");
                }
                else{
                    answer.add(values[pp.x][pp.y]);
                }
            }
            
        }
        

       

        return answer;
    }
    
    static int findParent(int i, int j){
        if(parents[i][j] == i*50+j) return parents[i][j];
        
        Point parent = position.get(parents[i][j]);
        return findParent(parent.x, parent.y);
    }
    
    static Point union(int r1, int c1, int r2, int c2){
        int x = findParent(r1, c1);
        int y = findParent(r2, c2);
        
        if(x==y) return new Point(x,y);
        
        Point xP = position.get(x);
        Point yP = position.get(y);
        Point ret;
        
        if(!values[xP.x][xP.y].equals("") && !values[yP.x][yP.y].equals("")){
            values[yP.x][yP.y] = "";
            parents[yP.x][yP.y] = x;
            ret = new Point(y, x);
        }
        else if(!values[xP.x][xP.y].equals("")){
            parents[yP.x][yP.y] = x;
            ret = new Point(y, x);
        }
        else if(!values[yP.x][yP.y].equals("")){
            parents[xP.x][xP.y] = y;
            ret = new Point(x, y);
        }
        else{
            if(x<y){
                parents[yP.x][yP.y] = x;
                 ret = new Point(y, x);
            }
            else{
                parents[xP.x][xP.y] = y;
                ret = new Point(x, y);
            }
        }
        
        return ret;
    }
    
    static void update1(int r, int c, String value){
        int root = findParent(r,c);
        Point rootP = position.get(root);
        
        values[rootP.x][rootP.y] = value;
    }
    
    static void update2(String value1, String value2){
        for(int i=1;i<=50;i++){
            for(int j=1;j<=50;j++){
                if(values[i][j].equals(value1)){
                    values[i][j] = value2;
                }
            }
        }
    }
    
    static void merge(int r1, int c1, int r2, int c2){
        Point change = union(r1, c1, r2, c2);
        
        if(change.x==change.y) return;
        
        for(int i=1;i<=50;i++){
            for(int j=1;j<=50;j++){
                if(change.x==parents[i][j]){
                    parents[i][j] = change.y;
                    values[i][j] = "";
                }
            }
        }
    }
    
    static void unmerge(int r, int c){
        int parent = findParent(r,c);
        Point parentP = position.get(parent);
        String value = values[parentP.x][parentP.y];
        
        for(int i=1;i<=50;i++){
            for(int j=1;j<=50;j++){
                if(findParent(i,j)==parent){
                    parents[i][j] = i*50+j;
                }
            }
        }
        
        values[parentP.x][parentP.y] = "";
        values[r][c] = value;
    }
}