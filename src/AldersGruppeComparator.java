import java.util.Comparator;

public class AldersGruppeComparator implements Comparator<CovidData> {

    @Override
    public int compare(CovidData o1, CovidData o2) {
        return o1.getAldersgruppe().compareTo(o2.getAldersgruppe());
    }


}
