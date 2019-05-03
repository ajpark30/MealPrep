package edu.matc.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "UserRecipes")
@Table(name = "userRecipes")
public class UserRecipes {

    @Id
    @Column(name="recipe_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int recipeId;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name="recipe_title")
    private String recipeTitle;

    @Column(name="date_created")
    private LocalDateTime dateTimeCreated;

    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name="userRecipes_groceryList",
            joinColumns = { @JoinColumn(name="recipeId")},
            inverseJoinColumns = {@JoinColumn(name="groceryListId")})
    private Set<GroceryList> groceryLists = new HashSet<GroceryList>(0);

    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name="userRecipes_ingredients",
            joinColumns = { @JoinColumn(name="recipeId")},
            inverseJoinColumns = {@JoinColumn(name="ingredientId")})
    private Set<Ingredients> ingredients = new HashSet<Ingredients>(0);


    public UserRecipes() {
    }

    /**
     * Constructor that builds a userRecipes object
     * @param user
     * @param recipeTitle
     * @param dateTimeCreated
     * @param groceryLists
     * @param ingredients
     */
    public UserRecipes(User user, String recipeTitle, LocalDateTime dateTimeCreated, Set<GroceryList> groceryLists, Set<Ingredients> ingredients) {
        this.user = user;
        this.recipeTitle = recipeTitle;
        this.dateTimeCreated = dateTimeCreated;
        this.groceryLists = groceryLists;
        this.ingredients = ingredients;
    }

//    /**
//     *
//     * @param recipeId
//     * @param user
//     * @param recipeTitle
//     * @param dateTimeCreated
//     */
//    public UserRecipes(int recipeId, User user, String recipeTitle, LocalDateTime dateTimeCreated) {
//        this.recipeId = recipeId;
//        this.user = user;
//        this.recipeTitle = recipeTitle;
//        this.dateTimeCreated = dateTimeCreated;
//    }

    /**
     * @return
     */
    public int getRecipeId() {
        return recipeId;
    }

    /**
     * @param recipeId
     */
    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    /**
     * @return
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     *
     * @return
     */
    public String getRecipeTitle() {
        return recipeTitle;
    }

    /**
     *
     * @param recipeTitle
     */
    public void setRecipeTitle(String recipeTitle) {
        this.recipeTitle = recipeTitle;
    }

    /**
     *
     * @return
     */
    public LocalDateTime getDateTimeCreated() {
        return dateTimeCreated;
    }

    /**
     *
     * @param dateTimeCreated
     */
    public void setDateTimeCreated(LocalDateTime dateTimeCreated) {
        this.dateTimeCreated = dateTimeCreated;
    }

    /**
     *
     * @return
     */
    public Set<GroceryList> getGroceryLists() {
        return groceryLists;
    }

    /**
     *
     * @param groceryLists
     */
    public void setGroceryLists(Set<GroceryList> groceryLists) {
        this.groceryLists = groceryLists;
    }

    /**
     *
     * @return
     */
    public Set<Ingredients> getIngredients() {
        return ingredients;
    }

    /**
     *
     * @param ingredients
     */
    public void setIngredients(Set<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "UserRecipes{" +
                "recipeId = " + recipeId +
                ", user = " + user +
                ", recipeTitle = '" + recipeTitle + '\'' +
                ", dateTimeCreated = " + dateTimeCreated +
                ", ingredients = " + ingredients +
                "}";
    }
}
