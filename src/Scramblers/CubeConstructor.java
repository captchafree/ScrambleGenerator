package Scramblers;

import Enums.CornerPosition;
import Enums.EdgePosition;
import RubiksCube.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class CubeConstructor {

    public static RubiksCube fillCube(Map<CornerPosition, CornerCubie> corners, Map<EdgePosition, EdgeCubie> edges) {
        RubiksCube cube = new RubiksCube();

        if (corners == null) {
            corners = new HashMap<CornerPosition, CornerCubie>();
        }
        if (edges == null) {
            edges = new HashMap<EdgePosition, EdgeCubie>();
        }

        ArrayList<CornerCubie> cornerPieces = new ArrayList<>();
        ArrayList<EdgeCubie> edgePieces = new ArrayList<>();

        for (CornerCubie c : CornerCubies.getCubies()) {
            if (!corners.containsValue(c)) {
                cornerPieces.add(c);
            }
        }

        for (EdgeCubie c : EdgeCubies.getCubies()) {
            if (!edges.containsValue(c)) {
                edgePieces.add(c);
            }
        }

        CornerCubie[] finalCorners = cornerPieces.toArray(new CornerCubie[0]);
        EdgeCubie[] finalEdges = edgePieces.toArray(new EdgeCubie[0]);

        shuffleArray(finalCorners);
        shuffleArray(finalEdges);

        Corners c = new Corners();
        c.clear();
        Edges e = new Edges();
        e.clear();

        int count = 0;
        for (CornerPosition pos : CornerCubies.getPositions()) {
            CornerCubie cubieToPlace;
            if (corners.containsKey(pos)) {
                cubieToPlace = corners.get(pos);
            } else {
                cubieToPlace = finalCorners[count];
                cubieToPlace.randomlyOrient();
                count++;
            }

            c.putCubieAtLocation(cubieToPlace, pos);
        }

        count = 0;
        for (EdgePosition pos : EdgeCubies.getPositions()) {
            EdgeCubie cubieToPlace;
            if (edges.containsKey(pos)) {
                cubieToPlace = edges.get(pos);
            } else {
                cubieToPlace = finalEdges[count];
                cubieToPlace.randomlyOrient();
                count++;
            }

            e.putCubieAtLocation(cubieToPlace, pos);
        }

        cube.setCorners(c);
        cube.setEdges(e);

        cube.randomlyOrientWithRespectTo(corners, edges);

        return cube;
    }

    private static <T> void shuffleArray(T[] ar) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            T a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
}
