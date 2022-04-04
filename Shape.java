package dp;

interface Renderer {
    public String whatToRender();
}

class VectorRenderer implements Renderer {
    @Override
    public String whatToRender() {
        return "lines";
    }
}

class RasterRenderer implements Renderer {
    @Override
    public String whatToRender() {
        return "pixels";
    }
}

abstract class Shape
{
    Renderer renderer;
    Shape(Renderer renderer) {
        this.renderer = renderer;
    }
    public abstract String getName();
}

class Triangle extends Shape
{
    Triangle( Renderer renderer) {
        super(renderer);
    }
    @Override
    public String getName()
    {
        return "Triangle";
    }

    @Override
    public String toString() {
        return String.format("Drawing %s as %s", getName(), renderer.whatToRender());
    }
}

class Square extends Shape
{
    public Square(Renderer renderer) {
        super(renderer);
    }

    @Override
    public String getName()
    {
        return "Square";
    }

    @Override
    public String toString() {
        return String.format("Drawing %s as %s", getName(), renderer.whatToRender());
    }

}
