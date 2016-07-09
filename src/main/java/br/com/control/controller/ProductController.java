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

import br.com.control.service.ProductService;
import br.com.control.model.Product;

@Controller
@RequestMapping("/panel/product")
@SessionAttributes("roles")
public class ProductController {

	@Autowired
    ProductService productService;
     
    @Autowired
    MessageSource messageSource;

 	@RequestMapping(value = {"/", "/list" }, method = RequestMethod.GET)
    public String listProduct(ModelMap model) {
		List<Product> product = productService.findAll();
        model.addAttribute("product", product);
        model.addAttribute("loggedinuser", getPrincipal());
        return "product-list";
    }
 
    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newProduct(ModelMap model) {
        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("edit", false);
        model.addAttribute("loggedinuser", getPrincipal());
        return "product-new";
    }

    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String saveProduct(@Valid Product product, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "product-new";
        }
         
        productService.save(product);
 
        model.addAttribute("success", "Produto " + product.getName() + " cadastrado com sucesso");
        model.addAttribute("loggedinuser", getPrincipal());
       
        return "redirect:/panel/product/list";
    }

    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
    public String editProduct(@PathVariable int id, ModelMap model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        model.addAttribute("edit", true);
        model.addAttribute("loggedinuser", getPrincipal());
        return "product-new";
    }
     
    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
    public String updateProduct(@Valid Product product, BindingResult result, ModelMap model, @PathVariable int id) {
		if (result.hasErrors()) {
            return "product-new";
        }
 
        productService.update(product);
 
        model.addAttribute("success", "Produto " + product.getName() + " atualizado com sucesso");
        model.addAttribute("loggedinuser", getPrincipal());
        return "redirect:/panel/product/list";
    }

    @RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
    public String deleteProduct(@PathVariable int id) {
        productService.delete(id);
        return "redirect:/panel/product/list";
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
