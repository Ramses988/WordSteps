package words_steps.services;

import words_steps.models.DictionaryWords;

import java.util.List;

public interface DictionaryService {

    List<DictionaryWords> getDictionaries();

    DictionaryWords getDictionary(Long id);

}
