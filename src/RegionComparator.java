import java.util.Comparator;

public class RegionComparator implements Comparator<CovidData> {

    @Override
    public int compare(CovidData o1, CovidData o2) {
        return o1.getRegion().compareTo(o2.getRegion());
    }
}
