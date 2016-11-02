package speak.hiepdd.tro_ly_ao_android.Model;

/**
 * Created by hiepdd on 11/09/2016.
 */
public class ChatMessage {
    private long id;
    private String mesage;
    private long userId;
    private String dateTime;
    private boolean isMe;



    public long getId() {
        return id;
    }

    public boolean isMe() {
        return isMe;
    }

    public void setIsMe(boolean isMe) {
        this.isMe = isMe;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMesage() {
        return mesage;
    }

    public void setMesage(String mesage) {
        this.mesage = mesage;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
