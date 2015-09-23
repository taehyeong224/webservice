package koreatech.cse.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/")
public class HomeController {
    @Value("${env.text}")
    private String env; //properties파일에서 env.text라는 변수를 가져와라
    //값의 형식에 따라서 변수를 만들면 자동적으로 대입

    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;

    @RequestMapping
    public String home(Model model) {
        model.addAttribute("textFromController", "Worlddss안녕!!d");
        return "hello";
    }

    @RequestMapping("/env")
    public String env(Model model) {
        model.addAttribute("textFromController", env);
        model.addAttribute("username",username);
        model.addAttribute("userpass",password);
        return "hello";
    }
}