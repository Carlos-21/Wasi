package proyecto.aplicacion.wasi.wasi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import proyecto.aplicacion.wasi.wasi.Soporte.Mensaje;

public class Login extends AppCompatActivity implements View.OnClickListener{
    private EditText usuario;
    private EditText clave;
    private Button ingresar;
    private int perfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle(R.string.cLogin);

        tipoPerfil();

        usuario = (EditText)findViewById(R.id.textoUsuario);
        clave = (EditText)findViewById(R.id.textoClave);

        ingresar = (Button)findViewById(R.id.botonIngresar);
        ingresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()){
            case R.id.botonIngresar : verificar(intent);
        }
    }

    /**
     * Método que se encargará de dirigir a una diferente vista
     * dependiendo del perfil del usuario
     * @param intent
     */
    private void verificar(Intent intent){
        switch (perfil){
            case 1 : verificarUsuario(intent, 1);
                     break;
            case 2 : verificarUsuario(intent, 2);
                     break;
        }
    }

    /**
     * Recibe el usuario y contraseña y comprueba si la persona se
     * encuentra registrada
     */
    private void verificarUsuario(Intent intent, int tipoPerfil){
        String usuario = this.usuario.getText().toString();
        String clave = this.clave.getText().toString();
        System.out.println("Número switch : "+tipoPerfil);
        switch (tipoPerfil){
            case 1 : if(usuario.equals("padre") && clave.equals("padre")){
                System.out.println("1P");
                        intent = new Intent(Login.this, Apoderado2.class);
                        Toast.makeText(Login.this, Mensaje.mensajeUsuarioCorrecto, Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        finish();
                     }
                     else{
                System.out.println("2P");
                        Toast.makeText(Login.this, Mensaje.mensajeUsuarioIncorrecto, Toast.LENGTH_SHORT).show();
                     }
                     break;
            case 2 : if(usuario.equals("movilidad") && clave.equals("movilidad")){
                        System.out.println("3M");
                        intent = new Intent(Login.this, Movilidad.class);
                        Toast.makeText(Login.this, Mensaje.mensajeUsuarioCorrecto, Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        finish();
                    }
                    else{
                System.out.println("4M");
                        Toast.makeText(Login.this, Mensaje.mensajeUsuarioIncorrecto, Toast.LENGTH_SHORT).show();
                    }
                    break;
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
            System.out.println("Numero : "+perfil);
        }
    }
}
