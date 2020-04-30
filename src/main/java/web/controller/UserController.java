package web.controller;
/*

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.service.UserService;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

/*
    @RequestMapping(value = "/homepage", method = RequestMethod.GET)
    public String homePage(ModelMap modelMap){
        return "homePage";
    }

 */

/*

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String showUserList(ModelMap modelMap) throws SQLException {
        List<User> userList = userService.listAllUsers();
        modelMap.addAttribute("allUsers", userList);
        return "admin";
    }

    @RequestMapping(value = "/newUser", method = RequestMethod.GET)
    public String addUserPage(Model model) throws SQLException {
        User user = new User();
        model.addAttribute("newUser", user);
        return "addUser";
    }

    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String newUserSubmit(@ModelAttribute("user") User user) throws SQLException {
        if(user.getUsername() == null || user.getUsername().isEmpty()) {
            return "redirect:/userList";
        } else {
            userService.addUser(user);
            return "redirect:/userList";
        }
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam(value = "id", required = true)long id, Model model) throws SQLException {

        User user = userService.getUserById(id);
        model.addAttribute("userEdit", user);
        return "editPage";
    }

    @RequestMapping(value = "/updated", method = RequestMethod.POST)
    public String updatedUser(@ModelAttribute("user") User user) throws SQLException{
        User userUToUpdate = new User(user.getUsername(),user.getPassword(),user.getEmail());

       if (userUToUpdate.getPassword() == null || userUToUpdate.getPassword().isEmpty()) {
           return "redirect:/userList";
       }else{
           userService.updateUser(user);
       }
       return "redirect:/userList";
   }

   @RequestMapping(value = "/delete", method = RequestMethod.GET)
   public String deleteUser(@RequestParam(value = "id", required = true)long id, Model model) throws SQLException {
        userService.deleteUser(id);
        model.addAttribute("userId",id);
        return "redirect:/userList";
    }
}
*/

















