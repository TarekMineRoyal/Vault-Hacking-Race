import java.util.Random;

public class Vault {
    public static final int MAX_PASSWORD = 9999;
    private int password;

    public Vault() {
        this.password = new Random().nextInt(MAX_PASSWORD + 1);
        System.out.println("The real password is: " + this.password);
    }

    public boolean isCorrectPassword(int guess) {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return guess == this.password;
    }
}