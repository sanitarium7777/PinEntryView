package me.philio.pinentry.demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import me.philio.pinentry.PinEntryView;

public class MainActivity extends Activity {

    private PinEntryView pinEntryView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pinEntryView = (PinEntryView) findViewById(R.id.pin_entry_simple);
        pinEntryView.setOnPinEnteredListener(new PinEntryView.OnPinEnteredListener() {
            @Override
            public void onPinEntered(String pin) {

                pinEntryView.splash(ContextCompat.getColor(getApplicationContext(), R.color.red),
                        1000, new PinEntryView.OnSplashListener() {
                            @Override
                            public void onFinished() {
                                pinEntryView.clearText();
                            }
                        });
//                pinEntryView.clearText();
                Toast.makeText(MainActivity.this, "Pin entered: " + pin, Toast.LENGTH_LONG).show();
            }
        });
    }

}
