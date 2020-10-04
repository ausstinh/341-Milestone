package src.com.gcu.controller;

import src.com.gcu.model.Credentials;
import src.com.gcu.model.User;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import src.com.gcu.business.UsersBusinessService;
import src.com.gcu.data.DatabaseException;

@Controller
@RequestMapping("/user")
public class CredentialsController {
	
	UsersBusinessService service = new UsersBusinessService();

	/**
	 * Displays the registration form to the user with an empty user object
	 * @return ModelAndView - sends the user to the registration page with a blank user
	 */
	@RequestMapping(path="/registration", method=RequestMethod.GET)
	public ModelAndView displayRegistrationForm()
	{
		return new ModelAndView("Register", "user", new User());
	}
	
	/**
	 * Displays the user the login form and send a empty user to the view in order to fill with information inputed by the user
	 * @return ModelAndView - send the user to the login page with an empty user credentials objects
	 */
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public ModelAndView displayLoginForm()
	{
		return new ModelAndView("Login", "credentials", new Credentials());
	}
	
	/**
	 * method to be able to login the user
	 * @param credentials
	 * @return ModelAndView - attempt to authenticate user with inputed credentials
	 * @throws DatabaseException 
	 */
	@RequestMapping(path="/loginuser", method=RequestMethod.POST)
	public ModelAndView loginUser(@Valid @ModelAttribute("credentials")Credentials credentials, BindingResult results) throws DatabaseException 
	{	
		if(results.hasErrors())
		{
			return new ModelAndView("Login", "credentials", credentials);
		}
	// log in user by invoking the business service 
	
		User user = service.authenticateUser(credentials);
		if(user != null) 
		{
			return new ModelAndView("index", "user", user);	
		}
		else 
		{
			return new ModelAndView("ErrorPage");
		}
	}
	
	/**
	 * add a new person by going through the business logic in the business service.
	 * @param credentials
	 * @return ModelAndView - attempt to register user with new user fields
	 */
	@RequestMapping(path="/registeruser", method=RequestMethod.POST)
	public ModelAndView registerUser(@Valid @ModelAttribute("user")User user, BindingResult results)
	{		
		if(results.hasErrors())
		{
			return new ModelAndView("Register", "user", user);
		}
		// check credentials to see if user already exists.
		if(service.authenticateRegistration(user) == true)
		{
			return new ModelAndView("Login", "credentials", new Credentials());			
		}
		else 
		{
			return new ModelAndView("errorPage");
		}			
	}	
	/**
	 * logout active user
	 */
	@RequestMapping(path="/logout", method=RequestMethod.GET)
	public ModelAndView logoutUser() throws DatabaseException 
	{	
		return new ModelAndView("Login", "credentials", new Credentials());	
	}
}
