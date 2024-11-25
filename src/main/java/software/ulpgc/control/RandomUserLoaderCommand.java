package software.ulpgc.control;

import software.ulpgc.model.User;

import java.util.ArrayList;
import java.util.List;

public class RandomUserLoaderCommand {
    public List<User> execute(){
        List<User> users = new ArrayList<>();
        RandomUserProvider provider = new RandomUserProvider();

        try{
            for (int i = 0; i < 50; i++) users.add(provider.newUser());
            return users;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
