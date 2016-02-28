package net.studio.main.ide;

import java.util.List;
import java.util.ArrayList;
import java.io.InputStream;
import net.studio.main.MainActivity;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import android.util.Log;

public class ModPE
{
	 private List<String> hooks = new ArrayList<>();
	 private List<String> functions = new ArrayList<>();
	 private static final String TAG = "ModPE";
	 private static final String FILE_NAME_HOOK = "hooks.txt";
	 private static final String FILE_NAME_FUNCTION = "functions.txt";
	 
	 public ModPE()
	 {
			getHooks(FILE_NAME_HOOK);
			getFunctions(FILE_NAME_FUNCTION);
	 }
	 
	 private void getHooks(String directory)
	 {		
			InputStream is = null;
			InputStreamReader isr = null;
			BufferedReader br = null;
			String nextLine = null;
			
			try
			{
				 is = MainActivity.APP_CONTEXT.getAssets().open(directory);
				 isr = new InputStreamReader(is);
				 br = new BufferedReader(isr);
				 
				 while ( (nextLine = br.readLine()) != null)
				 {
						this.hooks.add(nextLine);
				 }
				 
				 br.close();
			}
			catch (IOException io)
			{
				 Log.e(TAG, "getHooks: " + io.toString());
			}
			
	 }
	 
	 private void getFunctions(String directory)
	 {
			InputStream is = null;
			InputStreamReader isr = null;
			BufferedReader br = null;
			String nextLine = null;
			
			try
			{
				 is = MainActivity.APP_CONTEXT.getAssets().open(directory);
				 isr = new InputStreamReader(is);
				 br = new BufferedReader(isr);
				 
				 while ( (nextLine = br.readLine()) != null)
				 {
						this.functions.add(nextLine);
				 }
				 
				 br.close();
			}
			catch (IOException io)
			{
				 Log.e(TAG, "getFunctions: " + io.toString());
			}
	 }
	 
}
