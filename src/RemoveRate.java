import java.util.HashMap;

public class RemoveRate {
    private String uId;
    private String fId;
    HashMap<String, User> allPeopleMap = new HashMap<>();
    HashMap<String, Films> allFilmMap = new HashMap<>();

    RemoveRate(String uId, String fId, HashMap allPeopleMap, HashMap allFilmMap){
        this.fId = fId;
        this.uId = uId;
        this.allFilmMap = allFilmMap;
        this.allPeopleMap = allPeopleMap;
    }
    void RateRemover(String uId, String fId, HashMap allPeopleMap, HashMap allFilmMap){
        if (!User.ratingsByUser.get(uId).containsKey(fId)){
            System.out.println("The user: " + uId + " have not rated the film: " + fId);
        }
        else {
            User.ratingsByUser.get(uId).remove(fId);
            System.out.println("The film: " + fId + " has been deleted from " + uId);

        }
    }
}
