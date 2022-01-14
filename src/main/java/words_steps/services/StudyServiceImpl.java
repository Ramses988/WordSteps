package words_steps.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import words_steps.models.Word;
import words_steps.repository.WordRepository;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@Service
public class StudyServiceImpl implements StudyService {

    private final List<Word> currentWords = new ArrayList<>();
    private final List<Word> tempCurrentWords = new ArrayList<>();
    private final WordRepository wordRepository;


    @Override
    public void getWordsForStudy(Long id) {
        getCurrentWords(wordRepository.findAllByNextDate(null));
    }

    @Override
    public Word GetWordLesson1() {
        if (tempCurrentWords.size() > 0) {
            Word word = tempCurrentWords.get(0);
            tempCurrentWords.remove(0);
            return word;
        }
        tempCurrentWords.addAll(currentWords);
        return null;
    }

    @Override
    public Word GetWordLesson2() {
        if (tempCurrentWords.size() > 0) {
            int i = new SecureRandom().nextInt(tempCurrentWords.size()) + 1;
            Word word = tempCurrentWords.get(i-1);
            tempCurrentWords.remove(i-1);
            return word;
        }
        tempCurrentWords.addAll(currentWords);
        return null;
    }

    @Override
    public void setForgot(Long id) {
        for (Word word : currentWords) {
            if (id.equals(word.getId()))
                word.setErrors(word.getErrors() + 1);
        }
    }

    @Override
    public Word getWordById(Long id) {
        return wordRepository.findById(id).orElse(null);
    }

    private void getCurrentWords(List<Word> words) {
        currentWords.clear();
        for (int i = 0; i <= words.size(); i++) {
            int word = new SecureRandom().nextInt(words.size()) + 1;
            currentWords.add(words.get(word-1));
            words.remove(word-1);
            if (i == 7)
                return;
        }
        tempCurrentWords.clear();
        tempCurrentWords.addAll(currentWords);
    }

}
