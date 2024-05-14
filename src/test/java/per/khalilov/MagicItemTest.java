package per.khalilov;

import per.khalilov.model.AccountData;
import org.junit.Test;
import per.khalilov.model.MagicItemData;

import java.util.UUID;

public class MagicItemTest extends BaseTest {

    @Test
    public void createMagicItemTest() {
        AccountData user = new AccountData("Bulat147", "147258369Hb");
        MagicItemData magicItem = new MagicItemData(UUID.randomUUID().toString(),
                MagicItemData.ItemTypeEnum.Potion,
                MagicItemData.ItemQualityEnum.Artefact,
                "safsdgfsdfsgsdfgdsf g nfg fdn dkfj jdfs,b df.kjb dhfj bkjdfb ksjdb hjbcxj bsdb kjb jhb jkdb cxjkb kdsjbxcjkxb jds");

        openHomePage();
        loginUser(user);
        createMagicItem(magicItem);
        logoutUser();
    }

}
