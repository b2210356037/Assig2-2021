import java.util.ArrayList;
import java.util.HashMap;

public class Films {
    private String id;
     String title;
    private String language;
    private String runTime;
    private String country;
    String[] directors;
    String[] cast;
     String type;
     String tarih;

     static HashMap<String, HashMap<String, Integer> > filmRatings = new HashMap<>();
    Films(String id, String title, String language, String runTime, String country , String[] directors, String[] cast){
        this.id = id;
        this.title = title;
        this.language = language;
        this.runTime = runTime;
        this.country = country;
        this.directors = directors;
        this.cast = cast;
    }
    String getTitle(){
        return this.title;
    }
    String getDate(){ return this.tarih;}
    String getType(){ return this.type;}
    String getCountry(){return this.country;}
    String getRunTime(){return this.runTime;}
    String getLanguage(){return this.language;}
}
