package org.example;

import org.example.controller.UserController;
import org.example.model.Validation;
import org.example.model.ValidationException;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class View {
    private final UserController userController;

    public View(UserController userController) {
        this.userController = userController;
    }

    public void run() throws IOException, ValidationException {
        System.out.println("Добро пожаловать в программу по сбору информации");
        String dataString = prompt("Введите данные в произвольном порядке, разделенные пробелом:\n" +
                "//Фамилия Имя Отчество датарождения номертелефона пол.\n" +
                "//Формат данных:\n" +
                "//Дата рождения - дд.мм.гггг \n" +
                "//Номер телефона - 89*********\n" +
                "//Пол - m (муж), f (жен)\n" +
                "Ввод данных: \n");
        List<String> validUser = userController.checkedAndParsed(dataString);
        userController.savedUser(validUser);

    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
