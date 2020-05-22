package com.company;

import java.util.ArrayList;

public class BlackShapes {
    public int black(ArrayList<String> A) {

        if(A.size() == 0){
            return 0;
        }
        int row=A.size();
        int col=A.get(0).length();
        int[][] check=new int[row][col];
        Boolean[][] visited=new Boolean[row][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                check[i][j]=0;
                visited[i][j]=false;
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(A.get(i).charAt(j)=='X'){
                    check[i][j]=1;
                }
            }
        }
           int count=0;

        for(int i=0;i<row;i++){
            for(int j=0;j<A.get(i).length();j++){
                if(A.get(i).charAt(j)=='X' && !visited[i][j]){
                    dfs(A,i,j,check,visited);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(ArrayList<String> A,int i,int j,int[][] check,Boolean[][] visited){

        if(i<0 || i>=A.size())
            return;
        if(j<0 || j>=A.get(0).length())
            return;
        if(visited[i][j] || check[i][j]==0)
            return;

        visited[i][j]=true;

        dfs(A,i-1,j,check,visited);
        dfs(A,i+1,j,check,visited);
        dfs(A,i,j-1,check,visited);
        dfs(A,i,j+1,check,visited);
    }
}
