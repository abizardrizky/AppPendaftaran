package id.sch.smktelkom_mlg.tugas01.xiirpl2001.apppendaftaran;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama, etNis, etEmail;
    Button btOk;
    TextView tvHasil;
    Spinner spKelas;
    RadioButton rbAsp, rbAndroid, rbJava, rbOracle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etNis = (EditText) findViewById(R.id.editTextNis);
        etEmail = (EditText) findViewById(R.id.editTextEmail);
        btOk = (Button) findViewById(R.id.buttonOk);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        spKelas = (Spinner) findViewById(R.id.spinnerKelas);
        rbAsp = (RadioButton) findViewById(R.id.radioButtonAsp);
        rbAndroid = (RadioButton) findViewById(R.id.radioButtonAndroid);
        rbJava = (RadioButton) findViewById(R.id.radioButtonJava);
        rbOracle = (RadioButton) findViewById(R.id.radioButtonOracle);

        findViewById(R.id.buttonOk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });
    }

    private void doClick() {
        String nama = etNama.getText().toString();
        String nis = etNis.getText().toString();
        String email = etEmail.getText().toString();

        String ket = null;
        if (rbAsp.isChecked()) {
            ket = rbAsp.getText().toString();
        } else if (rbAndroid.isChecked()) {
            ket = rbAndroid.getText().toString();
        } else if (rbJava.isChecked()) {
            ket = rbJava.getText().toString();
        } else if (rbOracle.isChecked()) {
            ket = rbOracle.getText().toString();
        } else {
            ket = "Anda belum memilih kelas extra";
        }

        if (isValid()) {
            tvHasil.setText("Nama : " + nama +
                    "\nNIS : " + nis +
                    "\nEmail : " + email +
                    "\nKelas : " + spKelas.getSelectedItem().toString() +
                    "\nKelas yang diikuti : " + ket);
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String namaa = etNama.getText().toString();
        String niss = etNis.getText().toString();
        String emaill = etEmail.getText().toString();

        if (namaa.isEmpty()) {
            etNama.setError("Nama belum diisi");
            valid = false;
        } else if (niss.isEmpty()) {
            etNis.setError("NIS belum diisi");
            valid = false;
        } else if (emaill.isEmpty()) {
            etEmail.setError("NIS belum diisi");
            valid = false;
        } else {
            etNama.setError(null);
            etNis.setError(null);
            etEmail.setError(null);
        }

        return valid;
    }
}
