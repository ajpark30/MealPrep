package edu.matc.entity;

import javax.persistence.*;
import java.util.Date; //Consider using Joda time when you have free time to look into it.

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
    private Date dateTimeCreated;


    public UserRecipes() {
    }

    /**
     * Constructor that builds a userRecipes object
     * @param user
     * @param recipeTitle
     * @param dateTimeCreated
     */
    public UserRecipes(User user, String recipeTitle, Date dateTimeCreated) {
        this.user = user;
        this.recipeTitle = recipeTitle;
        this.dateTimeCreated = dateTimeCreated;
    }

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
    public Date getDateTimeCreated() {
        return dateTimeCreated;
    }

    /**
     *
     * @param dateTimeCreated
     */
    public void setDateTimeCreated(Date dateTimeCreated) {
        this.dateTimeCreated = dateTimeCreated;
    }

    @Override
    public String toString() {
        return "UserRecipes{" +
                "recipeId=" + recipeId +
                ", user=" + user +
                ", recipeTitle='" + recipeTitle + '\'' +
                ", dateTimeCreated=" + dateTimeCreated +
                '}';
    }
}
