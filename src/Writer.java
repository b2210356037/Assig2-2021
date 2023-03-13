public class Writer extends Artist{
    private String style;

    Writer(String name, String surname, String country, String id, String style) {
        super(name, surname, country, id);
        this.style = style;
    }
}
