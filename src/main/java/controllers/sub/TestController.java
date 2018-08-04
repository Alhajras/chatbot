package controllers.sub;


import java.io.FileReader;
import java.io.IOException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@RestController
public class TestController {

	 @RequestMapping("/login")
	 @GetMapping
	public ModelAndView firstPage() {
		
//		ModelAndView v = new ModelAndView("welcome");
//		
		System.err.println("controller");
		return new ModelAndView("login");
	}
	

}

