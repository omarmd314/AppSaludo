package com.example.appsaludo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

//import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView txtNombre;
    private TextView txtEdad;
    private TextView txtCelular;
    private TextView txtEmail;




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

        txtNombre = findViewById(R.id.txtNombre);
        txtEdad = findViewById(R.id.txtEdad);
        txtCelular = findViewById(R.id.txtCelular);
        txtEmail = findViewById(R.id.txtEmail);
    }


    public void Mostrar(View view){

        String nombre = String.valueOf(txtNombre.getText());
        String edad = String.valueOf(txtEdad.getText());
        String celular = String.valueOf(txtCelular.getText());
        String email = String.valueOf(txtEmail.getText());

        String crit;

        int nedad = Integer.parseInt(edad);
        int ncel = Integer.parseInt(celular);

        if (nombre.length() > 50){
            Toast.makeText(this, "El nombre tiene mas de 50 caracteres", Toast.LENGTH_LONG).show();
        } else if (edad.startsWith("0")){
            Toast.makeText(this, "Tu edad empieza con cero", Toast.LENGTH_LONG).show();
        } else if (nedad < 1 || nedad > 99){
            Toast.makeText(this, "Tu edad no es correcta", Toast.LENGTH_LONG).show();
        } else if (!celular.startsWith("9")){
            Toast.makeText(this, "Tu celular no empieza con 9", Toast.LENGTH_LONG).show();
        } else if (celular.length() < 9){
            Toast.makeText(this, "Tu no tiene 9 digitos", Toast.LENGTH_LONG).show();
        }
        else {

            if(nedad < 2){
                crit = "bebe";
            } else if (nedad >= 2 && nedad<=11){
                crit = "niño";
            } else if (nedad >= 12 && nedad<=17){
                crit = "adolescente";
            } else if (nedad >=18 && nedad<=50){
                crit = "adulto";
            } else {
                crit = "anciano";
            }

            String msg = "Hola "+nombre+", tienes "+edad+" años y eres un " + crit;

            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        }



    }
}