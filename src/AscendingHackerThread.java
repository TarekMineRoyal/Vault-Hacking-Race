public class AscendingHackerThread extends HackerThread {

    public AscendingHackerThread(Vault vault) {
        super(vault);
    }

    @Override
    public void run() {
        for (int guess = 0; guess <= Vault.MAX_PASSWORD; guess++) {
            if (vault.isCorrectPassword(guess)) {
                System.out.println("Ascending hacker won! Password is: " + guess);
                System.exit(0); //
            }
        }
    }
}