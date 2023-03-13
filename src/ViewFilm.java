import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

public class ViewFilm {

     String fId;
    HashMap<String, Documentary> documentaryHashMap;
    HashMap<String , ShortFilm> shortFilmHashMap;
    HashMap<String, FeatureFilms> featureFilmsHashMap;
    HashMap<String, TVseries> tVseriesHashMap;
    HashMap<Integer, RateMethod> ratingsMap;
    HashMap<String, Writer> writerHashMap;

    ViewFilm(String fId, HashMap featureFilmsHashMap, HashMap documentaryHashMap, HashMap shortFilmHashMap, HashMap tVseriesHashMap, HashMap ratingsMap, HashMap writerHashMap ){
        this.fId = fId;
        this.featureFilmsHashMap = featureFilmsHashMap;
        this.documentaryHashMap = documentaryHashMap;
        this.shortFilmHashMap = shortFilmHashMap;
        this.tVseriesHashMap = tVseriesHashMap;
        this.ratingsMap = ratingsMap;
        this.writerHashMap = writerHashMap;
    }

    void filmViewer(String fId,HashMap<String, FeatureFilms> featureFilmsHashMap, HashMap documentaryHashMap, HashMap shortFilmHashMap, HashMap tVseriesHashMap, HashMap ratingsMap   ){
        if(featureFilmsHashMap.containsKey(fId)){
            System.out.println("VIEWFILM       " + fId);
            ArrayList<String> writers = new ArrayList<>();
            ArrayList<String> genres = new ArrayList<>();
            for(String i : featureFilmsHashMap.get(fId).writers){
                //System.out.println(writerHashMap.get(i).getNameSurname());
                writers.add(writerHashMap.get(i).getNameSurname());
            }
            for (String i : featureFilmsHashMap.get(fId).genre){
                genres.add(i);
            }

            System.out.println(featureFilmsHashMap.get(fId).getTitle() +" (" + featureFilmsHashMap.get(fId).tarih + ") ");
            System.out.print("Genres: ");
            for (String i : genres){
                System.out.println(i + ",");
            }
            System.out.println("title: " + featureFilmsHashMap.get(fId).getTitle());
            System.out.print("Writers: ");
            for(String i : featureFilmsHashMap.get(fId).writers){
                System.out.print(writerHashMap.get(i).getNameSurname() + ", ");
            }
            System.out.println("\nasdafafs");
        }
    }
}
