package week6.ex5;

import javax.swing.*;

public class Controller extends JFrame {

    private final AirPort airPort;
    private final JTextArea eventTextArea;

    public Controller() {

        airPort = new AirPort();


        setTitle("Airport Event Viewer");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();
        JButton addButton = new JButton("Add Event");
        JButton showButton = new JButton("Show Events");
        eventTextArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(eventTextArea);


        panel.add(addButton);
        panel.add(showButton);
        panel.add(scrollPane);


        add(panel);


        addButton.addActionListener(e -> {
            PlaneEvent newEvent = new PlaneEvent("06:30","ZBA30","Ha canh","Vietnam Airline");
            PlaneEvent newEvent1 = new PlaneEvent("10:15","ZCG24","Cat canh","Vietnam Airline");
            PlaneEvent newEvent2 = new PlaneEvent("20:50","VNK290","Ha canh","Viet Jet Air");
            PlaneEvent newEvent3 = new PlaneEvent("05:00","LWN69","Ha canh","Bamboo Airway");
            PlaneEvent newEvent4 = new PlaneEvent("22:30","XT310","Cat canh","Bamboo Airway");
            airPort.add(newEvent);
            airPort.add(newEvent1);
            airPort.add(newEvent2);
            airPort.add(newEvent3);
            airPort.add(newEvent4);
        });

        // Add ActionListener for the "Show Events" button
        showButton.addActionListener(e -> {
            eventTextArea.setText(""); // Clear previous text
            try {
                eventTextArea.append("Upcoming Event:\n" + airPort.showEvent() + "\n");
            } catch (IllegalStateException ex) {
                eventTextArea.append("Khong co chuyen bay hien hanh\n");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Controller().setVisible(true));
    }
}
