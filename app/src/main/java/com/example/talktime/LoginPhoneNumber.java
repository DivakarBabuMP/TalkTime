package com.example.talktime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.hbb20.CountryCodePicker;

public class LoginPhoneNumber extends AppCompatActivity {
    CountryCodePicker countryCodePicker;
    EditText phoneNo;
    Button SendOtp;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_phone_number);
        countryCodePicker=findViewById(R.id.Country_code);
        phoneNo=findViewById(R.id.MobileNumber);
        SendOtp=findViewById(R.id.OTP);
        progressBar=findViewById(R.id.Login_progressbar);
        countryCodePicker.registerCarrierNumberEditText(phoneNo);
        progressBar.setVisibility(View.GONE);
        SendOtp.setOnClickListener((v)->{
            if(!countryCodePicker.isValidFullNumber()){
                phoneNo.setError("Sorry!.Not a valid number");
            }
            Intent intent=new Intent(LoginPhoneNumber.this, loginOTP.class);
            intent.putExtra("phone",countryCodePicker.getFullNumberWithPlus());
            startActivity(intent);
        });
    }
}