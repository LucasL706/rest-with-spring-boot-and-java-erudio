package LucasL706.com.github.repository;

import LucasL706.com.github.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> { //Os parâmetros são o Tipo da entidade e o Tipo do ID da entidade

}
