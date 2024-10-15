package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);

    User findById(int id);

    void update(int id,User user);

    void delete(int id);

    List<User> findAll();
}
