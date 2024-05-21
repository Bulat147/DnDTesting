package per.khalilov.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Test;
import per.khalilov.model.MagicItemData;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static per.khalilov.generator.MagicItemTestDataParser.parseMagicItemData;

@RunWith(Parameterized.class)
public class MagicItemTest extends AuthBase {

    private MagicItemData magicItem;

    public MagicItemTest(MagicItemData magicItem) {
        this.magicItem = magicItem;
    }

    @Parameterized.Parameters
    public static List<MagicItemData> magicItems() {
        try {
            return parseMagicItemData("magicItems.xml");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testCreateMagicItem() {
        manager.magicItem().createMagicItem(magicItem);
        MagicItemData created = manager.magicItem().getCreatedMagicItemData();

        assertThat("", magicItem.getTitle(), equalTo(created.getTitle()));
        assertThat("", magicItem.getType(), equalTo(created.getType()));
        assertThat("", magicItem.getQuality(), equalTo(created.getQuality()));
        assertThat("", magicItem.getDescription(), equalTo(created.getDescription()));
    }

    @Test
    public void testEditMagicItem() {
        String magicItemEditedSubtype = "testSubtypeeeeeeeee";

        manager.magicItem().createMagicItem(magicItem);
        manager.magicItem().editMagicItemSubtype(magicItemEditedSubtype);
        MagicItemData created = manager.magicItem().getCreatedMagicItemData();

        assertThat("", created.getSubtype(), equalTo(magicItemEditedSubtype));
    }

}
