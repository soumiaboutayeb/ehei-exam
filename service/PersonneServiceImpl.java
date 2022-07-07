import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PersonneServiceImpl implements PersonneService {


    private final PersonneRepository personneRepository;

    @Autowired
    public PersonneServiceImpl(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }


    @Override
    public List<Personne> findAll() {
        return personneRepository.findAll();
    }

    @Override
    public Personne findById(int id) {
        Optional<Personne> result = personneRepository.findById(id);
        Personne personne = null;
        if (result.isPresent()) personne = result.get();
        else throw new RuntimeException("Did not find personne with id - " + id);

        return personne;
    }

    @Override
    public void save(Personne personne) {
        personneRepository.save(personne);

    }

    @Override
    public void deleteById(int id) {
        personneRepository.deleteById(id);
    }
}
