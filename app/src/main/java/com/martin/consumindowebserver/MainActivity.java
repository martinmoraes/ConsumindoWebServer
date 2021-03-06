package com.martin.consumindowebserver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void buscar(View view) {
        EditText cepEditText = (EditText) findViewById(R.id.cepEditText);
        final EditText grandeAreaEditText = (EditText) findViewById(R.id.grandeAreaEditText);

        AsyncHttpClient cliente = new AsyncHttpClient();
        String url = "https://viacep.com.br/ws/" +
                cepEditText.getText().toString() +
                "/json";
        cliente.get(url,
                new JsonHttpResponseHandler() {

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        Log.d("MEUAPP", response.toString());

                        Gson gson = new GsonBuilder().create();
                        CEP umCEP = null;
                        if (response.length() > 0) {
                            umCEP = gson.fromJson(response.toString(), CEP.class);
                        }
                        Log.d("MEUAPP",umCEP.toString());
                        grandeAreaEditText.setText(umCEP.toString()+"\n\n"+ grandeAreaEditText.getText());
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers,
                                          JSONArray response) {
                        Log.d("MEUAPP", response.toString());
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable
                            throwable, JSONArray errorResponse) {
                        Log.e("MEUAPP", "onFailure JSONArray: " + statusCode, throwable);
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, String
                            responseString, Throwable throwable) {
                        Log.e("MEUAPP", "onFailure STRING: " + statusCode, throwable);
                        grandeAreaEditText.setText(statusCode + responseString+"\n\n"+ grandeAreaEditText.getText());
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable
                            throwable, JSONObject errorResponse) {
                        Log.e("MEUAPP", "onFailure JSONObject: " + statusCode, throwable);
                        grandeAreaEditText.setText(statusCode + errorResponse.toString()+"\n\n"+ grandeAreaEditText.getText());
                    }
                });
    }
}