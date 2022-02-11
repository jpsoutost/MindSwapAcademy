package academy.mindswap.field;

public class Position {
    int col;
    int row;

    public Position (int col, int row){
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    @Override
    public boolean equals(Object position) {
        if (this == position) return true;
        if (!(position instanceof Position)) return false;
        Position p = (Position) position;
        return col == p.getCol() && row == p.getRow();
    }
}
