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
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id=id;
    }
}
