package pl.pawlas.warehouse.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.pawlas.warehouse.model.User;
import pl.pawlas.warehouse.repository.UserRepository;
import pl.pawlas.warehouse.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {

    private UserService userService;
    private UserRepository userRepository;
    private BCryptPasswordEncoder encoder;

    public UserController(UserService userService, UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @RequestMapping(value = {"/login", "/"}, method = RequestMethod.GET)
    public String loginForm() {
        return "login/login";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginErrorHandling(Model model, HttpServletRequest request) {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if ((user.getUsername().equals(request.getParameter("username")) && request.getParameter("password").equals("")) ||
                    (user.getUsername().equals(request.getParameter("username")) && !user.getPassword().equals(request.getParameter("password")))) {
                model.addAttribute("error", 1);
            } else if (!user.getUsername().equals(request.getParameter("username")) || request.getParameter("username").equals("")) {
                model.addAttribute("error", 0);
            }
        }
        return "error/401";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        return "redirect:/login";
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "login/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registration(User user, HttpServletRequest request) {
        List<User> users = userRepository.findAll();
        for (User singleUser : users) {
            if (user.getUsername().equals(singleUser.getUsername())) {
                return "redirect:/register";
            } else if (user.getEmail().equals(singleUser.getEmail())) {
                return "redirect:/register";
            }
        }
        String confirmedPassword = request.getParameter("confirmedPassword");
        if (!confirmedPassword.equals(user.getPassword())) {
            return "redirect:/register";
        }
        userService.saveUser(user);
        return "redirect:/login";
    }


}
