package eu.pyrocorp.view;

import javax.swing.*;

/**
 * Created by Michal Hubálek.
 */
public class MainWindow extends JFrame
{
    private static final String WINDOW_CAPTION = "Pyrocorp Stock Exchange";

    public MainWindow()
    {
        super(WINDOW_CAPTION);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(new JLabel("Hello"));
        setVisible(true);
    }
}
