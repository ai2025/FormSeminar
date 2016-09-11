package id.sch.smktelkom_mlg.learn.tugas01.xirpl2001.formseminar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    EditText etEmail;
    EditText etPass;
    Button bDaftar;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.etNama);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPass = (EditText) findViewById(R.id.etPass);
        bDaftar = (Button) findViewById(R.id.bDaftar);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        bDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doProcess();
            }
        });

    }

    private void doProcess() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            String email = etEmail.getText().toString();
            String pass = etPass.getText().toString();
            tvHasil.setText("Atas nama " + nama + ", email Anda " + email);
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String email = etEmail.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
        } else if (nama.length() <= 3) {
            etNama.setError("Nama minimal 3 karakter");
            valid = false;
        } else {
            etNama.setError(null);
        }

        if (email.isEmpty()) {
            etEmail.setError("Email belum diisi");
        } else {
            etEmail.setError(null);
        }

        return valid;
    }
}
