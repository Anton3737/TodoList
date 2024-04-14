package com.example.TodoList;

import com.example.TodoList.dao_interface.NoteDao;
import com.example.TodoList.entity.Note;
import com.example.TodoList.services.NoteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class TodoListApplicationTests {

    List<Note> myNotes = new ArrayList<>();

    @Test
    public void testListAll() {

        // Створюємо екземпляр NoteService та додаємо нотатки в його список
        NoteService noteService = new NoteService();
        Note note1 = new Note(1, "Title1", "Content1");
        Note note2 = new Note(2, "Title2", "Content2");
        Note note3 = new Note(3, "Title3", "Content3");
        Note note4 = new Note(4, "Title4", "Content4");
        Note note5 = new Note(5, "Title5", "Content5");

        myNotes.add(note1);
        myNotes.add(note2);
        myNotes.add(note3);
        myNotes.add(note4);
        myNotes.add(note5);

        noteService.listAll();

        assertNotNull(myNotes);
        assertEquals(5, myNotes.size());
        assertEquals(1, myNotes.get(0).getId());
        assertEquals(2, myNotes.get(1).getId());
    }

    @Test
    public void testAdd() {
        NoteService noteService = new NoteService();
        Note note1 = new Note(1, "Title1", "Content1");
        Note note2 = new Note(2, "Title2", "Content2");
        Note note3 = new Note(3, "Title3", "Content3");
        Note note4 = new Note(4, "Title4", "Content4");
        Note note5 = new Note(5, "Title5", "Content5");

        myNotes.add(note1);
        myNotes.add(note2);
        myNotes.add(note3);
        myNotes.add(note4);
        myNotes.add(note5);


        assertEquals(5, myNotes.size());
        assertEquals(1, myNotes.get(0).getId());
        assertEquals(2, myNotes.get(1).getId());

    }

    @Test
    public void testDeleteById() {
        List<Note> notesList = new ArrayList<>();
        NoteService noteService = new NoteService();
        Note note1 = new Note(1, "Title1", "Content1");
        Note note2 = new Note(2, "Title2", "Content2");
        Note note3 = new Note(3, "Title3", "Content3");
        Note note4 = new Note(4, "Title4", "Content4");
        Note note5 = new Note(5, "Title5", "Content5");

        notesList.add(note1);
        notesList.add(note2);
        notesList.add(note3);
        notesList.add(note4);
        notesList.add(note5);

        // Передаємо список до NoteService
        noteService.myNotes = notesList;

        long idToRemove = 3L;
        noteService.deleteById(idToRemove);

        // Перевіряємо, чи елемент з idToRemove було видалено
        assertNull(noteService.getById(idToRemove));

        assertEquals(4, noteService.myNotes.size());
    }

    @Test
    public void testUpdate() {
        NoteService noteService = new NoteService();
        List<Note> noteList = new ArrayList<>();
        Note note1 = new Note(1, "Title1", "Content1");
        Note note2 = new Note(2, "Title2", "Content2");
        Note note3 = new Note(3, "Title3", "Content3");
        Note note4 = new Note(4, "Title4", "Content4");
        Note note5 = new Note(5, "Title5", "Content5");

        noteList.add(note1);
        noteList.add(note2);
        noteList.add(note3);
        noteList.add(note4);
        noteList.add(note5);

        noteService.myNotes = noteList; // Передаємо список до NoteService

        // Оновлюємо нотатку з ідентифікатором 1
        Note updatedNote = new Note(1, "UpdatedTitle", "UpdatedContent");
        noteService.update(updatedNote);

        // Отримуємо оновлену нотатку
        Note retrievedNote = noteService.getById(updatedNote.getId());
        assertNotNull(retrievedNote);

        // Перевіряємо, чи назва та вміст оновлені
        assertEquals(updatedNote.getTitle(), retrievedNote.getTitle());
        assertEquals(updatedNote.getContent(), retrievedNote.getContent());
    }

    @Test
    public void testGetById() {
        NoteService noteService = new NoteService();

        noteService.add(new Note(1, "Title1", "Content1"));
        noteService.add(new Note(2, "Title2", "Content2"));
        noteService.add(new Note(3, "Title3", "Content3"));
        noteService.add(new Note(4, "Title4", "Content4"));
        noteService.add(new Note(5, "Title5", "Content5"));



        long idToRetrieve = 1;
        Note result = noteService.getById(idToRetrieve);

        assertNotNull(result);
        assertEquals(idToRetrieve, result.getId());

    }
}


