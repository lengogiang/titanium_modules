/**
 * Ti.StyledLabel Module
 * Copyright (c) 2010-2013 by Appcelerator, Inc. All Rights Reserved.
 * Please see the LICENSE included with this distribution for details.
 */

package ti.styledlabel.property;

import java.util.HashMap;

import ti.styledlabel.Util;

import android.text.ParcelableSpan;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;

public class BackgroundColor implements IProperty {

	@Override
	public void mixWithMap(HashMap<String, IProperty> map) {
		map.put("background-color", this);
	}

	@Override
	public ParcelableSpan getSpan(SpannableStringBuilder mSB, String value) {
		int c = Util.getHtmlColor(value);
		if (c != -1) {
			return new BackgroundColorSpan(c | 0xFF000000);
		} else {
			Util.e("Unknown background-color found: " + value);
		}
		return null;
	}

}
