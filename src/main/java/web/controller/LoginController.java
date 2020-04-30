package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImp;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/")
public class LoginController {
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String homePage(ModelMap modelMap) {
         User user = new User();
         modelMap.addAttribute("newUser", user);
        return "index";
    }

    @RequestMapping(value="/index", method=RequestMethod.POST)
    public String newUserSubmit(@ModelAttribute("user") User user) throws SQLException {
            userService.addUser(user);
            return "redirect:/index";
        }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }


    @RequestMapping(value = "/admin/list", method = RequestMethod.GET)
    public String showUserList(ModelMap modelMap) throws SQLException {
        List<User> userList = userService.listAllUsers();
        modelMap.addAttribute("allUsers", userList);
        return "admin";
    }

    @RequestMapping(value = "/admin/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam(value = "id", required = true)long id, Model model) throws SQLException {

        User user = userService.getUserById(id);
        model.addAttribute("userEdit", user);
        return "editPage";
    }

    @RequestMapping(value = "/admin/updated", method = RequestMethod.POST)
    public String updatedUser(@ModelAttribute("user") User user) throws SQLException{
        User userUToUpdate = new User(user.getUsername(),user.getPassword(),user.getEmail());

        if (userUToUpdate.getPassword() == null || userUToUpdate.getPassword().isEmpty()) {
            return "redirect:/admin";
        }else{
            userService.updateUser(user);
        }
        return "redirect:/admin";
    }


}
