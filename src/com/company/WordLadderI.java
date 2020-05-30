package com.company;

import java.util.*;

public class WordLadderI {

    public class WordNode {

        String word;
        int numOfSteps;

        public WordNode(String word, int numOfSteps) {
            this.word = word;
            this.numOfSteps = numOfSteps;
        }
    }

    public int solve(String A, String B, ArrayList<String> C) {

        Queue<WordNode> myque = new LinkedList<>();
        WordNode node = new WordNode(A,1);
        myque.add(node);
        C.add(B);
        Set<String > myset= new HashSet<>(C);

        while (!myque.isEmpty()) {
            WordNode original = myque.poll();

            if (original.word.equals(B))
                return original.numOfSteps;

            char[] arr = original.word.toCharArray();

            for (int i = 0; i < arr.length; i++) {

                for (char j = 'a'; j <= 'z'; j++) {
                    char temp = arr[i];
                    if (arr[i] != j)
                        arr[i] = j;
                    String newword= new String(arr);
                    if (myset.contains(newword)) {
                        myque.add(new WordNode(newword,original.numOfSteps+1));
                        myset.remove(newword);
                    }
                    arr[i]=temp;
                }
            }
        }
      return 0;
    }
}
