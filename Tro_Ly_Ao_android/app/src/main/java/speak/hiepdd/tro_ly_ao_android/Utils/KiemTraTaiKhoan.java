package speak.hiepdd.tro_ly_ao_android.Utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import speak.hiepdd.tro_ly_ao_android.Database.Database_CauHoi;
import speak.hiepdd.tro_ly_ao_android.Model.CauHoi;
import speak.hiepdd.tro_ly_ao_android.Model.ChatMessage;

/**
 * Created by hiepdd on 12/09/2016.
 */
public class KiemTraTaiKhoan {
    private Database_CauHoi database_cauHoi;
    private ArrayList<CauHoi> danhSachCauHoi = new ArrayList<CauHoi>();
    private ArrayList<CauHoi> danhSachCauHoi_taiKhoanChinh = new ArrayList<CauHoi>();
    private ArrayList<CauHoi> danhSachCauHoi_taiKhoanPhu = new ArrayList<CauHoi>();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm dd:MM:yyyy");
    ChatMessage chatMessage = new ChatMessage();

    // kiểm tra tài khoàn chính
    public ChatMessage kiemTraTaiKhoanChinh(Activity activity, String giongNoi) {
        database_cauHoi = new Database_CauHoi(activity);
        danhSachCauHoi = database_cauHoi.layDanhSachCauHoi();
        // lấy danh sách câu hỏi tai khoan chinh
        for (int i = 0; i < danhSachCauHoi.size(); i++) {
            if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("kiểm tra tài khoản chính")) {
                CauHoi cauHoi = new CauHoi();
                cauHoi.setId(danhSachCauHoi.get(i).getId());
                cauHoi.setLoaiCauHoi(danhSachCauHoi.get(i).getLoaiCauHoi());
                cauHoi.setCauHoi(danhSachCauHoi.get(i).getCauHoi());
                danhSachCauHoi_taiKhoanChinh.add(cauHoi);
            }
        }

        chatMessage.setIsMe(false);
        chatMessage.setDateTime(simpleDateFormat.format(new Date()));

        for(int i=0; i<danhSachCauHoi_taiKhoanChinh.size(); i++){
            if(giongNoi.trim().toLowerCase().equals(danhSachCauHoi_taiKhoanChinh.get(i).getCauHoi())){
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "*101%23"));
                try {
                    activity.startActivity(intent);
                    chatMessage.setMesage("Đã kiểm tra tài khoản chính");
                    break;
                }
                catch (Exception e){
                    chatMessage.setMesage("Lỗi kiểm tra tài khoản chính");
                    break;
                }
            }

        }
        return chatMessage;
    }

    // kiểm tra tài khoàn phu
    public ChatMessage kiemTraTaiKhoanPhu(Activity activity, String giongNoi) {
        database_cauHoi = new Database_CauHoi(activity);
        danhSachCauHoi = database_cauHoi.layDanhSachCauHoi();
        // lấy danh sách câu hỏi tai khoan phu
        for (int i = 0; i < danhSachCauHoi.size(); i++) {
            if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("kiểm tra tài khoản phụ")) {
                CauHoi cauHoi = new CauHoi();
                cauHoi.setId(danhSachCauHoi.get(i).getId());
                cauHoi.setLoaiCauHoi(danhSachCauHoi.get(i).getLoaiCauHoi());
                cauHoi.setCauHoi(danhSachCauHoi.get(i).getCauHoi());
                danhSachCauHoi_taiKhoanPhu.add(cauHoi);
            }
        }

        chatMessage.setIsMe(false);
        chatMessage.setDateTime(simpleDateFormat.format(new Date()));

        for(int i=0; i<danhSachCauHoi_taiKhoanPhu.size(); i++){
            if(giongNoi.trim().toLowerCase().equals(danhSachCauHoi_taiKhoanPhu.get(i).getCauHoi())){
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "*102%23"));
                try {
                    activity.startActivity(intent);
                    chatMessage.setMesage("Đã kiểm tra tài khoản khuyễn mãi");
                    break;
                }
                catch (Exception e){
                    chatMessage.setMesage("Lỗi kiểm tra tài khoản khuyến mãi");
                    break;
                }
            }

        }
        return chatMessage;
    }

}
