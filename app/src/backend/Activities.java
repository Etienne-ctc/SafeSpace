public abstract class Activities {
    protected String name;
    protected int completion;
    protected String content;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCompletion() {
        return completion;
    }

    public String getContent() {
        return content;
    }

    public void setCompletion(int completion) {
        this.completion = completion;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
