package com.etoitau.designpatterns.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Design Patterns
 * Coding Exercise 1 - Builder Coding Exercise
 */
public class CodeBuilder
{
    private String className;
    private List<Field> fields;
    private final String br = System.lineSeparator();

    public CodeBuilder(String className)
    {
        this.className = className;
        this.fields = new ArrayList<>();
    }

    public CodeBuilder addField(String name, String type)
    {
        fields.add(new Field(name, type));
        return this;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("public class ").append(className).append(br).append("{").append(br);
        for (Field field: fields) {
            sb.append("  ").append(field).append(br);
        }
        sb.append("}");
        return sb.toString();
    }
}

class Field {
    private String name;
    private String type;

    public Field(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("public %s %s;", type, name);
    }
}