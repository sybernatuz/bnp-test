public class Coordinate {

    private Integer x;
    private Integer y;

    @Override
    public String toString() {
        return x + " " + y;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}
