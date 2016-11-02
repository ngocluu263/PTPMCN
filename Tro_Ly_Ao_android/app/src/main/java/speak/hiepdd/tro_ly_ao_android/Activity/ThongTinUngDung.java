package speak.hiepdd.tro_ly_ao_android.Activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.List;

import speak.hiepdd.tro_ly_ao_android.R;

public class ThongTinUngDung extends AppCompatActivity {
    private Button btthongTinUngDung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_ung_dung);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_thongTinUngDung);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.thongtin);

        btthongTinUngDung = (Button)findViewById(R.id.button_thongTinUngDung);
        btthongTinUngDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(createEmailIntent());
            }
        });
    }

    // gui mail
    public  Intent createEmailIntent()
    {
        String toEmail= "donghiep1995@gmail.com";

        String release = Build.VERSION.RELEASE;
        int SDK = Build.VERSION.SDK_INT;
        String codename = Build.VERSION.CODENAME;
        PackageManager manager = getPackageManager();
        PackageInfo info = null;
        try {
            info = manager.getPackageInfo(
                    this.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String version1 = info.versionName;
        String subject = "Hồi đáp từ Android";
        String message = "--------------------\nApp information:\n\nCodeName :" + codename + "\nAPI Level: " + SDK + "\nVersion: " + release +
                "\nApp version: " + version1 + "\nUsername: "  + "\n--------------------\n";

        Intent sendTo = new Intent(Intent.ACTION_SENDTO);
        String uriText = "mailto:" + Uri.encode(toEmail) +
                "?subject=" + Uri.encode(subject) +
                "&body=" + Uri.encode(message);
        Uri uri = Uri.parse(uriText);
        sendTo.setData(uri);
        List<ResolveInfo> resolveInfos =
                getPackageManager().queryIntentActivities(sendTo, 0);

        // Emulators may not like this check...
        if (!resolveInfos.isEmpty())
        {
            return sendTo;
        }

        // Nothing resolves send to, so fallback to send...
        Intent send = new Intent(Intent.ACTION_SEND);

        send.setType("text/plain");
        send.putExtra(Intent.EXTRA_EMAIL,
                new String[] { toEmail });
        send.putExtra(Intent.EXTRA_SUBJECT, subject);
        send.putExtra(Intent.EXTRA_TEXT, message);

        return Intent.createChooser(send, "Gửi Gmail cho nhà phát triển");
    }
}
