package software.ulpgc.control;

import com.google.gson.Gson;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import software.ulpgc.control.pojo.RandomUserResponse;
import software.ulpgc.model.User;

import java.io.IOException;

public class RandomUserProvider implements UserProvider{
    private static final String URL = "https://randomuser.me/api/";

    @Override
    public User newUser() throws IOException {
        Connection connection = Jsoup.connect(URL).ignoreContentType(true);
        RandomUserResponse response = new Gson().fromJson(connection.get().text(), RandomUserResponse.class);
        return new RandomUserAdapter().from(response.getResults().getFirst());
    }
}
