package br.com.control.controller;

import java.util.List;
import java.util.Locale;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
 
import br.com.control.model.User;
import br.com.control.model.UserProfile;
import br.com.control.service.UserProfileService;
import br.com.control.service.UserService;

@Controller
@RequestMapping("/panel/user")
@SessionAttributes("roles")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	MessageSource messageSource;

	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public String listCategorys(ModelMap model) {
		List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("loggedinuser", getPrincipal());
        return "user-list";
	}

	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newCategory(ModelMap model) {
		User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        model.addAttribute("loggedinuser", getPrincipal());
        return "user-new";
	}

	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveCategory(@Valid User user, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
            return "user-new";
        }
 
        if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
            FieldError ssoError =new FieldError("user","ssoId" , messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
            result.addError(ssoError);
            return "user-new";
        }
         
        userService.saveUser(user);
 
        model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " registered successfully");
        model.addAttribute("loggedinuser", getPrincipal());
       
        return "user-list";
	}

	@RequestMapping(value = { "/edit/{ssoId}" }, method = RequestMethod.GET)
	public String editCategory(@PathVariable String ssoId, ModelMap model) {
		User user = userService.findBySSO(ssoId);
        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        model.addAttribute("loggedinuser", getPrincipal());
        return "edit-new";
	}

	@RequestMapping(value = { "/edit/save/{ssoId}" }, method = RequestMethod.POST)
	public String updateCategory(@Valid User user, BindingResult result, ModelMap model, @PathVariable String ssoId) {
		if (result.hasErrors()) {
            return "user-list";
        }
 
        userService.updateUser(user);
 
        model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " updated successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        return "user-list";
	}

	@RequestMapping(value = { "/delete/{ssoId}" }, method = RequestMethod.GET)
	public String deleteCategory(@PathVariable String ssoId) {
		userService.deleteUserBySSO(ssoId);
        return "redirect:/panel/user/user-list";
	}

	private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

}
