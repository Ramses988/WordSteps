package words_steps.controller.rest;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import words_steps.models.Word;
import words_steps.services.DictionaryService;

import java.util.List;

@AllArgsConstructor
@RestController
public class DictionaryRestController {

    private final DictionaryService service;

    @GetMapping("/dictionary/get-words")
    public List<Word> getWords() {
        return service.getDictionary(1L).getWords();
    }

}
