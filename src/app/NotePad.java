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


        JTabbedPane tabs = new JTabbedPane();

        Page page = new Page(this, "/Quasar/Test.txt");
        Page page2 = new Page(this, null);

        tabs.add(page.getName(), page);
        tabs.add(page2.getName(), page2);

        mDirector.buildPagefulMenuBar(mBuilder);
        focusedPage = page;

        footer = new Footer(focusedPage.getText().length());

        frame = new JFrame("BBDF NotePad");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(600, 600));
        frame.setMinimumSize(new Dimension(300, 300));
        frame.setJMenuBar(mBuilder.getMenuBar());
        frame.add(tabs, BorderLayout.CENTER);
        frame.add(footer, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public static Page openPage(String path) {

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
