package command_design_pattern;

import app.NotePad;

public class UpdateFooterCommand extends Command{



    public UpdateFooterCommand(NotePad notePad) {
        super(notePad);
    }

    @Override
    public boolean execute() {

        return false;
    }
}
