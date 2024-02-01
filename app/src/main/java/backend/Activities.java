package backend;

public class Activities {
    protected String name;
    protected boolean completion;
    protected String id;
    public Activities(String name, boolean completion,String id){
        this.name=name;
        this.completion=completion;
        this.id=id;
    }

    public String getName() {
        return name;
    }
    public String toString(){
        return "name: "+name+" completion :"+completion;
    }
}
