package com.nhom3.bduan1.appcompatactivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.ComponentActivity;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.google.firebase.firestore.FirebaseFirestore;
import com.nhom3.bduan1.R;
import com.nhom3.bduan1.models.QuanLyPhongTroModels;

public class SupportActivity extends ComponentActivity {

    private ImageView imgBack;
    private FirebaseFirestore db;
    private EditText etYeucau;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.xanh_user));
        }
        imgBack = findViewById(R.id.imgBackHoTro);
        etYeucau = findViewById(R.id.edtContent);
        btnSave = findViewById(R.id.btnGui);
        db = FirebaseFirestore.getInstance();

        imgBack.setOnClickListener(v -> finish());

        btnSave.setOnClickListener(v -> {
            String yeuCau = etYeucau.getText().toString();
            if (yeuCau.isEmpty()) {
                Toast.makeText(SupportActivity.this, "Vui lòng nhập yêu cầu", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Thành Công", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
