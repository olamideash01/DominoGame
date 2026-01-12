public class DominoTile {
    private int sideA;
    private int sideB;

    public DominoTile(int sideA, int sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public int getSideA() { return sideA; }
    public int getSideB() { return sideB; }

    // Swaps sideA and sideB so the tile can fit the board
    public void flip() {
        int temp = sideA;
        sideA = sideB;
        sideB = temp;
    }

    @Override
    public String toString() {
        return "[" + sideA + "|" + sideB + "]";
    }
}