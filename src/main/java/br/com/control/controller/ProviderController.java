package br.com.control.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.com.control.model.Provider;
import br.com.control.service.ProviderService;

@Controller
@RequestMapping("/panel/provider")
@SessionAttributes("roles")
public class ProviderController {

	@Autowired		
    ProviderService providerService;
     
    @Autowired
    MessageSource messageSource;
    
    @RequestMapping(value = {"/", "/list" }, method = RequestMethod.GET)
    public String listProvider(ModelMap model) {
        List<Provider> provider = providerService.findAll();
        model.addAttribute("provider", provider);
        model.addAttribute("loggedinuser", getPrincipal());
        return "provider-list";
    }
 
    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newProvider(ModelMap model) {
		Provider provider = new Provider();
        model.addAttribute("provider", provider);
        model.addAttribute("edit", false);
        model.addAttribute("loggedinuser", getPrincipal());
        return "provider-new";
    }

    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String saveProvider(@Valid Provider provider, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "provider-new";
        }
         
        providerService.save(provider);
 
        model.addAttribute("success", "Provider " + provider.getName() + " cadastrado com sucesso");
        model.addAttribute("loggedinuser", getPrincipal());
       
        return "redirect:/panel/provider/list";
    }

    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
    public String editProvider(@PathVariable int id, ModelMap model) {
		Provider provider = providerService.findById(id);
        model.addAttribute("provider", provider);
        model.addAttribute("edit", true);
        model.addAttribute("loggedinuser", getPrincipal());
        return "provider-edit";
    }
     
    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
    public String updateProvider(@Valid Provider provider, BindingResult result, ModelMap model, @PathVariable int id) {
		if (result.hasErrors()) {
            return "provider-new";
        }
 
        providerService.update(provider);
 
        model.addAttribute("success", "Fornecedor " + provider.getName() + " atualizado com sucesso");
        model.addAttribute("loggedinuser", getPrincipal());
        return "redirect:/panel/provider/list";
    }

    @RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
    public String deleteProvider(@PathVariable int id) {
        providerService.delete(id);
		return "redirect:/panel/provider/list";
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
