package com.company;

import java.util.*;

public class WordLadderII {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, ArrayList<String> dictV) {
        ArrayList<String> dict=new ArrayList<>();
        for(int i=0;i<dictV.size();i++)
        {
            String test=dictV.get(i);
            if(dict.contains(test)==false)
                dict.add(test);
        }
        ArrayList<ArrayList<String>> ans=new ArrayList<>();
        Queue<ArrayList<String>> q=new LinkedList<>();
        ArrayList<String> init=new ArrayList<>();
        init.add(start);
        q.add(init);

        while(!q.isEmpty())
        {
            init=q.poll();
            String test=init.get(init.size()-1);
            if(test.equals(end))
            {
                if(!ans.contains(init))
                    ans.add(init);
                continue;
            }
            if(isValid(test,end))
            {
                init.add(end);
                if(!ans.contains(init))
                    ans.add(init);
                continue;
            }
            for(int i=0;i<dict.size();i++)
            {
                if(isValid(test,dict.get(i)) && !init.contains(dict.get(i)))
                {
                    ArrayList<String> n=new ArrayList<>(init);
                    n.add(dict.get(i));
                    q.add(n);
                }
            }
        }
        int minLength=Integer.MAX_VALUE;
        for(int i=0;i<ans.size();i++)
            minLength=Math.min(minLength,ans.get(i).size());
        for(int i=ans.size()-1;i>=0;i--)
        {
            if(ans.get(i).size()!=minLength)
                ans.remove(i);
        }
        return ans;
    }

    private boolean isValid(String a, String b)
    {
        int count=0;
        for(int i=0;i<a.length();i++)
            if(a.charAt(i)!=b.charAt(i))
                count++;
        if(count==1)
            return true;

        return false;
    }
}
