/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package greedydm;

import java.io.File;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author alireza
 */
public final class Merger extends javax.swing.JFrame {

    private ArrayList<File> files;
    private DefaultListModel<String> listModel;

    public Merger() {
        initComponents();
        init();
    }

    public void init() {
        files = new ArrayList<File>();
        listModel = new DefaultListModel<String>();
        lstFiles.setModel(listModel);
    }

    public void showList() {
        listModel.removeAllElements();
        for (int i = 0; i < files.size(); i++) {
            listModel.addElement(files.get(i).getName());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstFiles = new javax.swing.JList();
        btnUp = new javax.swing.JButton();
        btnDown = new javax.swing.JButton();
        btnMerge = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setTitle("Merger");
        setName("Merger"); // NOI18N
        setResizable(false);

        lstFiles.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(lstFiles);

        btnUp.setText("UP");
        btnUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpActionPerformed(evt);
            }
        });

        btnDown.setText("Down");
        btnDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownActionPerformed(evt);
            }
        });

        btnMerge.setText("Merge");
        btnMerge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMergeActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCancel)
                            .addComponent(btnMerge))
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnUp, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDown)
                        .addComponent(btnAdd)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd, btnCancel, btnDown, btnMerge, btnUp});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDown)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                        .addComponent(btnMerge)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAdd, btnCancel, btnDown, btnMerge, btnUp});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMergeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMergeActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.showSaveDialog(this);
        if (fileChooser.getSelectedFile() != null) {
            File[] file = new File[files.size()];
            for (int i = 0; i < files.size(); i++) {
                file[i] = files.get(i);
            }
            if (FileMerger.mergeFiles(file, fileChooser.getSelectedFile())) {
                JOptionPane.showMessageDialog(this, "File merged succussfully!\n" + fileChooser.getSelectedFile().getAbsolutePath(), "Hey ... ", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnMergeActionPerformed

    private void btnUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpActionPerformed
        if (lstFiles.getSelectedIndex() == -1) {
            return;
        }
        int index = lstFiles.getSelectedIndex();
        if (index == 0) {
            return;
        }
        File file = files.remove(index);
        files.add(index - 1, file);
        showList();
    }//GEN-LAST:event_btnUpActionPerformed

    private void btnDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownActionPerformed
        if (lstFiles.getSelectedIndex() == -1) {
            return;
        }
        int index = lstFiles.getSelectedIndex();
        if (index == files.size() - 1) {
            return;
        }
        File file = files.remove(index);
        files.add(index + 1, file);
        showList();
    }//GEN-LAST:event_btnDownActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.showOpenDialog(this);
        if (fileChooser.getSelectedFile() != null) {
            files.add(fileChooser.getSelectedFile());
            showList();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDown;
    private javax.swing.JButton btnMerge;
    private javax.swing.JButton btnUp;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lstFiles;
    // End of variables declaration//GEN-END:variables
}
