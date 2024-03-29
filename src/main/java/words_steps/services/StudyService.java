package words_steps.services;

import words_steps.models.Word;

import java.util.List;

public interface StudyService {

    void getWordsForStudy(Long id);

    void getWordsForRepeat(Long id);

    Word GetWordLesson1();

    Word GetWordLesson2();

    Word GetWordLesson3();

    Word GetWordLesson4();

    Word GetWordLesson8();

    List<Word> GetListForLesson();

    Word getWordById(Long id);

    void setForgot(Long id);

    void saveResult();

    int getCountWordsRepeat();

    int getWordsNew();

}
