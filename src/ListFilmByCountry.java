import java.util.HashMap;

public class ListFilmByCountry {
    HashMap<String, Films> allFilmHashmap = new HashMap<>();
    private String cId;
    ListFilmByCountry(HashMap allFilmHashmap, String cId){
        this.allFilmHashmap = allFilmHashmap;
        this.cId = cId;
    }
    void LFBCmethod(HashMap allFilmHashmap, String cId){
        int c = 0;
        System.out.println("FILMS FROM: " + cId);
        for (Object i : allFilmHashmap.keySet()){
            Films films =(Films) allFilmHashmap.get(i);
            if (films.getCountry().equals(cId)){
                System.out.println("Title: " + films.title);
                System.out.println("Duration: " + films.getRunTime());
                System.out.println("Language: " + films.getLanguage());
                c = 1;
            }
        }
        if (c != 1){
            System.out.println("There is no film from: " + cId);
            c= 0;
        }

    }
}
