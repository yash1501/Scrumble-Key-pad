package com.yash.keyboard;

import android.content.Context;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;

/**
 * @author Yash Harpale
 *
 */
public class Key extends Button {

	public Key(Context context, MetaData metaData, int width) {
		super(context);
		if (metaData.getCode() == 101) {
			this.setBackgroundResource(R.drawable.custom_big_key);
		} else {
			this.setBackgroundResource(R.drawable.custom_small_key);
		}

		this.setTag(metaData);
		this.setText(metaData.getText());
		LayoutParams layoutParams = new LayoutParams(width,
				LayoutParams.WRAP_CONTENT);
		this.setLayoutParams(layoutParams);
	}
}
