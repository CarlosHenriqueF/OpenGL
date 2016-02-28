package net.studio.main;

import android.app.Activity;
import android.os.Bundle;
import net.studio.main.editor.CodeEditor;
import android.widget.LinearLayout;
import android.widget.ListPopupWindow;
import android.widget.EditText;
import android.widget.ArrayAdapter;
import android.content.Context;

public class MainActivity extends Activity
{
	 private CodeEditor editor;
	 public static Context APP_CONTEXT;

	 @Override
	 protected void onCreate(Bundle savedInstanceState)
	 {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.main);
			
			this.APP_CONTEXT = this;

			editor = new CodeEditor(this, MainActivity.this);
      LinearLayout ll = (LinearLayout)findViewById(R.id.mainLinearLayout);

			ll.addView(editor);
	 }

	 @Override
	 protected void onDestroy()
	 {
			boolean retry = true;
			editor.getDS().setRunning(false);

			while (retry)
			{
				 try
				 {
						editor.getDS().join();
				 }
				 catch (InterruptedException e)
				 {}

				 retry = false;
			}

			super.onDestroy();
	 }

}
