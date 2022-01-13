package words_steps.controller;

import org.springframework.stereotype.Controller;

@Controller
public class IndexController {

    public String getIndex() {
        return "index";
    }

}
