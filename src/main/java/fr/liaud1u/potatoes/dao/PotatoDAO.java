package fr.liaud1u.potatoes.dao;

import fr.liaud1u.potatoes.model.Potato;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class PotatoDAO implements IPotatoDAO {
    private final HashMap<Integer, Potato> potatoHashMap = new HashMap<>();

    public PotatoDAO() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(
                    this.getClass().getClassLoader().getResourceAsStream("static/potatoes.csv")));

            String line = null;

            ArrayList<String> fields = new ArrayList<>();

            int cptId = 0;

            while ((line = br.readLine()) != null) {
                String[] str = line.split(";");
                HashMap<String, String> potatoData = new HashMap<>();
                for (int i = 0; i < str.length; i++) {
                    if (cptId == 0) {
                        fields.add(str[i]);
                    } else {
                        if (i < fields.size())
                            potatoData.put(fields.get(i), str[i]);
                    }
                }

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

                    potatoHashMap.put(cptId - 1, potato);
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


        Writer writer = null;
        try {
            writer = new FileWriter("./src/main/resources/static/potatoes.csv", true);
            writer.write(potato.getVarietyName() + ";" + potato.getDescription() + ";" + potato.getParentage() + ";" + potato.getIVTVariety() + ";-;-;-;-;-;-;" + potato.getBreederCountry() + ";-;-;-;-;-;-;-;-;-;-;-;-;-;-;-;-;-;" + potato.getColourOfSkin() + ";" + potato.getColourOfFlesh() + ";-;" + potato.getSmoothness() + ";-;" + potato.getMaturity() + ";" + potato.getHeight() + ";" + potato.getCoulourOfFlower() + ";-;-;-;-;-;-;-;-;-;-;-;-;-;-;-;-;-;-;-;-;-;-;-;-;\n");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
