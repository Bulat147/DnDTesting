package per.khalilov.generator;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import per.khalilov.model.MagicItemData;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class MagicItemTestDataGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите кол-во предметов: ");
        int count = scanner.nextInt();
        saveToXml(generateMagicItems(count), "magicItems" + new Random().nextInt(1000) + ".xml");
    }

    public static List<MagicItemData> generateMagicItems(int count) {
        List<MagicItemData> magicItems = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            MagicItemData magicItem = new MagicItemData(UUID.randomUUID().toString(),
                    MagicItemData.ItemTypeEnum.Potion,
                    MagicItemData.ItemQualityEnum.Artefact,
                    randomString(70));
            magicItem.setPrice(randomString(6));
            magicItem.setSubtype(randomString(12));
            magicItem.setSubquality(randomString(10));
            magicItem.setTitleEn(randomString(12));
            magicItems.add(magicItem);
        }
        return magicItems;
    }


    public static String randomString(int length) {
        String alf = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(alf.charAt(random.nextInt(alf.length())));
        }
        return sb.toString();
    }

    public static void saveToXml(List<MagicItemData> magicItems, String fileName) {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            xmlMapper.writeValue(new File(fileName), magicItems);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
