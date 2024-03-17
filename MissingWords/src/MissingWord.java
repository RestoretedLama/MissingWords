import java.util.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class MissingWord {
    private char[][] grid;
    private List<String> words;

    public MissingWord(char[][] grid, List<String> words) {
        this.grid = grid;
        this.words = words;
    }

    public List<String> findAllMissingWords() {
        List<String> missingWords = new ArrayList<>();
        for (String word : words) {
            if (!findWord(word)) {
                missingWords.add(word);
            }
        }
        return missingWords;
    }

    private boolean findWord(String word) {
        int n = grid.length;
        boolean found = false;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == word.charAt(0)) {
                    // Check all 8 possible orientations
                    if (checkLR(word, r, c) || checkRL(word, r, c) || checkBT(word, r, c) || checkTB(word, r, c) ||
                            checkTLBR(word, r, c) || checkBRTL(word, r, c) || checkTRBL(word, r, c) || checkBLTR(word, r, c)) {

                        markWord(word,r,c);
                        found = true;
                    }
                }
            }
        }
        return found;
    }
    private void markWord(String word, int row, int col) {
        int n = grid.length;
        if (checkLR(word, row, col)) {
            for (int i = 0; i < word.length(); i++) {
                grid[row][col + i] = Character.toUpperCase(grid[row][col + i]);
            }
        } else if (checkRL(word, row, col)) {
            for (int i = 0; i < word.length(); i++) {
                grid[row][col - i] = Character.toUpperCase(grid[row][col - i]);
            }
        } else if (checkBT(word, row, col)) {
            for (int i = 0; i < word.length(); i++) {
                grid[row + i][col] = Character.toUpperCase(grid[row + i][col]);
            }
        } else if (checkTB(word, row, col)) {
            for (int i = 0; i < word.length(); i++) {
                grid[row - i][col] = Character.toUpperCase(grid[row - i][col]);
            }
        } else if (checkTLBR(word, row, col)) {
            for (int i = 0; i < word.length(); i++) {
                grid[row + i][col + i] = Character.toUpperCase(grid[row + i][col + i]);
            }
        } else if (checkBRTL(word, row, col)) {
            for (int i = 0; i < word.length(); i++) {
                grid[row - i][col - i] = Character.toUpperCase(grid[row - i][col - i]);
            }
        } else if (checkTRBL(word, row, col)) {
            for (int i = 0; i < word.length(); i++) {
                grid[row - i][col + i] = Character.toUpperCase(grid[row - i][col + i]);
            }
        } else if (checkBLTR(word, row, col)) {
            for (int i = 0; i < word.length(); i++) {
                grid[row + i][col - i] = Character.toUpperCase(grid[row + i][col - i]);
            }
        }
    }
    private boolean checkLR(String word, int row, int col) {
        int n = grid.length;
        if (col + word.length() > n) return false;
        for (int i = 0; i < word.length(); i++) {
            if (grid[row][col + i] != word.charAt(i)) return false;
        }
        return true;
    }

    private boolean checkRL(String word, int row, int col) {
        int n = grid.length;
        if (col - word.length() + 1 < 0) return false;
        for (int i = 0; i < word.length(); i++) {
            if (grid[row][col - i] != word.charAt(i)) return false;
        }
        return true;
    }

    private boolean checkBT(String word, int row, int col) {
        int n = grid.length;
        if (row + word.length() > n) return false;
        for (int i = 0; i < word.length(); i++) {
            if (grid[row + i][col] != word.charAt(i)) return false;
        }
        return true;
    }

    private boolean checkTB(String word, int row, int col) {
        int n = grid.length;
        if (row - word.length() + 1 < 0) return false;
        for (int i = 0; i < word.length(); i++) {
            if (grid[row - i][col] != word.charAt(i)) return false;
        }
        return true;
    }

    private boolean checkTLBR(String word, int row, int col) {
        int n = grid.length;
        if (row + word.length() > n || col + word.length() > n) return false;
        for (int i = 0; i < word.length(); i++) {
            if (grid[row + i][col + i] != word.charAt(i)) return false;
        }
        return true;
    }

    private boolean checkBRTL(String word, int row, int col) {
        int n = grid.length;
        if (row - word.length() + 1 < 0 || col - word.length() + 1 < 0) return false;
        for (int i = 0; i < word.length(); i++) {
            if (grid[row - i][col - i] != word.charAt(i)) return false;
        }
        return true;
    }

    private boolean checkTRBL(String word, int row, int col) {
        int n = grid.length;
        if (row - word.length() + 1 < 0 || col + word.length() > n) return false;
        for (int i = 0; i < word.length(); i++) {
            if (grid[row - i][col + i] != word.charAt(i)) return false;
        }
        return true;
    }

    private boolean checkBLTR(String word, int row, int col) {
        int n = grid.length;
        if (row + word.length() > n || col - word.length() + 1 < 0) return false;
        for (int i = 0; i < word.length(); i++) {
            if (grid[row + i][col - i] != word.charAt(i)) return false;
        }
        return true;
    }
}


