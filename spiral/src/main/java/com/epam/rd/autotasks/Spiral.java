package com.epam.rd.autotasks;

class Spiral {
    static int[][] spiral(int rows, int columns) {
        int[][] res = new int[rows][columns];

        int round = 0;
        int maxRound = (int)Math.ceil(columns/2.0);
        int currentNum = 1;

        while(round < maxRound){

            // upper for
            for(int i = round; i < columns - round; i++){
                res[round][i] = currentNum++;
            }

            // right for
            for(int i = round + 1; i < rows - round - 1; i++){
                res[i][columns - round - 1] = currentNum++;
            }

            if (rows - round - 1 == round) break;

            // bottom for
            for(int i = columns - round - 1; i >= round; i--){
                res[rows - round - 1][i] = currentNum++;
            }

            // left for
            for(int i = rows - round - 2; i > round; i--){
                res[i][round] = currentNum++;
            }

            round++;
        }

        return res;
    }
}
