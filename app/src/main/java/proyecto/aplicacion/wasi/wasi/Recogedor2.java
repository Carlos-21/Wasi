package proyecto.aplicacion.wasi.wasi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Recogedor2 extends AppCompatActivity {
    private EditText usuarioRecogedor;
    private EditText claveRecogedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recogedor2);

        setTitle(R.string.cRecogedor);

        usuarioRecogedor = (EditText)findViewById(R.id.textoUsuarioRecogedorMostrar);
        claveRecogedor = (EditText)findViewById(R.id.textoClaveRecogedorMostrar);

        usuarioRecogedor.setText("usuario: 2K349");
        claveRecogedor.setText("contraseña: 4T890");
    }
}
