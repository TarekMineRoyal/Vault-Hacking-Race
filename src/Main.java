public class Main {
    public static void main(String[] args) {
        // Create a vault with a random password
        Vault vault = new Vault();

        Thread ascendingHacker = new AscendingHackerThread(vault);
        Thread descendingHacker = new DescendingHackerThread(vault);
        Thread police = new PoliceThread();

        ascendingHacker.start();
        descendingHacker.start();
        police.start();
    }
}