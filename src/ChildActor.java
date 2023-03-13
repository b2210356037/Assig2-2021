public class ChildActor extends Performer{
    private String age;

    ChildActor(String name, String surname, String country, String id, String age){
        super(name, surname, country, id);
        this.age = age;
    }
}
