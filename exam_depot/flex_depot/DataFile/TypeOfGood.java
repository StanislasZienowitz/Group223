package flex_depot.DataFile;

public enum TypeOfGood {
    MATERIALS ("1", "Материалы"),
    INDUSTRIAL_PRODUCTS ("2", "Промышленное оборудование в сборе"),
    VEHICLES_PARTS ("3", "Запасные части машин и механизмов"),
    AEROSPACE_DEFENSE ("4", "Средства защиты и обороны"),
    CONSUMER_DEFENSE ("5", "Товары постоянного спроса"),
    CONSUMER_CYCLE ("6", "Товары выборочного спроса"),
    SHORT_TERM_GOOD ("7", "Продукты питания долговременного хранения"),
    NO_SHORT_TERM_GOOD("8", "Продукты питания кратковременного хранения"),
    OTHER_GOOD_TYPE("10", "Категория товара не найдена");

    private final String number;
    private final String desc;

    TypeOfGood (String number, String desc) {
        this.number = number;
        this.desc = desc;
    }

    public static String writtingOfTypeOfGood(String inputOfChosenNewGoodType) {
        String choiceForNameOfGoodType;
        int numberOfChosenNewGoodType = Integer.parseInt(inputOfChosenNewGoodType);
        switch (numberOfChosenNewGoodType) {
            case 1 -> choiceForNameOfGoodType = MATERIALS.desc;
            case 2 -> choiceForNameOfGoodType = INDUSTRIAL_PRODUCTS.desc;
            case 3 -> choiceForNameOfGoodType = VEHICLES_PARTS.desc;
            case 4 -> choiceForNameOfGoodType = AEROSPACE_DEFENSE.desc;
            case 5 -> choiceForNameOfGoodType = CONSUMER_DEFENSE.desc;
            case 6 -> choiceForNameOfGoodType = CONSUMER_CYCLE.desc;
            case 7 -> choiceForNameOfGoodType = SHORT_TERM_GOOD.desc;
            case 8 -> choiceForNameOfGoodType = NO_SHORT_TERM_GOOD.desc;
            default -> choiceForNameOfGoodType = OTHER_GOOD_TYPE.desc;
        }
        return choiceForNameOfGoodType;
    }
}
