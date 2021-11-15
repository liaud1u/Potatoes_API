package fr.liaud1u.potatoes.dao;

import fr.liaud1u.potatoes.model.Potato;

import java.util.List;

public interface IPotatoDAO {

    /**
     * Getter of the Potatoes list
     *
     * @return List of Potato
     */
    List<Potato> findAll();

    /**
     * Getter of one Potato by ID
     *
     * @param id int ID of the Potato
     * @return Potato
     */
    Potato findById(int id);

    /**
     * Add Potato to DAO
     *
     * @param potato Potato to add
     */
    void save(Potato potato);

    /**
     * Update a potato in DAO
     *
     * @param id     int id of the potato
     * @param potato Potato new value
     */
    void updatePotato(int id, Potato potato);

    /**
     * Remove a Potato from DAO
     *
     * @param id int id of the potato to remove
     */
    void removePotato(int id);
}
