package net.studio.main.editor;

import java.util.List;
import java.util.ArrayList;

public class Keywords
{
	 private List<String> keywords = new ArrayList<>();
	 private String[] stringWords = {"var", "if", "else", "switch", "return"};

	 public Keywords()
	 {
			for (String s : stringWords)
			{
				 keywords.add(s);
			}

	 }

	 public void addNewKeyWord(String keyW)
	 {
			this.keywords.add(keyW);
	 }

	 public void removeKeyWord(String keyW)
	 {
			this.keywords.remove(keyW);
	 }

	 public List<String> getKeyWords()
	 {
			return this.keywords;
	 }

}
