package backend;

public class Activities {
    protected String name;
    protected boolean completion;
    public Activities(String name, boolean completion){
        this.name=name;
        this.completion=completion;
    }

    public String getName() {
        return name;
    }
    public String toString(){
        return "name: "+name+" completion :"+completion;
    }
}
