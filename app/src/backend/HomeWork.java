public class HomeWork extends Activities{
    private Professionnal professionnal;

    public HomeWork(String name, String content, int completion, Professionnal professionnal){
        this.name= name;
        this.content = content;
        this.completion = completion;
        this.professionnal=professionnal;
    }

    public Professionnal getProfessionnal() {
        return professionnal;
    }

    public void setProfessionnal(Professionnal professionnal) {
        this.professionnal = professionnal;
    }
}
