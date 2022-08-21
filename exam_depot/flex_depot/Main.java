package flex_depot;

import flex_depot.DataFile.*;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/*
Создать приложение «Склад».
Основная задача проекта: отображать информацию о приходе/расходе материальных средств с отображением документов,
по которым прибыли/убыли.
Система хранит следующую информацию:
    категория товаров (название категории, описание категории и т. д.);
    накладные (вид операции - приход/расход, товар, количество, дата и т. д.);
    товары, находящиеся на складе, с категорией, названием, описанием, количеством и т.д.;
    журнал прихода/расхода товаров с отображением даты и накладных изменения количества товара;
Приложение должно предоставлять интерфейс для:
    отображения состояния товаров на складе;
    получение всех накладных по типу - приход/расход;
    отображение журнала прихода/расхода за указанную пользователем дату;
    отображение статистики приход/расход за месяц;
    добавление накладной, при этом количество товара должно тоже измениться;
    вывод информации по категориям товаров;
 */

public class Main {

    static List<Good> goods = new ArrayList<>();
    static List<Deliveryman> deliverymen = new ArrayList<>();
    static List<Storekeeper> storekeepers = new ArrayList<>();
    static List<ImportOrder> importOrders = new ArrayList<>();
    static List<ExportOrder> exportOrders = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        functionMenuTitle();

        String inputOfCommand;
        BufferedReader depotFile = new BufferedReader(new InputStreamReader(System.in));
        inputOfCommand = depotFile.readLine();

        //проверки на объем не сделаны
        //чтение и запись в файл

