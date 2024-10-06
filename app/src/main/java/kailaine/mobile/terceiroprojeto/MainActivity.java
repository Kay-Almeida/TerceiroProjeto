package kailaine.mobile.terceiroprojeto;

/*
 *@author:<Kailaine Almeida de Souza 1110482313026>
 */

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etBaseMaior;
    private EditText etBaseMenor;
    private EditText etAltura;

    private TextView tvRes;

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

        etBaseMaior = findViewById(R.id.etBaseMaior);
        etBaseMenor = findViewById(R.id.etBaseMenor);
        etAltura = findViewById(R.id.etAltura);

        tvRes = findViewById(R.id.tvRes);

        etBaseMaior.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        etBaseMenor.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        etAltura.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);

        tvRes.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);

        Button btnCalc = findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(op -> calc());
    }

    private void calc(){
        int etMaior = Integer.parseInt(etBaseMaior.getText().toString());
        int etMenor = Integer.parseInt(etBaseMenor.getText().toString());
        int etAltu = Integer.parseInt(etAltura.getText().toString());

        int area = ((etMaior + etMenor) * etAltu) / 2;
        tvRes.setText(String.valueOf(area)+ "cm^2");

        etBaseMaior.setText("");
        etBaseMenor.setText("");
        etAltura.setText("");
    }
}