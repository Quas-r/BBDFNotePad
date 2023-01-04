package app;

import builder_design_pattern.MenuBuilder;
import builder_design_pattern.MenuDirector;
import command_design_pattern.CheckPagesCommand;
import command_design_pattern.UpdateFooterCommand;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class NotePad {

    private ArrayList<Page> pages = new ArrayList<Page>();
    private WelcomePage welcomePage;
    private String clipboard;
    private JFrame frame;
    private MenuDirector mDirector;
    private MenuBuilder mBuilder;
    private Page focusedPage;
    private Footer footer;
    private JTabbedPane tabs;

    public void init() {
        mDirector = MenuDirector.getInstance();
        mBuilder = MenuBuilder.getInstance(this);


        tabs = new JTabbedPane();
        welcomePage = new WelcomePage();

        mDirector.buildPagefulMenuBar(mBuilder);

        footer = new Footer(0);
        (new UpdateFooterCommand(this)).execute();

        frame = new JFrame("BBDF NotePad");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(600, 600));
        frame.setMinimumSize(new Dimension(300, 300));
        frame.setJMenuBar(mBuilder.getMenuBar());
        (new CheckPagesCommand(this)).execute();
        frame.add(footer, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public void changeJTabbedPane(boolean pageful) {
        if (pageful) {
            try { frame.remove(welcomePage); } catch (Exception e) {}
            frame.add(tabs);
            return;
        }
        try { frame.remove(tabs); } catch (Exception e) {}
        frame.add(welcomePage);
    }

    public static Page openPage(NotePad notePad, String path) {
        String text = "";
        try {
            File file = new File(path);
            Scanner s = new Scanner(file);
            while (s.hasNext()) {
                text += s.nextLine() + "\n";
            }

            Page p = new Page(notePad, path);
            p.setText(text);
            return p;
        } catch (Exception e) { System.out.println("File not found."); return null; }
    }

    public void addPage(Page page) {
        pages.add(page);
        setFocusedPage(page);
        tabs.add(page);
        tabs.setSelectedComponent(page);
    }

    public ArrayList<Page> getPages() {
        return pages;
    }

    public void setMenuBar(boolean pageful) {
        if (pageful) {
            mDirector.buildPagefulMenuBar(mBuilder);
            frame.setJMenuBar(mBuilder.getMenuBar());
            return;
        }
        mDirector.buildPagelessMenuBar(mBuilder);
        frame.setJMenuBar(mBuilder.getMenuBar());
    }


    public String getClipboard() {
        return clipboard;
    }

    public void setClipboard(String clipboard) {
        this.clipboard = clipboard;
    }

    public Page getFocusedPage() {
        return focusedPage;
    }

    public void setFocusedPage(Page page) {
        this.focusedPage = page;
    }

    public Footer getFooter() {
        return footer;
    }

    public void setFooter(Footer footer) {
        this.footer = footer;
    }
}
