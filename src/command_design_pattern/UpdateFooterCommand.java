package command_design_pattern;

import app.NotePad;

public class UpdateFooterCommand extends Command{



    public UpdateFooterCommand(NotePad notePad) {
        super(notePad);
    }

    @Override
    public void execute() {
        if (notePad.getFocusedPage() == null) {
            notePad.getFooter().setCharCountText("BBDF Notepad");
            return;
        }
        notePad.getFooter().setCharCountText(String.valueOf(notePad.getFocusedPage().getText().length()));
    }
}
