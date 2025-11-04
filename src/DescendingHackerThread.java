// DescendingHackerThread.java
import javax.swing.JProgressBar;
public class DescendingHackerThread extends HackerThread {
    public DescendingHackerThread(Vault vault, JProgressBar progressBar) {
        super(vault, progressBar);
        this.setName("Descending Hacker");
    }

    @Override
    public void run() {
        for (int guess = Vault.MAX_PASSWORD; guess >= 0; guess--) {
            if (vault.isGameIsOver()) return;

            attemptCount++;

            progressBar.setString("Testing: " + guess);

            if (vault.isCorrectPassword(guess)) {
                reportWin(guess);
                return;
            }
            progressBar.setValue(Vault.MAX_PASSWORD - guess);
        }
    }
}