package com.company;

import java.util.ArrayList;

public class CaptureRegionsOnBoard {

    void dfs(ArrayList<ArrayList<Character>> a,int i,int j,char x,char y)
    {
        if(i<0||j<0||i>=a.size()||j>=a.get(i).size()) return;
        if(a.get(i).get(j)!=x) return;
        a.get(i).set(j,y);
        dfs(a,i+1,j,x,y);
        dfs(a,i-1,j,x,y);
        dfs(a,i,j-1,x,y);
        dfs(a,i,j+1,x,y);

    }
    public void solve(ArrayList<ArrayList<Character>> a) {

        int m=a.size();
        int n=a.get(0).size();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(a.get(i).get(j)=='O')
                    a.get(i).set(j,'-');
            }
        }
        for(int i=0;i<n;i++)
        {
            if(a.get(0).get(i)=='-')
            {
                dfs(a,0,i,'-','O');
            }
        }
        for(int i=0;i<n;i++)
        {
            if(a.get(m-1).get(i)=='-')
            {
                dfs(a,m-1,i,'-','O');
            }
        }
        for(int i=0;i<m;i++)
        {
            if(a.get(i).get(0)=='-')
            {
                dfs(a,i,0,'-','O');
            }
        }
        for(int i=0;i<m;i++)
        {
            if(a.get(i).get(n-1)=='-')
            {
                dfs(a,i,n-1,'-','O');
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(a.get(i).get(j)=='-')
                    a.get(i).set(j,'X');
            }
        }
    }
}
