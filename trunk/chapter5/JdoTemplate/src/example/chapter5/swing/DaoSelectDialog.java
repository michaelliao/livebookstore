package example.chapter5.swing;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;

/**
 * @author Xuefeng
 */
public class DaoSelectDialog extends JPanel {

    private JDialog dialog;

    private JLabel lblName;
    private JComboBox comboOptions;
    private JButton btnOK;
    private JButton btnCancel;

    private Vector<String> daoList;
    private String selection;
    private int nRet;

    public DaoSelectDialog(String[] strs) {
        nRet = JOptionPane.CANCEL_OPTION;
        if(strs.length>0)
            selection = strs[0];
        initDaos(strs);
        initUI();
        installListeners();
    }

    private void initDaos(String[] strs) {
        daoList = new Vector<String>();
        for(int i = 0; i < strs.length; i++) {
            daoList.add(strs[i]);
        }
    }

    private void initUI() {
        lblName = new JLabel("选择Dao实现：");
        comboOptions = new JComboBox(daoList);
        btnOK = new JButton("OK");
        btnCancel = new JButton("Cancel");

        JPanel optionPane = new JPanel();
        optionPane.add(lblName);
        optionPane.add(comboOptions);

        JPanel ctrlPane = new JPanel();
        ctrlPane.add(btnOK);
        ctrlPane.add(btnCancel);

        setLayout(new BorderLayout());
        add(optionPane, java.awt.BorderLayout.CENTER);
        add(ctrlPane, java.awt.BorderLayout.SOUTH);
    }

    private void installListeners() {
        btnOK.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent evt) {
                btnOK_actionPerformed();
            }
        } );

        btnCancel.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent evt) {
                btnCancel_actionPerformed();
            }
        });
    }

    protected void btnOK_actionPerformed() {
        selection = comboOptions.getSelectedItem().toString();
        nRet = JOptionPane.OK_OPTION;
        if(dialog != null) {
            dialog.dispose();
        }
    }

    protected void btnCancel_actionPerformed() {
        nRet = JOptionPane.CANCEL_OPTION;
        if(dialog != null) {
            dialog.dispose();
        }
    }

    public String getSelected() {
        return selection;
    }

    public int showDialog(Frame frame) {
        dialog = new JDialog(frame, "请选择DAO实现", true);
        dialog.setContentPane(this);
        dialog.setSize(300, 120);
        dialog.setLocation(300, 400);
        dialog.setVisible(true);
        return nRet;
    }

}
