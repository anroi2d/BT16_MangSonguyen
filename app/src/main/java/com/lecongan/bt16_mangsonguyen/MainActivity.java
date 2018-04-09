package com.lecongan.bt16_mangsonguyen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnNew, btnXuoi, btnNguoc, btnMinMax, btnSapXepTang, btnDao, btnTongPtuDau;
    private EditText edtDay;
    private TextView tvKq;
    private int mang[] = new int[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidget();
        btnNew.setOnClickListener(this);
        btnXuoi.setOnClickListener(this);
        btnNguoc.setOnClickListener(this);
        btnMinMax.setOnClickListener(this);
        btnSapXepTang.setOnClickListener(this);
        btnDao.setOnClickListener(this);
        btnTongPtuDau.setOnClickListener(this);


    }

    private void initWidget() {
        tvKq = (TextView) findViewById(R.id.tv_kq);
        edtDay = (EditText) findViewById(R.id.edt_day);
        btnNew = (Button) findViewById(R.id.btn_create_new);
        btnXuoi = (Button) findViewById(R.id.btn_xuat_xuoi);
        btnNguoc = (Button) findViewById(R.id.btn_xuat_nguoc);
        btnMinMax = (Button) findViewById(R.id.btn_min_max);
        btnSapXepTang = (Button) findViewById(R.id.btn_sap_tang);
        btnDao = (Button) findViewById(R.id.btn_dao_random);
        btnTongPtuDau = (Button) findViewById(R.id.btn_sum_3ptudau);
    }

    public void DocMangRaEditText() {
        String chuoi = "";
        for (int i = 0; i < 10; i++) {
            chuoi += mang[i] + " ";
            edtDay.setText(chuoi);
        }
    }

    public void XuatNguoc() {
        String chuoi = "";
        for (int i = 9; i >= 0; i--) {
            chuoi += mang[i] + " ";
            edtDay.setText(chuoi);
        }
    }

    public void TimMinMax() {
        int min = mang[0];
        int max = mang[0];
        for (int i = 0; i < 10; i++) {
            if (mang[i] < min)
                min = mang[i];
            if (mang[i] > max)
                max = mang[i];

            tvKq.setText("min: " + min + "  max: " + max);
        }
    }


    public static void sortASC(int [] arr) {
        int temp = arr[0];
        for (int i = 0 ; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
public void sumArr(int arr[]){
    int tong = 0;
    String chuoi="";
    for ( int i = 0; i < 3 ; i ++){
        tong = tong + arr[i];
        chuoi+=mang[i]+" ";
        chuoi+=(i!=3)?"+":"";
    }
    tvKq.setText("Tổng phần tử đầu: "+chuoi.substring(0,chuoi.length()-1)+" = "+tong);
}
//    public static void Daomang(int mang[]){
//        int j;
//        for(j=9;j>=0;j--)
//
//    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_create_new:
                Random r = new Random();
                String chuoi = "";
                for (int i = 0; i < 10; i++) {
//                    mang[i]=r.nextInt(10);
                    mang[i] = r.nextInt(50 - 10 + 1) + 10;//tu 10->50//(b-a+1)+a
                }
//                Toast.makeText(this, btnNew.getText(), Toast.LENGTH_SHORT).show();
                DocMangRaEditText();
                break;

            case R.id.btn_xuat_xuoi:
                DocMangRaEditText();
                break;

            case R.id.btn_xuat_nguoc:
                XuatNguoc();
                break;

            case R.id.btn_min_max:
                TimMinMax();
                break;
            case R.id.btn_sap_tang:
                sortASC(mang);
                DocMangRaEditText();
                break;
            case R.id.btn_dao_random:
//                Daomang(mang);
//                DocMangRaEditText();
                break;
            case R.id.btn_sum_3ptudau:
                sumArr(mang);
                DocMangRaEditText();
                break;
        }
    }
}
