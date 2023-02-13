package org.example.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    public String validationDate(String date) throws ValidationException {
        List<String> splitDate = Arrays.asList(date.split("\\."));
        String day = splitDate.get(0);
        String month = splitDate.get(1);
        int year = Integer.parseInt(splitDate.get(2));
        if (day.split("").length != 2 || Integer.parseInt(day) > 31){
            String message = "Не корректный ввод даты ( число состиот не из 2 цифр, число больше 31 )";
            throw new ValidationException(message);
        }
        if (day.equals("31") &&
                (month.equals("4") || month .equals("6") || month.equals("9") ||
                        month.equals("11") || month.equals("04") || month .equals("06") ||
                        month.equals("09"))) {
            String message = "В этом месяце не может быть 31 день";
            throw new ValidationException(message);
        }

        else if (month.equals("2") || month.equals("02")) {
            if(year % 4==0){
                if(day.equals("30") || day.equals("31")){
                    String message = "В этом месяце 29 дней";
                    throw new ValidationException(message);
                }
            }
            else{
                if(day.equals("29")||day.equals("30")||day.equals("31")){
                    String message = "В этом месяце 28 дней";
                    throw new ValidationException(message);
                }
            }
        }
        Date dateNow = new Date();
        if (year > dateNow.getYear()){
            String message = "Вы из будущего?";
            throw new ValidationException(message);
        }
        return date;
    }

    public List<String> parseData(List<String> dataArr) throws ValidationException {

        String date = findFunction("\\d{2}\\.\\d{2}.\\d{4}", dataArr,
                "Не корректный ввод даты, формат ввода дд.мм.гггг");
        String phone = findFunction("89\\d{9}", dataArr,
                "Не корректный ввод телефона, формат ввода 89*********");
        String sex = findFunction("\\b[mMfF]\\b", dataArr,
                "Не корректный ввод пола, формат ввод m - муж / f - жен" );
        List<String> res = new ArrayList<>();
        res.add(date);
        res.add(phone);
        res.add(sex);
        return res;
    }

    public String findFunction(String regex, List<String> data, String exceptionText) throws ValidationException {
        Matcher result = Pattern.compile(regex)
                .matcher(data.toString());
        if (!result.find()){
            throw new ValidationException(exceptionText);
        }
        return result.group();
    }

    public List<String> checkAndParse(String data) throws ValidationException {
        List<String> dataToArray = Arrays.asList(data.split(" "));
        List<String> result = new ArrayList<>(dataToArray);
        List<String> datePhoneSex = parseData(dataToArray);
        validationDate(datePhoneSex.get(0));
        for (String el : datePhoneSex) {
            for (int i = 0; i < result.size(); i++) {
                if (el.equals(result.get(i))) {
                    result.remove(result.get(i));
                }
            }
        }
        if (result.size() != 3) {
            throw new ValidationException("Не корректный ввод ФИО");
        } else {
            result.addAll(datePhoneSex);
        }
        return result;// controller
    }



}
