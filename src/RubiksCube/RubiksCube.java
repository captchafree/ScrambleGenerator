package RubiksCube;

import Enums.CornerPosition;
import Enums.Direction;
import Enums.EdgePosition;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//Default orientation is RED front, YELLOW up
public class RubiksCube {

    private Corners corners;
    private Edges edges;

    public RubiksCube() {
        corners = new Corners();
        edges = new Edges();
    }

    public void setCorners(Corners corners) {
        this.corners = corners;
    }

    public void setEdges(Edges edges) {
        this.edges = edges;
    }

    public void setCorners(CornerCubie[] corners) {
        this.corners.setCubies(corners);
    }

    public void setEdges(EdgeCubie[] edges) {
        this.edges.setCubies(edges);
    }

    public void putPieceAtLocation(CornerCubie cubie, CornerPosition pos) {
        corners.putCubieAtLocation(cubie, pos);
    }

    public void putPieceAtLocation(EdgeCubie cubie, EdgePosition pos) {
        edges.putCubieAtLocation(cubie, pos);
    }

    public void solve() {
        this.corners = new Corners();
        this.edges = new Edges();
    }

    public void scramble(int numberOfMoves) {
        for (int i = 0; i < numberOfMoves; i++) {
            this.randomMove();
        }
    }

    public void randomlyOrientWithRespectTo(Map<CornerPosition, CornerCubie> corners_, Map<EdgePosition, EdgeCubie> edges_) {
        if (corners_ == null) {
            corners_ = new HashMap<CornerPosition, CornerCubie>();
        }

        if (edges_ == null) {
            edges_ = new HashMap<EdgePosition, EdgeCubie>();
        }

        this.corners.randomlyOrientWithRespectTo(corners_);
        this.edges.randomlyOrientWithRespectTo(edges_);
    }

    public void U() {
        corners.U();
        edges.U();
    }

    public void UPrime() {
        corners.UPrime();
        edges.UPrime();
    }

    public void U2() {
        this.U();
        this.U();
    }

    public void D() {
        corners.D();
        edges.D();
    }

    public void DPrime() {
        corners.DPrime();
        edges.DPrime();
    }

    public void D2() {
        this.D();
        this.D();
    }

    public void R() {
        corners.R();
        edges.R();
    }

    public void RPrime() {
        corners.RPrime();
        edges.RPrime();
    }

    public void R2() {
        this.R();
        this.R();
    }

    public void L() {
        corners.L();
        edges.L();
    }

    public void LPrime() {
        corners.LPrime();
        edges.LPrime();
    }

    public void L2() {
        this.L();
        this.L();
    }

    public void F() {
        corners.F();
        edges.F();
    }

    public void FPrime() {
        corners.FPrime();
        edges.FPrime();
    }

    public void F2() {
        this.F();
        this.F();
    }

    public void B() {
        corners.B();
        edges.B();
    }

    public void BPrime() {
        corners.BPrime();
        edges.BPrime();
    }

    public void B2() {
        this.B();
        this.B();
    }

    public void randomMove() {
        Random rand = new Random();

        switch (rand.nextInt(12)) {
            case 0:
                this.U();
                break;
            case 1:
                this.UPrime();
                break;
            case 2:
                this.D();
                break;
            case 3:
                this.DPrime();
                break;
            case 4:
                this.R();
                break;
            case 5:
                this.RPrime();
                break;
            case 6:
                this.L();
                break;
            case 7:
                this.LPrime();
                break;
            case 8:
                this.F();
                break;
            case 9:
                this.FPrime();
                break;
            case 10:
                this.B();
                break;
            case 11:
                this.BPrime();
                break;
        }
    }

    public void executeScramble(String scramble) {
        String[] moves = scramble.split(" ");
        for (String move : moves) {
            switch (move) {
                case "U":
                    this.U();
                    break;
                case "U'":
                    this.UPrime();
                    break;
                case "U2":
                    this.U2();
                    break;

                case "D":
                    this.D();
                    break;
                case "D'":
                    this.DPrime();
                    break;
                case "D2":
                    this.D2();
                    break;

                case "R":
                    this.R();
                    break;
                case "R'":
                    this.RPrime();
                    break;
                case "R2":
                    this.R2();
                    break;

                case "L":
                    this.L();
                    break;
                case "L'":
                    this.LPrime();
                    break;
                case "L2":
                    this.L2();
                    break;

                case "F":
                    this.F();
                    break;
                case "F'":
                    this.FPrime();
                    break;
                case "F2":
                    this.F2();
                    break;

                case "B":
                    this.B();
                    break;
                case "B'":
                    this.BPrime();
                    break;
                case "B2":
                    this.B2();
                    break;

                default:
                    System.out.println("Couldn't execute " + move);
            }
        }
    }

