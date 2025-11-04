public class PoliceThread extends Thread {
    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            try {
                System.out.println("Police arrive in " + i + " seconds...");
                Thread.sleep(1000); //
            } catch (InterruptedException e) {
                e.printStackTrace(); //
            }
        }

        System.out.println("Game over for you hackers!");
        System.exit(0); //
    }
}