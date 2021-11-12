package fr.liaud1u.potatoes.model;

public class Potato {
    private String varietyName;
    private String description;
    private String parentage;
    private String IVTVariety;
    private String breederCountry;
    private String colourOfSkin;
    private String colourOfFlesh;
    private String smoothness;
    private String maturity;
    private String height;
    private String coulourOfFlower;

    public Potato(String varietyName, String description, String parentage, String IVTVariety, String breederCountry, String colourOfSkin, String colourOfFlesh, String smoothness, String maturity, String height, String coulourOfFlower) {
        this.varietyName = varietyName;
        this.description = description;
        this.parentage = parentage;
        this.IVTVariety = IVTVariety;
        this.breederCountry = breederCountry;
        this.colourOfSkin = colourOfSkin;
        this.colourOfFlesh = colourOfFlesh;
        this.smoothness = smoothness;
        this.maturity = maturity;
        this.height = height;
        this.coulourOfFlower = coulourOfFlower;
    }

    public String getVarietyName() {
        return varietyName;
    }

    public void setVarietyName(String varietyName) {
        this.varietyName = varietyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParentage() {
        return parentage;
    }

    public void setParentage(String parentage) {
        this.parentage = parentage;
    }

    public String getIVTVariety() {
        return IVTVariety;
    }

    public void setIVTVariety(String IVTVariety) {
        this.IVTVariety = IVTVariety;
    }

    public String getBreederCountry() {
        return breederCountry;
    }

    public void setBreederCountry(String breederCountry) {
        this.breederCountry = breederCountry;
    }

    public String getColourOfSkin() {
        return colourOfSkin;
    }

    public void setColourOfSkin(String colourOfSkin) {
        this.colourOfSkin = colourOfSkin;
    }

    public String getColourOfFlesh() {
        return colourOfFlesh;
    }

    public void setColourOfFlesh(String colourOfFlesh) {
        this.colourOfFlesh = colourOfFlesh;
    }

    public String getSmoothness() {
        return smoothness;
    }

    public void setSmoothness(String smoothness) {
        this.smoothness = smoothness;
    }

    public String getMaturity() {
        return maturity;
    }

    public void setMaturity(String maturity) {
        this.maturity = maturity;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getCoulourOfFlower() {
        return coulourOfFlower;
    }

    public void setCoulourOfFlower(String coulourOfFlower) {
        this.coulourOfFlower = coulourOfFlower;
    }
}
