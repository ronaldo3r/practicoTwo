package appmoviles.com.practicotwo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import appmoviles.com.practicotwo.Model.Usuario;

public class PrincipalReporte extends AppCompatActivity {

    private TextView mensaje;
    private TextView txt_spiderman;
    private TextView txt_ironman;
    private TextView txt_america;
    private TextView txt_marvel;
    private TextView txt_hulk;
    private TextView txt_viuda;
    private TextView txt_thor;
    private TextView txt_strange;

    private RadioGroup grupos;
    private RadioButton grupo1;
    private RadioButton grupo2;
    private RadioButton grupo3;
    private RadioButton grupo4;
    private RadioButton grupo5;
    private RadioButton grupo6;

    private Button btn_sel;
    private Button btn_voto;

    FirebaseDatabase rtdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_reporte);

        mensaje = findViewById(R.id.txt_mensaje);
        txt_spiderman = findViewById(R.id.txt_spiderman);
        txt_ironman = findViewById(R.id.txt_ironman);
        txt_america = findViewById(R.id.txt_america);
        txt_marvel = findViewById(R.id.txt_marvel);
        txt_hulk = findViewById(R.id.txt_hulk);
        txt_viuda = findViewById(R.id.txt_viuda);
        txt_thor = findViewById(R.id.txt_thor);
        txt_strange = findViewById(R.id.txt_strange);

        grupos = findViewById(R.id.opc_grupos);
        grupo1 = findViewById(R.id.radio_opcGrupo1);
        grupo2 = findViewById(R.id.radio_opcGrupo2);
        grupo3 = findViewById(R.id.radio_opcGrupo3);
        grupo4 = findViewById(R.id.radio_opcGrupo4);
        grupo5 = findViewById(R.id.radio_opcGrupo5);
        grupo6 = findViewById(R.id.radio_opcGrupo6);

        btn_sel = findViewById(R.id.btn_sel);
        btn_voto = findViewById(R.id.btn_voto);

        rtdb = FirebaseDatabase.getInstance();

        //refrescar();

        rtdb.getReference().child("Usuarios").child("Todo el publico").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                double total=0;
                double spi=0;
                double iro=0;
                double ame=0;
                double mar=0;
                double hulk=0;
                double viuda=0;
                double thor=0;
                double str=0;
                for(DataSnapshot hijo : dataSnapshot.getChildren()){
                    Usuario a = hijo.getValue(Usuario.class);
                    String heroe = a.getSuperheroe();

                    if(heroe.equals("Spiderman")){
                        spi++;
                    }else if(heroe.equals("Ironman")){
                        iro++;
                    }else if(heroe.equals("Capitan America")){
                        ame++;
                    }else if(heroe.equals("Capitana Marvel")){
                        mar++;
                    }else if(heroe.equals("Hulk")){
                        hulk++;
                    }else if(heroe.equals("La Viuda Negra")){
                        viuda++;
                    }else if(heroe.equals("Thor")){
                        thor++;
                    }else{
                        str++;
                    }

                    total++;
                }

                calcularPorcentajes(total, spi, iro,ame, mar,hulk,viuda,thor,str);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }


        });

        btn_sel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(grupo1.isChecked()){

                    mensaje.setText("Los superheroes más populares para todo el público son:");

                    rtdb.getReference().child("Usuarios").child("Todo el publico").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            double total=0;
                            double spi=0;
                            double iro=0;
                            double ame=0;
                            double mar=0;
                            double hulk=0;
                            double viuda=0;
                            double thor=0;
                            double str=0;

                            for(DataSnapshot hijo : dataSnapshot.getChildren()){
                                Usuario a = hijo.getValue(Usuario.class);
                                String heroe = a.getSuperheroe();
                                if(heroe.equals("Spiderman")){
                                    spi++;
                                }else if(heroe.equals("Ironman")){
                                    iro++;
                                }else if(heroe.equals("Capitan America")){
                                    ame++;
                                }else if(heroe.equals("Capitana Marvel")){
                                    mar++;
                                }else if(heroe.equals("Hulk")){
                                    hulk++;
                                }else if(heroe.equals("La Viuda Negra")){
                                    viuda++;
                                }else if(heroe.equals("Thor")){
                                    thor++;
                                }else{
                                    str++;
                                }
                                total++;
                            }
                            calcularPorcentajes(total, spi, iro,ame, mar,hulk,viuda,thor,str);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }else if(grupo2.isChecked()){

                    mensaje.setText("Los superheroes más populares para las mujeres adultas son:");

                    rtdb.getReference().child("Usuarios").child("Mujeres adultas").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            double total=0;
                            double spi=0;
                            double iro=0;
                            double ame=0;
                            double mar=0;
                            double hulk=0;
                            double viuda=0;
                            double thor=0;
                            double str=0;

                            for(DataSnapshot hijo : dataSnapshot.getChildren()){
                                Usuario a = hijo.getValue(Usuario.class);
                                String heroe = a.getSuperheroe();

                                if(heroe.equals("Spiderman")){
                                    spi++;
                                }else if(heroe.equals("Ironman")){
                                    iro++;
                                }else if(heroe.equals("Capitan America")){
                                    ame++;
                                }else if(heroe.equals("Capitana Marvel")){
                                    mar++;
                                }else if(heroe.equals("Hulk")){
                                    hulk++;
                                }else if(heroe.equals("La Viuda Negra")){
                                    viuda++;
                                }else if(heroe.equals("Thor")){
                                    thor++;
                                }else{
                                    str++;
                                }
                                total++;
                            }
                            calcularPorcentajes(total, spi, iro,ame, mar,hulk,viuda,thor,str);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }else if(grupo3.isChecked()){

                    mensaje.setText("Los superheroes más populares para los hombres adultos son:");

                    rtdb.getReference().child("Usuarios").child("Hombres adultos").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            double total=0;
                            double spi=0;
                            double iro=0;
                            double ame=0;
                            double mar=0;
                            double hulk=0;
                            double viuda=0;
                            double thor=0;
                            double str=0;

                            for(DataSnapshot hijo : dataSnapshot.getChildren()){
                                Usuario a = hijo.getValue(Usuario.class);
                                String heroe = a.getSuperheroe();

                                if(heroe.equals("Spiderman")){
                                    spi++;
                                }else if(heroe.equals("Ironman")){
                                    iro++;
                                }else if(heroe.equals("Capitan America")){
                                    ame++;
                                }else if(heroe.equals("Capitana Marvel")){
                                    mar++;
                                }else if(heroe.equals("Hulk")){
                                    hulk++;
                                }else if(heroe.equals("La Viuda Negra")){
                                    viuda++;
                                }else if(heroe.equals("Thor")){
                                    thor++;
                                }else{
                                    str++;
                                }
                                total++;
                            }
                            calcularPorcentajes(total, spi, iro,ame, mar,hulk,viuda,thor,str);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }else if(grupo4.isChecked()){

                    mensaje.setText("Los superheroes más populares para las mujeres adolescentes son:");

                    rtdb.getReference().child("Usuarios").child("Mujeres adolescentes").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            double total=0;
                            double spi=0;
                            double iro=0;
                            double ame=0;
                            double mar=0;
                            double hulk=0;
                            double viuda=0;
                            double thor=0;
                            double str=0;

                            for(DataSnapshot hijo : dataSnapshot.getChildren()){
                                Usuario a = hijo.getValue(Usuario.class);
                                String heroe = a.getSuperheroe();

                                if(heroe.equals("Spiderman")){
                                    spi++;
                                }else if(heroe.equals("Ironman")){
                                    iro++;
                                }else if(heroe.equals("Capitan America")){
                                    ame++;
                                }else if(heroe.equals("Capitana Marvel")){
                                    mar++;
                                }else if(heroe.equals("Hulk")){
                                    hulk++;
                                }else if(heroe.equals("La Viuda Negra")){
                                    viuda++;
                                }else if(heroe.equals("Thor")){
                                    thor++;
                                }else{
                                    str++;
                                }
                                total++;
                            }
                            calcularPorcentajes(total, spi, iro,ame, mar,hulk,viuda,thor,str);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }else if(grupo5.isChecked()){

                    mensaje.setText("Los superheroes más populares para los hombres adolescentes son:");

                    rtdb.getReference().child("Usuarios").child("Hombres adolescentes").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            double total=0;
                            double spi=0;
                            double iro=0;
                            double ame=0;
                            double mar=0;
                            double hulk=0;
                            double viuda=0;
                            double thor=0;
                            double str=0;

                            for(DataSnapshot hijo : dataSnapshot.getChildren()){
                                Usuario a = hijo.getValue(Usuario.class);
                                String heroe = a.getSuperheroe();

                                if(heroe.equals("Spiderman")){
                                    spi++;
                                }else if(heroe.equals("Ironman")){
                                    iro++;
                                }else if(heroe.equals("Capitan America")){
                                    ame++;
                                }else if(heroe.equals("Capitana Marvel")){
                                    mar++;
                                }else if(heroe.equals("Hulk")){
                                    hulk++;
                                }else if(heroe.equals("La Viuda Negra")){
                                    viuda++;
                                }else if(heroe.equals("Thor")){
                                    thor++;
                                }else{
                                    str++;
                                }
                                total++;
                            }
                            calcularPorcentajes(total, spi, iro,ame, mar,hulk,viuda,thor,str);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }else{

                    mensaje.setText("Los superheroes más populares para los niños son:");

                    rtdb.getReference().child("Usuarios").child("Niños").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            double total=0;
                            double spi=0;
                            double iro=0;
                            double ame=0;
                            double mar=0;
                            double hulk=0;
                            double viuda=0;
                            double thor=0;
                            double str=0;

                            for(DataSnapshot hijo : dataSnapshot.getChildren()){
                                Usuario a = hijo.getValue(Usuario.class);
                                String heroe = a.getSuperheroe();

                                if(heroe.equals("Spiderman")){
                                    spi++;
                                }else if(heroe.equals("Ironman")){
                                    iro++;
                                }else if(heroe.equals("Capitan America")){
                                    ame++;
                                }else if(heroe.equals("Capitana Marvel")){
                                    mar++;
                                }else if(heroe.equals("Hulk")){
                                    hulk++;
                                }else if(heroe.equals("La Viuda Negra")){
                                    viuda++;
                                }else if(heroe.equals("Thor")){
                                    thor++;
                                }else{
                                    str++;
                                }
                                total++;
                            }
                            calcularPorcentajes(total, spi, iro,ame, mar,hulk,viuda,thor,str);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }

            }
        });

        btn_voto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PrincipalReporte.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }

