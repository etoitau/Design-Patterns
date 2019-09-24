package com.etoitau.designpatterns.bridge;

public class Exercise {
    public static void main(String[] args) {

    }
}

// shape has a name
abstract class Shape {
    public abstract String getName();
}

// renderer says what mode should be rendered in
interface Renderer {
    public String whatToRenderAs();
}

// Bridge pattern, inherit Shape and aggregate Renderer
class Triangle extends Shape {
    private Renderer r;

    public Triangle(Renderer r) {
        super();
        this.r = r;
    }

    @Override
    public String getName() {
        return "Triangle";
    }

    @Override
    public String toString() {
        return String.format("Drawing %s as %s", getName(), r.whatToRenderAs());
    }
}

// same for square
class Square extends Shape {
    private Renderer r;

    public Square(Renderer r) {
        super();
        this.r = r;
    }

    @Override
    public String getName() {
        return "Square";
    }

    @Override
    public String toString() {
        return String.format("Drawing %s as %s", getName(), r.whatToRenderAs());
    }
}

class VectorRenderer implements Renderer {
    @Override
    public String whatToRenderAs() {
        return "lines";
    }
}

class RasterRenderer implements Renderer {
    @Override
    public String whatToRenderAs() {
        return "pixels";
    }
}
