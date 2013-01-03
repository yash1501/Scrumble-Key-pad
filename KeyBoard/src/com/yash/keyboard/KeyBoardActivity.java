package com.yash.keyboard;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;

import com.yash.keyboard.KeyBoardView.OnKeyClicked;

public class KeyBoardActivity extends Activity implements OnKeyClicked {
	private KeyBoardView keyBoardView;
	private EditText editText;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		keyBoardView = (KeyBoardView) findViewById(R.id.keyBoardView);
		editText = (EditText) findViewById(R.id.editText1);
		editText.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					keyBoardView.show(KeyBoardActivity.this, getWindowManager()
							.getDefaultDisplay().getWidth(), getWindowManager()
							.getDefaultDisplay().getHeight());
				}
				return true;
			}
		});
	}

	@Override
	public void onKeyClicked(int code, int value) {
		Editable text = editText.getText();
		StringBuffer buffer = new StringBuffer(text);
		if (value == KeyBoardView.DEL_KEY) {
			if (buffer.length() != 0) {
				buffer.deleteCharAt(buffer.length() - 1);
			} else {
				return;
			}
		} else if (value == KeyBoardView.DONE_KEY) {
			keyBoardView.setVisibility(View.GONE);
			return;
		} else {
			if (Character.isLetter(value)) {
				buffer.append((char) value);
			} else {
				buffer.append(value);
			}
		}
		editText.setText(buffer.toString());
		editText.setSelection(buffer.length());
	}
}