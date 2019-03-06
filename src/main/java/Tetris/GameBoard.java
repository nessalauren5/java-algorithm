package Tetris;

import java.util.Arrays;
import java.util.Scanner;

public class GameBoard {
    char[][] board;
    int length = 0;
    boolean boardIsFull = false;
    int numEmptySpace  = 0;
    private Scanner sc = new Scanner(System.in);

    public GameBoard(int size){

        board = new char[size][size];
        length=size;
        numEmptySpace=size*size;
        for(char[] row : board) {
            Arrays.fill(row, '_');
        }
        System.out.println("************* WELCOME TO TETRIS *************");
    }

    public void play()throws InterruptedException{


        while(!boardIsFull) {
            print();
            addPiece();
        }


    }
    public void addPiece()throws InterruptedException{
        Tetrimono bp = Tetrimono.generateRandomPiece();
        //find middle for new piece
        int firstRowLength = bp.blocks[0].length;
        int middle = (length-firstRowLength)/2;
        bp.row=0;
        bp.col=middle;
        if(checkForSpace(bp)){
            updateGameBoard(bp);
        }
        else{
            boardIsFull=true;
            return;
        }

        boolean falling=true;

        while(falling){
            print();
            Thread.sleep(1000);
            falling=lowerPiece(bp);
           //movePiece(bp,sc.next());
        }
    }

    public void movePiece(Tetrimono bp, String move){
        switch(move.toUpperCase()){
            case "R":
                bp.col++;
                break;
            case "L":
                bp.col--;
                break;
            case "D":
                bp.row++;
                break;
        }
        updateGameBoard(bp);
        print();
    }
    public void removeOldPieces(Tetrimono bp, int row){
        if(row>=0) {
            for (int i = 0; i < bp.width; i++) {
                board[row][i+bp.col] = '_';
            }
        }
    }
    public void updateGameBoard(Tetrimono bp){
        removeOldPieces(bp,bp.row-1);
        for(int r=0;r<=bp.height;r++) {
            for (int c= 0; c < bp.width; c++) {

                board[r+bp.row][c + bp.col] = bp.blocks[r][c];
            }
        }
    }

    public boolean lowerPiece(Tetrimono bp)
    {
        bp.row++;
        if(checkForSpace(bp)){
            updateGameBoard(bp);
            return true;
        }else{
            return false;
        }

    }

    public boolean checkForSpace(Tetrimono bp){

        int nextRow = bp.row+bp.height;
        if(nextRow<length) {
            for (int i = 0; i < bp.width; i++) {
                if (board[nextRow][i+bp.col] != '_' && bp.blocks[bp.height][i]!='_') {
                    return false;
                }
            }
            return true;
        }
        return false;
    }



    public void print(){

        for(char[] row : board){
            for(char c : row){
                System.out.print("|"+c + "");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("**************************************");
    }

}
