import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private ArrayList<CovidData> covidData = new ArrayList<>();
    private File file = new File("src/data/11_noegletal_pr_region_pr_aldersgruppe1.csv");

    public void saveToFile() {
        try {
            PrintStream output = new PrintStream(file);
            for(CovidData cD : covidData) {
                output.println(cD.getRegion()+ ',' +
                        cD.getAldersgruppe()+ ',' +
                        cD.getBekræftetTilfælde()+ ',' +
                        cD.getDøde()+ ',' +
                        cD.getIndlagteIntensiv()+ ',' +
                        cD.getIndlagte()+ ',' +
                        cD.getDato());
            }
            output.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadFile() {
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNext()) {
                String line = sc.nextLine();
                String[] attributes = line.split(";");
                CovidData covid = new CovidData(
                        attributes[0],
                        attributes[1],
                        Integer.parseInt(attributes[2]),
                        Integer.parseInt(attributes[3]),
                        Integer.parseInt(attributes[4]),
                        Integer.parseInt(attributes[5]),
                        attributes[6]);

                covidData.add(covid);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<CovidData> getCovidData() {
        return covidData;
    }

    public void sortByRegion() {
        covidData.sort(new RegionComparator());
    }

    public void sortByAgeGroup() {
        covidData.sort(new AldersGruppeComparator());
    }
}
//private File file = new File("c:/Users/jespe/Documents/Java/11_noegletal_pr_region_pr_aldersgruppe11.csv");