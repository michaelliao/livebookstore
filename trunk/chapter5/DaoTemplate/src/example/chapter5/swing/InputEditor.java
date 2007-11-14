package example.chapter5.swing;

import java.awt.*;

import javax.swing.*;

/**
 * @author Li Jianghua
 */
public class InputEditor extends JPanel {

    JLabel lblDisplayName = new JLabel();
    JTextField txtEditor = new JTextField();

    private GridBagLayout gridBagLayout = new GridBagLayout();

    public InputEditor() {
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setLabelText(String text) {
        lblDisplayName.setText(text);
    }

    public String getLabelText() {
        return lblDisplayName.getText();
    }

    public void setEditorText(String text) {
        txtEditor.setText(text);
    }

    public String getEditorText() {
        return txtEditor.getText();
    }

    private void jbInit() throws Exception {
        lblDisplayName.setText("Name:");
        this.setLayout(gridBagLayout);

        this.add(lblDisplayName, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));
        this.add(txtEditor, new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(0, 6, 0, 0), 100, 12));
    }
}
