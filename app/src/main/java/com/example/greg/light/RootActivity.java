package com.example.greg.light;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;


public class RootActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		LinearLayout rootLayout = new LinearLayout(this);
		rootLayout.setOrientation(LinearLayout.VERTICAL);
		setTheme(android.R.style.Theme_Black);

		final ImageView light = new ImageView(this);
		light.setImageResource(R.drawable.indicatorbw);
		LinearLayout.LayoutParams lightParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 2);
		rootLayout.addView(light, lightParams);

		final Switch lightSwitch = new Switch(this);
		lightSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
				light.setImageResource(b ? R.drawable.indicatorgreen : R.drawable.indicatorbw);
			}
		});

		LinearLayout.LayoutParams lightSwitchParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 0, 1);
		lightSwitchParams.gravity = Gravity.CENTER_HORIZONTAL;
		rootLayout.addView(lightSwitch, lightSwitchParams);

		setContentView(rootLayout);
	}
}
