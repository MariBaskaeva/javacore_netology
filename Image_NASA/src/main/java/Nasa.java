public class Nasa {
    private String copyright = null;
    private String date = null;
    private String explanation = null;
    private String hdurl = null;
    private String media_type = null;
    private String service_version = null;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    private String title = null;
    private String url = null;

    public Nasa(){}

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public void setHdurl(String hdurl) {
        this.hdurl = hdurl;
    }

    public void setMedia_type(String media_type) {
        this.media_type = media_type;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getDate() {
        return date;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getHdurl() {
        return hdurl;
    }

    public String getMedia_type() {
        return media_type;
    }

    public String getService_version() {
        return service_version;
    }

    public String getUrl() {
        return url;
    }

    public void setService_version(String service_version) {
        this.service_version = service_version;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
