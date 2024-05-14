package per.khalilov.helper;

import org.openqa.selenium.By;
import per.khalilov.ApplicationManager;
import per.khalilov.model.MagicItemData;

public class MagicItemHelper extends HelperBase {

    public MagicItemHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createMagicItem(MagicItemData magicItem) {
        manager.goTo().workshopPage();
        driver.findElement(By.cssSelector("li:nth-child(7) .btn")).click();
        if (magicItem.getTitle() != null) {
            driver.findElement(By.name("title")).click();
            driver.findElement(By.name("title")).sendKeys(magicItem.getTitle());
        }
        if (magicItem.getTitleEn() != null) {
            driver.findElement(By.name("title_en")).click();
            driver.findElement(By.name("title_en")).sendKeys(magicItem.getTitleEn());
        }
        if (magicItem.getType() != null) {
            driver.findElement(By.name("type")).click();
            driver.findElement(By.cssSelector(".active .if-list__item:nth-child(" + magicItem.getType().index + ") > .if-list__item-title")).click();
        }
        if (magicItem.getSubtype() != null) {
            driver.findElement(By.name("subtype")).click();
            driver.findElement(By.name("subtype")).sendKeys(magicItem.getSubtype());
        }
        if (magicItem.getPrice() != null) {
            driver.findElement(By.name("price")).click();
            driver.findElement(By.name("price")).sendKeys(magicItem.getPrice());
        }
        if (magicItem.getQuality() != null) {
            driver.findElement(By.name("quality")).click();
            driver.findElement(By.cssSelector(".active .if-list__item:nth-child(" + magicItem.getQuality().index + ") > .if-list__item-title")).click();
        }
        if (magicItem.getSubquality() != null) {
            driver.findElement(By.name("subquality")).click();
            driver.findElement(By.name("subquality")).sendKeys(magicItem.getSubquality());
        }
        driver.findElement(By.xpath("//*[@id=\"editor_block\"]/div/div/div[2]/form/div/div[12]/input")).click();
        if (magicItem.getDescription() != null) {
            driver.findElement(By.cssSelector(".trumbowyg-editor")).click();
            {
                driver.findElement(By.cssSelector(".trumbowyg-editor")).sendKeys(magicItem.getDescription());
            }
        }
        driver.findElement(By.xpath("//*[@id=\"editor_block\"]/div/div/div[2]/form/div/div[12]/input")).click();
    }

}
