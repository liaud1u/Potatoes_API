package fr.liaud1u.potatoes.dao;

import fr.liaud1u.potatoes.model.Potato;

import java.util.List;

public interface IPotatoDAO {

    List<Potato> findAll();

    Potato findById(int id);

    void save(Potato potato);
}
