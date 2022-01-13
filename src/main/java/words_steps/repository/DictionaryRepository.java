package words_steps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import words_steps.models.DictionaryWords;

public interface DictionaryRepository extends JpaRepository<DictionaryWords, Long> {
}
