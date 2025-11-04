import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        Vault vault = new Vault();

        JFrame frame = new JFrame("Vault cracking race");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new GridLayout(5, 1, 10, 10));

        JLabel timerLabel = new JLabel("Police will arrive in...", SwingConstants.CENTER);
        timerLabel.setFont(new Font("Serif", Font.BOLD, 20));
        timerLabel.setForeground(Color.RED);

        JProgressBar ascendingBar = createProgressBar();
        JProgressBar descendingBar = createProgressBar();
        JProgressBar binaryBar = createProgressBar();

        frame.add(timerLabel);

        JLabel passwordLabel = new JLabel("The password is: " + vault.getPasswordForDisplay(), SwingConstants.CENTER);
        passwordLabel.setFont(new Font("Serif", Font.ITALIC, 16));
        passwordLabel.setForeground(Color.GRAY); // Make it subtle
        frame.add(passwordLabel);

        frame.add(createLabeledBar(ascendingBar, "Ascending Hacker (0 -> 9999)"));
        frame.add(createLabeledBar(descendingBar, "Descending Hacker (9999 -> 0)"));
        frame.add(createLabeledBar(binaryBar, "Binary Search Hacker"));

        Thread ascendingHacker = new AscendingHackerThread(vault, ascendingBar);
        Thread descendingHacker = new DescendingHackerThread(vault, descendingBar);
        int binaryMaxSteps = (int) Math.ceil(Math.log(Vault.MAX_PASSWORD + 1) / Math.log(2));
        binaryBar.setMaximum(binaryMaxSteps);
        Thread binaryHacker = new BinarySearchHackerThread(vault, binaryBar);

        Thread police = new PoliceThread(vault, timerLabel);


        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Starting the race
        ascendingHacker.start();
        descendingHacker.start();
        binaryHacker.start();
        police.start();
    }

    private static JProgressBar createProgressBar() {
        JProgressBar pb = new JProgressBar(0, Vault.MAX_PASSWORD);
        pb.setStringPainted(true);
        return pb;
    }

    private static JPanel createLabeledBar(JProgressBar pb, String label) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel(label), BorderLayout.NORTH);
        panel.add(pb, BorderLayout.CENTER);
        return panel;
    }
}