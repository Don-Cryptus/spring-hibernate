package com.spring.mvc;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {


    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }


    @RequestMapping("/showForm")
    public String getCustomer(Model theModel) {

        theModel.addAttribute("customer", new Customer());

        return "customer-form";
    }


    @RequestMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult) {
        System.out.println("Customer: " + theCustomer.getFirstName() + " " + theCustomer.getLastName());

        System.out.println("Binding Result: " + theBindingResult);

        System.out.println("\n\n\n");

        if (theBindingResult.hasErrors()) {
            return "customer-form";
        } else {

            return "customer-confirmation";
        }
    }
}
