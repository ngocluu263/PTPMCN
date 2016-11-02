package speak.hiepdd.tro_ly_ao_android.Utils;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import speak.hiepdd.tro_ly_ao_android.Database.Database_CauHoi;
import speak.hiepdd.tro_ly_ao_android.Model.CauHoi;
import speak.hiepdd.tro_ly_ao_android.Model.ChatMessage;

/**
 * Created by hiepdd on 02/10/2016.
 */
public class GiaVang {
    private Database_CauHoi database_cauHoi;
    private ArrayList<CauHoi> danhSachCauHoi = new ArrayList<CauHoi>();
    private ArrayList<CauHoi> danhSachCauHoi_GiaVang = new ArrayList<CauHoi>();

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm dd:MM:yyyy");
    ChatMessage chatMessage = new ChatMessage();

    public ChatMessage giaVang(Activity activity, String giongNoi){
        database_cauHoi = new Database_CauHoi(activity);
        danhSachCauHoi = database_cauHoi.layDanhSachCauHoi();

        // lấy danh sách câu hỏi mở giá vàng
        for (int i = 0; i < danhSachCauHoi.size(); i++) {
            if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("giá vàng")) {
                CauHoi cauHoi = new CauHoi();
                cauHoi.setId(danhSachCauHoi.get(i).getId());
                cauHoi.setLoaiCauHoi(danhSachCauHoi.get(i).getLoaiCauHoi());
                cauHoi.setCauHoi(danhSachCauHoi.get(i).getCauHoi());
                danhSachCauHoi_GiaVang.add(cauHoi);
            }
        }

        chatMessage.setIsMe(false);
        chatMessage.setDateTime(simpleDateFormat.format(new Date()));

        for (int i = 0; i < danhSachCauHoi_GiaVang.size(); i++) {
            if (giongNoi.trim().toLowerCase().equals(danhSachCauHoi_GiaVang.get(i).getCauHoi())) {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH );
                intent.putExtra(SearchManager.QUERY, "http://vip.giavang.net/teline2/data/banggiavang1a.php");
                activity.startActivity(intent);
                chatMessage.setMesage(giongNoi + " : Đã bật");
                break;

            }
        }

        return chatMessage;
    }

}
