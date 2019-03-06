package Tetris;

import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Tetrimono {

    Pattern pattern;
    public Set<Point> locs = new HashSet<>();

    public Tetrimono(Pattern p){
        this.pattern = p;
        locs.addAll(Arrays.asList(Pattern.patterns[p.type.ordinal()]));
    }

    public Tetrimono() {

    }

    public static Tetrimono generateRandomPiece() {
        int type = randomIndex();


       // Pattern p = Pattern.patterns[randomIndex()];
        return new Tetrimono();
    }

    private static int randomIndex() {
        Random random = new Random();
        return random.nextInt(7);
    }

    public boolean equals(Object o){
        Tetrimono bp = (Tetrimono)o;
        return this.locs.equals(bp.locs);
    }

    public boolean moveBlock(Move move){

        if(move == Move.LEFT){
            //decrease column
            for(Point p : locs){
                p.translate(0,-1);
            }
        }
        else if(move == Move.RIGHT){
            //increase column
            for(Point p : locs){
                p.translate(0,1);
            }
        }
        else if(move == Move.DOWN){
            //increase row
            for(Point p : locs){
                p.translate(1,0);
            }
        }
        else if(move == Move.R90){
            //rotate this block 90 degrees
            for(Point p : locs){
                p.translate(0,-1);
            }
        }
        return true;
    }
}
