package com.etoitau.designpatterns.command;

class Command
{
    enum Action
    {
        DEPOSIT, WITHDRAW
    }

    public Action action;
    public int amount;
    public boolean success;

    public Command(Action action, int amount)
    {
        this.action = action;
        this.amount = amount;
    }
}

class Account
{
    public int balance;

    public void process(Command c)
    {
        if (c.action == Command.Action.DEPOSIT) {
            c.success = true;
            balance += c.amount;
        } else {
            c.success = balance >= c.amount;
            if (c.success) {
                balance -= c.amount;
            }
        }
    }
}