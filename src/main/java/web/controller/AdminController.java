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

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/")
public class AdminController {

    @Autowired
    UserService userService;

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

    @RequestMapping(value = "/admin/edit", method = RequestMethod.POST)
    public String updatedUser(@ModelAttribute("user") User user) throws SQLException{
        User userUToUpdate = new User(user.getUsername(),user.getPassword(),user.getEmail());

        if (userUToUpdate.getPassword() == null || userUToUpdate.getPassword().isEmpty()) {
            return "redirect:/admin/list";
        }else{
            userService.updateUser(user);
        }
        return "redirect:/admin/list";
    }

    @RequestMapping(value = "/admin/deleteUser", method = RequestMethod.GET)
    public String deleteUser(@RequestParam(value = "id")long id, Model model) throws SQLException {
        userService.deleteUser(id);
        model.addAttribute("userId",id);
        return "redirect:/admin/list";
    }
}
