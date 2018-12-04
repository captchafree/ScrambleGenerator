package RubiksCube;

import Enums.EdgePosition;

public class EdgeCubies {

    private static Color RED = Color.RED;
    private static Color ORANGE = Color.ORANGE;
    private static Color YELLOW = Color.YELLOW;
    private static Color WHITE = Color.WHITE;
    private static Color BLUE = Color.BLUE;
    private static Color GREEN = Color.GREEN;

    public static EdgeCubie[] getCubies() {
        EdgeCubie[] result = {
                new EdgeCubie(YELLOW, ORANGE),
                new EdgeCubie(YELLOW, GREEN),
                new EdgeCubie(YELLOW, RED),
                new EdgeCubie(YELLOW, BLUE),
                new EdgeCubie(RED, BLUE),
                new EdgeCubie(RED, GREEN),
                new EdgeCubie(ORANGE, BLUE),
                new EdgeCubie(ORANGE, GREEN),
                new EdgeCubie(WHITE, ORANGE),
                new EdgeCubie(WHITE, GREEN),
                new EdgeCubie(WHITE, RED),
                new EdgeCubie(WHITE, BLUE)
        };

        return result;
    }

    public static EdgePosition[] getPositions() {
        return EdgePosition.values();
    }
}
