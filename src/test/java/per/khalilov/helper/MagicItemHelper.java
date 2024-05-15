package per.khalilov.helper;

import org.openqa.selenium.By;
import per.khalilov.ApplicationManager;
import per.khalilov.model.MagicItemData;

import java.util.Arrays;
import java.util.Objects;

import static per.khalilov.test.BaseTest.sleepWithTime;

public class MagicItemHelper extends HelperBase {

    public MagicItemHelper(ApplicationManager manager) {
        super(manager);
    }

    public void editMagicItemSubtype(String subtype) {
        driver.findElement(By.xpath("//*[@id=\"body\"]/main/div/div/div/section[2]/div[2]/div/div/div[2]/div")).click();
        driver.findElement(By.cssSelector("#body > main > div > div > div > section:nth-child(2) > div.cards-wrapper > div > div > div.card__header > div > ul > li:nth-child(3)")).click();
        driver.findElement(By.name("subtype")).clear();
        driver.findElement(By.name("subtype")).sendKeys(subtype);
        driver.findElement(By.cssSelector(".btn")).click();
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

    public MagicItemData getCreatedMagicItemData() {
        sleepWithTime(2000L);
        String[] name = driver.findElement(By.xpath("//*[@id=\"body\"]/main/div/div/div/section[2]/div[2]/div/div/div[2]/h2/span")).getText().split(" ");
        String title = name[0];
        String title_en = null;
        if (name.length > 1) {
            title_en = name[1].substring(1, name[1].length() - 1);
        }
        String[] characteristics = driver.findElement(By.xpath("//*[@id=\"body\"]/main/div/div/div/section[2]/div[2]/div/div/div[3]/ul/li[1]")).getText().split(" ");
        MagicItemData.ItemTypeEnum type = Arrays.stream(MagicItemData.ItemTypeEnum.values())
                .filter(it -> Objects.equals(it.title.toLowerCase(), characteristics[0].toLowerCase())).findFirst().get();
        String subtype = characteristics[1].substring(1, characteristics[1].length() - 2);
        MagicItemData.ItemQualityEnum quality = Arrays.stream(MagicItemData.ItemQualityEnum.values())
                .filter(it -> Objects.equals(it.title.toLowerCase(), characteristics[2].toLowerCase())).findFirst().get();
        String subquality = characteristics[3].substring(1, characteristics[3].length() - 1);

        String priceText = driver.findElement(By.xpath("//*[@id=\"body\"]/main/div/div/div/section[2]/div[2]/div/div/div[3]/ul/li[2]")).getText();
        String price = priceText.substring(2, priceText.length() - 1);
        String descriptionText = driver.findElement(By.xpath("//*[@id=\"body\"]/main/div/div/div/section[2]/div[2]/div/div/div[3]/ul/li[4]/div")).getText();
//        String description = descriptionText.substring(1, descriptionText.length() - 1);

        MagicItemData magicItemData = new MagicItemData(title, type, quality, descriptionText);
        magicItemData.setTitleEn(title_en);
        magicItemData.setPrice(price);
        magicItemData.setSubtype(subtype);
        magicItemData.setSubquality(subquality);
        return magicItemData;
    }

    public void openCreatedMagicItem(String name, Integer index) {
        String addText = "";
        if (index != null) {
            addText = String.valueOf(index+1);
        }
        driver.findElement(
                By.xpath("//*[@id=\"body\"]/main/div/div/div/section[2]/div/div/div/ul/li[6]/p[2]//*[text()='" + name + "']" + addText)
        ).click();
    }

}
