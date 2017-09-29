/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import greedydm.*;
import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author alireza
 */
public class DLForm extends javax.swing.JFrame {

    private int size = 0;
    private DownloadsTableModel DTM;
    private GreedyDMG DMG;
    private File output, continueFile;
    private URL url;

    /**
     * Creates new form DLForm
     */
    public DLForm() {
        initComponents();
        init();
    }

    public DLForm(DownloadsTableModel DTM, GreedyDMG DMG) {
        this();
        this.DTM = DTM;
        this.DMG = DMG;
    }

    private void disableComponents() {
        txtSize.setEnabled(false);
        txtThreadNum.setEnabled(false);
        chkWholeFile.setEnabled(false);
        txtOutput.setEnabled(false);
        btnDownload.setEnabled(false);
        btnSelectOut.setEnabled(false);
        enableTabs(false);
    }

    public void init() {

        disableComponents();

        url = null;
        chkWholeFile.setSelected(true);
        txtURL.setText("");
        txtOutput.setText("");
        txtSize.setText("0");
        txtContinueFile.setText("");
    }

    private boolean getInfo() {
        try {
            URL url = new URL(txtURL.getText());

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            size = connection.getContentLength();
            this.url = url;
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    private void enableTabs(boolean enabled) {
        Component comps[] = jPanel1.getComponents();
        for (Component cmp : comps) {
            cmp.setEnabled(enabled);
        }
        comps = jPanel2.getComponents();
        for (Component cmp : comps) {
            cmp.setEnabled(enabled);
        }
        comps = jPanel3.getComponents();
        for (Component cmp : comps) {
            cmp.setEnabled(enabled);
        }
        tabOptions.setEnabled(enabled);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        optionSelect = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txtURL = new javax.swing.JTextField();
        btnInfo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtSize = new javax.swing.JTextField();
        tabOptions = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtDLPart = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPartToDL = new javax.swing.JTextField();
        rdoSP = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        txtContinueFile = new javax.swing.JTextField();
        btnSelect = new javax.swing.JButton();
        rdoFF = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtFrom = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTo = new javax.swing.JTextField();
        rdoSR = new javax.swing.JRadioButton();
        txtOutput = new javax.swing.JTextField();
        btnDownload = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtThreadNum = new javax.swing.JTextField();
        chkWholeFile = new javax.swing.JCheckBox();
        btnCancel = new javax.swing.JButton();
        btnSelectOut = new javax.swing.JButton();

        setTitle("Add URL");
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jLabel1.setText("URL");

        btnInfo.setText("Get info");
        btnInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoActionPerformed(evt);
            }
        });

        jLabel2.setText("Size ");

        txtSize.setEditable(false);
        txtSize.setText("0");
        txtSize.setOpaque(false);

        jLabel3.setText("How many parts : ");

        txtDLPart.setText("10");

        jLabel4.setText("Which part to download :");

        txtPartToDL.setText("10");

