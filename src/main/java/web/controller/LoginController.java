package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.model.User;
import web.service.UserService;

import java.sql.SQLException;

@Controller
@RequestMapping("/")
public class LoginController {


    @Autowired
    UserService userService;


    @RequestMapping(value = "/registrationPage", method = RequestMethod.GET)
    public String homePage(ModelMap modelMap) {
         User user = new User();
         modelMap.addAttribute("newUser", user);
         return "registrationPage";
    }

    @RequestMapping(value="/registrationPage", method=RequestMethod.POST)
    public String newUserSubmit(@ModelAttribute("user") User user) throws SQLException {
            userService.addUser(user);
            return "redirect:/login";
        }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }
}






















