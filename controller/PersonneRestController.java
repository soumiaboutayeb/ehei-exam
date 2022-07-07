import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonneRestController {

    private final PersonneService personneService;

    @Autowired
    public PersonneRestController(PersonneService personneService) {
        this.personneService = personneService;
    }

    @GetMapping("/personnes")
    public List<Personne> findAll() {
        return personneService.findAll();
    }

    @GetMapping("/personnes/{id}")
    public Personne getPersonne(@PathVariable int id) {
        Personne personne = personneService.findById(id);

        if (personne == null) {
            throw new RuntimeException("personne id not found - " + id);
        }

        return personne;
    }

    @DeleteMapping("/personnes/{id}")
    public String deletePersonne(@PathVariable int id) {
        Personne personne = personneService.findById(id);

        if (personne == null) {
            throw new RuntimeException("personne id not found - " + id);
        }

        personneService.deleteById(id);

        return "Deleted personne id - " + id;
    }

    @PutMapping("/personnes")
    public Personne updatePersonne(@RequestBody Personne personne) {

        personneService.save(personne);

        return personne;
    }

    @PostMapping("/personnes")
    public Personne addPersonne(@RequestBody Personne personne) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        personne.setId(0);

        personneService.save(personne);

        return personne;
    }

}
