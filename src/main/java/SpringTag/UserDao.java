package SpringTag;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
    @Autowired
	private HibernateTemplate hibernateTemplate;
	
	public UserDao() {

	}
	

	@Transactional
	public int saveUser(User user) {
		return (int) hibernateTemplate.save(user);
	}


	public List<User> getAllUsers() {
		return hibernateTemplate.loadAll(User.class);
	}
	
	public User getUserById(int userId) {
		return hibernateTemplate.get(User.class,userId);
	}

   @Transactional
	public void deleteUser(int userId) {
		User user=getUserById(userId);
	    hibernateTemplate.delete(user);
	}
   
   @Transactional
  	public void updateUser(int userId) {
  		User user=getUserById(userId);
  		user.setPassWord("Updated");
  	    hibernateTemplate.update(user);
  	}

	@Transactional
	public void updateUserUsingObject(User user) {
		hibernateTemplate.update(user);
	}


}
