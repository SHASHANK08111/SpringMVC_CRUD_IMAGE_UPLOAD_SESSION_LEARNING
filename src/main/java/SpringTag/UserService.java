package SpringTag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
    private UserDao userDao;
    
	public int saveUser(User user) {
		return userDao.saveUser(user);
	}
	
	public List<User> getAllUsers(){
		return userDao.getAllUsers();
	}

	public void deleteUser(int userId) {
		userDao.deleteUser(userId);
	}
	

	public void updateUser(int userId) {
		userDao.updateUser(userId);
	}

	public void saveImage(byte[] profileImageData) {
		User user=new User();
		user.setProfileImage(profileImageData);
		userDao.saveUser(user);
	}

	public User getUserById(int userId) {
		return userDao.getUserById(userId);
	}

	public void updateUserUsingObject(User user) {
		userDao.updateUserUsingObject(user);
		
	}

}
