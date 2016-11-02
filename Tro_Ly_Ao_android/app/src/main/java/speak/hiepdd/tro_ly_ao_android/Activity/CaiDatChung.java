package speak.hiepdd.tro_ly_ao_android.Activity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;

import speak.hiepdd.tro_ly_ao_android.R;

public class CaiDatChung extends AppCompatActivity {
    private SwitchCompat swtenCuaBan, swtatAmThanh;
    private SharedPreferences sharedPreferences, sharedPreferences1, sharedPreferences2;
    private SharedPreferences.Editor editor, editor1, editor2;

    private String tenCuaBan = "";
    private boolean kiemTraTenCuaBan;
    private boolean tatAmBao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cai_dat_chung);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_caiDatChung);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(R.string.caidat);




        init();

        caiDat();

    }

    // anh xa
    private void init(){
        swtenCuaBan = (SwitchCompat)findViewById(R.id.switchcompat_tenCuaBan);
        swtatAmThanh = (SwitchCompat)findViewById(R.id.switchcompat_tatAmBao);

        // âm báo
        sharedPreferences = getSharedPreferences("CATDAT_AMBAO", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        tatAmBao = sharedPreferences.getBoolean("tatambao", false);
        if(tatAmBao){
            swtatAmThanh.setChecked(true);
        }else {
            swtatAmThanh.setChecked(false);
        }

        // tên của bạn
        sharedPreferences1 = getSharedPreferences("CAIDAT_TENCUABAN", MODE_PRIVATE);
        editor1 = sharedPreferences1.edit();
        tenCuaBan = sharedPreferences1.getString("tencuaban","");

        // kiểm tra tên của bạn
        sharedPreferences2 = getSharedPreferences("CAIDAT_KIEMTRATENCUABAN", MODE_PRIVATE);
        editor2 = sharedPreferences2.edit();
        kiemTraTenCuaBan = sharedPreferences2.getBoolean("kiemtratencuaban", false);
        if(kiemTraTenCuaBan){
            swtenCuaBan.setChecked(true);
            swtenCuaBan.setText("TÊN CỦA BẠN : "+tenCuaBan+"\n\nTên dùng để hiển thị giao tiếp với Trợ Lý Ảo");
        }else {
            swtenCuaBan.setChecked(false);
            swtenCuaBan.setText("TÊN CỦA BẠN" + "\n\nTên dùng để hiển thị giao tiếp với Trợ Lý Ảo");
        }


    }

    // cai dat
    private void caiDat(){
        // tắt âm thanh
        swtatAmThanh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    tatAmBao = true;
                    editor.clear();
                    editor.putBoolean("tatambao", tatAmBao);
                    editor.commit();
                    Log.d("am bao2", "" + tatAmBao);
                }
                else{
                    tatAmBao = false;
                    editor.clear();
                    editor.putBoolean("tatambao", tatAmBao);
                    editor.commit();
                    Log.d("am bao2", "" + tatAmBao);
                }
            }
        });

        // kiểm tra tên của bạn
        swtenCuaBan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    kiemTraTenCuaBan = true;
                    editor2.clear();
                    editor2.putBoolean("kiemtratencuaban", kiemTraTenCuaBan);
                    editor2.commit();

                    // lay ra custon dialog
                    LayoutInflater inflater = getLayoutInflater();
                    View view = inflater.inflate(R.layout.custom_dialog_name, null);
                    final EditText edttenCuaBan = (EditText)view.findViewById(R.id.editTextcaiDatTen);

                    AlertDialog.Builder builder = new AlertDialog.Builder(CaiDatChung.this);
                    builder.setTitle(R.string.tencuaban);
                    builder.setIcon(R.drawable.icon_name);
                    builder.setView(view);
                    builder.setNegativeButton("Đồng Ý", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            editor1.clear();
                            editor1.putString("tencuaban", edttenCuaBan.getText().toString());
                            editor1.commit();

                            // hiển thị ra switch
                            swtenCuaBan.setText(android.text.Html.fromHtml("<b>TÊN CỦA BẠN : " + sharedPreferences1.getString("tencuaban","").toString().toUpperCase()+"</b>") + "\n\nTên dùng để hiển thị giao tiếp với Trợ Lý Ảo");
                        }
                    });
                    builder.show();
                }
                else{
                    editor2.clear();
                    kiemTraTenCuaBan = false;
                    editor2.putBoolean("kiemtratencuaban", kiemTraTenCuaBan);
                    editor2.commit();

                }
            }

        });
    }
}
