package SpringMVC.HomeController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import SpringMVC.Dao.StudentDao;
import SpringMVC.Model.Student;

@Controller
public class HomeController {
	@RequestMapping("/home")
	public String home(Model model) {
		System.out.println("This is Home");
		model.addAttribute("name", "RAJ");
		
		StudentDao studentDao=new StudentDao();
		Student student=studentDao.getStudent();
		model.addAttribute("Student",student);
		return "index";
	}
	
	
	  @GetMapping("/inputForm")
	    public String showInputForm() {
	        return "inputForm";
	    }

	    @PostMapping("/processForm")
	    public ModelAndView processForm(@RequestParam String name, @RequestParam int age, Model model) {
//	        model.addAttribute("name", name);
//	        model.addAttribute("age", age);
//	        System.out.println(name);
//	        return "displayInfo";
	    	return new ModelAndView("displayInfo","name1",name);
	    }
}
