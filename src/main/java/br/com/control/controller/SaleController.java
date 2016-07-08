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

import br.com.control.model.Sale;
import br.com.control.service.SaleService;

@Controller
@RequestMapping("/panel/sale")
@SessionAttributes("roles")
public class SaleController {

	@Autowired		
    SaleService saleService;
     
    @Autowired
    MessageSource messageSource;
    
    @RequestMapping(value = {"/", "/list" }, method = RequestMethod.GET)
    public String listCategorys(ModelMap model) {
		List<Sale> sale = saleService.findAll();
        model.addAttribute("sale", sale);
        model.addAttribute("loggedinuser", getPrincipal());
        return "sale-list";
    }
 
    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newCategory(ModelMap model) {
		Sale sale = new Sale();
        model.addAttribute("sale", sale);
        model.addAttribute("edit", false);
        model.addAttribute("loggedinuser", getPrincipal());
        return "sale-new";
    }

    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String saveCategory(@Valid Sale sale, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
            return "user-new";
        }
         
        saleService.save(sale);
 
        model.addAttribute("success", "Sale " + sale.getProduct() + " registered successfully");
        model.addAttribute("loggedinuser", getPrincipal());
       
        return "sale-list";
    }

    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
    public String editCategory(@PathVariable int id, ModelMap model) {
		Sale sale = saleService.findById(id);
        model.addAttribute("sale", sale);
        model.addAttribute("edit", true);
        model.addAttribute("loggedinuser", getPrincipal());
        return "sale-new";
    }
     
    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
    public String updateCategory(@Valid Sale sale, BindingResult result, ModelMap model, @PathVariable int id) {
		if (result.hasErrors()) {
            return "sale-new";
        }
 
        saleService.update(sale);
 
        model.addAttribute("success", "Sale " + sale.getProduct() + " updated successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        return "sale-list";
    }

    @RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
    public String deleteCategory(@PathVariable int id) {
        saleService.delete(id);
        return "redirect:/panel/sale/sale-list";
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

