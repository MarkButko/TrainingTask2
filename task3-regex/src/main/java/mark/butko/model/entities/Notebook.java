package mark.butko.model.entities;

import java.util.ArrayList;
import java.util.List;

public class Notebook {
	private List<Note> notes = new ArrayList<Note>();

	public void addNote(Note note) {
		notes.add(note);
	}

	public Note getNote(int index) {
		return notes.get(index);
	}

	public int size() {
		return notes.size();
	}
}
