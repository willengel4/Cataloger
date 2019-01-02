import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class SimpleMenuEx extends JFrame {
    public SimpleMenuEx() {
        initUI();
    }

    private void initUI() {
        createMenuBar();

        setTitle("Simple menu");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createMenuBar() {
        JMenuBar menubar = new JMenuBar();
        ImageIcon exitIcon = new ImageIcon("src/resources/exit.png");

        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        JMenuItem eMenuItem = new JMenuItem("Exit", exitIcon);
        eMenuItem.setMnemonic(KeyEvent.VK_E);
        eMenuItem.setToolTipText("Exit application");
        eMenuItem.addActionListener((event) -> System.exit(0));

        fileMenu.add(eMenuItem);
        menubar.add(fileMenu);

        setJMenuBar(menubar);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            SimpleMenuEx ex = new SimpleMenuEx();
            ex.setVisible(true);
        });
    }
}