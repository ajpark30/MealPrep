package edu.matc.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * A class to represent a user.
 *
 * @author apark 3/23/19
 */
@Entity(name = "GroceryList")
@Table(name = "groceryList")
public class GroceryList {

    @Id
    @Column(name="groceryListId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int groceryListId;

    @Column(name="groceryListName")
    private String groceryListName;

    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name="groceryList_ingredients",
            joinColumns = { @JoinColumn(name="groceryListId")},
            inverseJoinColumns = {@JoinColumn(name="ingredientId")})
    private Set<Ingredients> ingredients = new HashSet<Ingredients>(0);

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "groceryLists")
    private Set<UserRecipes> userRecipes = new HashSet<UserRecipes>(0);

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "groceryLists")
    private Set<User> users = new HashSet<User>(0);

    public GroceryList() {

    }

    /**
     * Constructor that builds a grocery list object
     * @param groceryListId
     * @param groceryListName
     * @param ingredients
     * @param userRecipes
     * @param users
     */
    public GroceryList(int groceryListId, String groceryListName, Set<Ingredients> ingredients, Set<UserRecipes> userRecipes, Set<User> users) {
        this.groceryListId = groceryListId;
        this.groceryListName = groceryListName;
        this.ingredients = ingredients;
        this.userRecipes = userRecipes;
        this.users = users;
    }

    /**
     * @return
     */
    public int getGroceryListId() {
        return groceryListId;
    }

    /**
     * @param groceryListId
     */
    public void setGroceryListId(int groceryListId) {
        this.groceryListId = groceryListId;
    }

    /**
     * @return
     */
    public String getGroceryListName() {
        return groceryListName;
    }

    /**
     * @param groceryListName
     */
    public void setGroceryListName(String groceryListName) {
        this.groceryListName = groceryListName;
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

    /**
     * @return
     */
    public Set <UserRecipes> getUserRecipes() {
        return userRecipes;
    }

    /**
     * @param userRecipes
     */
    public void setUserRecipes(Set<UserRecipes> userRecipes) {
        this.userRecipes = userRecipes;
    }

    /**
     * @return
     */
    public Set<User> getUsers() {
        return users;
    }

    /**
     * @param users
     */
    public void setUser(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "GroceryLists{" +
                "groceryListId=" + groceryListId +
                "groceryListName=" + groceryListName +
                "ingredients=" + ingredients +
                "recipeId=" + userRecipes +
                "userId=" + users +
                "}";
    }
}
