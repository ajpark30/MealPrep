package edu.matc.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * A class to represent a user.
 *
 * @author apark 2/23/19
 */
@Entity(name = "User")
@Table(name = "users")
public class User {

    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int userId;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_password")
    private String userPassword;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER) //You'll prob want to use LAZY later on
    private Set<UserRecipes> userRecipesSet = new HashSet<>();


    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName         the first name
     * @param lastName          the last name
     * @param userName          the user name
     * @param userPassword      the users password
     */
    public User(String firstName, String lastName, String userName, String userPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    /**
     * Gets user id.
     *
     * @return the UserId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets user password.
     *
     * @return userPassword the user password
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Sets user password.
     *
     * @param userPassword the user password
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * Gets Set of Recipes
     * @return
     */
    public Set<UserRecipes> getUserRecipesSet() {
        return userRecipesSet;
    }

    /**
     * Sets Users set of recipes
     * @param userRecipesSet
     */
    public void setUserRecipesSet(Set<UserRecipes> userRecipesSet) {
        this.userRecipesSet = userRecipesSet;
    }

    /**
     * Add user recipes
     * @param userRecipes
     */
    public void addUserRecipes(UserRecipes userRecipes) {
        userRecipesSet.add(userRecipes);
        userRecipes.setUser(this);
    }

    /**
     * Remove user Recipes
     * @param userRecipes
     */
    public void removeUserRecipes(UserRecipes userRecipes) {
        userRecipesSet.add(userRecipes);
        userRecipes.setUser(null);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }

}