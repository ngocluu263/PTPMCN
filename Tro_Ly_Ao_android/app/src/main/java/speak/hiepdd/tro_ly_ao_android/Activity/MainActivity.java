package speak.hiepdd.tro_ly_ao_android.Activity;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognizerIntent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.txusballesteros.bubbles.BubbleLayout;
import com.txusballesteros.bubbles.BubblesManager;
import com.txusballesteros.bubbles.OnInitializedCallback;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import speak.hiepdd.tro_ly_ao_android.Database.Database_CauHoi;
import speak.hiepdd.tro_ly_ao_android.Model.CauHoi;
import speak.hiepdd.tro_ly_ao_android.Model.ChatMessage;
import speak.hiepdd.tro_ly_ao_android.R;
import speak.hiepdd.tro_ly_ao_android.Utils.BangXepHang_LichThiDau;
import speak.hiepdd.tro_ly_ao_android.Utils.ChatAdapter;
import speak.hiepdd.tro_ly_ao_android.Utils.DenFlash;
import speak.hiepdd.tro_ly_ao_android.Utils.DuBaoThoiTiet;
import speak.hiepdd.tro_ly_ao_android.Utils.GiaVang;
import speak.hiepdd.tro_ly_ao_android.Utils.KetQuaXoSo;
import speak.hiepdd.tro_ly_ao_android.Utils.KhoiTaoDuLieu;
import speak.hiepdd.tro_ly_ao_android.Utils.KiemTraTaiKhoan;
import speak.hiepdd.tro_ly_ao_android.Utils.MoUngDung;
import speak.hiepdd.tro_ly_ao_android.Utils.TangGiamDoSangManHinh;
import speak.hiepdd.tro_ly_ao_android.Utils.TiGiaNgoaiTe;
import speak.hiepdd.tro_ly_ao_android.Utils.TimKiemDiaDiem;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton btnSpeak;
    private final int REQ_CODE_SPEECH_INPUT = 100;

    private BubblesManager bubblesManager;
    private BubbleLayout bubbleView;

    private Database_CauHoi database_cauHoi;
    private ArrayList<CauHoi> danhSachCauHoiDatabase = new ArrayList<CauHoi>();
    private ArrayList<CauHoi> danhSachCauHoi = new ArrayList<CauHoi>();
    private ProgressDialog progressBar;
    private Handler handler;
    private int demNguoc = 10;
    private String tenCuaBan;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private int showBubbleView;
    private boolean isShowBubble;

    private ListView messagesContainer;

    private ChatAdapter adapter;
    private ArrayList<ChatMessage> chatHistory = new ArrayList<ChatMessage>();
    private FloatingActionButton fabCaiDat, fabChiaSe, fabThongTin, fabDanhGia;

    private CallbackManager callbackManager;
    private ShareDialog shareDialog;
    private static final String PERMISSION = "publish_action";
    private FacebookCallback<Sharer.Result> shareCallBack = new FacebookCallback<Sharer.Result>() {
        @Override
        public void onSuccess(Sharer.Result result) {
            //     Toast.makeText(getActivity(), "Success", Toast.LENGTH_SHORT).show();
            if (result.getPostId() != null) {
                String title = "Thành Công";
                String id = result.getPostId();
                String alertMessage = "Chia sẻ quá trình học lên tường của bạn";
                showResult(title, alertMessage);
            }
        }

        @Override
        public void onCancel() {
            Toast.makeText(MainActivity.this, "Hủy chia sẻ", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(FacebookException error) {
            String title = "Chia sẻ không thành công";
            String alertMessage = "Kiểm tra kết nối Internet của bạn";
            showResult(title, alertMessage);
        }

        private void showResult(String title, String alertMessage) {
            new AlertDialog.Builder(MainActivity.this).setTitle(title)
                    .setIcon(R.drawable.icon_speech)
                    .setMessage(alertMessage)
                    .setPositiveButton("Đồng ý", null).show();
        }
    };
    private boolean canPresentShareDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = this.getSharedPreferences("BUBBLE", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        showBubbleView = sharedPreferences.getInt("bubble", 0);
        isShowBubble = sharedPreferences.getBoolean("bubble_boolean", false);
        if (showBubbleView == 0 && !isShowBubble) {
            showBubbleView++;
            isShowBubble = true;
            editor.clear();
            editor.putInt("bubble", showBubbleView);
            editor.putBoolean("bubble_boolean", isShowBubble);
            editor.commit();
            // khoi tao bubble view
            initializeBubblesManager();
            addNewBubble();
            Log.d("resume 0", "" + showBubbleView);
        }
        init();

        if (danhSachCauHoi.size() != 0) {
            promptSpeechInput();
        }


        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                promptSpeechInput();
            }
        });


    }

    // them bubble
    public void addNewBubble() {
        bubbleView = (BubbleLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout.bubble_layout, null);
        bubbleView.setOnBubbleRemoveListener(new BubbleLayout.OnBubbleRemoveListener() {
            @Override
            public void onBubbleRemoved(BubbleLayout bubble) {
                Toast.makeText(MainActivity.this, "hu hu, tạm biệt", Toast.LENGTH_SHORT).show();

                sharedPreferences = MainActivity.this.getSharedPreferences("BUBBLE", MODE_PRIVATE);
                showBubbleView = sharedPreferences.getInt("bubble", 0);
                showBubbleView = 2;
                editor = sharedPreferences.edit();
                editor.clear();
                editor.putInt("bubble", showBubbleView);
                editor.putBoolean("bubble_boolean", true);
                editor.commit();
                Log.d("resume 3", "" + showBubbleView);

            }
        });


        bubbleView.setOnBubbleClickListener(new BubbleLayout.OnBubbleClickListener() {
            @Override
            public void onBubbleClick(BubbleLayout bubble) {
                Toast.makeText(MainActivity.this, "Rất vui được gặp lại bạn", Toast.LENGTH_SHORT).show();

                // mở ứng dụng lên
                Intent launch_intent = new Intent("android.intent.action.MAIN");
                launch_intent.addCategory("android.intent.category.LAUNCHER");
                launch_intent.setComponent(new ComponentName(MainActivity.this.getPackageName(), MainActivity.this.getPackageName() + ".Activity.MainActivity"));
                launch_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                MainActivity.this.startActivity(launch_intent);
            }
        });

        WindowManager windowManager = (WindowManager) MainActivity.this.getSystemService(MainActivity.this.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        bubbleView.setShouldStickToWall(true);
        bubblesManager.addBubble(bubbleView, 0, point.y / 2);
    }

    // khoi tao bubble
    public void initializeBubblesManager() {
        bubblesManager = new BubblesManager.Builder(MainActivity.this)
                .setTrashLayout(R.layout.bubble_trash_layout)
                .setInitializationCallback(new OnInitializedCallback() {
                    @Override
                    public void onInitialized() {
                        addNewBubble();
                    }
                }).build();
        bubblesManager.initialize();
    }

    /**
     * Showing google speech input dialog
     */
    private void promptSpeechInput() {
        btnSpeak.setBackgroundResource(R.drawable.icon_speech);

        sharedPreferences = getSharedPreferences("CATDAT_AMBAO", MODE_PRIVATE);
        boolean tatAmBao = sharedPreferences.getBoolean("tatambao", false);
        Log.d("am bao3", "" + tatAmBao);

        AudioManager amanager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int maxVolume = amanager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

        if (tatAmBao) {
            //tat am thanh cua nhan giong noi
            amanager.setStreamVolume(AudioManager.STREAM_MUSIC, 0, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);
        } else {
            amanager.setStreamMute(AudioManager.STREAM_MUSIC, false);
            amanager.setStreamVolume(AudioManager.STREAM_MUSIC, maxVolume, AudioManager.ADJUST_MUTE);
        }

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
//        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
//                getString(R.string.speech_prompt));
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Receiving speech input
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        btnSpeak.setBackgroundResource(R.drawable.icon_not_speech);
        if (danhSachCauHoi.size() == 0) {
            danhSachCauHoi = database_cauHoi.layDanhSachCauHoi();


        }
        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {
                    SimpleDateFormat format = new SimpleDateFormat("hh:mm dd-MM-yyyy");

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String s = "";
                    for (int i = 0; i < result.size(); i++) {
                        s = s + "\n" + result.get(i);
                    }
                    Toast.makeText(MainActivity.this, s + "\n\n" + result.size(), Toast.LENGTH_SHORT).show();

                    //Chọn phần tử thứ nhất trong danh sách giọng nói nhận được
                    String messageText = result.get(0).toString();
                    if (TextUtils.isEmpty(messageText)) {
                        return;
                    }
                    ChatMessage chatMessage = new ChatMessage();
                    ChatMessage chatMessageBot = new ChatMessage();
                    chatMessage.setMesage(messageText);
                    chatMessage.setDateTime(format.format(new Date()));
                    chatMessage.setIsMe(true);

                    for (int i = 0; i < danhSachCauHoi.size(); i++) {
                        Log.i("a",danhSachCauHoi.get(i).getLoaiCauHoi());
                        if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("bật đèn flash")) {
                            if (chatMessage.getMesage().trim().toLowerCase().equals(danhSachCauHoi.get(i).getCauHoi().trim().toLowerCase())) {
                                DenFlash denFlash = new DenFlash();
                                chatMessageBot = denFlash.batDenFLash(MainActivity.this, chatMessage.getMesage().trim().toLowerCase());
                                break;
                            }
                        }
                        else if(danhSachCauHoi.get(i).getLoaiCauHoi().equals("đọc báo")){
                            if(chatMessage.getMesage().trim().toLowerCase().equals(danhSachCauHoi.get(i).getCauHoi().trim().toLowerCase())){
                                MoUngDung moUngDung = new MoUngDung();
                                chatMessageBot = moUngDung.moUngDung_docbao(MainActivity.this,chatMessage.getMesage().trim().toLowerCase());
                                break;
                            }
                        }
                        else if(danhSachCauHoi.get(i).getLoaiCauHoi().equals("địa điểm")){
                            if(chatMessage.getMesage().trim().toLowerCase().equals(danhSachCauHoi.get(i).getCauHoi().trim().toLowerCase())){
                                MoUngDung moUngDung = new MoUngDung();
                                chatMessageBot = moUngDung.moUngDung_diadiem(MainActivity.this,chatMessage.getMesage().trim().toLowerCase());
                                break;
                            }
                        }
                        else if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("tắt đèn flash")) {
                            if (chatMessage.getMesage().trim().toLowerCase().equals(danhSachCauHoi.get(i).getCauHoi().trim().toLowerCase())) {
                                DenFlash denFlash = new DenFlash();
                                chatMessageBot = denFlash.tatDenFLash(MainActivity.this, chatMessage.getMesage().trim().toLowerCase());
                                break;
                            }
                        } else if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("kiểm tra tài khoản chính")) {
                            if (chatMessage.getMesage().trim().toLowerCase().equals(danhSachCauHoi.get(i).getCauHoi().trim().toLowerCase())) {
                                KiemTraTaiKhoan kiemTraTaiKhoan = new KiemTraTaiKhoan();
                                chatMessageBot = kiemTraTaiKhoan.kiemTraTaiKhoanChinh(MainActivity.this, chatMessage.getMesage().trim().toLowerCase());
                                break;
                            }
                        } else if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("kiểm tra tài khoản phụ")) {
                            if (chatMessage.getMesage().trim().toLowerCase().equals(danhSachCauHoi.get(i).getCauHoi().trim().toLowerCase())) {
                                KiemTraTaiKhoan kiemTraTaiKhoan = new KiemTraTaiKhoan();
                                chatMessageBot = kiemTraTaiKhoan.kiemTraTaiKhoanPhu(MainActivity.this, chatMessage.getMesage().trim().toLowerCase());
                                break;
                            }
                        } else if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("tăng độ sáng màn hình")) {
                            if (chatMessage.getMesage().trim().toLowerCase().equals(danhSachCauHoi.get(i).getCauHoi().trim().toLowerCase())) {
                                TangGiamDoSangManHinh tangGiamDoSangManHinh = new TangGiamDoSangManHinh();
                                chatMessageBot = tangGiamDoSangManHinh.tangDoSangManHinh(MainActivity.this, chatMessage.getMesage().trim().toLowerCase());
                                break;
                            }
                        } else if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("giảm độ sáng màn hình")) {
                            if (chatMessage.getMesage().trim().toLowerCase().equals(danhSachCauHoi.get(i).getCauHoi().trim().toLowerCase())) {
                                TangGiamDoSangManHinh tangGiamDoSangManHinh = new TangGiamDoSangManHinh();
                                chatMessageBot = tangGiamDoSangManHinh.giamDoSangManHinh(MainActivity.this, chatMessage.getMesage().trim().toLowerCase());
                                break;
                            }
                        } else if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("mở ứng dụng facebook")) {
                            if (chatMessage.getMesage().trim().toLowerCase().equals(danhSachCauHoi.get(i).getCauHoi().trim().toLowerCase())) {
                                MoUngDung moUngDung = new MoUngDung();
                                chatMessageBot = moUngDung.moUngDung_facebook(MainActivity.this, chatMessage.getMesage().trim().toLowerCase());
                                break;
                            }
                        } else if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("mở ứng dụng messenger")) {
                            if (chatMessage.getMesage().trim().toLowerCase().equals(danhSachCauHoi.get(i).getCauHoi().trim().toLowerCase())) {
                                MoUngDung moUngDung = new MoUngDung();
                                chatMessageBot = moUngDung.moUngDung_messenger(MainActivity.this, chatMessage.getMesage().trim().toLowerCase());
                                break;
                            }
                        } else if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("mở ứng dụng zing")) {
                            if (chatMessage.getMesage().trim().toLowerCase().equals(danhSachCauHoi.get(i).getCauHoi().trim().toLowerCase())) {
                                MoUngDung moUngDung = new MoUngDung();
                                chatMessageBot = moUngDung.moUngDung_zingMP3(MainActivity.this, chatMessage.getMesage().trim().toLowerCase());
                                break;
                            }
                        } else if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("mở ứng dụng zalo")) {
                            if (chatMessage.getMesage().trim().toLowerCase().equals(danhSachCauHoi.get(i).getCauHoi().trim().toLowerCase())) {
                                MoUngDung moUngDung = new MoUngDung();
                                chatMessageBot = moUngDung.moUngDung_zalo(MainActivity.this, chatMessage.getMesage().trim().toLowerCase());
                                break;
                            }
                        } else if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("mở ứng dụng danh bạ")) {
                            if (chatMessage.getMesage().trim().toLowerCase().equals(danhSachCauHoi.get(i).getCauHoi().trim().toLowerCase())) {
                                MoUngDung moUngDung = new MoUngDung();
                                chatMessageBot = moUngDung.moUngDung_danhBa(MainActivity.this, chatMessage.getMesage().trim().toLowerCase());
                                break;
                            }
                        } else if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("mở ứng dụng cài đặt")) {
                            if (chatMessage.getMesage().trim().toLowerCase().equals(danhSachCauHoi.get(i).getCauHoi().trim().toLowerCase())) {
                                MoUngDung moUngDung = new MoUngDung();
                                chatMessageBot = moUngDung.moUngDung_caiDat(MainActivity.this, chatMessage.getMesage().trim().toLowerCase());
                                break;
                            }
                        } else if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("mở ứng dụng youtube")) {
                            if (chatMessage.getMesage().trim().toLowerCase().equals(danhSachCauHoi.get(i).getCauHoi().trim().toLowerCase())) {
                                MoUngDung moUngDung = new MoUngDung();
                                chatMessageBot = moUngDung.moUngDung_youtube(MainActivity.this, chatMessage.getMesage().trim().toLowerCase());
                                break;
                            }
                        } else if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("mở ứng dụng email")) {
                            if (chatMessage.getMesage().trim().toLowerCase().equals(danhSachCauHoi.get(i).getCauHoi().trim().toLowerCase())) {
                                MoUngDung moUngDung = new MoUngDung();
                                chatMessageBot = moUngDung.moUngDung_email(MainActivity.this, chatMessage.getMesage().trim().toLowerCase());
                                break;
                            }
                        } else if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("mở ứng dụng trình duyệt")) {
                            if (chatMessage.getMesage().trim().toLowerCase().equals(danhSachCauHoi.get(i).getCauHoi().trim().toLowerCase())) {
                                MoUngDung moUngDung = new MoUngDung();
                                chatMessageBot = moUngDung.moUngDung_trinhDuyet(MainActivity.this, chatMessage.getMesage().trim().toLowerCase());
                                break;
                            }
                        } else if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("mở ứng dụng lịch")) {
                            if (chatMessage.getMesage().trim().toLowerCase().equals(danhSachCauHoi.get(i).getCauHoi().trim().toLowerCase())) {
                                MoUngDung moUngDung = new MoUngDung();
                                chatMessageBot = moUngDung.moUngDung_lich(MainActivity.this, chatMessage.getMesage().trim().toLowerCase());
                                break;
                            }
                        } else if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("mở ứng dụng instagram")) {
                            if (chatMessage.getMesage().trim().toLowerCase().equals(danhSachCauHoi.get(i).getCauHoi().trim().toLowerCase())) {
                                MoUngDung moUngDung = new MoUngDung();
                                chatMessageBot = moUngDung.moUngDung_instagram(MainActivity.this, chatMessage.getMesage().trim().toLowerCase());
                                break;
                            }
                        } else if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("mở ứng dụng thư viện")) {
                            if (chatMessage.getMesage().trim().toLowerCase().equals(danhSachCauHoi.get(i).getCauHoi().trim().toLowerCase())) {
                                MoUngDung moUngDung = new MoUngDung();
                                chatMessageBot = moUngDung.moUngDung_thuVien(MainActivity.this, chatMessage.getMesage().trim().toLowerCase());
                                break;
                            }
                        } else if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("mở ứng dụng bản đồ")) {
                            if (chatMessage.getMesage().trim().toLowerCase().equals(danhSachCauHoi.get(i).getCauHoi().trim().toLowerCase())) {
                                MoUngDung moUngDung = new MoUngDung();
                                chatMessageBot = moUngDung.moUngDung_banDo(MainActivity.this, chatMessage.getMesage().trim().toLowerCase());
                                break;
                            }
                        } else if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("mở ứng dụng gmail")) {
                            if (chatMessage.getMesage().trim().toLowerCase().equals(danhSachCauHoi.get(i).getCauHoi().trim().toLowerCase())) {
                                MoUngDung moUngDung = new MoUngDung();
                                chatMessageBot = moUngDung.moUngDung_gmail(MainActivity.this, chatMessage.getMesage().trim().toLowerCase());
                                break;
                            }
                        } else if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("tìm vị trí nhà hàng")) {
                            if (chatMessage.getMesage().trim().toLowerCase().equals(danhSachCauHoi.get(i).getCauHoi().trim().toLowerCase())) {
                                TimKiemDiaDiem timKiemDiaDiem = new TimKiemDiaDiem();
                                chatMessageBot = timKiemDiaDiem.tim_nhaHang(MainActivity.this, chatMessage.getMesage().trim().toLowerCase(), "Nhà hàng");
                                break;
                            }
                        } else if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("tìm vị trí trạm xăng")) {
                            if (chatMessage.getMesage().trim().toLowerCase().equals(danhSachCauHoi.get(i).getCauHoi().trim().toLowerCase())) {
                                TimKiemDiaDiem timKiemDiaDiem = new TimKiemDiaDiem();
                                chatMessageBot = timKiemDiaDiem.tim_tramXang(MainActivity.this, chatMessage.getMesage().trim().toLowerCase(), "Trạm xăng");
                                break;
                            }
                        } else if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("tìm vị trí ATM")) {
                            if (chatMessage.getMesage().trim().toLowerCase().equals(danhSachCauHoi.get(i).getCauHoi().trim().toLowerCase())) {
                                TimKiemDiaDiem timKiemDiaDiem = new TimKiemDiaDiem();
                                chatMessageBot = timKiemDiaDiem.tim_ATM(MainActivity.this, chatMessage.getMesage().trim().toLowerCase(), "ATM");
                                break;
                            }
                        } else if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("tìm vị trí hiệu thuốc")) {
                            if (chatMessage.getMesage().trim().toLowerCase().equals(danhSachCauHoi.get(i).getCauHoi().trim().toLowerCase())) {
                                TimKiemDiaDiem timKiemDiaDiem = new TimKiemDiaDiem();
                                chatMessageBot = timKiemDiaDiem.tim_hieuThuoc(MainActivity.this, chatMessage.getMesage().trim().toLowerCase(), "Hiệu thuốc");
                                break;
                            }
                        } else if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("tìm vị trí khách sạn")) {
                            if (chatMessage.getMesage().trim().toLowerCase().equals(danhSachCauHoi.get(i).getCauHoi().trim().toLowerCase())) {
                                TimKiemDiaDiem timKiemDiaDiem = new TimKiemDiaDiem();
                                chatMessageBot = timKiemDiaDiem.tim_khachSan(MainActivity.this, chatMessage.getMesage().trim().toLowerCase(), "Khách sạn");
                                break;
                            }
                        } else if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("tìm vị trí quán bar")) {
                            if (chatMessage.getMesage().trim().toLowerCase().equals(danhSachCauHoi.get(i).getCauHoi().trim().toLowerCase())) {
                                TimKiemDiaDiem timKiemDiaDiem = new TimKiemDiaDiem();
                                chatMessageBot = timKiemDiaDiem.tim_quanBar(MainActivity.this, chatMessage.getMesage().trim().toLowerCase(), "Quán bar");
                                break;
                            }
                        } else if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("tìm vị trí bưu điện")) {
                            if (chatMessage.getMesage().trim().toLowerCase().equals(danhSachCauHoi.get(i).getCauHoi().trim().toLowerCase())) {
                                TimKiemDiaDiem timKiemDiaDiem = new TimKiemDiaDiem();
                                chatMessageBot = timKiemDiaDiem.tim_buuDien(MainActivity.this, chatMessage.getMesage().trim().toLowerCase(), "Bưu điện");
                                break;
                            }
                        } else if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("tìm vị trí bãi đỗ xe")) {
                            if (chatMessage.getMesage().trim().toLowerCase().equals(danhSachCauHoi.get(i).getCauHoi().trim().toLowerCase())) {
                                TimKiemDiaDiem timKiemDiaDiem = new TimKiemDiaDiem();
                                chatMessageBot = timKiemDiaDiem.tim_baiDoXe(MainActivity.this, chatMessage.getMesage().trim().toLowerCase(), "Bãi đỗ xe");
                                break;
                            }
                        } else if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("xổ số miền bắc")) {
                            if (chatMessage.getMesage().trim().toLowerCase().equals(danhSachCauHoi.get(i).getCauHoi().trim().toLowerCase())) {
                                KetQuaXoSo ketQuaXoSo = new KetQuaXoSo(this);
                                chatMessageBot = ketQuaXoSo.ketQuaXoSo_mienBac(MainActivity.this, chatMessage.getMesage().trim().toLowerCase());
                                break;
                            }
                        } else if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("xổ số miền nam")) {
                            if (chatMessage.getMesage().trim().toLowerCase().equals(danhSachCauHoi.get(i).getCauHoi().trim().toLowerCase())) {
                                KetQuaXoSo ketQuaXoSo = new KetQuaXoSo(this);
                                chatMessageBot = ketQuaXoSo.ketQuaXoSo_mienNam(MainActivity.this, chatMessage.getMesage().trim().toLowerCase());
                                break;
                            }
                        } else if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("xổ số miền trung")) {
                            if (chatMessage.getMesage().trim().toLowerCase().equals(danhSachCauHoi.get(i).getCauHoi().trim().toLowerCase())) {
                                KetQuaXoSo ketQuaXoSo = new KetQuaXoSo(this);
                                chatMessageBot = ketQuaXoSo.ketQuaXoSo_mienTrung(MainActivity.this, chatMessage.getMesage().trim().toLowerCase());
                                break;
                            }
                        } else if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("tỉ giá ngoại tệ")) {
                            if (chatMessage.getMesage().trim().toLowerCase().equals(danhSachCauHoi.get(i).getCauHoi().trim().toLowerCase())) {
                                TiGiaNgoaiTe tiGiaNgoaiTe = new TiGiaNgoaiTe();
                                chatMessageBot = tiGiaNgoaiTe.tiGiaNgoaiTe(MainActivity.this, chatMessage.getMesage().trim().toLowerCase());
                                break;
                            }
                        } else if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("giá vàng")) {
                            if (chatMessage.getMesage().trim().toLowerCase().equals(danhSachCauHoi.get(i).getCauHoi().trim().toLowerCase())) {
                                GiaVang giaVang = new GiaVang();
                                chatMessageBot = giaVang.giaVang(MainActivity.this, chatMessage.getMesage().trim().toLowerCase());
                                break;
                            }
                        } else if (chatMessage.getMesage().toLowerCase().trim().contains("thời tiết") ||
                                chatMessage.getMesage().toLowerCase().trim().contains("dự báo thời tiết")) {
                            DuBaoThoiTiet duBaoThoiTiet = new DuBaoThoiTiet();
                            chatMessageBot = duBaoThoiTiet.duBaoThoiTiet(MainActivity.this, chatMessage.getMesage().toLowerCase().trim());
                            break;
                        } else if (chatMessage.getMesage().toLowerCase().trim().contains("bảng xếp hạng") ||
                                chatMessage.getMesage().toLowerCase().trim().contains("xếp hạng") ||
                                chatMessage.getMesage().toLowerCase().trim().contains("thi đấu") ||
                                chatMessage.getMesage().toLowerCase().trim().contains("lịch thi đấu")) {
                            BangXepHang_LichThiDau bangXepHang_lichThiDau = new BangXepHang_LichThiDau();
                            chatMessageBot = bangXepHang_lichThiDau.hienThiBXH_LTD(MainActivity.this, chatMessage.getMesage().toLowerCase().trim());
                            break;
                        } else if (i == danhSachCauHoi.size() - 1) {
                            ArrayList<String> khongHieuYeuCau = new ArrayList<String>();
                            for (int j = 0; j < danhSachCauHoi.size(); j++) {
                                if (danhSachCauHoi.get(j).getLoaiCauHoi().equals("không hiểu yêu cầu")) {
                                    khongHieuYeuCau.add(danhSachCauHoi.get(j).getCauHoi());
                                }
                            }
                            int chonsoNgauNhien = new Random().nextInt(khongHieuYeuCau.size());
                            chatMessageBot.setMesage(khongHieuYeuCau.get(chonsoNgauNhien) + " " + tenCuaBan.toUpperCase());
                            break;
                        }


                    }


                    displayMessage(chatMessage);
                    displayMessage(chatMessageBot);
                }
                break;
            }

        }
    }

    // hien thi listView và sự thay đổi khi nhập giọng nói
    public void displayMessage(ChatMessage message) {
        adapter.add(message);
        adapter.notifyDataSetChanged();
        scroll();
    }

    private void scroll() {
        messagesContainer.setSelection(messagesContainer.getCount() - 1);
    }

    private void loadDummyHistory() {
        danhSachCauHoi = database_cauHoi.layDanhSachCauHoi();
        if (danhSachCauHoi.size() != 0) {
            ArrayList<String> chaoHoi = new ArrayList<String>();
            for (int i = 0; i < danhSachCauHoi.size(); i++) {
                if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("Lời chào ban đầu")) {
                    chaoHoi.add(danhSachCauHoi.get(i).getCauHoi());
                }
            }

            Random random = new Random();
            int chonSoNgauNhien = random.nextInt(chaoHoi.size());

            // lấy ra tên của ban
            sharedPreferences = getSharedPreferences("CAIDAT_KIEMTRATENCUABAN", MODE_PRIVATE);
            boolean kiemTraTenCuaBan = sharedPreferences.getBoolean("kiemtratencuaban", false);
            tenCuaBan = "";
            if (kiemTraTenCuaBan) {
                // lấy ra tên của ban
                sharedPreferences = getSharedPreferences("CAIDAT_TENCUABAN", MODE_PRIVATE);
                tenCuaBan = " - " + sharedPreferences.getString("tencuaban", "");
            }

            SimpleDateFormat format = new SimpleDateFormat("hh:mm dd-MM-yyyy");
            ChatMessage msg = new ChatMessage();
            msg.setIsMe(false);
            msg.setMesage(chaoHoi.get(chonSoNgauNhien) + " " + tenCuaBan.toUpperCase());
            msg.setDateTime(format.format(new Date()));
            chatHistory.add(msg);

            adapter = new ChatAdapter(MainActivity.this, new ArrayList<ChatMessage>());
            messagesContainer.setAdapter(adapter);

            displayMessage(msg);
        } else {


            SimpleDateFormat format = new SimpleDateFormat("hh:mm dd-MM-yyyy");
            ChatMessage msg = new ChatMessage();
            msg.setIsMe(false);
            msg.setMesage("Hi, tôi rất vui được gặp bạn");
            msg.setDateTime(format.format(new Date()));
            chatHistory.add(msg);

            adapter = new ChatAdapter(MainActivity.this, new ArrayList<ChatMessage>());
            messagesContainer.setAdapter(adapter);

            displayMessage(msg);
        }
    }

    // anh xạ
    private void init() {
        btnSpeak = (ImageButton) findViewById(R.id.btnSpeak);
        messagesContainer = (ListView) findViewById(R.id.messagesContainer);
        fabCaiDat = (FloatingActionButton) findViewById(R.id.fab_menu_caidat);
        fabChiaSe = (FloatingActionButton) findViewById(R.id.fab_menu_chiase);
        fabDanhGia = (FloatingActionButton) findViewById(R.id.fab_menu_danhgia);
        fabThongTin = (FloatingActionButton) findViewById(R.id.fab_menu_thongtin);
        fabCaiDat.setOnClickListener(this);
        fabChiaSe.setOnClickListener(this);
        fabDanhGia.setOnClickListener(this);
        fabThongTin.setOnClickListener(this);

        // khoi tao du lieu
        // Khởi tạo progressBar với đối là Context
        progressBar = new ProgressDialog(MainActivity.this);
        // Cho phép hủy progressBar nếu ấn nút Back
        progressBar.setCancelable(false);
        // Đặt tiêu đề cho ProgressBar
        progressBar.setMessage("Loading data......\nPlease wait");
        // Đặt giao diện cho ProgressBar
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        database_cauHoi = new Database_CauHoi(MainActivity.this);

//        if (danhSachCauHoiDatabase.size() == 0) {
//            progressBar.show();
//            handler = new Handler();
//            handler.removeCallbacks(capNhatThoiGian);
//            handler.postDelayed(capNhatThoiGian, 1000);
//        }

        // Tạo một luồng xử lý công việc.
        TaoDuLieu taoDuLieu = new TaoDuLieu();
        Thread t = new Thread(taoDuLieu);
        t.start();

        loadDummyHistory();
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.fab_menu_caidat) {
            startActivity(new Intent(MainActivity.this, CaiDatChung.class));
        }
        if (id == R.id.fab_menu_thongtin) {
            Intent intent = new Intent(MainActivity.this, ThongTinUngDung.class);
            startActivity(intent);
        }
        if (id == R.id.fab_menu_chiase) {
            FacebookSdk.sdkInitialize(this.getApplicationContext());
            callbackManager = CallbackManager.Factory.create();

            shareDialog = new ShareDialog(this);
            shareDialog.registerCallback(
                    callbackManager,
                    shareCallBack);


            canPresentShareDialog = ShareDialog.canShow(ShareLinkContent.class);
            if (canPresentShareDialog) {
                ShareLinkContent linkContent = new ShareLinkContent.Builder()
                        .setContentTitle("Ứng dụng Trợ Lý Ảo cho người Việt")
                        .setContentDescription("Đơn giản và Hiệu quả")
                        .setQuote("Virtual assistant for Vietnamese")
                        .setContentUrl(Uri.parse("https://play.google.com/store/search?q=tr%E1%BB%A3%20l%C3%BD%20%E1%BA%A3o%20VA&c=apps"))
                        .setImageUrl(Uri.parse("http://www.mykitchenshrink.com/wp-content/uploads/2014/01/Icon-microphone.png"))
                        .build();
                shareDialog.show(linkContent, ShareDialog.Mode.AUTOMATIC);
            } else {
                Toast.makeText(MainActivity.this, "Không thành công", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        sharedPreferences = this.getSharedPreferences("BUBBLE", MODE_PRIVATE);
        showBubbleView = sharedPreferences.getInt("bubble", 0);
        if (showBubbleView == 1) {
//            initializeBubblesManager();
//            addNewBubble();
            //bubblesManager.recycle();
            showBubbleView++;
            editor = sharedPreferences.edit();
            editor.clear();
            editor.putInt("bubble", showBubbleView);
            editor.putBoolean("bubble_boolean", true);
            editor.commit();
            Log.d("resume 1", "" + showBubbleView);
            return;
        } else if (showBubbleView == 2) {
            initializeBubblesManager();
            addNewBubble();
            //bubblesManager.recycle();
            showBubbleView++;
            editor = sharedPreferences.edit();
            editor.clear();
            editor.putInt("bubble", showBubbleView);
            editor.putBoolean("bubble_boolean", true);
            editor.commit();
            Log.d("resume 2", "" + showBubbleView);
            return;
        }
    }

    // tao du lieu
    private class TaoDuLieu implements Runnable {
        @Override
        public void run() {
            database_cauHoi = new Database_CauHoi(MainActivity.this);
            database_cauHoi.xoaToanboDulieu();
            danhSachCauHoiDatabase = database_cauHoi.layDanhSachCauHoi();
            if (danhSachCauHoiDatabase.size() == 0) {
                KhoiTaoDuLieu khoiTao_duLieu = new KhoiTaoDuLieu(MainActivity.this);
            }
        }
    }

//    private Runnable capNhatThoiGian = new Runnable() {
//        @Override
//        public void run() {
//            demNguoc--;
//            if (demNguoc == 0) {
//                progressBar.dismiss();
//                handler.removeCallbacks(capNhatThoiGian);
//                Log.d("taoDemNguoc", "ket thuc dialog");
//            }
//            handler.postDelayed(capNhatThoiGian, 1000);
//        }
//    };

}
