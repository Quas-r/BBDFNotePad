package command_design_pattern;

import app.NotePad;
import app.Page;

public class CopyCommand extends Command{


    public CopyCommand(NotePad notePad) {
        super(notePad);
    }

    @Override
    public boolean execute() {
        notePad.getFocusedPage().setClipboard(notePad.getFocusedPage().getSelectedText());
        return false;
    }
}
