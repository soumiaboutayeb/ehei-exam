
import java.util.List;

public interface PersonneService {


    List<Personne> findAll();

    Personne findById(int id);

    void save(Personne personne);

    void deleteById(int id);

}
