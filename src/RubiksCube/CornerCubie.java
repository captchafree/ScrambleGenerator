package RubiksCube;

import Enums.CornerPosition;
import Enums.Direction;

import java.util.Random;

public class CornerCubie {

    //Colors stored in clockwise order
    private Color[] colors;

    //value in [0,2]
    private int orientation;

    public CornerCubie(Color a, Color b, Color c) {
        colors = new Color[3];
        colors[0] = a;
        colors[1] = b;
        colors[2] = c;

        orientation = 0;
    }

    public void rotateClockwise() {
        orientation--;
        if (orientation < 0) {
            orientation = 2;
        }
    }

    public void rotateCounterClockwise() {
        orientation = (orientation + 1) % 3;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public void randomlyOrient() {
        Random rand = new Random();
        this.orientation = rand.nextInt(3);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CornerCubie)) {
            return false;
        } else {
            CornerCubie other = (CornerCubie) o;
            return this.colors[0] == other.colors[0] && this.colors[1] == other.colors[1] && this.colors[2] == other.colors[2];
        }
    }

    public Color getColorAtLocation(CornerPosition position, Direction direction) {
        switch (position) {
            case ULB:
                switch (direction) {
                    case UP:
                        return colors[(0 + orientation) % 3];
                    case LEFT:
                        return colors[(1 + orientation) % 3];
                    case BACK:
                        return colors[(2 + orientation) % 3];
                    default:
                        return Color.NIL;
                }

            case UBR:
                switch (direction) {
                    case UP:
                        return colors[(0 + orientation) % 3];
                    case BACK:
                        return colors[(1 + orientation) % 3];
                    case RIGHT:
                        return colors[(2 + orientation) % 3];
                    default:
                        return Color.NIL;
                }

            case URF:
                switch (direction) {
                    case UP:
                        return colors[(0 + orientation) % 3];
                    case RIGHT:
                        return colors[(1 + orientation) % 3];
                    case FRONT:
                        return colors[(2 + orientation) % 3];
                    default:
                        return Color.NIL;
                }

            case UFL:
                switch (direction) {
                    case UP:
                        return colors[(0 + orientation) % 3];
                    case FRONT:
                        return colors[(1 + orientation) % 3];
                    case LEFT:
                        return colors[(2 + orientation) % 3];
                    default:
                        return Color.NIL;
                }

            case DLF:
                switch (direction) {
                    case FRONT:
                        return colors[(0 + orientation) % 3];
                    case DOWN:
                        return colors[(1 + orientation) % 3];
                    case LEFT:
                        return colors[(2 + orientation) % 3];
                    default:
                        return Color.NIL;
                }

            case DBL:
                switch (direction) {
                    case LEFT:
                        return colors[(0 + orientation) % 3];
                    case DOWN:
                        return colors[(1 + orientation) % 3];
                    case BACK:
                        return colors[(2 + orientation) % 3];
                    default:
                        return Color.NIL;
                }

            case DRB:
                switch (direction) {
                    case BACK:
                        return colors[(0 + orientation) % 3];
                    case DOWN:
                        return colors[(1 + orientation) % 3];
                    case RIGHT:
                        return colors[(2 + orientation) % 3];
                    default:
                        return Color.NIL;
                }

            case DFR:
                switch (direction) {
                    case FRONT:
                        return colors[(0 + orientation) % 3];
                    case RIGHT:
                        return colors[(1 + orientation) % 3];
                    case DOWN:
                        return colors[(2 + orientation) % 3];
                    default:
                        return Color.NIL;
                }

            default:
                return Color.NIL;
        }
    }
}
