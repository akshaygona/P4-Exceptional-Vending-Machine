//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P04 Exceptional Vending Machine
// Course:   CS 300 Fall 2022
//
// Author:   Akshay Gona
// Email:    gona@wisc.edu
// Lecturer: Hobbes LeGault
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:  Varun Munagala, Rishit Patil, Shrivats Sriram, Sam Eron, all helped me debug my code.
// Online Sources:  stackoverflow, zybooks, github, youtube videos on how to use try catch and
//                  handle exceptions
//
///////////////////////////////////////////////////////////////////////////////



/**
 * This class and the method within model an item defined by its description and expiration date.
 */
public class Item {
    private final int expirationDate;
    private String description;

    /**
     * This method creates a new Item Object with a specific expiration date and description
     *
     * @param description
     * @param expirationDate
     * @throws IllegalArgumentException
     */
    public Item(String description, int expirationDate) throws IllegalArgumentException {
        if ((description == null) || expirationDate < 0 || description.isBlank()) {
            throw new IllegalArgumentException(
                "Error: Description is null or expirationDate is less than 0");
        }
        this.description = description;
        this.expirationDate = expirationDate;
    }

    /**
     * This method gets the description of this item
     *
     * @return
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * This method changes the description of this item
     *
     * @param description
     * @throws IllegalArgumentException
     */
    public void setDescription(String description) throws IllegalArgumentException {
        if (description == null) {
            throw new IllegalArgumentException("Error: description is null");
        }
        this.description = description;
    }

    /**
     * This method gets the expiration date of this item
     *
     * @return
     */
    public int getExpirationDate() {
        return this.expirationDate;
    }

    /**
     * This method returns a String representation of this item formatted as
     * "description: expirationDate"
     *
     * @return string which describes item within vending machine and expiration date formatted
     */
    @Override public String toString() {
        return (description + ": " + expirationDate);
    }

    /**
     * This method checks whether this item equals another object passed as input.
     *
     * @param other
     * @return
     */
    @Override public boolean equals(Object other) {
        if (other instanceof Item) {
            Item otherItem = (Item) other;
            return otherItem.getDescription().equals(this.getDescription());
        }
        return false;
    }
}
