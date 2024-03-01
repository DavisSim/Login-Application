package login.service;

import login.model.User;

public interface UserService {
    User authenticateUser(String userId, String password);
}
