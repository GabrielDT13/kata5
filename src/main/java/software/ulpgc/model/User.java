package software.ulpgc.model;

public class User {
    private String name;
    private String surname;
    private String email;
    private Gender gender;
    private byte[] photo;

    public enum Gender{Male, Female};

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public Gender getGender() {
        return gender;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public User setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public User setPhoto(byte[] photo) {
        this.photo = photo;
        return this;
    }
}
