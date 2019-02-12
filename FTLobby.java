import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FTLobby {
    private JFrame frame;
    private JTextField coords_A = new TextfieldPrompt(1).getTextField();
    private JTextField coords_B = new TextfieldPrompt(2).getTextField();
    private JTextArea aircraftCoords = new TextAreaPrompt().getTextArea();
    private JButton btn_GetKML = new JButton("Get KML");

    public FTLobby(){
        frame = new JFrame("Flight Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(addLobbyComponents(), BorderLayout.CENTER);
        frame.setSize(500,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JPanel addLobbyComponents(){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        configureComponents();
        panel.add(coords_A);
        panel.add(coords_B);
        panel.add(aircraftCoords);
        panel.add(btn_GetKML);
        return panel;
    }

    public void configureComponents(){
        // first and second set of coordinates
        coords_A.setBackground(Color.WHITE);
        coords_A.setColumns(15);

        coords_B.setBackground(Color.WHITE);
        coords_B.setColumns(15);

        // list of coordinates
        aircraftCoords.setBackground(Color.lightGray);
        aircraftCoords.setColumns(31);
        aircraftCoords.setRows(5);

        // button to create and access a built KML file
        btn_GetKML.setPreferredSize(new Dimension(342, 40));
        btn_GetKML.addActionListener(e -> {
            System.out.println("We'll convert coords using FormatCoordinates class, then build KML " +
                                "via the BuildKML class.");
        });
    }
}
