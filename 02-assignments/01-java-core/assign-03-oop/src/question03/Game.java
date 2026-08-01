package question03;

public class Game {
    private String name;
    private int rounds;

    public Game() {
    }

    public Game(String name, int rounds) {
        this.name = name;
        this.rounds = rounds;
    }

    public void startGame() {
        System.out.printf("Trò chơi: %-20s - Lượt chơi: %3d - [Bắt đầu]\n", name, rounds);
    }

    public void endGame() {
        System.out.printf("Trò chơi: %-20s - Lượt chơi: %3d - [Kết thúc]\n", name, rounds);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }
}
