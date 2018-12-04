package RubiksCube;

import Enums.CornerPosition;
import Enums.Direction;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Corners {

    private HashMap<CornerPosition, CornerCubie> cubies;

    public Corners() {
        cubies = new HashMap<CornerPosition, CornerCubie>();
        CornerCubie[] corners = CornerCubies.getCubies();

        cubies.put(CornerPosition.ULB, corners[0]);
        cubies.put(CornerPosition.UBR, corners[1]);
        cubies.put(CornerPosition.URF, corners[2]);
        cubies.put(CornerPosition.UFL, corners[3]);
        cubies.put(CornerPosition.DLF, corners[4]);
        cubies.put(CornerPosition.DBL, corners[5]);
        cubies.put(CornerPosition.DRB, corners[6]);
        cubies.put(CornerPosition.DFR, corners[7]);
    }

    public void setCubies(CornerCubie[] cubies) {
        int count = 0;
        for (CornerPosition pos : CornerCubies.getPositions()) {
            this.cubies.put(pos, cubies[count]);
            count++;
        }
    }

    public void randomlyOrientWithRespectTo(Map<CornerPosition, CornerCubie> corners_) {
        for (CornerCubie c : cubies.values()) {
            if (!corners_.containsValue(c)) {
                c.randomlyOrient();
            }
        }

        int orientationSum = this.getOrientationSum();
        if (orientationSum % 3 == 0) {
            return;
        } else {

            CornerCubie cubieToRotate = null;
            Iterator<CornerCubie> itr = this.cubies.values().iterator();

            while (itr.hasNext()) {
                cubieToRotate = itr.next();
                if (!corners_.containsValue(cubieToRotate)) {
                    break;
                }
            }

            if (orientationSum % 3 == 1) {
                cubieToRotate.rotateClockwise();
            } else if (orientationSum % 3 == 2) {
                cubieToRotate.rotateCounterClockwise();
            }
        }
    }

    public void clear() {
        cubies.clear();
    }

    public void putCubieAtLocation(CornerCubie cubie, CornerPosition location) {
        if (cubies.get(location) == null) {
            cubies.put(location, cubie);
        }
    }

    public Color getColorAtLocation(CornerPosition position, Direction direction) {
        CornerCubie cubie = cubies.get(position);
        return cubie.getColorAtLocation(position, direction);
    }

    public void U() {
        CornerCubie temp = cubies.get(CornerPosition.ULB);
        cubies.put(CornerPosition.ULB, cubies.get(CornerPosition.UFL));
        cubies.put(CornerPosition.UFL, cubies.get(CornerPosition.URF));
        cubies.put(CornerPosition.URF, cubies.get(CornerPosition.UBR));
        cubies.put(CornerPosition.UBR, temp);
    }

    public void UPrime() {
        CornerCubie temp = cubies.get(CornerPosition.ULB);
        cubies.put(CornerPosition.ULB, cubies.get(CornerPosition.UBR));
        cubies.put(CornerPosition.UBR, cubies.get(CornerPosition.URF));
        cubies.put(CornerPosition.URF, cubies.get(CornerPosition.UFL));
        cubies.put(CornerPosition.UFL, temp);
    }

    public void U2() {
        this.U();
        this.U();
    }

    public void D() {
        CornerCubie temp = cubies.get(CornerPosition.DLF);
        cubies.put(CornerPosition.DLF, cubies.get(CornerPosition.DBL));
        cubies.put(CornerPosition.DBL, cubies.get(CornerPosition.DRB));
        cubies.put(CornerPosition.DRB, cubies.get(CornerPosition.DFR));
        cubies.get(CornerPosition.DFR).rotateCounterClockwise();
        cubies.put(CornerPosition.DFR, temp);
        cubies.get(CornerPosition.DFR).rotateClockwise();
    }

    public void DPrime() {
        CornerCubie temp = cubies.get(CornerPosition.DLF);
        cubies.put(CornerPosition.DLF, cubies.get(CornerPosition.DFR));
        cubies.get(CornerPosition.DLF).rotateCounterClockwise();
        cubies.put(CornerPosition.DFR, cubies.get(CornerPosition.DRB));
        cubies.get(CornerPosition.DFR).rotateClockwise();
        cubies.put(CornerPosition.DRB, cubies.get(CornerPosition.DBL));
        cubies.put(CornerPosition.DBL, temp);
    }

    public void D2() {
        this.D();
        this.D();
    }

    public void R() {
        CornerCubie temp = cubies.get(CornerPosition.URF);
        cubies.put(CornerPosition.URF, cubies.get(CornerPosition.DFR));
        cubies.put(CornerPosition.DFR, cubies.get(CornerPosition.DRB));
        cubies.get(CornerPosition.DFR).rotateCounterClockwise();
        cubies.put(CornerPosition.DRB, cubies.get(CornerPosition.UBR));
        cubies.put(CornerPosition.UBR, temp);
        cubies.get(CornerPosition.UBR).rotateClockwise();
    }

    public void RPrime() {
        CornerCubie temp = cubies.get(CornerPosition.URF);
        cubies.put(CornerPosition.URF, cubies.get(CornerPosition.UBR));
        cubies.get(CornerPosition.URF).rotateCounterClockwise();
        cubies.put(CornerPosition.UBR, cubies.get(CornerPosition.DRB));
        cubies.put(CornerPosition.DRB, cubies.get(CornerPosition.DFR));
        cubies.get(CornerPosition.DRB).rotateClockwise();
        cubies.put(CornerPosition.DFR, temp);
    }

    public void R2() {
        this.R();
        this.R();
    }

    public void L() {
        CornerCubie temp = cubies.get(CornerPosition.UFL);
        cubies.put(CornerPosition.UFL, cubies.get(CornerPosition.ULB));
        cubies.get(CornerPosition.UFL).rotateClockwise();
        cubies.put(CornerPosition.ULB, cubies.get(CornerPosition.DBL));
        cubies.get(CornerPosition.ULB).rotateClockwise();
        cubies.put(CornerPosition.DBL, cubies.get(CornerPosition.DLF));
        cubies.get(CornerPosition.DBL).rotateClockwise();
        cubies.put(CornerPosition.DLF, temp);
    }

    public void LPrime() {
        CornerCubie temp = cubies.get(CornerPosition.UFL);
        cubies.put(CornerPosition.UFL, cubies.get(CornerPosition.DLF));
        cubies.put(CornerPosition.DLF, cubies.get(CornerPosition.DBL));
        cubies.get(CornerPosition.DLF).rotateCounterClockwise();
        cubies.put(CornerPosition.DBL, cubies.get(CornerPosition.ULB));
        cubies.get(CornerPosition.DBL).rotateCounterClockwise();
        cubies.put(CornerPosition.ULB, temp);
        cubies.get(CornerPosition.ULB).rotateCounterClockwise();
    }

    public void L2() {
        this.L();
        this.L();
    }

    public void F() {
        CornerCubie temp = cubies.get(CornerPosition.UFL);
        cubies.put(CornerPosition.UFL, cubies.get(CornerPosition.DLF));
        cubies.get(CornerPosition.UFL).rotateClockwise();
        cubies.put(CornerPosition.DLF, cubies.get(CornerPosition.DFR));
        cubies.put(CornerPosition.DFR, cubies.get(CornerPosition.URF));
        cubies.get(CornerPosition.DFR).rotateClockwise();
        cubies.put(CornerPosition.URF, temp);
        cubies.get(CornerPosition.URF).rotateClockwise();
    }

    public void FPrime() {
        CornerCubie temp = cubies.get(CornerPosition.UFL);
        cubies.put(CornerPosition.UFL, cubies.get(CornerPosition.URF));
        cubies.get(CornerPosition.UFL).rotateCounterClockwise();
        cubies.put(CornerPosition.URF, cubies.get(CornerPosition.DFR));
        cubies.get(CornerPosition.URF).rotateCounterClockwise();
        cubies.put(CornerPosition.DFR, cubies.get(CornerPosition.DLF));
        cubies.put(CornerPosition.DLF, temp);
        cubies.get(CornerPosition.DLF).rotateCounterClockwise();
    }

    public void F2() {
        this.F();
        this.F();
    }

    public void B() {
        CornerCubie temp = cubies.get(CornerPosition.ULB);
        cubies.put(CornerPosition.ULB, cubies.get(CornerPosition.UBR));
        cubies.get(CornerPosition.ULB).rotateClockwise();
        cubies.put(CornerPosition.UBR, cubies.get(CornerPosition.DRB));
        cubies.get(CornerPosition.UBR).rotateClockwise();
        cubies.put(CornerPosition.DRB, cubies.get(CornerPosition.DBL));
        cubies.get(CornerPosition.DRB).rotateClockwise();
        cubies.put(CornerPosition.DBL, temp);
    }

    public void BPrime() {
        CornerCubie temp = cubies.get(CornerPosition.ULB);
        cubies.put(CornerPosition.ULB, cubies.get(CornerPosition.DBL));
        cubies.put(CornerPosition.DBL, cubies.get(CornerPosition.DRB));
        cubies.get(CornerPosition.DBL).rotateCounterClockwise();
        cubies.put(CornerPosition.DRB, cubies.get(CornerPosition.UBR));
        cubies.get(CornerPosition.DRB).rotateCounterClockwise();
        cubies.put(CornerPosition.UBR, temp);
        cubies.get(CornerPosition.UBR).rotateCounterClockwise();
    }

    public void B2() {
        this.B();
        this.B();
    }

    //If sum % 3 == 0 then the cube is solvable
    public int getOrientationSum() {
        int sum = 0;
        for (CornerCubie cubie : cubies.values()) {
            sum += cubie.getOrientation();
        }
        return sum;
    }

    public boolean isOriented() {
        return this.getOrientationSum() % 3 == 0;
    }
}
