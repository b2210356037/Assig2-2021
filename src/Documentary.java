public class Documentary extends Films{
    String date;

    Documentary(String id, String title, String language, String runTime, String country , String[] directors, String[] cast, String date){
        super(id, title, language, runTime, country, directors, cast);
        super.type = "Documentary";
        super.tarih = date;
        this.date = date;
    }
}
