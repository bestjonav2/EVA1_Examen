package com.example.vale.eva1_examen_1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity
        implements  RadioGroup.OnCheckedChangeListener, Button.OnClickListener
{
    EditText edT1, edT2, edT3, edT4, edT5, edT6, edT7, edT8;
    RadioGroup RGF;
    RadioButton rbDe, rbBi;
    TextView TxtVIP, TxtVMa, TxtVSub, TxtVPre;
    Button btC, btB;
    int deci,deci2,deci3,deci4,deci5,deci6,deci7,deci8;
    String Des, S1,S2,S3,S4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        edT1 = findViewById(R.id.edT1);
        edT2 = findViewById(R.id.edT2);
        edT3 = findViewById(R.id.edT3);
        edT4 = findViewById(R.id.edT4);
        edT5 = findViewById(R.id.edT5);
        edT6 = findViewById(R.id.edT6);
        edT7 = findViewById(R.id.edT7);
        edT8 = findViewById(R.id.edT8);
        RGF = findViewById(R.id.RGF);
        rbDe = findViewById(R.id.rbDe);
        rbBi = findViewById(R.id.rbBi);
        TxtVIP = findViewById(R.id.TxtVIP);
        TxtVMa = findViewById(R.id.TxtVMa);
        TxtVSub = findViewById(R.id.TxtVSub);
        TxtVPre = findViewById(R.id.TxtVPre);
        btC = findViewById(R.id.btC);
        btB = findViewById(R.id.btB);

        btB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edT1.setText("");
                edT2.setText("");
                edT3.setText("");
                edT4.setText("");
                edT5.setText("");
                edT6.setText("");
                edT7.setText("");
                edT8.setText("");
                TxtVIP.setText("IP ");
                TxtVMa.setText("Mask ");
                TxtVSub.setText("Subred ");
                TxtVPre.setText("Prefijo ");


            }
        });

        btC.setOnClickListener(this);

        RGF.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) { //int es el id del boton que se presiono
        int deci1 = Integer.parseInt(edT1.getText().toString());
        int deci2 = Integer.parseInt(edT2.getText().toString());
        int deci3 = Integer.parseInt(edT3.getText().toString());
        int deci4 = Integer.parseInt(edT4.getText().toString());
        int deci5 = Integer.parseInt(edT5.getText().toString());
        int deci6 = Integer.parseInt(edT6.getText().toString());
        int deci7 = Integer.parseInt(edT7.getText().toString());
        int deci8 = Integer.parseInt(edT8.getText().toString());
        switch (checkedId) {
            case R.id.rbDe://aqui se sabe cual boton pico
                Des = "Decimal";
                TxtVIP.setText("IP  " + deci1 + ",  " + deci2 + ",  " + deci3 + ",  " + deci4);
                TxtVMa.setText("Mask  " + deci5 + ",  " + deci6 + ",  " + deci7 + ",  " + deci8);
                break;
            case R.id.rbBi:
                Des = "Binario";
                String bin1 = convert2Binary(deci1);
                String bin2 = convert2Binary(deci2);
                String bin3 = convert2Binary(deci3);
                String bin4 = convert2Binary(deci4);
                String bin5 = convert2Binary(deci5);
                String bin6 = convert2Binary(deci6);
                String bin7 = convert2Binary(deci7);
                String bin8 = convert2Binary(deci8);
                TxtVIP.setText("IP  " + bin1 + ",  " + bin2 + ",  " + bin3 + ",  " + bin4 );
                TxtVMa.setText("Mask  " + bin5 + ",  " + bin6 + ",  " + bin7 + ",  " + bin8 );
                break;
        }
    }

    public String convert2Binary(int num){
        String bin = Integer.toBinaryString(num);
        if(bin.length() < 8){
            int rest = 8 - bin.length();
            String r = "";
            for (int i = 0; i<rest; i++){
                r += "0";
            }
            bin  = r+bin;
        }
        return bin;
    }

    @Override
    public void onClick(View v) {
        int deci1 = Integer.parseInt(edT1.getText().toString());
        int deci2 = Integer.parseInt(edT2.getText().toString());
        int deci3 = Integer.parseInt(edT3.getText().toString());
        int deci4 = Integer.parseInt(edT4.getText().toString());
        int deci5 = Integer.parseInt(edT5.getText().toString());
        int deci6 = Integer.parseInt(edT6.getText().toString());
        int deci7 = Integer.parseInt(edT7.getText().toString());
        int deci8 = Integer.parseInt(edT8.getText().toString());
        boolean error = false;
        String errorMsg = "Error en: ";
        if(deci1 < 0 || deci1 > 255){
            errorMsg += "IP Octeto 1, ";
            error = true;
        }
        if(deci2 < 0 || deci2 > 255){
            errorMsg += "IP Octeto 2, ";
            error = true;
        }
        if(deci3 < 0 || deci3 > 255){
            errorMsg += "IP Octeto 3, ";
            error = true;
        }
        if(deci4 < 0 || deci4 > 255){
            errorMsg += "IP Octeto 3, ";
            error = true;
        }

        if(deci5 < 0 || deci5 > 255){
            errorMsg += "Mascara Octeto 1, ";
            error = true;
        }
        if(deci6 < 0 || deci6 > 255){
            errorMsg += "Mascara Octeto 2, ";
            error = true;
        }
        if(deci7 < 0 || deci7 > 255){
            errorMsg += "Mascara Octeto 3, ";
            error = true;
        }
        if(deci8 < 0 || deci8 > 255){
            errorMsg += "Mascara Octeto 4, ";
            error = true;
        }

        if(error){
            Toast.makeText(this, errorMsg,Toast.LENGTH_SHORT).show();
        }else {

            String bin1 = convert2Binary(deci1);
            String bin2 = convert2Binary(deci2);
            String bin3 = convert2Binary(deci3);
            String bin4 = convert2Binary(deci4);
            String bin5 = convert2Binary(deci5);
            String bin6 = convert2Binary(deci6);
            String bin7 = convert2Binary(deci7);
            String bin8 = convert2Binary(deci8);
            String newOct1 = "", newOct2 = "", newOct3 = "", newOct4 = "";
            int oct1 = 0, oct2 = 0, oct3 = 0, oct4 = 0;

            int prefix = 0;
            String mask = bin5 + bin6 + bin7 + bin8;
            Log.i("Mask", mask);
            for (int i = 1; i < mask.length(); i++) {
                if (i == 1 && Character.getNumericValue(mask.charAt(i - 1)) == 1) {
                    prefix++;
                }
                if (Character.getNumericValue(mask.charAt(i)) == 1 && Character.getNumericValue(mask.charAt(i - 1)) == 1) {
                    prefix++;
                }
            }

            for (int i = 0; i < 8; i++) {
                if (Character.getNumericValue(bin1.charAt(i)) == 1 && bin1.charAt(i) == bin5.charAt(i)) {
                    newOct1 += "1";
                } else {
                    newOct1 += "0";
                }
            }
            for (int i = 0; i < 8; i++) {
                if (Character.getNumericValue(bin2.charAt(i)) == 1 && bin2.charAt(i) == bin6.charAt(i)) {
                    newOct2 += "1";
                } else {
                    newOct2 += "0";
                }
            }
            for (int i = 0; i < 8; i++) {
                if (Character.getNumericValue(bin3.charAt(i)) == 1 && bin3.charAt(i) == bin7.charAt(i)) {
                    newOct3 += "1";
                } else {
                    newOct3 += "0";
                }
            }
            for (int i = 0; i < 8; i++) {
                if (Character.getNumericValue(bin4.charAt(i)) == 1 && bin4.charAt(i) == bin8.charAt(i)) {
                    newOct4 += "1";
                } else {
                    newOct4 += "0";
                }
            }

            oct1 = Integer.parseInt(newOct1, 2);
            oct2 = Integer.parseInt(newOct2, 2);
            oct3 = Integer.parseInt(newOct3, 2);
            oct4 = Integer.parseInt(newOct4, 2);

            TxtVSub.setText("Subred: " + oct1 + "." + oct2 + "." + oct3 + "." + oct4);
            TxtVPre.setText("Prefijo: /" + prefix);
        }
    }
}
