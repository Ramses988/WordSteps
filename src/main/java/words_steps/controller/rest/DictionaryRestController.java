package words_steps.controller.rest;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import words_steps.models.Word;
import words_steps.services.DictionaryService;
import words_steps.services.StudyService;

import java.util.List;

@AllArgsConstructor
@RestController
public class DictionaryRestController {

    private final DictionaryService service;
    private final StudyService studyService;

    @GetMapping("/dictionary/get-words")
    public List<Word> getWords() {
        return service.getDictionary(1L).getWords();
    }

    @PostMapping("/study/setError")
    public void setError(Long id) {
        studyService.setForgot(id);
    }

}
