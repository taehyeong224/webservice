package koreatech.cse.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller @RequestMapping("/") public class HomeController {
    @RequestMapping
    public String home(Model model) {
        model.addAttribute("textFromController", "Worlddss안녕!!d");
        return "hello"; }
}