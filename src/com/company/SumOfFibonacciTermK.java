package com.company;

import java.util.ArrayList;

public class SumOfFibonacciTermK {

    public int fibsum(int A) {

        ArrayList<Integer> myarray = new ArrayList<>();

        myarray.add(0);
        myarray.add(1);
        myarray.add(1);

        int next = 0, i = 3;

        while (true) {
            next = myarray.get(i - 1) + myarray.get(i - 2);
            if (next <= A) {
                myarray.add(next);
                i++;
            }else
                break;
        }

        int count=0;
        int oldno=0;
        for(int j=myarray.size()-1;j>=0;){
            int newno=0;
            if(A==0)
                break;
            if(A>=myarray.get(j))
            {
                newno=myarray.get(j);
                if(newno!=oldno){
                    count++;
                    oldno=newno;
                }
                A=A-myarray.get(j);
            }
            else{
                j--;
            }
        }
        return count;
    }
}