/*
 * Copyright (C) 2008,2009  OMRON SOFTWARE Co., Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.gorry.android.input.nicownng.EN;

import net.gorry.android.input.nicownng.NicoWnnGEN;
import net.gorry.android.input.nicownng.NicoWnnGEvent;
import net.gorry.android.input.nicownng.R;
import net.gorry.android.input.nicownng.WnnWord;
import android.content.Context;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.widget.Toast;

/**
 * The preference class to clear user dictionary for English IME.
 *
 * @author Copyright (C) 2009 OMRON SOFTWARE CO., LTD.  All Rights Reserved.
 */
public class ClearUserDictionaryDialogPreferenceEN extends DialogPreference {
	/** The context */
	protected Context mContext = null;

	/**
	 * Constructor
	 *
	 * @param context   The context
	 * @param attrs     The set of attributes
	 */
	public ClearUserDictionaryDialogPreferenceEN(final Context context, final AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
	}

	/**
	 * Constructor
	 *
	 * @param context   The context
	 */
	public ClearUserDictionaryDialogPreferenceEN(final Context context) {
		this(context, null);
	}

	/** @see android.preference.DialogPreference#onDialogClosed */
	@Override protected void onDialogClosed(final boolean positiveResult) {
		if (positiveResult) {
			/* clear the user dictionary */
			final NicoWnnGEvent ev = new NicoWnnGEvent(NicoWnnGEvent.INITIALIZE_USER_DICTIONARY, new WnnWord());
			NicoWnnGEN.getInstance().onEvent(ev);

			/* show the message */
			Toast.makeText(mContext.getApplicationContext(), R.string.dialog_clear_user_dictionary_done,
					Toast.LENGTH_LONG).show();
		}
	}

}
