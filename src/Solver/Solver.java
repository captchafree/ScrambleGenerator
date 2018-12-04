package Solver;

import RubiksCube.RubiksCube;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Solver {

    public static String solve(RubiksCube cube) {

        File commandFile = new File("src/Solver/kociembaSolver/kociemba ");
        File commandDir = new File("src/Solver/kociembaSolver");

        Process p;
        try {
            p = Runtime.getRuntime().exec(commandFile.getAbsolutePath() + cube, null, commandDir);
            String result = convertStreamToString(p.getInputStream());
            if (result.contains("Unsolvable cube!")) {
                return null;
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @SuppressWarnings("resource")
    private static String convertStreamToString(InputStream is) {
        Scanner scanner = new Scanner(is).useDelimiter("\\A");
        String result = scanner.hasNext() ? scanner.next() : "";

        scanner.close();

        return result;
    }
}
