public class Person {
    private String name;
    private String surname;
    private String country;
    private String id;

    Person(String name, String surname, String country, String id){
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.country = country;
    }

    String getNameSurname(){
        return this.name +" "+this.surname;
    }
    String getId(){
        return this.id;
    }
}
