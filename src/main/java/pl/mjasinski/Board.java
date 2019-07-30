package pl.mjasinski;


public class Board {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public int size;

    private boolean[][] grid;

    public Board(int size) {
        this.size = size;
        initGrid();
    }

    public Board(boolean[][] grid) {
        this.grid = grid;
        this.size = this.grid.length;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print((grid[i][j] ? ANSI_RED + "x" + ANSI_RESET : "-") + "  ");
            }
            System.out.println();
        }
    }

    private void initGrid() {
        grid = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = getRandomCellState();
            }
        }
    }

    private boolean getRandomCellState() {
        return Math.random() > 0.7;
    }

    protected int getNeighbours(int x, int y) {

        int aliveNeighbours = 0;

        for (int i = x - 1; i <= x + 1; i++) {
            if (i >= 0 && i < size) {
                for (int j = y - 1; j <= y + 1; j++)
                    if (j >= 0 && j < size) {
                        if (!(i == x && j == y) && grid[i][j]) {
                            aliveNeighbours++;
                        }
                    }
            }
        }
        return aliveNeighbours;
    }

    public boolean tick() {
        boolean isAnyAlive = false;
        boolean[][] newBoard = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                newBoard[i][j] = isCellAliveInNextGen(i,j);

                if (newBoard[i][j] && !isAnyAlive) {
                    isAnyAlive = true;
                }
            }
        }
        grid = newBoard;
        return isAnyAlive;
    }

    private boolean isCellAliveInNextGen(int x, int y) {

        int neighbours = getNeighbours(x,y);

        switch (neighbours) {
            case 2:
                return grid[x][y];
            case 3:
                return true;
            default:
                return false;
        }
    }
}
