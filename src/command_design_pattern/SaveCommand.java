package command_design_pattern;

import app.NotePad;

import javax.swing.*;
import java.io.FileWriter;

public class SaveCommand extends Command {

    public SaveCommand(NotePad notePad) {
        super(notePad);
    }

    @Override
    public void execute() {
        String path = notePad.getFocusedPage().getPath();
        if (path == null) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if (response == JFileChooser.CANCEL_OPTION) return;
            path = fileChooser.getSelectedFile().getAbsolutePath();
            notePad.getFocusedPage().setPath(path);
            notePad.getFocusedPage().parseName(path);
            notePad.changeCurrentPageName(notePad.getFocusedPage().getName());
        }
        try {
            FileWriter writer = new FileWriter(path);
            writer.write(notePad.getFocusedPage().getText());
            writer.close();
        } catch (Exception e) { System.out.println(e); }

    }
}
