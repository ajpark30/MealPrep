package edu.matc.entity;

import javax.persistence.*;

@Entity(name = "Ingredients")
@Table(name = "ingredients")
public class Ingredients {

    @Id
    @Column(name="ingredientId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ingredientId;

    @Column(name="ingredientName")
    private String ingredientName;

    @Column(name="ingredientCategory")
    private String ingredientCategory;

    @Column(name="price")
    private int price;

    @Column(name="priceMeasurementUnit")
    private String priceMeasurementUnit;

    @Column(name="brand")
    private String brand;

    @ManyToMany
    @JoinColumn(name="recipe_id")
    private UserRecipes userRecipes;

    public Ingredients() {}

    public Ingredients (int ingredientId, String ingredientName, String ingredientCategory, int price,
                            String priceMeasurementUnit, String brand, UserRecipes userRecipes) {

        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
        this.ingredientCategory = ingredientCategory;
        this.price = price;
        this.priceMeasurementUnit = priceMeasurementUnit;
        this.brand = brand;
        this.userRecipes = userRecipes;
    }

    /**
     * @return
     */
    public int getIngredientId() {
        return ingredientId;
    }

    /**
     * @param ingredientId
     */
    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    /**
     * @return
     */
    public String getIngredientName() {
        return ingredientName;
    }

    /**
     * @param ingredientName
     */
    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    /**
     * @return
     */
    public String getIngredientCategory() {
        return ingredientCategory;
    }

    /**
     * @param ingredientCategory
     */
    public void setIngredientCategory(String ingredientCategory) {
        this.ingredientCategory = ingredientCategory;
    }

    /**
     * @return
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return
     */
    public String getPriceMeasurementUnit() {
        return priceMeasurementUnit;
    }

    /**
     * @param priceMeasurementUnit
     */
    public void setPriceMeasurementUnit(String priceMeasurementUnit) {
        this.priceMeasurementUnit = priceMeasurementUnit;
    }

    /**
     * @return
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return
     */
    public UserRecipes getUserRecipes() {
        return userRecipes;
    }

    /**
     * @param userRecipes
     */
    public void setUserRecipes(UserRecipes userRecipes) {
        this.userRecipes = userRecipes;
    }
}
