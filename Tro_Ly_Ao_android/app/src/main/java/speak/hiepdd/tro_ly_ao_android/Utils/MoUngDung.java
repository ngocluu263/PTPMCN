package speak.hiepdd.tro_ly_ao_android.Utils;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import speak.hiepdd.tro_ly_ao_android.Activity.Diadiem;
import speak.hiepdd.tro_ly_ao_android.Activity.DocBao;
import speak.hiepdd.tro_ly_ao_android.Database.Database_CauHoi;
import speak.hiepdd.tro_ly_ao_android.Model.CauHoi;
import speak.hiepdd.tro_ly_ao_android.Model.ChatMessage;

/**
 * Created by hiepdd on 12/09/2016.
 */
public class MoUngDung {
    private Database_CauHoi database_cauHoi;
    private ArrayList<CauHoi> danhSachCauHoi = new ArrayList<CauHoi>();
    private ArrayList<CauHoi> danhSachCauHoi_facebook = new ArrayList<CauHoi>();
    private ArrayList<CauHoi> danhSachCauHoi_messenger = new ArrayList<CauHoi>();
    private ArrayList<CauHoi> danhSachCauHoi_zingMP3 = new ArrayList<CauHoi>();
    private ArrayList<CauHoi> danhSachCauHoi_zalo = new ArrayList<CauHoi>();
    private ArrayList<CauHoi> danhSachCauHoi_danhBa = new ArrayList<CauHoi>();
    private ArrayList<CauHoi> danhSachCauHoi_caiDat = new ArrayList<CauHoi>();
    private ArrayList<CauHoi> danhSachCauHoi_youtube = new ArrayList<CauHoi>();
    private ArrayList<CauHoi> danhSachCauHoi_email = new ArrayList<CauHoi>();
    private ArrayList<CauHoi> danhSachCauHoi_trinhDuyet = new ArrayList<CauHoi>();
    private ArrayList<CauHoi> danhSachCauHoi_lich = new ArrayList<CauHoi>();
    private ArrayList<CauHoi> danhSachCauHoi_instagram = new ArrayList<CauHoi>();
    private ArrayList<CauHoi> danhSachCauHoi_thuVienAnh = new ArrayList<CauHoi>();
    private ArrayList<CauHoi> danhSachCauHoi_gmail = new ArrayList<CauHoi>();
    private ArrayList<CauHoi> danhSachCauHoi_banDo = new ArrayList<CauHoi>();
    private ArrayList<CauHoi> danhSachCauHoi_docbao = new ArrayList<CauHoi>();
    private ArrayList<CauHoi> danhSachCauHoi_diadiem = new ArrayList<CauHoi>();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm dd:MM:yyyy");
    ChatMessage chatMessage = new ChatMessage();

    // mo facebook
    public ChatMessage moUngDung_facebook(Activity activity, String giongNoi) {
        database_cauHoi = new Database_CauHoi(activity);
        danhSachCauHoi = database_cauHoi.layDanhSachCauHoi();

        // lấy danh sách câu hỏi mở facebook
        for (int i = 0; i < danhSachCauHoi.size(); i++) {
            if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("mở ứng dụng facebook")) {
                CauHoi cauHoi = new CauHoi();
                cauHoi.setId(danhSachCauHoi.get(i).getId());
                cauHoi.setLoaiCauHoi(danhSachCauHoi.get(i).getLoaiCauHoi());
                cauHoi.setCauHoi(danhSachCauHoi.get(i).getCauHoi());
                danhSachCauHoi_facebook.add(cauHoi);
            }
        }

        chatMessage.setIsMe(false);
        chatMessage.setDateTime(simpleDateFormat.format(new Date()));

