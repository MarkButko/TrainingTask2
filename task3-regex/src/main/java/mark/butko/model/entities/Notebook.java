package mark.butko.model.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Note objects container
 * 
 * @autor Butko Mark
 * @version 1.0
 */
public class Notebook {
	/**
	 * List of Note objects
	 */
	private List<Note> notes = new ArrayList<Note>();

	/**
	 * Adds new Note object to list
	 */
	public void addNote(Note note) {
		notes.add(note);
	}

	/**
	 * @return Note object at index position in list
	 */
	public Note getNote(int index) {
		return notes.get(index);
	}

	/**
	 * @return current number of Note objects in list
	 */
	public int size() {
		return notes.size();
	}
}
