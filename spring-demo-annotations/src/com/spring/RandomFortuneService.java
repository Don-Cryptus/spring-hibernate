package com.spring;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService{

    private String[] data = {
            "Today is your lucky day",
            "You will be happy today",
            "Test"
    };

    private Random myRandom = new Random();
    @Override
    public String getFortune() {
        int index = myRandom.nextInt(data.length);

        String theFortune = data[index];

        return theFortune;
    }
}
