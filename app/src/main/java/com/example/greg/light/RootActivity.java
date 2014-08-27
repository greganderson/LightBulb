package com.example.greg.light;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;


public class RootActivity extends Activity {

    private Switch lightSwitch;
    private Switch colorSwitch;
    private ImageView light;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout rootLayout = new LinearLayout(this);
        rootLayout.setOrientation(LinearLayout.VERTICAL);

        light = new ImageView(this);
        light.setImageResource(R.drawable.indicatorbw);
        rootLayout.addView(light);

        lightSwitch = new Switch(this);
        lightSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lightSwitch.isChecked())
                    setLight();
                else
                    light.setImageResource(R.drawable.indicatorbw);
            }
        });

        colorSwitch = new Switch(this);
        colorSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lightSwitch.isChecked())
                    setLight();
            }
        });

        rootLayout.addView(lightSwitch);
        rootLayout.addView(colorSwitch);

        setContentView(rootLayout);
    }

    private void setLight() {
        if (colorSwitch.isChecked())
            light.setImageResource(R.drawable.indicatorgreen);
        else
            light.setImageResource(R.drawable.indicatorbright);
    }
}
