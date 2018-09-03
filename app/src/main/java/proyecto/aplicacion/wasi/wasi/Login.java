package proyecto.aplicacion.wasi.wasi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity implements View.OnClickListener{
    private EditText usuario;
    private EditText clave;
    private Button ingresar;
    private int perfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()){
            case R.id.botonIngresar : verificar(intent);
        }
        startActivity(intent);
        finish();
    }

    /**
     * Método que se encargará de dirigir a una diferente vista
     * dependiendo del perfil del usuario
     * @param intent
     */
    private void verificar(Intent intent){
        switch (perfil){
            case 1 : intent = new Intent(Login.this, Apoderado.class);
        }
    }

    /**
     * Recibe el dato del tipo de perfil que esta intentando acceder la persona
     * que usa la aplicación
     */
    private void tipoPerfil(){
        Intent inten = getIntent();
        Bundle bun = inten.getExtras();

        if(bun != null){
            perfil = (int)bun.get("perfil");
        }
    }
}
