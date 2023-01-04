package command_design_pattern;

import app.NotePad;

public class CheckPagesCommand extends Command {

    public CheckPagesCommand(NotePad notePad) {
        super(notePad);
    }

    @Override
    public boolean execute() {
        (new UpdateFooterCommand(notePad)).execute();
        if (notePad.getPages().isEmpty()) {
            notePad.setMenuBar(false);
            notePad.changeJTabbedPane(false);
            return false;
        }
        notePad.setMenuBar(true);
        notePad.changeJTabbedPane(true);
        return false;
    }
}