        for (int i = 0; i < danhSachCauHoi_facebook.size(); i++) {
            if (giongNoi.trim().toLowerCase().equals(danhSachCauHoi_facebook.get(i).getCauHoi())) {
                String packageName = "com.facebook.katana";
                try {
                    Intent intent = new Intent("android.intent.action.MAIN");
                    intent.addCategory("android.intent.category.LAUNCHER");

                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    List<ResolveInfo> resolveinfo_list = activity.getPackageManager().queryIntentActivities(intent, 0);

                    for (ResolveInfo info : resolveinfo_list) {
                        if (info.activityInfo.packageName.equalsIgnoreCase(packageName)) {
                            Intent launch_intent = new Intent("android.intent.action.MAIN");
                            launch_intent.addCategory("android.intent.category.LAUNCHER");
                            launch_intent.setComponent(new ComponentName(info.activityInfo.packageName, info.activityInfo.name));
                            launch_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                            activity.startActivity(launch_intent);
                            chatMessage.setMesage(giongNoi + " : Đã mở");
                            break;
                        }
                    }
                    break;
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(activity.getApplicationContext(), "There was a problem loading the application: " + giongNoi, Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }
        return chatMessage;
    }
    // mo doc bao
    public ChatMessage moUngDung_docbao(Activity activity, String giongNoi){
        database_cauHoi = new Database_CauHoi(activity);
        danhSachCauHoi = database_cauHoi.layDanhSachCauHoi();
        for(int i=0;i<danhSachCauHoi.size();i++){
            if(danhSachCauHoi.get(i).getLoaiCauHoi().equals("đọc báo")){
                CauHoi cauHoi = new CauHoi();
                cauHoi.setId(danhSachCauHoi.get(i).getId());
                cauHoi.setLoaiCauHoi(danhSachCauHoi.get(i).getLoaiCauHoi());
                cauHoi.setCauHoi(danhSachCauHoi.get(i).getCauHoi());
                danhSachCauHoi_docbao.add(cauHoi);
            }
        }
        chatMessage.setIsMe(false);
        chatMessage.setDateTime(simpleDateFormat.format(new Date()));
        for(int i =0;i<danhSachCauHoi_docbao.size();i++){
            if (giongNoi.trim().toLowerCase().equals(danhSachCauHoi_docbao.get(i).getCauHoi())) {
                Intent intent = new Intent(activity, DocBao.class);
                activity.startActivity(intent);
                chatMessage.setMesage(giongNoi + " đã mở");
            }
        }
        return chatMessage;
    }
    // mo dia diem
    public ChatMessage moUngDung_diadiem(Activity activity, String giongNoi){
        database_cauHoi = new Database_CauHoi(activity);
        danhSachCauHoi = database_cauHoi.layDanhSachCauHoi();
        for(int i=0;i<danhSachCauHoi.size();i++){
            if(danhSachCauHoi.get(i).getLoaiCauHoi().equals("địa điểm")){
                CauHoi cauHoi = new CauHoi();
                cauHoi.setId(danhSachCauHoi.get(i).getId());
                cauHoi.setLoaiCauHoi(danhSachCauHoi.get(i).getLoaiCauHoi());
                cauHoi.setCauHoi(danhSachCauHoi.get(i).getCauHoi());
                danhSachCauHoi_diadiem.add(cauHoi);
            }
        }
        chatMessage.setIsMe(false);
        chatMessage.setDateTime(simpleDateFormat.format(new Date()));
        for(int i =0;i<danhSachCauHoi_diadiem.size();i++){
            if (giongNoi.trim().toLowerCase().equals(danhSachCauHoi_diadiem.get(i).getCauHoi())) {
                Intent intent = new Intent(activity, Diadiem.class);
                activity.startActivity(intent);
                chatMessage.setMesage(giongNoi + " đã mở");
            }
        }
        return chatMessage;
    }
    // mo messenger
    public ChatMessage moUngDung_messenger(Activity activity, String giongNoi) {
        database_cauHoi = new Database_CauHoi(activity);
        danhSachCauHoi = database_cauHoi.layDanhSachCauHoi();

        // lấy danh sách câu hỏi mở messenger
        for (int i = 0; i < danhSachCauHoi.size(); i++) {
            if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("mở ứng dụng messenger")) {
                CauHoi cauHoi = new CauHoi();
                cauHoi.setId(danhSachCauHoi.get(i).getId());
                cauHoi.setLoaiCauHoi(danhSachCauHoi.get(i).getLoaiCauHoi());
                cauHoi.setCauHoi(danhSachCauHoi.get(i).getCauHoi());
                danhSachCauHoi_messenger.add(cauHoi);
            }
        }

        chatMessage.setIsMe(false);
        chatMessage.setDateTime(simpleDateFormat.format(new Date()));

        for (int i = 0; i < danhSachCauHoi_messenger.size(); i++) {
            if (giongNoi.trim().toLowerCase().equals(danhSachCauHoi_messenger.get(i).getCauHoi())) {
                String packageName = "com.facebook.orca";
                try {
                    Intent intent = new Intent("android.intent.action.MAIN");
                    intent.addCategory("android.intent.category.LAUNCHER");

                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    List<ResolveInfo> resolveinfo_list = activity.getPackageManager().queryIntentActivities(intent, 0);

                    for (ResolveInfo info : resolveinfo_list) {
                        if (info.activityInfo.packageName.equalsIgnoreCase(packageName)) {
                            Intent launch_intent = new Intent("android.intent.action.MAIN");
                            launch_intent.addCategory("android.intent.category.LAUNCHER");
                            launch_intent.setComponent(new ComponentName(info.activityInfo.packageName, info.activityInfo.name));
                            launch_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                            activity.startActivity(launch_intent);
                            chatMessage.setMesage(giongNoi + " : Đã mở");
                            break;
                        }
                    }
                    break;
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(activity.getApplicationContext(), "There was a problem loading the application: " + giongNoi, Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }
        return chatMessage;
    }

    // mo zing mp3
    public ChatMessage moUngDung_zingMP3(Activity activity, String giongNoi) {
        database_cauHoi = new Database_CauHoi(activity);
        danhSachCauHoi = database_cauHoi.layDanhSachCauHoi();

        // lấy danh sách câu hỏi mở zing mp3
        for (int i = 0; i < danhSachCauHoi.size(); i++) {
            if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("mở ứng dụng zing")) {
                CauHoi cauHoi = new CauHoi();
                cauHoi.setId(danhSachCauHoi.get(i).getId());
                cauHoi.setLoaiCauHoi(danhSachCauHoi.get(i).getLoaiCauHoi());
                cauHoi.setCauHoi(danhSachCauHoi.get(i).getCauHoi());
                danhSachCauHoi_zingMP3.add(cauHoi);
            }
        }

        chatMessage.setIsMe(false);
        chatMessage.setDateTime(simpleDateFormat.format(new Date()));

        for (int i = 0; i < danhSachCauHoi_zingMP3.size(); i++) {
            if (giongNoi.trim().toLowerCase().equals(danhSachCauHoi_zingMP3.get(i).getCauHoi())) {
                String packageName = "com.zing.mp3";
                try {
                    Intent intent = new Intent("android.intent.action.MAIN");
                    intent.addCategory("android.intent.category.LAUNCHER");

                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    List<ResolveInfo> resolveinfo_list = activity.getPackageManager().queryIntentActivities(intent, 0);

                    for (ResolveInfo info : resolveinfo_list) {
                        if (info.activityInfo.packageName.equalsIgnoreCase(packageName)) {
                            Intent launch_intent = new Intent("android.intent.action.MAIN");
                            launch_intent.addCategory("android.intent.category.LAUNCHER");
                            launch_intent.setComponent(new ComponentName(info.activityInfo.packageName, info.activityInfo.name));
                            launch_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                            activity.startActivity(launch_intent);
                            chatMessage.setMesage(giongNoi + " : Đã mở");
                            break;
                        }
                    }
                    break;
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(activity.getApplicationContext(), "There was a problem loading the application: " + giongNoi, Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }
        return chatMessage;
    }

    // mo zalo
    public ChatMessage moUngDung_zalo(Activity activity, String giongNoi) {
        database_cauHoi = new Database_CauHoi(activity);
        danhSachCauHoi = database_cauHoi.layDanhSachCauHoi();

        // lấy danh sách câu hỏi mở zalo
        for (int i = 0; i < danhSachCauHoi.size(); i++) {
            if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("mở ứng dụng zalo")) {
                CauHoi cauHoi = new CauHoi();
                cauHoi.setId(danhSachCauHoi.get(i).getId());
                cauHoi.setLoaiCauHoi(danhSachCauHoi.get(i).getLoaiCauHoi());
                cauHoi.setCauHoi(danhSachCauHoi.get(i).getCauHoi());
                danhSachCauHoi_zalo.add(cauHoi);
            }
        }

        chatMessage.setIsMe(false);
        chatMessage.setDateTime(simpleDateFormat.format(new Date()));

        for (int i = 0; i < danhSachCauHoi_zalo.size(); i++) {
            if (giongNoi.trim().toLowerCase().equals(danhSachCauHoi_zalo.get(i).getCauHoi())) {
                String packageName = "com.zing.zalo";
                try {
                    Intent intent = new Intent("android.intent.action.MAIN");
                    intent.addCategory("android.intent.category.LAUNCHER");

                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    List<ResolveInfo> resolveinfo_list = activity.getPackageManager().queryIntentActivities(intent, 0);

                    for (ResolveInfo info : resolveinfo_list) {
                        if (info.activityInfo.packageName.equalsIgnoreCase(packageName)) {
                            Intent launch_intent = new Intent("android.intent.action.MAIN");
                            launch_intent.addCategory("android.intent.category.LAUNCHER");
                            launch_intent.setComponent(new ComponentName(info.activityInfo.packageName, info.activityInfo.name));
                            launch_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                            activity.startActivity(launch_intent);
                            chatMessage.setMesage(giongNoi + " : Đã mở");
                            break;
                        }
                    }
                    break;
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(activity.getApplicationContext(), "There was a problem loading the application: " + giongNoi, Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }
        return chatMessage;
    }


    // mo danh bạ
    public ChatMessage moUngDung_danhBa(Activity activity, String giongNoi) {
        database_cauHoi = new Database_CauHoi(activity);
        danhSachCauHoi = database_cauHoi.layDanhSachCauHoi();

        // lấy danh sách câu hỏi mở danh bạ
        for (int i = 0; i < danhSachCauHoi.size(); i++) {
            if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("mở ứng dụng danh bạ")) {
                CauHoi cauHoi = new CauHoi();
                cauHoi.setId(danhSachCauHoi.get(i).getId());
                cauHoi.setLoaiCauHoi(danhSachCauHoi.get(i).getLoaiCauHoi());
                cauHoi.setCauHoi(danhSachCauHoi.get(i).getCauHoi());
                danhSachCauHoi_danhBa.add(cauHoi);
            }
        }

        chatMessage.setIsMe(false);
        chatMessage.setDateTime(simpleDateFormat.format(new Date()));

        for (int i = 0; i < danhSachCauHoi_danhBa.size(); i++) {
            if (giongNoi.trim().toLowerCase().equals(danhSachCauHoi_danhBa.get(i).getCauHoi())) {
                String packageName = "com.android.contacts";
                try {
                    Intent intent = new Intent("android.intent.action.MAIN");
                    intent.addCategory("android.intent.category.LAUNCHER");

                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    List<ResolveInfo> resolveinfo_list = activity.getPackageManager().queryIntentActivities(intent, 0);

                    for (ResolveInfo info : resolveinfo_list) {
                        if (info.activityInfo.packageName.equalsIgnoreCase(packageName)) {
                            Intent launch_intent = new Intent("android.intent.action.MAIN");
                            launch_intent.addCategory("android.intent.category.LAUNCHER");
                            launch_intent.setComponent(new ComponentName(info.activityInfo.packageName, info.activityInfo.name));
                            launch_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                            activity.startActivity(launch_intent);
                            chatMessage.setMesage(giongNoi + " : Đã mở");
                            break;
                        }
                    }
                    break;
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(activity.getApplicationContext(), "There was a problem loading the application: " + giongNoi, Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }
        return chatMessage;
    }


    // mở cài đặt
    public ChatMessage moUngDung_caiDat(Activity activity, String giongNoi) {
        database_cauHoi = new Database_CauHoi(activity);
        danhSachCauHoi = database_cauHoi.layDanhSachCauHoi();

        // lấy danh sách câu hỏi mở cài đặt
        for (int i = 0; i < danhSachCauHoi.size(); i++) {
            if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("mở ứng dụng cài đặt")) {
                CauHoi cauHoi = new CauHoi();
                cauHoi.setId(danhSachCauHoi.get(i).getId());
                cauHoi.setLoaiCauHoi(danhSachCauHoi.get(i).getLoaiCauHoi());
                cauHoi.setCauHoi(danhSachCauHoi.get(i).getCauHoi());
                danhSachCauHoi_caiDat.add(cauHoi);
            }
        }

        chatMessage.setIsMe(false);
        chatMessage.setDateTime(simpleDateFormat.format(new Date()));

        for (int i = 0; i < danhSachCauHoi_caiDat.size(); i++) {
            if (giongNoi.trim().toLowerCase().equals(danhSachCauHoi_caiDat.get(i).getCauHoi())) {
                String packageName = "com.android.settings";
                try {
                    Intent intent = new Intent("android.intent.action.MAIN");
                    intent.addCategory("android.intent.category.LAUNCHER");

                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    List<ResolveInfo> resolveinfo_list = activity.getPackageManager().queryIntentActivities(intent, 0);

                    for (ResolveInfo info : resolveinfo_list) {
                        if (info.activityInfo.packageName.equalsIgnoreCase(packageName)) {
                            Intent launch_intent = new Intent("android.intent.action.MAIN");
                            launch_intent.addCategory("android.intent.category.LAUNCHER");
                            launch_intent.setComponent(new ComponentName(info.activityInfo.packageName, info.activityInfo.name));
                            launch_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                            activity.startActivity(launch_intent);
                            chatMessage.setMesage(giongNoi + " : Đã mở");
                            break;
                        }
                    }
                    break;
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(activity.getApplicationContext(), "There was a problem loading the application: " + giongNoi, Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }
        return chatMessage;
    }


    // mở youtube
    public ChatMessage moUngDung_youtube(Activity activity, String giongNoi) {
        database_cauHoi = new Database_CauHoi(activity);
        danhSachCauHoi = database_cauHoi.layDanhSachCauHoi();

        // lấy danh sách câu hỏi mở youtube
        for (int i = 0; i < danhSachCauHoi.size(); i++) {
            if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("mở ứng dụng youtube")) {
                CauHoi cauHoi = new CauHoi();
                cauHoi.setId(danhSachCauHoi.get(i).getId());
                cauHoi.setLoaiCauHoi(danhSachCauHoi.get(i).getLoaiCauHoi());
                cauHoi.setCauHoi(danhSachCauHoi.get(i).getCauHoi());
                danhSachCauHoi_youtube.add(cauHoi);
            }
        }

        chatMessage.setIsMe(false);
        chatMessage.setDateTime(simpleDateFormat.format(new Date()));

        for (int i = 0; i < danhSachCauHoi_youtube.size(); i++) {
            if (giongNoi.trim().toLowerCase().equals(danhSachCauHoi_youtube.get(i).getCauHoi())) {
                String packageName = "com.google.android.youtube";
                try {
                    Intent intent = new Intent("android.intent.action.MAIN");
                    intent.addCategory("android.intent.category.LAUNCHER");

                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    List<ResolveInfo> resolveinfo_list = activity.getPackageManager().queryIntentActivities(intent, 0);

                    for (ResolveInfo info : resolveinfo_list) {
                        if (info.activityInfo.packageName.equalsIgnoreCase(packageName)) {
                            Intent launch_intent = new Intent("android.intent.action.MAIN");
                            launch_intent.addCategory("android.intent.category.LAUNCHER");
                            launch_intent.setComponent(new ComponentName(info.activityInfo.packageName, info.activityInfo.name));
                            launch_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                            activity.startActivity(launch_intent);
                            chatMessage.setMesage(giongNoi + " : Đã mở");
                            break;
                        }
                    }
                    break;
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(activity.getApplicationContext(), "There was a problem loading the application: " + giongNoi, Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }
        return chatMessage;
    }

    // mở email
    public ChatMessage moUngDung_email(Activity activity, String giongNoi) {
        database_cauHoi = new Database_CauHoi(activity);
        danhSachCauHoi = database_cauHoi.layDanhSachCauHoi();

        // lấy danh sách câu hỏi mở youtube
        for (int i = 0; i < danhSachCauHoi.size(); i++) {
            if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("mở ứng dụng email")) {
                CauHoi cauHoi = new CauHoi();
                cauHoi.setId(danhSachCauHoi.get(i).getId());
                cauHoi.setLoaiCauHoi(danhSachCauHoi.get(i).getLoaiCauHoi());
                cauHoi.setCauHoi(danhSachCauHoi.get(i).getCauHoi());
                danhSachCauHoi_email.add(cauHoi);
            }
        }

        chatMessage.setIsMe(false);
        chatMessage.setDateTime(simpleDateFormat.format(new Date()));

        for (int i = 0; i < danhSachCauHoi_email.size(); i++) {
            if (giongNoi.trim().toLowerCase().equals(danhSachCauHoi_email.get(i).getCauHoi())) {
                String packageName = "com.android.email";
                try {
                    Intent intent = new Intent("android.intent.action.MAIN");
                    intent.addCategory("android.intent.category.LAUNCHER");

                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    List<ResolveInfo> resolveinfo_list = activity.getPackageManager().queryIntentActivities(intent, 0);

                    for (ResolveInfo info : resolveinfo_list) {
                        if (info.activityInfo.packageName.equalsIgnoreCase(packageName)) {
                            Intent launch_intent = new Intent("android.intent.action.MAIN");
                            launch_intent.addCategory("android.intent.category.LAUNCHER");
                            launch_intent.setComponent(new ComponentName(info.activityInfo.packageName, info.activityInfo.name));
                            launch_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                            activity.startActivity(launch_intent);
                            chatMessage.setMesage(giongNoi + " : Đã mở");
                            break;
                        }
                    }
                    break;
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(activity.getApplicationContext(), "There was a problem loading the application: " + giongNoi, Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }
        return chatMessage;
    }

    // mở lịch
    public ChatMessage moUngDung_lich(Activity activity, String giongNoi) {
        database_cauHoi = new Database_CauHoi(activity);
        danhSachCauHoi = database_cauHoi.layDanhSachCauHoi();

        // lấy danh sách câu hỏi mở lịch
        for (int i = 0; i < danhSachCauHoi.size(); i++) {
            if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("mở ứng dụng lịch")) {
                CauHoi cauHoi = new CauHoi();
                cauHoi.setId(danhSachCauHoi.get(i).getId());
                cauHoi.setLoaiCauHoi(danhSachCauHoi.get(i).getLoaiCauHoi());
                cauHoi.setCauHoi(danhSachCauHoi.get(i).getCauHoi());
                danhSachCauHoi_lich.add(cauHoi);
            }
        }

        chatMessage.setIsMe(false);
        chatMessage.setDateTime(simpleDateFormat.format(new Date()));

        for (int i = 0; i < danhSachCauHoi_lich.size(); i++) {
            if (giongNoi.trim().toLowerCase().equals(danhSachCauHoi_lich.get(i).getCauHoi())) {
                String packageName = "com.android.calendar";
                try {
                    Intent intent = new Intent("android.intent.action.MAIN");
                    intent.addCategory("android.intent.category.LAUNCHER");

                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    List<ResolveInfo> resolveinfo_list = activity.getPackageManager().queryIntentActivities(intent, 0);

                    for (ResolveInfo info : resolveinfo_list) {
                        if (info.activityInfo.packageName.equalsIgnoreCase(packageName)) {
                            Intent launch_intent = new Intent("android.intent.action.MAIN");
                            launch_intent.addCategory("android.intent.category.LAUNCHER");
                            launch_intent.setComponent(new ComponentName(info.activityInfo.packageName, info.activityInfo.name));
                            launch_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                            activity.startActivity(launch_intent);
                            chatMessage.setMesage(giongNoi + " : Đã mở");
                            break;
                        }
                    }
                    break;
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(activity.getApplicationContext(), "There was a problem loading the application: " + giongNoi, Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }
        return chatMessage;
    }

    // mở trình duyệt
    public ChatMessage moUngDung_trinhDuyet(Activity activity, String giongNoi) {
        database_cauHoi = new Database_CauHoi(activity);
        danhSachCauHoi = database_cauHoi.layDanhSachCauHoi();

        // lấy danh sách câu hỏi mở trinh duyệt
        for (int i = 0; i < danhSachCauHoi.size(); i++) {
            if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("mở ứng dụng trình duyệt")) {
                CauHoi cauHoi = new CauHoi();
                cauHoi.setId(danhSachCauHoi.get(i).getId());
                cauHoi.setLoaiCauHoi(danhSachCauHoi.get(i).getLoaiCauHoi());
                cauHoi.setCauHoi(danhSachCauHoi.get(i).getCauHoi());
                danhSachCauHoi_trinhDuyet.add(cauHoi);
            }
        }

        chatMessage.setIsMe(false);
        chatMessage.setDateTime(simpleDateFormat.format(new Date()));

        for (int i = 0; i < danhSachCauHoi_trinhDuyet.size(); i++) {
            if (giongNoi.trim().toLowerCase().equals(danhSachCauHoi_trinhDuyet.get(i).getCauHoi())) {
                String packageName = "com.android.browser";
                try {
                    Intent intent = new Intent("android.intent.action.MAIN");
                    intent.addCategory("android.intent.category.LAUNCHER");

                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    List<ResolveInfo> resolveinfo_list = activity.getPackageManager().queryIntentActivities(intent, 0);

                    for (ResolveInfo info : resolveinfo_list) {
                        if (info.activityInfo.packageName.equalsIgnoreCase(packageName)) {
                            Intent launch_intent = new Intent("android.intent.action.MAIN");
                            launch_intent.addCategory("android.intent.category.LAUNCHER");
                            launch_intent.setComponent(new ComponentName(info.activityInfo.packageName, info.activityInfo.name));
                            launch_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                            activity.startActivity(launch_intent);
                            chatMessage.setMesage(giongNoi + " : Đã mở");
                            break;
                        }
                    }
                    break;
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(activity.getApplicationContext(), "There was a problem loading the application: " + giongNoi, Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }
        return chatMessage;
    }

    // mở instagram
    public ChatMessage moUngDung_instagram(Activity activity, String giongNoi) {
        database_cauHoi = new Database_CauHoi(activity);
        danhSachCauHoi = database_cauHoi.layDanhSachCauHoi();

        // lấy danh sách câu hỏi mở instagram
        for (int i = 0; i < danhSachCauHoi.size(); i++) {
            if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("mở ứng dụng instagram")) {
                CauHoi cauHoi = new CauHoi();
                cauHoi.setId(danhSachCauHoi.get(i).getId());
                cauHoi.setLoaiCauHoi(danhSachCauHoi.get(i).getLoaiCauHoi());
                cauHoi.setCauHoi(danhSachCauHoi.get(i).getCauHoi());
                danhSachCauHoi_instagram.add(cauHoi);
            }
        }

        chatMessage.setIsMe(false);
        chatMessage.setDateTime(simpleDateFormat.format(new Date()));

        for (int i = 0; i < danhSachCauHoi_instagram.size(); i++) {
            if (giongNoi.trim().toLowerCase().equals(danhSachCauHoi_instagram.get(i).getCauHoi())) {
                String packageName = "com.instagram.android";
                try {
                    Intent intent = new Intent("android.intent.action.MAIN");
                    intent.addCategory("android.intent.category.LAUNCHER");

                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    List<ResolveInfo> resolveinfo_list = activity.getPackageManager().queryIntentActivities(intent, 0);

                    for (ResolveInfo info : resolveinfo_list) {
                        if (info.activityInfo.packageName.equalsIgnoreCase(packageName)) {
                            Intent launch_intent = new Intent("android.intent.action.MAIN");
                            launch_intent.addCategory("android.intent.category.LAUNCHER");
                            launch_intent.setComponent(new ComponentName(info.activityInfo.packageName, info.activityInfo.name));
                            launch_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                            activity.startActivity(launch_intent);
                            chatMessage.setMesage(giongNoi + " : Đã mở");
                            break;
                        }
                    }
                    break;
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(activity.getApplicationContext(), "There was a problem loading the application: " + giongNoi, Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }
        return chatMessage;
    }

    // mở thư viện ảnh
    public ChatMessage moUngDung_thuVien(Activity activity, String giongNoi) {
        database_cauHoi = new Database_CauHoi(activity);
        danhSachCauHoi = database_cauHoi.layDanhSachCauHoi();

        // lấy danh sách câu hỏi mở thư viện
        for (int i = 0; i < danhSachCauHoi.size(); i++) {
            if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("mở ứng dụng thư viện")) {
                CauHoi cauHoi = new CauHoi();
                cauHoi.setId(danhSachCauHoi.get(i).getId());
                cauHoi.setLoaiCauHoi(danhSachCauHoi.get(i).getLoaiCauHoi());
                cauHoi.setCauHoi(danhSachCauHoi.get(i).getCauHoi());
                danhSachCauHoi_thuVienAnh.add(cauHoi);
            }
        }

        chatMessage.setIsMe(false);
        chatMessage.setDateTime(simpleDateFormat.format(new Date()));

        for (int i = 0; i < danhSachCauHoi_thuVienAnh.size(); i++) {
            if (giongNoi.trim().toLowerCase().equals(danhSachCauHoi_thuVienAnh.get(i).getCauHoi())) {
                String packageName = "com.android.gallery3d";
                try {
                    Intent intent = new Intent("android.intent.action.MAIN");
                    intent.addCategory("android.intent.category.LAUNCHER");

                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    List<ResolveInfo> resolveinfo_list = activity.getPackageManager().queryIntentActivities(intent, 0);

                    for (ResolveInfo info : resolveinfo_list) {
                        if (info.activityInfo.packageName.equalsIgnoreCase(packageName)) {
                            Intent launch_intent = new Intent("android.intent.action.MAIN");
                            launch_intent.addCategory("android.intent.category.LAUNCHER");
                            launch_intent.setComponent(new ComponentName(info.activityInfo.packageName, info.activityInfo.name));
                            launch_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                            activity.startActivity(launch_intent);
                            chatMessage.setMesage(giongNoi + " : Đã mở");
                            break;
                        }
                    }
                    break;
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(activity.getApplicationContext(), "There was a problem loading the application: " + giongNoi, Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }
        return chatMessage;
    }

    // mở bản đồ
    public ChatMessage moUngDung_banDo(Activity activity, String giongNoi) {
        database_cauHoi = new Database_CauHoi(activity);
        danhSachCauHoi = database_cauHoi.layDanhSachCauHoi();

        // lấy danh sách câu hỏi mở bản đồ
        for (int i = 0; i < danhSachCauHoi.size(); i++) {
            if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("mở ứng dụng bản đồ")) {
                CauHoi cauHoi = new CauHoi();
                cauHoi.setId(danhSachCauHoi.get(i).getId());
                cauHoi.setLoaiCauHoi(danhSachCauHoi.get(i).getLoaiCauHoi());
                cauHoi.setCauHoi(danhSachCauHoi.get(i).getCauHoi());
                danhSachCauHoi_banDo.add(cauHoi);
            }
        }

        chatMessage.setIsMe(false);
        chatMessage.setDateTime(simpleDateFormat.format(new Date()));

        for (int i = 0; i < danhSachCauHoi_banDo.size(); i++) {
            if (giongNoi.trim().toLowerCase().equals(danhSachCauHoi_banDo.get(i).getCauHoi())) {
                String packageName = "com.google.android.apps.maps";
                try {
                    Intent intent = new Intent("android.intent.action.MAIN");
                    intent.addCategory("android.intent.category.LAUNCHER");

                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    List<ResolveInfo> resolveinfo_list = activity.getPackageManager().queryIntentActivities(intent, 0);

                    for (ResolveInfo info : resolveinfo_list) {
                        if (info.activityInfo.packageName.equalsIgnoreCase(packageName)) {
                            Intent launch_intent = new Intent("android.intent.action.MAIN");
                            launch_intent.addCategory("android.intent.category.LAUNCHER");
                            launch_intent.setComponent(new ComponentName(info.activityInfo.packageName, info.activityInfo.name));
                            launch_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                            activity.startActivity(launch_intent);
                            chatMessage.setMesage(giongNoi + " : Đã mở");
                            break;
                        }
                    }
                    break;
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(activity.getApplicationContext(), "There was a problem loading the application: " + giongNoi, Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }
        return chatMessage;
    }

    // mở gmail
    public ChatMessage moUngDung_gmail(Activity activity, String giongNoi) {
        database_cauHoi = new Database_CauHoi(activity);
        danhSachCauHoi = database_cauHoi.layDanhSachCauHoi();

        // lấy danh sách câu hỏi mở gmail
        for (int i = 0; i < danhSachCauHoi.size(); i++) {
            if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("mở ứng dụng gmail")) {
                CauHoi cauHoi = new CauHoi();
                cauHoi.setId(danhSachCauHoi.get(i).getId());
                cauHoi.setLoaiCauHoi(danhSachCauHoi.get(i).getLoaiCauHoi());
                cauHoi.setCauHoi(danhSachCauHoi.get(i).getCauHoi());
                danhSachCauHoi_gmail.add(cauHoi);
            }
        }

        chatMessage.setIsMe(false);
        chatMessage.setDateTime(simpleDateFormat.format(new Date()));

        for (int i = 0; i < danhSachCauHoi_gmail.size(); i++) {
            if (giongNoi.trim().toLowerCase().equals(danhSachCauHoi_gmail.get(i).getCauHoi())) {
                String packageName = "com.google.android.gm";
                try {
                    Intent intent = new Intent("android.intent.action.MAIN");
                    intent.addCategory("android.intent.category.LAUNCHER");

                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    List<ResolveInfo> resolveinfo_list = activity.getPackageManager().queryIntentActivities(intent, 0);

                    for (ResolveInfo info : resolveinfo_list) {
                        if (info.activityInfo.packageName.equalsIgnoreCase(packageName)) {
                            Intent launch_intent = new Intent("android.intent.action.MAIN");
                            launch_intent.addCategory("android.intent.category.LAUNCHER");
                            launch_intent.setComponent(new ComponentName(info.activityInfo.packageName, info.activityInfo.name));
                            launch_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                            activity.startActivity(launch_intent);
                            chatMessage.setMesage(giongNoi + " : Đã mở");
                            break;
                        }
                    }
                    break;
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(activity.getApplicationContext(), "There was a problem loading the application: " + giongNoi, Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }
        return chatMessage;
    }

}
