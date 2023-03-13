import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
public class Main {
    public static void main(String[] args) throws IOException {
        String people = args[0];
        String films = args[1];
        String commands = args[2];
        String output = args[3];

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

        FileReader read_people = new FileReader(people);
        BufferedReader reader_people = new BufferedReader(read_people);

        String line = reader_people.readLine();
        String[] news;

        while (line != null) {
            news = line.split("\t");
            if (news[0].equals("Actor:")) {
                Actor actor = new Actor(news[2], news[3], news[4], news[1], news[5]);
                actorHashMap.put(news[1], actor);
                allPeopleHashMap.put(news[1], actor);
            } else if (news[0].equals("ChildActor:")) {
                ChildActor childActor = new ChildActor(news[2], news[3], news[4], news[1], news[5]);
                childActorHashMap.put(news[1], childActor);
                allPeopleHashMap.put(news[1], childActor);
            } else if (news[0].equals("Director:")) {
                Director director = new Director(news[2], news[3], news[4], news[1], news[5]);
                directorHashMap.put(news[1], director);
                allPeopleHashMap.put(news[1], director);
            } else if (news[0].equals("Writer:")) {
                Writer writer = new Writer(news[2], news[3], news[4], news[1], news[5]);
                writerHashMap.put(news[1], writer);
                allPeopleHashMap.put(news[1], writer);
            } else if (news[0].equals("StuntPerformer:")) {
                String[] _actor_ = news[6].split(",");

                StuntPerformer stuntPerformer = new StuntPerformer(news[2], news[3], news[4], news[1], news[5], _actor_);
                stringStuntPerformerHashMap.put(news[1], stuntPerformer);
                allPeopleHashMap.put(news[1], stuntPerformer);
            } else {
                User user = new User(news[2], news[3], news[4], news[1]);
                userHashMap.put(news[1], user);
                allPeopleHashMap.put(news[1], user);
            }
            line = reader_people.readLine();
        }
        reader_people.close();
        read_people.close();

        FileReader read_films = new FileReader(films);
        BufferedReader reader_films = new BufferedReader(read_films);

        line = reader_films.readLine();

        while (line != null) {
            news = line.split("\t");

            String[] directorsId = news[4].split(",");
            String[] castId = news[7].split(",");

            if (news[0].equals("FeatureFilm:")) {
                String[] genres = news[8].split(",");
                String[] writers = news[10].split(",");

                FeatureFilms featureFilms = new FeatureFilms(news[1], news[2], news[3], news[5], news[6], directorsId, castId, news[9], news[11], writers, genres);
                featureFilmsHashMap.put(news[1], featureFilms);
                allFilmsHashMap.put(news[1], featureFilms);

            } else if (news[0].equals("ShortFilm:")) {
                if (Integer.parseInt(news[5]) <= 40) {
                    String[] genres = news[8].split(",");
                    String[] writers_id = news[10].split(",");

                    ShortFilm short_film = new ShortFilm(news[1], news[2], news[3], news[5], news[6], directorsId, castId, news[9], writers_id, genres);
                    shortFilmHashMap.put(news[1], short_film);
                    allFilmsHashMap.put(news[1], short_film);
                } else {
                    // If the length of short film is bigger than 40 minutes, the block will throw an exception.
                    try {
                        throw new Exception("The length of short film mustn't be bigger than 40 minutes.");
                    } catch (Exception e) {
                        System.out.println();
                    }
                }
            }
            else if (news[0].equals("Documentary:")) {
                Documentary documentary = new Documentary(news[1], news[2], news[3], news[5], news[6], directorsId, castId, news[8]);
                documentaryHashMap.put(news[1], documentary);
                allFilmsHashMap.put(news[1], documentary);
            }
            else if (news[0].equals("TVSeries:")) {
                String[] genres = news[8].split(",");
                String[] writers_id = news[9].split(",");

                TVseries tvseries = new TVseries(news[1], news[2], news[3], news[5], news[6], directorsId, castId, news[10], news[11], news[12], news[13], genres, writers_id);
                tvseriesHashMap.put(news[1], tvseries);
                allFilmsHashMap.put(news[1], tvseries);
            }
            line = reader_films.readLine();
        }
        /*FileWriter write_output = new FileWriter(output, false);
        BufferedWriter output_file = new BufferedWriter(write_output);
        output_file.append("\n");
        output_file.close();
        write_output.close();
*/
        CommandReader command_reader = new CommandReader(commands, output, allPeopleHashMap, actorHashMap, childActorHashMap, directorHashMap,
                stringStuntPerformerHashMap, userHashMap, writerHashMap, allFilmsHashMap, featureFilmsHashMap, shortFilmHashMap,
                tvseriesHashMap, documentaryHashMap);

        command_reader.reader_method();
    }
}