package com.example.vencees.taxisguaymas;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ListaActivity  extends Activity implements AdapterView.OnItemClickListener {

    ListViewAdapter adapter;

    String[] titulo = new String[]{
            "Semeson Guaymas Norte",
            "Radio Servicios",
            "Super Rapidos",
            "Sitio Tufesa",
            "Sitio del Seguro de la 10",
            "Radio Taxis del Puerto A.C",
            "Sitio Centenario",
    };

    int[] imagenes = {
            R.mipmap.ic_launcher,
            R.mipmap.ubicasiones,
            R.mipmap.ic_launcher,
            R.mipmap.ubicasiones,
            R.mipmap.ic_launcher,
            R.mipmap.ubicasiones,
            R.mipmap.ic_launcher
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        final ListView lista = (ListView) findViewById(R.id.listView1);
        adapter = new ListViewAdapter(this, titulo, imagenes);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) throws SecurityException {
        switch (position) {
            case 0:
                Uri numero0 = Uri.parse("tel:" + "6221252850".toString());
                Intent intent0 = new Intent(Intent.ACTION_CALL, numero0);
                startActivity(intent0);
                break;
            case 1:
                Uri numero1 = Uri.parse("tel:" + "6222240466".toString());
                Intent intent1 = new Intent(Intent.ACTION_CALL, numero1);
                startActivity(intent1);

                break;
            case 2:
                Uri numero2 = Uri.parse("tel:" + "6222227859".toString());
                Intent intent2 = new Intent(Intent.ACTION_CALL, numero2);
                startActivity(intent2);

                break;
            case 3:
                Uri numero3 = Uri.parse("tel:" + "6222223301".toString());
                Intent intent3 = new Intent(Intent.ACTION_CALL, numero3);
                startActivity(intent3);

                break;
            case 4:
                Uri numero4 = Uri.parse("tel:" + "6222220377".toString());
                Intent intent4 = new Intent(Intent.ACTION_CALL, numero4);
                startActivity(intent4);

                break;
            case 5:
                Uri numero5 = Uri.parse("tel:" + "6222229322".toString());
                Intent intent5 = new Intent(Intent.ACTION_CALL, numero5);
                startActivity(intent5);

                break;
            case 6:
                Uri numero6 = Uri.parse("tel:" + "6222224041".toString());
                Intent intent6 = new Intent(Intent.ACTION_CALL, numero6);
                startActivity(intent6);

                break;

            default:
                String msg = "Ops no se pudo llamar";
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

                break;
        }
    }
}
