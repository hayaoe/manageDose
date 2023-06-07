/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pane;

import Main.MainMenu;
import Pane.editCheckTarget.Datas;
import Targets.TargetBoolean;
import Targets.TargetTimer;
import User.User;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Willas Tobing
 */
public class Calendar_Panel extends javax.swing.JFrame {

    /**
     * Creates new form Calendar_Panel
     */
    MainMenu main = new MainMenu();

    ;

    public Calendar_Panel() {
        initComponents();
        refreshTableTimer();
        refreshTableBool();

    }

    private void refreshTableTimer() {
        User session = main.getUser();
        String status;
        String colNameTimer[] = {"Target", "Tanggal", "Category", "Status", "Duration", "UID"};
        DefaultTableModel tabelTimer = new DefaultTableModel(colNameTimer, 0);
        TimerTable.setModel(tabelTimer);

        for (int i = 0; i < session.getTimer().size(); i++) {

            TargetTimer dataTimer = (TargetTimer) session.getTimer().get(i);
            if (dataTimer.getStatus() != 1) {
                status = "not Finished";
            } else {
                status = "Finished";
            }
            String hour;
            hour = String.valueOf(dataTimer.getDurationHour());
            String minute;
            minute = String.valueOf(dataTimer.getDurationMin());
            String time = hour + ":" + minute;

            String targets[] = {dataTimer.getTargetName(), dataTimer.getDate(), dataTimer.getCategory(), status, time, dataTimer.getUID()};
            tabelTimer.addRow(targets);
        }
    }

    private void updateStatus(String UID) {
        User session = main.getUser();
        TargetBoolean temp;
        TargetTimer temp2;
        for (int i = 0; i < session.getBool().size(); i++) {
            temp = (TargetBoolean) session.getBool().get(i);
            if (temp.getUID().equals(UID)) {
                temp.setStatus(1);
                session.getBool().set(i, temp);
            }
        }

        for (int i = 0; i < session.getTimer().size(); i++) {
            temp2 = (TargetTimer) session.getTimer().get(i);
            if (temp2.getUID().equals(UID)) {
                temp2.setStatus(1);
                session.getTimer().set(i, temp2);
            }
        }

        session.SaveRead();
    }
    
    private void boolUpdate(String UID, String newName, String newCat) {
        User session = main.getUser();
        TargetBoolean temp = null;

        for (int i = 0; i < session.getBool().size(); i++) {
            temp = (TargetBoolean) session.getBool().get(i);
            if (temp.getUID().equals(UID)) {
                temp.setName(newName);
                temp.setCategory(newCat);
                session.getBool().set(i, temp);

            }
        }
        session.SaveRead();
    }
     
    private void timerUpdate(String UID, String newName, String newCat, int newHour, int newMinute) {
        User session = main.getUser();
        TargetTimer temp = null;

        for (int i = 0; i < session.getTimer().size(); i++) {
            temp = (TargetTimer) session.getTimer().get(i);
            if (temp.getUID().equals(UID)) {
                temp.setName(newName);
                temp.setCategory(newCat);
                temp.setDurHour(newHour);
                temp.setDurMin(newMinute);
                session.getTimer().set(i, temp);

            }
        }
        session.SaveRead();
    }
      

    private TargetBoolean boolGetter(String UID) {
        User session = main.getUser();
        TargetBoolean temp = null;

        for (int i = 0; i < session.getBool().size(); i++) {
            temp = (TargetBoolean) session.getBool().get(i);
            if (temp.getUID().equals(UID)) {
                break;

            }
        }
        return temp;
    }

    private TargetTimer timerGetter(String UID) {
        User session = main.getUser();
        TargetTimer temp = null;

        for (int i = 0; i < session.getTimer().size(); i++) {
            temp = (TargetTimer) session.getTimer().get(i);
            if (temp.getUID().equals(UID)) {
                break;

            }
        }
        return temp;
    }

