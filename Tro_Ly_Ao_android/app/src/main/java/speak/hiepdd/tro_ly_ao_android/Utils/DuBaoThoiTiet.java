package speak.hiepdd.tro_ly_ao_android.Utils;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;

import java.text.SimpleDateFormat;
import java.util.Date;

import speak.hiepdd.tro_ly_ao_android.Model.ChatMessage;

/**
 * Created by hiepdd on 14/09/2016.
 */
public class DuBaoThoiTiet {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm dd:MM:yyyy");
    ChatMessage chatMessage = new ChatMessage();

    public ChatMessage duBaoThoiTiet(Activity activity, String giongNoi){
        chatMessage.setIsMe(false);
        chatMessage.setDateTime(simpleDateFormat.format(new Date()));
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH );
        intent.putExtra(SearchManager.QUERY, giongNoi);
        activity.startActivity(intent);
        chatMessage.setMesage(giongNoi+" : Đã bật");

        return chatMessage;
    }
}
