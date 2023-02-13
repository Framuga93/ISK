package org.example.controller;

import org.example.model.Repository;
import org.example.model.Validation;
import org.example.model.ValidationException;

import java.io.IOException;
import java.util.List;

public class UserController {

    private final Repository repository;
    private Validation validation = new Validation();

    public UserController(Repository repository) {
        this.repository = repository;
    }

    public void savedUser (List<String> user) throws IOException {
        repository.saveUser(user);
    }

    public List<String> checkedAndParsed(String data) throws ValidationException {
        return validation.checkAndParse(data);
    }
}
