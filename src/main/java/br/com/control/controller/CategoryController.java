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

import br.com.control.model.Category;
import br.com.control.service.CategoryService;

@Controller
@RequestMapping("/panel/category")
@SessionAttributes("roles")
public class CategoryController {

	@Autowired
    CategoryService categoryService;
     
    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = {"/", "/list" }, method = RequestMethod.GET)
    public String listCategorys(ModelMap model) {
    	List<Category> category = categoryService.findAll();
        model.addAttribute("category", category);
        model.addAttribute("loggedinuser", getPrincipal());
        return "category-list";
    }
 
    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newCategory(ModelMap model) {
	    Category category = new Category();
        model.addAttribute("category", category);
        model.addAttribute("edit", false);
        model.addAttribute("loggedinuser", getPrincipal());
        return "category-new";
    }

    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String saveCategory(@Valid Category category, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
            return "category-new";
        }
         
        categoryService.save(category);
 
        model.addAttribute("success", "Category " + category.getName() + " cadastrado com sucesso");
        model.addAttribute("loggedinuser", getPrincipal());
       
        return "redirect:/panel/category/list";
    }

    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
    public String editCategory(@PathVariable int id, ModelMap model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        model.addAttribute("edit", true);
        model.addAttribute("loggedinuser", getPrincipal());
        return "category-new";
    }
     
    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
    public String updateCategory(@Valid Category category, BindingResult result, ModelMap model, @PathVariable int id) {
		if (result.hasErrors()) {
            return "category-new";
        }
 
        categoryService.update(category);
 
        model.addAttribute("success", "Category " + category.getName() + " atualizado com sucesso");
        model.addAttribute("loggedinuser", getPrincipal());
        return "redirect:/panel/category/list";
    }

    @RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
    public String deleteCategory(@PathVariable int id) {
		categoryService.delete(id);
        return "redirect:/panel/category/list";
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
