package com.etoitau.designpatterns.memento;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Collectors;



class Token
{
    public int value = 0;

    public Token(int value)
    {
        this.value = value;
    }
}

class Memento implements Iterable<Token>
{
    // code provided has this public list, why public? this should be immutable
    public List<Token> tokens = new ArrayList<>();

    // Memento keeps own immutable record of state
    // need all three because the list and all the tokens are exposed elsewhere
    // the original token list object
    private List<Token> listObject;
    // the original token objects in it
    private List<Token> tokenObjects = new ArrayList<>();
    // their original values
    private List<Token> values = new ArrayList<>();

    public Memento(TokenMachine tm) {
        // take this 'cause it's in the provided code, but can't trust
        tokens = tm.tokens;
        // get list object
        listObject = tm.tokens;
        // get Token objects and values
        for (Token t: tm.tokens) {
            tokenObjects.add(t);
            values.add(new Token(t.value));
        }
    }

    // get original token with original value restored
    private Token getToken(int i) {
        tokenObjects.get(i).value = values.get(i).value;
        return tokenObjects.get(i);
    }

    public List<Token> getTokenList() {
        tokens = listObject;
        tokens.clear();
        for (int i = 0; i < tokenObjects.size(); i++) {
            tokens.add(tokenObjects.get(i));
            tokens.get(i).value = values.get(i).value;
        }
        return tokens;
    }

    @Override
    public Iterator<Token> iterator() {
        return new MementoIterator(this);
    }

    @Override
    public void forEach(Consumer<? super Token> action) {
        for (Iterator<Token> it = new MementoIterator(this); it.hasNext(); ) {
            action.accept(it.next());
        }
    }

    @Override
    public Spliterator<Token> spliterator() {
        return null;
    }

    class MementoIterator implements Iterator<Token> {
        private Memento m;
        private int i = 0;

        public MementoIterator(Memento m) { this.m = m; }

        @Override
        public boolean hasNext() {
            return (i < m.tokenObjects.size());
        }

        @Override
        public Token next() {
            return m.getToken(i++);
        }
    }
}


class TokenMachine
{
    public List<Token> tokens = new ArrayList<>();

    public Memento addToken(int value)
    {
        return addToken(new Token(value));
    }

    public Memento addToken(Token token)
    {
        tokens.add(token);
        return new Memento(this);
    }

    // revert state back to same token objects and values TokenMachine had when m was created
    public void revert(Memento m)
    {
        tokens = m.getTokenList();
    }

    public int sum() {
        int sum = 0;
        for (Token t: tokens) {
            sum += t.value;
        }
        return sum;
    }
}