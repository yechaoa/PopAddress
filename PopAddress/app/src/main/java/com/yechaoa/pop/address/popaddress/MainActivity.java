package com.yechaoa.pop.address.popaddress;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView1, textView2;
    private Button button1, button2;
    private PopHelper popHelper;//pop

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
    }

    /**
     * 实现popHelper中的item接口
     */
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_pop_address_cencel:
                    popHelper.colsePopupwindow();
                    break;
                case R.id.btn_pop_address_enter:
                    String addressData = popHelper.getAddressData();
                    if (flag) {
                        textView1.setText(addressData);
                    } else {
                        textView2.setText(addressData);
                    }
                    popHelper.colsePopupwindow();
                    break;
            }
        }
    };

    boolean flag;//用于pop标记显示,避免多个地方显示却只填充一个textview的情况

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                popHelper = new PopHelper(getApplicationContext());
                popHelper.showAddressPop(v, MainActivity.this, onClickListener);
                flag = true;
                break;
            case R.id.button2:
                popHelper = new PopHelper(getApplicationContext());
                popHelper.showAddressPop(v, MainActivity.this, onClickListener);
                flag = false;
                break;
        }
    }
}