    private void refreshTableBool() {
        User session = main.getUser();
        String status;
        String colNameBool[] = {"Target", "Tanggal", "Category", "Status", "UID"};
        DefaultTableModel tabelBool = new DefaultTableModel(colNameBool, 0);
        TargetTable.setModel(tabelBool);
        for (int i = 0; i < session.getBool().size(); i++) {
            TargetBoolean dataBool = (TargetBoolean) session.getBool().get(i);
            if (dataBool.getStatus() != 1) {
                status = "not Finished";
            } else {
                status = "Finished";
            }

            String targets[] = {dataBool.getTargetName(), dataBool.getDate(), dataBool.getCategory(), status, dataBool.getUID()};
            tabelBool.addRow(targets);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        boolAdd = new javax.swing.JButton();
        timerAdd = new javax.swing.JButton();
        shareBt = new javax.swing.JButton();
        editBt = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TimerTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        TargetTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TimerTable1 = new javax.swing.JTable();
        selectTarget = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        customCalendar1 = new Pane.CustomCalendar();
        recent = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        boolAdd.setText("Add Target Boolean");
        boolAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boolAddActionPerformed(evt);
            }
        });

        timerAdd.setText("Add Target Timer");
        timerAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timerAddActionPerformed(evt);
            }
        });

        shareBt.setText("ShareTarget");
        shareBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shareBtActionPerformed(evt);
            }
        });

        editBt.setText("Edit");
        editBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtActionPerformed(evt);
            }
        });

        TimerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Target", "Tanggal", "Kategori", "Status", "Durasi", "UID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TimerTable.getTableHeader().setReorderingAllowed(false);
        TimerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TimerTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TimerTable);
        if (TimerTable.getColumnModel().getColumnCount() > 0) {
            TimerTable.getColumnModel().getColumn(0).setResizable(false);
            TimerTable.getColumnModel().getColumn(1).setResizable(false);
            TimerTable.getColumnModel().getColumn(2).setResizable(false);
            TimerTable.getColumnModel().getColumn(3).setResizable(false);
            TimerTable.getColumnModel().getColumn(4).setResizable(false);
        }

        TargetTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Target", "Tanggal", "Kategori", "Status", "UID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TargetTable.setColumnSelectionAllowed(true);
        TargetTable.getTableHeader().setReorderingAllowed(false);
        TargetTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TargetTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TargetTable);
        TargetTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (TargetTable.getColumnModel().getColumnCount() > 0) {
            TargetTable.getColumnModel().getColumn(0).setResizable(false);
            TargetTable.getColumnModel().getColumn(1).setResizable(false);
            TargetTable.getColumnModel().getColumn(2).setResizable(false);
            TargetTable.getColumnModel().getColumn(3).setResizable(false);
            TargetTable.getColumnModel().getColumn(4).setMinWidth(0);
            TargetTable.getColumnModel().getColumn(4).setPreferredWidth(0);
            TargetTable.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        jLabel1.setText("Check Targets");

        jLabel2.setText("Time Targets");

        TimerTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Target", "Tanggal", "Kategori", "Status", "Durasi"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TimerTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(TimerTable1);
        if (TimerTable1.getColumnModel().getColumnCount() > 0) {
            TimerTable1.getColumnModel().getColumn(0).setResizable(false);
            TimerTable1.getColumnModel().getColumn(1).setResizable(false);
            TimerTable1.getColumnModel().getColumn(2).setResizable(false);
            TimerTable1.getColumnModel().getColumn(3).setResizable(false);
            TimerTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        selectTarget.setText("openTarget");
        selectTarget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectTargetActionPerformed(evt);
            }
        });

        jLabel3.setText("Shared Target");

        setResizable(false);

        recent.setText("Please Select");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(customCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 916, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(recent)
                        .addGap(24, 24, 24))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(boolAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timerAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectTarget, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(shareBt, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(customCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(recent))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shareBt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectTarget, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editBt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timerAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boolAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void shareBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shareBtActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_shareBtActionPerformed

    private void boolAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boolAddActionPerformed
        // TODO add your handling code here:

        InputTargetCheck ITC = new InputTargetCheck();
        ITC.setVisible(true);

        ITC.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                TargetBoolean data = ITC.returnData();

                main.saveBoolTarget(data.getTargetName(), data.getCategory(), data.getDate());
                refreshTableTimer();
                refreshTableBool();
            }
        });


    }//GEN-LAST:event_boolAddActionPerformed

    private void timerAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timerAddActionPerformed
        // TODO add your handling code here:

        InputTargetTimer ITT = new InputTargetTimer();
        ITT.setVisible(true);

        ITT.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                TargetTimer data = ITT.returnData();

                main.saveTimerTarget(data.getTargetName(), data.getCategory(), data.getDate(), data.getDurationHour(), data.getDurationMin());
                refreshTableTimer();
                refreshTableBool();
            }
        });


    }//GEN-LAST:event_timerAddActionPerformed

    private void TargetTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TargetTableMouseClicked
        // TODO add your handling code here:
        int row = TargetTable.getSelectedRow();
        String uid = TargetTable.getValueAt(row, 4).toString();

        TargetBoolean temp = boolGetter(uid);
        main.saveSelectedBoolean(temp);
        recent.setText("TargetBoolean");
    }//GEN-LAST:event_TargetTableMouseClicked

    private void editBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtActionPerformed
        // TODO add your handling code here:
        String select = recent.getText();

        if (select.equals("TargetBoolean")) {
            if (main.readSelectedBool() != null) {
                editCheckTarget ct = new editCheckTarget();
                TargetBoolean target = main.readSelectedBool();
                String nama = target.getTargetName();
                String kategori = target.getCategory();
                String tanggal = target.getDate();
                String uid = target.getUID();

                ct.setVisible(true);
                ct.passData(nama, kategori, tanggal);
                ct.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {

                      Datas datas = ct.returnData();

                      boolUpdate(uid, datas.getName(),datas.getKategori());
                      refreshTableTimer();
                      refreshTableBool();
                    }
                });
            }
        } else if (select.equals("TargetTimer")) {
            if (main.readSelectedTimer() != null) {
                editTimerTarget ct = new editTimerTarget();
                
                TargetTimer target = main.readSelectedTimer();
                String nama = target.getTargetName();
                String kategori = target.getCategory();
                String tanggal = target.getDate();
                String uid = target.getUID();
                int jam = target.getDurationHour();
                int menit = target.getDurationMin();

                ct.setVisible(true);
                ct.passData(nama, kategori, jam, menit, tanggal);
                ct.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {

                        editTimerTarget.Datas datas = ct.returnData();
                        timerUpdate(uid,datas.getNama(),datas.getKategori(),datas.getHour(),datas.getMinute());
                        
                        refreshTableTimer();
                        refreshTableBool();
                    }
                });
            }
        }

    }//GEN-LAST:event_editBtActionPerformed

    private void selectTargetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectTargetActionPerformed
        // TODO add your handling code here:
        String select = recent.getText();

        if (select.equals("TargetBoolean")) {
            if (main.readSelectedBool() != null) {
                selectCheckTarget ct = new selectCheckTarget();
                TargetBoolean target = main.readSelectedBool();
                String nama = target.getTargetName();
                String kategori = target.getCategory();
                String tanggal = target.getDate();
                String uid = target.getUID();
                String status;
                if (target.getStatus() != 1) {
                    status = "not Finished";
                } else {
                    status = "Finished";
                }

                ct.setVisible(true);
                ct.passData(nama, kategori, tanggal, status);
                ct.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {

                        boolean update = ct.returnStatus();
                        if (update == true) {
                            updateStatus(uid);
                        }

                        refreshTableTimer();
                        refreshTableBool();
                    }
                });
            }
        } else if (select.equals("TargetTimer")) {
            if (main.readSelectedTimer() != null) {
                selectCheckTarget ct = new selectCheckTarget();
                
                TargetTimer target = main.readSelectedTimer();
                String nama = target.getTargetName();
                String kategori = target.getCategory();
                String tanggal = target.getDate();
                String uid = target.getUID();
                String status;
                if (target.getStatus() != 1) {
                    status = "not Finished";
                } else {
                    status = "Finished";
                }

                ct.setVisible(true);
                ct.passData(nama, kategori, tanggal, status);
                ct.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {

                        boolean update = ct.returnStatus();
                        if (update == true) {
                            updateStatus(uid);
                        }

                        refreshTableTimer();
                        refreshTableBool();
                    }
                });
            }
        }


    }//GEN-LAST:event_selectTargetActionPerformed

    private void TimerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TimerTableMouseClicked
        // TODO add your handling code here:
        int row = TimerTable.getSelectedRow();
        String uid = TimerTable.getValueAt(row, 4).toString();

        TargetTimer temp = timerGetter(uid);
        main.saveSelectedTimer(temp);
        recent.setText("TargetTimer");
    }//GEN-LAST:event_TimerTableMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Calendar_Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calendar_Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calendar_Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calendar_Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Calendar_Panel().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TargetTable;
    private javax.swing.JTable TimerTable;
    private javax.swing.JTable TimerTable1;
    private javax.swing.JButton boolAdd;
    private Pane.CustomCalendar customCalendar1;
    private javax.swing.JButton editBt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel recent;
    private javax.swing.JButton selectTarget;
    private javax.swing.JButton shareBt;
    private javax.swing.JButton timerAdd;
    // End of variables declaration//GEN-END:variables
}
