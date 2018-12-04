package Scramblers;

import Enums.EdgePosition;
import RubiksCube.Color;
import RubiksCube.EdgeCubie;

import java.util.HashMap;

public class CrossSolvedScrambler extends ScrambleGenerator {

    @Override
    protected void constructCube() {

        EdgeCubie WG = new EdgeCubie(Color.WHITE, Color.GREEN);
        EdgeCubie WB = new EdgeCubie(Color.WHITE, Color.BLUE);
        EdgeCubie WR = new EdgeCubie(Color.WHITE, Color.RED);
        EdgeCubie WO = new EdgeCubie(Color.WHITE, Color.ORANGE);

        HashMap<EdgePosition, EdgeCubie> edges = new HashMap<>();

        edges.put(EdgePosition.DB, WO);
        edges.put(EdgePosition.DR, WG);
        edges.put(EdgePosition.DF, WR);
        edges.put(EdgePosition.DL, WB);

        cube = CubeConstructor.fillCube(null, edges);
    }
}