        optionSelect.add(rdoSP);
        rdoSP.setSelected(true);
        rdoSP.setText("Use this");
        rdoSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdoSP)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDLPart)
                            .addComponent(txtPartToDL, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(339, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(rdoSP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDLPart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPartToDL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabOptions.addTab("Specific part", jPanel1);

        btnSelect.setText("Select");
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });

        optionSelect.add(rdoFF);
        rdoFF.setText("Use this");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtContinueFile)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSelect))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(rdoFF)
                        .addGap(0, 519, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(rdoFF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContinueFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSelect)
                .addContainerGap())
        );

        tabOptions.addTab("Continue from file", jPanel3);

        jLabel5.setText("From (in byte) :  ");

        txtFrom.setText("0");

        jLabel6.setText("To (in byte) : ");

        txtTo.setText("0");

        optionSelect.add(rdoSR);
        rdoSR.setText("Use this");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdoSR)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFrom)
                            .addComponent(txtTo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(325, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(rdoSR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabOptions.addTab("Specific region", jPanel2);

        btnDownload.setText("Download");
        btnDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownloadActionPerformed(evt);
            }
        });

        jLabel7.setText("Output");

        jLabel8.setText("Number of threads ");

        txtThreadNum.setText("3");

        chkWholeFile.setSelected(true);
        chkWholeFile.setText("Download whole file");
        chkWholeFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkWholeFileActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSelectOut.setText("Select");
        btnSelectOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabOptions)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSelectOut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDownload)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtURL, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnInfo))
                                    .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(2, 2, 2)
                                .addComponent(txtThreadNum, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(chkWholeFile))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInfo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtThreadNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkWholeFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(tabOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDownload)
                    .addComponent(txtOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(btnCancel)
                    .addComponent(btnSelectOut))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoActionPerformed
        if (getInfo()) {
            txtSize.setText(size + "");
            txtSize.setEnabled(true);
            txtThreadNum.setEnabled(true);
            chkWholeFile.setEnabled(true);
            txtOutput.setEnabled(true);
            btnDownload.setEnabled(true);
            btnSelectOut.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "Error connecting to server.", "Error", JOptionPane.ERROR_MESSAGE);
            disableComponents();
        }
    }//GEN-LAST:event_btnInfoActionPerformed

    private void chkWholeFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkWholeFileActionPerformed
        if (!chkWholeFile.isSelected()) {
            enableTabs(true);
        } else {
            enableTabs(false);

        }
    }//GEN-LAST:event_chkWholeFileActionPerformed

    private void rdoSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoSPActionPerformed
    }//GEN-LAST:event_rdoSPActionPerformed

    private void btnSelectOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectOutActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.showOpenDialog(this);
        if (fileChooser.getSelectedFile() != null) {
            output = fileChooser.getSelectedFile();
            txtOutput.setText(output.getAbsolutePath());
        }
    }//GEN-LAST:event_btnSelectOutActionPerformed

    private void btnDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownloadActionPerformed
        actionDownload();
    }//GEN-LAST:event_btnDownloadActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.showOpenDialog(this);
        if (fileChooser.getSelectedFile() != null) {
            continueFile = fileChooser.getSelectedFile();
            txtContinueFile.setText(continueFile.getAbsolutePath());
        }
    }//GEN-LAST:event_btnSelectActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDownload;
    private javax.swing.JButton btnInfo;
    private javax.swing.JButton btnSelect;
    private javax.swing.JButton btnSelectOut;
    private javax.swing.JCheckBox chkWholeFile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.ButtonGroup optionSelect;
    private javax.swing.JRadioButton rdoFF;
    private javax.swing.JRadioButton rdoSP;
    private javax.swing.JRadioButton rdoSR;
    private javax.swing.JTabbedPane tabOptions;
    private javax.swing.JTextField txtContinueFile;
    private javax.swing.JTextField txtDLPart;
    private javax.swing.JTextField txtFrom;
    private javax.swing.JTextField txtOutput;
    private javax.swing.JTextField txtPartToDL;
    private javax.swing.JTextField txtSize;
    private javax.swing.JTextField txtThreadNum;
    private javax.swing.JTextField txtTo;
    private javax.swing.JTextField txtURL;
    // End of variables declaration//GEN-END:variables

    private void actionDownload() {
        if (output == null) {
            JOptionPane.showMessageDialog(this, "Please select somewhere to save the file.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int numberOfThreads = Integer.parseInt(txtThreadNum.getText() + "");

        if (numberOfThreads <= 0) {
            JOptionPane.showMessageDialog(this, "Number of threads must be greater than zero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (chkWholeFile.isSelected()) {
            DownloadPack dlp = new DownloadPack(url, 0, size - 1, numberOfThreads, output);
            dlp.addObserver(DMG);
            DTM.addDownload(dlp);
            setVisible(false);
            return;
        }

        //specific Part
        if (rdoSP.isSelected()) {
            int numberOfParts = Integer.parseInt(txtDLPart.getText() + "");
            if (numberOfParts <= 0) {
                JOptionPane.showMessageDialog(this, "Number of Parts must be greater than zero.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int partToDownload = Integer.parseInt(txtPartToDL.getText());
            if (partToDownload <= 0 || partToDownload > numberOfParts) {
                JOptionPane.showMessageDialog(this, "Selected part must be between 1 and " + numberOfParts + ".", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int partSize = size / numberOfParts;
            int from = (partToDownload - 1) * partSize;
            int to = partToDownload * partSize - 1;
            if (partToDownload == numberOfParts) {
                to = size - 1;
            }

            DownloadPack dlp = new DownloadPack(url, from, to, numberOfThreads, output);
            dlp.addObserver(DMG);
            DTM.addDownload(dlp);
            setVisible(false);
            return;
        }

        //specific region
        if (rdoSR.isSelected()) {

            int from = Integer.parseInt(txtFrom.getText() + "");
            if (from < 0 || from > size) {
                JOptionPane.showMessageDialog(this, "From must be between 0 and " + size + ".", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int to = Integer.parseInt(txtTo.getText() + "");
            if (to <= from || to > size) {
                JOptionPane.showMessageDialog(this, "To must be between " + (from + 1) + " and " + size + ".", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            DownloadPack dlp = new DownloadPack(url, from, to, numberOfThreads, output);
            dlp.addObserver(DMG);
            DTM.addDownload(dlp);
            setVisible(false);
            return;
        }

        //continue from file
        if (rdoFF.isSelected()) {

            if (continueFile == null) {
                JOptionPane.showMessageDialog(this, "At first select a valid file for continuing.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int from = (int) (continueFile.length()) + 1;
            int to = size - 1;

            DownloadPack dlp = new DownloadPack(url, from, to, numberOfThreads, output);
            dlp.addObserver(DMG);
            DTM.addDownload(dlp);
            setVisible(false);
            return;
        }
    }
}
