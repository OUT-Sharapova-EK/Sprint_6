package com.example;

import java.util.List;

public class Lion {

    private boolean hasMane;
    private final Feline feline; // Используем переданный объект

    public Lion(String sex, Feline feline) throws Exception {
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - Самец или Самка");
        }
        this.feline = feline; // Сохраняем переданный объект
    }

    public int getKittens() {
        return feline.getKittens(); // Теперь используем переданный экземпляр Feline
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник"); // Используем переданный Feline
    }
}
