package puzzle.model;

public enum Direction {
    UP(-1,0),
    RIGHT(0, 1),
    DOWN(1, 0),
    LEFT(0, -1);
    private int rowChange;
    private int colChange;

    private Direction(int rowChange, int colChange) {
        this.rowChange = rowChange;
        this.colChange = colChange;
    }

    public int getRowChange() {
        return rowChange;
    }

    public int getColChange() {
        return colChange;
    }

    public static Direction of(int rowChange, int colChange){
        for(var direction: values()) {
            if(direction.getRowChange() == rowChange && direction.getColChange() == colChange){
                return direction;
            }
        }
    }

}
