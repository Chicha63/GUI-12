import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Task1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel lowerPanel = new JPanel(new GridLayout(3,1));
        JPanel buttons = new JPanel(new GridLayout(1,4));
        JSlider height = new JSlider(100, 220, 160);
        height.setMajorTickSpacing(10);
        height.setMinorTickSpacing(2);
        height.setPaintLabels(true);
        height.setPaintTicks(true);
        JSlider weight = new JSlider(40, 120);
        weight.setMajorTickSpacing(10);
        weight.setMinorTickSpacing(2);
        weight.setPaintLabels(true);
        weight.setPaintTicks(true);
        JTextField name = new JTextField("name");

        JComboBox<Size> size = new JComboBox<>(Size.values());

        JButton addPerson = new JButton("Add person");
        JButton exit = new JButton("Exit");

        JList<Person> people = new JList<>(new DefaultListModel<>());
        people.setCellRenderer(new ListCellRenderer<Person>() {
            @Override
            public Component getListCellRendererComponent(JList<? extends Person> list, Person value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = new JLabel(value.toString());
                label.setOpaque(true);
                switch (value.getSize()){
                    case XL -> label.setBackground(Color.RED);
                    case XS -> label.setBackground(Color.GREEN);
                    default -> label.setBackground(Color.WHITE);
                }
                return label;
            }
        });

        JScrollPane peoplePane = new JScrollPane(people, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.add(peoplePane, BorderLayout.CENTER);
        lowerPanel.add(height);
        lowerPanel.add(weight);
        lowerPanel.add(buttons);
        buttons.add(name);
        buttons.add(size);
        buttons.add(addPerson);
        buttons.add(exit);
        frame.add(lowerPanel, BorderLayout.SOUTH);
        exit.addActionListener(e->System.exit(0));
        addPerson.addActionListener(e -> {
            Person person = new Person(name.getText(),height.getValue(),weight.getValue(), (Size) size.getSelectedItem());
            ((DefaultListModel<Person>)(people.getModel())).addElement(person);
        });
        frame.setSize(500,500);
        frame.setVisible(true);
    }
}