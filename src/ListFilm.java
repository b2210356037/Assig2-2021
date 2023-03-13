import java.util.HashMap;

public class ListFilm {
    HashMap<String, TVseries> tVseriesHashMap = new HashMap<>();
    ListFilm(HashMap tVseriesHashMap){
        this.tVseriesHashMap = tVseriesHashMap;
    }
    void SeriesLister(HashMap tVseriesHashMap){
        for (Object i : tVseriesHashMap.keySet()){
            TVseries tVseries =  (TVseries) tVseriesHashMap.get(i);
            System.out.println("TVSeries ");
            System.out.println("Title: " + tVseries.title);
            System.out.println("(" + tVseries.getStartDate() + "-" + tVseries.getEndDate() + ")");
            System.out.println(tVseries.episodes + " episodes, " + tVseries.seasons + " seasons\n");
        }
    }
}
