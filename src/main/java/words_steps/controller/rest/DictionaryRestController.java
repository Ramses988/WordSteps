package words_steps.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import words_steps.models.DictionaryWords;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DictionaryRestController {

    @GetMapping("/dictionary/get-words")
    public List<DictionaryWords> getWords() {
        List<DictionaryWords> words = new ArrayList<>();
        words.add(new DictionaryWords(1, "name", ""));
        words.add(new DictionaryWords(2, "name2", ""));
        words.add(new DictionaryWords(3, "name3", ""));
        return words;
    }

}
