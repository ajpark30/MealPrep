package edu.matc.entity;

import javax.persistence.*;

@Entity(name = "WeeklyMealPlan")
@Table(name = "weeklyMealPlan")
public class WeeklyMealPlan {

    @Id
    @Column(name="weeklyMealPlanId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer weeklyMealPlanId;

    @Column(name="weeklyMealPlanName")
    private String weeklyMealPlanName;

    @Column(name="recipe_id")
    private Integer recipe_id;

    @Column(name="user_id")
    private Integer user_id;

    @ManyToMany
    @JoinColumn(name="recipe_id")
    private UserRecipes userRecipes;

    @ManyToMany
    @JoinColumn(name="user_id")
    private User user;

    public WeeklyMealPlan() {}

    public WeeklyMealPlan(Integer weeklyMealPlanId, String weeklyMealPlanName, Integer recipe_id, Integer user_id,UserRecipes userRecipes, User user) {
        this.weeklyMealPlanId = weeklyMealPlanId;
        this.weeklyMealPlanName = weeklyMealPlanName;
        this.recipe_id = recipe_id;
        this.user_id = user_id;
        this.userRecipes = userRecipes;
        this.user = user;
    }

    /**
     * @return
     */
    public Integer getWeeklyMealPlanId() {
        return weeklyMealPlanId;
    }

    /**
     * @param weeklyMealPlanId
     */
    public void setWeeklyMealPlanId(Integer weeklyMealPlanId) {
        this.weeklyMealPlanId = weeklyMealPlanId;
    }

    /**
     * @return
     */
    public String getWeeklyMealPlanName() {
        return weeklyMealPlanName;
    }

    /**
     * @param weeklyMealPlanName
     */
    public void setWeeklyMealPlanName(String weeklyMealPlanName) {
        this.weeklyMealPlanName = weeklyMealPlanName;
    }

    /**
     *
     * @return
     */
    public Integer getRecipe_id() { return recipe_id; }

    /**
     *
     * @param recipe_id
     */
    public void setRecipe_id(Integer recipe_id) { this.recipe_id = recipe_id; }

    /**
     *
     * @return
     */
    public Integer getUser_id() { return user_id; }

    /**
     *
     * @param user_id
     */
    public void setUser_id(Integer user_id) { this.user_id = user_id; }

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
        return "WeeklyMealPlan{" +
                "weeklyMealPlanId = " + weeklyMealPlanId +
                ", weeklyMealPlanName = " + weeklyMealPlanName +
                ", recipe_id = " + recipe_id +
                ", user_id = " + user_id +
                ", userRecipes = {" + userRecipes +
                ", user = {" + user +
                "}";
    }
}
