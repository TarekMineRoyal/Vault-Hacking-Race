import javax.swing.JProgressBar;

public abstract class HackerThread extends Thread {
    protected Vault vault;
    protected JProgressBar progressBar;
    protected long attemptCount = 0;

    public HackerThread(Vault vault, JProgressBar progressBar) {
        this.vault = vault;
        this.progressBar = progressBar;
        this.setPriority(Thread.MAX_PRIORITY);
    }

    protected void reportWin(int guess) {
        if (!vault.isGameIsOver()) {
            vault.setGameIsOver();
            System.out.println(this.getName() + " won! Password is: " + guess);
            System.out.println("Number of tries: " + attemptCount);
            progressBar.setString("won! (" + guess + ") - Tries: " + attemptCount);
            progressBar.setValue(progressBar.getMaximum());
        }
    }
}