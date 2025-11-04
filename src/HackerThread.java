public abstract class HackerThread extends Thread {
    protected Vault vault;

    public HackerThread(Vault vault) {
        this.vault = vault;
        this.setPriority(Thread.MAX_PRIORITY);
    }
}