package per.khalilov.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import per.khalilov.ApplicationManager;
import per.khalilov.model.AccountData;
import org.junit.Test;
import per.khalilov.model.MagicItemData;
import per.khalilov.util.Settings;

import java.util.List;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static per.khalilov.generator.MagicItemTestDataParser.parseMagicItemData;

public class MagicItemTest extends AuthBase {

    public static List<MagicItemData> getMagicItems() {
        try {
            return parseMagicItemData("magicItems.xml");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @ParameterizedTest
    @MethodSource("getMagicItems")
    public void testCreateMagicItem(MagicItemData magicItem) {
        manager = ApplicationManager.getInstance();
        AccountData user = new AccountData(Settings.username, Settings.password);

        manager.goTo().homePage();
        manager.manageAccount().loginUser(user);
        manager.magicItem().createMagicItem(magicItem);
        MagicItemData created = manager.magicItem().getCreatedMagicItemData();

        assertThat("", magicItem.getTitle(), equalTo(created.getTitle()));
        assertThat("", magicItem.getType(), equalTo(created.getType()));
        assertThat("", magicItem.getQuality(), equalTo(created.getQuality()));
        assertThat("", magicItem.getDescription(), equalTo(created.getDescription()));
    }

    @Test
    public void testEditMagicItem() {
        MagicItemData magicItem = new MagicItemData(UUID.randomUUID().toString(),
                MagicItemData.ItemTypeEnum.Potion,
                MagicItemData.ItemQualityEnum.Artefact,
                "safsdgfsdfsgsdfgdsf g nfg fdn dkfj jdfs,b df.kjb dhfj bkjdfb ksjdb hjbcxj bsdb kjb jhb jkdb cxjkb kdsjbxcjkxb jds");
        magicItem.setPrice("65436");
        magicItem.setSubtype("sdfgsfdfsdvfsd");
        magicItem.setSubquality("sgsdfsd");
        magicItem.setTitleEn("sdfasdgsdfvf");
        String magicItemEditedSubtype = "testSubtypeeeeeeeee";

        manager.magicItem().createMagicItem(magicItem);
        manager.magicItem().editMagicItemSubtype(magicItemEditedSubtype);
        MagicItemData created = manager.magicItem().getCreatedMagicItemData();

        assertThat("", created.getSubtype(), equalTo(magicItemEditedSubtype));
    }

}
