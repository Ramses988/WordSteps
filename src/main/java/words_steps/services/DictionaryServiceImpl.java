package words_steps.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import words_steps.models.DictionaryWords;
import words_steps.repository.DictionaryRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class DictionaryServiceImpl implements DictionaryService {

    private final DictionaryRepository repository;

    @Override
    public List<DictionaryWords> getDictionaries() {
        return repository.findAll();
    }

    @Override
    public DictionaryWords getDictionary(Long id) {
        return repository.getById(id);
    }

}
