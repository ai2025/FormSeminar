package id.sch.smktelkom_mlg.learn.tugas01.xirpl2001.formseminar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    EditText etNama, etEmail, etPass;
    Button bDaftar;
    TextView tvHasil, tvHasil2, tvMapel;
    RadioButton rbLK, rbPR;
    CheckBox cbHTML, cbCSS, cbJS, cbPHP;
    int nMapel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etEmail = (EditText) findViewById(R.id.editTextEmail);
        etPass = (EditText) findViewById(R.id.editTextPass);
        bDaftar = (Button) findViewById(R.id.buttonDaftar);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvHasil2 = (TextView) findViewById(R.id.textViewHasil2);
        rbLK = (RadioButton) findViewById(R.id.radioButtonLk);
        rbPR = (RadioButton) findViewById(R.id.radioButtonPr);
        cbHTML = (CheckBox) findViewById(R.id.checkBoxHTML);
        cbCSS = (CheckBox) findViewById(R.id.checkBoxCSS);
        cbJS = (CheckBox) findViewById(R.id.checkBoxJS);
        cbPHP = (CheckBox) findViewById(R.id.checkBoxPHP);
        tvMapel = (TextView) findViewById(R.id.textViewMapel);
        cbHTML.setOnCheckedChangeListener(this);
        cbCSS.setOnCheckedChangeListener(this);
        cbJS.setOnCheckedChangeListener(this);
        cbPHP.setOnCheckedChangeListener(this);

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
            tvHasil.setText("Atas nama " + nama + ", email Anda " + email);
        }

        String gender = null;

        if (rbLK.isChecked()) {
            gender = rbLK.getText().toString();
        } else if (rbPR.isChecked()) {
            gender = rbPR.getText().toString();
        }

        if (gender == null) {
            tvHasil2.setText("Anda belum memilih Gender");
        } else {
            tvHasil2.setText("Gender Anda ; " + gender);
        }

        String mapel = "Materi yang Anda ambil adalah ;\n";
        int startlen = mapel.length();
        if (cbHTML.isChecked()) mapel += cbHTML.getText() + "\\n";
        if (cbCSS.isChecked()) mapel += cbCSS.getText() + "\\n";
        if (cbJS.isChecked()) mapel += cbJS.getText() + "\\n";
        if (cbPHP.isChecked()) mapel += cbPHP.getText() + "\\n";

        if (mapel.length() == startlen) mapel += "Anda Belum memilih Materi";

        tvHasil2.setText(mapel);
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

    @Override
    public void onCheckedChanged(CompoundButton compoundbutton, boolean isChecked) {
        if (isChecked) nMapel += 1;
        else nMapel -= 1;

        tvMapel.setText("Materi (" + nMapel + " terpilih)");
    }
}
