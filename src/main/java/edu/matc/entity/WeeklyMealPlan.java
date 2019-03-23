package edu.matc.entity;

import javax.persistence.*;

@Entity(name = "WeeklyMealPlan")
@Table(name = "weeklyMealPlan")
public class WeeklyMealPlan {

    @Id
    @Column(name="weeklyMealPlanId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int weeklyMealPlanId;

    @Column(name="weeklyMealPlanName")
    private String weeklyMealPlanName;

    @ManyToMany
    @JoinColumn(name="recipe_id")
    private UserRecipes userRecipes;

    @ManyToMany
    @JoinColumn(name="user_id")
    private User user;

    public WeeklyMealPlan() {}

    public WeeklyMealPlan(int weeklyMealPlanId, String weeklyMealPlanName, UserRecipes userRecipes, User user) {

        this.weeklyMealPlanId = weeklyMealPlanId;
        this.weeklyMealPlanName = weeklyMealPlanName;
        this.userRecipes = userRecipes;
        this.user = user;
    }

    /**
     * @return
     */
    public int getWeeklyMealPlanId() {
        return weeklyMealPlanId;
    }

    /**
     * @param weeklyMealPlanId
     */
    public void setWeeklyMealPlanId(int weeklyMealPlanId) {
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
}
