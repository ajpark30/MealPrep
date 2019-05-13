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
    private Integer groceryListId;

    @Column(name="grocerylistName")
    private String grocerylistName;

    @Column(name="user_id")
    private Integer user_id;

    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.MERGE)
    @JoinTable(name="groceryList_ingredients",
            joinColumns = { @JoinColumn(name="groceryListId")},
            inverseJoinColumns = {@JoinColumn(name="ingredientId")})
    private Set<Ingredients> ingredients = new HashSet<Ingredients>();

    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name="userRecipes_groceryList",
            joinColumns = { @JoinColumn(name="groceryListId")},
            inverseJoinColumns = {@JoinColumn(name="recipeId")})
    private Set<UserRecipes> userRecipes = new HashSet<UserRecipes>(0);

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "groceryLists")
    private Set<User> users = new HashSet<User>(0);

    public GroceryList() {

    }

    /**
     * Constructor that builds a grocery list object
     * @param grocerylistName
     * @param ingredients
     * @param userRecipes
     * @param users
     */
    public GroceryList(String grocerylistName, Integer user_id, Set<Ingredients> ingredients, Set<UserRecipes> userRecipes, Set<User> users) {
        this.grocerylistName = grocerylistName;
        this.user_id = user_id;
        this.ingredients = ingredients;
        this.userRecipes = userRecipes;
        this.users = users;
    }

    /**
     * @return
     */
    public Integer getGroceryListId() {
        return groceryListId;
    }

    /**
     * @param groceryListId
     */
    public void setGroceryListId(Integer groceryListId) {
        this.groceryListId = groceryListId;
    }

    /**
     * @return
     */
    public String getGrocerylistName() {
        return grocerylistName;
    }

    /**
     * @param grocerylistName
     */
    public void setGrocerylistName(String grocerylistName) {
        this.grocerylistName = grocerylistName;
    }

    /**
     * @return
     */
    public Integer getUser_id(){ return user_id;}

    /**
     *
     * @param user_id
     */
    public void setUser_id(Integer user_id) { this.user_id = user_id;}

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
                " groceryListId = " + groceryListId +
                ", grocerylistName = " + grocerylistName +
                ", user_id = " + user_id +
                ", ingredients = {" + ingredients +
                "}, userRecipes = {" + userRecipes +
                "}, user = {" + users +
                "} }";
    }
}
