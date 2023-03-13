import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.SplittableRandom;

public class User extends Person{
    static HashMap<String, HashMap<String, Integer>> ratingsByUser = new HashMap<>();
    HashMap<String, Integer> ratings = new HashMap<>();
    User(String name, String surname, String country, String id){
        super(name, surname, country, id);
    }

}
