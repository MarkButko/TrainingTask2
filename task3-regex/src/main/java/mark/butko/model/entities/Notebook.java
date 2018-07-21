package mark.butko.model.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mark.butko.model.NoteConstructor;

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
	private static List<Note> notes = new ArrayList<Note>(
			Arrays.asList(new NoteConstructor().withEmail("already.existed@e.mail").build()));

	/**
	 * Adds new Note object to list
	 */
	public static void addNote(Note note) {
		notes.add(note);
	}

	/**
	 * @return Note object at index position in list
	 */
	public static Note getNote(int index) {
		return notes.get(index);
	}

	/**
	 * @return current number of Note objects in list
	 */
	public static int size() {
		return notes.size();
	}

	/**
	 * @return list of stored notes
	 */
	public static List<Note> getNotesList() {
		return notes;
	}
}
