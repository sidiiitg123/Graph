package com.company;

import java.util.ArrayList;

public class WordBoardSearch {


    public int exist(ArrayList<String> A, String B) {

        int row = A.size();
        int col = A.get(0).length();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (search(i, j, 0, B, A) && A.get(i).charAt(j) == B.charAt(0)) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public Boolean search(int i, int j, int index, String B, ArrayList<String> A) {

        if (B.length() == index)
            return true;

        if (i < 0 || i >= A.size() || j < 0 || j >= A.get(0).length() || B.charAt(index) != A.get(i).charAt(j)) {
            return false;
        }

        if (search(i - 1, j, index + 1, B, A) ||
                search(i + 1, j, index + 1, B, A) ||
                search(i, j - 1, index + 1, B, A) ||
                search(i, j + 1, index + 1, B, A)) {
            return true;
        }
        return false;
    }
}
