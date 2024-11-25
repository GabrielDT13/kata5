package software.ulpgc.control;

import software.ulpgc.model.User;

public interface UserAdapter<T> {
    User from(T object);
}
