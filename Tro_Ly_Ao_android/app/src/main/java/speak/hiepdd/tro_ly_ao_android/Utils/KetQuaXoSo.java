package speak.hiepdd.tro_ly_ao_android.Utils;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import speak.hiepdd.tro_ly_ao_android.Database.Database_CauHoi;
import speak.hiepdd.tro_ly_ao_android.Model.CauHoi;
import speak.hiepdd.tro_ly_ao_android.Model.ChatMessage;
import speak.hiepdd.tro_ly_ao_android.R;

/**
 * Created by hiepdd on 01/10/2016.
 */
public class KetQuaXoSo {
    private Database_CauHoi database_cauHoi;
    private ArrayList<CauHoi> danhSachCauHoi = new ArrayList<CauHoi>();
    private ArrayList<CauHoi> ketQuaXoSo_mienBac = new ArrayList<CauHoi>();
    private ArrayList<CauHoi> ketQuaXoSo_mienNam = new ArrayList<CauHoi>();
    private ArrayList<CauHoi> ketQuaXoSo_mienNamTrung = new ArrayList<CauHoi>();

    private Context context;
    private String loaiXoSo[] = {"miền bắc", "miền nam", "miền trung"};
    private String xoSo = loaiXoSo[0];

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm dd:MM:yyyy");
    ChatMessage chatMessage = new ChatMessage();

    public KetQuaXoSo(Context context) {
        this.context = context;
    }


    public ChatMessage ketQuaXoSo_mienBac(Activity activity, String giongNoi) {
        database_cauHoi = new Database_CauHoi(activity);
        danhSachCauHoi = database_cauHoi.layDanhSachCauHoi();

        // loại xổ số được chọn
        xoSo = loaiXoSo[0];

        // lấy danh sách câu hỏi mở ket qua xo so
        for (int i = 0; i < danhSachCauHoi.size(); i++) {
            if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("xổ số miền bắc")) {
                CauHoi cauHoi = new CauHoi();
                cauHoi.setId(danhSachCauHoi.get(i).getId());
                cauHoi.setLoaiCauHoi(danhSachCauHoi.get(i).getLoaiCauHoi());
                cauHoi.setCauHoi(danhSachCauHoi.get(i).getCauHoi());
                ketQuaXoSo_mienBac.add(cauHoi);
            }
        }

        chatMessage.setIsMe(false);
        chatMessage.setDateTime(simpleDateFormat.format(new Date()));


