package lm.com.lmapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonINR = null;
    private Button buttonAED = null;
    private Button buttonSAR = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        buttonINR = (Button)findViewById(R.id.butINR);
        buttonAED = (Button)findViewById(R.id.butAED);
        buttonSAR = (Button)findViewById(R.id.butSAR);

        buttonINR.setOnClickListener(MainActivity.this);
        buttonAED.setOnClickListener(MainActivity.this);
        buttonSAR.setOnClickListener(MainActivity.this);

        buttonINR.setActivated(true);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.butINR:
                setButtonState(true,false,false);
                break;
            case R.id.butAED:
                setButtonState(false,true,false);
                break;
            case R.id.butSAR:
                setButtonState(false,false,true);
                break;
        }

    }

    private void setButtonState(boolean inrSelected, boolean aedSelected, boolean sarSelected){
        buttonINR.setActivated(inrSelected);
        buttonAED.setActivated(aedSelected);
        buttonSAR.setActivated(sarSelected);
    }
}
