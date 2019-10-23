import javax.swing.*;

public class HelloHacktoberfest {

    public static void main(String[] args) {
        new HelloWorldFrame();
    }

    static class HelloWorldFrame extends JFrame {

        HelloWorldFrame() {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) { }

            setTitle("Hacktoberfest 2019");
            setSize(300, 150);

            Box box = Box.createVerticalBox();
            box.add(Box.createVerticalGlue());
            box.add(new HelloWorldPanel());
            box.add(Box.createVerticalGlue());
            getContentPane().add(box);

            setLocationRelativeTo(null);
            setVisible(true);
            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }

    static class HelloWorldPanel extends JPanel {

        HelloWorldPanel() {
            add(new JLabel("Hello World! Hello Hacktoberfest!"));
        }
    }
}
