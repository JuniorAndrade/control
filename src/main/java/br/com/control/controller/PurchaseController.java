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

import br.com.control.model.Purchase;
import br.com.control.service.PurchaseService;

@Controller
@RequestMapping("/panel/purchase")
@SessionAttributes("roles")
public class PurchaseController {

	@Autowired		
    PurchaseService purchaseService;
     
    @Autowired
    MessageSource messageSource;
    
    @RequestMapping(value = {"/", "/list" }, method = RequestMethod.GET)
    public String listCategorys(ModelMap model) {
		List<Purchase> purchase = purchaseService.findAll();
        model.addAttribute("purchase", purchase);
        model.addAttribute("loggedinuser", getPrincipal());
        return "purchase-list";
    }
 
    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newCategory(ModelMap model) {
		Purchase purchase = new Purchase();
        model.addAttribute("purchase", purchase);
        model.addAttribute("edit", false);
        model.addAttribute("loggedinuser", getPrincipal());
        return "purchase-new";
    }

    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String saveCategory(@Valid Purchase purchase, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
            return "purchase-new";
        }
         
        purchaseService.save(purchase);
 
        model.addAttribute("success", "Purchase " + purchase.getProduct() + " registered successfully");
        model.addAttribute("loggedinuser", getPrincipal());
       
        return "purchase-list";
    }

    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
    public String editCategory(@PathVariable int id, ModelMap model) {
		Purchase purchase = purchaseService.findById(id);
        model.addAttribute("purchase", purchase);
        model.addAttribute("edit", true);
        model.addAttribute("loggedinuser", getPrincipal());
        return "purchase-new";
    }
     
    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
    public String updateCategory(@Valid Purchase purchase, BindingResult result, ModelMap model, @PathVariable int id) {
		if (result.hasErrors()) {
            return "purchase-new";
        }
 
        purchaseService.update(purchase);
 
        model.addAttribute("success", "Purchase " + purchase.getProduct() + " updated successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        return "purchase-list";
    }

    @RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
    public String deleteCategory(@PathVariable int id) {
		purchaseService.delete(id);
        return "redirect:/panel/purchase/purchase-list";
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
