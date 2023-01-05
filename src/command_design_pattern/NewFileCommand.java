package command_design_pattern;

import app.NotePad;
import app.Page;

public class NewFileCommand extends Command {
    private Page page;

    public NewFileCommand(NotePad notePad, Page pageToBeCloned) {
        super(notePad);
        this.page = pageToBeCloned;
    }

    @Override
    public void execute() {
        if (page == null) {
            notePad.addPage();
            (new CheckPagesCommand(notePad)).execute();
            return;
        }
        notePad.addPage(page.clone());
        (new CheckPagesCommand(notePad)).execute();
    }
}
