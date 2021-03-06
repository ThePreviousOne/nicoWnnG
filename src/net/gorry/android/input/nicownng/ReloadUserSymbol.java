/**
 * 
 */
package net.gorry.android.input.nicownng;

import android.content.Context;
import android.os.Environment;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.widget.Toast;

/**
 * @author gorry
 *
 */
public class ReloadUserSymbol extends DialogPreference {

	private Context me;
	
	public ReloadUserSymbol(final Context context, final AttributeSet attrs) {
		super(context, attrs);
		me = context;
	}

	public ReloadUserSymbol(final Context context) {
		this(context, null);
	}

	@Override
	protected void onDialogClosed(final boolean positiveResult) {
		super.onDialogClosed(positiveResult);
		
		if (positiveResult) {
			SymbolList.copyUserSymbolDicFileToExternalStorageDirectory(me, false);
			if (NicoWnnGJAJP.getInstance() == null) {
				new NicoWnnGJAJP(me);
			}
			boolean loaded = NicoWnnGJAJP.getInstance().reloadSymbol();
			if (loaded) {
				Toast.makeText(me, R.string.preference_nicownng_reload_usersymbol_success, Toast.LENGTH_LONG).show();
			} else {
				Toast.makeText(me, R.string.preference_nicownng_reload_usersymbol_failed, Toast.LENGTH_LONG).show();
			}
		}
	}
}
