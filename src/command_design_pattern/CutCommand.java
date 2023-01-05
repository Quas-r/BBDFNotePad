package command_design_pattern;

import app.NotePad;

public class CutCommand extends Command {

    public CutCommand(NotePad notePad) {
        super(notePad);
    }

    @Override
    public void execute() {
        (new CopyCommand(notePad)).execute();
        notePad.getFocusedPage().setText(cutString(notePad.getFocusedPage().getText()));
    }

    private String cutString(String s) {
        String start = s.substring(0, notePad.getFocusedPage().getSelectionStart());
        String end = s.substring(notePad.getFocusedPage().getSelectionEnd());
        return (start + end);
    }
}
