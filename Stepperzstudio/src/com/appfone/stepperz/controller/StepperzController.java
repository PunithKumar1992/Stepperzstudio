package com.appfone.stepperz.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.appfone.stepperz.Dao.CareerDao;
import com.appfone.stepperz.Daoimpl.CareerDaoimpl;
import com.appfone.stepperz.Daoimpl.FeedbackDaoimpl;
import com.appfone.stepperz.Daoimpl.RegistrationDaoimpl;
import com.appfone.stepperz.pojo.Career;
import com.appfone.stepperz.pojo.Feedback;
import com.appfone.stepperz.pojo.Registration;
import com.appfone.stepperz.util.Emailutility;

@Controller
public class StepperzController {
	
	@RequestMapping(value="/KayanNagarGal")
	public ModelAndView KayanNagarGalController()
	{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("KayanNagarGal");
		return mv;
	}

	
	@RequestMapping(value="/MalleshwaramGal")
	public ModelAndView MalleshwaramGalController()
	{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("MalleshwaramGal");
		return mv;
	}
	
	@RequestMapping(value="/SadashivNagarGal")
	public ModelAndView SadashivNagarGalController()
	{
		System.out.println("in controller");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("SadashivNagarGal");
		return mv;
	}
	
	
	@RequestMapping(value="/videosadashiv")
	public ModelAndView SadashivNagarVideoController()
	{
		System.out.println("in controller");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("videosadashiv");
		return mv;
	}
	
	
	@RequestMapping(value="/videokalyan")
	public ModelAndView KalyannagarVideoController()
	{
		System.out.println("in controller");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("videokalyan");
		return mv;
	}

	@RequestMapping(value="/videomalleshwaram")
	public ModelAndView malleshwaramVideoController()
	{
		System.out.println("in controller");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("videomalleshwaram");
		return mv;
	}
	
	@RequestMapping(value="/feedback")
	public String feedbackController(@RequestParam Map<String, String>reqparam, @ModelAttribute("feedback") Feedback feedback1)
	{
		
		String name=reqparam.get("name");
		String email =reqparam.get("email");
		String phone=reqparam.get("phone_number");
		String message=reqparam.get("message");
		
		FeedbackDaoimpl feedback=new FeedbackDaoimpl();
		feedback.saveFeedback(feedback1);
		String bodymsg = "Feed back sended by:"+name
				 +"\n" +"Email id is :"+email
				 +"\n" +"Phone number is:"+phone
				 +"\n" +"Feed Back Message is "+message;
		
		Emailutility.send("stepperzstudio1234@gmail.com", "Feedback Message", bodymsg);
		Emailutility.send(email, "Feed reply", "Thank for your feedback Don't reply this auto generated computer mail");
		
		return "redirect:index.jsp";
	}
	
	@RequestMapping(value="/career")
	public ModelAndView careerController()
	{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("career");
		return mv;
	}
	
	
	
	@RequestMapping(value="/careersubmit")
	public String careersubmitController(@ModelAttribute("career") Career career1)
	{
		System.out.println(career1.getEmail());
		System.out.println(career1.getFirst_name());
		CareerDaoimpl  careersave= new CareerDaoimpl();
		careersave.savecareer(career1);
		
		
		
		return "redirect:index.jsp";
	}
	
	@RequestMapping(value="/regestration")
	public ModelAndView regestrationController()
	{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("regestration");
		return mv;
	}
	
	@RequestMapping(value="/courseregistration")
	public String courseregistrationController(@ModelAttribute("registration") Registration reg1)
	{
		
		RegistrationDaoimpl registration= new RegistrationDaoimpl();
		registration.saveRegistration(reg1);
		
		return "redirect:index.jsp";
	}
	
	@RequestMapping(value="/sadashiv_timetable")
	public ModelAndView sadashiv_timetableController()
	{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sadashiv_timetable");
		return mv;
	}

	
	@RequestMapping(value="/kalyan_timetable")
	public ModelAndView kalyan_timetableController()
	{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("kalyan_timetable");
		return mv;
	}

	
	@RequestMapping(value="/malleshwaram_timetable")
	public ModelAndView malleshwaram_timetableController()
	{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("malleshwaram_timetable");
		return mv;
	}
}
