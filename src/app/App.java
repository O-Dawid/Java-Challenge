package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int numIslands(char[][] grid) {
        List<List<Integer>> list = new ArrayList<>();
        int count = 0;
        for(int i=0; i<grid.length;i++){
            //System.out.println(">Jestem w wierszu = " + i);
            for(int j=0; j<grid[i].length;j++){
                //System.out.println(">>Znak : " + j + " wiersz: "+i + " = "+grid[i][j]);
                if (grid[i][j]=='1'){
                    //System.out.println(">>>Znalazlem poczatek wyspy w punkcie: "+ i + ", "+j );
                    count++;
                    callBFS(grid,i,j,list);
                }
                //System.out.println(">>for2");
            }
            //System.out.println(">for1");
            
            
        }
        System.out.println(list.toString());
        return count;
    }
    
    public void callBFS(char[][]grid, int i, int j, List<List<Integer>> list){
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j]=='0'){
            //System.out.println(">>>>>kraniec");
            return;
        }
        list.add(Arrays.asList(i,j));
        if(grid[i][j]=='2'){
            
            System.out.println(list.toString());
            System.out.println(">>>>>CEL OSIĄGNIĘTY:     "+"Znak: "+j+" wiersz: "+i);
        }
        //System.out.println(">>>>Pętla BFS ----- Znak: "+j+" wiersz: "+i+" = "+grid[i][j]);
        
        grid[i][j]='0';
        //System.out.println(">>>>>BFSi+");
        callBFS(grid,i+1,j,list);
        //System.out.println(">>>>>BFSi-");
        callBFS(grid,i-1,j,list);
        //System.out.println(">>>>>BFSj-");
        callBFS(grid,i,j-1,list);
        //System.out.println(">>>>>BFSj+");
        callBFS(grid,i,j+1,list);
        list.remove(list.indexOf(Arrays.asList(i,j)));
        //System.out.println(">>>>>KONIEC PĘTLI: "+"Znak: "+j+" wiersz: "+i);
        
    }
}



public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");

        Solution solution = new Solution();
        char[][] grid = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','1','0'},
            {'0','0','0','2','0'}};
        solution.numIslands(grid);

    }
}