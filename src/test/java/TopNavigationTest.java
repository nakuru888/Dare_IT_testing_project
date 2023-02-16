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

import static pageUrl.PageUrl.HOMEPAGE_URL;

public class TopNavigationTest {
      private WebDriver driver;
    private TopNavigation topNavigation;
    private List<WebElement> topCategoriesList;

    @BeforeClass
    public void setUp() {
        driver = WebDriverUtils.createWebDriver();
        driver.get(HOMEPAGE_URL);
        topNavigation = new TopNavigation(driver);
        topCategoriesList = topNavigation.getTopCategoriesList();
    }

    @Test
    public void topNavigation_TopLevelCategories_CorrectlyDisplayed() {
        //then
        List<String> expectedNamesList = List.of("What's New", "Women", "Men", "Gear", "Training", "Sale");
        List<String> expectedLinkList = List.of("what-is-new.html", "women.html", "men.html",
                "gear.html", "training.html", "sale.html");
        validateMenuCategoriesNamesAndLinks(topCategoriesList, expectedNamesList, expectedLinkList);
    }

    @DataProvider
    public Object[][] secondCategoriesLevelWithExpectedNamesAndLinks() {

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

    @DataProvider
    public Object[][] thirdCategoriesLevelWithExpectedNamesAndLinksWomenTops() {
       
        return new Object[][]{
                {topCategoriesList.get(1), 1, List.of("Jackets", "Hoodies & Sweatshirts", "Tees", "Bras & Tanks"), List.of("women/tops-women/jackets-women.html",
                        "women/tops-women/hoodies-and-sweatshirts-women.html", "women/tops-women/tees-women.html", "women/tops-women/tanks-women.html")},
                {topCategoriesList.get(1), 2, List.of("Pants", "Shorts"), List.of("women/bottoms-women/pants-women.html", "women/bottoms-women/shorts-women.html")},
                {topCategoriesList.get(2), 1, List.of("Jackets", "Hoodies & Sweatshirts", "Tees", "Tanks"), List.of("men/tops-men/jackets-men.html",
                        "men/tops-men/hoodies-and-sweatshirts-men.html", "men/tops-men/tees-men.html", "men/tops-men/tanks-men.html")},
                {topCategoriesList.get(2), 2, List.of("Pants", "Shorts"), List.of("men/bottoms-men/pants-men.html", "men/bottoms-men/shorts-men.html")},
        };
    }

    @Test(dataProvider = "thirdCategoriesLevelWithExpectedNamesAndLinksWomenTops")
    public void topNavigation_ThirdLevelCategories_CorrectlyDisplayed(WebElement topCategory, Integer secondCategoryLevelChildNumber,
                                                                      List<String> expectedCategoriesNames, List<String> expectedCategoriesLinks) {
        //given
        topNavigation.hoverOnCategory(topCategory);
        String cssSelectorForSecondLevelCategory = String.format("ul.level0 li.level1:nth-child(%s)", secondCategoryLevelChildNumber);
        WebElement secondLevelCategory = topCategory.findElement(By.cssSelector(cssSelectorForSecondLevelCategory));

        //when
        topNavigation.hoverOnCategory(secondLevelCategory);
        List<WebElement> thirdLevelCategories = secondLevelCategory.findElements(By.cssSelector("ul.level1 li.level2"));

        //then
        validateMenuCategoriesNamesAndLinks(thirdLevelCategories, expectedCategoriesNames, expectedCategoriesLinks);
    }

    public void validateMenuCategoriesNamesAndLinks(List<WebElement> categoriesList, List<String> expectedCategoriesNames,
                                                    List<String> expectedCategoriesLinks) {

        List<String> actualCategoriesNames = new ArrayList<>();
        List<String> actualCategoriesLinks = new ArrayList<>();
        List<String> expectedCategoriesLinksWithDomain = new ArrayList<>();

        for (WebElement category : categoriesList) {
            WebElement categoryName = category.findElement(By.cssSelector("ul a > span:not(.ui-menu-icon)"));
            Assertions.assertThat(categoryName.isDisplayed()).isTrue();
            actualCategoriesNames.add(categoryName.getText());
            WebElement categoryLink = category.findElement(By.cssSelector("ul a"));
            Assertions.assertThat(categoryLink.isEnabled()).isTrue();
            actualCategoriesLinks.add(categoryLink.getAttribute(Attribute.HREF.name()));
        }

        for (String link : expectedCategoriesLinks) {
            expectedCategoriesLinksWithDomain.add(HOMEPAGE_URL + link);
        }

        Assertions.assertThat(actualCategoriesNames).hasSameElementsAs(expectedCategoriesNames);
        Assertions.assertThat(actualCategoriesLinks).hasSameElementsAs(expectedCategoriesLinksWithDomain);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
