public class Person {
    private String name;
    private int height;
    private int weight;
    private Size size;

    public Person(String name, int height, int weight, Size size) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.size = size;
    }

    @Override
    public String toString() {
        return name + "(h=" + height + ", w=" + weight + ", size=" + size + ")";
    }

    public Size getSize() {
        return size;
    }
}
