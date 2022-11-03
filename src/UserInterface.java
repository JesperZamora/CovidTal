import java.util.Scanner;

public class UserInterface {
    private Scanner sc;
    private Controller controller;


    public UserInterface() {
        sc = new Scanner(System.in);
        controller = new Controller();
    }

    private void printMenu() {
        System.out.println("""
            Menu:
            1. Show list
            2. Load list
            3. Save file
            4. Sort by region
            5. Sort by age group
            6. Add new covid info
            9. Exit""");
    }

    public void startProgram(){
        boolean isRunning = true;
        while(isRunning) {
            printMenu();
            switch (readInteger()) {
                case 1 -> showList();
                case 2 -> loadList();
                case 3 -> saveToFile();
                case 4 -> sortByRegion();
                case 5 -> sortAgeGroup();
                case 6 -> addInformation();
                case 9 -> isRunning = false;
                default -> System.out.println("Invalid number!\n");
            }
        }
    }

    public void showList() {
        if (controller.getCovidData().isEmpty()) {
            System.out.println("No list found. Load the list first\n");
        } else {
            for(CovidData data : controller.getCovidData()) {
                System.out.println(data);
            }
            System.out.println();
        }
    }

    public void loadList() {
        System.out.println("Loading database...");
        controller.loadFile();
        System.out.println("Loading done!\n");
    }

    public void saveToFile() {
        if(controller.getCovidData().isEmpty()) {
            System.out.println("You need to load data first!\n");
        } else {
            System.out.println("""
                You are about to save your data. Do you wish to continue?
                Yes = 1 / no = 2""");

            int answer = readInteger();
            if(answer == 1) {
                System.out.println("Saving file...");
                controller.saveToFile();
                System.out.println("File saved!\n");
            } else {
                System.out.println("File not saved!\n");
            }
        }
    }

    public void sortByRegion() {
        controller.sortByRegion();
        System.out.println("List has been sorted by region. See 'Show list'.\n");
    }

    public void sortAgeGroup() {
        controller.sortByAgeGroup();
        System.out.println("List has been sorted by age group. See 'Show list'.\n");
    }

    public int readInteger() {
        while(!sc.hasNextInt()) {
            System.out.println("This is not a number!");
            sc.next();
        }
        return sc.nextInt();
    }

    public String readString() { // for at undgå scannerbug
        String input = sc.next();
        sc.nextLine();
        return input;
    }

    public void addInformation() {
        System.out.println("Add new Covid-19 information:");
        System.out.print("Region: ");
        String region = readString();

        System.out.print("Aldersgruppe: ");
        String ageG = readString();

        System.out.print("Bekræftet tilfælde: ");
        int confirmedIncident = readInteger();

        System.out.print("Døde: ");
        int deaths = readInteger();

        System.out.print("Indlagte intensiv: ");
        int intensiveCare = readInteger();

        System.out.print("Indlagte: ");
        int hospitalized = readInteger();

        System.out.print("Dato: ");
        String date = readString();

        controller.addCovidInfo(region, ageG, confirmedIncident, deaths, intensiveCare, hospitalized, date);
        System.out.println("New data added!");
        System.out.println();
    }
}

/*    public int getIntegerFromUser() {
        int input = sc.nextInt();
        sc.nextLine();
        return input;
    }*/