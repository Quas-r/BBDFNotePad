package command_design_pattern;

import app.NotePad;

public class CloseCommand extends Command {

    public CloseCommand(NotePad notePad) {
        super(notePad);
    }

    @Override
    public void execute() {
        notePad.removeCurrentPage();
        if (notePad.isEmpty()) {
            notePad.setFocusedPage(null);
            (new CheckPagesCommand(notePad)).execute();
            return;
        }
        notePad.setFocusedPage(notePad.getPageAtIndex(notePad.getFocusedPageIndex()));
    }
}
