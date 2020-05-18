package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.dao.RoleHibernateDAO;
import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showUserList(ModelMap modelMap) throws SQLException {
        List<User> allUsers = userService.listAllUsers();
        modelMap.addAttribute("allUsers", allUsers);
        return "admin";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam(value = "id", required = true) long id, Model model) throws SQLException {
        User user = userService.getUserById(id);
        model.addAttribute("userEdit", user);
        return "editPage";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String updatedUser(@ModelAttribute("user") User user) throws SQLException {
        if (user.getPassword() == null || user.getPassword().isEmpty()){
            return "redirect:/login";
        } else {
                Set<Role> roles = user.getRoles().stream()
                        .map(Role::getName)
                        .map(roleService::findByName)
                        .filter(Objects::nonNull)
                        .collect(Collectors.toSet());
                user.setRoles(roles);
                user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
                userService.updateUser(user);
            }
            return "redirect:/admin/list";
        }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public String deleteUser(@RequestParam(value = "id")long id, Model model) throws SQLException {
        userService.deleteUser(id);
        model.addAttribute("userId",id);
        return "redirect:/admin/list";
    }
}

















