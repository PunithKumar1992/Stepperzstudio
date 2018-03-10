package com.appfone.stepperz.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.appfone.stepperz.Daoimpl.AdminLoginDaoimpl;
import com.appfone.stepperz.Daoimpl.AdminbannerDaoimpl;
import com.appfone.stepperz.Daoimpl.AdminregistrationDaoimpl;
import com.appfone.stepperz.Daoimpl.BannerDaoimpl;
import com.appfone.stepperz.Daoimpl.CareerDaoimpl;
import com.appfone.stepperz.Daoimpl.FeedbackDaoimpl;
import com.appfone.stepperz.Daoimpl.RecoveryDaoimpl;
import com.appfone.stepperz.Daoimpl.RegistrationDaoimpl;
import com.appfone.stepperz.pojo.Adminregistration;
import com.appfone.stepperz.pojo.Banner;
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
	
	@InitBinder
	public void initBinder(WebDataBinder  dataBinder)
	{
		StringTrimmerEditor editor=new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, editor);
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
	
	@RequestMapping(value="/admin")
	public ModelAndView adminLoginController()
	{
		System.out.println("in controller");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	@RequestMapping(value="/registration")
	public ModelAndView adminRegistrationController(Model model)
	{
		Adminregistration adminreg= new Adminregistration();
		System.out.println("in controller");
		model.addAttribute("adminreg",adminreg);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adminregistration");
		return mv;
	}
	
	@RequestMapping(value="/adminregistration")
	public ModelAndView  adminregprocessController(@Valid @ModelAttribute("adminreg") Adminregistration adminregg,BindingResult result )
	{
		System.out.println(result);
		System.out.println("in controller");
		
		if(result.hasErrors())
		{
			System.out.println("errors");
			ModelAndView mv=new  ModelAndView();
			mv.setViewName("adminregistration");
			return mv;
			
		}
		else
		{
			System.out.println("no errors");
		AdminregistrationDaoimpl saveAdmin=new AdminregistrationDaoimpl();
		saveAdmin.saveAdmin(adminregg);
		ModelAndView mv=new  ModelAndView();
		mv.setViewName("login");
		return mv;
		}
	}
	@RequestMapping(value="/admindashboard")
	public String admindashboardController(@RequestParam Map<String, String>reqparam,HttpServletRequest request)
	{
		String user=reqparam.get("username");
		String pass= reqparam.get("password1");
		System.out.println("in controller");
		AdminLoginDaoimpl admcheck=new AdminLoginDaoimpl();
		int res=admcheck.validateAdmin(user, pass);
		if(res==1)
		{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Adminindex");
		HttpSession session = request.getSession();
		session.setAttribute("activeuser", user);
		String activeuser=user;
		mv.addObject("activeuser", activeuser);
		return "redirect:/adminloginsuccess.html";
		}
		/*ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		String err="Username or Password Missmatch";
		mv.addObject("error", err);*/
		return "redirect:/adminloginfailure.html";
	}
	
	
	@RequestMapping(value="/adminloginsuccess")
	public ModelAndView adminloginsuccessController()
	{
		System.out.println("in controller");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Adminindex");
		return mv;
	}
	
	@RequestMapping(value="/adminloginfailure")
	public ModelAndView adminloginfailureController()
	{
		System.out.println("in controller");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		String err="Username or Password Missmatch";
		mv.addObject("error", err);
		return mv;
	}
	
	@RequestMapping(value="/adminbanner")
	public ModelAndView adminbannerController()
	{
		System.out.println("in controller");
		AdminbannerDaoimpl bannerlist=new AdminbannerDaoimpl();
		List list = bannerlist.getbanners();
		ModelAndView mv = new ModelAndView();
		Banner banner = new Banner();
		mv.addObject("banner", banner);
		mv.setViewName("banner");
		mv.addObject("bannerlist", list);
		return mv;
	}
	
	
	
	
	
	@RequestMapping(value="/bashboard")
	public ModelAndView DashboardController()
	{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Adminindex");
		return mv;
	}
	
	@RequestMapping(value="/forgotusername")
	public ModelAndView forgotusernameController()
	{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("forgotusername");
		return mv;
	}
	
	@RequestMapping(value="/forgotcredentials")
	public ModelAndView forgotcredentialsController()
	{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("recoverycredentials");
		return mv;
	}
	
	@RequestMapping(value="/recovery")
	public ModelAndView recoveryController(@RequestParam("email")String email)
	{
		RecoveryDaoimpl recovery=new RecoveryDaoimpl();
		int res=recovery.checkMailidtosend(email);
		if(res==1)
		{
			String username=recovery.getusername(email);
			String password=recovery.getpassword(email);
			String subject ="login credentials Recovery ";
			String msg="Dear Admin your username and password is as follows \n \n \n Username :" +username +"\n Password is :"+password +"\n \n \n Please don't reply to this message this is computer generated";
		Emailutility.send(email, subject, msg);
			ModelAndView mv = new ModelAndView();
		mv.setViewName("popup");
		return mv;
		}
		ModelAndView mv=new ModelAndView();
		mv.setViewName("recoverycredentials");
		String recerror="please enter the registred email id";
		mv.addObject("recerr", recerror);
		return mv;
		
		
	}
	
}
