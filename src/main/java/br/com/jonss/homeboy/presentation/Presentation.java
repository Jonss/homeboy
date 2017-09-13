package br.com.jonss.homeboy.presentation;

import br.com.jonss.homeboy.model.WorkRegister;

import java.util.List;

public class Presentation {


    public static String presentateWorkRegister(List<WorkRegister> workRegisterList) {
        String presentation = "";
        for (WorkRegister register: workRegisterList) {
            presentation += register.toString();
        }
        return presentation;
    }
}
