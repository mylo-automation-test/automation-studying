package collections;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CollectionTest {

    private List<String> things;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        things = new ArrayList<>();
        things.add("something");
        things.add("anything");
        System.out.println("List before test: " + things);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        System.out.println("List after test: " + things);
    }

    @Test(groups = "collections")
    public void addShouldIncreaseSize() {
        things.add("new thing");
        Assert.assertEquals(things.size(), 3, "List size should be 3 after adding");
    }

    @Test(groups = "collections")
    public void removeShouldDecreaseSize() {
        things.remove("something");
        Assert.assertEquals(things.size(), 1, "List size should be 1 after removing");
    }

    @Test(groups = "collections")
    public void listShouldContainAddedElement() {
        things.add("modern stuff");
        Assert.assertTrue(things.contains("modern stuff"), "List should contain modern stuff");
    }

    @Test(groups = "collections")
    public void listShouldNotContainRemovedElement() {
        things.remove("something");
        Assert.assertFalse(things.contains("something"), "List should not contain something");
    }

    @Test(groups = "collections")
    public void clearShouldEmptyList() {
        things.clear();
        Assert.assertTrue(things.isEmpty(), "List should be empty after clear");
    }
}