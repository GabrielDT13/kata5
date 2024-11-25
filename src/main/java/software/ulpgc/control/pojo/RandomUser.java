package software.ulpgc.control.pojo;

public class RandomUser {
    private String gender;
    private Name name;
    private String email;
    private Picture picture;

    public record Name(String title, String first, String last){};
    public record Picture(String large, String medium, String thumbnail){};

    public String getGender() {
        return gender;
    }

    public Name getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Picture getPicture() {
        return picture;
    }
}
