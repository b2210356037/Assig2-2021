import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
public class CommandReader {
    String commands;
    String output;
    HashMap<String, Person> allPeopleHashMap = new HashMap<>();
    HashMap<String, Artist> artistHashMap = new HashMap<>();
    HashMap<String, Performer> performerHashMap = new HashMap<>();
    HashMap<String, Actor> actorHashMap = new HashMap<>();
    HashMap<String, Director> directorHashMap = new HashMap<>();
    HashMap<String, StuntPerformer> stringStuntPerformerHashMap = new HashMap<>();
    HashMap<String, ChildActor> childActorHashMap = new HashMap<>();
    HashMap<String, Writer> writerHashMap = new HashMap<>();
    HashMap<String, User> userHashMap = new HashMap<>();

    HashMap<String, Films> allFilmsHashMap = new HashMap<>();
    HashMap<String, FeatureFilms> featureFilmsHashMap = new HashMap<>();
    HashMap<String, ShortFilm> shortFilmHashMap = new HashMap<>();
    HashMap<String, TVseries> tvseriesHashMap = new HashMap<>();
    HashMap<String, Documentary> documentaryHashMap = new HashMap<>();
    CommandReader(String commands,String output,HashMap allPeopleHashMap,HashMap actorHashMap,HashMap childActorHashMap,HashMap directorHashMap,
                  HashMap stringStuntPerformerHashMap,HashMap userHashMap,HashMap writerHashMap,HashMap allFilmsHashMap,HashMap featureFilmsHashMap,HashMap shortFilmHashMap,
                  HashMap tvseriesHashMap,HashMap documentaryHashMap){
        this.commands = commands;
        this.output = output;
        this.allPeopleHashMap = allPeopleHashMap;
        this.actorHashMap = actorHashMap;
        this.childActorHashMap = childActorHashMap;
        this.directorHashMap = directorHashMap;
        this.stringStuntPerformerHashMap = stringStuntPerformerHashMap;
        this.userHashMap = userHashMap;
        this.writerHashMap = writerHashMap;
        this.allFilmsHashMap = allFilmsHashMap;
        this.featureFilmsHashMap = featureFilmsHashMap;
        this.shortFilmHashMap = shortFilmHashMap;
        this.tvseriesHashMap = tvseriesHashMap;
        this.documentaryHashMap = documentaryHashMap;
    }
    HashMap<String, Integer> ratings = new HashMap<>();
    void reader_method() throws IOException {
        FileReader read_people = new FileReader(commands);
        BufferedReader reader_people = new BufferedReader(read_people);

        String line = reader_people.readLine();
        String[] news;

        while (line != null) {

            news = line.split("\\s+");

            if (news[0].equals("RATE")) {
                RateMethod rateMethod = new RateMethod(news[1], news[2], Integer.parseInt(news[3]), allFilmsHashMap, allPeopleHashMap);
                rateMethod.rater(allFilmsHashMap, userHashMap);

            } else if (news[0].equals("ADD")) {
                FeatureFilms featureFilms = new FeatureFilms(news[2],news[3],news[4], news[6], news[7], news[5].split(","), news[8].split(","),news[10], news[12], news[11].split(","), news[9].split(","));
                featureFilmsHashMap.put(news[2], featureFilms );

            } else if (news[0].equals("VIEWFILM")) {
                String fId = news[1];
                ViewFilm viewFilm = new ViewFilm(fId, featureFilmsHashMap, documentaryHashMap, shortFilmHashMap, tvseriesHashMap, ratings, writerHashMap);
                viewFilm.filmViewer(fId, featureFilmsHashMap, documentaryHashMap, shortFilmHashMap, tvseriesHashMap, ratings);

            }else if (news[0].equals("LIST") && news[1].equals("USER") ){
                String uid = news[2];
                ListUser listUser = new ListUser(uid, allPeopleHashMap, allFilmsHashMap);
                listUser.Seer(allFilmsHashMap, userHashMap );

            } else if (news[0].equals("REMOVE")) {
                String uid = news[2];
                String fid = news[3];
                RemoveRate removeRate = new RemoveRate(uid, fid, allPeopleHashMap, allFilmsHashMap);
                removeRate.RateRemover(uid,fid,allPeopleHashMap,allFilmsHashMap);
            } else if (news[0].equals("LIST") && news[1].equals("FILM")) {
                ListFilm listFilm = new ListFilm(tvseriesHashMap);
                listFilm.SeriesLister(tvseriesHashMap);

            } else if (news[0].equals("LIST") && news[1].equals("FILMS") && news[3].equals("COUNTRY")) {
                String cId = news[4];
                ListFilmByCountry listFilmByCountry = new ListFilmByCountry(allFilmsHashMap, cId);
                listFilmByCountry.LFBCmethod(allFilmsHashMap, cId);
            }

            line = reader_people.readLine();
    }

}
}
