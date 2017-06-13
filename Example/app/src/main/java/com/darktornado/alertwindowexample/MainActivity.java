package com.darktornado.alertwindowexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(1);
        Button btn = new Button(this);
        btn.setText("Show AlertWindow");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showWindow();
            }
        });
        layout.addView(btn);
        Button btn2 = new Button(this);
        btn2.setText("Show AlertWindow with view");
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showWindow2();
            }
        });
        layout.addView(btn2);
        int pad = dip2px(10);
        layout.setPadding(pad, pad, pad, pad);
        setContentView(layout);
    }

    private void showWindow(){
        try{
            AlertWindow window = new AlertWindow(this);
            window.setTitle("Title");
            window.setMessage("Message!");
            window.show();
        }catch (Exception e){
            toast(e.toString());
        }
    }

    private void showWindow2(){
        try{
            final AlertWindow window = new AlertWindow(this);
            window.setTitle("Title");
            LinearLayout layout = new LinearLayout(this);
            layout.setOrientation(1);
            TextView txt1 = new TextView(this);
            txt1.setText("Input : ");
            txt1.setTextSize(17);
            layout.addView(txt1);
            final EditText txt2 = new EditText(this);
            txt2.setHint("Input Text...");
            layout.addView(txt2);
            window.setView(layout);
            window.setButton("Lalala!", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toast(txt2.getText().toString());
                    window.close();
                }
            });
            window.show();
        }catch (Exception e){
            toast(e.toString());
        }
    }

    private int dip2px(int dips){
        return (int)Math.ceil(dips*this.getResources().getDisplayMetrics().density);
    }

    private void toast(final String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
