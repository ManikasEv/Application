package Validations;

public interface IvalidationUser {
  //TODO Example functions add whatever is important . On the implimantation add a constructor that you will set all users
    List<Users> getAllUsers();
    void add(User);
    void update(User);
    void delete(User);
    void checkUser(User);
}
