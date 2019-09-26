package com.etoitau.designpatterns.decorator;

public class Main {
    public static void main(String[] args) {

    }
}

class Bird
{
    public int age;

    public String fly()
    {
        return age < 10 ? "flying" : "too old";
    }
}

class Lizard
{
    public int age;

    public String crawl()
    {
        return (age > 1) ? "crawling" : "too young";
    }
}

class Dragon
{
    private Bird bird;
    private Lizard lizard;
    private int age;

    public Dragon() {
        this.bird = new Bird();
        this.lizard = new Lizard();
    }

    public void setAge(int age)
    {
        this.age = age;
        bird.age = age;
        lizard.age = age;
    }
    public String fly()
    {
        return bird.fly();
    }
    public String crawl()
    {
        return lizard.crawl();
    }
}
