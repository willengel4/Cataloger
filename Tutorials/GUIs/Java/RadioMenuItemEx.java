import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;

public class RadioMenuItemEx extends JFrame {

    private JLabel statusbar;

    public RadioMenuItemEx() {

        initUI();
    }

    private void initUI() {

        createMenuBar();

        statusbar = new JLabel("Easy");
        statusbar.setBorder(BorderFactory.createEtchedBorder());
        add(statusbar, BorderLayout.SOUTH);

        setTitle("JRadioButtonMenuItem");
        setSize(360, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createMenuBar() {

        JMenuBar menubar = new JMenuBar();
        JMenu difMenu = new JMenu("Difficulty");
        difMenu.setMnemonic(KeyEvent.VK_F);

        ButtonGroup difGroup = new ButtonGroup();

        JRadioButtonMenuItem easyRMenuItem = new JRadioButtonMenuItem("Easy");
        easyRMenuItem.setSelected(true);
        difMenu.add(easyRMenuItem);

        easyRMenuItem.addItemListener((e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                statusbar.setText("Easy");
            }
        });

        JRadioButtonMenuItem mediumRMenuItem = new JRadioButtonMenuItem("Medium");
        difMenu.add(mediumRMenuItem);

        mediumRMenuItem.addItemListener((e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                statusbar.setText("Medium");
            }
        });

        JRadioButtonMenuItem hardRMenuItem = new JRadioButtonMenuItem("Hard");
        difMenu.add(hardRMenuItem);

        hardRMenuItem.addItemListener((e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                statusbar.setText("Hard");
            }
        });

        difGroup.add(easyRMenuItem);
        difGroup.add(mediumRMenuItem);
        difGroup.add(hardRMenuItem);

        menubar.add(difMenu);

        setJMenuBar(menubar);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            RadioMenuItemEx ex = new RadioMenuItemEx();
            ex.setVisible(true);
        });
    }
}