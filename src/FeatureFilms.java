public class FeatureFilms extends Films{
     int id;
     String title;
     String language;
     String runTime;
     String country;
    String[] directors;
    String[] cast;
     String date;
     String budget;
    String[] writers;
    String[] genre;

    FeatureFilms(String id, String title, String language, String runTime, String country , String[] directors, String[] cast, String date, String budget, String[] writers, String[] genre){
        super(id, title, language, runTime, country, directors, cast);
        super.tarih = date;
        super.type = "Feature Film";
        this.date = date;
        this.budget = budget;
        this.writers = writers;
        this.genre = genre;

    }

}
