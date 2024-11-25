package software.ulpgc.view;

import software.ulpgc.model.User;

import javax.swing.*;

public class MainFrame extends JFrame {
    private final RandomUserDisplay display;

    public MainFrame(){
        setTitle("User");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 800);
        display = new RandomUserDisplay();
        add(display);
    }

    public void put(User user) {
        display.display(user);
    }
}
