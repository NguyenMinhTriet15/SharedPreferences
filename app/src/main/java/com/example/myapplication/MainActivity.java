package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnxacnhan;
    EditText edtusername, edtpassword;
    CheckBox cbremember;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        sharedPreferences = getSharedPreferences("datalogin", MODE_PRIVATE);
        edtusername.setText(sharedPreferences.getString("taikhoan","" ));
        edtpassword.setText(sharedPreferences.getString("matkhau",""));
        cbremember.setChecked(sharedPreferences.getBoolean("checked", false));
        btnxacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtusername.getText().toString().trim();
                String password = edtpassword.getText().toString().trim();
                if(username.equals("triet") && password.equals("123123")){
                    Toast.makeText(MainActivity.this, "Dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                if(cbremember.isChecked()){
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("taikhoan", username);
                    editor.putString("matkhau", password);
                    editor.putBoolean("checked", true);
                    editor.commit()
                }
                }
                else{
                    Toast.makeText(MainActivity.this, "Dang nhap that bai", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private  void Anhxa(){
        btnxacnhan = (Button) findViewById(R.id.button);
        edtpassword = (EditText) findViewById(R.id.edtpass);
        edtusername = (EditText) findViewById(R.id.edtuser);
        cbremember = (CheckBox) findViewById(R.id.checkBox);
    }
}