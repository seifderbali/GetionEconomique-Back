package tn.esprit.services;

import tn.esprit.entities.User;

import java.util.List;

public interface IUserService {
    List<User> retreiveAllUsers();
    User addUser(User u);
    void deleteUser(long id);
    User updateUser(User u);
    User retrieveUser(long id);
    String retrieveUserRole(long id);
    List<User> searchUser(String keyword);
    User DoLogin(String  mail, String mdp);
    User recover(String mail);
<<<<<<< HEAD
    void sendMeet(String[] mails, String name);
=======
>>>>>>> 4891e145863e5307dee80c29251c0241eb8316d2

}
