package com.appfone.stepperz.controller;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.appfone.stepperz.Daoimpl.AdminLoginDaoimpl;
import com.appfone.stepperz.Daoimpl.AdminadsDaoimpl;
import com.appfone.stepperz.Daoimpl.AdminbannerDaoimpl;
import com.appfone.stepperz.Daoimpl.AdmincareerDaoimpl;
import com.appfone.stepperz.Daoimpl.AdminfeedbackDaoimpl;
import com.appfone.stepperz.Daoimpl.AdminregistrationDaoimpl;
import com.appfone.stepperz.Daoimpl.AdminstdregDaoimpl;
import com.appfone.stepperz.Daoimpl.AdmintestimonialsDaoimpl;
import com.appfone.stepperz.Daoimpl.Admintime_kalyannagrDaoimpl;
import com.appfone.stepperz.Daoimpl.Admintime_malleshwaramDaoimpl;
import com.appfone.stepperz.Daoimpl.Admintime_sadashivnagrDaoimpl;
import com.appfone.stepperz.Daoimpl.CareerDaoimpl;
import com.appfone.stepperz.Daoimpl.FeedbackDaoimpl;
import com.appfone.stepperz.Daoimpl.RecoveryDaoimpl;
import com.appfone.stepperz.Daoimpl.RegistrationDaoimpl;
import com.appfone.stepperz.pojo.Adminregistration;
import com.appfone.stepperz.pojo.Advertisement;
import com.appfone.stepperz.pojo.Banner;
import com.appfone.stepperz.pojo.Career;
import com.appfone.stepperz.pojo.Feedback;
import com.appfone.stepperz.pojo.Registration;
import com.appfone.stepperz.pojo.Testimonials;
import com.appfone.stepperz.pojo.Timetable_kalyannagar;
import com.appfone.stepperz.pojo.Timetable_malleshwaram;
import com.appfone.stepperz.pojo.Timetable_sadashivnagr;
import com.appfone.stepperz.util.Emailutility;

@Controller
public class StepperzController {
	@Autowired
	ServletContext context; 

