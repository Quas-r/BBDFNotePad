package command_design_pattern;

import app.NotePad;

public abstract class Command {
    public NotePad notePad;

    private Command() {}

    public Command(NotePad notePad) {
        this.notePad = notePad;
    }

    public abstract void execute();
}
