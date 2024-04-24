package puzzle.model;

public record Position(int row, int col) {
    //elorejelzi a lepes helyzetet mozgas eseteb
    public Position move(Direction direction){
        return new Position(direction.getRowChange(), direction.getColChange());
    }

    public Position moveUp(){
        return null;
    }
    public Position moveRight(){
        return null;
    }
    public Position moveDown(){
        return null;
    }
    public Position moveLeft(){
        return null;
    }
    @Override
    public String toString() {
        return String.format("(%d, %d)",row ,col);
    }

}
