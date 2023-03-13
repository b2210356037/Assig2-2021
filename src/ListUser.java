import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class ListUser {
    private String uId;
    ArrayList<String> usRaList = new ArrayList<>();
    HashMap<String, User> allPeopleMap = new HashMap<>();
    HashMap<String, Films> allFilmMap = new HashMap<>();

    ListUser(String uId, HashMap allPeoplemap, HashMap allFilmMap){
        this.uId = uId;
        this.allFilmMap = allFilmMap;
        this.allPeopleMap = allPeoplemap;
    }
    void Seer(HashMap<String, Films> allFilms, HashMap<String, User> allUsers){
        if (!User.ratingsByUser.containsKey(uId)){
            System.out.println("There is no such user: " + uId);
        }
        else {

            for (String i : User.ratingsByUser.get(uId).keySet()){
                System.out.println(allFilms.get(i).getTitle() + ": " + User.ratingsByUser.get(uId).get(i));
            }

            }
        }
    }


