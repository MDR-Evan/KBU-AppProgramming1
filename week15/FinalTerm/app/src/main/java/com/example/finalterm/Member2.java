package com.example.finalterm;

public class Member2 {
    private final String name;
    private final int age;
    private final String job;
    private final int imageResId;

    public Member2(String name, int age, String job, int imageResId) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getJob() {
        return job;
    }

    public int getImageResId() {
        return imageResId;
    }
}
