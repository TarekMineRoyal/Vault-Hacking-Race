// AscendingHackerThread.java
import javax.swing.JProgressBar;
public class AscendingHackerThread extends HackerThread {
    public AscendingHackerThread(Vault vault, JProgressBar progressBar) {
        super(vault, progressBar);
        this.setName("Ascending Hacker");
    }

    @Override
    public void run() {
        for (int guess = 0; guess <= Vault.MAX_PASSWORD; guess++) {
            if (vault.isGameIsOver()) return;

            attemptCount++;

            progressBar.setString("Testing: " + guess);

            if (vault.isCorrectPassword(guess)) {
                reportWin(guess);
                return;
            }
            progressBar.setValue(guess);
        }
    }
}