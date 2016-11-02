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
public class TiGiaNgoaiTe {
    private Database_CauHoi database_cauHoi;
    private ArrayList<CauHoi> danhSachCauHoi = new ArrayList<CauHoi>();
    private ArrayList<CauHoi> danhSachCauHoi_NgoaiTe = new ArrayList<CauHoi>();

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm dd:MM:yyyy");
    ChatMessage chatMessage = new ChatMessage();

    public ChatMessage tiGiaNgoaiTe(Activity activity, String giongNoi){
        database_cauHoi = new Database_CauHoi(activity);
        danhSachCauHoi = database_cauHoi.layDanhSachCauHoi();

        // lấy danh sách câu hỏi mở tỉ giá ngoại tệ
        for (int i = 0; i < danhSachCauHoi.size(); i++) {
            if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("tỉ giá ngoại tệ")) {
                CauHoi cauHoi = new CauHoi();
                cauHoi.setId(danhSachCauHoi.get(i).getId());
                cauHoi.setLoaiCauHoi(danhSachCauHoi.get(i).getLoaiCauHoi());
                cauHoi.setCauHoi(danhSachCauHoi.get(i).getCauHoi());
                danhSachCauHoi_NgoaiTe.add(cauHoi);
            }
        }

        chatMessage.setIsMe(false);
        chatMessage.setDateTime(simpleDateFormat.format(new Date()));

        for (int i = 0; i < danhSachCauHoi_NgoaiTe.size(); i++) {
            if (giongNoi.trim().toLowerCase().equals(danhSachCauHoi_NgoaiTe.get(i).getCauHoi())) {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH );
                intent.putExtra(SearchManager.QUERY, "https://www.vietcombank.com.vn/exchangerates/");
                activity.startActivity(intent);
                chatMessage.setMesage(giongNoi + " : Đã bật");
                break;

            }
        }

        return chatMessage;
    }

}
