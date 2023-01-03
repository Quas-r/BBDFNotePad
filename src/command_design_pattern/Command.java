package command_design_pattern;

import app.NotePad;

public abstract class Command {
    public NotePad notePad;
    private String backup;

    private Command() {}

    public Command(NotePad notePad) {
        this.notePad = notePad;
    }

    public void backup() {
        backup = notePad.getFocusedPage().getText();
    }

    public void undo() {
        notePad.getFocusedPage().setText(backup);
    }

    public abstract boolean execute();
}
