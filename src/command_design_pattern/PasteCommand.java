package command_design_pattern;

import app.NotePad;

public class PasteCommand extends Command{


    public PasteCommand(NotePad notePad) {
        super(notePad);
    }

    @Override
    public void execute() {
        if (notePad.getFocusedPage().getClipboard() == null || notePad.getFocusedPage().getClipboard().isEmpty())
            return;

        backup();
        notePad.getFocusedPage().insertTextAtCaret(notePad.getFocusedPage().getClipboard());
    }
}
