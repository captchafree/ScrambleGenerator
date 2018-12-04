package Scramblers;

import RubiksCube.RubiksCube;
import Solver.Solver;

public abstract class ScrambleGenerator {

    protected RubiksCube cube;

    public ScrambleGenerator() {
        cube = new RubiksCube();
    }

    protected abstract void constructCube();

    public String generate() {
        String result;
        do {
            constructCube();
            result = Solver.solve(cube);
        } while (result == null);

        return inverseScramble(result);
    }

    private String inverseScramble(String scramble) {
        String result = "";

        String[] moves = scramble.split(" ");
        for (int i = 0; i < moves.length; i++) {
            if (moves[i].length() == 2) {
                if (moves[i].charAt(1) == '\'') {
                    moves[i] = moves[i].charAt(0) + "";
                }
            } else if (moves[i].length() == 1) {
                moves[i] = moves[i] + "\'";
            }
        }

        for (int i = moves.length - 1; i >= 0; i--) {
            result += moves[i];
            if (i != 0) {
                result += " ";
            }
        }
        return result.substring(3);
    }
}
