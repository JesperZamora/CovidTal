import java.util.ArrayList;


public class Controller {
    private FileHandler fileHandler;

    public Controller() {
        fileHandler = new FileHandler();
    }

    public void loadFile() {
        fileHandler.loadFile();
    }

    public ArrayList<CovidData> getCovidData() {
        return fileHandler.getCovidData();
    }

    public void sortByRegion() {
        fileHandler.sortByRegion();
    }

    public void sortByAgeGroup() {
      fileHandler.sortByAgeGroup();
    }

    public void saveToFile() {
        fileHandler.saveToFile();
    }

    public void addCovidInfo(String region, String aldersgruppe, int bekræftetTilfælde, int døde,
                                                int indlagteIntensiv, int indlagte, String dato) {

        fileHandler.addCovidInfo(region, aldersgruppe, bekræftetTilfælde, døde,
                                                indlagteIntensiv, indlagte, dato);
    }
}
