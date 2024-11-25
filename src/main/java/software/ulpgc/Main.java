package software.ulpgc;

import software.ulpgc.control.RandomUserLoaderCommand;
import software.ulpgc.model.User;
import software.ulpgc.view.MainFrame;

import java.util.List;
import java.util.Random;

public class Main{
    public static void main(String[] args) {
        List<User> users = new RandomUserLoaderCommand().execute();

        User user = getRandomUser(users);
        display(user);
    }

    private static void display(User user) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.put(user);
        mainFrame.setVisible(true);
    }

    private static User getRandomUser(List<User> users){
        Random random = new Random();
        int i = random.nextInt(users.size());
        return users.get(i);
    }
}
