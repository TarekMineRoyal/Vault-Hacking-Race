import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class Vault {
    public static final int MAX_PASSWORD = 9999;
    private int password;

    private AtomicBoolean gameIsOver = new AtomicBoolean(false);

    public Vault() {
        this.password = new Random().nextInt(MAX_PASSWORD + 1);
        System.out.println("Password is: " + this.password);
    }

    // الدالة الأصلية
    public boolean isCorrectPassword(int guess) {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
        }
        return guess == this.password;
    }

    public int checkPasswordHint(int guess) {
        try {
            Thread.sleep(500); // a little more delayed because the binary hacker was super fast
        } catch (InterruptedException e) {}

        if (guess == this.password) {
            return 0;
        } else if (guess < this.password) {
            return -1;
        } else {
            return 1;
        }
    }

    public boolean isGameIsOver() {
        return gameIsOver.get();
    }

    public void setGameIsOver() {
        this.gameIsOver.set(true);
    }

    public int getPasswordForDisplay() {
        return this.password;
    }
}