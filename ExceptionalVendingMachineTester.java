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

// TODO import relevant exceptions here
import java.util.NoSuchElementException;
import java.util.zip.DataFormatException;

/**
 * This class implements testers to check the correctness of the methods implemented in p04
 * Exceptional Vending Machine
 */
public class ExceptionalVendingMachineTester {
    // TODO complete the implementation of all the public static tester methods defined below

    // It is recommended but NOT required to add additional tester methods to check the correctness
    // of loadItems and saveVendingMachineSummary defined in the ExceptionalVendingMachine class.

    /**
     * Checks the correctness of the constructor of the class Item when passed invalid inputs
     *
     * @return true if the test verifies a correct functionality and false if any bug is detected
     */
    public static boolean testItemConstructorNotValidInput() {
        try {
            Item x = new Item(null, -1);
            System.out.println("Error: Constructor did not throw IllegalArgumentException");
            return false;
        } catch (IllegalArgumentException e) {
            return true;
        }
    }

    /**
     * Checks the correctness of the constructor of the class Item, Item.getDescription(),
     * Item.getExpirationDate(), Item.setDescription(), and Item.toString() when passed valid inputs
     *
     * @return true if the test verifies a correct functionality and false if any bug is detected
     */
    public static boolean testItemConstructorGettersSetters() {
        Item item1 = new Item("description", 12345);
        Item item2 = new Item("description", 12345);
        Item item3 = new Item("desc", 12345);
        String s = "description";
        String s1 = "description: 12345";
        if (!item1.equals(item2) || (item1.getExpirationDate() != item2.getExpirationDate())) {
            System.out.println("item constructor fails");
            return false;
        }
        if (item1.getDescription().compareTo(s) != 0) {
            System.out.println("getDescription method fails");
            return false;
        }
        if (item1.getExpirationDate() != (12345)) {
            System.out.println("getExpirationDate method fails");
            return false;
        }
        item3.setDescription("description");
        if (!item3.equals(item1)) {
            System.out.println("setDescription method fails");
            return false;
        }
        if (item1.toString().compareTo(s1) != 0) {
            System.out.println("toString method fails");
            return false;
        }
        return true;
    }

    /**
     * Checks the correctness of the Item.equals() method. You should consider at least the following
     * four scenarios. (1) Create an item with valid description and expiration date, comparing it to
     * itself should return true. (2) Two items having the same description but different expiration
     * dates should be equal. (3) Passing a null reference to the Item.equals() method should return
     * false. (4) An item MUST NOT be equal to an object NOT instance of the class Item, for instance
     * a string object.
     *
     * @return true if the test verifies a correct functionality and false if any bug is detected
     */
    public static boolean testItemEquals() {
        //1. Create an item with valid description and expiration date, self comparison should return true.
        Item item1 = new Item("abc", 123);
        if (!item1.equals(item1)) {
            System.out.println("testItemEquals case1 fails");
            return false;
        }
        //2. Two items having same description but different expiration dates should be equal.
        Item item2 = new Item("abc", 124);
        if (!item1.equals(item2)) {
            System.out.println("testItemEquals case2 fails");
            return false;
        }
        //3. Passing a null reference to the Item.equals() method should return false.
        Item item3 = null;
        boolean result = item1.equals(item3);
        if (result) {
            System.out.println("testItemEquals case3 fails");
            return false;
        }
        //4. An item must not be equal to an object not instance of the class item for instance a string object.
        String s = "abc";
        if (item1.equals(s)) {
            System.out.println("testItemEquals case4 fails");
            return false;
        }
        return true;
    }


    /**
     * Checks the correctness of the constructor of the ExceptionalVendingMachine when passed invalid
     * input
     *
     * @return true if the test verifies a correct functionality and false if any bug is detected
     */
    public static boolean testExceptionalVendingMachineConstructor()
        throws IllegalArgumentException {
        try {
            ExceptionalVendingMachine items = new ExceptionalVendingMachine(0);
        } catch (IllegalArgumentException e) {
            if (!e.getMessage().equals("Error: Capacity is less than or equal to 0.")) {
                System.out.println("testExceptionalVendingMachineConstructor case1 fails");
                return false;
            }
        }
        return true;
    }

