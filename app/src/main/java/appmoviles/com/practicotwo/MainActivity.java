package appmoviles.com.practicotwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;

import appmoviles.com.practicotwo.Model.Usuario;

public class MainActivity extends AppCompatActivity {

    private Usuario usuario;
    FirebaseDatabase rtdb;

    private TextView selGenero;
    private TextView selEdad;
    private TextView selHeroe;

    private Button btn_resultado;
    private Button btn_reporte;

    private RadioGroup generos;
    private RadioButton gen1;
    private RadioButton gen2;

    private RadioGroup edades;
    private RadioButton edad1;
    private RadioButton edad2;
    private RadioButton edad3;

    private RadioGroup heroes;
    private RadioButton heroe1;
    private RadioButton heroe2;
    private RadioButton heroe3;
    private RadioButton heroe4;
    private RadioButton heroe5;
    private RadioButton heroe6;
    private RadioButton heroe7;
    private RadioButton heroe8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseApp.initializeApp(this);
        usuario = new Usuario();
        rtdb = FirebaseDatabase.getInstance();

        selGenero = findViewById(R.id.txt_genero);
        selEdad = findViewById(R.id.txt_edad);
        selHeroe = findViewById(R.id.txt_heroe);

        btn_resultado = findViewById(R.id.btn_resultado);
        btn_reporte = findViewById(R.id.btn_reporte);

        generos = findViewById(R.id.opc_genero);
        gen1 = findViewById(R.id.radio_opcGen1);
        gen2 = findViewById(R.id.radio_opcGen2);

        edades = findViewById(R.id.opc_edad);
        edad1 = findViewById(R.id.radio_opcEdad1);
        edad2 = findViewById(R.id.radio_opcEdad2);
        edad3 = findViewById(R.id.radio_opcEdad3);

        heroes = findViewById(R.id.opc_heroe);
        heroe1 = findViewById(R.id.radio_opcHeroe1);
        heroe2 = findViewById(R.id.radio_opcHeroe2);
        heroe3 = findViewById(R.id.radio_opcHeroe3);
        heroe4 = findViewById(R.id.radio_opcHeroe4);
        heroe5 = findViewById(R.id.radio_opcHeroe5);
        heroe6 = findViewById(R.id.radio_opcHeroe6);
        heroe7 = findViewById(R.id.radio_opcHeroe7);
        heroe8 = findViewById(R.id.radio_opcHeroe8);

        btn_resultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gen1.isChecked()) {
                    usuario.setGenero(gen1.getText().toString());
                } else {
                    usuario.setGenero(gen2.getText().toString());
                }
                if (edad1.isChecked()) {
                    usuario.setEdad(edad1.getText().toString());
                } else if (edad2.isChecked()) {
                    usuario.setEdad(edad2.getText().toString());
                } else {
                    usuario.setEdad(edad3.getText().toString());
                }
                if (heroe1.isChecked()) {
                    usuario.setSuperheroe(heroe1.getText().toString());
                } else if (heroe2.isChecked()) {
                    usuario.setSuperheroe(heroe2.getText().toString());
                } else if (heroe3.isChecked()) {
                    usuario.setSuperheroe(heroe3.getText().toString());
                } else if (heroe4.isChecked()) {
                    usuario.setSuperheroe(heroe4.getText().toString());
                } else if (heroe5.isChecked()) {
                    usuario.setSuperheroe(heroe5.getText().toString());
                } else if (heroe6.isChecked()) {
                    usuario.setSuperheroe(heroe6.getText().toString());
                } else if (heroe7.isChecked()) {
                    usuario.setSuperheroe(heroe7.getText().toString());
                } else {
                    usuario.setSuperheroe(heroe8.getText().toString());
                }

                rtdb.getReference().child("Usuarios").child("Todo el publico").push().setValue(usuario);

                if (usuario.getGenero().equals(gen1.getText().toString()) && usuario.getEdad().equals(edad2.getText().toString())) {
                    rtdb.getReference().child("Usuarios").child("Hombres adolescentes").push().setValue(usuario);
                } else if (usuario.getGenero().equals(gen1.getText().toString()) && usuario.getEdad().equals(edad3.getText().toString())) {
                    rtdb.getReference().child("Usuarios").child("Hombres adultos").push().setValue(usuario);
                } else if (usuario.getGenero().equals(gen2.getText().toString()) && usuario.getEdad().equals(edad2.getText().toString())) {
                    rtdb.getReference().child("Usuarios").child("Mujeres adolescentes").push().setValue(usuario);
                } else if (usuario.getGenero().equals(gen2.getText().toString()) && usuario.getEdad().equals(edad3.getText().toString())) {
                    rtdb.getReference().child("Usuarios").child("Mujeres adultas").push().setValue(usuario);
                }else if (usuario.getEdad().equals(edad1.getText().toString())){
                    rtdb.getReference().child("Usuarios").child("Niños").push().setValue(usuario);
                }

                Intent i = new Intent(MainActivity.this, PrincipalReporte.class);
                startActivity(i);
                finish();
            }
        });

        btn_reporte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, PrincipalReporte.class);
                startActivity(i);
                finish();
            }
        });

    }
}
