package app;

import builder_design_pattern.MenuBuilder;
import builder_design_pattern.MenuDirector;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class NotePad {

    private ArrayList<Page> pages = new ArrayList<Page>();
    private String clipboard;
    private JFrame frame;
    private MenuDirector mDirector;
    private MenuBuilder mBuilder;
    private Page focusedPage;
    private Footer footer;

    public void init() {
        mDirector = MenuDirector.getInstance();
        mBuilder = MenuBuilder.getInstance(this);

        Page page = new Page(this);
        mDirector.buildPagefulMenuBar(mBuilder);
        focusedPage = page;
        footer = new Footer(focusedPage.getText().length());

        frame = new JFrame("BBDF app.NotePad");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(600, 600));
        frame.setMinimumSize(new Dimension(300, 300));
        frame.setJMenuBar(mBuilder.getMenuBar());
        frame.add(page, BorderLayout.CENTER);
        frame.add(footer, BorderLayout.SOUTH);
        frame.setVisible(true);
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
