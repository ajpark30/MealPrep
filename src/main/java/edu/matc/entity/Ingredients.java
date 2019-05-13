package edu.matc.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Ingredients")
@Table(name = "ingredients")
public class Ingredients {

    @Id
    @Column(name="ingredientId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ingredientId;

    @Column(name="ingredientName")
    private String ingredientName;

    @Column(name="ingredientCategory")
    private String ingredientCategory;

    @Column(name="price")
    private Double price;

    @Column(name="priceMeasurementUnit")
    private String priceMeasurementUnit;

    @Column(name="brand")
    private String brand;

    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.MERGE)
    @JoinTable(name="groceryList_ingredients",
            joinColumns = { @JoinColumn(name="ingredientId")},
            inverseJoinColumns = {@JoinColumn(name="groceryListId")})
    private Set<GroceryList> groceryList = new HashSet<GroceryList>();

    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name="userRecipes_ingredients",
            joinColumns = { @JoinColumn(name="ingredientId")},
            inverseJoinColumns = {@JoinColumn(name="recipeId")})
    private Set<UserRecipes> userRecipes = new HashSet<UserRecipes>(0);

    public Ingredients() {}

    /**
     *
     * @param ingredientName
     * @param ingredientCategory
     * @param price
     * @param priceMeasurementUnit
     * @param brand
     */
    public Ingredients (String ingredientName, String ingredientCategory, Double price,
                            String priceMeasurementUnit, String brand) {

        this.ingredientName = ingredientName;
        this.ingredientCategory = ingredientCategory;
        this.price = price;
        this.priceMeasurementUnit = priceMeasurementUnit;
        this.brand = brand;
    }

    /**
     * @return
     */
    public Integer getIngredientId() {
        return ingredientId;
    }

    /**
     * @param ingredientId
     */
    public void setIngredientId(Integer ingredientId) {
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
    public Double getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(Double price) {
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
     *
     * @return
     */
    public Set<GroceryList> getGroceryList() {return groceryList;}

    /**
     *
     * @param groceryList
     */
    public void setGroceryList(Set<GroceryList> groceryList) { this.groceryList = groceryList;}

    /**
     *
     * @return
     */
    public Set<UserRecipes> getUserRecipes() { return userRecipes;}

    /**
     *
     * @param userRecipes
     */
    public void setUserRecipes(Set<UserRecipes> userRecipes) { this.userRecipes = userRecipes; }

    @Override
    public String toString() {
        return "Ingredients{" +
                "ingredientId = " + ingredientId +
                ", ingredientName = " + ingredientName +
                ", ingredientCategory = " + ingredientCategory +
                ", price = " + price +
                ", priceMeasurementUnit = " + priceMeasurementUnit +
                ", brand = " + brand +
                "}";
    }

}
