public class StuntPerformer extends Performer {
    private String height;
    String[] actors;

    StuntPerformer(String name, String surname, String country, String id, String height,String[] actors) {
        super(name, surname, country, id);
        this.height = height;
        this.actors = actors;
    }
}
