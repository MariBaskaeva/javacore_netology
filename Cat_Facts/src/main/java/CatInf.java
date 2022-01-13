public class CatInf {
    private String id = null;
    private String text = null;
    private String type = null;
    private String user = null;
    private Integer upvotes = null;

    public CatInf(){}

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public String getUser() {
        return user;
    }

    public Integer getUpvotes() {
        return upvotes;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setUpvotes(Integer upvotes) {
        this.upvotes = upvotes;
    }

    @Override
    public String toString(){
        return "id: " + id + "\n" +
                "text: " + text + "\n" +
                "type: " + type + "\n" +
                "user: " + user + "\n" +
                "upvotes: " + upvotes;
    }
}
