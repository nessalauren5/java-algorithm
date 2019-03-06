package Tetris;

import javafx.geometry.Point2D;

public class PatternOld {

    public PatternType type;

    public PatternOld(int t){

        type = PatternType.values()[t];
    }
    public char[][] getPattern(){
        switch(this.type){
            case SQUARE: return SQUARE;
            case BAR: return BAR;
            case L: return L;
            case HALFT: return HALFT;
            case SNAKE: return SNAKE;
            default: type=PatternType.HALFT; return HALFT;
        }
    }
    public final char[][] SQUARE = {{'*','*'},
                                    {'*','*'}};

    public final char[][] HALFT = {{'_','*','_'},
                                   {'*','*','*'}};

    public final char[][] BAR = {{'*','*','*','*'}};

    public final char[][] L = {{'*','*','*'},
                               {'_','_','*'}};

    public final char[][] SNAKE = {{'_','*','*'},
                                   {'*','*','_'}};


    public enum PatternType{
        SQUARE (0),HALFT(1),BAR(2),L(3),SNAKE(4);

        private int code;

        PatternType(int c){
            this.code = c;
        }
    }
}
