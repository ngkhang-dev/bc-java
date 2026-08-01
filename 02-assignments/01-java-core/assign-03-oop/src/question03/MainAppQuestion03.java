package question03;

public class MainAppQuestion03 {
    public static void main(String[] args) {
        int round = 3;

        Game game1 = new Game("Tennis", round);

        game1.startGame();
        for (int i = 0; i < round; i++) {
            System.out.println("Lượt chơi: " + (i + 1));
            game1.setRounds(game1.getRounds() - 1);
        }

        game1.endGame();
    }
}
