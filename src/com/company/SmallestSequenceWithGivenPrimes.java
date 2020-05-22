package com.company;

import java.util.*;

public class SmallestSequenceWithGivenPrimes {

    public ArrayList<Integer> solve(int A, int B, int C, int D) {

        ArrayList<Integer> output = new ArrayList<>(D);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashSet<Integer> hs = new HashSet<>();

        int[] arr = new int[3];
        arr[0] = A;
        arr[1] = B;
        arr[2] = C;

        Arrays.sort(arr);

        pq.add(A);
        pq.add(B);
        pq.add(C);

        hs.add(A);
        hs.add(B);
        hs.add(C);

        int lowestnum = 0;

        while (output.size() < D) {

            int current = pq.poll();

            if (current > lowestnum) {
                output.add(current);
                lowestnum = current;
            }
            for (int i=0;i<arr.length;i++ ) {
                int newno = current * arr[i];

                if(!pq.contains(newno)){
                    pq.add(newno);
                    hs.add(newno);
                }
            }
        }
        return output;
    }
}
