package com.locale;

import java.util.ListResourceBundle;

public class TaiwanMessage extends ListResourceBundle{

	@Override
	protected Object[][] getContents() {
		
		Object[][] contents = {
			{"one", "壹"},
			{"two", "貮"},
			{"three", "參"}
		};
		return contents;
	}

}
