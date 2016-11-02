package speak.hiepdd.tro_ly_ao_android.Utils;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;

import java.text.SimpleDateFormat;
import java.util.Date;

import speak.hiepdd.tro_ly_ao_android.Model.ChatMessage;

/**
 * Created by hiepdd on 02/10/2016.
 */
public class BangXepHang_LichThiDau {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm dd:MM:yyyy");
    ChatMessage chatMessage = new ChatMessage();

    public ChatMessage hienThiBXH_LTD(Activity activity, String giongNoi){
        chatMessage.setIsMe(false);
        chatMessage.setDateTime(simpleDateFormat.format(new Date()));
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH );
        intent.putExtra(SearchManager.QUERY, giongNoi);
        activity.startActivity(intent);
        chatMessage.setMesage(giongNoi+" : Đã hiển thị");

        return chatMessage;
    }
}
