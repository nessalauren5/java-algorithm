package Tetris;

import java.util.Comparator;

public class Location {
    int row;
    int col;

    public Location(int x, int y){
        row=x;
        col=y;
    }

    @Override
    public boolean equals(Object ob){
    Location l = (Location) ob;
    return l.row==this.row && l.col==this.col;
    }
}
