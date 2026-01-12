public class Main {
    public static void main(String[] args) {
        DominoGame game = new DominoGame();

        System.out.println("--- Domino Mechanics Simulation ---");
        System.out.println("Total tiles in stock: " + game.getStockCount());

        int placedCount = 0;

        // Simulation: Try to play as many tiles as possible from the stock
        while (game.getStockCount() > 0) {
            DominoTile drawn = game.drawFromStock();
            boolean success = game.tryToPlace(drawn);

            if (success) {
                placedCount++;
                System.out.println("Placed " + drawn);
            } else {
                System.out.println("Discarded " + drawn + " (No match)");
            }
        }

        System.out.println("\n--- Final Result ---");
        game.printBoard();
        System.out.println("Total tiles on board: " + placedCount);
    }
}
