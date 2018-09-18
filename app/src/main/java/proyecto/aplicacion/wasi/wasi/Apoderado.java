package proyecto.aplicacion.wasi.wasi;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import proyecto.aplicacion.wasi.wasi.Soporte.Mensaje;

public class Apoderado extends AppCompatActivity implements View.OnClickListener{
    private Button permitirSalida;
    private Button asignarRecogedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apoderado);

        setTitle(R.string.cApoderado); //En la versión final deberá salir el nombre del padre o madre

        permitirSalida = (Button)findViewById(R.id.botonPermitirSalida);
        permitirSalida.setOnClickListener(this);
        asignarRecogedor = (Button)findViewById(R.id.botonAsignarRecogedor);
        asignarRecogedor.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()){
            case R.id.botonPermitirSalida : intent = new Intent(Apoderado.this, HijoApoderado.class);
                break;
            case R.id.botonAsignarRecogedor : intent = new Intent(Apoderado.this, Recogedor.class);
                break;
        }
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.apoderado2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.logout) {
            cerrarSesion();
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Método que se encargará de verificar si el usuario desea cerrar sessión,
     * de ser ser afirmativo se mostrará la actividad de perfiles
     */
    private void cerrarSesion(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Apoderado.this);
        builder.setTitle(Mensaje.tituloCerrarSesion);
        builder.setMessage(Mensaje.mensajeCerrarSesion);
        builder.setCancelable(false);
        builder.setIcon(R.drawable.informacion);

        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(Apoderado.this, Perfil.class);
                startActivity(intent);
                finish();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //No se hace nada
                dialogInterface.cancel();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
