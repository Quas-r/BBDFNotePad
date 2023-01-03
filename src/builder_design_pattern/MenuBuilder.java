package builder_design_pattern;

import app.NotePad;
import command_design_pattern.CopyCommand;
import command_design_pattern.PasteCommand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBuilder {

    private static MenuBuilder instance;
    private NotePad notePad;
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu;

    private MenuBuilder(NotePad notePad) {
        this.notePad = notePad;
    }

    public void reset() {
        menuBar = new JMenuBar();
    }

    public void addFileMenu(boolean pageful) {
        menu = new JMenu("File");

        JMenuItem open = new JMenuItem("Open");
        //open.addActionListener(notePad);
        menu.add(open);

        if (pageful) {
            JMenuItem close = new JMenuItem("Close");
            JMenuItem save = new JMenuItem("Save");
            JMenuItem clone = new JMenuItem("Clone");

            menu.add(close);
            menu.add(save);
            menu.add(clone);

        }
        menuBar.add(menu);
    }

    public void addEditMenu() {
        menu = new JMenu("Edit");

        JMenuItem copy = new JMenuItem("Copy");
        JMenuItem cut = new JMenuItem("Cut");
        JMenuItem paste = new JMenuItem("Paste");
        JMenuItem find = new JMenuItem("Find");
        JMenuItem findAndReplace = new JMenuItem("Find & Replace");
        copy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                (new CopyCommand(notePad)).execute();
            }
        });
        //cut.addActionListener();
        paste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                (new PasteCommand(notePad)).execute();
            }
        });
        //find.addActionListener(notePad);
        //findAndReplace.addActionListener(notePad);
        menu.add(copy);
        menu.add(cut);
        menu.add(paste);
        menu.add(find);
        menu.add(findAndReplace);
        menuBar.add(menu);
    }

    public void addHelpMenu() {
        menu = new JMenu("Help");

        JMenuItem developers = new JMenuItem("Developers");
        //developers.addActionListener(notePad);
        menu.add(developers);
        menuBar.add(menu);
    }

    public static MenuBuilder getInstance(NotePad notePad) {
        if (instance == null) {
            instance = new MenuBuilder(notePad);
        }
        return instance;
    }

    public JMenuBar getMenuBar() {
        JMenuBar temp = menuBar;
        reset();
        return temp;
    }

}
