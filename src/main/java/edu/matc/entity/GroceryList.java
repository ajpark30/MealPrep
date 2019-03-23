package edu.matc.entity;

import javax.persistence.*;

@Entity(name = "GroceryList")
@Table(name = "groceryList")
public class GroceryList {

    @Id
    @Column(name="groceryListId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int groceryListId;

    @Column(name="groceryListName")
    private String groceryListName;

    @Column(name="ingredientId")
    private int ingredientId;

    @ManyToMany
    @JoinColumn(name="recipe_id")
    private UserRecipes userRecipes;

    @ManyToMany
    @JoinColumn(name="user_id")
    private User user;

    public GroceryList() {

    }

    /**
     * Constructor that builds a grocery list object
     * @param groceryListId
     * @param groceryListName
     * @param ingredientId
     * @param userRecipes
     * @param user
     */
    public GroceryList(int groceryListId, String groceryListName, int ingredientId, UserRecipes userRecipes, User user) {
        this.groceryListId = groceryListId;
        this.groceryListName = groceryListName;
        this.ingredientId = ingredientId;
        this.userRecipes = userRecipes;
        this.user = user;
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
    public UserRecipes getUserRecipes() {
        return userRecipes;
    }

    /**
     * @param userRecipes
     */
    public void setUserRecipes(UserRecipes userRecipes) {
        this.userRecipes = userRecipes;
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

    @Override
    public String toString() {
        return "GroceryLists{" +
                "groceryListId=" + groceryListId +
                "groceryListName=" + groceryListName +
                "ingredientId=" + ingredientId +
                "recipeId=" + userRecipes +
                "userId=" + user +
                "}";
    }
}
