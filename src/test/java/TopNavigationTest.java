import Components.TopNavigation;
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
    private static final By TOP_NAVIGATION_BAR_CATEGORY_NAME_FIRST_LEVEL = By.cssSelector(".navigation li.level0 > a> span:not(.ui-menu-icon)");
    private static final By TOP_NAVIGATION_BAR_CATEGORY_FIRST_LEVEL_LINK = By.cssSelector(".navigation li.level0 > a");

    private WebDriver driver;
    private TopNavigation topNavigation;

    @BeforeClass
    public void setUp() {
        driver = WebDriverUtils.createWebDriver();
        driver.get(HOMEPAGE_URL);
        topNavigation = new TopNavigation(driver);
    }

    @DataProvider
    public Object[][] secondCategoriesLevelWithExpectedNamesAndLinks() {
        List<WebElement> topCategoriesList = topNavigation.getTopCategoriesList();

        return new Object[][]{
                {topCategoriesList.get(1), List.of("Tops", "Bottoms"), List.of(HOMEPAGE_URL + "women/tops-women.html", HOMEPAGE_URL + "women/bottoms-women.html")},
                {topCategoriesList.get(2), List.of("Tops", "Bottoms"), List.of(HOMEPAGE_URL + "men/tops-men.html", HOMEPAGE_URL + "men/bottoms-men.html")},
                {topCategoriesList.get(3), List.of("Bags", "Fitness Equipment", "Watches"), List.of(HOMEPAGE_URL + "gear/bags.html", HOMEPAGE_URL + "gear/fitness-equipment.html"),
                        HOMEPAGE_URL + "gear/watches.html"},
                {topCategoriesList.get(4), List.of("Video Download"), List.of(HOMEPAGE_URL + "training/training-video.html")},
        };
    }

    @Test
    public void topNavigation_TopLevelCategories_CorrectlyDisplayed() {
        //given
        List<WebElement> topCategoriesList = topNavigation.getTopCategoriesList();

        //then
        List<String> expectedNamesList = List.of("What's New", "Women", "Men", "Gear", "Training", "Sale");
        List<String> expectedLinkList = List.of(HOMEPAGE_URL + "what-is-new.html", HOMEPAGE_URL + "women.html", HOMEPAGE_URL + "men.html",
                HOMEPAGE_URL + "gear.html", HOMEPAGE_URL + "training.html", HOMEPAGE_URL + "sale.html");
        validateMenuCategoriesNamesAndLinks(topCategoriesList, expectedNamesList, expectedLinkList);
    }

    @Test(dataProvider = "secondCategoriesLevelWithExpectedNamesAndLinks")
    public void topNavigation_SecondLevelCategories_CorrectlyDisplayed(WebElement topCategoryHavingSecondLevelSubMenu, List<String> expectedCategoriesNames,
                                                                       List<String> expectedCategoriesLinks) {
        //when
        topNavigation.hoverOnCategory(topCategoryHavingSecondLevelSubMenu);
        List<WebElement> secondLevelCategories = topCategoryHavingSecondLevelSubMenu.findElements(By.cssSelector("ul.level0"));

        //then
        validateMenuCategoriesNamesAndLinks(secondLevelCategories, expectedCategoriesNames, expectedCategoriesLinks);
    }

    public void validateMenuCategoriesNamesAndLinks(List<WebElement> categoriesList, List<String> expectedCategoriesNames,
                                                    List<String> expectedCategoriesLinks) {

        List<String> actualCategoriesNames = new ArrayList<>();
        List<String> actualCategoriesLinks = new ArrayList<>();

        for (WebElement category : categoriesList) {
            WebElement categoryName = category.findElement(TOP_NAVIGATION_BAR_CATEGORY_NAME_FIRST_LEVEL);
            Assertions.assertThat(categoryName.isDisplayed()).isTrue();
            actualCategoriesNames.add(categoryName.getText());
            WebElement categoryLink = category.findElement(TOP_NAVIGATION_BAR_CATEGORY_FIRST_LEVEL_LINK);
            Assertions.assertThat(categoryLink.isEnabled()).isTrue();
            actualCategoriesLinks.add(categoryLink.getAttribute(Attribute.HREF.name()));
        }

        Assertions.assertThat(actualCategoriesNames).hasSameElementsAs(expectedCategoriesNames);
        Assertions.assertThat(actualCategoriesLinks).hasSameElementsAs(expectedCategoriesLinks);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
