package command_design_pattern;

import app.NotePad;

import javax.swing.*;

public class OpenCommand extends Command {
    public String path;
    public JFileChooser fileChooser;

    public OpenCommand(NotePad notePad) {
        super(notePad);
    }

    @Override
    public boolean execute() {
        fileChooser = new JFileChooser();
        int response = fileChooser.showOpenDialog(null);

        if (response == JFileChooser.CANCEL_OPTION) return false;
        path = fileChooser.getSelectedFile().getAbsolutePath();
        notePad.addPage(NotePad.openPage(notePad, path));
        (new CheckPagesCommand(notePad)).execute();
        return false;
    }
}
