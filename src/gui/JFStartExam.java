/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import contrain.DatabaseConnections;
import daoImp.BoDeImplDAO;
import daoImp.CauHoiImplDAO;
import daoImp.DapAnImplDAO;
import entity.BoDeChiTiet;
import entity.CauHoi;
import entity.DapAn;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author duyet
 */
public class JFStartExam extends javax.swing.JFrame {

    Connection con;
    CauHoiImplDAO chdao;
    BoDeImplDAO bddao;
    DapAnImplDAO dadao;
    String user;
    String pass;
    int idExam;

    /**
     * Creates new form JFSearchPoint
     */
    public JFStartExam(String username, String password, int id) {
        initComponents();
        // Set default window
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        // Set var 
        user = username;
        pass = password;
        idExam = id;
        // Get Connection
        con = DatabaseConnections.getConnect();
        chdao = new CauHoiImplDAO(con);
        bddao = new BoDeImplDAO(con);
        dadao = new DapAnImplDAO(con);
        // Set Timer
        new Thread() {
            int minute = 19;
            int second = 60;

            @Override
            public void run() {
                while (true) {
                    second = second - 1;
//                    System.out.println(second);
                    lblMinute.setText(Integer.toString(minute));
                    lblSecond.setText(Integer.toString(second));
                    if (lblSecond.getText().equals("0")) {
                        minute = minute - 1;
                        System.out.println(minute);
                        lblMinute.setText(Integer.toString(minute));
                        second = 60;
                    }
                    if (minute == -1 && second == 60) {
                        break;
                    }
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(JFStartExam.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                insertResultExam();
            }
        }.start();
        // Set data
        getDataQuestion();
    }

    public void insertResultExam() {
        JOptionPane.showMessageDialog(rootPane, "Hết thời gian làm bài!");
    }

    public void getDataQuestion() {
        List<BoDeChiTiet> bdct = bddao.getAllByIdExam(idExam);
        List<CauHoi> ch = new ArrayList<>();
        for (BoDeChiTiet boDeChiTiet : bdct) {
            CauHoi c = chdao.getById(boDeChiTiet.getId_cauhoi());
            ch.add(c);
        }
        DefaultListModel model = new DefaultListModel();
        int a = 1;
        for (int i = 0; i < ch.size(); i++) {
            model.add(i, "Câu " + a++ + " :");
        }
        lstQuestion.setModel(model);
        
        // ------------------------------------------------------> Nghiên cứu phần này đi cu Thắng <-------------------------------------------------------------------------
        // ------------------------------------------------------> Hiển thị thì ra r mà có vấn đề lúc chọn đáp án <----------------------------------------------------------
        // ------------------------------------------------------> Với cả tìm xem cách để break line label nhá <--------------------------------------------------------------
        // ------------------------------------------------------> Nếu mà câu hỏi dài thì nó tràn cmn ra ngoài luôn <--------------------------------------------------------------
        for (int i = 0; i < ch.size(); i++) {
            int j = i;
            List<DapAn> da = dadao.getAllAnsert(ch.get(j).getId());
            Collections.shuffle(da);
            lstQuestion.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
                if (lstQuestion.getSelectedIndex() == j) {
                    lblQuestion.setText("Câu " + (j + 1) + " : " + ch.get(j).getNoi_dung());
                    rdoA.setText(da.get(0).getNoi_dung());
                    rdoB.setText(da.get(1).getNoi_dung());
                    rdoC.setText(da.get(2).getNoi_dung());
                    rdoD.setText(da.get(3).getNoi_dung());
                }
            });
        }
        // -------------------------------------------------------------------------------------------------------------------------------------------------------------------

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        btnAns = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblTotalQ = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblTotalTime = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstQuestion = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        lblQuestion = new javax.swing.JLabel();
        rdoA = new javax.swing.JRadioButton();
        rdoB = new javax.swing.JRadioButton();
        rdoC = new javax.swing.JRadioButton();
        rdoD = new javax.swing.JRadioButton();
        btnSubmit = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        lblIdSt = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblNameSt = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblThread = new javax.swing.JLabel();
        lblMinute = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblTime1 = new javax.swing.JLabel();
        lblSecond = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setOpaque(false);

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTitle.setText("BÀI THI SỐ ???");

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Tổng Số Câu Hỏi: ");

        lblTotalQ.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTotalQ.setText("20");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Tổng Thời Gian: ");

        lblTotalTime.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTotalTime.setText("20 phút");

        lstQuestion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lstQuestion.setOpaque(false);
        jScrollPane2.setViewportView(lstQuestion);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTotalQ, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotalTime, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 56, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotalTime)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblTotalQ))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        lblQuestion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblQuestion.setText("Câu hỏi????");
        lblQuestion.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblQuestion.setAutoscrolls(true);

        btnAns.add(rdoA);
        rdoA.setText("Ans 1");
        rdoA.setOpaque(false);

        btnAns.add(rdoB);
        rdoB.setText("Ans 2");
        rdoB.setOpaque(false);

        btnAns.add(rdoC);
        rdoC.setText("Ans 3");
        rdoC.setOpaque(false);

        btnAns.add(rdoD);
        rdoD.setText("Ans 4");
        rdoD.setOpaque(false);

        btnSubmit.setBackground(new java.awt.Color(153, 153, 153));
        btnSubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        btnSubmit.setText("Nộp bài");
        btnSubmit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jLabel14.setText("Ngày: .../.../...");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdoA)
                    .addComponent(rdoB)
                    .addComponent(rdoC)
                    .addComponent(rdoD))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblQuestion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 796, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(lblQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(rdoA)
                .addGap(57, 57, 57)
                .addComponent(rdoB)
                .addGap(57, 57, 57)
                .addComponent(rdoC)
                .addGap(57, 57, 57)
                .addComponent(rdoD)
                .addGap(69, 69, 69)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jLabel14)
                .addContainerGap())
        );

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("Mã Sinh Viên: ");

        lblIdSt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblIdSt.setText("B8793");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Tên Sinh Viên: ");

        lblNameSt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNameSt.setText("Nguyễn Hữu Thắng");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("Mã Đề:");

        lblThread.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblThread.setText("A1");

        lblMinute.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblMinute.setText("20");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Thời Gian: ");

        lblTime1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTime1.setText(":");

        lblSecond.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSecond.setText("00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 13, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(lblIdSt, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblNameSt, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(lblThread, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblMinute, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(lblTime1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblSecond, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1329, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(487, 487, 487)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(lblIdSt)
                            .addComponent(jLabel5)
                            .addComponent(lblNameSt)
                            .addComponent(jLabel15)
                            .addComponent(lblThread))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(lblMinute)
                            .addComponent(lblTime1)
                            .addComponent(lblSecond))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(jPanel1, gridBagConstraints);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/index background.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(jLabel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        int i = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn sẽ nộp!", "Thông báo!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon("src/img/tick.png"));
        if (i == 0) {
            this.dispose();
            JOptionPane.showMessageDialog(this, "Bạn đã nộp bài thành công!");
//            JFStudent jst = new JFStudent(sv);
//            jst.setVisible(true);
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnAns;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblIdSt;
    private javax.swing.JLabel lblMinute;
    private javax.swing.JLabel lblNameSt;
    private javax.swing.JLabel lblQuestion;
    private javax.swing.JLabel lblSecond;
    private javax.swing.JLabel lblThread;
    private javax.swing.JLabel lblTime1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTotalQ;
    private javax.swing.JLabel lblTotalTime;
    private javax.swing.JList<String> lstQuestion;
    private javax.swing.JRadioButton rdoA;
    private javax.swing.JRadioButton rdoB;
    private javax.swing.JRadioButton rdoC;
    private javax.swing.JRadioButton rdoD;
    // End of variables declaration//GEN-END:variables
}
