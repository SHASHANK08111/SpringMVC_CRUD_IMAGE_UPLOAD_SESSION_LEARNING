package SpringTag;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class Main {
	
	public static void main(String[] args) {
		System.out.println("Spring Tag");
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ConfigUser.class);
		User user=new User("s4","Test Address");
//	    UserDao userDao=context.getBean(UserDao.class);
//	    userDao.saveUser(user);
	    //System.out.println(userDao);
//		
		UserService userService=context.getBean(UserService.class);
		userService.saveUser(user);
//		
	}

}
