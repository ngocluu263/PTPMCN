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
 * Created by hiepdd on 15/09/2016.
 */
public class TimKiemDiaDiem {
    private Database_CauHoi database_cauHoi;
    private ArrayList<CauHoi> danhSachCauHoi = new ArrayList<CauHoi>();
    private ArrayList<CauHoi> danhSachCauHoi_timKiemNhaHang = new ArrayList<CauHoi>();
    private ArrayList<CauHoi> danhSachCauHoi_timKiemTramXang = new ArrayList<CauHoi>();
    private ArrayList<CauHoi> danhSachCauHoi_timKiemATM = new ArrayList<CauHoi>();
    private ArrayList<CauHoi> danhSachCauHoi_timKiemHieuThuoc = new ArrayList<CauHoi>();
    private ArrayList<CauHoi> danhSachCauHoi_timKiemKhachSan = new ArrayList<CauHoi>();
    private ArrayList<CauHoi> danhSachCauHoi_timKiemQuanBar = new ArrayList<CauHoi>();
    private ArrayList<CauHoi> danhSachCauHoi_timKiemBuuDien = new ArrayList<CauHoi>();
    private ArrayList<CauHoi> danhSachCauHoi_timKiemBaiDoXe = new ArrayList<CauHoi>();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm dd:MM:yyyy");
    ChatMessage chatMessage = new ChatMessage();

    // tìm kiếm nhà hàng
    public ChatMessage tim_nhaHang(Activity context, String giongNoi, String diaDiem) {
        database_cauHoi = new Database_CauHoi(context);
        danhSachCauHoi = database_cauHoi.layDanhSachCauHoi();

        for (int i = 0; i < danhSachCauHoi.size(); i++) {
            if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("tìm vị trí nhà hàng")) {
                CauHoi cauHoi = new CauHoi();
                cauHoi.setId(danhSachCauHoi.get(i).getId());
                cauHoi.setLoaiCauHoi(danhSachCauHoi.get(i).getLoaiCauHoi());
                cauHoi.setCauHoi(danhSachCauHoi.get(i).getCauHoi());
                danhSachCauHoi_timKiemNhaHang.add(cauHoi);
            }
        }
        // tao đôi tượng chatMessage
        chatMessage.setIsMe(false);
        chatMessage.setDateTime(simpleDateFormat.format(new Date()));

        for (int i = 0; i < danhSachCauHoi_timKiemNhaHang.size(); i++) {
            if (giongNoi.trim().toLowerCase().equals(danhSachCauHoi_timKiemNhaHang.get(i).getCauHoi())) {
                // Create a Uri from an intent string. Use the result to create an Intent.
                Uri gmmIntentUri = Uri.parse("geo:0,0?q="+diaDiem);

                // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                // Make the Intent explicit by setting the Google Maps package
                mapIntent.setPackage("com.google.android.apps.maps");

                // Attempt to start an activity that can handle the Intent
                context.startActivity(mapIntent);
                chatMessage.setMesage("Đã hiển thị thông tin các nhà hàng quanh đây");
                break;
            }
        }

