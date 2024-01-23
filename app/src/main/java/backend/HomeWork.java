package backend;

public class HomeWork extends Activities{
    private Professionnal professionnal;

    public HomeWork(String name, String content, int completion, Professionnal professionnal){
        /*
        Get it from the database instead
         */
        this.name= name;
        this.content = content;
        this.completion = completion;
        this.professionnal=professionnal;
    }


}
