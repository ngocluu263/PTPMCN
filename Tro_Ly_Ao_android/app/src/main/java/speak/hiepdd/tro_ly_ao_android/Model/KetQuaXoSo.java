package speak.hiepdd.tro_ly_ao_android.Model;

/**
 * Created by hiepdd on 01/10/2016.
 */
public class KetQuaXoSo {
    private String title;
    private String description;
    private String links;

    public KetQuaXoSo(String title, String description, String links) {
        this.title = title;
        this.description = description;
        this.links = links;
    }

    public KetQuaXoSo() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }
}
