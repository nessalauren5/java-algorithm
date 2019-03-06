package Tetris;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pattern {


    Set<Point> locations = new HashSet<>();
    public PatternType type;
    public static final int NUM_PIECES = 7;
    public Pattern(PatternType p){
        this.type = p;
    }

    private static Point[] square = new Point[]{
        new Point(0, 0) ,new Point(0,1),new Point(1,0),new Point(1,1)};

    private static Point[] halft = new Point[]{
            new Point(1,0),new Point(0,1),new Point(1,1), new Point(1,2)
    };

    private static Point[] hbar = new Point[]{
            new Point(0,1),new Point(0,2),new Point(0,3), new Point(0,4)
    };

    private static Point[] vbar = new Point[]{
            new Point(0,0),new Point(1,0),new Point(3,0), new Point(4,0)
    };

    private static Point[] lbar = new Point[]{
            new Point(0,0),new Point(1,0),new Point(2,0), new Point(3,0),new Point(3,1)
    };

    private static Point[] snakeleft = new Point[]{
        new Point(0,1), new Point(0,2),  new Point(1,0), new Point(1,1)};

    private static Point[] snakeright = new Point[]{
            new Point(0,0), new Point(0,1),  new Point(1,1), new Point(1,2)};

    public static Point[][] patterns = new Point[][]{square,halft,hbar,vbar,lbar,snakeleft,snakeright};

    public enum PatternType {
        SQUARE, HALFT, HBAR, VBAR, RIGHTL, SNAKELEFT,SNAKERIGHT;

    }


}
