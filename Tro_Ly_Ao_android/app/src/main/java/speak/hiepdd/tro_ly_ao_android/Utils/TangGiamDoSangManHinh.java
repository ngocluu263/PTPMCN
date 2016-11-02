package speak.hiepdd.tro_ly_ao_android.Utils;

import android.app.Activity;
import android.provider.Settings;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import speak.hiepdd.tro_ly_ao_android.Database.Database_CauHoi;
import speak.hiepdd.tro_ly_ao_android.Model.CauHoi;
import speak.hiepdd.tro_ly_ao_android.Model.ChatMessage;

/**
 * Created by hiepdd on 12/09/2016.
 */
public class TangGiamDoSangManHinh {
    private Database_CauHoi database_cauHoi;
    private ArrayList<CauHoi> danhSachCauHoi = new ArrayList<CauHoi>();
    private ArrayList<CauHoi> danhSachCauHoi_tangDoSang = new ArrayList<CauHoi>();
    private ArrayList<CauHoi> danhSachCauHoi_giamDoSang = new ArrayList<CauHoi>();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm dd:MM:yyyy");
    ChatMessage chatMessage = new ChatMessage();
    private static float brightness_add = 30.0f;

    public ChatMessage tangDoSangManHinh(Activity activity, String giongNoi) {
        database_cauHoi = new Database_CauHoi(activity);
        danhSachCauHoi = database_cauHoi.layDanhSachCauHoi();
        // lấy danh sách câu hỏi tăng độ sáng
        for (int i = 0; i < danhSachCauHoi.size(); i++) {
            if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("tăng độ sáng màn hình")) {
                CauHoi cauHoi = new CauHoi();
                cauHoi.setId(danhSachCauHoi.get(i).getId());
                cauHoi.setLoaiCauHoi(danhSachCauHoi.get(i).getLoaiCauHoi());
                cauHoi.setCauHoi(danhSachCauHoi.get(i).getCauHoi());
                danhSachCauHoi_tangDoSang.add(cauHoi);
            }
        }

        chatMessage.setIsMe(false);
        chatMessage.setDateTime(simpleDateFormat.format(new Date()));
        float curBrightness = 0f;

        for (int i = 0; i < danhSachCauHoi_tangDoSang.size(); i++) {
            if (giongNoi.trim().toLowerCase().equals(danhSachCauHoi_tangDoSang.get(i).getCauHoi())) {
                try {
                    curBrightness = android.provider.Settings.System.getFloat(activity.getContentResolver(), android.provider.Settings.System.SCREEN_BRIGHTNESS);
                } catch (Settings.SettingNotFoundException e) {
                    e.printStackTrace();
                }
                int brightness = 0;
                if (curBrightness + brightness_add >= 255) brightness = 255;
                else brightness = (int) (curBrightness + brightness_add);

                android.provider.Settings.System.putInt(activity.getContentResolver(),
                        android.provider.Settings.System.SCREEN_BRIGHTNESS,
                        brightness);

                chatMessage.setMesage("Đã tăng độ sáng màn hình đến :" + ((brightness * 100) / 255) + " %");
                break;
            }
        }
        return chatMessage;
    }

    public ChatMessage giamDoSangManHinh(Activity activity, String giongNoi) {
        database_cauHoi = new Database_CauHoi(activity);
        danhSachCauHoi = database_cauHoi.layDanhSachCauHoi();
        // lấy danh sách câu hỏi giảm độ sáng
        for (int i = 0; i < danhSachCauHoi.size(); i++) {
            if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("giảm độ sáng màn hình")) {
                CauHoi cauHoi = new CauHoi();
                cauHoi.setId(danhSachCauHoi.get(i).getId());
                cauHoi.setLoaiCauHoi(danhSachCauHoi.get(i).getLoaiCauHoi());
                cauHoi.setCauHoi(danhSachCauHoi.get(i).getCauHoi());
                danhSachCauHoi_giamDoSang.add(cauHoi);
            }
        }

        chatMessage.setIsMe(false);
        chatMessage.setDateTime(simpleDateFormat.format(new Date()));
        float curBrightness = 0f;

        for (int i = 0; i < danhSachCauHoi_giamDoSang.size(); i++) {
            if (giongNoi.trim().toLowerCase().equals(danhSachCauHoi_giamDoSang.get(i).getCauHoi())) {
                try {
                    curBrightness = android.provider.Settings.System.getFloat(activity.getContentResolver(), android.provider.Settings.System.SCREEN_BRIGHTNESS);
                } catch (Settings.SettingNotFoundException e) {
                    e.printStackTrace();
                }
                int brightness = 0;
                if ((curBrightness - brightness_add) <= 0) brightness = 0;
                else brightness = (int) (curBrightness - brightness_add);

                android.provider.Settings.System.putInt(activity.getContentResolver(),
                        android.provider.Settings.System.SCREEN_BRIGHTNESS, brightness);

                chatMessage.setMesage("Đã giảm độ sáng màn hình còn :" + ((brightness * 100) / 255) + " %");
                break;
            }
        }
        return chatMessage;
    }

}
