package com.example.TodoList.services;

import com.example.TodoList.entity.Note;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FakeNoteService {


    List<Note> myNotes = new ArrayList<>();

    public List<Note> listAll() {
        return this.myNotes;
    }


    public Note add(Note note) {
        note.setId(note.getId());
        this.myNotes.add(note);
        return null;
    }


    public void deleteById(long id) {
        Note noteToRemove = null;
        for (Note note : myNotes) {
            if (note.getId() == id) {
                noteToRemove = note;
                break;
            }
        }
        if (noteToRemove != null) {
            myNotes.remove(noteToRemove);
            System.out.println("Note deleted.");
        }
    }


    public void update(Note note) {
        for (Note findNote : myNotes) {
            if (findNote.getId() == note.getId()) {
                findNote.setTitle(note.getTitle());
                findNote.setContent(note.getContent());
                break;
            }
        }
    }


    public Note getById(long id) {
        return myNotes.get((int) id);
    }

    public static void main(String[] args) {
        FakeNoteService fakeNoteService = new FakeNoteService();
        fakeNoteService.add(new Note(1, "MyTitle1", "Some text1"));
        fakeNoteService.add(new Note(2, "MyTitle2", "Some text2"));
        fakeNoteService.add(new Note(3, "MyTitle3", "Some text3"));
        fakeNoteService.add(new Note(4, "MyTitle4", "Some text4"));
        fakeNoteService.add(new Note(5, "MyTitle5", "Some text5"));
        fakeNoteService.add(new Note(6, "MyTitle6", "Some text6"));
        fakeNoteService.add(new Note(7, "MyTitle7", "Some text7"));


        System.out.println(fakeNoteService.listAll());

        fakeNoteService.deleteById(6);

        System.out.println(fakeNoteService.listAll());

        System.out.println(fakeNoteService.getById(5));

        fakeNoteService.update(new Note(2, "MyTitle Update", "Some text Update"));

        System.out.println(fakeNoteService.listAll());

        fakeNoteService.deleteById(2);

        System.out.println(fakeNoteService.listAll());

    }

}
