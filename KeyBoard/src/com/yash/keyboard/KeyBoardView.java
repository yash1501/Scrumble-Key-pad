package com.yash.keyboard;

import java.util.ArrayList;
import java.util.Collections;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class KeyBoardView extends LinearLayout implements OnClickListener {

	public static final int DONE_KEY = 501;
	public static final int DEL_KEY = 502;

	private int screenWidth;
	private int screenHeight;
	private Context context;
	private ArrayList<Key> alpha_keys = new ArrayList<Key>();
	private ArrayList<Key> numeric_keys = new ArrayList<Key>();
	private OnKeyClicked keyClickedListener;

	public interface OnKeyClicked {
		public void onKeyClicked(int code, int value);
	}

	public KeyBoardView(Context context, AttributeSet attributeSet) {
		super(context, attributeSet);
		this.context = context;
		this.setOrientation(LinearLayout.VERTICAL);
	}

	private void hide() {
		this.removeAllViews();
		alpha_keys.clear();
		numeric_keys.clear();
		Runtime.getRuntime().gc();
	}

	public void show(OnKeyClicked keyClickedListener, int width, int height) {
		this.setVisibility(View.GONE);
		Animation in = AnimationUtils.loadAnimation(getContext(),
				R.anim.view_slide_bottom_up_anim);
		this.startAnimation(in);
		this.setVisibility(View.VISIBLE);
		create(keyClickedListener, width, height);
	}

	private void create(OnKeyClicked keyClickedListener, int screenWidth,
			int screenHeight) {

		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;

		init();

		Collections.shuffle(alpha_keys);

		Collections.shuffle(numeric_keys);

		LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		this.setLayoutParams(layoutParams);
		LinearLayout firstRow = new LinearLayout(getContext());
		firstRow.setLayoutParams(layoutParams);

		for (int i = 0; i < 10; i++) {
			firstRow.addView(alpha_keys.get(i));
		}

		LinearLayout secondRow = new LinearLayout(getContext());
		secondRow.setLayoutParams(layoutParams);

		for (int i = 0; i < 10; i++) {
			secondRow.addView(alpha_keys.get(i + 10));
		}

		LinearLayout thirdRow = new LinearLayout(getContext());
		thirdRow.setLayoutParams(layoutParams);

		for (int i = 0; i < 6; i++) {
			thirdRow.addView(alpha_keys.get(i + 20));
		}

		for (int i = 0; i < 4; i++) {
			thirdRow.addView(numeric_keys.get(i));
		}

		LinearLayout fourthRow = new LinearLayout(getContext());
		fourthRow.setLayoutParams(layoutParams);

		for (int i = 0; i < 6; i++) {
			fourthRow.addView(numeric_keys.get(i + 4));
		}

		MetaData metaData36 = new MetaData();
		metaData36.setCode(DONE_KEY);
		metaData36.setText("Done");
		metaData36.setValue(DONE_KEY);
		Key key36 = new Key(getContext(), metaData36, getKeyWidth() * 2);
		key36.setOnClickListener(this);
		fourthRow.addView(key36);

		MetaData metaData37 = new MetaData();
		metaData37.setCode(DEL_KEY);
		metaData37.setText("Del");
		metaData37.setValue(DEL_KEY);
		Key key37 = new Key(getContext(), metaData37, getKeyWidth() * 2);
		key37.setOnClickListener(this);
		fourthRow.addView(key37);

		this.addView(firstRow);
		this.addView(secondRow);
		this.addView(thirdRow);
		this.addView(fourthRow);

		this.keyClickedListener = keyClickedListener;
	}

	private int getKeyWidth() {
		return this.screenWidth / 10;
	}

	@Override
	public void setVisibility(int visibility) {
		if (visibility == View.GONE) {
			hide();
		}
		super.setVisibility(visibility);
	}

	@Override
	public void onClick(View v) {
		if (v instanceof Key) {
			MetaData metaData = (MetaData) v.getTag();
			keyClickedListener.onKeyClicked(metaData.getCode(),
					metaData.getValue());
		}
	}

	private void init() {
		MetaData metaData = new MetaData();
		metaData.setCode(100);
		metaData.setText("1");
		metaData.setValue(1);
		Key key1 = new Key(getContext(), metaData, getKeyWidth());
		key1.setOnClickListener(this);
		numeric_keys.add(key1);

		MetaData metaData1 = new MetaData();
		metaData1.setCode(100);
		metaData1.setText("2");
		metaData1.setValue(2);
		Key key2 = new Key(getContext(), metaData1, getKeyWidth());
		key2.setOnClickListener(this);
		numeric_keys.add(key2);

		MetaData metaData2 = new MetaData();
		metaData2.setCode(100);
		metaData2.setText("3");
		metaData2.setValue(3);
		Key key3 = new Key(getContext(), metaData2, getKeyWidth());
		key3.setOnClickListener(this);
		numeric_keys.add(key3);

		MetaData metaData3 = new MetaData();
		metaData3.setCode(100);
		metaData3.setText("4");
		metaData3.setValue(4);
		Key key4 = new Key(getContext(), metaData3, getKeyWidth());
		key4.setOnClickListener(this);
		numeric_keys.add(key4);

		MetaData metaData4 = new MetaData();
		metaData4.setCode(100);
		metaData4.setText("5");
		metaData4.setValue(5);
		Key key5 = new Key(getContext(), metaData4, getKeyWidth());
		key5.setOnClickListener(this);
		numeric_keys.add(key5);

		MetaData metaData5 = new MetaData();
		metaData5.setCode(100);
		metaData5.setText("6");
		metaData5.setValue(6);
		Key key6 = new Key(getContext(), metaData5, getKeyWidth());
		key6.setOnClickListener(this);
		numeric_keys.add(key6);

		MetaData metaData6 = new MetaData();
		metaData6.setCode(100);
		metaData6.setText("7");
		metaData6.setValue(7);
		Key key7 = new Key(getContext(), metaData6, getKeyWidth());
		key7.setOnClickListener(this);
		numeric_keys.add(key7);

		MetaData metaData7 = new MetaData();
		metaData7.setCode(100);
		metaData7.setText("8");
		metaData7.setValue(8);
		Key key8 = new Key(getContext(), metaData7, getKeyWidth());
		key8.setOnClickListener(this);
		numeric_keys.add(key8);

		MetaData metaData8 = new MetaData();
		metaData8.setCode(100);
		metaData8.setText("9");
		metaData8.setValue(9);
		Key key9 = new Key(getContext(), metaData8, getKeyWidth());
		key9.setOnClickListener(this);
		numeric_keys.add(key9);

		MetaData metaData9 = new MetaData();
		metaData9.setCode(100);
		metaData9.setText("0");
		metaData9.setValue(0);
		Key key0 = new Key(getContext(), metaData9, getKeyWidth());
		key0.setOnClickListener(this);
		numeric_keys.add(key0);

		MetaData metaData10 = new MetaData();
		metaData10.setCode(100);
		metaData10.setText("a");
		metaData10.setValue(97);
		Key key10 = new Key(getContext(), metaData10, getKeyWidth());
		key10.setOnClickListener(this);
		alpha_keys.add(key10);

		MetaData metaData11 = new MetaData();
		metaData11.setCode(100);
		metaData11.setText("b");
		metaData11.setValue(98);
		Key key11 = new Key(getContext(), metaData11, getKeyWidth());
		key11.setOnClickListener(this);
		alpha_keys.add(key11);

		MetaData metaData12 = new MetaData();
		metaData12.setCode(100);
		metaData12.setText("c");
		metaData12.setValue(99);
		Key key12 = new Key(getContext(), metaData12, getKeyWidth());
		key12.setOnClickListener(this);
		alpha_keys.add(key12);

		MetaData metaData13 = new MetaData();
		metaData13.setCode(100);
		metaData13.setText("d");
		metaData13.setValue(100);
		Key key13 = new Key(getContext(), metaData13, getKeyWidth());
		key13.setOnClickListener(this);
		alpha_keys.add(key13);

		MetaData metaData14 = new MetaData();
		metaData14.setCode(100);
		metaData14.setText("e");
		metaData14.setValue(101);
		Key key14 = new Key(getContext(), metaData14, getKeyWidth());
		key14.setOnClickListener(this);
		alpha_keys.add(key14);

		MetaData metaData15 = new MetaData();
		metaData15.setCode(100);
		metaData15.setText("f");
		metaData15.setValue(102);
		Key key15 = new Key(getContext(), metaData15, getKeyWidth());
		key15.setOnClickListener(this);
		alpha_keys.add(key15);

		MetaData metaData16 = new MetaData();
		metaData16.setCode(100);
		metaData16.setText("g");
		metaData16.setValue(103);
		Key key16 = new Key(getContext(), metaData16, getKeyWidth());
		key16.setOnClickListener(this);
		alpha_keys.add(key16);

		MetaData metaData17 = new MetaData();
		metaData17.setCode(100);
		metaData17.setText("h");
		metaData17.setValue(104);
		Key key17 = new Key(getContext(), metaData17, getKeyWidth());
		key17.setOnClickListener(this);
		alpha_keys.add(key17);

		MetaData metaData18 = new MetaData();
		metaData18.setCode(100);
		metaData18.setText("i");
		metaData18.setValue(105);
		Key key18 = new Key(getContext(), metaData18, getKeyWidth());
		key18.setOnClickListener(this);
		alpha_keys.add(key18);

		MetaData metaData19 = new MetaData();
		metaData19.setCode(100);
		metaData19.setText("j");
		metaData19.setValue(106);
		Key key19 = new Key(getContext(), metaData19, getKeyWidth());
		key19.setOnClickListener(this);
		alpha_keys.add(key19);

		MetaData metaData20 = new MetaData();
		metaData20.setCode(100);
		metaData20.setText("k");
		metaData20.setValue(107);
		Key key20 = new Key(getContext(), metaData20, getKeyWidth());
		key20.setOnClickListener(this);
		alpha_keys.add(key20);

		MetaData metaData21 = new MetaData();
		metaData21.setCode(100);
		metaData21.setText("l");
		metaData21.setValue(108);
		Key key21 = new Key(getContext(), metaData21, getKeyWidth());
		key21.setOnClickListener(this);
		alpha_keys.add(key21);

		MetaData metaData22 = new MetaData();
		metaData22.setCode(100);
		metaData22.setText("m");
		metaData22.setValue(109);
		Key key22 = new Key(getContext(), metaData22, getKeyWidth());
		key22.setOnClickListener(this);
		alpha_keys.add(key22);

		MetaData metaData23 = new MetaData();
		metaData23.setCode(100);
		metaData23.setText("n");
		metaData23.setValue(110);
		Key key23 = new Key(getContext(), metaData23, getKeyWidth());
		key23.setOnClickListener(this);
		alpha_keys.add(key23);

		MetaData metaData24 = new MetaData();
		metaData24.setCode(100);
		metaData24.setText("o");
		metaData24.setValue(111);
		Key key24 = new Key(getContext(), metaData24, getKeyWidth());
		key24.setOnClickListener(this);
		alpha_keys.add(key24);

		MetaData metaData25 = new MetaData();
		metaData25.setCode(100);
		metaData25.setText("p");
		metaData25.setValue(112);
		Key key25 = new Key(getContext(), metaData25, getKeyWidth());
		key25.setOnClickListener(this);
		alpha_keys.add(key25);

		MetaData metaData26 = new MetaData();
		metaData26.setCode(100);
		metaData26.setText("q");
		metaData26.setValue(113);
		Key key26 = new Key(getContext(), metaData26, getKeyWidth());
		key26.setOnClickListener(this);
		alpha_keys.add(key26);

		MetaData metaData27 = new MetaData();
		metaData27.setCode(100);
		metaData27.setText("r");
		metaData27.setValue(114);
		Key key27 = new Key(getContext(), metaData27, getKeyWidth());
		key27.setOnClickListener(this);
		alpha_keys.add(key27);

		MetaData metaData28 = new MetaData();
		metaData28.setCode(100);
		metaData28.setText("s");
		metaData28.setValue(115);
		Key key28 = new Key(getContext(), metaData28, getKeyWidth());
		key28.setOnClickListener(this);
		alpha_keys.add(key28);

		MetaData metaData29 = new MetaData();
		metaData29.setCode(100);
		metaData29.setText("t");
		metaData29.setValue(116);
		Key key29 = new Key(getContext(), metaData29, getKeyWidth());
		key29.setOnClickListener(this);
		alpha_keys.add(key29);

		MetaData metaData30 = new MetaData();
		metaData30.setCode(100);
		metaData30.setText("u");
		metaData30.setValue(117);
		Key key30 = new Key(getContext(), metaData30, getKeyWidth());
		key30.setOnClickListener(this);
		alpha_keys.add(key30);

		MetaData metaData31 = new MetaData();
		metaData31.setCode(100);
		metaData31.setText("v");
		metaData31.setValue(118);
		Key key31 = new Key(getContext(), metaData31, getKeyWidth());
		key31.setOnClickListener(this);
		alpha_keys.add(key31);

		MetaData metaData32 = new MetaData();
		metaData32.setCode(100);
		metaData32.setText("w");
		metaData32.setValue(119);
		Key key32 = new Key(getContext(), metaData32, getKeyWidth());
		key32.setOnClickListener(this);
		alpha_keys.add(key32);

		MetaData metaData33 = new MetaData();
		metaData33.setCode(100);
		metaData33.setText("x");
		metaData33.setValue(120);
		Key key33 = new Key(getContext(), metaData33, getKeyWidth());
		key33.setOnClickListener(this);
		alpha_keys.add(key33);

		MetaData metaData34 = new MetaData();
		metaData34.setCode(100);
		metaData34.setText("y");
		metaData34.setValue(121);
		Key key34 = new Key(getContext(), metaData34, getKeyWidth());
		key34.setOnClickListener(this);
		alpha_keys.add(key34);

		MetaData metaData35 = new MetaData();
		metaData35.setCode(100);
		metaData35.setText("z");
		metaData35.setValue(122);
		Key key35 = new Key(getContext(), metaData35, getKeyWidth());
		key35.setOnClickListener(this);
		alpha_keys.add(key35);

	}

}