    /**
     * Checks the correctness of the following methods defined in the ExceptionalVendingMachine class
     * when an exception is expected to be thrown:
     * <p>
     * addItem(), containsItem(), getIndexNextItem(), getItemAtIndex(), getItemOccurrences(),
     * getItemOccurrencesByExpirationDate(), removeNextItem().
     *
     * @return true if the test verifies a correct functionality and false if any bug is detected
     */
    public static boolean testExceptionalVendingMachineAddContainsRemoveGetters() {
        ExceptionalVendingMachine items = new ExceptionalVendingMachine(10);
        //addItem
        try {
            items.addItem("akshay", -69);
            System.out.println("addItem negative expDate case wrong");
            return false;
        } catch (IllegalArgumentException e) {
        } catch (Exception e) {
            System.out.println("addItem throws wrong exception");
            return false;
        }
        try {
            items.addItem("", 69);
            System.out.println("addItem blank case wrong");
            return false;
        } catch (IllegalArgumentException e) {
        } catch (Exception e) {
            System.out.println("addItem throws wrong exception");
            return false;
        }
        try {
            items.addItem(null, 69);
            System.out.println("addItem null case wrong");
            return false;
        } catch (IllegalArgumentException e) {
        } catch (Exception e) {
            System.out.println("addItem throws wrong exception");
            return false;
        }
        try {
            items.addItem("akshay", 69);
            if (items.size() != 1) {
                System.out.println("addItem doesn't add or change size");
                return false;
            }
        } catch (Exception e) {
            System.out.println("addItem throws exception where exception should not be thrown");
            return false;
        }

        //containsItem
        try {
            items.containsItem("  ");
            System.out.println("containsItem blank case fails");
            return false;
        } catch (IllegalArgumentException e) {
        } catch (Exception e) {
            System.out.println("containsItem throws the wrong exception");
            return false;
        }
        try {
            items.containsItem(null);
            System.out.println("containsItem null case fails");
            return false;
        } catch (IllegalArgumentException e) {
        } catch (Exception e) {
            System.out.println("containsItem throws the wrong exception");
            return false;
        }
        if (!items.containsItem("akshay")) {
            System.out.println("containsItem returns false when item is in array");
            return false;
        }
        //getIndexNextItem
        try {
            items.getIndexNextItem(" ");
            System.out.println("getIndexNextItem blank case fails");
            return false;
        } catch (IllegalArgumentException e) {
        } catch (Exception e) {
            System.out.println("getIndexNextItem throws the wrong exception");
            return false;
        }
        try {
            items.getIndexNextItem(null);
            System.out.println("getIndexNextItem null case fails");
            return false;
        } catch (IllegalArgumentException e) {
        } catch (Exception e) {
            System.out.println("getIndexNextItem throws the wrong exception");
            return false;
        }
        try {
            items.getIndexNextItem("akshaygona");
            System.out.println("getIndexNextItem DNE case fails");
            return false;
        } catch (NoSuchElementException e) {
        } catch (Exception e) {
            System.out.println("getIndexNextItem throws the wrong exception");
            return false;
        }
        //getItemAtIndex
        try {
            items.getItemAtIndex(13);
            System.out.println("getItemAtIndex does not work");
            return false;
        } catch (IndexOutOfBoundsException e){
        } catch (Exception e) {
            System.out.println("getItemAtIndex throws the wrong exception");
        }
        if (!items.getItemAtIndex(0).equals("akshay: 69")) {
            System.out.println("getItemAtIndex fails to get item that exists or gets an item "
                + "from the incorrect index");
            return false;
        }
        //getItemOccurrences
        try {
            items.getItemOccurrences(" ");
            System.out.println("getItemOccurrences blank case fails");
            return false;
        } catch (IllegalArgumentException e) {
        }
        try {
            items.getItemOccurrences(null);
            System.out.println("getItemOccurrences null case fails");
            return false;
        } catch (IllegalArgumentException e) {
        }
        //getItemOccurrencesByExpirationDate
        try {
            items.getItemOccurrencesByExpirationDate(" ", 69);
            System.out.println("getItemOccurrencesByExpirationDate blank case fails");
            return false;
        } catch (IllegalArgumentException e) {
        }
        try {
            items.getItemOccurrencesByExpirationDate(null, 69);
            System.out.println("getItemOccurrencesByExpirationDate null case fails");
            return false;
        } catch (IllegalArgumentException e) {
        }
        try {
            items.getItemOccurrencesByExpirationDate("akshay", -1);
            System.out.println("getItemOccurrencesByExpirationDate negDate case fails");
            return false;
        } catch (IllegalArgumentException e) {
        }
        //removeNextItem
        try {
            items.removeNextItem(" ");
            System.out.println("removeNextItem blank case fails");
            return false;
        } catch (IllegalArgumentException e){
        }
        try {
            items.removeNextItem(null);
            System.out.println("removeNextItem null case fails");
            return false;
        } catch (IllegalArgumentException e){
        }
        try {
            items.removeNextItem("akshaygona1");
            System.out.println("removeNextItem DNE case fails");
            return false;
        } catch (NoSuchElementException e){
        }
        return true; // default return statement added to resolve compiler errors
    }

