package com.spring;

public class TrackCoach implements Coach {

    private FortuneService fortuneService;

    public TrackCoach() {

    }

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return "Just Do It: " + fortuneService.getFortune();
    }

    public void doMyStartupStuff() {
        System.out.println("TrackCoach: inside doMyStartupStuff()");
    }

    public void doMyCleanupStuff() {
        System.out.println("TrackCoach: inside doMyCleanupStuff()");
    }

}