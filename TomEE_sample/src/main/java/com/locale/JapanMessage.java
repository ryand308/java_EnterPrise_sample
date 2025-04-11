package com.locale;

import java.util.ListResourceBundle;
import java.util.Locale;

public class JapanMessage extends ListResourceBundle{

	@Override
	protected Object[][] getContents() {
		
		return contents;
	}
		
	static final Object[][] contents = {
		{"count.one", "いち"},
		{"count.two", "に"},
		{"count.three", "さん"},
		{"count.four", "し"},
		{"count.five", "ご"}	
	};
	
}
