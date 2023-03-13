public class TVseries extends Films{
    private String startDate;
    private String endDate;
     String seasons;
     String episodes;
    String[] genre;
    String[] writers;

    TVseries(String id, String title, String language, String runTime, String country , String[] directors, String[] cast, String sdate, String edate, String seas, String epi, String[] genre, String[] writers){
        super(id, title, language, runTime, country, directors, cast);
        super.type = "TV Series";
        this.startDate = sdate;
        this.endDate = edate;
        this.seasons = seas;
        this.episodes = epi;
        this.writers = writers;
        this.genre = genre;
    }
    String getStartDate(){
        return this.startDate;
    }
    String getEndDate(){
        return  this.endDate;
    }
    String getTitle(){
        return this.title;
    }
}
