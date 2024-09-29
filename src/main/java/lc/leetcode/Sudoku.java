package lc.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Sudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i<9 ; i++){
            Set<Character> checkTableCol = new HashSet<>();
            Set<Character> checkTableRow = new HashSet<>();

            for (int j = 0 ; j<9 ; j++){
                if (board[i][j]!='.'){
                    if (checkTableCol.contains(board[i][j])){
                        return false;
                    }else {
                        checkTableCol.add(board[i][j]);
                    }
                }
                if (board[j][i]!='.'){
                    if (checkTableRow.contains(board[j][i])){
                        return false;
                    }else {
                        checkTableRow.add(board[j][i]);
                    }
                }

            }
        }
        int level =0;
        Set<Character> checkTable = new HashSet<>();
        Set<Character> checkTable1 = new HashSet<>();
        Set<Character> checkTable2 = new HashSet<>();

        while (level<3){
            checkTable = new HashSet<>();
            checkTable1 = new HashSet<>();
            checkTable2 = new HashSet<>();
            for (int m=level*3; m<level*3+3;m++){

                for (int n=0; n<3;n++){
                    if (board[m][n]!='.'){
                        if (checkTable.contains(board[m][n])){
                            return false;
                        }else {
                            checkTable.add(board[m][n]);
                        }
                    }
                }
                for (int n=3; n<6;n++){
                    if (board[m][n]!='.'){
                        if (checkTable1.contains(board[m][n])){
                            return false;
                        }else {
                            checkTable1.add(board[m][n]);
                        }
                    }
                }
                for (int n=6; n<9;n++){
                    if (board[m][n]!='.'){
                        if (checkTable2.contains(board[m][n])){
                            return false;
                        }else {
                            checkTable2.add(board[m][n]);
                        }
                    }
                }
            }
            level++;
        }
        return true;


    }

    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        char[][] board  =
                      {{'.','.','.','.','5','.','.','1','.'},
                       {'.','4','.','3','.','.','.','.','.'},
                       {'.','.','.','.','.','3','.','.','1'},
                       {'8','.','.','.','.','.','.','2','.'},
                       {'.','.','2','.','7','.','.','.','.'},
                       {'.','1','5','.','.','.','.','.','.'},
                       {'.','.','.','.','.','2','.','.','.'},
                       {'.','2','.','9','.','.','.','.','.'},
                       {'.','.','4','.','.','.','.','.','.'}};
        System.out.println(sudoku.isValidSudoku(board));
    }

}
