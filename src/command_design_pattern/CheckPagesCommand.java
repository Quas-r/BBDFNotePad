package command_design_pattern;

import app.NotePad;

public class CheckPagesCommand extends Command {

    public CheckPagesCommand(NotePad notePad) {
        super(notePad);
    }

    @Override
    public void execute() {
        (new UpdateFooterCommand(notePad)).execute();
        if (notePad.isEmpty()) {
            notePad.setMenuBar(false);
            notePad.changeJTabbedPane(false);
            return;
        }
        notePad.setMenuBar(true);
        notePad.changeJTabbedPane(true);
    }
}
