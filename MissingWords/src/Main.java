import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        char[][] grid = {
                {'i', 'ü', 'l', 's', 'e'},
                {'d', 'd', 'r', 'k', 'j'},
                {'i', 'n', 'i', 'n', 'o'},
                {'ş', 'k', 'r', 'l', 't'},
                {'u', 'v', 'w', 'x', 'y'}
        };
        List<String> words = new ArrayList<>(Arrays.asList("hello", "idil", "dins", "openai"));

        MissingWord puzzle = new MissingWord(grid, words);
        String missingWord = String.valueOf(puzzle.findAllMissingWords());
        System.out.println("Missing word: " + missingWord);


        System.out.println("\nGrid with words:");
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(Character.isUpperCase(grid[i][j]) ? "*" + grid[i][j] + "*" : grid[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

