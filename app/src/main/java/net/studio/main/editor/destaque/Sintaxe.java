package net.studio.main.editor.destaque;

import net.studio.main.editor.CodeEditor;
import net.studio.main.editor.Keywords;
import android.text.style.ForegroundColorSpan;
import android.graphics.Color;
import android.text.Spannable;
import android.util.Log;
import android.app.Activity;
import android.text.TextWatcher;
import android.text.Editable;
import android.graphics.Canvas;

public class Sintaxe extends Thread
{
	 private boolean running;
	 private CodeEditor editor;
	 private Keywords keyWords;
	 private Activity a;
	 private boolean processingDestaque;
	 private int[] numbers = {1,2,3,4,5,6,7,8,9};

	 public Sintaxe(CodeEditor editor, Activity a)
	 {
			this.editor = editor;
			this.keyWords = editor.getKeyWords();
			this.a = a;
	 }

	 public void setRunning(boolean running)
	 {
			this.running = running;
	 }

	 public boolean isRunning()
	 {
			return running;
	 }

	 @Override
	 public void run()
	 {	
			synchronized (this.editor)
			{
				 this.editor.addTextChangedListener(new TextWatcher()
						{

							 @Override
							 public void beforeTextChanged(CharSequence e, int p2, int p3, int p4)
							 {

							 }

							 @Override
							 public void onTextChanged(CharSequence e, int p2, int p3, int p4)
							 {

							 }

							 @Override
							 public void afterTextChanged(Editable e)
							 {
									processDestaque(e);
							 }

						});
			}
			
			while (running)
			{
				 this.editor.draw(new Canvas());
			}
	 }

	 private void processDestaque(Editable e)
	 {
			for (String s : keyWords.getKeyWords())
			{
				 if (s != keyWords.getKeyWords().
				     get(keyWords.getKeyWords().size() - 1))
				 {
						this.processingDestaque = true;
				 }
				 else
				 {
						this.processingDestaque = false;
				 }

				 if (e.toString().contains(s))
				 {
            int i = e.toString().lastIndexOf(s), f = i + s.length();

						addColorInText(e, i, f, Color.BLUE);
				 }
			}

			if (!this.processingDestaque)
			{
				 for (int i : numbers)
				 {
						if (e.toString().contains("" + i))
						{
							 int in = e.toString().lastIndexOf("" + i), f = in + 1;

							 addColorInText(e, in, f, Color.RED);
						}
				 }
			}
	 }

	 private void addColorInText(Editable e, int inicio, int fim, int cor)
	 {
			e.setSpan(new ForegroundColorSpan(cor), inicio, fim,
			          Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
	 }
}
