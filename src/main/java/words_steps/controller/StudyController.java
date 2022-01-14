package words_steps.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import words_steps.models.Word;
import words_steps.services.StudyService;

import java.util.Objects;

@AllArgsConstructor
@Controller
public class StudyController {

    private final StudyService service;

    @GetMapping("/study/{id}")
    public String getLessons(@PathVariable("id") Long id) {
        service.getWordsForStudy(1L);
        return "redirect:/study/lesson1";
    }

    @GetMapping("/repeat/{id}")
    public String getRepeat(@PathVariable("id") Long id) {
        service.getWordsForRepeat(1L);
        return "redirect:/study/lesson1";
    }

    @GetMapping("/study/lesson1")
    public String getLesson1(Model model) {
        Word word = service.GetWordLesson1();
        if (Objects.nonNull(word)) {
            model.addAttribute("word", word);
            return "lesson1";
        }
        return "redirect:/study/lesson2";
    }

    @GetMapping("/study/forgot/{id}")
    public String setForgot(@PathVariable("id") Long id, Model model) {
        service.setForgot(id);
        return "redirect:/study/lesson2";
    }

    @GetMapping("/study/lesson3")
    public String getLesson3(Model model) {
        Word word = service.GetWordLesson3();
        if (Objects.nonNull(word)) {
            model.addAttribute("word", word);
            model.addAttribute("words", service.GetListForLesson());
            return "lesson3";
        }
        return "redirect:/study/lesson4";
    }

    @GetMapping("/study/lesson6")
    public String getLesson6(Model model) {
        Word word = service.GetWordLesson3();
        if (Objects.nonNull(word)) {
            model.addAttribute("word", word);
            model.addAttribute("words", service.GetListForLesson());
            return "lesson6";
        }
        return "redirect:/study/lesson7";
    }

    @GetMapping("/study/lesson4")
    public String getLesson4(Model model) {
        Word word = service.GetWordLesson4();
        if (Objects.nonNull(word)) {
            model.addAttribute("word", word);
            return "lesson4";
        }
        return "redirect:/study/lesson5";
    }

    @GetMapping("/study/lesson7")
    public String getLesson7(Model model) {
        Word word = service.GetWordLesson4();
        if (Objects.nonNull(word)) {
            model.addAttribute("word", word);
            return "lesson7";
        }
        return "redirect:/study/lesson8";
    }

    @GetMapping("/study/lesson8")
    public String getLesson8(Model model) {
        Word word = service.GetWordLesson3();
        if (Objects.nonNull(word)) {
            model.addAttribute("word", word);
            model.addAttribute("words", service.GetListForLesson());
            return "lesson8";
        }
        service.saveResult();
        return "redirect:/";
    }

    @GetMapping("/study/lesson2")
    public String getLesson2(Model model) {
        Word word = service.GetWordLesson2();
        if (Objects.nonNull(word)) {
            model.addAttribute("word", word);
            return "lesson2";
        }
        return "redirect:/study/lesson3";
    }

    @GetMapping("/study/lesson5")
    public String getLesson5(Model model) {
        Word word = service.GetWordLesson2();
        if (Objects.nonNull(word)) {
            model.addAttribute("word", word);
            return "lesson5";
        }
        return "redirect:/study/lesson6";
    }

    @GetMapping("/study/check-word/{id}")
    public String checkWord(@PathVariable("id") Long id, Model model) {
        model.addAttribute("word", service.getWordById(id));
        return "check";
    }

    @GetMapping("/study/check-word-en/{id}")
    public String checkWordEn(@PathVariable("id") Long id, Model model) {
        model.addAttribute("word", service.getWordById(id));
        return "check-en";
    }

}
