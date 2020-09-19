package toy.project.kando.user.service;

import toy.project.kando.user.model.User;

public interface UserService {
	void addUser(User user);
	User login(User user);
	User getUserById(String userId);
}
