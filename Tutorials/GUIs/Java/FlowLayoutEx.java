import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTree;
import java.awt.Dimension;
import java.awt.EventQueue;

public class FlowLayoutEx extends JFrame {

    public FlowLayoutEx() {

        initUI();
    }

    private void initUI() {

        JPanel panel = new JPanel();

        JButton button = new JButton("button");
        panel.add(button);

        JTree tree = new JTree();
        panel.add(tree);

        JTextArea area = new JTextArea("text area");
        area.setPreferredSize(new Dimension(100, 100));

        panel.add(area);

        add(panel);

        pack();

        setTitle("FlowLayout example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            FlowLayoutEx ex = new FlowLayoutEx();
            ex.setVisible(true);
        });
    }
}