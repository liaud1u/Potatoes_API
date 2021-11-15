package fr.liaud1u.potatoes.dao;

import fr.liaud1u.potatoes.model.Potato;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PotatoDAO implements IPotatoDAO {

    // Map of Potato (ID, Potato)
    private final Map<Integer, Potato> potatoHashMap = new HashMap<>();

    public PotatoDAO() {

        // Read the .csv file and convert it to an Hashmap of potato
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(
                    this.getClass().getClassLoader().getResourceAsStream("static/potatoes.csv")));

            String line = null;

            // Get the list of field of the csv file
            ArrayList<String> fields = new ArrayList<>();

            int cptId = 0;

            // For each line of csv
            while ((line = br.readLine()) != null) {
                String[] str = line.split(";");
                HashMap<String, String> potatoData = new HashMap<>();
                // For each row of csv
                for (int i = 0; i < str.length; i++) {
                    if (cptId == 0) {
                        // If it's the first line, we add the string as a new field
                        fields.add(str[i]);
                    } else {
                        // We add the data to the map of potato data
                        if (i < fields.size())
                            potatoData.put(fields.get(i), str[i]);
                    }
                }

                // Conversion of the map of potato data to a map of potato
                if (cptId != 0) {
                    Potato potato = new Potato(potatoData.get("Variety Name"),
                            potatoData.get("Description"),
                            potatoData.get("Parentage"),
                            potatoData.get("IVT Variety"),
                            potatoData.get("Breeder Country"),
                            potatoData.get("Colour of skin"),
                            potatoData.get("Colour of flesh"),
                            potatoData.get("Smoothness of skin"),
                            potatoData.get("Maturity"),
                            potatoData.get("Height of plants"),
                            potatoData.get("Colour of flower"));

                    potatoHashMap.put(cptId, potato);
                }
                cptId++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    @Override
    public List<Potato> findAll() {
        return new ArrayList<>(potatoHashMap.values());
    }

    @Override
    public Potato findById(int id) {
        return potatoHashMap.get(id);
    }

    @Override
    public void save(Potato potato) {
        potatoHashMap.put(potatoHashMap.size(), potato);
        save();
    }

    @Override
    public void updatePotato(int id, Potato potato) {
        potatoHashMap.put(id, potato);
        save();
    }

    @Override
    public void removePotato(int id) {
        potatoHashMap.remove(id);
        save();
    }

    public void save() {
        Writer writer = null;
        try {
            writer = new FileWriter("./src/main/resources/static/potatoes.csv", false);

            for (Potato potato : potatoHashMap.values())
                writer.write(potato.getVarietyName() + ";" + potato.getDescription() + ";" + potato.getParentage() + ";" + potato.getIVTVariety() + ";-;-;-;-;-;-;" + potato.getBreederCountry() + ";-;-;-;-;-;-;-;-;-;-;-;-;-;-;-;-;-;" + potato.getColourOfSkin() + ";" + potato.getColourOfFlesh() + ";-;" + potato.getSmoothness() + ";-;" + potato.getMaturity() + ";" + potato.getHeight() + ";" + potato.getColourOfFlower() + ";-;-;-;-;-;-;-;-;-;-;-;-;-;-;-;-;-;-;-;-;-;-;-;-;\n");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
