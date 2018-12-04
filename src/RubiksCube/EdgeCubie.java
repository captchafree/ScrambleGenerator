package RubiksCube;

import Enums.Direction;
import Enums.EdgePosition;

import java.util.Random;

public class EdgeCubie {

    //Colors stored
    private Color[] colors;

    //Value in [0,1]
    private int orientation;

    public EdgeCubie(Color a, Color b) {
        colors = new Color[2];
        colors[0] = a;
        colors[1] = b;

        orientation = 0;
    }

    public void flip() {
        orientation = (orientation + 1) % 2;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public void randomlyOrient() {
        Random rand = new Random();
        this.orientation = rand.nextInt(3);
    }

    public Color getColorAtLocation(EdgePosition position, Direction direction) {
        switch (position) {
            case UB:
                switch (direction) {
                    case UP:
                        return colors[(0 + orientation) % 2];
                    case BACK:
                        return colors[(1 + orientation) % 2];
                    default:
                        return Color.NIL;
                }

            case UR:
                switch (direction) {
                    case UP:
                        return colors[(0 + orientation) % 2];
                    case RIGHT:
                        return colors[(1 + orientation) % 2];
                    default:
                        return Color.NIL;
                }

            case UF:
                switch (direction) {
                    case UP:
                        return colors[(0 + orientation) % 2];
                    case FRONT:
                        return colors[(1 + orientation) % 2];
                    default:
                        return Color.NIL;
                }

            case UL:
                switch (direction) {
                    case UP:
                        return colors[(0 + orientation) % 2];
                    case LEFT:
                        return colors[(1 + orientation) % 2];
                    default:
                        return Color.NIL;
                }

            case FL:
                switch (direction) {
                    case FRONT:
                        return colors[(0 + orientation) % 2];
                    case LEFT:
                        return colors[(1 + orientation) % 2];
                    default:
                        return Color.NIL;
                }

            case FR:
                switch (direction) {
                    case FRONT:
                        return colors[(0 + orientation) % 2];
                    case RIGHT:
                        return colors[(1 + orientation) % 2];
                    default:
                        return Color.NIL;
                }

            case BL:
                switch (direction) {
                    case BACK:
                        return colors[(0 + orientation) % 2];
                    case LEFT:
                        return colors[(1 + orientation) % 2];
                    default:
                        return Color.NIL;
                }

            case BR:
                switch (direction) {
                    case BACK:
                        return colors[(0 + orientation) % 2];
                    case RIGHT:
                        return colors[(1 + orientation) % 2];
                    default:
                        return Color.NIL;
                }

            case DB:
                switch (direction) {
                    case DOWN:
                        return colors[(0 + orientation) % 2];
                    case BACK:
                        return colors[(1 + orientation) % 2];
                    default:
                        return Color.NIL;
                }

            case DR:
                switch (direction) {
                    case DOWN:
                        return colors[(0 + orientation) % 2];
                    case RIGHT:
                        return colors[(1 + orientation) % 2];
                    default:
                        return Color.NIL;
                }

            case DF:
                switch (direction) {
                    case DOWN:
                        return colors[(0 + orientation) % 2];
                    case FRONT:
                        return colors[(1 + orientation) % 2];
                    default:
                        return Color.NIL;
                }

            case DL:
                switch (direction) {
                    case DOWN:
                        return colors[(0 + orientation) % 2];
                    case LEFT:
                        return colors[(1 + orientation) % 2];
                    default:
                        return Color.NIL;
                }

            default:
                return Color.NIL;
        }
    }

    public boolean hasColor(Color color) {
        return colors[0] == color || colors[1] == color;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof EdgeCubie)) {
            return false;
        } else {
            EdgeCubie other = (EdgeCubie) o;
            return other.colors[0] == this.colors[0] && other.colors[1] == this.colors[1];
        }
    }
}
