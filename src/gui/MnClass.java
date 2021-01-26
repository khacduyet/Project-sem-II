/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import contrain.DatabaseConnections;
import dao.ClassDAO;
import daoImp.ClassImplDAO;
import entity.LopHoc;
import java.sql.Connection;
import java.util.List;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author duyet
 */
public class MnClass extends javax.swing.JPanel {

    private Connection con;
    private ClassDAO cdao;
    private boolean checkEdit;
    private int lophocId;

    /**
     * Creates new form JFClass
     */
    public MnClass() {
        initComponents();

        con = DatabaseConnections.getConnect();
        cdao = new ClassImplDAO(con);
        loadDataLopHoc();
        
        // Size Table
        tbl_Class.setRowHeight(30);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupBtnStatus = new javax.swing.ButtonGroup();
        lblTitle = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNameClass = new javax.swing.JTextField();
        txtCourse = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cboYear = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        rdoAction = new javax.swing.JRadioButton();
        rdoStop = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Class = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblErrorNameClass = new javax.swing.JLabel();
        lblErorKhoaHoc = new javax.swing.JLabel();
        btnIns = new javax.swing.JButton();

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(153, 0, 153));
        lblTitle.setText("QUẢN LÝ LỚP HỌC");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Tên lớp:");

        txtNameClass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtCourse.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Khóa học:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Niên khóa:");

        cboYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034" }));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Trạng thái:");

        groupBtnStatus.add(rdoAction);
        rdoAction.setSelected(true);
        rdoAction.setText("Hoạt động");

        groupBtnStatus.add(rdoStop);
        rdoStop.setText("Ngừng hoạt động");

        tbl_Class.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_Class.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ClassMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Class);

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        btnSave.setText("Lưu");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lblErrorNameClass.setForeground(new java.awt.Color(255, 0, 0));

        lblErorKhoaHoc.setForeground(new java.awt.Color(255, 0, 0));

        btnIns.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnIns.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Clear-icon.png"))); // NOI18N
        btnIns.setText("Thêm");
        btnIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(50, 50, 50)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblErrorNameClass, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNameClass, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblErorKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cboYear, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(54, 54, 54)
                                        .addComponent(txtCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnIns)
                                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(48, 48, 48)
                                .addComponent(rdoAction)
                                .addGap(71, 71, 71)
                                .addComponent(rdoStop))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNameClass, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIns))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblErrorNameClass, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblErorKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addGap(26, 26, 26)
                        .addComponent(btnDelete)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboYear, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoAction)
                    .addComponent(rdoStop)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // lưu dữ liệu lớp vào csdl
        LopHoc lp1 = new LopHoc();
        if (checkNull()) {
            lp1.setTen_lop(txtNameClass.getText());
            lp1.setKhoa_hoc(txtCourse.getText());
            String value = cboYear.getSelectedItem().toString();
            lp1.setNien_khoa(Integer.parseInt(value));
            lp1.setTrang_thai(rdoAction.isSelected());

            if (checkEdit) {
                lp1.setId(lophocId);
                cdao.update(lp1);
                JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
                loadDataLopHoc();
            } else {
                cdao.insert(lp1);
                JOptionPane.showMessageDialog(this, "Thêm mới thành công!");
                loadDataLopHoc();
            }

        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int rowSelect = tbl_Class.getSelectedRow();
        lophocId = (int) tbl_Class.getValueAt(rowSelect, 0);
        int checkAccept = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa không!", "Thông báo!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon("src/img/exit-48px.png"));
        if (checkAccept == 0) {
            cdao.delete(lophocId);
            JOptionPane.showMessageDialog(this, "Đã xóa thành công!", "Thông báo!", JOptionPane.QUESTION_MESSAGE, new ImageIcon("src/img/tick.png"));
            loadDataLopHoc();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tbl_ClassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ClassMouseClicked
        // update data bang lop hoc5
        int rowSelect = tbl_Class.getSelectedRow();
        lophocId = (int) tbl_Class.getValueAt(rowSelect, 0);
        LopHoc lh = cdao.getById(lophocId);
        txtNameClass.setText(lh.getTen_lop());
        txtCourse.setText(lh.getKhoa_hoc());
        String check = (String) tbl_Class.getValueAt(rowSelect, 4);
        if (check.equals("Đang Hoạt Động")) {
            rdoAction.setSelected(true);
        } else {
            rdoStop.setSelected(true);
        }
        checkEdit = true;
    }//GEN-LAST:event_tbl_ClassMouseClicked

    private void btnInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsActionPerformed
        checkEdit = false;
        txtCourse.setText("");
        txtNameClass.setText("");
        cboYear.setSelectedIndex(0);
        rdoAction.setSelected(true);
        txtNameClass.requestFocus();
    }//GEN-LAST:event_btnInsActionPerformed

    public boolean checkNull() {
        if (txtNameClass.getText().equals("")) {
            lblErrorNameClass.setText("Bạn cần nhập vào tên lớp!");
            return false;
        } else if (txtCourse.getText().equals("")) {
            lblErrorNameClass.setText("");
            lblErorKhoaHoc.setText("Bạn cần nhập vào khóa học!");
            return false;
        } else {
            lblErorKhoaHoc.setText("");
            return true;
        }
    }

    private void loadDataLopHoc() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("Tên Lớp");
        model.addColumn("Khóa Học");
        model.addColumn("Niên Khóa");
        model.addColumn("Trạng Thái");

        // add row
        List<LopHoc> listLH = cdao.getAll();
        for (LopHoc item : listLH) {
            Vector rows = new Vector();
            rows.add(item.getId());
            rows.add(item.getTen_lop());
            rows.add(item.getKhoa_hoc());
            rows.add(item.getNien_khoa());
            rows.add(item.isTrang_thai() ? "Đang Hoạt Động" : "Đã Dừng");
            model.addRow(rows);
            System.out.println("oke" + item.getTen_lop());
        }
        tbl_Class.setModel(model);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnIns;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cboYear;
    private javax.swing.ButtonGroup groupBtnStatus;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblErorKhoaHoc;
    private javax.swing.JLabel lblErrorNameClass;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JRadioButton rdoAction;
    private javax.swing.JRadioButton rdoStop;
    private javax.swing.JTable tbl_Class;
    private javax.swing.JTextField txtCourse;
    private javax.swing.JTextField txtNameClass;
    // End of variables declaration//GEN-END:variables
}
