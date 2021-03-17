package com.springmvc.Controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
//import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.Model.Employee;
import com.springmvc.Model.Student;
import com.springmvc.Service.EmployeeService;
import com.springmvc.util.ExcelUserListReportView;
import com.springmvc.util.PdfUserListReportView;


@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	MessageSource messageSource;
	
	//method level  and class level
	/*
	@Autowired
    FileValidator fileValidator;*/
	
	/*@InitBinder("fileBucket")
    protected void initBinder(WebDataBinder binder) {
       binder.setValidator(fileValidator);
    }
	*/
	/*@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;*/
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listEmployees(ModelAndView model,HttpServletRequest req, HttpServletResponse res) {

		
		String typeReport = req.getParameter("type");
		System.out.println(".........." + typeReport);
		List<Employee> employees = employeeService.findAllEmployees();

		if (typeReport != null && typeReport.equals("xls")) {
			return new ModelAndView(new ExcelUserListReportView(), "employees", employees);
		} else if (typeReport != null && typeReport.equals("pdf")) {
			return new ModelAndView(new PdfUserListReportView(), "employees", employees);
		}

		// return new ModelAndView("userListReport", "userList", list);
		return new ModelAndView("allemployees", "employees", employees);
		
		
		/*
		 * List<Employee> employees = employeeService.findAllEmployees();
		 * model.addObject("employees", employees); return model;
		 */
		
		
		
	}
	
	/*
	 * @RequestMapping(value = { "/"}, method = RequestMethod.GET) public String
	 * defaultPage() { System.out.println("defaultPage"); return "login"; }
	 */
	
	//ModelMap : it is use when building model data for use with UI tools.
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newEmployee(ModelMap model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		model.addAttribute("edit", false);
		return "registration";
	}
	
	// controller method for PDF Generation..
	 @RequestMapping(value="/generatePDF",method = RequestMethod.GET)
	    public String getDocuments(Model model) {
			List<Employee> employees = employeeService.findAllEmployees();
			model.addAttribute("employees", employees);
			return "indexPDF";
	    }
	
	
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveEmployee(@Valid Employee employee, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		}
		/*
		 * if(!employeeService.isEmployeeSsnUnique(employee.getId(),
		 * employee.getSsn())){ FieldError ssnError =new
		 * FieldError("employee","ssn",messageSource.getMessage("non.unique.ssn", new
		 * String[]{employee.getSsn()}, Locale.getDefault()));
		 * result.addError(ssnError); return "registration"; }
		 */
		employeeService.saveEmployee(employee);

		model.addAttribute("success", "Employee " + employee.getName() + " registered successfully");
		return "success";
	}

		
	
	@RequestMapping(value = { "/edit-{ssn}-employee" }, method = RequestMethod.GET)
	public String editEmployee(@PathVariable String ssn, ModelMap model) {
		Employee employee = employeeService.findEmployeeBySsn(ssn);
		model.addAttribute("employee", employee);
		model.addAttribute("edit", true);
		return "registration";
	}
	
	@RequestMapping(value = { "/edit-{ssn}-employee" }, method = RequestMethod.POST)
	public String updateEmployee(@Valid Employee employee, BindingResult result,
			ModelMap model, @PathVariable String ssn) {

		if (result.hasErrors()) {
			return "registration";
		}

		if(!employeeService.isEmployeeSsnUnique(employee.getId(), employee.getSsn())){
			FieldError ssnError =new FieldError("employee","ssn",messageSource.getMessage("non.unique.ssn", new String[]{employee.getSsn()}, Locale.getDefault()));
		    result.addError(ssnError);
			return "registration";
		}

		employeeService.updateEmployee(employee);

		model.addAttribute("success", "Employee " + employee.getName()	+ " updated successfully");
		return "success";
	}

	
	/*
	 * This method will delete an employee by it's SSN value. /delete-${employee.ssn}-employee
	 */
	@RequestMapping(value = { "/delete-{ssn}-employee" }, method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable String ssn) {
		employeeService.deleteEmployeeBySsn(ssn);
		return "redirect:/list";
	}
	
	
	 /**
     * This method handles Access-Denied redirect.
     */
    /*@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("loggedinuser", getPrincipal());
        return "accessDenied";
    }
 */
    /**
     * This method handles login GET requests.
     * If users is already logged-in and tries to goto login page again, will be redirected to list page.
     */
	
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(HttpServletRequest request, HttpServletResponse response) {
       /* if (isCurrentAuthenticationAnonymous()) {
            return "login";
        } else {
            return "redirect:/list";  
        }*/
     /*  String exceptionOccured = "NULL";
       if(exceptionOccured.equalsIgnoreCase("NULL")) {
    	   throw new NullPointerException("Given name is too short");
       }
       */
       String username = request.getParameter("ssoId");
       String passworduserEnterd = request.getParameter("password");
      /* System.out.println("username...."+username+"..passworduserEnterd...."+passworduserEnterd);
       
       Employee employee = (Employee) employeeService.userLogin();
       String usernameBacked = employee.getName();
      */
       
       
       if(username =="Anilkumar" && passworduserEnterd == "Siripuram") {
    	   System.out.println("If Block enterd");
    	   return "redirect:/list";   
       }
       else {
    	   System.out.println("else block enterd");
    	  // return "denied";
    	   return "redirect:/list";
       }
       //return "redirect:/list";
    }
    
    @ExceptionHandler(value=NullPointerException.class)
    public String handleNullPointerException(Exception e) {
    	System.out.println("Exception Occcurred");
    	return "exceptionerror";
    }
    
    
    
   /* @RequestMapping(value = { "/add-document-{userId}" }, method = RequestMethod.GET)
    public String addDocuments(@PathVariable int userId, ModelMap model) {
        Employee employee = employeeService.findById(userId);
		model.addAttribute("employee", employee);
 
        FileBucket fileModel = new FileBucket();
        model.addAttribute("fileBucket", fileModel);
 
        List<UserDocument> documents = (List<UserDocument>) employeeService.findById(userId);
        model.addAttribute("documents", documents);
         
        return "managedocuments";
    }
    */
 
    /**
     * This method handles logout requests.
     * Toggle the handlers if you are RememberMe functionality is useless in your app.
     */
    /*@RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            //new SecurityContextLogoutHandler().logout(request, response, auth);
            persistentTokenBasedRememberMeServices.logout(request, response, auth);
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return "redirect:/login?logout";
    }
 */
    /**
     * This method returns the principal[user-name] of logged-in user.
     */
    /*private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }*/
     
    /**
     * This method returns true if users is already authenticated [logged-in], else false.
     */
   /* private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }*/
    
    
    @RequestMapping(value="/test/{CountryName}/{username}",method=RequestMethod.GET)
    public ModelAndView test(@PathVariable Map<String, String> pathVars) {
    	
    	
    	//@PathVariable("username") String name,@PathVariable("CountryName") String countryName is Equals to
    	
    	
    	ModelAndView model = new ModelAndView("firstPage");
    	//if we have a n no of Inputs then we need to give @pathVariable annotation that many times.
    	//but it is not an good idea /good programming so to Overcome this we have another idea. like as follows
    	//(@pathVariable Map<String,String> pathVars) now we can retrive the value by providing the key. like pathVars.getUsername.
    	String name=pathVars.get("username");
    	String countryName=pathVars.get("CountryName");
    	
    	
    	//model.addObject("msg", "Hello User....."+name);
    	model.addObject("msg1", "Hello User....."+countryName);
    	
    	return model;
    }
    
    
    @ModelAttribute
    public void addObject(Model model) {
    	model.addAttribute("msg1", "Welcome user...this is From the ModelAttribute Annotation");
    }
    
    
   //@RequestParam : this can be used to get the values in Controller class in a request.
    //Instead of RequestParam .we will go for @ModelAttribute for binding the data.
    //@ModelAttribute("FormName/beanName") : it will automatically bind all the Incoming Requests.
    
    
   @RequestMapping(value="/submitData",method=RequestMethod.POST)
    public ModelAndView submittingFormElements(@ModelAttribute("student") Student student) {
    	ModelAndView model = new ModelAndView();
    //	model.addObject(attributeName, attributeValue)
    	
    	return model;
    }
    
    
}
