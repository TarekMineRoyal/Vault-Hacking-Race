import javax.swing.JLabel;

public class PoliceThread extends Thread {
    private Vault vault;
    private JLabel timerLabel;

    public PoliceThread(Vault vault, JLabel timerLabel) {
        this.vault = vault;
        this.timerLabel = timerLabel;
        this.setName("The police");
    }

    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            if (vault.isGameIsOver()) return;

            try {
                timerLabel.setText("Police will arrive in " + i + " seconds...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }

        if (!vault.isGameIsOver()) {
            vault.setGameIsOver();
            timerLabel.setText("Game over for you hackers!");
            System.out.println("Police won!");
        }
    }
}