package Driver;

import Scramblers.CrossSolvedScrambler;
import Scramblers.RandomStateScrambler;

public class Main {

    public static void main(String args[]) {

        RandomStateScrambler s = new RandomStateScrambler();
        System.out.println(s.generate());

        CrossSolvedScrambler s1 = new CrossSolvedScrambler();
        System.out.println(s1.generate());
    }
}
