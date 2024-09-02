import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {
    Player player1 = new Player(1, "Игорь", 140);
    Player player2 = new Player(2, "Анна", 120);
    Player player3 = new Player(3, "Олег", 140);
    Game game = new Game();

    @Test
    public void testFirstPlayerIsStronger() {
        game.register(player1, "Duke");
        game.register(player2, "Queen");

        int expected = 1;
        int actual = game.round("Игорь", "Анна");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSecondPlayerIsStronger() {
        game.register(player1, "Duke");
        game.register(player2, "Queen");

        int expected = 2;
        int actual = game.round("Анна", "Игорь");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPlayersStrengthIsEqual() {
        game.register(player1, "Duke");
        game.register(player3, "King");

        int expected = 0;
        int actual = game.round("Олег", "Игорь");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFirstPlayerIsNotRegistered() {
        game.register(player3, "King");

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Игорь", "Олег");
        });
    }

    @Test
    public void testSecondPlayerIsNotRegistered() {
        game.register(player3, "King");

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Олег", "Игорь");
        });
    }
}