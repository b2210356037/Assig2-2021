public class ShortFilm extends Films{
    private String date;
    String[] writers;
    String[] genre;
    ShortFilm(String id, String title, String language, String runTime, String country , String[] directors, String[] cast, String date, String[] writers, String[] genre){
        super(id, title, language, runTime, country, directors, cast);
        super.type = "Short Film";
        super.tarih = date;
        this.date = date;
        this.writers = writers;
        this.genre = genre;
    }
}
