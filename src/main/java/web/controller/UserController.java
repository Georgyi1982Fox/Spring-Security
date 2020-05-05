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
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/userPage", method = RequestMethod.GET)
    public String showUsersPage(@ModelAttribute("user")User user, ModelMap modelMap) throws SQLException {

        modelMap.addAttribute("user",user);
        return "user";
    }
}
