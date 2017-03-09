package com.dama.fcarvajal.materialdesign;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import javax.mail.AuthenticationFailedException;
import javax.mail.MessagingException;

public class FormularioContactoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_contacto);
        setToolbar();
        setFormularioContacto();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //TOOLBAR
    public void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView tvTitulo = (TextView) findViewById(R.id.toolbar_tvTitulo);
        tvTitulo.setText(R.string.afc_titulo);

        ImageView imgEstrella = (ImageView) findViewById(R.id.toolbar_imgEstrella);
        imgEstrella.setVisibility(View.INVISIBLE);
    }

    public void setFormularioContacto() {
        Button afc_btnEnviarComentario = (Button) findViewById(R.id.afc_btnEnviarComentario);
        afc_btnEnviarComentario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });
    }

    //ENVIAR CORREO
    private void sendMessage() {
        String[] recipients = { ((EditText) findViewById(R.id.afc_etPara)).getText().toString() };
        SendEmailAsyncTask email = new SendEmailAsyncTask();
        email.activity = this;
        email.m = new Mail(
                ((EditText) findViewById(R.id.afc_etUsuario)).getText().toString(),
                ((EditText) findViewById(R.id.afc_etContrasenna)).getText().toString());
        email.m.set_from(((EditText) findViewById(R.id.afc_etUsuario)).getText().toString());
        email.m.setBody(((EditText) findViewById(R.id.afc_etCuerpo)).getText().toString());
        email.m.set_to(recipients);
        email.m.set_subject(((EditText) findViewById(R.id.afc_etAsunto)).getText().toString());
        email.execute();
    }

    public void displayMessage(String message) {
        Snackbar.make(findViewById(R.id.activity_formulario_contacto), message, Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }
}

class SendEmailAsyncTask extends AsyncTask<Void, Void, Boolean> {
    Mail m;
    FormularioContactoActivity activity;

    public SendEmailAsyncTask() {}

    @Override
    protected Boolean doInBackground(Void... params) {
        try {
            if (m.send()) {
                activity.displayMessage("Email sent.");
            } else {
                activity.displayMessage("Email failed to send.");
            }

            return true;
        } catch (AuthenticationFailedException e) {
            Log.e(SendEmailAsyncTask.class.getName(), "Detalles de la cuenta erróneos");
            e.printStackTrace();
            activity.displayMessage("Autenticación fallida.");
            return false;
        } catch (MessagingException e) {
            Log.e(SendEmailAsyncTask.class.getName(), "Correo fallido");
            e.printStackTrace();
            activity.displayMessage("Falló el envio del correo.");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            activity.displayMessage("Unexpected error occured.");
            return false;
        }
    }
}