import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class RateMethod {
    private String uId;
    private String fId;
    private int ratePoint;
    ArrayList<String> usRaList = new ArrayList<>();
    HashMap<String, User> allPeopleMap = new HashMap<>();
    HashMap<String, Films> allFilmMap = new HashMap<>();

    RateMethod(String uId, String fId, int ratePoint, HashMap allPeoplemap, HashMap allFilmMap){
        this.uId = uId;
        this.fId = fId;
        this.ratePoint = ratePoint;
        this.allFilmMap = allFilmMap;
        this.allPeopleMap = allPeoplemap;
    }
    int rater(HashMap<String, Films> allFilms, HashMap<String, User> allUsers){
        if(allFilms.containsKey(fId) && allUsers.containsKey(uId)){
            if (allUsers.get(uId).ratings.containsKey(fId)){
                System.out.println("Film already rated!");
            }
            else{

                allUsers.get(uId).ratings.put(fId, ratePoint);
                System.out.println("Film rated successfully");
                System.out.println("Film type: " + allFilms.get(fId).getType());
                System.out.println("Film title: " + allFilms.get(fId).getTitle());

                if (!Films.filmRatings.containsKey(fId)) {
                    Films.filmRatings.put(fId, new HashMap<>());
                }
                Films.filmRatings.get(fId).put(uId, ratePoint);

                if (!User.ratingsByUser.containsKey(uId)){
                    User.ratingsByUser.put(uId, new HashMap<>());
                }
                User.ratingsByUser.get(uId).put(fId, ratePoint);

            }
        }
        return 0;
    }
}
