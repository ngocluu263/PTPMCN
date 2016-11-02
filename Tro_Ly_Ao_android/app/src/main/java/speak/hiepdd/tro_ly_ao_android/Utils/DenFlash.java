package speak.hiepdd.tro_ly_ao_android.Utils;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.hardware.Camera;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import speak.hiepdd.tro_ly_ao_android.Database.Database_CauHoi;
import speak.hiepdd.tro_ly_ao_android.Model.CauHoi;
import speak.hiepdd.tro_ly_ao_android.Model.ChatMessage;

/**
 * Created by hiepdd on 12/09/2016.
 */
public class DenFlash {
    private Database_CauHoi database_cauHoi;
    private ArrayList<CauHoi> danhSachCauHoi = new ArrayList<CauHoi>();
    private ArrayList<CauHoi> danhSachCauHoi_batDenFlash = new ArrayList<CauHoi>();
    private ArrayList<CauHoi> danhSachCauHoi_tatDenFlash = new ArrayList<CauHoi>();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm dd:MM:yyyy");

    // Bật đèn flash
    public ChatMessage batDenFLash(Activity context, String giongNoi) {
        database_cauHoi = new Database_CauHoi(context);
        danhSachCauHoi = database_cauHoi.layDanhSachCauHoi();
        // lấy danh sách câu hỏi bật đèn flash
        for (int i = 0; i < danhSachCauHoi.size(); i++) {
            if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("bật đèn flash")) {
                CauHoi cauHoi = new CauHoi();
                cauHoi.setId(danhSachCauHoi.get(i).getId());
                cauHoi.setLoaiCauHoi(danhSachCauHoi.get(i).getLoaiCauHoi());
                cauHoi.setCauHoi(danhSachCauHoi.get(i).getCauHoi());
                danhSachCauHoi_batDenFlash.add(cauHoi);
            }
        }ChatMessage chatMessage = new ChatMessage();

        // tao đôi tượng chatMessage

        chatMessage.setIsMe(false);
        chatMessage.setDateTime(simpleDateFormat.format(new Date()));

        for (int i = 0; i < danhSachCauHoi_batDenFlash.size(); i++) {
            if (giongNoi.trim().toLowerCase().equals(danhSachCauHoi_batDenFlash.get(i).getCauHoi())) {
                try {
                    if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)) {
                        Camera camera = null;
                        camera = Camera.open();
                        Camera.Parameters parameters = camera.getParameters();
                        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                        camera.setParameters(parameters);
                        camera.startPreview();
                        chatMessage.setMesage("Đã bật đèn Flash");
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    chatMessage.setMesage("Lỗi khi bật đèn Flash");
                    break;
                }
            }
        }

        return chatMessage;
    }


    // tat den flash
    public ChatMessage tatDenFLash(Activity context, String giongNoi) {
        database_cauHoi = new Database_CauHoi(context);
        danhSachCauHoi = database_cauHoi.layDanhSachCauHoi();
        // lấy danh sách câu hỏi tắt đèn flash
        for (int i = 0; i < danhSachCauHoi.size(); i++) {
            if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("tắt đèn flash")) {
                CauHoi cauHoi = new CauHoi();
                cauHoi.setId(danhSachCauHoi.get(i).getId());
                cauHoi.setLoaiCauHoi(danhSachCauHoi.get(i).getLoaiCauHoi());
                cauHoi.setCauHoi(danhSachCauHoi.get(i).getCauHoi());
                danhSachCauHoi_tatDenFlash.add(cauHoi);
            }
        }

        // tạo đối tượng chat message
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setIsMe(false);
        chatMessage.setDateTime(simpleDateFormat.format(new Date()));

        for (int i = 0; i < danhSachCauHoi_tatDenFlash.size(); i++) {
            if (giongNoi.trim().toLowerCase().equals(danhSachCauHoi_tatDenFlash.get(i).getCauHoi())) {
                try {
                    if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)) {
                        Camera camera = Camera.open();
                        Camera.Parameters p = camera.getParameters();
                        p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                        camera.setParameters(p);
                        camera.startPreview();
                        if (camera.getParameters().equals(Camera.Parameters.FLASH_MODE_TORCH)) {
                            camera.stopPreview();
                            camera.release();
                        }
                        chatMessage.setMesage("Đã tắt đèn Flash");
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    chatMessage.setMesage("tắt đèn Flash");
                    break;
                }
            }
        }
        return chatMessage;
    }
}