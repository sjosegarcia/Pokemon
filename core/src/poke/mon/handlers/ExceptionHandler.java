/*
 * The ExceptionHandler class writes the error 
 * that it catches to a specific file.
 * */
package poke.mon.handlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class ExceptionHandler {
	
	private FileHandle file = Gdx.files.internal("error.txt");
	boolean isExtAvailable = Gdx.files.isExternalStorageAvailable();
	boolean isLocAvailable = Gdx.files.isLocalStorageAvailable();
	
	public ExceptionHandler(String className, Exception e) {
		if(!isExtAvailable || !isLocAvailable) {
			return;
		}
		file.writeString(className + ":\n" +e.toString(), true);
	}
}
