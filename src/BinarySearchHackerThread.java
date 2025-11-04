// BinarySearchHackerThread.java (التمرين الإضافي 1)
import javax.swing.JProgressBar;
public class BinarySearchHackerThread extends HackerThread {
    public BinarySearchHackerThread(Vault vault, JProgressBar progressBar) {
        super(vault, progressBar);
        this.setName("Binary Search Hacker");
    }

    @Override
    public void run() {
        int low = 0;
        int high = Vault.MAX_PASSWORD;
        int progress = 0;

        while (low <= high) {
            if (vault.isGameIsOver()) return;

            int guess = (low + high) / 2;
            attemptCount++;
            progressBar.setString("Testing: " + guess);
            int result = vault.checkPasswordHint(guess);

            progressBar.setValue(progress++);

            if (result == 0) {
                reportWin(guess);
                return;
            } else if (result == -1) {
                low = guess + 1;
            } else {
                high = guess - 1;
            }
        }
    }
}