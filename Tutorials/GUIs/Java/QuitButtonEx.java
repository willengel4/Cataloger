import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

public class QuitButtonEx extends JFrame {
    public QuitButtonEx() {

        initUI();
    }

    private void initUI() {
        JButton quitButton = new JButton("Quit");

        quitButton.addActionListener((event) -> System.exit(0));

        createLayout(quitButton);

        setTitle("Quit button");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createLayout(JComponent... arg) {
        GroupLayout gl = new GroupLayout(getContentPane());
        getContentPane().setLayout(gl);

        gl.setAutoCreateContainerGaps(true);
        gl.setHorizontalGroup(gl.createSequentialGroup().addComponent(arg[0]));
        gl.setVerticalGroup(gl.createSequentialGroup().addComponent(arg[0]));
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            QuitButtonEx ex = new QuitButtonEx();
            ex.setVisible(true);
        });
    }
}