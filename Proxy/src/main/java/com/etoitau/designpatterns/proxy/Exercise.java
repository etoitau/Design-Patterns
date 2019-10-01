package com.etoitau.designpatterns.proxy;


class Person
{
    private int age;

    public Person(int age)
    {
        this.age = age;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String drink() { return "drinking"; }
    public String drive() { return "driving"; }
    public String drinkAndDrive() { return "driving while drunk"; }
}

class ResponsiblePerson extends Person
{
    private Person person;

    public ResponsiblePerson(Person person)
    {
        super(person.getAge());
        this.person = person;
    }

    @Override
    public void setAge(int age) {
        person.setAge(age);
    }

    @Override
    public int getAge() {
        return person.getAge();
    }

    @Override
    public String drink() {
        return (person.getAge() >= 18)? person.drink(): "too young";
    }

    @Override
    public String drive() {
        return (person.getAge() >= 16)? person.drive(): "too young";
    }

    @Override
    public String drinkAndDrive() {
        return "dead";
    }

}


public class Exercise {
    public static void main(String[] args) {

    }
}
