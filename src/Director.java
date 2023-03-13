public class Director extends Artist {

    private String agency;

    Director(String name, String surname, String country, String id, String agency){
        super(name, surname, country, id);
        this.agency = agency;
    }

}
