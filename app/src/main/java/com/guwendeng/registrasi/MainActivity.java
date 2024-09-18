package com.guwendeng.registrasi;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.activity.EdgeToEdge;

import com.guwendeng.registrasi.R;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        EditText edtTanggal, edtFullname, edtUsername, edtEmail, edtNim, edtPassword, edtAlamat, edtNohp;
        Spinner spinGender;
        Button btnRegistrasi;
        int tahun, bulan, tanggal;

        btnRegistrasi = findViewById(R.id.btn_registrasi);
        edtFullname = findViewById(R.id.edt_fullname);
        edtUsername = findViewById(R.id.edt_username);
        edtEmail = findViewById(R.id.edt_email);
        edtNim = findViewById(R.id.edt_nim);
        edtPassword = findViewById(R.id.edt_password);
        edtAlamat = findViewById(R.id.edt_alamat);
        edtNohp = findViewById(R.id.edt_nohp);
        edtTanggal = findViewById(R.id.edt_date);

        edtTanggal.setOnClickListener(v -> {
            final Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePicker = new DatePickerDialog(MainActivity.this, (view, year1, monthOfYear, dayOfMonth) -> {
                String selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year1;
                edtTanggal.setText(selectedDate);
            }, year, month, day);
            datePicker.show();
        });

        btnRegistrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullname = edtFullname.getText().toString();
                String username = edtUsername.getText().toString();
                String email = edtEmail.getText().toString();
                String nim = edtNim.getText().toString();
                String password = edtPassword.getText().toString();
                String tanggal = edtTanggal.getText().toString();
                String alamat = edtAlamat.getText().toString();
                String nohp = edtNohp.getText().toString();

                Toast.makeText(MainActivity.this, "Nama: " + fullname + ", email: " + email + ",username: " + username + ",nim: " + nim + ",password: " + password + ",tanggal: " + tanggal + ",alamat: " + alamat + ",nohp: " + nohp + "", Toast.LENGTH_LONG).show();


            }
        });

    }
}