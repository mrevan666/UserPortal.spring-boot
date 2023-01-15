package com.admin.Admin.Controller;

import com.admin.Admin.Entity.Occupation;
import com.admin.Admin.Entity.User;
import com.admin.Admin.Repository.OccupationRepository;
import com.admin.Admin.Repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//@RequestMapping(path = "/user")  // all page start with "user" - localhost:8080/user
@Controller
public class UserController {

    @Autowired //dependency injection
    private UserRepository userRepository;

    @Autowired
    private OccupationRepository occupationRepository;

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
        Iterable<Occupation> occupations = occupationRepository.findAll();
        model.addAttribute("allOccupations", occupations);
        return "User";
    }

    @PostMapping(path = "/user/save")
    public String addUser(@Valid User user, BindingResult br, Model model){
        if(br.hasErrors()){
            return "User";
        }
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
        Iterable<Occupation> occupations = occupationRepository.findAll();
        model.addAttribute("allOccupations", occupations);
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

    @GetMapping(path = "/user/name/{name}")
    public String getNameById(Model model, @PathVariable String name){
        Iterable<User> users = userRepository.findByName(name);
        model.addAttribute("users",users);
        return "list";
    }

}