//    public void refrescar(){
//       // total=0;
//        spi=0;
//        iro=0;
//        ame=0;
//        mar=0;
//        hulk=0;
//        str=0;
//        viuda=0;
//        thor=0;
//    }

    public void calcularPorcentajes(double total, double spi, double iro, double ame, double mar, double hulk, double viuda, double thor, double str){

        if(total!=0){
            txt_spiderman.setText("Spiderman: " + (spi/total)*100 + "%");
            txt_ironman.setText("Ironman: " + (iro/total)*100+ "%");
            txt_america.setText("Capitan America: " + (ame/total)*100+ "%");
            txt_marvel.setText("Capitana Marvel: " + (mar/total)*100+ "%");
            txt_hulk.setText("Hulk: " + (hulk/total)*100+ "%");
            txt_viuda.setText("La Viuda Negra: "+ (viuda/total)*100+ "%");
            txt_thor.setText("Thor: "+ (thor/total)*100+ "%");
            txt_strange.setText("Doctor Strange: "+ (str/total)*100+ "%");
        }else{
            txt_spiderman.setText("Spiderman: No hay votos");
            txt_ironman.setText("Ironman: No hay votos");
            txt_america.setText("Capitan America: No hay votos");
            txt_marvel.setText("Capitana Marvel: No hay votos");
            txt_hulk.setText("Hulk: No hay votos");
            txt_viuda.setText("La Viuda Negra: No hay votos");
            txt_thor.setText("Thor: No hay votos");
            txt_strange.setText("Doctor Strange: No hay votos");
        }
    }
}
