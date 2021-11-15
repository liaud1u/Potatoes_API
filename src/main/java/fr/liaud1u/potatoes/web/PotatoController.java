package fr.liaud1u.potatoes.web;

import fr.liaud1u.potatoes.dao.IPotatoDAO;
import fr.liaud1u.potatoes.model.Potato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PotatoController {

    // Potato DAO used for the requests
    @Autowired
    private IPotatoDAO potatoDAO;

    /**
     * Return the list of all Potatoes of the Database
     *
     * @return List of Potatoes
     */
    @GetMapping(value = "/Potatoes")
    public List<Potato> getPotatoes() {
        return potatoDAO.findAll();
    }

    /**
     * Return the specified Potato by ID
     *
     * @param id int ID of the Potato
     * @return Potato
     */
    @GetMapping(value = "/Potato/{id}")
    public Potato getPotato(@PathVariable int id) {
        return potatoDAO.findById(id);
    }

    /**
     * Add a Potato to Database
     *
     * @param potato Potato to add to the DAO
     */
    @PostMapping(value = "Potatoes")
    public void addPotato(@RequestBody Potato potato) {
        potatoDAO.save(potato);
    }

    /**
     * Delete potato
     *
     * @param id int id of potato to delete
     */
    @DeleteMapping("/Potato/{id}")
    void deleteEmployee(@PathVariable int id) {
        potatoDAO.removePotato(id);
    }

    /**
     * Update potato
     *
     * @param potato Potato data
     * @param id     int id of the potato to update
     */
    @PutMapping(value = "Potato/{id}")
    public void addPotato(@RequestBody Potato potato, @PathVariable int id) {
        potatoDAO.updatePotato(id, potato);
    }
}
