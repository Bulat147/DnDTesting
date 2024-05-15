package per.khalilov.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MagicItemData {

    private String title;
    private String titleEn;
    private ItemTypeEnum type;
    private String subtype;
    private String price;
    private ItemQualityEnum quality;
    private String subquality;
    private String description;

    public MagicItemData(String title, ItemTypeEnum type, ItemQualityEnum quality, String description) {
        this.title = title;
        this.type = type;
        this.quality = quality;
        this.description = description;
    }

    public enum ItemTypeEnum {
        MagicWand("1", "Волшебная палочка"),
        Armor("2", "Доспех"),
        TheWand("3", "Жезл"),
        Potion("4", "Зелье"),
        Ring("5", "Кольцо"),
        Weapon("6", "Оружие"),
        Stick("7", "Посох"),
        TheScroll("8", "Свиток"),
        FantasticItem("9", "Чудесный предмет");

        public final String index;
        public final String title;

        private ItemTypeEnum(String index, String title) {
            this.index = index;
            this.title = title;

        }
    }

    public enum ItemQualityEnum {
        Ordinary("1", "Обычный"),
        Unusual("2", "Необычный"),
        Rare("3", "Редкий"),
        VeryRare("4", "Очень редкий"),
        Legendary("5", "Легендарный"),
        Artefact("6", "Артефакт"),
        WithoutQuality("7", "Не имеет редкости"),
        QualityVaries("8", "Редкость варьируется");

        public final String index;
        public final String title;

        private ItemQualityEnum(String index, String title) {
            this.index = index;
            this.title = title;
        }
    }


}
