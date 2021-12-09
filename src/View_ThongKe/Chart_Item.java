package View_ThongKe;

import java.awt.Color;

public class Chart_Item {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValues() {
        return values;
    }

    public void setValues(double values) {
        this.values = values;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Chart_Item(String name, double values, Color color) {
        this.name = name;
        this.values = values;
        this.color = color;
    }

    public Chart_Item() {
    }

    private String name;
    private double values;
    private Color color;
}
