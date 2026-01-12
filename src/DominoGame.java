import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DominoGame {
    private List<DominoTile> stock; // The face-down pile
    private LinkedList<DominoTile> board; // The tiles on the table

    public DominoGame() {
        this.stock = new ArrayList<>();
        this.board = new LinkedList<>();
        generateTiles();
        Collections.shuffle(stock);
    }

    private void generateTiles() {
        // Generates the 28 unique tiles (0-0 to 6-6)
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                stock.add(new DominoTile(i, j));
            }
        }
    }

    public boolean tryToPlace(DominoTile tile) {
        if (board.isEmpty()) {
            board.add(tile);
            return true;
        }

        // 1. Try matching the Left end of the board
        int leftValue = board.getFirst().getSideA();
        if (tile.getSideB() == leftValue) {
            board.addFirst(tile);
            return true;
        } else if (tile.getSideA() == leftValue) {
            tile.flip();
            board.addFirst(tile);
            return true;
        }

        // 2. Try matching the Right end of the board
        int rightValue = board.getLast().getSideB();
        if (tile.getSideA() == rightValue) {
            board.addLast(tile);
            return true;
        } else if (tile.getSideB() == rightValue) {
            tile.flip();
            board.addLast(tile);
            return true;
        }

        return false; // Could not be placed
    }

    public DominoTile drawFromStock() {
        if (stock.isEmpty()) return null;
        return stock.remove(0);
    }

    public void printBoard() {
        if (board.isEmpty()) {
            System.out.println("Board is empty.");
        } else {
            System.out.println("Current Board: " + board);
        }
    }

    public int getStockCount() {
        return stock.size();
    }
}