package words_steps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import words_steps.models.Word;

import java.time.LocalDateTime;
import java.util.List;

public interface WordRepository extends JpaRepository<Word, Long> {

    List<Word> findAllByNextDate(LocalDateTime nextDate);

    List<Word> findAllByNextDateLessThan(LocalDateTime nextDate);

}