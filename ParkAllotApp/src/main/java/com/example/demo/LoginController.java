package com.example.demo;

//import java.io.*; 
//import java.lang.*; 
//import java.util.Arrays;
//import java.util.regex.Pattern;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.model.User;
import com.example.demo.model.UserRepo;
import com.example.demo.model.Register;
import com.example.demo.model.RegRepo;
import com.example.demo.service.UserserviceInter;
//import com.example.demo.service.Userservice;


@Controller
public class LoginController {
	@Autowired
	private UserserviceInter userservice;
	//private UserRepo userRepo;
	
	@Autowired
	private UserRepo userRepo;
	User u=null;
	
	@Autowired
	private RegRepo regRepo;
	Register r=null;
	 int j=0, i=2;
	
   @RequestMapping("/parking")
   public String Login() {
	return "login";
    }

@RequestMapping("/home")
public String home(@RequestParam("uname") String uname,@RequestParam("psw") String psw,Model model) {
	model.addAttribute("uname", uname);
	
	
	if(uname.equals("Admin") && (psw.equals("admin"))) {
		//@Autowired
		
		
		model.addAttribute("ulist",userservice.getAllRegister());
		return "admin";
	}

	
	try
	{
		u=userRepo.findByName(uname);
	}
	catch(Exception e) 
	{
		//System.out.println("User not found !!!");
		//return "login";
	}
	
	if(u!=null)
	{
		model.addAttribute("uname",uname);
		return "home";
	}
	
	model.addAttribute("error","User Not Found");
	
	return "login";
}
  @RequestMapping("/register")
  public String gotoregister() {
	  return "register";
  }
  @RequestMapping("/set-user")
  public String setUser(@RequestParam("uname") String uname,
		  @RequestParam("email") String email,
		  @RequestParam("phoneno") String phoneno,
		  @RequestParam("psw") String psw,@RequestParam("psw-repeat") String p,Model model) 
  {
	  
	 if(psw.equals(p)) {
		 u=new User();
		 
		   u.setId(i++);
		   u.setName(uname);
		   u.setEmail(email);
		   u.setPhoneno(phoneno);
		   u.setPassword(psw);
		   userRepo.save(u);
		  return "login";
		 
	 }
	 model.addAttribute("error","Password and Repeat password are not same");
	 return "register";
	 
	  
  }
  
  @RequestMapping("/successregister")
  public String successregister(@RequestParam("name") String name,
		  @RequestParam("email") String email,
		  @RequestParam("place") String place,
		  @RequestParam("time") String time,Model model) {
	  r=new Register();
	  
	   r.setId(j++);
	   r.setName(name);
	   r.setEmail(email);
	   r.setPlace(place);
	   r.setTime(time);
	   regRepo.save(r);
	   
	   LocalTime myObj = LocalTime.now();
	   DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("hh:mm");
	   String ct = myObj.format(myFormatObj);
	   int r=60*Integer.parseInt(ct.substring(0,2))+Integer.parseInt(ct.substring(3,5));
	   int q=60*Integer.parseInt(time.substring(0,2))+Integer.parseInt(time.substring(3,5));
	   if(Math.abs(r-q)<=120) {
		   model.addAttribute("msg","But,Your booking is wait listed!!!");
		   //model.addAttribute("msg","Register successful");
		  
	   }
	   
	  // model.addAttribute("msg",Math.abs(r-q));
	   
	  return "success";
  }
  
  @RequestMapping("/setnewuser")
  public String newuser(@RequestParam("name") String name,
		  @RequestParam("email") String email,
		  @RequestParam("place") String place,
		  @RequestParam("time") String time ,Model model) {
	  r=new Register();
	  
	   r.setId(j++);
	   r.setName(name);
	   r.setEmail(email);
	   r.setPlace(place);
	   r.setTime(time);
	   regRepo.save(r);
	   
	   model.addAttribute("ulist",userservice.getAllRegister());
	  return "admin";
  }
  
  
  
  
  
  @RequestMapping("/newuser")
  public String Adduser() {
		return "newuser";
	    }
  
  @RequestMapping("/logout")
  public String logout() {
		return "login";
	    }

  
  
 @RequestMapping("/deleteUser/{id}")
  public String deleteUser(@PathVariable(value = "id") long id,Model model) {

      // call delete employee method 
      this.userservice.deleteUserById(id);
      model.addAttribute("ulist",userservice.getAllRegister());
      return "admin";
  } 


}
