package fr.liaud1u.potatoes.web;

import fr.liaud1u.potatoes.dao.IPotatoDAO;
import fr.liaud1u.potatoes.model.Potato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PotatoController {

    @Autowired
    private IPotatoDAO potatoDAO;

    @GetMapping(value = "/Potatoes")
    public List<Potato> getPotatoes() {
        return potatoDAO.findAll();
    }

    @GetMapping(value = "/Potato/{id}")
    public Potato getPotato(@PathVariable int id) {
        return potatoDAO.findById(id);
    }

    @PostMapping(value = "Potatoes")
    public void addPotato(@RequestBody Potato potato) {
        potatoDAO.save(potato);
    }
}
