package words_steps.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import words_steps.models.DictionaryWords;
import words_steps.services.DictionaryService;

import java.util.List;

@AllArgsConstructor
@Controller
public class IndexController {

    private final DictionaryService service;

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("dictionaries", service.getDictionaries());
        return "index";
    }

    @GetMapping("/dictionary/{id}")
    public String getDictionary(@PathVariable("id") Long id, Model model) {
        model.addAttribute("dictionary", service.getDictionary(id));
        return "dictionary";
    }

}
