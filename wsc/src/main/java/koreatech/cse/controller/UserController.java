package koreatech.cse.controller;
import koreatech.cse.dao.UserDao;
import koreatech.cse.domain.Searchable;
import koreatech.cse.domain.User;
import koreatech.cse.repository.UserMapper;
import koreatech.cse.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;


@Controller
@RequestMapping("/user")
    public class UserController {
    @Inject
    private UserDao userDao;
    @Inject
    private UserMapper userMapper;
    @Inject
    private UserService userService;

    @RequestMapping("/signup")
        public String signup(Model model) {
            User user = new User();
            model.addAttribute("user", user);
            return "signup";
        }
    @Transactional
    @RequestMapping(value="/signup", method= RequestMethod.POST)
    @ResponseBody
    public String signup(@ModelAttribute User user, BindingResult result) {
//        if (result.hasErrors()) {
//            List<FieldError> errors = result.getFieldErrors();
//            for (FieldError error : errors ) {
//                System.out.println (error.getObjectName() + " - " + error.getDefaultMessage());
//            } }
//
//
//        System.out.println("user = " + user);
//        userDao.add(user);
//        userMapper.insert(user);

        userService.signup(user);
        return "success";
    }

    @RequestMapping("/getInfo")
    @ResponseBody
    public String findOne(@RequestParam("id") int id){
        User user = userMapper.findOne(id);
        System.out.println("user = " + user);
        return "success";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(@RequestParam("id") int id){
        userService.delete(id);
        return "success delete";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model, @RequestParam(required=false) String name, @RequestParam(required=false) String email, @RequestParam(required=false) String order) {
        Searchable searchable = new Searchable();
        searchable.setName(name);
        searchable.setEmail(email);
        searchable.setOrderParam(order);
        model.addAttribute("users", userMapper.findByScript(searchable));
        return "list";
    }
}