    /**
     * Checks the correctness of isEmpty(), size(), and isFull() methods defined in the
     * ExceptionalVendingMachine class
     *
     * @return true if the test verifies a correct functionality and false if any bug is detected
     */
    public static boolean testEmptySizeFullExceptionalVendingMachine() {
        ExceptionalVendingMachine items = new ExceptionalVendingMachine(6);
        ExceptionalVendingMachine items1 = new ExceptionalVendingMachine(2);
        if (!items.isEmpty()) {
            System.out.println("isEmpty method fails");
            return false;
        }
        items1.addItem("abc", 10202);
        items1.addItem("abc", 30923);
        if (!items1.isFull()) {
            System.out.println("isFull method fails");
            return false;
        }
        if (items1.size() != 2) {
            System.out.println("size method fails");
            return false;
        }
        return true;
    }

    /**
     * Checks the correctness of loadOneItem method with respect to its specification. Consider at
     * least the four following scenarios. (1) Successful scenario for loading one item with a valid
     * string representation to a non-full vending machine. (2) Unsuccessful scenario for passing null
     * or a blank string (for instance one space or empty string) to the loadOneItem() method call, an
     * IllegalArgumentException is expected to be thrown. (3) Unsuccessful scenario for passing a
     * badly formatted string to the loadOneItem method. A DataFormatException is expected to be
     * thrown. (4) Unsuccessful scenario for trying to load an item with a valid representation to a
     * full vending machine. An IllegalStateException is expected to be thrown.
     *
     * @return true if the test verifies a correct functionality and false if any bug is detected
     */
    public static boolean testLoadOneItem() {
        //1. Successful scenario for loading one item with a valid string representation to a
        //   non-full vending machine.
        ExceptionalVendingMachine items = new ExceptionalVendingMachine(2);
        try {
            items.loadOneItem("akshaygona: 124");
        } catch (DataFormatException e) {
            if (e.getMessage() == null) {
                System.out.println("testLoadOneItem case1 fails");
                return false;
            }
        }
        //2. Unsuccessful scenario for passing null or a blank string to the loadOneItem() method
        //   call, an IllegalArgumentException is expected to be thrown.
        try {
            items.loadOneItem(null);
        } catch (IllegalArgumentException e) {
            if (!e.getMessage().equals("Error:Given itemRepresentation is null")) {
                System.out.println("testLoadOneItem test case2 fails");
                return false;
            }
        } catch (DataFormatException e) {
            System.out.println("wrong exception thrown case2 testLoadOneItem");
            return false;
        }
        //3. Unsuccessful scenario for passing a badly formatted string to the loadOneItem method.
        //   A DataFormatException is expected to be thrown.
        try {
            items.loadOneItem("3493:43737:");
        } catch (DataFormatException e) {
            if (!e.getMessage().equals("item representation not in the correct format")) {
                System.out.println("testLoadOneItem case3 fails");
                return false;
            }
        }
        //4. Unsuccessful scenario for trying to load an item with a valid representation to a full
        //   vending machine. An IllegalStateException is expected to be thrown.
        items.addItem("gona", 2);
        try {
            items.loadOneItem("aja: 133");
            System.out.println("testLoadOneItem case4 fails");
            return false;
        } catch (IllegalStateException e) {
        } catch (Exception e) {
            System.out.println("wrong exception thrown case4 testLoadOneItem");
            return false;
        }
        return true; // default return statement added to resolve compiler errors
    }

    /**
     * Invokes all the public tester methods implemented in this class
     *
     * @return true if all testers pass with no errors, and false if any of the tester fails.
     */
    public static boolean runAllTests() {
        if ((testItemConstructorNotValidInput() != true) || (testItemConstructorGettersSetters()
            != true) || (testItemEquals() != true) || (testExceptionalVendingMachineConstructor()
            != true) || (testExceptionalVendingMachineAddContainsRemoveGetters() != true) || (
            testEmptySizeFullExceptionalVendingMachine() != true) || (testLoadOneItem() != true)) {
            System.out.println("One or more of the above methods has failed");
            return false;
        }
        System.out.println("all test cases passed");
        return true; // default return statement added to resolve compiler errors
    }

    /**
     * Main method for the tester class
     *
     * @param args list of input arguments if any
     */
    public static void main(String[] args) {
        runAllTests();
    }

}
