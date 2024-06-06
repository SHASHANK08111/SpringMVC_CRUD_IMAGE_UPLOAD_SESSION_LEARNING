package SpringTag;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.HttpSessionMutexListener;

@Controller
@SessionAttributes("user")
public class UserController {

	@Autowired
    UserService userService;
	
	@GetMapping("/")
	public String loginPage() {
		return "userLogin";
	}
	
//	@PostMapping("/login")
//	public String userLogin(@RequestParam("userId") int userId,@RequestParam("passWord") String passWord,HttpSession session){
//		User user=userService.getUserById(userId);
//		if(user!=null) {
//			if(user.getPassWord().equals(passWord)) {
//				session.setAttribute("user",user);
//				return "redirect:/showAllUser";
//			}
//		}
//		
//		return "redirect:/SpringTagForm";
//	}
	
	
	@PostMapping("/login")
	public String userLogin(@RequestParam("userId") int userId,@RequestParam("passWord") String passWord,Model model){
		User user=userService.getUserById(userId);
		if(user!=null) {
			if(user.getPassWord().equals(passWord)) {
				model.addAttribute("user", user);
				return "redirect:/showAllUser";
			}
		}
		
		return "redirect:/SpringTagForm";
	}
	
	@GetMapping("/showAllUser")
    public String showAllUser(Model model,HttpSession session) {
		 //User sessionUser=(User) session.getAttribute("user");
		 User sessionUser = (User) model.getAttribute("user");
		 System.out.println(sessionUser);
    	 List<User> userList= userService.getAllUsers();
    	 model.addAttribute("users",userList);
    	 for (User user : userList) {
             if (user.getProfileImage() != null) {
                 String base64Image = Base64.getEncoder().encodeToString(user.getProfileImage());
                 user.setBase64ProfileImage(base64Image);
             }
         }
    	// System.out.println(userList);
    	 return "userDisplay"; 
    }
	
	
//	@GetMapping("logout")
//	public String userLogout(HttpSession session) {
//		session.invalidate();
//		return "redirect:/SpringTagForm";	
//	}
	
	@GetMapping("logout")
	public String userLogout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/SpringTagForm";	
	}
//	
//	@PostMapping("/login")
//	public ResponseEntity<String> userLogin(@RequestParam("userId") int userId, @RequestParam("passWord") String passWord, HttpSession session) {
//	    User user = userService.getUserById(userId);
//	    if (user != null && user.getPassWord().equals(passWord)) {
//	        session.setAttribute("user", user);
//	        return ResponseEntity.ok().build(); // Return HTTP 200 OK
//	    } else {
//	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // Return HTTP 401 Unauthorized
//	    }
//	}

	
	@GetMapping("/SpringTagForm")
	public ModelAndView SpringTagForm(Model model) {
		return new ModelAndView("SpringTagForm").addObject(new User());
	}
	
	

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
    	System.out.println("-----------------------------");
        userService.saveUser(user);
        System.out.println("Saved");
        return "redirect:/SpringTagForm";
    }
    
    
    
    @PostMapping("/deleteUser")
    public String DeleteUser(@RequestParam("userId") int userId) {
    	userService.deleteUser(userId);
    	return "redirect:/showAllUser";
    }
    
    @PostMapping("/updateUser")
    public String UpdateUser(@RequestParam("userId") int userId) {
    	userService.updateUser(userId);
    	return "redirect:/showAllUser";
    }

    @PostMapping("/uploadImage")
    public String uploadImage(
       @RequestParam("userId") int userId,
       @RequestParam("imageFile") MultipartFile profileImageUser) 
         {
    	
    	if(!profileImageUser.isEmpty()) {
    		try {
    			User user= userService.getUserById(userId);
    			byte[] profileImageData=profileImageUser.getBytes();
    			user.setProfileImage(profileImageData);
			    userService.updateUserUsingObject(user);
			} catch (IOException e) {
				return "redirect:/showAllUser";
			}
    	}else {
    		return "redirect:/showAllUser";
		}
    	return "redirect:/showAllUser";
    }
    
}
