package com.example.TodoList.services;

import com.example.TodoList.dao_interface.NoteDao;
import com.example.TodoList.entity.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.List;


@Service
public class NoteService implements NoteDao {

    @Autowired
    private FakeNoteService fakeNoteService;

    private static final String GET_TASK_BY_ID = "";
    public static final String INSERT_TASK = "";
    private static final String UPDATE_TASK = "";
    private static final String DELETE_TASK = "";
    private static final String SELECT_ALL_TASKS = "";


    @Override
    public List<Note> listAll() {
        return null;
    }

    @Override
    public Note add(Note note) {

        return null;
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public void update(Note note) {

    }

    @Override
    public Note getById(long id) {
        return null;
    }
}
