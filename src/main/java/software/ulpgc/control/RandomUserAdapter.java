package software.ulpgc.control;

import org.jsoup.Jsoup;
import software.ulpgc.control.pojo.RandomUser;
import software.ulpgc.model.User;

import java.io.IOException;

public class RandomUserAdapter implements UserAdapter<RandomUser> {

    @Override
    public User from(RandomUser object) {
        User user = new User()
                .setName(object.getName().first() + " " + object.getName().last())
                .setEmail(object.getEmail())
                .setGender(User.Gender.valueOf(firstUpperCase(object.getGender())));
        loadPhoto(object, user);
        return user;
    }

    private void loadPhoto(RandomUser object, User user) {
        try{
            user.setPhoto(photoFrom(object.getPicture().large()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private byte[] photoFrom(String url) throws IOException {
        return Jsoup.connect(url)
                .ignoreContentType(true)
                .execute()
                .bodyAsBytes();
    }

    private String firstUpperCase(String gender) {
        return gender.substring(0,1).toUpperCase() + gender.substring(1);
    }
}
