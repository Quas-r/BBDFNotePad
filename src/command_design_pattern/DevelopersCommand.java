package command_design_pattern;

import app.NotePad;

import javax.swing.*;

public class DevelopersCommand extends Command {

    public DevelopersCommand(NotePad notePad) {
        super(notePad);
    }

    @Override
    public void execute() {
        JOptionPane.showMessageDialog(null,
                "Berfin Dicle Kılınç\n" +
                        "Yusuf Bora Eroğlu\n" +
                        "Dilem Cebeci\n" +
                        "Feyza Nur Başpınar",
                "Developers",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