        while (!inputOfCommand.equalsIgnoreCase("exit")) {
            if (inputOfCommand.equals("1")) {
                String descriptionOfFunctionForCurrentStateDepot;
                descriptionOfFunctionForCurrentStateDepot = "5. Вывести текущее состояние склада";
                String descriptionOfFunctionForCurrentStateDepotByGoodType;
                descriptionOfFunctionForCurrentStateDepotByGoodType = "6. Вывести информацию по категориям";
                System.out.println(descriptionOfFunctionForCurrentStateDepot);
                System.out.println(descriptionOfFunctionForCurrentStateDepotByGoodType);
                System.out.println(contourOfFunctionMenuTitle);
                System.out.print(descriptionOfPointForFunctionChoice);
                String choiceOfSubFirstCommand;
                choiceOfSubFirstCommand = depotFile.readLine();
                if (choiceOfSubFirstCommand.equalsIgnoreCase("5")) {
                    printingOfAllDepotGoodsCurrentState();
                } else if (choiceOfSubFirstCommand.equalsIgnoreCase("6")) {
                    printingOfDepotCurrentStateForSomeTypeGood();
                } else {
                    System.out.println(descriptionOfIncorrectlySelectedFunctionMessage);
                }
            } else if (inputOfCommand.equals("2")) {
                addNewGoodToDepot();
            } else if (inputOfCommand.equals("3")) {
                //writingImportExportNote();
                System.out.println(descriptionOfMenuTitleEssence);
                String descriptionOfWritingImportOrderFunction;
                descriptionOfWritingImportOrderFunction = "7. Оформить накладную на приход товара на склад";
                String descriptionOfInputExportOrderFunction;
                descriptionOfInputExportOrderFunction = "8. Оформить накладную на вывоз товара со склада";
                System.out.println(descriptionOfWritingImportOrderFunction);
                System.out.println(descriptionOfInputExportOrderFunction);
                System.out.println(contourOfFunctionMenuTitle);
                System.out.print(descriptionOfPointForFunctionChoice);

                String subInputOfWritingImportExportNoteCommand;
                subInputOfWritingImportExportNoteCommand = depotFile.readLine();
                if (subInputOfWritingImportExportNoteCommand.equalsIgnoreCase("7")) {
                    String inputOfCommandForImportGoodNumb;
                    System.out.print(descriptionOfOrderNumberQuestion);
                    inputOfCommandForImportGoodNumb = depotFile.readLine();
                    long numberOfOrder = Long.parseLong(inputOfCommandForImportGoodNumb);
                    System.out.print(descriptionOfOrderDateQuestion);
                    String dateOfOrder = depotFile.readLine();
                    System.out.print(descriptionOfOrderMonthQuestion);
                    String monthOfOrder = depotFile.readLine();
                    System.out.print(descriptionOfOrderYearQuestion);
                    String yearOfOrder = depotFile.readLine();
                    String calendarPointOfOrder;
                    calendarPointOfOrder = (dateOfOrder + "." + monthOfOrder + "." + yearOfOrder).trim().replace(" ", "");

                    String positionOfStorekeeper;
                    positionOfStorekeeper = "заведующий складом";
                    String descriptionOfNameStorekeeperQuestion;
                    descriptionOfNameStorekeeperQuestion = "Введите представителя фамилию и инициалы представителя склада: ";
                    System.out.print(descriptionOfNameStorekeeperQuestion);
                    String nameOfStorekeeper = depotFile.readLine();
                    storekeepers.add(new Storekeeper(nameOfStorekeeper,positionOfStorekeeper,nameOfDepot));

                    String loginOfStorekeeper;
                    loginOfStorekeeper = storekeepers.toString();

                    String descriptionOfDeliveryCompanyQuestion;
                    descriptionOfDeliveryCompanyQuestion = "Введите наименования организации-поставщика: ";
                    System.out.print(descriptionOfDeliveryCompanyQuestion);
                    String nameOfDeliveryCompany = depotFile.readLine();

                    String descriptionOfNameDeliverymanQuestion;
                    descriptionOfNameDeliverymanQuestion = "Введите представителя фамилию и инициалы представителя поставщика: ";
                    System.out.print(descriptionOfNameDeliverymanQuestion);
                    String nameOfDeliveryman = depotFile.readLine();

                    String descriptionOfPostDeliverymanQuestion;
                    descriptionOfPostDeliverymanQuestion = "Введите должность представителя поставщика: ";
                    System.out.print(descriptionOfPostDeliverymanQuestion);
                    String positionOfDeliveryman = depotFile.readLine();

                    deliverymen.add(new Deliveryman(nameOfDeliveryman, positionOfDeliveryman, nameOfDeliveryCompany));

                    String loginOfDeliveryman;
                    loginOfDeliveryman = deliverymen.toString();

                    System.out.print(descriptionOfGoodNameQuestion);
                    String goods = depotFile.readLine();
                    //проверка наличия товара
                    //String descriptionOfMessageAboutGoodAbsenceOnDepot = "Товар в базе склада отсутствует, необходимо внести в базу";
                    System.out.print(descriptionOfGoodViewQuestion);
                    String viewOfGoodToDepotByString = depotFile.readLine();
                    double viewOfGoodToDepotByDouble = Double.parseDouble(viewOfGoodToDepotByString);
                    double tabOfNumber = -1;
                    double viewOfGood = tabOfNumber * Double.parseDouble(String.format("%.3f",viewOfGoodToDepotByDouble));

                    System.out.print(descriptionOfMessageForSave);
                    String inputCommandSaveNewImport;
                    inputCommandSaveNewImport = depotFile.readLine();
                    if (inputCommandSaveNewImport.equalsIgnoreCase("y") || inputCommandSaveNewImport.equalsIgnoreCase("н")) {
                            System.out.println(descriptionOfSavingMessage);
                            importOrders.add(new ImportOrder(numberOfOrder, calendarPointOfOrder, loginOfStorekeeper, loginOfDeliveryman, goods, viewOfGood));
                            //savingToDepotFile();
                        } else {
                            System.out.println(descriptionOfDoNotSavingMessage);
                        }
                } else if (subInputOfWritingImportExportNoteCommand.equalsIgnoreCase("8")) {
                    System.out.print(descriptionOfOrderNumberQuestion);
                    long numberOfOrder = Long.parseLong(inputOfCommand);
                    System.out.print(descriptionOfOrderDateQuestion);
                    String dateOfOrder = depotFile.readLine();
                    System.out.print(descriptionOfOrderMonthQuestion);
                    String monthOfOrder = depotFile.readLine();
                    System.out.print(descriptionOfOrderYearQuestion);
                    String yearOfOrder = depotFile.readLine();
                    String calendarPointOfOrder;
                    calendarPointOfOrder = (dateOfOrder + "." + monthOfOrder + "." + yearOfOrder).trim().replace(" ", "");

                    String positionOfStorekeeper;
                    positionOfStorekeeper = "заведующий складом";
                    String descriptionOfNameStorekeeperQuestion;
                    descriptionOfNameStorekeeperQuestion = "Введите представителя фамилию и инициалы представителя склада: ";
                    System.out.print(descriptionOfNameStorekeeperQuestion);
                    String nameOfStorekeeper = depotFile.readLine();
                    storekeepers.add(new Storekeeper(nameOfStorekeeper,positionOfStorekeeper,nameOfDepot));

                    String loginOfStorekeeper;
                    loginOfStorekeeper = storekeepers.toString();

                    String descriptionOfDeliveryCompanyQuestion;
                    descriptionOfDeliveryCompanyQuestion = "Введите наименования организации-поставщика: ";
                    System.out.print(descriptionOfDeliveryCompanyQuestion);
                    String nameOfDeliveryCompany = depotFile.readLine();

                    String descriptionOfNameDeliverymanQuestion;
                    descriptionOfNameDeliverymanQuestion = "Введите представителя фамилию и инициалы представителя поставщика: ";
                    System.out.print(descriptionOfNameDeliverymanQuestion);
                    String nameOfDeliveryman = depotFile.readLine();

                    String descriptionOfPostDeliverymanQuestion;
                    descriptionOfPostDeliverymanQuestion = "Введите должность представителя поставщика: ";
                    System.out.print(descriptionOfPostDeliverymanQuestion);
                    String positionOfDeliveryman = depotFile.readLine();
                    deliverymen.add(new Deliveryman(nameOfDeliveryman, positionOfDeliveryman, nameOfDeliveryCompany));

                    String loginOfDeliveryman;
                    loginOfDeliveryman = deliverymen.toString();

                    System.out.print(descriptionOfGoodNameQuestion);
                    String goods = depotFile.readLine();
                    System.out.print(descriptionOfGoodViewQuestion);
                    String viewOfGoodToDepotByString = depotFile.readLine();
                    double viewOfGoodToDepotByDouble = Double.parseDouble(viewOfGoodToDepotByString);
                    double viewOfGood = Double.parseDouble(String.format("%.3f",viewOfGoodToDepotByDouble));

                    System.out.print(descriptionOfMessageForSave);
                    String inputCommandSaveNewExport;
                    inputCommandSaveNewExport = depotFile.readLine();
                    if (inputCommandSaveNewExport.equalsIgnoreCase("y") || inputCommandSaveNewExport.equalsIgnoreCase("н")) {
                        System.out.println(descriptionOfSavingMessage);
                        exportOrders.add(new ExportOrder(numberOfOrder, calendarPointOfOrder, loginOfStorekeeper, loginOfDeliveryman, goods, viewOfGood));
                    } else {
                        System.out.println(descriptionOfDoNotSavingMessage);
                    }
                } else {
                    System.out.println(descriptionOfIncorrectlySelectedFunctionMessage);
                }
            } else if (inputOfCommand.equals("4")) {
                String descriptionOfOutputAllOrderFunction;
                descriptionOfOutputAllOrderFunction = "9. Вывести журнал движения товара (весь)";
                String descriptionOfOutputDateOrderFunction;
                descriptionOfOutputDateOrderFunction = "10. Вывести журнал движения товара (за месяц)";
                String descriptionOfOutputMonthOrderFunction;
                descriptionOfOutputMonthOrderFunction = "11. Вывести журнал движения товара (на дату)";
                System.out.println(descriptionOfMenuTitleEssence);
                System.out.println(descriptionOfOutputAllOrderFunction);
                System.out.println(descriptionOfOutputDateOrderFunction);
                System.out.println(descriptionOfOutputMonthOrderFunction);
                System.out.println(contourOfFunctionMenuTitle);
                System.out.print(descriptionOfPointForFunctionChoice);

                String choiceOfSubFourthCommand;
                choiceOfSubFourthCommand = depotFile.readLine();
                if (choiceOfSubFourthCommand.equalsIgnoreCase("9")) {
                    printingOfAllDepotNotes();
                } else if (choiceOfSubFourthCommand.equalsIgnoreCase("10")) {
                    System.out.println("Здесь вывести журнал движения товара (за месяц)");
                    printingOfMonthDepotNotes();
                } else if (choiceOfSubFourthCommand.equalsIgnoreCase("11")) {
                    System.out.println("Здесь вывести журнал движения товара (на дату)");
                    printingOfDateDepotNotes();
                } else {
                    System.out.println(descriptionOfIncorrectlySelectedFunctionMessage);
                }
            } else {
                System.out.println(descriptionOfIncorrectlySelectedFunctionMessage);
            }
            functionMenuTitle();
            inputOfCommand = depotFile.readLine();
        }
    }

    //Default: Method for output of the program's menu
    //=========================================================================================

    private static final String nameOfDepot = "FlexDepot ltd.";
    private static final String descriptionOfMenuTitleEssence = "Выберети из предложенных функцию: ";
    private static final String descriptionOfPointForFunctionChoice = "Введите номер выбранной функции: ";
    private static final String contourOfFunctionMenuTitle = "===================================";
    private static final String descriptionOfIncorrectlySelectedFunctionMessage = "Неверно заданная функция";

    private static void functionMenuTitle() {

        String descriptionOfCommandForDepotStatusPrint = "1. вывести товары, содержащиеся на складе;";
        String descriptionOfCommandForAddNewGood = "2. добавить новое наименование товара, хранящееся на складе;";
        String descriptionOfCommandForImportGoodToDepot = "3. оформить накладную на приход/расход товара на склад;";
        String descriptionOfCommandForExportGoodToDepot = "4. вывести журнал прихода/расхода товаров на склад;";
        String descriptionOfCommandForExitFromApplication = "exit - выход из программы;";

        System.out.println(contourOfFunctionMenuTitle);
        System.out.println(descriptionOfMenuTitleEssence);
        System.out.println(descriptionOfCommandForDepotStatusPrint);
        System.out.println(descriptionOfCommandForAddNewGood);
        System.out.println(descriptionOfCommandForImportGoodToDepot);
        System.out.println(descriptionOfCommandForExportGoodToDepot);
        System.out.println(descriptionOfCommandForExitFromApplication);
        System.out.println(contourOfFunctionMenuTitle);
        System.out.print(descriptionOfPointForFunctionChoice);
    }

    //1. Methods for print of the Depot state
    //=========================================================================================
    private static void printingOfDepotCurrentStateForSomeTypeGood() throws IOException {
        System.out.print(descriptionOfGoodTypeQuestion);

        BufferedReader depotFile = new BufferedReader(new InputStreamReader(System.in));
        String choiceGoodTypeForCurrentDepotStateQuestion;
        choiceGoodTypeForCurrentDepotStateQuestion = depotFile.readLine();
        String seeTypeOfGood;
        seeTypeOfGood = TypeOfGood.writtingOfTypeOfGood(choiceGoodTypeForCurrentDepotStateQuestion);
        double minCurrentView = 0;
        System.out.println(currentGoodState.stream().filter((p) -> p.equals(seeTypeOfGood)
                && p.getViewOfGood() > minCurrentView).collect(Collectors.toList()));
    }

    static List <Good> currentGoodState = new ArrayList<>();
    private static Good writingOfCurrentGoodState  (long idOfGood, String nameOfGood, String typeOfGood,
    String scaleOfGood, double viewOfExportGood, double viewOfAllImportGood) {

        double viewOfGood = viewOfExportGood + viewOfAllImportGood;
        currentGoodState.add(new Good(idOfGood, nameOfGood, typeOfGood, scaleOfGood, viewOfGood));
        return (Good) currentGoodState;
    }

    private static void printingOfAllDepotGoodsCurrentState() {
        String messageAboutDepotGoodsCurrentStateOutput;
        messageAboutDepotGoodsCurrentStateOutput = "Текущее состояние склада по именованиям товара: ";
        System.out.println(messageAboutDepotGoodsCurrentStateOutput);

        for (Map.Entry<String, String> k : printAllGoodCurrentState.entrySet()) {
            System.out.println(k.getValue() + " " + System.lineSeparator());
        }
    }

    private static HashMap <String, String> printAllGoodCurrentState = new HashMap <> ();
    private static void writingAllGoodCurrentState (long idOfGood, String nameOfGood, String typeOfGood,
                                                               String scaleOfGood, double viewOfExportGood, double viewOfAllImportGood) {
        String key = String.valueOf(idOfGood);
        String viewForCurrentTotal;
        double viewOfExportGoodToPut = getViewOfAllExportGood(String.valueOf(viewOfExportGood));
        double viewOfImportGoodToPut = getViewOfAllImportGood(String.valueOf(viewOfAllImportGood));
        viewForCurrentTotal = String.valueOf(viewOfExportGoodToPut + viewOfImportGoodToPut);
        String nameOfTypeOfGood = TypeOfGood.writtingOfTypeOfGood(typeOfGood);
        String value = nameOfGood + " " + nameOfTypeOfGood + ", ед. изм. - " + scaleOfGood + ", в кол.: " + viewForCurrentTotal;
        printAllGoodCurrentState.put(key, value);
    }

    private static double getViewOfAllExportGood (String nameOfGood) {
        double viewOfExportGood = 0;
        for (ExportOrder exportOrder : exportOrders)
            if (exportOrder.getGoods().equalsIgnoreCase(nameOfGood)) {
                viewOfExportGood += exportOrder.getGoods().length();
            }
        return viewOfExportGood;
    }

    private static double getViewOfAllImportGood (String nameOfGood) {
        double viewOfAllImportGood = 0;
        for (ImportOrder importOrder : importOrders)
            if (importOrder.getGoods().equalsIgnoreCase(nameOfGood)) {
                viewOfAllImportGood += importOrder.getGoods().length();
            }
        return viewOfAllImportGood;
    }

    //2. Method of creating for a new good on the depot
    //=========================================================================================
    private static final String descriptionOfGoodNameQuestion = "Введите наименование товара: ";
    private static final String descriptionOfGoodIDQuestion = "Введите инвентарный номер товара: ";
    private static final String descriptionOfGoodTypeQuestion = "Введите наименование категории товара: ";
    private static final String descriptionOfGoodScaleQuestion = "Введите единицу измерения товара: ";
    private static final String descriptionOfMessageForSave = "Сохранить введенные даные: [Y]=да или [N]=нет?: ";
    private static final String descriptionOfSavingMessage = "... Данные сохранены ...";
    private static final String descriptionOfDoNotSavingMessage = "... Данные удалены ...";

    //private static final String descriptionOfMessageAboutGoodAbsenceOnDepot = "Товар на складе отсутствует";
    private static void addNewGoodToDepot() throws IOException {
        //loadingFromDepotFile;
        //descriptionOfApplicationChoiceOfNewGoodType;
        //String inputOfCommand;
        BufferedReader depotFile = new BufferedReader(new InputStreamReader(System.in));
        //inputOfCommand = depotFile.readLine();
        System.out.println(descriptionOfGoodNameQuestion);
        String nameOfGood = depotFile.readLine();
        System.out.println(descriptionOfGoodTypeQuestion);
        String inputOfChosenNewGoodType = depotFile.readLine();
        String typeOfGood;
        typeOfGood = TypeOfGood.writtingOfTypeOfGood(inputOfChosenNewGoodType);
        System.out.println(descriptionOfGoodIDQuestion);
        String idGood = depotFile.readLine();
        long idOfGood = Long.parseLong(idGood);
        System.out.println(descriptionOfGoodScaleQuestion);
        String scaleOfGood = depotFile.readLine();
        String inputCommandSaveNewGood;
        System.out.print(descriptionOfMessageForSave);
        inputCommandSaveNewGood = depotFile.readLine();
        if (inputCommandSaveNewGood.equalsIgnoreCase("y") || inputCommandSaveNewGood.equalsIgnoreCase("н")) {
            System.out.println(descriptionOfSavingMessage);
            goods.add(new Good(idOfGood,nameOfGood,typeOfGood,scaleOfGood,0));
        } else {
            System.out.println(descriptionOfDoNotSavingMessage);
        }
    }

    //3. Method of writing for a porting good on the depot
    //=========================================================================================

    private static final String descriptionOfOrderNumberQuestion = "Введите номер накладной: ";
    private static final String descriptionOfOrderDateQuestion  = "Введите дату оформления накладной (день): ";
    private static final String descriptionOfOrderMonthQuestion  = "Введите дату оформления накладной (месяц): ";
    private static final String descriptionOfOrderYearQuestion = "Введите дату оформления накладной (год): ";
    private static final String descriptionOfGoodViewQuestion = "Введите объём товара по накладной: ";

    //4. Method of printing for the depot porting notes
    //=========================================================================================

    private static final String descriptionOfDateInputQuestion = "Введите дату (день): ";
    private static final String descriptionOfMonthInputQuestion = "Введите месяц (числом): ";
    private static final String descriptionOfYearInputQuestion = "Введите год: ";
    private static final String typeOfMessageAboutImport = "Приход: ";
    private static final String typeOfMessageAboutExport = "Расход: ";
    private static final String descriptionOfMessageAboutDepotJournalType = "Журнал движения товара на складе за: ";
    private static void printingOfDateDepotNotes() throws IOException {
        BufferedReader depotFile = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(descriptionOfDateInputQuestion);
        String dateInputQuestion = depotFile.readLine();
        System.out.print(descriptionOfMonthInputQuestion);
        String monthInputQuestion = depotFile.readLine();
        System.out.print(descriptionOfYearInputQuestion);
        String yearInputQuestion = depotFile.readLine();
        String inputDateForPrint = (dateInputQuestion + "." + monthInputQuestion + "." + yearInputQuestion).trim().replace(" ","");
        System.out.println(descriptionOfMessageAboutDepotJournalType + inputDateForPrint);
        System.out.println(contourOfFunctionMenuTitle);

        List<Object> dateDepotNotes = new ArrayList<>();
        getDateDepotNotesForImport(inputDateForPrint);
        getDateDepotNotesForExport(inputDateForPrint);
        dateDepotNotes.add(typeOfMessageAboutImport + getDateDepotNotesForImport(inputDateForPrint));
        dateDepotNotes.add(typeOfMessageAboutExport + getDateDepotNotesForExport(inputDateForPrint));
        dateDepotNotes.stream().sorted().forEach(System.out ::println);
    }

    private static ExportOrder getDateDepotNotesForExport(String inputDateForPrint) {
        ExportOrder current = null;
        for (ExportOrder exportOrder : exportOrders) {
            if (exportOrder.getDateOfOrder().equals(inputDateForPrint)) {
                current = exportOrder;
                break;
            }
        }
        return current;
    }

    private static ImportOrder getDateDepotNotesForImport(String inputDateForPrint) {
        ImportOrder current = null;
        for (ImportOrder importOrder : importOrders) {
            if (importOrder.getDateOfOrder().equals(inputDateForPrint)) {
                current =  importOrder;
                break;
            }
        }
        return current;
    }

    private static void printingOfMonthDepotNotes() throws IOException {
        BufferedReader depotFile = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(descriptionOfMonthInputQuestion);
        String monthInputQuestion = depotFile.readLine();
        System.out.print(descriptionOfYearInputQuestion);
        String yearInputQuestion = depotFile.readLine();
        String inputMonthForPrint = (monthInputQuestion + "." + yearInputQuestion).trim().replace(" ","");
        System.out.println(descriptionOfMessageAboutDepotJournalType + inputMonthForPrint);
        System.out.println(contourOfFunctionMenuTitle);

        List<Object> monthDepotNotes = new ArrayList<>();
        getMonthDepotNotesForImport(inputMonthForPrint);
        getMonthDepotNotesForExport(inputMonthForPrint);
        monthDepotNotes.add(typeOfMessageAboutImport + getMonthDepotNotesForImport(inputMonthForPrint));
        monthDepotNotes.add(typeOfMessageAboutExport + getMonthDepotNotesForExport(inputMonthForPrint));
        monthDepotNotes.stream().sorted().forEach(System.out :: println);
    }

    private static ExportOrder getMonthDepotNotesForExport(String inputMonthForPrint) {
        ExportOrder current = null;
        for (ExportOrder exportOrder : exportOrders) {
            int i;
            for (i = 1; i <= 31; i++) {
                String runMonth;
                runMonth = i + "." + inputMonthForPrint;
                if (exportOrder.getDateOfOrder().equals(runMonth)) {
                    current = exportOrder;
                    break;
                }
            }
        }
        return current;
    }

    private static ImportOrder getMonthDepotNotesForImport(String inputMonthForPrint) {
        ImportOrder current = null;
        for (ImportOrder importOrder : importOrders) {
            int i;
            for (i = 1; i <= 31; i++) {
                String runMonth;
                runMonth = i + "." + inputMonthForPrint;
                if (importOrder.getDateOfOrder().equals(runMonth)) {
                    current = importOrder;
                    break;
                }
            }
        }
        return current;
    }

    private static void printingOfAllDepotNotes() {
        String messageAboutAllPeriodForPrint;
        messageAboutAllPeriodForPrint = "весь период";
        System.out.println(descriptionOfMessageAboutDepotJournalType + messageAboutAllPeriodForPrint);
        System.out.println(contourOfFunctionMenuTitle);

        List<Object> allDepotNotes = new ArrayList<>();
        allDepotNotes.add(typeOfMessageAboutImport + getAllDepotNotesForImport());
        allDepotNotes.add(typeOfMessageAboutExport + getAllDepotNotesForExport());
        allDepotNotes.stream().sorted().forEach(System.out ::println);
    }

    private static ExportOrder getAllDepotNotesForExport() {
        ExportOrder current = null;
        for (ExportOrder exportOrder : exportOrders) {
            current = exportOrder;
            break;
        }
        return current;
    }

    private static ImportOrder getAllDepotNotesForImport() {
        ImportOrder current = null;
        for (ImportOrder importOrder : importOrders) {
            current = importOrder;
            break;
        }
        return current;
    }

}
