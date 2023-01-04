package app;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class Page extends JPanel implements KeyListener {

    private String path;
    private JTextArea textArea;
    private NotePad notePad;

    public Page(NotePad notePad) {
        this.notePad = notePad;
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        textArea = new JTextArea();
        textArea.addKeyListener(this);
        textArea.setText("Test");
        textArea.setLineWrap(true);
        textArea.setMargin(new Insets(5, 5, 5, 5));
        JScrollPane scrollPane = new JScrollPane(textArea);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    private Page(Page page) {
        super();
        this.path = null;
        setText(page.getText());
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void insertTextAtCaret(String string) {
        textArea.insert(string, textArea.getCaretPosition());
    }

    public String getClipboard() { return notePad.getClipboard(); }

    public void setClipboard(String string) { notePad.setClipboard(string); }

    public String getText() {
        return textArea.getText();
    }

    public void setText(String text) {
        this.textArea.setText(text);
    }

    public String getSelectedText() {
        return textArea.getSelectedText();
    }

    public Page clone(Page p) {
        return new Page(p);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == textArea) {
            notePad.getFooter().setCharCountText(String.valueOf(textArea.getText().length()));
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
