import components.TopNavigation;
import enums.Attribute;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.WebDriverUtils;

import java.util.ArrayList;
import java.util.List;

public class TopNavigationTest {
    private static final String HOMEPAGE_URL = "https://magento.softwaretestingboard.com/";
    private static final By topNavigationBarCategoryNameFirstLevel = By.cssSelector("a > span:not(.ui-menu-icon)");
    private static final By topNavigationBarCategoryFirstLevelLink = By.cssSelector("a");

    private WebDriver driver;
    private TopNavigation topNavigation;

    @BeforeClass
    public void setUp() {
        driver = WebDriverUtils.createWebDriver();
        driver.get(HOMEPAGE_URL);
        topNavigation = new TopNavigation(driver);
    }

    @Test
    public void topNavigation_TopLevelCategories_CorrectlyDisplayed() {
        //given
        List<WebElement> topCategoriesList = topNavigation.getTopCategoriesList();

        //then
        List<String> expectedNamesList = List.of("What's New", "Women", "Men", "Gear", "Training", "Sale");
        List<String> expectedLinkList = List.of("what-is-new.html", "women.html", "men.html",
                "gear.html", "training.html", "sale.html");
        validateMenuCategoriesNamesAndLinks(topCategoriesList, expectedNamesList, expectedLinkList);
    }

    @DataProvider
    public Object[][] secondCategoriesLevelWithExpectedNamesAndLinks() {
        List<WebElement> topCategoriesList = topNavigation.getTopCategoriesList();

        return new Object[][]{
                {topCategoriesList.get(1), List.of("Tops", "Bottoms"), List.of("women/tops-women.html", "women/bottoms-women.html")},
                {topCategoriesList.get(2), List.of("Tops", "Bottoms"), List.of("men/tops-men.html", "men/bottoms-men.html")},
                {topCategoriesList.get(3), List.of("Bags", "Fitness Equipment", "Watches"), List.of("gear/bags.html", "gear/fitness-equipment.html",
                        "gear/watches.html")},
                {topCategoriesList.get(4), List.of("Video Download"), List.of("training/training-video.html")},
        };
    }

    @Test(dataProvider = "secondCategoriesLevelWithExpectedNamesAndLinks")
    public void topNavigation_SecondLevelCategories_CorrectlyDisplayed(WebElement topCategoryHavingSecondLevelSubMenu, List<String> expectedCategoriesNames,
                                                                       List<String> expectedCategoriesLinks) {
        //when
        topNavigation.hoverOnCategory(topCategoryHavingSecondLevelSubMenu);
        List<WebElement> secondLevelCategories = topCategoryHavingSecondLevelSubMenu.findElements(By.cssSelector("ul.level0 li.level1"));

        //then
        validateMenuCategoriesNamesAndLinks(secondLevelCategories, expectedCategoriesNames, expectedCategoriesLinks);
    }

    public void validateMenuCategoriesNamesAndLinks(List<WebElement> categoriesList, List<String> expectedCategoriesNames,
                                                    List<String> expectedCategoriesLinks) {

        List<String> actualCategoriesNames = new ArrayList<>();
        List<String> actualCategoriesLinks = new ArrayList<>();
        List<String> expectedCategoriesLinksWithDomain = new ArrayList<>();

        for (WebElement category : categoriesList) {
            WebElement categoryName = category.findElement(topNavigationBarCategoryNameFirstLevel);
            Assertions.assertThat(categoryName.isDisplayed()).isTrue();
            actualCategoriesNames.add(categoryName.getText());
            WebElement categoryLink = category.findElement(topNavigationBarCategoryFirstLevelLink);
            Assertions.assertThat(categoryLink.isEnabled()).isTrue();
            actualCategoriesLinks.add(categoryLink.getAttribute(Attribute.HREF.name()));
        }

        for (String link : expectedCategoriesLinks) {
            expectedCategoriesLinksWithDomain.add("https://magento.softwaretestingboard.com/" + link);
        }

        Assertions.assertThat(actualCategoriesNames).hasSameElementsAs(expectedCategoriesNames);
        Assertions.assertThat(actualCategoriesLinks).hasSameElementsAs(expectedCategoriesLinksWithDomain);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
