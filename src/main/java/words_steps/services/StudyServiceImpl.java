package words_steps.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import words_steps.models.Word;
import words_steps.repository.WordRepository;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@AllArgsConstructor
@Service
public class StudyServiceImpl implements StudyService {

    private final CopyOnWriteArrayList<Word> currentWords = new CopyOnWriteArrayList<>();
    private final List<Word> tempCurrentWords = new ArrayList<>();
    private final WordRepository wordRepository;


    @Override
    public void getWordsForStudy(Long id) {
        getCurrentWords(wordRepository.findAllByNextDate(null));
    }

    @Override
    public void getWordsForRepeat(Long id) {
        getCurrentWords(getWordsRepeat());
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
        return getRandomWord();
    }

    @Override
    public Word GetWordLesson3() {
        return getRandomWord();
    }

    @Override
    public Word GetWordLesson8() {
        return getRandomWord();
    }

    @Override
    public Word GetWordLesson4() {
        return getRandomWord();
    }

    @Override
    public List<Word> GetListForLesson() {
        Collections.shuffle(currentWords);
        return currentWords;
    }

    @Override
    @Transactional
    public void saveResult() {
        LocalDateTime date = LocalDateTime.now();
        for (Word word : currentWords) {
            if (word.getErrors() > 0) {
                word.setNextDate(date.plusDays(3));
            } else {
                if ( word.getStatus() == 10)
                    word.setNextDate(date.plusYears(1));
                if ( word.getStatus() == 9)
                    updateStatus(word, date.plusMonths(8));
                if ( word.getStatus() == 8)
                    updateStatus(word, date.plusMonths(6));
                if ( word.getStatus() == 7)
                    updateStatus(word, date.plusMonths(3));
                if ( word.getStatus() == 6)
                    updateStatus(word, date.plusMonths(2));
                if ( word.getStatus() == 5)
                    updateStatus(word, date.plusMonths(1));
                if ( word.getStatus() == 4)
                    updateStatus(word, date.plusDays(14));
                if ( word.getStatus() == 3)
                    updateStatus(word, date.plusDays(7));
                if ( word.getStatus() == 2)
                    updateStatus(word, date.plusDays(3));
                if ( word.getStatus() == 1)
                    updateStatus(word, date.plusDays(1));
                if ( word.getStatus() == 0)
                    updateStatus(word, date.plusHours(8));
            }
            wordRepository.saveAll(currentWords);
        }
    }

    private void updateStatus(Word word, LocalDateTime dateTime) {
        word.setStatus(word.getStatus() + 1);
        word.setNextDate(dateTime);
    }

    private Word getRandomWord() {
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
    public int getCountWordsRepeat() {
        return getWordsRepeat().size();
    }

    private List<Word> getWordsRepeat() {
        return wordRepository.findAllByNextDateLessThan(LocalDateTime.now());
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
        for (int i = 0; i < words.size(); i++) {
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
