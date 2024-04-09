package com.example.TodoList.dao_interface;

import com.example.TodoList.entity.Note;

import java.util.List;

public interface NoteDao {

    List<Note> listAll();

    Note add(Note note);

    void deleteById(long id);

    void update(Note note);

    Note getById(long id);
}
