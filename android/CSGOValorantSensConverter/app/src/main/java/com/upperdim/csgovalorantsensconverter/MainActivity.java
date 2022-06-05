package com.upperdim.csgovalorantsensconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.upperdim.csgovalorantsensconverter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnCsgo2valo.setOnClickListener(v -> {
            if (binding.etCsgoDpi.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getApplicationContext(), "CS:GO DPI field must be filled!", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }

            if (binding.etCsgoSens.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getApplicationContext(), "CS:GO sensitivity field must be filled!", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }

            if (binding.etValoDpi.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getApplicationContext(), "Valorant DPI field must be filled!", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }

            double csgoDpi = Double.parseDouble(binding.etCsgoDpi.getText().toString());
            double csgoSens = Double.parseDouble(binding.etCsgoSens.getText().toString());
            double valoDpi = Double.parseDouble(binding.etValoDpi.getText().toString());

            double valoSens = (csgoSens / 3.18) * (csgoDpi / valoDpi);
            binding.etValoSens.setText(String.format("%.6f", valoSens));
        });

        binding.btnValo2csgo.setOnClickListener(v -> {
            if (binding.etCsgoDpi.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getApplicationContext(), "CS:GO DPI field must be filled!", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }

            if (binding.etValoSens.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getApplicationContext(), "Valorant sensitivity field must be filled!", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }

            if (binding.etValoDpi.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getApplicationContext(), "Valorant DPI field must be filled!", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }

            double csgoDpi = Double.parseDouble(binding.etCsgoDpi.getText().toString());
            double valoSens = Double.parseDouble(binding.etValoSens.getText().toString());
            double valoDpi = Double.parseDouble(binding.etValoDpi.getText().toString());

            double csgoSens = (valoSens * 3.18) * (valoDpi / csgoDpi);
            binding.etCsgoSens.setText(String.format("%.6f", csgoSens));
        });

        binding.btnDelCsgoDpi.setOnClickListener(v -> binding.etCsgoDpi.setText(""));

        binding.btnDelCsgoSens.setOnClickListener(v -> binding.etCsgoSens.setText(""));

        binding.btnDelValoDpi.setOnClickListener(v -> binding.etValoDpi.setText(""));

        binding.btnDelValoSens.setOnClickListener(v -> binding.etValoSens.setText(""));
    }
}