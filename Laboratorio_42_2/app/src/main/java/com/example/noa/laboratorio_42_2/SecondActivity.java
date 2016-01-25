package com.example.noa.laboratorio_42_2;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.GpsSatellite;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.Locale;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    //Navegador Web
    public void buttonAclick(View view) {
        Intent viewIntent =
                new Intent("android.intent.action.VIEW",
                        Uri.parse("http://www.google.com/"));
        startActivity(viewIntent);
    }

    //Marcar Teléfono
    public void buttonBclick(View view) {
        Intent viewIntent = new Intent(Intent.ACTION_DIAL);
        startActivity(viewIntent);
    }

    public void buttonCclick(View view) {
        Intent viewIntent = new Intent(Intent.ACTION_CALL);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        String number = "943530851";
        viewIntent.setData(Uri.parse("tel:" + number));
        startActivity(viewIntent);
    }

    //Agregar Contacto
    public void buttonDclick(View view) {
        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
        startActivity(intent);
    }

    //Crear o modificar alarma
    public void buttonEclick(View view) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
        startActivity(intent);
    }

    //Enviar un correo electrónico.
    public void buttonFclick(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", getResources().getString(R.string.mail), null));
        intent.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(
                R.string.subject));
        startActivity(Intent.createChooser(intent, getResources().getString(
                R.string.envio)));
    }

    //Iniciar la cámara fotográfica.
    public void buttonGclick(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);
    }

    //Iniciar la cámara de video.
    public void buttonHclick(View view) {
        Intent intent = new Intent(MediaStore.INTENT_ACTION_VIDEO_CAMERA);
        startActivity(intent);
    }

    //Iniciar el Intent del GPS.
    public void buttonIclick(View view) {
        /*GoogleApiClient mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                mGoogleApiClient);
        */
    }

    //Iniciar enviar un mensaje.
    public void buttonJclick(View view) {
        Intent intent= new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, getResources().getString(
                R.string.text));
        intent.setType("text/plain");
        startActivity(intent);
    }
}

















