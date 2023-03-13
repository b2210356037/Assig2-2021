public class Actor extends Performer{
    private String height;

    Actor(String name, String surname, String country, String id, String height) {
        super(name, surname, country, id);
        this.height = height;
    }
}
