package pr3.movable;

public class MovableRectangle implements Movable {
    private MovablePoint topLeft;
    private MovablePoint bottomRight;

    public MovableRectangle(int x1, int y1, int x2, int y2,
                            int xSpeed, int ySpeed) {
        this.topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
        this.bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
    }

    private void checkSpeeds() {
        if (topLeft.xSpeed != bottomRight.xSpeed ||
                topLeft.ySpeed != bottomRight.ySpeed) {
            throw new IllegalStateException(
                    "Скорости точек прямоугольника должны совпадать!");
        }
    }

    @Override public void moveUp()    { checkSpeeds(); topLeft.moveUp();    bottomRight.moveUp(); }
    @Override public void moveDown()  { checkSpeeds(); topLeft.moveDown();  bottomRight.moveDown(); }
    @Override public void moveLeft()  { checkSpeeds(); topLeft.moveLeft();  bottomRight.moveLeft(); }
    @Override public void moveRight() { checkSpeeds(); topLeft.moveRight(); bottomRight.moveRight(); }

    @Override
    public String toString() {
        return "MovableRectangle[topLeft=" + topLeft +
                ", bottomRight=" + bottomRight + "]";
    }
}
