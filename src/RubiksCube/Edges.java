package RubiksCube;

import Enums.Direction;
import Enums.EdgePosition;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Edges {

    private HashMap<EdgePosition, EdgeCubie> cubies;

    public Edges() {
        cubies = new HashMap<EdgePosition, EdgeCubie>();
        EdgeCubie[] edges = EdgeCubies.getCubies();

        cubies.put(EdgePosition.UB, edges[0]);
        cubies.put(EdgePosition.UR, edges[1]);
        cubies.put(EdgePosition.UF, edges[2]);
        cubies.put(EdgePosition.UL, edges[3]);

        cubies.put(EdgePosition.FL, edges[4]);
        cubies.put(EdgePosition.FR, edges[5]);
        cubies.put(EdgePosition.BL, edges[6]);
        cubies.put(EdgePosition.BR, edges[7]);

        cubies.put(EdgePosition.DB, edges[8]);
        cubies.put(EdgePosition.DR, edges[9]);
        cubies.put(EdgePosition.DF, edges[10]);
        cubies.put(EdgePosition.DL, edges[11]);
    }

    public void setCubies(EdgeCubie[] cubies) {
        int count = 0;
        for (EdgePosition pos : EdgeCubies.getPositions()) {
            this.cubies.put(pos, cubies[count]);
            count++;
        }
    }

    public void clear() {
        cubies.clear();
    }

    public void randomlyOrientWithRespectTo(Map<EdgePosition, EdgeCubie> edges_) {
        for (EdgeCubie c : cubies.values()) {
            if (!edges_.containsValue(c)) {
                c.randomlyOrient();
            }
        }

        int orientationSum = this.getOrientationSum();
        if (orientationSum % 2 == 0) {
            return;
        } else {

            EdgeCubie cubieToRotate = null;
            Iterator<EdgeCubie> itr = this.cubies.values().iterator();

            while (itr.hasNext()) {
                cubieToRotate = itr.next();
                if (!edges_.containsValue(cubieToRotate)) {
                    break;
                }
            }

            if (orientationSum % 2 == 1) {
                if (cubieToRotate != null) {
                    cubieToRotate.flip();
                }
            }
        }
    }

    public EdgeCubie getCubieAtLocation(EdgePosition location) {
        return cubies.get(location);
    }

    public Color getColorAtLocation(EdgePosition position, Direction direction) {
        EdgeCubie cubie = cubies.get(position);
        return cubie.getColorAtLocation(position, direction);
    }

    public void putCubieAtLocation(EdgeCubie cubie, EdgePosition location) {
        if (cubies.get(location) == null) {
            cubies.put(location, cubie);
        }
    }

    public void U() {
        EdgeCubie temp = cubies.get(EdgePosition.UB);
        cubies.put(EdgePosition.UB, cubies.get(EdgePosition.UL));
        cubies.put(EdgePosition.UL, cubies.get(EdgePosition.UF));
        cubies.put(EdgePosition.UF, cubies.get(EdgePosition.UR));
        cubies.put(EdgePosition.UR, temp);
    }

    public void UPrime() {
        EdgeCubie temp = cubies.get(EdgePosition.UB);
        cubies.put(EdgePosition.UB, cubies.get(EdgePosition.UR));
        cubies.put(EdgePosition.UR, cubies.get(EdgePosition.UF));
        cubies.put(EdgePosition.UF, cubies.get(EdgePosition.UL));
        cubies.put(EdgePosition.UL, temp);
    }

    public void U2() {
        this.U();
        this.U();
    }

    public void D() {
        EdgeCubie temp = cubies.get(EdgePosition.DB);
        cubies.put(EdgePosition.DB, cubies.get(EdgePosition.DR));
        cubies.put(EdgePosition.DR, cubies.get(EdgePosition.DF));
        cubies.put(EdgePosition.DF, cubies.get(EdgePosition.DL));
        cubies.put(EdgePosition.DL, temp);
    }

    public void DPrime() {
        EdgeCubie temp = cubies.get(EdgePosition.DB);
        cubies.put(EdgePosition.DB, cubies.get(EdgePosition.DL));
        cubies.put(EdgePosition.DL, cubies.get(EdgePosition.DF));
        cubies.put(EdgePosition.DF, cubies.get(EdgePosition.DR));
        cubies.put(EdgePosition.DR, temp);
    }

    public void D2() {
        this.D();
        this.D();
    }

    public void R() {
        EdgeCubie temp = cubies.get(EdgePosition.UR);
        cubies.put(EdgePosition.UR, cubies.get(EdgePosition.FR));
        cubies.put(EdgePosition.FR, cubies.get(EdgePosition.DR));
        cubies.put(EdgePosition.DR, cubies.get(EdgePosition.BR));
        cubies.put(EdgePosition.BR, temp);
    }

    public void RPrime() {
        EdgeCubie temp = cubies.get(EdgePosition.UR);
        cubies.put(EdgePosition.UR, cubies.get(EdgePosition.BR));
        cubies.put(EdgePosition.BR, cubies.get(EdgePosition.DR));
        cubies.put(EdgePosition.DR, cubies.get(EdgePosition.FR));
        cubies.put(EdgePosition.FR, temp);
    }

    public void R2() {
        this.R();
        this.R();
    }

    public void L() {
        EdgeCubie temp = cubies.get(EdgePosition.UL);
        cubies.put(EdgePosition.UL, cubies.get(EdgePosition.BL));
        cubies.put(EdgePosition.BL, cubies.get(EdgePosition.DL));
        cubies.put(EdgePosition.DL, cubies.get(EdgePosition.FL));
        cubies.put(EdgePosition.FL, temp);
    }

    public void LPrime() {
        EdgeCubie temp = cubies.get(EdgePosition.UL);
        cubies.put(EdgePosition.UL, cubies.get(EdgePosition.FL));
        cubies.put(EdgePosition.FL, cubies.get(EdgePosition.DL));
        cubies.put(EdgePosition.DL, cubies.get(EdgePosition.BL));
        cubies.put(EdgePosition.BL, temp);
    }

    public void L2() {
        this.L();
        this.L();
    }

    public void F() {
        EdgeCubie temp = cubies.get(EdgePosition.UF);
        cubies.put(EdgePosition.UF, cubies.get(EdgePosition.FL));
        cubies.get(EdgePosition.UF).flip();
        cubies.put(EdgePosition.FL, cubies.get(EdgePosition.DF));
        cubies.get(EdgePosition.FL).flip();
        cubies.put(EdgePosition.DF, cubies.get(EdgePosition.FR));
        cubies.get(EdgePosition.DF).flip();
        cubies.put(EdgePosition.FR, temp);
        cubies.get(EdgePosition.FR).flip();
    }

    public void FPrime() {
        EdgeCubie temp = cubies.get(EdgePosition.UF);
        cubies.put(EdgePosition.UF, cubies.get(EdgePosition.FR));
        cubies.get(EdgePosition.UF).flip();
        cubies.put(EdgePosition.FR, cubies.get(EdgePosition.DF));
        cubies.get(EdgePosition.FR).flip();
        cubies.put(EdgePosition.DF, cubies.get(EdgePosition.FL));
        cubies.get(EdgePosition.DF).flip();
        cubies.put(EdgePosition.FL, temp);
        cubies.get(EdgePosition.FL).flip();
    }

    public void F2() {
        this.F();
        this.F();
    }

    public void B() {
        EdgeCubie temp = cubies.get(EdgePosition.UB);
        cubies.put(EdgePosition.UB, cubies.get(EdgePosition.BR));
        cubies.get(EdgePosition.UB).flip();
        cubies.put(EdgePosition.BR, cubies.get(EdgePosition.DB));
        cubies.get(EdgePosition.BR).flip();
        cubies.put(EdgePosition.DB, cubies.get(EdgePosition.BL));
        cubies.get(EdgePosition.DB).flip();
        cubies.put(EdgePosition.BL, temp);
        cubies.get(EdgePosition.BL).flip();
    }

    public void BPrime() {
        EdgeCubie temp = cubies.get(EdgePosition.UB);
        cubies.put(EdgePosition.UB, cubies.get(EdgePosition.BL));
        cubies.get(EdgePosition.UB).flip();
        cubies.put(EdgePosition.BL, cubies.get(EdgePosition.DB));
        cubies.get(EdgePosition.BL).flip();
        cubies.put(EdgePosition.DB, cubies.get(EdgePosition.BR));
        cubies.get(EdgePosition.DB).flip();
        cubies.put(EdgePosition.BR, temp);
        cubies.get(EdgePosition.BR).flip();
    }

    public void B2() {
        this.B();
        this.B();
    }

    //If sum % 2 == 0 then the cube is solvable
    public int getOrientationSum() {
        int sum = 0;
        for (EdgeCubie cubie : cubies.values()) {
            sum += cubie.getOrientation();
        }
        return sum;
    }

    public boolean isOriented() {
        return this.getOrientationSum() % 2 == 0;
    }
}
