package RubiksCube;

import Enums.CornerPosition;

public class CornerCubies {

    private static Color RED = Color.RED;
    private static Color ORANGE = Color.ORANGE;
    private static Color YELLOW = Color.YELLOW;
    private static Color WHITE = Color.WHITE;
    private static Color BLUE = Color.BLUE;
    private static Color GREEN = Color.GREEN;

    public static CornerCubie[] getCubies() {
        CornerCubie[] result = {
                new CornerCubie(YELLOW, BLUE, ORANGE),
                new CornerCubie(YELLOW, ORANGE, GREEN),
                new CornerCubie(YELLOW, GREEN, RED),
                new CornerCubie(YELLOW, RED, BLUE),
                new CornerCubie(RED, WHITE, BLUE),
                new CornerCubie(BLUE, WHITE, ORANGE),
                new CornerCubie(ORANGE, WHITE, GREEN),
                new CornerCubie(RED, GREEN, WHITE)
        };

        return result;
    }

    public static CornerPosition[] getPositions() {
        return CornerPosition.values();
    }
}