        for (int i = 0; i < ketQuaXoSo_mienBac.size(); i++) {
            if (giongNoi.trim().toLowerCase().equals(ketQuaXoSo_mienBac.get(i).getCauHoi())) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        new readXML_xoSoMienBac().execute("http://xskt.com.vn/rss-feed/mien-bac-xsmb.rss");
                    }
                });

                chatMessage.setDateTime("Đã tìm thây kết quả xổ số miền Bắc");
                break;

            }
        }

        return chatMessage;
    }


    public ChatMessage ketQuaXoSo_mienNam(Activity activity, String giongNoi) {
        database_cauHoi = new Database_CauHoi(activity);
        danhSachCauHoi = database_cauHoi.layDanhSachCauHoi();

        // loại xổ số được chọn
        xoSo = loaiXoSo[1];

        // lấy danh sách câu hỏi mở ket qua xo so
        for (int i = 0; i < danhSachCauHoi.size(); i++) {
            if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("xổ số miền nam")) {
                CauHoi cauHoi = new CauHoi();
                cauHoi.setId(danhSachCauHoi.get(i).getId());
                cauHoi.setLoaiCauHoi(danhSachCauHoi.get(i).getLoaiCauHoi());
                cauHoi.setCauHoi(danhSachCauHoi.get(i).getCauHoi());
                ketQuaXoSo_mienNam.add(cauHoi);
            }
        }

        chatMessage.setIsMe(false);
        chatMessage.setDateTime(simpleDateFormat.format(new Date()));


        for (int i = 0; i < ketQuaXoSo_mienNam.size(); i++) {
            if (giongNoi.trim().toLowerCase().equals(ketQuaXoSo_mienNam.get(i).getCauHoi())) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        new readXML_xoSoMienBac().execute("http://xskt.com.vn/rss-feed/mien-nam-xsmn.rss");
                    }
                });

                chatMessage.setDateTime("Đã tìm thây kết quả xổ số miền Nam");
                break;

            }
        }

        return chatMessage;
    }

    public ChatMessage ketQuaXoSo_mienTrung(Activity activity, String giongNoi) {
        database_cauHoi = new Database_CauHoi(activity);
        danhSachCauHoi = database_cauHoi.layDanhSachCauHoi();

        // loại xổ số được chọn
        xoSo = loaiXoSo[2];

        // lấy danh sách câu hỏi mở ket qua xo so
        for (int i = 0; i < danhSachCauHoi.size(); i++) {
            if (danhSachCauHoi.get(i).getLoaiCauHoi().equals("xổ số miền trung")) {
                CauHoi cauHoi = new CauHoi();
                cauHoi.setId(danhSachCauHoi.get(i).getId());
                cauHoi.setLoaiCauHoi(danhSachCauHoi.get(i).getLoaiCauHoi());
                cauHoi.setCauHoi(danhSachCauHoi.get(i).getCauHoi());
                ketQuaXoSo_mienNamTrung.add(cauHoi);
            }
        }

        chatMessage.setIsMe(false);
        chatMessage.setDateTime(simpleDateFormat.format(new Date()));


        for (int i = 0; i < ketQuaXoSo_mienNamTrung.size(); i++) {
            if (giongNoi.trim().toLowerCase().equals(ketQuaXoSo_mienNamTrung.get(i).getCauHoi())) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        new readXML_xoSoMienBac().execute("http://xskt.com.vn/rss-feed/mien-trung-xsmt.rss");
                    }
                });

                chatMessage.setDateTime("Đã tìm thây kết quả xổ số miền Trung");
                break;

            }
        }

        return chatMessage;
    }

    // tao class async
    class readXML_xoSoMienBac extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... params) {
            String data = readDataFromUrl(params[0]);
            return data;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            XMLDOMParser parser = new XMLDOMParser();
            Document document = parser.getDocument(s);
            NodeList nodeList = document.getElementsByTagName("item");

            final ArrayList<speak.hiepdd.tro_ly_ao_android.Model.KetQuaXoSo> danhSachKetQua = new ArrayList<speak.hiepdd.tro_ly_ao_android.Model.KetQuaXoSo>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                speak.hiepdd.tro_ly_ao_android.Model.KetQuaXoSo ketQuaXoSo = new speak.hiepdd.tro_ly_ao_android.Model.KetQuaXoSo();
                ketQuaXoSo.setTitle(parser.getValue(element, "title"));
                ketQuaXoSo.setDescription(parser.getValue(element, "description"));
                ketQuaXoSo.setLinks(parser.getValue(element, "link"));
                danhSachKetQua.add(ketQuaXoSo);
            }

            // hiển thị lên hộp thoại thông báo
            final AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setIcon(R.drawable.icon_xoso);
            builder.setTitle(danhSachKetQua.get(0).getTitle());
            builder.setMessage(danhSachKetQua.get(0).getDescription());
            final String arrXoSo[] = new String[danhSachKetQua.size()];
            builder.setNegativeButton("Những ngày trước", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    String chuoi = "";
                    for (int i = 0; i < danhSachKetQua.size(); i++) {
                        arrXoSo[i] = danhSachKetQua.get(i).getTitle() + "\n" + danhSachKetQua.get(i).getDescription();
                        chuoi = chuoi + arrXoSo[i] + "\n\n\n";

                    }
                    builder.setTitle("Các ngày trước đó");
                    builder.setIcon(R.drawable.icon_xoso);
                    builder.setMessage(chuoi);
                    builder.show();
                }
            });

            builder.setNeutralButton("Xem đầy đủ trên web", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                    if (xoSo.equals(loaiXoSo[0]))
                        intent.putExtra(SearchManager.QUERY, "http://xskt.com.vn/ket-qua-xo-so/mien-bac/mien-bac-xsmb.html");
                    else if (xoSo.equals(loaiXoSo[1]))
                        intent.putExtra(SearchManager.QUERY, "http://xskt.com.vn/ket-qua-xo-so/mien-nam/mien-nam-xsmn.html");
                    else if (xoSo.equals(loaiXoSo[2]))
                        intent.putExtra(SearchManager.QUERY, "http://xskt.com.vn/ket-qua-xo-so/mien-trung/mien-trung-xsmt.html");
                    context.startActivity(intent);
                }
            });

            builder.setPositiveButton("Hủy bỏ", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.show();

        }
    }

    //read data from internet
    private static String readDataFromUrl(String theUrl) {
        StringBuilder content = new StringBuilder();

        try {
            // create a url object
            URL url = new URL(theUrl);

            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();

            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}
