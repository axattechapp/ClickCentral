package com.axat.clickcentral.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;
import androidx.databinding.DataBindingUtil;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnticipateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.axat.clickcentral.Api;
import com.axat.clickcentral.R;
import com.axat.clickcentral.databinding.ActivityLogInactivityBinding;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class LogINActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityLogInactivityBinding binding;
    OkHttpClient client;
    Gson gson;
    Api api;
    Retrofit retrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         binding = DataBindingUtil.setContentView(this,R.layout.activity_log_inactivity);

        client = new OkHttpClient.Builder()
                .connectTimeout(8, TimeUnit.MINUTES)
                .writeTimeout(8, TimeUnit.MINUTES)
                .readTimeout(8, TimeUnit.MINUTES)
                .build();

        gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addConverterFactory(ScalarsConverterFactory.create())
                .client(client)
                .build();

        api = retrofit.create(Api.class);





        binding.textLogin.setOnClickListener(this);
        binding.textCreateNew.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view == binding.textLogin){
            showLogin();

        }
        else if(view == binding.textCreateNew){
            showRegister();
        }

    }

    public void showLogin(){
        LayoutInflater inflater2 = (LayoutInflater)LogINActivity.this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View view3 = inflater2.inflate(R.layout.login_popup, null);
        EditText email=view3.findViewById(R.id.edemail);
        EditText password=view3.findViewById(R.id.edpassword);
        ImageView imgclose=view3.findViewById(R.id.imgclose);
        Button btnsign=view3.findViewById(R.id.btnsign);

        android.app.AlertDialog.Builder builder2 = new android.app.AlertDialog.Builder( LogINActivity.this);
        builder2.setView(view3);
        final android.app.AlertDialog alertDialog3 = builder2.create();

        btnsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailString=email.getText().toString();
                String passwordString=password.getText().toString();
                Log.e("emailString", emailString);
                Log.e("passwordString", passwordString);

                JsonObject object = new JsonObject();
                object.addProperty("username", Objects.requireNonNull(email.getText()).toString().trim());
                object.addProperty("password",password.getText().toString().trim());

                Call<String> call=api.login(object);
                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {

//                        if (response.code()==200)
//                        {
////                            Log.e("token",response.body().toString());
////                            Log.e("Success", response.message());
//                            startActivity(new Intent(LogINActivity.this,HomeActivity.class));
//                        }else {
//                            try {
//                                JSONObject jObjError = new JSONObject(response.errorBody().string());
//
////                                ToastUtility.errorToast(LoginActivity.this, "Error : " + jObjError.getString("msg") + " " + response.code());
//                                Log.e("er2", jObjError.getString("message") + " " + response.code());
//
//                            } catch (Exception e) {
////                                ToastUtility.errorToast(LoginActivity.this, e.getMessage());
//                                Log.e("er1", e.getMessage());
//
//                            }
//                        }
//                        Log.i("Response", response.body().toString());
                        //Toast.makeText()
                        if (response.isSuccessful()) {
                            if (response.body() != null) {
                                Log.e("onSuccess", response.body().toString());
                                alertDialog3.dismiss();
                                Intent intent=new Intent(LogINActivity.this,HomeActivity.class);
                                intent.putExtra("value",1);
                                startActivity(intent);
//                                startActivity(new Intent(LogINActivity.this,HomeActivity.class));

                            } else {
                                Log.e("onEmptyResponse", "Returned empty response");//Toast.makeText(getContext(),"Nothing returned",Toast.LENGTH_LONG).show();
                            }
                        }else {
                            try {
                                alertDialog3.dismiss();
                                JSONObject jObjError = new JSONObject(response.errorBody().string());
//
////                                ToastUtility.errorToast(LoginActivity.this, "Error : " + jObjError.getString("msg") + " " + response.code());
//                                Log.e("er2", jObjError.getString("msg")+" "+response.code());
                                Toast.makeText(LogINActivity.this, "Error : " + jObjError.getString("message"), Toast.LENGTH_SHORT).show();

                                Log.e("er1", response.message());
                                Log.e("er1", String.valueOf(response.code()));

                            } catch (Exception e) {
                                alertDialog3.dismiss();
//                                ToastUtility.errorToast(LoginActivity.this, e.getMessage());
                                Log.e("er1", e.getMessage());

                            }
                        }


                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.e("error12", t.getMessage());
                    }
                });

            }
        });

        imgclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog3.dismiss();
            }
        });

        alertDialog3.show();
        alertDialog3.setCancelable(true);
        alertDialog3.getWindow().setGravity(Gravity.CENTER);
    }


    public void showRegister(){
        LayoutInflater inflater2 = (LayoutInflater)LogINActivity.this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View view3 = inflater2.inflate(R.layout.register_popup, null);
        ImageView imgclose=view3.findViewById(R.id.imgclose);

        android.app.AlertDialog.Builder builder2 = new android.app.AlertDialog.Builder( LogINActivity.this);
        builder2.setView(view3);
        final android.app.AlertDialog alertDialog3 = builder2.create();


        imgclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog3.dismiss();
            }
        });

        alertDialog3.show();
        alertDialog3.setCancelable(true);
        alertDialog3.getWindow().setGravity(Gravity.CENTER);
    }

}