        return chatMessage;
    }

    // tìm kiếm tram xăng
    public ChatMessage tim_tramXang(Activity context, String giongNoi, String diaDiem) {
        database_cauHoi = new Database_CauHoi(context);
        danhSachCauHoi = database_cauHoi.layDanhSachCauHoi();

        for (int i = 0; i < danhSachCauHoi.size(); i++) {
            if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("tìm vị trí trạm xăng")) {
                CauHoi cauHoi = new CauHoi();
                cauHoi.setId(danhSachCauHoi.get(i).getId());
                cauHoi.setLoaiCauHoi(danhSachCauHoi.get(i).getLoaiCauHoi());
                cauHoi.setCauHoi(danhSachCauHoi.get(i).getCauHoi());
                danhSachCauHoi_timKiemTramXang.add(cauHoi);
            }
        }
        // tao đôi tượng chatMessage
        chatMessage.setIsMe(false);
        chatMessage.setDateTime(simpleDateFormat.format(new Date()));

        for (int i = 0; i < danhSachCauHoi_timKiemTramXang.size(); i++) {
            if (giongNoi.trim().toLowerCase().equals(danhSachCauHoi_timKiemTramXang.get(i).getCauHoi())) {
                // Create a Uri from an intent string. Use the result to create an Intent.
                Uri gmmIntentUri = Uri.parse("geo:0,0?q="+diaDiem);

                // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                // Make the Intent explicit by setting the Google Maps package
                mapIntent.setPackage("com.google.android.apps.maps");

                // Attempt to start an activity that can handle the Intent
                context.startActivity(mapIntent);
                chatMessage.setMesage("Đã hiển thị thông tin các trạm xăng quanh đây");
                break;
            }
        }

        return chatMessage;
    }

    // tìm kiếm quan bar
    public ChatMessage tim_quanBar(Activity context, String giongNoi, String diaDiem) {
        database_cauHoi = new Database_CauHoi(context);
        danhSachCauHoi = database_cauHoi.layDanhSachCauHoi();

        for (int i = 0; i < danhSachCauHoi.size(); i++) {
            if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("tìm vị trí quán bar")) {
                CauHoi cauHoi = new CauHoi();
                cauHoi.setId(danhSachCauHoi.get(i).getId());
                cauHoi.setLoaiCauHoi(danhSachCauHoi.get(i).getLoaiCauHoi());
                cauHoi.setCauHoi(danhSachCauHoi.get(i).getCauHoi());
                danhSachCauHoi_timKiemQuanBar.add(cauHoi);
            }
        }
        // tao đôi tượng chatMessage
        chatMessage.setIsMe(false);
        chatMessage.setDateTime(simpleDateFormat.format(new Date()));

        for (int i = 0; i < danhSachCauHoi_timKiemQuanBar.size(); i++) {
            if (giongNoi.trim().toLowerCase().equals(danhSachCauHoi_timKiemQuanBar.get(i).getCauHoi())) {
                // Create a Uri from an intent string. Use the result to create an Intent.
                Uri gmmIntentUri = Uri.parse("geo:0,0?q="+diaDiem);

                // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                // Make the Intent explicit by setting the Google Maps package
                mapIntent.setPackage("com.google.android.apps.maps");

                // Attempt to start an activity that can handle the Intent
                context.startActivity(mapIntent);
                chatMessage.setMesage("Đã hiển thị thông tin các quán Bar quanh đây");
                break;
            }
        }
        return chatMessage;
    }

    // tìm kiếm hiệu thuốc
    public ChatMessage tim_hieuThuoc(Activity context, String giongNoi, String diaDiem) {
        database_cauHoi = new Database_CauHoi(context);
        danhSachCauHoi = database_cauHoi.layDanhSachCauHoi();

        for (int i = 0; i < danhSachCauHoi.size(); i++) {
            if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("tìm vị trí hiệu thuốc")) {
                CauHoi cauHoi = new CauHoi();
                cauHoi.setId(danhSachCauHoi.get(i).getId());
                cauHoi.setLoaiCauHoi(danhSachCauHoi.get(i).getLoaiCauHoi());
                cauHoi.setCauHoi(danhSachCauHoi.get(i).getCauHoi());
                danhSachCauHoi_timKiemHieuThuoc.add(cauHoi);
            }
        }
        // tao đôi tượng chatMessage
        chatMessage.setIsMe(false);
        chatMessage.setDateTime(simpleDateFormat.format(new Date()));

        for (int i = 0; i < danhSachCauHoi_timKiemHieuThuoc.size(); i++) {
            if (giongNoi.trim().toLowerCase().equals(danhSachCauHoi_timKiemATM.get(i).getCauHoi())) {
                // Create a Uri from an intent string. Use the result to create an Intent.
                Uri gmmIntentUri = Uri.parse("geo:0,0?q="+diaDiem);

                // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                // Make the Intent explicit by setting the Google Maps package
                mapIntent.setPackage("com.google.android.apps.maps");

                // Attempt to start an activity that can handle the Intent
                context.startActivity(mapIntent);
                chatMessage.setMesage("Đã hiển thị thông tin các hiệu thuốc quanh đây");
                break;
            }
        }
        return chatMessage;
    }

    // tìm kiếm khách sạn
    public ChatMessage tim_khachSan(Activity context, String giongNoi, String diaDiem) {
        database_cauHoi = new Database_CauHoi(context);
        danhSachCauHoi = database_cauHoi.layDanhSachCauHoi();

        for (int i = 0; i < danhSachCauHoi.size(); i++) {
            if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("tìm vị trí khách sạn")) {
                CauHoi cauHoi = new CauHoi();
                cauHoi.setId(danhSachCauHoi.get(i).getId());
                cauHoi.setLoaiCauHoi(danhSachCauHoi.get(i).getLoaiCauHoi());
                cauHoi.setCauHoi(danhSachCauHoi.get(i).getCauHoi());
                danhSachCauHoi_timKiemKhachSan.add(cauHoi);
            }
        }
        // tao đôi tượng chatMessage
        chatMessage.setIsMe(false);
        chatMessage.setDateTime(simpleDateFormat.format(new Date()));

        for (int i = 0; i < danhSachCauHoi_timKiemKhachSan.size(); i++) {
            if (giongNoi.trim().toLowerCase().equals(danhSachCauHoi_timKiemKhachSan.get(i).getCauHoi())) {
                // Create a Uri from an intent string. Use the result to create an Intent.
                Uri gmmIntentUri = Uri.parse("geo:0,0?q="+diaDiem);

                // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                // Make the Intent explicit by setting the Google Maps package
                mapIntent.setPackage("com.google.android.apps.maps");

                // Attempt to start an activity that can handle the Intent
                context.startActivity(mapIntent);
                chatMessage.setMesage("Đã hiển thị thông tin các khách sạn quanh đây");
                break;
            }
        }
        return chatMessage;
    }

    // tìm kiếm buu dien
    public ChatMessage tim_buuDien(Activity context, String giongNoi, String diaDiem) {
        database_cauHoi = new Database_CauHoi(context);
        danhSachCauHoi = database_cauHoi.layDanhSachCauHoi();

        for (int i = 0; i < danhSachCauHoi.size(); i++) {
            if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("tìm vị trí bưu điện")) {
                CauHoi cauHoi = new CauHoi();
                cauHoi.setId(danhSachCauHoi.get(i).getId());
                cauHoi.setLoaiCauHoi(danhSachCauHoi.get(i).getLoaiCauHoi());
                cauHoi.setCauHoi(danhSachCauHoi.get(i).getCauHoi());
                danhSachCauHoi_timKiemBuuDien.add(cauHoi);
            }
        }
        // tao đôi tượng chatMessage
        chatMessage.setIsMe(false);
        chatMessage.setDateTime(simpleDateFormat.format(new Date()));

        for (int i = 0; i < danhSachCauHoi_timKiemBuuDien.size(); i++) {
            if (giongNoi.trim().toLowerCase().equals(danhSachCauHoi_timKiemBuuDien.get(i).getCauHoi())) {
                // Create a Uri from an intent string. Use the result to create an Intent.
                Uri gmmIntentUri = Uri.parse("geo:0,0?q="+diaDiem);

                // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                // Make the Intent explicit by setting the Google Maps package
                mapIntent.setPackage("com.google.android.apps.maps");

                // Attempt to start an activity that can handle the Intent
                context.startActivity(mapIntent);
                chatMessage.setMesage("Đã hiển thị thông tin các bưu điện quanh đây");
                break;
            }
        }
        return chatMessage;
    }

    // tìm kiếm ATM
    public ChatMessage tim_ATM(Activity context, String giongNoi, String diaDiem) {
        database_cauHoi = new Database_CauHoi(context);
        danhSachCauHoi = database_cauHoi.layDanhSachCauHoi();

        for (int i = 0; i < danhSachCauHoi.size(); i++) {
            if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("tìm vị trí ATM")) {
                CauHoi cauHoi = new CauHoi();
                cauHoi.setId(danhSachCauHoi.get(i).getId());
                cauHoi.setLoaiCauHoi(danhSachCauHoi.get(i).getLoaiCauHoi());
                cauHoi.setCauHoi(danhSachCauHoi.get(i).getCauHoi());
                danhSachCauHoi_timKiemATM.add(cauHoi);
            }
        }
        // tao đôi tượng chatMessage
        chatMessage.setIsMe(false);
        chatMessage.setDateTime(simpleDateFormat.format(new Date()));

        for (int i = 0; i < danhSachCauHoi_timKiemATM.size(); i++) {
            if (giongNoi.trim().toLowerCase().equals(danhSachCauHoi_timKiemATM.get(i).getCauHoi())) {
                // Create a Uri from an intent string. Use the result to create an Intent.
                Uri gmmIntentUri = Uri.parse("geo:0,0?q="+diaDiem);

                // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                // Make the Intent explicit by setting the Google Maps package
                mapIntent.setPackage("com.google.android.apps.maps");

                // Attempt to start an activity that can handle the Intent
                context.startActivity(mapIntent);
                chatMessage.setMesage("Đã hiển thị thông tin các cây ATM quanh đây");
                break;
            }
        }
        return chatMessage;
    }

    // tìm kiếm bai do xe
    public ChatMessage tim_baiDoXe(Activity context, String giongNoi, String diaDiem) {
        database_cauHoi = new Database_CauHoi(context);
        danhSachCauHoi = database_cauHoi.layDanhSachCauHoi();

        for (int i = 0; i < danhSachCauHoi.size(); i++) {
            if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("tìm vị trí bãi đỗ xe")) {
                CauHoi cauHoi = new CauHoi();
                cauHoi.setId(danhSachCauHoi.get(i).getId());
                cauHoi.setLoaiCauHoi(danhSachCauHoi.get(i).getLoaiCauHoi());
                cauHoi.setCauHoi(danhSachCauHoi.get(i).getCauHoi());
                danhSachCauHoi_timKiemBaiDoXe.add(cauHoi);
            }
        }
        // tao đôi tượng chatMessage
        chatMessage.setIsMe(false);
        chatMessage.setDateTime(simpleDateFormat.format(new Date()));

        for (int i = 0; i < danhSachCauHoi_timKiemBaiDoXe.size(); i++) {
            if (giongNoi.trim().toLowerCase().equals(danhSachCauHoi_timKiemBaiDoXe.get(i).getCauHoi())) {
                // Create a Uri from an intent string. Use the result to create an Intent.
                Uri gmmIntentUri = Uri.parse("geo:0,0?q="+diaDiem);

                // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                // Make the Intent explicit by setting the Google Maps package
                mapIntent.setPackage("com.google.android.apps.maps");

                // Attempt to start an activity that can handle the Intent
                context.startActivity(mapIntent);
                chatMessage.setMesage("Đã hiển thị thông tin các bãi đỗ xe quanh đây");
                break;
            }
        }
        return chatMessage;
    }
}
