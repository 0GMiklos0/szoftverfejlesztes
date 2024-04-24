package puzzle.model;

import java.util.StringJoiner;

public class PuzzleState {
    public static final int BOARD_SIZE = 3;

    public static final int BLOCK = 0;

    public static final int RED_SHOE = 1;

    public static final int BLUE_SHOE = 2;

    public static final int BLACK_SHOE = 3;
    private Position[] positions;
    public PuzzleState(Position... positions){
        checkPositions(positions);
        this.positions = positions.clone();
    }

    public PuzzleState() {
        this(new Position(0,0), //block
            new Position(2, 0), //red
            new Position(1, 1), //blue
            new Position(0,2)); //black
    }

    private void checkPositions(Position[] positions) {
        if(positions.length != 4){
            throw new IllegalArgumentException();
        }
        for(var position:positions){
            if(!isOnBoard(position)){
                throw new IllegalArgumentException();
            }
        }
        if(positions[BLUE_SHOE].equals(positions[BLACK_SHOE])) {
            throw new IllegalArgumentException();
        }

    }

    public Position getPosition(int index){
        return positions[index];
    }

    public boolean canMove(Direction direction){
        return switch (direction) {
            case UP -> canMoveUp();
            case RIGHT -> canMoveRight();
            case DOWN -> canMoveDown();
            case LEFT -> canMoveLeft();
        };
    }

    public boolean canMoveUp(){
        return getPosition(BLOCK).row() > 0 && isEmpty(getPosition(BLOCK).moveUp());
    }
    public boolean canMoveRight(){
        if (getPosition(BLOCK).col() == BOARD_SIZE -1){
            return false;
        }
        var right = getPosition(BLOCK).moveRight();
        return isEmpty(right) || (right.equals(getPosition(BLACK_SHOE)) && !haveSamePosition(BLOCK, BLUE_SHOE));
    }
    public boolean canMoveDown(){
        if(getPosition(BLOCK).row() == BOARD_SIZE -1){
            return false;
        }
        var down = getPosition(BLOCK).moveDown();
        if (isEmpty(down)){
            return true;
        }
        if(haveSamePosition(BLACK_SHOE, BLOCK)){
            return false;
        }
        return down.equals(getPosition(BLUE_SHOE))|| (down.equals(getPosition(RED_SHOE)) && !haveSamePosition(BLOCK, BLUE_SHOE));
    }
    public boolean canMoveLeft(){
        return getPosition(BLOCK).col() > 0 && isEmpty(getPosition(BLOCK).moveLeft());
    }

    public void move(Direction direction){
        switch (direction){
            case UP -> moveUp();
            case RIGHT -> moveRight();
            case DOWN -> MoveDown();
            case LEFT -> moveLeft();
        }
    }

    private void movePiece(int index, Direction direction){
        var newPosition = positions[index].move(direction);
        positions[index] = newPosition;
    }

    private boolean isOnBoard(Position position){
        return 0<=position.row() && position.row() < BOARD_SIZE
            && 0 <= position.col() && position.col() < BOARD_SIZE;
    }

    public boolean haveSamePosition(int i, int j){
        return positions[i].equals(positions[j]);
    }

    @Override
    public String toString() {
        var joiner = new StringJoiner(",","[","]");
        for(var position: positions){
            joiner.add(position.toString());
        }
        return joiner.toString();
    }

    private boolean isEmpty(Position position){
        for (var p : positions){
            if(p.equals(position)){
                return false;
            }
        }
        return true;
    }
}
