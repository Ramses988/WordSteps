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
        return null;
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
