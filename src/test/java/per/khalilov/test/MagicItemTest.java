package per.khalilov.test;

import per.khalilov.model.AccountData;
import org.junit.Test;
import per.khalilov.model.MagicItemData;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MagicItemTest extends BaseTest {

    @Test
    public void createMagicItemTest() {
        AccountData user = new AccountData("Bulat147", "147258369Hb");
        MagicItemData magicItem = new MagicItemData(UUID.randomUUID().toString(),
                MagicItemData.ItemTypeEnum.Potion,
                MagicItemData.ItemQualityEnum.Artefact,
                "safsdgfsdfsgsdfgdsf g nfg fdn dkfj jdfs,b df.kjb dhfj bkjdfb ksjdb hjbcxj bsdb kjb jhb jkdb cxjkb kdsjbxcjkxb jds");
        magicItem.setPrice("65436");
        magicItem.setSubtype("sdfgsfdfsdvfsd");
        magicItem.setSubquality("sgsdfsd");
        magicItem.setTitleEn("sdfasdgsdfvf");

        manager.goTo().homePage();
        manager.manageAccount().loginUser(user);
        manager.magicItem().createMagicItem(magicItem);
        MagicItemData created = manager.magicItem().getCreatedMagicItemData();
        manager.goTo().homePage();
        manager.manageAccount().logoutUser();

        assertThat("", magicItem.getTitle(), equalTo(created.getTitle()));
        assertThat("", magicItem.getType(), equalTo(created.getType()));
        assertThat("", magicItem.getQuality(), equalTo(created.getQuality()));
        assertThat("", magicItem.getDescription(), equalTo(created.getDescription()));
    }

}
