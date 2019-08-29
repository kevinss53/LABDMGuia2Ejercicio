package com.example.labdmguia2ejercicio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Trace;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

public class SegundaActivity extends AppCompatActivity implements View.OnLongClickListener, View.OnClickListener {

    AutoCompleteTextView fruta, animal, lenguaje;
    Button btprocesar;
    String[] frut = { "Pera","Limon","Manzana" };
    String[] lengua = { "C++","JAVA","C#" };
    String[] anima = { "Leon","Jirafa","Perro" };
    ProgressBar barra;
    boolean activo = false;
    int i = 0;
    Handler h = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setTitle("hola");
        }

        //creando los autocomplete
        fruta = findViewById(R.id.txtfruta);
        animal = findViewById(R.id.txtanimal);
        lenguaje = findViewById(R.id.txtlenguaje);
        btprocesar = findViewById(R.id.btnprocesar);
        barra = findViewById(R.id.bar);

        ArrayAdapter<String> adapteranimal = new ArrayAdapter<>(this,android.R.layout.select_dialog_item,anima);
        ArrayAdapter<String> adapterfruta = new ArrayAdapter<>(this,android.R.layout.select_dialog_item,frut);
        ArrayAdapter<String> adapterlenguaje = new ArrayAdapter<>(this,android.R.layout.select_dialog_item,lengua);


        // adaptando sugerencias
        animal.setThreshold(1);
        animal.setAdapter(adapteranimal);

        fruta.setThreshold(1);
        fruta.setAdapter(adapterfruta);

        lenguaje.setThreshold(1);
        lenguaje.setAdapter(adapterlenguaje);



//Aqui empieza el error
       btprocesar.setOnClickListener(this);




    }


/*
    private void setProgressValue(final int progress){
        barra.setProgress(progress);
         int contador = 0;

        while(contador<100) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    setProgressValue(progress+20);

                }
            });
            thread.start();
            contador = contador + 20;
        };
//setProgressValue(0);

    }
*/
    void mensaje()
    {
        Toast.makeText(this,"estas en primera persona",Toast.LENGTH_SHORT).show();
    }

    // solo para prueba
    @Override
    public boolean onLongClick(View view) {

        switch (view.getId()){
           case R.id.btnprocesar: {
              //  setProgressValue(0);


                   Thread carga = new Thread(new Runnable() {
                       @Override
                       public void run() {


                           while (i <= 100) {
                               h.post(new Runnable() {
                                   @Override
                                   public void run() {
                                       barra.setProgress(i);
                                   }
                               });
                               try {
                                   Thread.sleep(1000);
                               } catch (InterruptedException e) {
                                   e.printStackTrace();
                               }
                               if(i==100)
                               {

                                  // Intent ol = new Intent(SegundaActivity.this, MainActivity.class);
                                 //  startActivity(ol);
                                 //  Toast t1 = Toast.makeText(getApplicationContext(), "ya escribio muajaja", Toast.LENGTH_SHORT);
                                  // t1.show();
                                  //  Toast.makeText(getApplicationContext(),"cargado",Toast.LENGTH_SHORT).show();

                               }

                               i = i+20;
                           }


                       }
                   });  carga.start();



           }

                break;
        }
        return false;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnprocesar: {
                //  setProgressValue(0);


                Thread carga = new Thread(new Runnable() {
                    @Override
                    public void run() {


                        while (i <= 100) {
                            h.post(new Runnable() {
                                @Override
                                public void run() {
                                    barra.setProgress(i);
                                }
                            });
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if(i==100)
                            {

                                // Intent ol = new Intent(SegundaActivity.this, MainActivity.class);
                                //  startActivity(ol);
                                //  Toast t1 = Toast.makeText(getApplicationContext(), "ya escribio muajaja", Toast.LENGTH_SHORT);
                                // t1.show();
                                //  Toast.makeText(getApplicationContext(),"cargado",Toast.LENGTH_SHORT).show();
                            }

                            i = i+20;
                        }


                    }
                });  carga.start();



            }

            break;
        }

    }
}
