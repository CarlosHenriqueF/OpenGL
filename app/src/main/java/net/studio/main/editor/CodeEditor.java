package net.studio.main.editor;

import android.widget.EditText;
import android.content.Context;
import android.graphics.Canvas;
import android.text.style.ForegroundColorSpan;
import android.text.Spannable;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.ListPopupWindow;
import android.widget.LinearLayout.LayoutParams;
import android.view.Gravity;
import net.studio.main.editor.destaque.Sintaxe;
import android.app.Activity;

public class CodeEditor extends EditText
{
	 private Keywords keyWords;
	 private ListPopupWindow autocomplete;
	 private Activity a;
	 private Sintaxe sin;
	 public static Canvas EDITOR_CANVAS;

	 public CodeEditor(Context ctx, Activity a)
	 {
			super(ctx);
			setHorizontallyScrolling(true);
			this.keyWords = new Keywords();
			setTypeface(Typeface.MONOSPACE);
			this.autocomplete = new ListPopupWindow(getContext());
			autocomplete.setAnchorView(this);
			setWidth(800);
			setHeight(450);
			setGravity(Gravity.TOP);
			this.a = a;
			this.sin = new Sintaxe(this, a);
			this.sin.setRunning(true);
			this.sin.start();
	 }

	 @Override
	 protected void onDraw(Canvas canvas)
	 {
			super.onDraw(canvas);
	 }

	 public void applyColor(int color, int inicio, int fim)
	 {
			getText().setSpan(new ForegroundColorSpan(color), inicio, fim, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
	 }

	 public int getIndiceInicioPalavra(String name)
	 {
			return getText().toString().lastIndexOf(name);
	 }

	 public int getIndiceFimPalavra(String name)
	 {
			return getText().toString().lastIndexOf(name) + name.length();
	 }

	 public Keywords getKeyWords()
	 {

			return keyWords;
	 }

	 public Sintaxe getDS()
	 {
			return sin;
	 }

}
