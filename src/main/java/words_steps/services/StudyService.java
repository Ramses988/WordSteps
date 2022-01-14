package words_steps.services;

import words_steps.models.Word;

public interface StudyService {

    void getWordsForStudy(Long id);

    Word GetWordLesson1();

    Word GetWordLesson2();

    Word getWordById(Long id);

    void setForgot(Long id);

}
