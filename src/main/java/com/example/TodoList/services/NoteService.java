package com.example.TodoList.services;

import com.example.TodoList.dao_interface.NoteDao;
import com.example.TodoList.entity.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Service
public class NoteService implements NoteDao {
    public List<Note> myNotes = new ArrayList<>();

//    private static final String GET_TASK_BY_ID = "";
//    public static final String INSERT_TASK = "";
//    private static final String UPDATE_TASK = "";
//    private static final String DELETE_TASK = "";
//    private static final String SELECT_ALL_TASKS = "";


    @Override
    public List<Note> listAll() {
        return this.myNotes;
    }

    @Override
    public Note add(Note note) {
        note.setId(note.getId());
        this.myNotes.add(note);
        return null;
    }

    @Override
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

    @Override
    public void update(Note note) {
        for (Note findNote : myNotes) {
            if (findNote.getId() == note.getId()) {
                findNote.setTitle(note.getTitle());
                findNote.setContent(note.getContent());
                break;
            }
        }
    }

    @Override
    public Note getById(long id) {
        return myNotes.get((int) id);
    }
}
