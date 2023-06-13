public class Rover {

    private Coordinate coordinate;
    private Direction direction;

    public void move(Move move) {
        int currentIndex = direction.ordinal();
        switch (move) {
            case M -> moveForward();
            case L -> direction = Direction.values()[(currentIndex + 3) % 4];
            case R -> direction = Direction.values()[(currentIndex + 1) % 4];
        }
    }

    private void moveForward() {
        switch (direction) {
            case E -> coordinate.setX(coordinate.getX()+1);
            case W -> coordinate.setX(coordinate.getX()-1);
            case N -> coordinate.setY(coordinate.getY()+1);
            case S -> coordinate.setY(coordinate.getY()-1);
        }
    }

    @Override
    public String toString() {
        return coordinate + " " + direction;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
