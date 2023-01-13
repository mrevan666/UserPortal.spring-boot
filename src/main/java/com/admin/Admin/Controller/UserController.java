package com.admin.Admin.Controller;

import com.admin.Admin.Entity.User;
import com.admin.Admin.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

//@RequestMapping(path = "/user")  // all page start with "user" - localhost:8080/user
@Controller
public class UserController {

    @Autowired //dependency injection
    private UserRepository userRepository;

    @GetMapping(path = "/user")
    public String index(){
        return "index";
    }

    @GetMapping(path = "/user/list")
    public String getAllUser(Model model){
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users",users);
        return "list";
    }

    @GetMapping(path = "/user/new")
    public String newPage(Model model){
        model.addAttribute("user",new User());
        return "User";
    }

    @PostMapping(path = "/user/save")
    public String addUser(User user,Model mode){
        userRepository.save(user);
        return "redirect:/user/list";
    }

    @GetMapping(path = "/user/update")
    public String goToUpdate(Model model, @RequestParam Integer id){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()) {
            User user = optionalUser.get();
            model.addAttribute("user", user);
        }
            return "Update";
    }

    @GetMapping(path = "/user/delete")
    public String goToDelete(Model model,@RequestParam Integer id){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()) {
            User user = optionalUser.get();
            model.addAttribute("user", user);
        }
        return "Delete";

    }

    @PostMapping(path = "/user/delete")
    public String delete(Model model,User user){
        userRepository.delete(user);
        return "redirect:/user/list";

    }

}
