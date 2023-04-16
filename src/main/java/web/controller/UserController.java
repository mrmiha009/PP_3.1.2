package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String showAllUsers(Model model) {
        List<User> users = userService.listUsers();
        model.addAttribute("users", users);
        return "users";
    }
    @RequestMapping("/addUser")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return "user-info";
    }
    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute ("user") User user) {

        userService.add(user);

        return "redirect:/";
    }

    @RequestMapping("/update")
    public String updateUser(@RequestParam("action") Integer id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "user-info";
    }
    @RequestMapping("/delete")
    public String deleteUser(@RequestParam("action") Integer id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
