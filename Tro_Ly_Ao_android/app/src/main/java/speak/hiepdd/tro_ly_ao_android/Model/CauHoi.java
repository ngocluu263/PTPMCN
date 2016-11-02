package speak.hiepdd.tro_ly_ao_android.Model;

/**
 * Created by hiepdd on 14/09/2016.
 */
public class CauHoi {
    private int id;
    private String loaiCauHoi;
    private String cauHoi;

    public CauHoi(String loaiCauHoi, String cauHoi) {
        this.loaiCauHoi = loaiCauHoi;
        this.cauHoi = cauHoi;
    }

    public CauHoi(int id, String loaiCauHoi, String cauHoi) {
        this.id = id;
        this.loaiCauHoi = loaiCauHoi;
        this.cauHoi = cauHoi;
    }

    public CauHoi() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoaiCauHoi() {
        return loaiCauHoi;
    }

    public void setLoaiCauHoi(String loaiCauHoi) {
        this.loaiCauHoi = loaiCauHoi;
    }

    public String getCauHoi() {
        return cauHoi;
    }

    public void setCauHoi(String cauHoi) {
        this.cauHoi = cauHoi;
    }
}