    @Override
    public String toString() {
        String result = "";

        result += getSymbol(corners.getColorAtLocation(CornerPosition.ULB, Direction.UP));
        result += getSymbol(edges.getColorAtLocation(EdgePosition.UB, Direction.UP));
        result += getSymbol(corners.getColorAtLocation(CornerPosition.UBR, Direction.UP));
        result += getSymbol(edges.getColorAtLocation(EdgePosition.UL, Direction.UP));
        result += "U";
        result += getSymbol(edges.getColorAtLocation(EdgePosition.UR, Direction.UP));
        result += getSymbol(corners.getColorAtLocation(CornerPosition.UFL, Direction.UP));
        result += getSymbol(edges.getColorAtLocation(EdgePosition.UF, Direction.UP));
        result += getSymbol(corners.getColorAtLocation(CornerPosition.URF, Direction.UP));

        result += getSymbol(corners.getColorAtLocation(CornerPosition.URF, Direction.RIGHT));
        result += getSymbol(edges.getColorAtLocation(EdgePosition.UR, Direction.RIGHT));
        result += getSymbol(corners.getColorAtLocation(CornerPosition.UBR, Direction.RIGHT));
        result += getSymbol(edges.getColorAtLocation(EdgePosition.FR, Direction.RIGHT));
        result += "R";
        result += getSymbol(edges.getColorAtLocation(EdgePosition.BR, Direction.RIGHT));
        result += getSymbol(corners.getColorAtLocation(CornerPosition.DFR, Direction.RIGHT));
        result += getSymbol(edges.getColorAtLocation(EdgePosition.DR, Direction.RIGHT));
        result += getSymbol(corners.getColorAtLocation(CornerPosition.DRB, Direction.RIGHT));

        result += getSymbol(corners.getColorAtLocation(CornerPosition.UFL, Direction.FRONT));
        result += getSymbol(edges.getColorAtLocation(EdgePosition.UF, Direction.FRONT));
        result += getSymbol(corners.getColorAtLocation(CornerPosition.URF, Direction.FRONT));
        result += getSymbol(edges.getColorAtLocation(EdgePosition.FL, Direction.FRONT));
        result += "F";
        result += getSymbol(edges.getColorAtLocation(EdgePosition.FR, Direction.FRONT));
        result += getSymbol(corners.getColorAtLocation(CornerPosition.DLF, Direction.FRONT));
        result += getSymbol(edges.getColorAtLocation(EdgePosition.DF, Direction.FRONT));
        result += getSymbol(corners.getColorAtLocation(CornerPosition.DFR, Direction.FRONT));

        result += getSymbol(corners.getColorAtLocation(CornerPosition.DLF, Direction.DOWN));
        result += getSymbol(edges.getColorAtLocation(EdgePosition.DF, Direction.DOWN));
        result += getSymbol(corners.getColorAtLocation(CornerPosition.DFR, Direction.DOWN));
        result += getSymbol(edges.getColorAtLocation(EdgePosition.DL, Direction.DOWN));
        result += "D";
        result += getSymbol(edges.getColorAtLocation(EdgePosition.DR, Direction.DOWN));
        result += getSymbol(corners.getColorAtLocation(CornerPosition.DBL, Direction.DOWN));
        result += getSymbol(edges.getColorAtLocation(EdgePosition.DB, Direction.DOWN));
        result += getSymbol(corners.getColorAtLocation(CornerPosition.DRB, Direction.DOWN));

        result += getSymbol(corners.getColorAtLocation(CornerPosition.ULB, Direction.LEFT));
        result += getSymbol(edges.getColorAtLocation(EdgePosition.UL, Direction.LEFT));
        result += getSymbol(corners.getColorAtLocation(CornerPosition.UFL, Direction.LEFT));
        result += getSymbol(edges.getColorAtLocation(EdgePosition.BL, Direction.LEFT));
        result += "L";
        result += getSymbol(edges.getColorAtLocation(EdgePosition.FL, Direction.LEFT));
        result += getSymbol(corners.getColorAtLocation(CornerPosition.DBL, Direction.LEFT));
        result += getSymbol(edges.getColorAtLocation(EdgePosition.DL, Direction.LEFT));
        result += getSymbol(corners.getColorAtLocation(CornerPosition.DLF, Direction.LEFT));

        result += getSymbol(corners.getColorAtLocation(CornerPosition.UBR, Direction.BACK));
        result += getSymbol(edges.getColorAtLocation(EdgePosition.UB, Direction.BACK));
        result += getSymbol(corners.getColorAtLocation(CornerPosition.ULB, Direction.BACK));
        result += getSymbol(edges.getColorAtLocation(EdgePosition.BR, Direction.BACK));
        result += "B";
        result += getSymbol(edges.getColorAtLocation(EdgePosition.BL, Direction.BACK));
        result += getSymbol(corners.getColorAtLocation(CornerPosition.DRB, Direction.BACK));
        result += getSymbol(edges.getColorAtLocation(EdgePosition.DB, Direction.BACK));
        result += getSymbol(corners.getColorAtLocation(CornerPosition.DBL, Direction.BACK));

        return result;
    }

    public boolean isOriented() {
        return corners.isOriented() && edges.isOriented();
    }

    public boolean isSolved() {
        return this.toString().equals("UUUUUUUUURRRRRRRRRFFFFFFFFFDDDDDDDDDLLLLLLLLLBBBBBBBBB");
    }

    public String getSymbol(Color color) {
        switch (color) {
            case RED:
                return "F";
            case BLUE:
                return "L";
            case ORANGE:
                return "B";
            case GREEN:
                return "R";
            case YELLOW:
                return "U";
            case WHITE:
                return "D";
            default:
                return "ERROR";
        }
    }
}
