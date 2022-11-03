public class CovidData implements Comparable<CovidData>{

    private String region;
    private String aldersgruppe;
    private int bekræftetTilfælde;
    private int døde;
    private int indlagteIntensiv;
    private int indlagte;
    private String dato;

    public CovidData(String region, String aldersgruppe, int bekræftetTilfælde, int døde,
                     int indlagteIntensiv, int indlagte, String dato) {
        this.region = region;
        this.aldersgruppe = aldersgruppe;
        this.bekræftetTilfælde = bekræftetTilfælde;
        this.døde = døde;
        this.indlagteIntensiv = indlagteIntensiv;
        this.indlagte = indlagte;
        this.dato = dato;
    }

    public String getRegion() {
        return region;
    }

    public String getAldersgruppe() {
        return aldersgruppe;
    }

    public int getBekræftetTilfælde() {
        return bekræftetTilfælde;
    }

    public int getDøde() {
        return døde;
    }

    public int getIndlagteIntensiv() {
        return indlagteIntensiv;
    }

    public int getIndlagte() {
        return indlagte;
    }

    public String getDato() {
        return dato;
    }

    @Override
    public String toString() {
        return String.format("""
                Region: %-15s Aldersgruppe: %-8s Bekræftet tilfælde: %-6d Døde: %-6d Indlagte intensiv: %-5d Indlagte: %-8s Dato: %-6s""",
                region, aldersgruppe, bekræftetTilfælde, døde, indlagteIntensiv, indlagte, dato );

    }

    @Override
    public int compareTo(CovidData o) {
        return this.region.compareTo(o.getRegion());
    }
}