	@Autowired
	HttpSession sessionn;
	
	
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
		Registration reg= new Registration();
		ModelAndView mv = new ModelAndView();
		mv.addObject("adminreg", reg);
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
	public String admindashboardController(@RequestParam Map<String, String>reqparam)
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
		sessionn.setAttribute("activeuser", user);
		String activeuser=user;
		mv.addObject("activeuser", activeuser);
		return "redirect:/adminloginsuccess.html";
		}
		
		return "redirect:/adminloginfailure.html";
	}
	
	
	@RequestMapping(value="/adminloginsuccess")
	public ModelAndView adminloginsuccessController()
	{
		if((sessionn.getAttribute("activeuser"))==null)
		{
			ModelAndView mv= new ModelAndView();
			mv.setViewName("login");
			return mv;
		}
		System.out.println("in controller");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Adminindex");
		return mv;
	}
	
	@RequestMapping(value="/adminloginfailure")
	public ModelAndView adminloginfailureController()
	{
		if((sessionn.getAttribute("activeuser"))==null)
		{
			ModelAndView mv= new ModelAndView();
			mv.setViewName("login");
			return mv;
		}
		
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
		
		if((sessionn.getAttribute("activeuser"))==null)
		{
			ModelAndView mv= new ModelAndView();
			mv.setViewName("login");
			return mv;
		
		}
		
			System.out.println("in controller");
			AdminbannerDaoimpl bannerlist=new AdminbannerDaoimpl();
			List list = bannerlist.getbanners();
			ModelAndView mv = new ModelAndView();
			AdminbannerDaoimpl bann=new AdminbannerDaoimpl();
			int size=bann.getBannerdbsize();
			Banner banner = new Banner();
			mv.addObject("banner", banner);
			mv.setViewName("banner");
			mv.addObject("bannsize", size);
			mv.addObject("bannerlist", list);
			return mv;
	}
	
	
	
	
	
	@RequestMapping(value="/bashboard")
	public ModelAndView DashboardController()
	{
		if((sessionn.getAttribute("activeuser"))==null)
		{
			ModelAndView mv= new ModelAndView();
			mv.setViewName("login");
			return mv;
		}
		
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
	
	
	@RequestMapping(value="/savebanner")
	public String savebannerController(@ModelAttribute("banner")Banner banner)
	{
		
		if((sessionn.getAttribute("activeuser"))==null)
		{
			
			return "redirect:/admin.html";
		}
		  MultipartFile file = banner.getFile(); 
		 
		   
		  String fileName = file.getOriginalFilename();  
		  System.out.println("filename is " +fileName);
		  banner.setBanner_img(fileName);
		  String relativepath = "images/banner/"+fileName;
		   String uploadPath = context.getRealPath("") + File.separator + "images" + File.separator +"banner"+ File.separator;
		   System.out.println("uploadpath is" +uploadPath);
		   File targetFile = new File(uploadPath, fileName);  
		  try {
			file.transferTo(targetFile);
			System.out.println("transfer starts");
		} catch (IllegalStateException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		  AdminbannerDaoimpl savebanner = new AdminbannerDaoimpl();
		  savebanner.Savebanner(banner);
		return "redirect:/adminbanner.html";
	}
	
	@RequestMapping(value="/deletebanner")
	public String deletebannerController(@RequestParam("bannerid")int bannerid,@RequestParam("bannerimg")String bannerimg)
	{
		if((sessionn.getAttribute("activeuser"))==null)
		{
			
			return "redirect:/admin.html";
		}
		System.out.println("banner id is" +bannerid);
		System.out.println("banner image is " +bannerimg);
		AdminbannerDaoimpl deletebanner = new AdminbannerDaoimpl();
		deletebanner.deletebanner(bannerid, bannerimg);
		
		   String uploadPath = context.getRealPath("") + File.separator + "images" + File.separator +"banner"+ File.separator;
		
		File file= new File(uploadPath,bannerimg);
		file.delete();
		
		
		return "redirect:/adminbanner.html";
	}
	
	@RequestMapping(value="/editbanner")
	public ModelAndView  bannereditController(@RequestParam("bannerid")int id,@RequestParam("bannerimg")String bannerimg)
	{
		if((sessionn.getAttribute("activeuser"))==null)
		{
			ModelAndView mv= new ModelAndView();
			mv.setViewName("login");
			return mv;
		}
		AdminbannerDaoimpl editbanner=new AdminbannerDaoimpl();
		Banner banner=editbanner.getsinglebanner(id);
		ModelAndView mv= new ModelAndView();
		mv.addObject("banner",banner);
		mv.addObject("imgtoedit", bannerimg);
		mv.setViewName("banneredit");
		
		return mv;
	}
	
	@RequestMapping(value="/saveeditedbanner")
	public String  saveeditedbannerController(@RequestParam("imgtoedit")String imgtoedit,@ModelAttribute("banner")Banner banner)
	{
		if((sessionn.getAttribute("activeuser"))==null)
		{
			
			return "redirect:/admin.html";
		}
		System.out.println("imgtoedit is  " +imgtoedit);
		MultipartFile file = banner.getFile(); 
		System.out.println(""+file.getSize());
		System.out.println(file.getOriginalFilename());
		if(file.getSize()==0)
		{
			System.out.println("image is not choose method");
			banner.setBanner_img(imgtoedit);
			AdminbannerDaoimpl saveeditedbanner = new AdminbannerDaoimpl();
			  saveeditedbanner.Savebanner(banner);
			  
		}
		else if(file.getSize()>0)
		{
			System.out.println("image choose method");
			String uploadPath = context.getRealPath("") + File.separator + "images" + File.separator +"banner"+ File.separator;
			File delfile=new File(uploadPath,imgtoedit);
			delfile.delete();
			String fileName = file.getOriginalFilename();  
			  System.out.println("filename is " +fileName);
			  banner.setBanner_img(fileName);
			  String relativepath = "images/banner/"+fileName;
			   System.out.println("uploadpath is" +uploadPath);
			   File targetFile = new File(uploadPath, fileName);  
			  try {
				file.transferTo(targetFile);
				System.out.println("transfer starts");
			} catch (IllegalStateException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			  			 
		}
		AdminbannerDaoimpl saveeditedbanner = new AdminbannerDaoimpl();
		  saveeditedbanner.Savebanner(banner);
		 return "redirect:/adminbanner.html";
	}
	
	@RequestMapping(value="/sadashivtimetable")
	public ModelAndView  sadashivtimetableController()
	{
		if((sessionn.getAttribute("activeuser"))==null)
		{
			ModelAndView mv= new ModelAndView();
			mv.setViewName("login");
			return mv;
		}
		
		ModelAndView mv= new ModelAndView();
		Timetable_sadashivnagr timetable = new Timetable_sadashivnagr();
		Admintime_sadashivnagrDaoimpl savtime=new Admintime_sadashivnagrDaoimpl();
		List list = savtime.gettimetables();
		mv.addObject("sadatime", timetable);
		mv.addObject("sadatimelist", list);
		mv.setViewName("adminsadashivtimetable");
		return mv;
	}
	
	@RequestMapping(value="/changesadatime")
	public ModelAndView  changesadatimeController(@RequestParam("timeid")int changeid)
	{
		if((sessionn.getAttribute("activeuser"))==null)
		{
			ModelAndView mv= new ModelAndView();
			mv.setViewName("login");
			return mv;
		}
		Admintime_sadashivnagrDaoimpl changeobj= new Admintime_sadashivnagrDaoimpl();
		Timetable_sadashivnagr chhangedobj = changeobj.getsingletime(changeid);
		ModelAndView mv= new ModelAndView();
		mv.setViewName("adminsadashivtimechange");
		mv.addObject("changesadaobj", chhangedobj);
		return mv;
	}
	
	
	@RequestMapping(value="/savesadatimeimgchange")
	public String  savesadatimeimgchangeController(@ModelAttribute("changesadaobj")Timetable_sadashivnagr updateobj )
	{
		if((sessionn.getAttribute("activeuser"))==null)
		{
			
			return "redirect:/admin.html";
		}
		MultipartFile sadafile = updateobj.getSadafile();
		String fileName=sadafile.getOriginalFilename();
		
		if(sadafile.getSize()>0)
		{
			
			String uploadPath = context.getRealPath("") + File.separator + "images" + File.separator +"timetable"+ File.separator +"sadhashivnagar" +File.separator ;
			System.out.println("uploadpath is" +uploadPath);
			String todeletefile =updateobj.getTimetable_image();
			File delfile= new File(uploadPath,todeletefile);
			delfile.delete();
			updateobj.setTimetable_image(fileName);
			 File targetFile = new File(uploadPath, fileName);  
			  try {
				sadafile.transferTo(targetFile);
				System.out.println("transfer starts");
			} catch (IllegalStateException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			  Admintime_sadashivnagrDaoimpl updatetime=new Admintime_sadashivnagrDaoimpl();
			  updatetime.saveSadaTime(updateobj);
	
		}
		
		return "redirect:/sadashivtimetable.html";
	}
	
	
	@RequestMapping(value="/kalyantimetable")
	public ModelAndView  kalyantimetableController()
	{
		if((sessionn.getAttribute("activeuser"))==null)
		{
			ModelAndView mv= new ModelAndView();
			mv.setViewName("login");
			return mv;
		}
		System.out.println("admin kalayan nagar controller");
		
		ModelAndView mv= new ModelAndView();
		Timetable_kalyannagar timetable = new Timetable_kalyannagar();
		Admintime_kalyannagrDaoimpl kalayantime=new Admintime_kalyannagrDaoimpl();
		List list = kalayantime.gettimetables();
		mv.addObject("kalayantime", kalayantime);
		mv.addObject("kalayntimelist", list);
		mv.setViewName("adminkalyantimetable");
		return mv;
	}
	
	

	@RequestMapping(value="/changekalyantime")
	public ModelAndView  changekalyantimeController(@RequestParam("timeid")int changeid)
	{
		if((sessionn.getAttribute("activeuser"))==null)
		{
			ModelAndView mv= new ModelAndView();
			mv.setViewName("login");
			return mv;
		}
		Admintime_kalyannagrDaoimpl changeobj= new Admintime_kalyannagrDaoimpl();
		Timetable_kalyannagar chhangedobj = changeobj.getsingletime(changeid);
		ModelAndView mv= new ModelAndView();
		mv.setViewName("adminkalyantimechange");
		mv.addObject("changekalaobj", chhangedobj);
		return mv;
	}
	
	@RequestMapping(value="/savekalatimeimgchange")
	public String  savekalatimeimgchangeController(@ModelAttribute("changekalaobj")Timetable_kalyannagar updateobj )
	{
		if((sessionn.getAttribute("activeuser"))==null)
		{
			
			return "redirect:/admin.html";
		}
		MultipartFile sadafile = updateobj.getKalafile();
		String fileName=sadafile.getOriginalFilename();
		
		if(sadafile.getSize()>0)
		{
			
			String uploadPath = context.getRealPath("") + File.separator + "images" + File.separator +"timetable"+ File.separator +"kalyannagar" +File.separator ;
			System.out.println("uploadpath is" +uploadPath);
			String todeletefile =updateobj.getTimetable_image();
			File delfile= new File(uploadPath,todeletefile);
			delfile.delete();
			updateobj.setTimetable_image(fileName);
			 File targetFile = new File(uploadPath, fileName);  
			  try {
				sadafile.transferTo(targetFile);
				System.out.println("transfer starts");
			} catch (IllegalStateException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			  Admintime_kalyannagrDaoimpl updatetime=new Admintime_kalyannagrDaoimpl();
			  updatetime.saveSadaTime(updateobj);
	
		}
		
		return "redirect:/kalyantimetable.html";
	}
	
	
	
	
	@RequestMapping(value="/mallesharamtimetable")
	public ModelAndView  mallesharamtimetableController()
	{	
		if((sessionn.getAttribute("activeuser"))==null)
		{
			ModelAndView mv= new ModelAndView();
			mv.setViewName("login");
			return mv;
		}
		System.out.println("admin mallesharam controller");
		
		ModelAndView mv= new ModelAndView();
		Timetable_malleshwaram timetable = new Timetable_malleshwaram();
		Admintime_malleshwaramDaoimpl malleshtime=new Admintime_malleshwaramDaoimpl();
		List list = malleshtime.gettimetables();
		mv.addObject("malleshtime", malleshtime);
		mv.addObject("malleshtimelist", list);
		mv.setViewName("adminmallesharamtimetable");
		return mv;
	}
	
	@RequestMapping(value="/changemalleshtime")
	public ModelAndView  changemalleshtimeController(@RequestParam("timeid")int changeid)
	{
		if((sessionn.getAttribute("activeuser"))==null)
		{
			ModelAndView mv= new ModelAndView();
			mv.setViewName("login");
			return mv;
		}
		Admintime_malleshwaramDaoimpl changeobj= new Admintime_malleshwaramDaoimpl();
		Timetable_malleshwaram chhangedobj = changeobj.getsingletime(changeid);
		ModelAndView mv= new ModelAndView();
		mv.setViewName("adminmallesharamtimechange");
		mv.addObject("changemalaobj", chhangedobj);
		return mv;
	}
	
	
	@RequestMapping(value="/savemalatimeimgchange")
	public String  savemalatimeimgchangeController(@ModelAttribute("changemalaobj")Timetable_malleshwaram updateobj )
	{
		if((sessionn.getAttribute("activeuser"))==null)
		{
			
			return "redirect:/admin.html";
		}
		MultipartFile malafile = updateobj.getMalafile();
		String fileName=malafile.getOriginalFilename();
		
		if(malafile.getSize()>0)
		{
			
			String uploadPath = context.getRealPath("") + File.separator + "images" + File.separator +"timetable"+ File.separator +"malleshwaram" +File.separator ;
			System.out.println("uploadpath is" +uploadPath);
			String todeletefile =updateobj.getTimetable_image();
			File delfile= new File(uploadPath,todeletefile);
			delfile.delete();
			updateobj.setTimetable_image(fileName);
			 File targetFile = new File(uploadPath, fileName);  
			  try {
				malafile.transferTo(targetFile);
				System.out.println("transfer starts");
			} catch (IllegalStateException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			  Admintime_malleshwaramDaoimpl updatetime=new Admintime_malleshwaramDaoimpl();
			  updatetime.saveMalleshTime(updateobj);
	
		}
		
		return "redirect:/mallesharamtimetable.html";
	}
	
	
	@RequestMapping(value="/adminads")
	public ModelAndView adminadsController()
	{
		if((sessionn.getAttribute("activeuser"))==null)
		{
			ModelAndView mv= new ModelAndView();
			mv.setViewName("login");
			return mv;
		}
		ModelAndView mv=new ModelAndView();
		Advertisement ads=new Advertisement();
		AdminadsDaoimpl adsobj=new AdminadsDaoimpl();
		Map<String,String> adslist= new LinkedHashMap();
		adslist.put("promo", "promo");
		adslist.put("hire", "hire");
		List list= adsobj.getads();
		mv.addObject("ads", ads);
		mv.addObject("adsMap", adslist);
		mv.addObject("adslist", list);
		mv.setViewName("adminads");
		return mv;
	}
	
	
	
	
	@RequestMapping(value="/saveadminads")
	public String saveadminadsController(@ModelAttribute("ads")Advertisement adver)
	{
		
		if((sessionn.getAttribute("activeuser"))==null)
		{
			
			return "redirect:/admin.html";
		}
		System.out.println("in ads controller");
		System.out.println(adver.getAds_type());
		MultipartFile file = adver.getAdsfile();
		String fileName=file.getOriginalFilename();
		System.out.println("uploaded file name is " +fileName);
		adver.setAds_images(fileName);
		
		   String uploadPath = context.getRealPath("") + File.separator + "images" + File.separator +"ads"+ File.separator;
		   System.out.println("uploadpath is" +uploadPath);
		   File targetFile = new File(uploadPath, fileName);  
		  try {
			file.transferTo(targetFile);
			System.out.println("transfer starts");
		} catch (IllegalStateException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
		AdminadsDaoimpl newad = new AdminadsDaoimpl();
		newad.saveads(adver);
		return"redirect:/adminads.html";
	}
	
	@RequestMapping(value="/deletead")
	public String deleteadController(@RequestParam("ads_id")int adsid,@RequestParam("ads_img")String adsimg)
	{
		if((sessionn.getAttribute("activeuser"))==null)
		{
			
			return "redirect:/admin.html";
		}
		
		AdminadsDaoimpl deleads= new AdminadsDaoimpl();
		deleads.deletead(adsid);
		   String uploadPath = context.getRealPath("") + File.separator + "images" + File.separator +"ads"+ File.separator;
		System.out.println("ads image path " +uploadPath);
		File file= new File(uploadPath,adsimg);
		file.delete();
		return "redirect:/adminads.html";
	}
	
	
	@RequestMapping(value="/admintestimonials")
	public ModelAndView admintestimonialsController()
	{
		if((sessionn.getAttribute("activeuser"))==null)
		{
			ModelAndView mv= new ModelAndView();
			mv.setViewName("login");
			return mv;
		}
		Testimonials test = new Testimonials();
		AdmintestimonialsDaoimpl gettest= new AdmintestimonialsDaoimpl();
		List list=gettest.getAllTestimonials();
		ModelAndView mv= new ModelAndView();
		mv.setViewName("admintestimonials");
		mv.addObject("testilist", list);
		mv.addObject("testi", test);
		
		return mv;
	}
	
	@RequestMapping(value="/savetestimonial")
	public String savetestimonialController(@ModelAttribute("testi")Testimonials testi)
	{
		
		if((sessionn.getAttribute("activeuser"))==null)
		{
			
			return "redirect:/admin.html";
		}
		AdmintestimonialsDaoimpl savetesti= new AdmintestimonialsDaoimpl();
		savetesti.saveTestimonial(testi);
		
		return "redirect:/admintestimonials.html";
	}
	
	
	@RequestMapping(value="/deletetesti")
	public String deletetestiController(@RequestParam("test_id")int testid)
	{
		if((sessionn.getAttribute("activeuser"))==null)
		{
			return "redirect:/admin.html";
		}
		AdmintestimonialsDaoimpl deletesti = new AdmintestimonialsDaoimpl();
		deletesti.deleteSingleTesti(testid);
		
		
		return "redirect:/admintestimonials.html";
	}

	
	@RequestMapping(value="/edittesti")
	public ModelAndView edittestiController(@RequestParam("test_id")int testid)
	{
		if((sessionn.getAttribute("activeuser"))==null)
		{
			ModelAndView mv= new ModelAndView();
			mv.setViewName("login");
			return mv;
		}
		
		AdmintestimonialsDaoimpl edittest= new AdmintestimonialsDaoimpl();
		Testimonials testt= edittest.getSingleTestimonial(testid);
		ModelAndView mv= new ModelAndView();
		mv.addObject("edittest", testt);
		mv.setViewName("admintestimonialedit");
		return mv;
		
	}
	
	@RequestMapping(value="/saveeditedtesti")
	public String saveeditedtestiController(@ModelAttribute("edittest")Testimonials editest)
	{
		if((sessionn.getAttribute("activeuser"))==null)
		{
			
			return "redirect:/admin.html";
		}
		
		AdmintestimonialsDaoimpl edittest= new AdmintestimonialsDaoimpl();
		edittest.saveTestimonial(editest);
		return "redirect:/admintestimonials.html";
	}
	
	
	@RequestMapping(value="/admincareer")
	public ModelAndView admincareerController()
	{
		if((sessionn.getAttribute("activeuser"))==null)
		{
			ModelAndView mv= new ModelAndView();
			mv.setViewName("login");
			return mv;
		}
		Career careerr = new Career(); 
		ModelAndView mv= new ModelAndView();
		AdmincareerDaoimpl listacareer= new AdmincareerDaoimpl();
		List list=listacareer.getCareers();
		mv.addObject("careerobj", careerr);
		mv.addObject("carrlist", list);
		mv.setViewName("admincareer");
		return mv;
		
		
	}
	
	
	
	
	@RequestMapping(value="/saveadmincareer")
	public String saveadmincareerController(@ModelAttribute("careerobj")Career carerr)
	{
		if((sessionn.getAttribute("activeuser"))==null)
		{
			
			return "redirect:/admin.html";
		}
		
		AdmincareerDaoimpl savecareer=new AdmincareerDaoimpl();
		savecareer.saveCareer(carerr);
		return"redirect:/admincareer.html";

	}
	
	
	
	@RequestMapping(value="/deleteadmincareer")
	public String deleteadmincareerController(@RequestParam("career_id")int career_id)
	{
		if((sessionn.getAttribute("activeuser"))==null)
		{
			
			return "redirect:/admin.html";
		}
		AdmincareerDaoimpl deletecareer= new AdmincareerDaoimpl();
		deletecareer.deleteSingleCareer(career_id);
		return "redirect:/admincareer.html";
	}
	
	@RequestMapping(value="/editadmincareer")
	public ModelAndView editadmincareerController(@RequestParam("career_id")int career_id)
	{
		if((sessionn.getAttribute("activeuser"))==null)
		{
			ModelAndView mv= new ModelAndView();
			mv.setViewName("login");
			return mv;
		}
		
		AdmincareerDaoimpl editcareer = new AdmincareerDaoimpl();
		Career editedcarrer= editcareer.getSingleCareer(career_id);
		
		ModelAndView mv= new ModelAndView();
		mv.addObject("editedcareer", editedcarrer);
		mv.setViewName("admincareeredit");
		return mv;
	}
	
	
	@RequestMapping(value="/adminfeedback")
	public ModelAndView adminfeedbackController()
	{
		if((sessionn.getAttribute("activeuser"))==null)
		{
			ModelAndView mv= new ModelAndView();
			mv.setViewName("login");
			return mv;
		}
		
		AdminfeedbackDaoimpl feed = new AdminfeedbackDaoimpl();
		List feedlist= feed.getFeedbacks();
		ModelAndView mv= new ModelAndView();
		mv.addObject("feedlist", feedlist);
		mv.setViewName("adminfeedback");
		return mv;
	}
	
	
	@RequestMapping(value="/deleteadminfeed")
	public String deleteadminfeedController(@RequestParam("feedback_id")int feedback_id)
	{
		if((sessionn.getAttribute("activeuser"))==null)
		{
			
			return "redirect:/admin.html";
		}
		
		AdminfeedbackDaoimpl delfeed= new AdminfeedbackDaoimpl();
		delfeed.deletefeedback(feedback_id);
		
		return "redirect:/adminfeedback.html";
	}
	
	@RequestMapping(value="/studentregbyadmin")
	public ModelAndView studentregbyadminController()
	{
		if((sessionn.getAttribute("activeuser"))==null)
		{
			ModelAndView mv= new ModelAndView();
			mv.setViewName("login");
			return mv;
		}
		Registration stdreg= new Registration();
		AdminstdregDaoimpl reglist= new AdminstdregDaoimpl();
		List list=reglist.getSavedreglist();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("stdreg", stdreg);
		mv.addObject("stdreglist", list);
		mv.setViewName("studentregbyadmin");
		return mv;
	}
	
	
	@RequestMapping(value="/savestdregbyadmin")
	public String  savestdregbyadminController(@ModelAttribute("stdreg")Registration stdreg)
	{
		if((sessionn.getAttribute("activeuser"))==null)
		{
			
			return "redirect:/admin.html";
		}
		AdminstdregDaoimpl savreg= new AdminstdregDaoimpl();
		savreg.savestdreg(stdreg);
		return "redirect:/studentregbyadmin.html";
	}
	
	@RequestMapping(value="/deletestdreg")
	public String  deletestdregController(@RequestParam("reg_id")int reg_id)
	{
		if((sessionn.getAttribute("activeuser"))==null)
		{
			
			return "redirect:/admin.html";
		}
		AdminstdregDaoimpl delreg= new AdminstdregDaoimpl();
		delreg.deletesinglestdreg(reg_id);
		return "redirect:/studentregbyadmin.html";
	}
	
	
	@RequestMapping(value="adminlogout.html")
	public String adminlogoutController()
	{
		
		sessionn.invalidate();
		return "redirect:/admin.html";
	}
	
	
	
	
	@RequestMapping(value="/timetablelist")
	public ModelAndView timetablelistController()
	{
		if((sessionn.getAttribute("activeuser"))==null)
		{
			ModelAndView mv= new ModelAndView();
			mv.setViewName("login");
			return mv;
		}
		ModelAndView mv= new ModelAndView();
		mv.setViewName("timetablelist");
		return mv;
	}
}



