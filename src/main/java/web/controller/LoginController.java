package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.model.User;
import web.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@Controller
@RequestMapping("/")
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/registrationPage", method = RequestMethod.GET)
    public String homePage(ModelMap modelMap) {
        modelMap.addAttribute("newUser", new User());
        return "registrationPage";
    }

    @RequestMapping(value = "/registrationPage", method = RequestMethod.POST)
    public String newUserSubmit(@ModelAttribute("user") User user) throws Exception {
        User user1 = userService.findUserByUserName(user.getUsername());
        if (user.getUsername().equals("") && user.getPassword().equals("")) {
            return "redirect:/login";
        }else
            if(user1 != null){
                return "redirect:/login";
            }else {
                userService.addUser(user);
            }
            return "redirect:/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }
}






















