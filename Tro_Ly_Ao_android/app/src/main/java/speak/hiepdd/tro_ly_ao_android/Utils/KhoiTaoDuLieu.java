package speak.hiepdd.tro_ly_ao_android.Utils;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

import speak.hiepdd.tro_ly_ao_android.Database.Database_CauHoi;
import speak.hiepdd.tro_ly_ao_android.Model.CauHoi;

/**
 * Created by hiepdd on 14/09/2016.
 */
public class KhoiTaoDuLieu {
    private ArrayList<CauHoi> danhSachCauHoi = new ArrayList<CauHoi>();
    private Database_CauHoi database_cauHoi;

    public KhoiTaoDuLieu(Context context){
        database_cauHoi = new Database_CauHoi(context);
        database_cauHoi.xoaToanboDulieu();
        danhSachCauHoi = database_cauHoi.layDanhSachCauHoi();

        taoDuLieuCauHoi taoDuLieuCauHoi = new taoDuLieuCauHoi();
        Thread thread = new Thread(taoDuLieuCauHoi);
        thread.start();
    }


    private class taoDuLieuCauHoi implements Runnable{
        @Override
        public void run() {

                themCauHoi();


        }
    }

    private void themCauHoi(){

        // bật đèn flash
        database_cauHoi.themCauHoi(new CauHoi("bật đèn flash","bật đèn"));
        database_cauHoi.themCauHoi(new CauHoi("bật đèn flash","bật đèn flash"));
        database_cauHoi.themCauHoi(new CauHoi("bật đèn flash","bật đèn pin"));
        database_cauHoi.themCauHoi(new CauHoi("bật đèn flash","bật đèn chiếu sáng"));
        database_cauHoi.themCauHoi(new CauHoi("bật đèn flash","flash"));
        database_cauHoi.themCauHoi(new CauHoi("bật đèn flash","đèn pin"));
        database_cauHoi.themCauHoi(new CauHoi("bật đèn flash","đèn pin bật"));
        database_cauHoi.themCauHoi(new CauHoi("bật đèn flash","bật flash"));
        database_cauHoi.themCauHoi(new CauHoi("bật đèn flash","mở flash"));
        database_cauHoi.themCauHoi(new CauHoi("bật đèn flash","mở đèn pin"));
        database_cauHoi.themCauHoi(new CauHoi("bật đèn flash","mở đèn flash"));
        database_cauHoi.themCauHoi(new CauHoi("bật đèn flash","mở đèn"));

        // tắt đèn flash
        database_cauHoi.themCauHoi(new CauHoi("tắt đèn flash","tắt đèn"));
        database_cauHoi.themCauHoi(new CauHoi("tắt đèn flash","tắt đèn flash"));
        database_cauHoi.themCauHoi(new CauHoi("tắt đèn flash","tắt đèn pin"));
        database_cauHoi.themCauHoi(new CauHoi("tắt đèn flash","tăt đèn chiếu sáng"));
        database_cauHoi.themCauHoi(new CauHoi("tắt đèn flash","tắt flash"));
        database_cauHoi.themCauHoi(new CauHoi("tắt đèn flash","tắt chiêu sáng"));
        database_cauHoi.themCauHoi(new CauHoi("tắt đèn flash","flash tắt"));
        database_cauHoi.themCauHoi(new CauHoi("tắt đèn flash","flash đóng"));
        database_cauHoi.themCauHoi(new CauHoi("tắt đèn flash","đóng đèn pin"));
        database_cauHoi.themCauHoi(new CauHoi("tắt đèn flash","dừng chiếu sáng"));
        database_cauHoi.themCauHoi(new CauHoi("tắt đèn flash","dừng đèn pin"));
        database_cauHoi.themCauHoi(new CauHoi("tắt đèn flash","dừng đèn flash"));
        // đọc báo
        database_cauHoi.themCauHoi(new CauHoi("đọc báo","đọc báo"));
        database_cauHoi.themCauHoi(new CauHoi("đọc báo","xem tin tức"));
        database_cauHoi.themCauHoi(new CauHoi("đọc báo","mở ứng dụng đọc báo"));
        database_cauHoi.themCauHoi(new CauHoi("đọc báo","mở ứng dụng xem tin tức"));
        database_cauHoi.themCauHoi(new CauHoi("đọc báo","tôi muốn đọc báo"));
        database_cauHoi.themCauHoi(new CauHoi("đọc báo","tôi muốn xem tin tức"));
        database_cauHoi.themCauHoi(new CauHoi("đọc báo","mở đọc báo"));
        database_cauHoi.themCauHoi(new CauHoi("đọc báo","báo"));
        database_cauHoi.themCauHoi(new CauHoi("đọc báo","tin tức"));
        // địa điểm nổi tiếng ở Hà Nội
        database_cauHoi.themCauHoi(new CauHoi("địa điểm","tìm địa điểm"));
        database_cauHoi.themCauHoi(new CauHoi("địa điểm","tìm địa điểm du lịch"));
        database_cauHoi.themCauHoi(new CauHoi("địa điểm","tìm địa điểm nổi tiếng"));
        database_cauHoi.themCauHoi(new CauHoi("địa điểm","tìm địa điểm du lịch ở hà nội"));
        database_cauHoi.themCauHoi(new CauHoi("địa điểm","tìm địa điểm nổi tiếng ở hà nội"));
        database_cauHoi.themCauHoi(new CauHoi("địa điểm","địa điểm du lịch"));
        database_cauHoi.themCauHoi(new CauHoi("địa điểm","địa điểm nổi tiếng"));
        database_cauHoi.themCauHoi(new CauHoi("địa điểm","địa điểm"));
        // kiểm tra tài khoản chính
        database_cauHoi.themCauHoi(new CauHoi("kiểm tra tài khoản chính","kiểm tra tài khoản chính"));
        database_cauHoi.themCauHoi(new CauHoi("kiểm tra tài khoản chính","kiểm tra tiền tài khoản chính"));
        database_cauHoi.themCauHoi(new CauHoi("kiểm tra tài khoản chính","kiểm tra tài khoản gốc"));
        database_cauHoi.themCauHoi(new CauHoi("kiểm tra tài khoản chính","kiểm tra tiền tài khoản gốc"));
        database_cauHoi.themCauHoi(new CauHoi("kiểm tra tài khoản chính","kiểm tra tài khoản"));
        database_cauHoi.themCauHoi(new CauHoi("kiểm tra tài khoản chính","tài khoản chính"));
        database_cauHoi.themCauHoi(new CauHoi("kiểm tra tài khoản chính","tài khoản gốc"));
        database_cauHoi.themCauHoi(new CauHoi("kiểm tra tài khoản chính","tiền tài khoản chính"));
        database_cauHoi.themCauHoi(new CauHoi("kiểm tra tài khoản chính","tiền của tài khoản chính"));
        database_cauHoi.themCauHoi(new CauHoi("kiểm tra tài khoản chính","tiền tài khoản gốc"));
        database_cauHoi.themCauHoi(new CauHoi("kiểm tra tài khoản chính","tiền của tài khoản gốc"));
        database_cauHoi.themCauHoi(new CauHoi("kiểm tra tài khoản chính","tài khoản chính còn bao nhiêu tiền"));
        database_cauHoi.themCauHoi(new CauHoi("kiểm tra tài khoản chính","tài khoản gốc còn bao nhiêu tiền"));

        // kiểm tra tài khoản khuyến mại
        database_cauHoi.themCauHoi(new CauHoi("kiểm tra tài khoản phụ","kiểm tra tài khoản khuyến mãi"));
        database_cauHoi.themCauHoi(new CauHoi("kiểm tra tài khoản phụ","kiểm tra tài khoản khuyến mại"));
        database_cauHoi.themCauHoi(new CauHoi("kiểm tra tài khoản phụ","kiểm tra tài khoản phụ"));
        database_cauHoi.themCauHoi(new CauHoi("kiểm tra tài khoản phụ","kiểm tra tiền tài khoản khuyến mãi"));
        database_cauHoi.themCauHoi(new CauHoi("kiểm tra tài khoản phụ","kiểm tra tiền tài khoản khuyến mại"));
        database_cauHoi.themCauHoi(new CauHoi("kiểm tra tài khoản phụ","kiểm tra tiền tài khoản phụ"));
        database_cauHoi.themCauHoi(new CauHoi("kiểm tra tài khoản phụ","tiền tài khoản phụ"));
        database_cauHoi.themCauHoi(new CauHoi("kiểm tra tài khoản phụ","tiền tài khoản khuyễn mãi"));
        database_cauHoi.themCauHoi(new CauHoi("kiểm tra tài khoản phụ","tiền tài khoản khuyễn mại"));
        database_cauHoi.themCauHoi(new CauHoi("kiểm tra tài khoản phụ","tài khoản khuyễn mãi"));
        database_cauHoi.themCauHoi(new CauHoi("kiểm tra tài khoản phụ","tài khoản khuyễn mại"));
        database_cauHoi.themCauHoi(new CauHoi("kiểm tra tài khoản phụ","tài khoản phụ"));

        // tăng độ sáng màn hình
        database_cauHoi.themCauHoi(new CauHoi("tăng độ sáng màn hình","tăng độ sáng màn hình"));
        database_cauHoi.themCauHoi(new CauHoi("tăng độ sáng màn hình","tăng độ sáng"));
        database_cauHoi.themCauHoi(new CauHoi("tăng độ sáng màn hình","sáng màn hình"));
        database_cauHoi.themCauHoi(new CauHoi("tăng độ sáng màn hình","tăng cường độ sáng màn hình"));
        database_cauHoi.themCauHoi(new CauHoi("tăng độ sáng màn hình","tăng cường độ chiếu sáng"));
        database_cauHoi.themCauHoi(new CauHoi("tăng độ sáng màn hình","tăng chiếu sáng"));
        database_cauHoi.themCauHoi(new CauHoi("tăng độ sáng màn hình","sáng lên"));
        database_cauHoi.themCauHoi(new CauHoi("tăng độ sáng màn hình","tăng độ sáng màn hình một chút"));
        database_cauHoi.themCauHoi(new CauHoi("tăng độ sáng màn hình","sáng màn hình"));
        database_cauHoi.themCauHoi(new CauHoi("tăng độ sáng màn hình","nâng độ sáng màn hình"));
        database_cauHoi.themCauHoi(new CauHoi("tăng độ sáng màn hình","nâng độ sáng"));
        database_cauHoi.themCauHoi(new CauHoi("tăng độ sáng màn hình","nâng chiếu sáng"));

        // giảm độ sáng màn hình
        database_cauHoi.themCauHoi(new CauHoi("giảm độ sáng màn hình","giảm độ sáng màn hình"));
        database_cauHoi.themCauHoi(new CauHoi("giảm độ sáng màn hình","giảm độ sáng"));
        database_cauHoi.themCauHoi(new CauHoi("giảm độ sáng màn hình","giảm chiếu sáng"));
        database_cauHoi.themCauHoi(new CauHoi("giảm độ sáng màn hình","giảm ánh sáng màn hình"));
        database_cauHoi.themCauHoi(new CauHoi("giảm độ sáng màn hình","giảm ánh sáng"));
        database_cauHoi.themCauHoi(new CauHoi("giảm độ sáng màn hình","hạ thấp ánh sáng màn hình"));
        database_cauHoi.themCauHoi(new CauHoi("giảm độ sáng màn hình","hạ ánh sáng màn hình"));
        database_cauHoi.themCauHoi(new CauHoi("giảm độ sáng màn hình","hạ thấp ánh sáng"));
        database_cauHoi.themCauHoi(new CauHoi("giảm độ sáng màn hình","giảm cường độ sáng"));
        database_cauHoi.themCauHoi(new CauHoi("giảm độ sáng màn hình","giảm cường độ sáng màn hình"));
        database_cauHoi.themCauHoi(new CauHoi("giảm độ sáng màn hình","hạ ánh sáng"));
        database_cauHoi.themCauHoi(new CauHoi("giảm độ sáng màn hình","hạ chiếu sáng"));
        database_cauHoi.themCauHoi(new CauHoi("giảm độ sáng màn hình","hạ cường độ sáng"));

        // mở ứng dụng
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng facebook","facebook"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng facebook","bật facebook"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng facebook","mở facebook"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng facebook","mở ứng dụng facebook"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng facebook","mở cho tôi facebook"));

        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng messenger","messenger"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng messenger","bật messenger"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng messenger","mở messenger"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng messenger","mở ứng dụng messenger"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng messenger","mở cho tôi messenger"));


        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng zing","zing mp3"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng zing","bật zing mp3"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng zing","mở zing mp3"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng zing","mở ứng dụng zing mp3"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng zing","mở cho tôi zing mp3"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng zing","nghe nhạc"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng zing","mở nghe nhạc"));

        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng zalo","zalo"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng zalo","bật zalo"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng zalo","mở zalo"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng zalo","mở ứng dụng zalo"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng zalo","mở cho tôi zalo"));

        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng danh bạ","danh bạ"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng danh bạ","danh bạ của tôi"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng danh bạ","mở danh bạ của tôi"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng danh bạ","xem danh bạ"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng danh bạ","bật danh bạ"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng danh bạ","mở danh bạ"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng danh bạ","mở ứng dụng danh bạ"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng danh bạ","mở cho tôi danh bạ"));

        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng cài đặt","cài đặt"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng cài đặt","setting"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng cài đặt","mở setting"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng cài đặt","cài đặt"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng cài đặt","bật cài đặt"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng cài đặt","mở cài đặt"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng cài đặt","mở ứng dụng cài đặt"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng cài đặt","mở cho tôi cài đặt"));

        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng youtube","youtube"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng youtube","xem youtube"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng youtube","bật youtube"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng youtube","mở youtube"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng youtube","mở ứng dụng youtube"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng youtube","mở cho tôi youtube"));

        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng email","email"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng email","email của tôi"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng email","mở email của tôi"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng email","xem email"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng email","bật email"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng email","mở email"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng email","mở ứng dụng email"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng email","mở cho tôi email"));

        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng trình duyệt","trình duyệt"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng trình duyệt","xem trình duyệt"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng trình duyệt","bật trình duyệt"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng trình duyệt","mở trình duyệt"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng trình duyệt","mở ứng dụng trình duyệt"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng trình duyệt","mở cho tôi trình duyệt"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng trình duyệt","google"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng trình duyệt","xem google"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng trình duyệt","bật google"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng trình duyệt","mở ứng dụng google"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng trình duyệt","mở google"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng trình duyệt","mở cho tôi google"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng trình duyệt","tìm kiếm"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng trình duyệt","xem tìm kiếm"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng trình duyệt","bật tìm kiếm"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng trình duyệt","mở ứng dụngtìm kiếm"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng trình duyệt","mở cho tôi tìm kiếm"));

        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng lịch","lịch"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng lịch","lịch của tôi"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng lịch","mở lịch của tôi"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng lịch","xem lịch"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng lịch","bật lịch"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng lịch","mở lịch"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng lịch","mở ứng dụng lịch"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng lịch","mở cho tôi lịch"));

        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng instagram","instagram"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng instagram","instagram của tôi"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng instagram","mở instagram của tôi"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng instagram","xem instagram"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng instagram","bật instagram"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng instagram","mở instagram"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng instagram","mở ứng dụng instagram"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng instagram","mở cho tôi instagram"));

        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng thư viện","thư viện"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng thư viện","thư viện của tôi"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng thư viện","mở thư viện của tôi"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng thư viện","xem thư viện"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng thư viện","bật thư viện"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng thư viện","mở thư viện"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng thư viện","mở ứng dụng thư viện"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng thư viện","mở cho tôi thư viện"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng thư viện","thư viện ảnh"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng thư viện","thư viện ảnh của tôi"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng thư viện","mở thư viện ảnh của tôi"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng thư viện","xem thư viện ảnh"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng thư viện","bật thư viện ảnh"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng thư viện","mở thư viện ảnh"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng thư viện","mở ứng dụng thư viện ảnh"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng thư viện","mở cho tôi thư viện ảnh"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng thư viện","mở ảnh"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng thư viện","xem ảnh"));

        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng bản đồ","bản đồ"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng bản đồ","bản đồ của tôi"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng bản đồ","mở bản đồ của tôi"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng bản đồ","xem bản đồ"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng bản đồ","bật bản đồ"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng bản đồ","mở bản đồ"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng bản đồ","mở ứng dụng bản đồ"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng bản đồ","mở cho tôi bản đồ"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng bản đồ","google map"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng bản đồ","google map của tôi"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng bản đồ","mở google map của tôi"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng bản đồ","xem google map"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng bản đồ","bật google map"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng bản đồ","mở google map"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng bản đồ","mở ứng dụng google map"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng bản đồ","mở cho tôi google map"));

        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng gmail","gmail"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng gmail","gmail của tôi"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng gmail","mở gmail của tôi"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng gmail","xem gmail"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng gmail","bật gmail"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng gmail","mở gmail"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng gmail","mở ứng dụng gmail"));
        database_cauHoi.themCauHoi(new CauHoi("mở ứng dụng gmail","mở cho tôi gmail"));

        // không hiểu yêu cầu
        database_cauHoi.themCauHoi(new CauHoi("không hiểu yêu cầu","tôi không hiểu ý của bạn cho lắm"));
        database_cauHoi.themCauHoi(new CauHoi("không hiểu yêu cầu","Bạn có thể nói rõ ràng được không"));
        database_cauHoi.themCauHoi(new CauHoi("không hiểu yêu cầu","Rất tiếc, tôi không hiểu bạn nói gì"));
        database_cauHoi.themCauHoi(new CauHoi("không hiểu yêu cầu","Bạn nói gì, tôi không hiểu"));
        database_cauHoi.themCauHoi(new CauHoi("không hiểu yêu cầu","Xin lỗi, tôi không thực hiện được yêu cầu này của bạn"));
        database_cauHoi.themCauHoi(new CauHoi("không hiểu yêu cầu","Tôi hơi mệt nên không thực hiện được yêu cầu này của bạn"));
        database_cauHoi.themCauHoi(new CauHoi("không hiểu yêu cầu","Hình như bạn nói sai gì đó thì phải"));
        database_cauHoi.themCauHoi(new CauHoi("không hiểu yêu cầu","Xin lỗi, tôi hơi ngốc nên không hiểu ý bạn cho lắm"));
        database_cauHoi.themCauHoi(new CauHoi("không hiểu yêu cầu","Vấn đề này quá sức của tôi rồi, haizz"));

        // lời chào ban đầu
        database_cauHoi.themCauHoi(new CauHoi("Lời chào ban đầu","Xin chào, tôi có thể giúp gì cho bạn"));
        database_cauHoi.themCauHoi(new CauHoi("Lời chào ban đầu","Chúc bạn một ngày học tập và làm việc vui vẻ"));
        database_cauHoi.themCauHoi(new CauHoi("Lời chào ban đầu","Hello, chúc bạn một ngày đầy niềm vui và hành phúc"));
        database_cauHoi.themCauHoi(new CauHoi("Lời chào ban đầu","Hi, tôi rât vui được gặp bạn"));
        database_cauHoi.themCauHoi(new CauHoi("Lời chào ban đầu","Xin chào, tôi sẽ là một trợ lý đắc lực của bạn"));
        database_cauHoi.themCauHoi(new CauHoi("Lời chào ban đầu","Xin chào"));
        database_cauHoi.themCauHoi(new CauHoi("Lời chào ban đầu","Hi, Bạn muốn tôi làm gì cho bạn"));

        // tìm vị trí nhà hàng gần nhất
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí nhà hàng","tìm nhà hàng quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí nhà hàng","nhà hàng quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí nhà hàng","danh sách nhà hàng"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí nhà hàng","nhà hàng gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí nhà hàng","tìm kiếm nhà hàng"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí nhà hàng","tìm kiếm nhà hàng gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí nhà hàng","tìm kiếm nhà hàng quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí nhà hàng","nhà hàng gần tôi nhất"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí nhà hàng","nhà hàng gần nhất"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí nhà hàng","đỉa chỉ các nhà hàng"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí nhà hàng","dịa chỉ các nhà hàng gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí nhà hàng","danh sách các nhà hàng gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí nhà hàng","các nhà hàng gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí nhà hàng","địa điểm ăn uống quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí nhà hàng","địa điểm ăn uống"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí nhà hàng","địa chỉa nhà hàng"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí nhà hàng","địa chỉ nhà hàng gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí nhà hàng","địa chỉ nhà hàng quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí nhà hàng","nhà hàng khu vực này"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí nhà hàng","các nhà hàng gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí nhà hàng","các nhà hàng quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí nhà hàng","các nhà hàng"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí nhà hàng","nhà hàng"));

        // tìm vị trí trạm xăng gần nhất
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí trạm xăng","tìm trạm xăng quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí trạm xăng","trạm xăng quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí trạm xăng","danh sách trạm xăng"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí trạm xăng","trạm xăng gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí trạm xăng","tìm kiếm trạm xăng"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí trạm xăng","tìm kiếm trạm xăng gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí trạm xăng","tìm kiếm trạm xăng quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí trạm xăng","trạm xăng gần tôi nhất"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí trạm xăng","trạm xăng gần nhất"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí trạm xăng","đỉa chỉ các trạm xăng"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí trạm xăng","dịa chỉ các trạm xăng gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí trạm xăng","danh sách các trạm xăng gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí trạm xăng","các trạm xăng gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí trạm xăng","địa điểm đổ xăng quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí trạm xăng","địa điểm đổ xăng"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí trạm xăng","địa chỉa trạm xăng"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí trạm xăng","địa chỉ trạm xăng gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí trạm xăng","địa chỉ trạm xăng quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí trạm xăng","trạm xăng khu vực này"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí trạm xăng","các trạm xăng gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí trạm xăng","các trạm xăng quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí trạm xăng","các trạm xăng"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí trạm xăng","trạm xăng"));

        // tìm vị trí ATM gần nhất
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí ATM","tìm atm quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí ATM","atm quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí ATM","danh sách atm"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí ATM","atm gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí ATM","tìm kiếm atm"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí ATM","tìm kiếm atm gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí ATM", "tìm kiếm atm quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí ATM","atm gần tôi nhất"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí ATM","atm gần nhất"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí ATM","đỉa chỉ các atm"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí ATM","dịa chỉ các atm gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí ATM","danh sách các atm gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí ATM","các atm gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí ATM","địa điểm atm quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí ATM","địa điểm rút tiền"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí ATM","địa chỉa atm"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí ATM","địa chỉ atm gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí ATM","địa chỉ atm quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí ATM","atm khu vực này"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí ATM","các atm gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí ATM","các atm quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí ATM","atm"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí ATM","các atm"));

        // tìm vị trí hiệu thuôc gần nhất
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí hiệu thuốc","tìm hiệu thuốc quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí hiệu thuốc","hiệu thuốc quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí hiệu thuốc","danh sách hiệu thuốc"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí hiệu thuốc","hiệu thuốc gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí hiệu thuốc","tìm kiếm hiệu thuốc"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí hiệu thuốc","tìm kiếm hiệu thuốc gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí hiệu thuốc","tìm kiếm hiệu thuốc quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí hiệu thuốc","hiệu thuốc gần tôi nhất"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí hiệu thuốc","hiệu thuốc gần nhất"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí hiệu thuốc","đỉa chỉ các hiệu thuốc"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí hiệu thuốc","dịa chỉ các hiệu thuốc gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí hiệu thuốc","danh sách các hiệu thuốc gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí hiệu thuốc","các hiệu thuốc gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí hiệu thuốc","địa điểm hiệu thuốc quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí hiệu thuốc","địa điểm hiệu thuốc"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí hiệu thuốc","địa chỉa hiệu thuốc"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí hiệu thuốc","địa chỉ hiệu thuốc gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí hiệu thuốc","địa chỉ hiệu thuốc quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí hiệu thuốc","hiệu thuốc khu vực này"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí hiệu thuốc","các hiệu thuốc gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí hiệu thuốc","các hiệu thuốc quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí hiệu thuốc","hiệu thuốc"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí hiệu thuốc","các hiệu thuốc"));

        // tìm vị trí khách sạn gần nhất
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí khách sạn","tìm khách sạn quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí khách sạn","khách sạn quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí khách sạn","danh sách khách sạn"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí khách sạn","khách sạn gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí khách sạn","tìm kiếm khách sạn"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí khách sạn","tìm kiếm khách sạn gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí khách sạn","tìm kiếm khách sạn quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí khách sạn","khách sạn gần tôi nhất"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí khách sạn","khách sạn gần nhất"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí khách sạn","đỉa chỉ các khách sạn"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí khách sạn","dịa chỉ các khách sạn gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí khách sạn","danh sách các khách sạn gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí khách sạn","các khách sạn gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí khách sạn","địa điểm khách sạn quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí khách sạn","địa điểm khách sạn"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí khách sạn","địa chỉa khách sạn"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí khách sạn","địa chỉ khách sạn gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí khách sạn","địa chỉ khách sạn quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí khách sạn","khách sạn khu vực này"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí khách sạn","các khách sạn gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí khách sạn","các khách sạn quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí khách sạn","khách sạn"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí khách sạn","các khách sạn"));

        // tìm vị trí quán bar gần nhất
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí quán bar","tìm quán bar quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí quán bar","quán bar quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí quán bar","danh sách quán bar"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí quán bar","quán bar gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí quán bar","tìm kiếm quán bar"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí quán bar","tìm kiếm quán bar gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí quán bar","tìm kiếm quán bar quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí quán bar","quán bar gần tôi nhất"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí quán bar","quán bar gần nhất"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí quán bar","đỉa chỉ các quán bar"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí quán bar","dịa chỉ các quán bar gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí quán bar","danh sách các quán bar gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí quán bar","các quán bar gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí quán bar","địa điểm quán bar quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí quán bar","địa điểm quán bar"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí quán bar","địa chỉa quán bar"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí quán bar","địa chỉ quán bar gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí quán bar","địa chỉ quán bar quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí quán bar","quán bar khu vực này"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí quán bar","các quán bar gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí quán bar","các quán bar quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí quán bar","quán bar"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí quán bar","các quán bar"));

        // tìm vị trí bưu điện gần nhất
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bưu điện","tìm bưu điện quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bưu điện","bưu điện quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bưu điện","danh sách bưu điện"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bưu điện","bưu điện gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bưu điện","tìm kiếm bưu điện"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bưu điện","tìm kiếm bưu điện gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bưu điện","tìm kiếm bưu điện quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bưu điện","bưu điện gần tôi nhất"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bưu điện","bưu điện gần nhất"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bưu điện","đỉa chỉ các bưu điện"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bưu điện","dịa chỉ các bưu điện gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bưu điện","danh sách các bưu điện gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bưu điện","các bưu điện gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bưu điện","địa điểm bưu điện quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bưu điện","địa điểm bưu điện"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bưu điện","địa chỉa bưu điện"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bưu điện","địa chỉ bưu điện gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bưu điện","địa chỉ bưu điện quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bưu điện","bưu điện khu vực này"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bưu điện","các bưu điện gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bưu điện","các bưu điện quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bưu điện","bưu điện"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bưu điện","các bưu điện"));

        // tìm vị trí bãi đỗ xe gần nhất
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","tìm bãi đỗ xe quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","bãi đỗ xe quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","danh sách bãi đỗ xe"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","bãi đỗ xe gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","tìm kiếm bãi đỗ xe"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","tìm kiếm bãi đỗ xe gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","tìm kiếm bãi đỗ xe quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","bãi đỗ xe gần tôi nhất"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","bãi đỗ xe gần nhất"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","đỉa chỉ các bãi đỗ xe"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","dịa chỉ các bãi đỗ xe gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","danh sách các bãi đỗ xe gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","các bãi đỗ xe gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","địa điểm bãi đỗ xe quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","địa điểm đỗ xe"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","địa chỉa bãi đỗ xe"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","địa chỉ bãi đỗ xe gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","địa chỉ bãi đỗ xe quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","bãi đỗ xe khu vực này"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","các bãi đỗ xe gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","các bãi đỗ xe quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","bãi đỗ xe"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","các bãi đỗ xe"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","tìm bãi đậu xe quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","bãi đậu xe quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","danh sách bãi đậu xe"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","bãi đậu xe gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","tìm kiếm bãi đậu xe"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","tìm kiếm bãi đỗ xe gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","tìm kiếm bãi đậu xe quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","bãi đậu xe gần tôi nhất"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","bãi đậu xe gần nhất"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","đỉa chỉ các bãi đậu xe"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","dịa chỉ các bãi đậu xe gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","danh sách các bãi đậu xe gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","các bãi đậu xe gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","địa điểm bãi đậu xe quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","địa điểm đậu xe"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","địa chỉa bãi đậu xe"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","địa chỉ bãi đậu xe gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","địa chỉ bãi đậu xe quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","bãi đậu xe khu vực này"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","các bãi đậu xe gần đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","các bãi đậu xe quanh đây"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","bãi đậu xe"));
        database_cauHoi.themCauHoi(new CauHoi("tìm vị trí bãi đỗ xe","các bãi đậu xe"));


        // dự đoán xổ sô miền bắc
        database_cauHoi.themCauHoi(new CauHoi("xổ số miền bắc","xổ số miền bắc"));
        database_cauHoi.themCauHoi(new CauHoi("xổ số miền bắc","dự đoán xổ số miền bắc"));
        database_cauHoi.themCauHoi(new CauHoi("xổ số miền bắc","xổ số miền bắc hôm nay"));
        database_cauHoi.themCauHoi(new CauHoi("xổ số miền bắc","xổ số miền bắc ngày hôm nay"));
        database_cauHoi.themCauHoi(new CauHoi("xổ số miền bắc","kết quả xổ số miền bắc"));
        database_cauHoi.themCauHoi(new CauHoi("xổ số miền bắc","kết quả xổ số"));

        // dự đoán xổ sô miền nam
        database_cauHoi.themCauHoi(new CauHoi("xổ số miền nam","xổ số miền nam"));
        database_cauHoi.themCauHoi(new CauHoi("xổ số miền nam","dự đoán xổ số miền nam"));
        database_cauHoi.themCauHoi(new CauHoi("xổ số miền nam","xổ số miền nam hôm nay"));
        database_cauHoi.themCauHoi(new CauHoi("xổ số miền nam","xổ số miền nam ngày hôm nay"));
        database_cauHoi.themCauHoi(new CauHoi("xổ số miền nam","kết quả xổ số miền nam"));

        // dự đoán xổ sô miền trung
        database_cauHoi.themCauHoi(new CauHoi("xổ số miền trung","xổ số miền trung"));
        database_cauHoi.themCauHoi(new CauHoi("xổ số miền trung","dự đoán xổ số miền trung"));
        database_cauHoi.themCauHoi(new CauHoi("xổ số miền trung","xổ số miền trung hôm nay"));
        database_cauHoi.themCauHoi(new CauHoi("xổ số miền trung","xổ số miền trung ngày hôm nay"));
        database_cauHoi.themCauHoi(new CauHoi("xổ số miền trung","kết quả xổ số miền trung"));

        // Xem tỉ giá ngoại tệ
        database_cauHoi.themCauHoi(new CauHoi("tỉ giá ngoại tệ","tỷ giá ngoại tệ"));
        database_cauHoi.themCauHoi(new CauHoi("tỉ giá ngoại tệ","xem tỷ giá ngoại tệ"));
        database_cauHoi.themCauHoi(new CauHoi("tỉ giá ngoại tệ","ngoại tệ"));
        database_cauHoi.themCauHoi(new CauHoi("tỉ giá ngoại tệ","tỷ giá"));
        database_cauHoi.themCauHoi(new CauHoi("tỉ giá ngoại tệ","thông tin ngoại tệ"));
        database_cauHoi.themCauHoi(new CauHoi("tỉ giá ngoại tệ","thông tin tỷ giá ngoại tệ"));
        database_cauHoi.themCauHoi(new CauHoi("tỉ giá ngoại tệ","tỷ giá các ngoại tệ"));
        database_cauHoi.themCauHoi(new CauHoi("tỉ giá ngoại tệ","tỷ giá ngoại tệ hôm nay"));
        database_cauHoi.themCauHoi(new CauHoi("tỉ giá ngoại tệ","ngoại tệ hôm nay"));

        //gia vang
        database_cauHoi.themCauHoi(new CauHoi("giá vàng","giá vàng"));
        database_cauHoi.themCauHoi(new CauHoi("giá vàng","giá vàng hôm nay"));
        database_cauHoi.themCauHoi(new CauHoi("giá vàng","giá vàng trong nữa"));
        database_cauHoi.themCauHoi(new CauHoi("giá vàng","giá vàng quốc tế"));
        database_cauHoi.themCauHoi(new CauHoi("giá vàng","xem giá vàng"));
        database_cauHoi.themCauHoi(new CauHoi("giá vàng","xem giá vàng trong nước"));
        database_cauHoi.themCauHoi(new CauHoi("giá vàng","xem giá vàng quốc tế"));
        database_cauHoi.themCauHoi(new CauHoi("giá vàng","vàng"));


        database_cauHoi.themCauHoi(new CauHoi("",""));
        database_cauHoi.themCauHoi(new CauHoi("",""));
        database_cauHoi.themCauHoi(new CauHoi("",""));

        danhSachCauHoi = database_cauHoi.layDanhSachCauHoi();
        Log.d("taodulieu", "xong " + danhSachCauHoi.size());
    }
}
