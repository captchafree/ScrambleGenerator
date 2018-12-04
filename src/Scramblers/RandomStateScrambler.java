package Scramblers;

import RubiksCube.CornerCubie;
import RubiksCube.CornerCubies;
import RubiksCube.EdgeCubie;
import RubiksCube.EdgeCubies;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomStateScrambler extends ScrambleGenerator {

    @Override
    protected void constructCube() {

        CornerCubie[] corners = CornerCubies.getCubies();
        EdgeCubie[] edges = EdgeCubies.getCubies();

        shuffleArray(corners);
        shuffleArray(edges);

        cube.setCorners(corners);
        cube.setEdges(edges);

        cube.randomlyOrientWithRespectTo(null, null);
    }

    private <T> void shuffleArray(T[] ar) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            T a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
}
