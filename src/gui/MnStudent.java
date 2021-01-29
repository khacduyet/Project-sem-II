/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import contrain.DatabaseConnections;
import daoImp.BoDeImplDAO;
import daoImp.ClassImplDAO;
import daoImp.KetQuaImplDAO;
import daoImp.KhieuNaiImplDAO;
import daoImp.StudentImplDAO;
import entity.BoDe;
import entity.KetQua;
import entity.KhieuNai;
import entity.LopHoc;
import entity.SinhVien;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Laptophaidang.com
 */
public final class MnStudent extends javax.swing.JPanel {

    ClassImplDAO cdao;
    StudentImplDAO sdao;
    KhieuNaiImplDAO kndao;
    StudentImplDAO stdao;
    KetQuaImplDAO ketquaDAO;
    BoDeImplDAO bodeDAO;
    Connection con;
    boolean checkSave = true;
    int idUpd;
    DefaultTableModel dm;

    /**
     * Creates new form MnStudent
     */
    public MnStudent() {
        initComponents();
        con = DatabaseConnections.getConnect();
        cdao = new ClassImplDAO(con);
        sdao = new StudentImplDAO(con);
        kndao = new KhieuNaiImplDAO(con);
        stdao = new StudentImplDAO(con);
        ketquaDAO = new KetQuaImplDAO(con);
        bodeDAO = new BoDeImplDAO(con);
        // Danh sách sinh viên
        loadDataTableStudent();
        loadDataTableReport();
        // Thêm mới sinh viên
        loadClass();
        getId();
        AutoCompleteDecorator.decorate(cboClass);
        // Set độ rộng hàng
        tblStudents.setRowHeight(30);
        tblPoint.setRowHeight(30);
        tblReport.setRowHeight(30);
        tblStudents.setAutoCreateRowSorter(true);
        dm = (DefaultTableModel) tblStudents.getModel();
        // load diem sinh vien theo bo de da thi
        loadDataDiem();
    }

    public void Filter(String str) {
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(dm);
        trs.setRowFilter(RowFilter.regexFilter(str));
    }

    public void loadClass() {
        List<LopHoc> dataClass = cdao.getAll();
        dataClass.forEach((dc) -> {
            cboClass.addItem(dc);
        });
    }

    public void getId() {
        SinhVien stud = sdao.getIdIns();
        String ma_sv = stud.getMa_sv();
        Character ma_new = ma_sv.trim().charAt(ma_sv.length() - 1);
        int number = Integer.parseInt(ma_new.toString());
        String result = String.valueOf(number + 1);
        lblIdStud.setText("SV00" + result);
    }

    public void loadDataTableStudent() {
        List<SinhVien> dataStud = sdao.getAll();
        DefaultTableModel dtm = new DefaultTableModel();
        // Set tên cột
        Vector cols = new Vector();
        cols.add("ID");
        cols.add("Mã Sinh Viên");
        cols.add("Mã Lớp");
        cols.add("Lớp");
        cols.add("Họ Tên");
        cols.add("Giới Tính");
        cols.add("Ngày Sinh");
        cols.add("Ngày Nhập Học");
        cols.add("Ngày Cập Nhật");
        cols.add("Di Động");
        cols.add("ĐT Gia Đình");
        cols.add("Email");
        cols.add("Địa Chỉ");
        cols.add("Username");
        cols.add("Password");
        cols.add("Ghi Chú");
        cols.add("Trạng Thái");
        dtm.setColumnIdentifiers(cols);

        dataStud.stream().map((sv) -> {
            Vector rows = new Vector();
            rows.add(sv.getId());
            rows.add(sv.getMa_sv());
            rows.add(sv.getId_lop());
            LopHoc dataClass = cdao.getById(sv.getId_lop());
            rows.add(dataClass.getTen_lop());
            rows.add(sv.getHo_ten());
            rows.add(sv.isGioi_Tinh() ? "Nam" : "Nữ");
            rows.add(sv.getNgay_sinh());
            rows.add(sv.getNgay_nhap_hoc());
            rows.add(sv.getNgay_cap_nhat());
            rows.add(sv.getDi_dong());
            rows.add(sv.getDt_gia_dinh());
            rows.add(sv.getEmail());
            rows.add(sv.getDia_chi());
            rows.add(sv.getUsername());
            rows.add(sv.getPassword());
            rows.add(sv.getGhi_chu());
            rows.add(sv.isTrang_thai() ? "Mở" : "Khóa");
            return rows;
        }).forEachOrdered((rows) -> {
            dtm.addRow(rows);
        });

        tblStudents.setModel(dtm);
    }

    public void loadDataTableStudentSeach() {
        String nameSeach = txtSearchStudent.getText();
        List<SinhVien> dataStud = sdao.getAllSeacher(nameSeach);

        DefaultTableModel dtm = new DefaultTableModel();
        // Set tên cột
        Vector cols = new Vector();
        cols.add("ID");
        cols.add("Mã Sinh Viên");
        cols.add("Mã Lớp");
        cols.add("Lớp");
        cols.add("Họ Tên");
        cols.add("Giới Tính");
        cols.add("Ngày Sinh");
        cols.add("Ngày Nhập Học");
        cols.add("Ngày Cập Nhật");
        cols.add("Di Động");
        cols.add("ĐT Gia Đình");
        cols.add("Email");
        cols.add("Địa Chỉ");
        cols.add("Username");
        cols.add("Password");
        cols.add("Ghi Chú");
        cols.add("Trạng Thái");
        dtm.setColumnIdentifiers(cols);

        dataStud.stream().map((sv) -> {
            Vector rows = new Vector();
            rows.add(sv.getId());
            rows.add(sv.getMa_sv());
            rows.add(sv.getId_lop());
            LopHoc dataClass = cdao.getById(sv.getId_lop());
            rows.add(dataClass.getTen_lop());
            rows.add(sv.getHo_ten());
            rows.add(sv.isGioi_Tinh() ? "Nam" : "Nữ");
            rows.add(sv.getNgay_sinh());
            rows.add(sv.getNgay_nhap_hoc());
            rows.add(sv.getNgay_cap_nhat());
            rows.add(sv.getDi_dong());
            rows.add(sv.getDt_gia_dinh());
            rows.add(sv.getEmail());
            rows.add(sv.getDia_chi());
            rows.add(sv.getUsername());
            rows.add(sv.getPassword());
            rows.add(sv.getGhi_chu());
            rows.add(sv.isTrang_thai() ? "Mở" : "Khóa");
            return rows;
        }).forEachOrdered((rows) -> {
            dtm.addRow(rows);
        });

        tblStudents.setModel(dtm);
    }

    public void loadDataTableReport() {
        List<KhieuNai> kn = kndao.getAll();
        DefaultTableModel dtm = new DefaultTableModel();
        // Set tên cột
        Vector cols = new Vector();
        cols.add("ID");
        cols.add("Mã Sinh Viên");
        cols.add("Tên Sinh Viên");
        cols.add("Tiêu Đề");
        cols.add("Nội Dung");
        cols.add("Ngày Tạo");
        dtm.setColumnIdentifiers(cols);

        kn.stream().map((k) -> {
            Vector rows = new Vector();
            rows.add(k.getId());
            SinhVien sv = stdao.getById(k.getId_sinhvien());
            rows.add(sv.getMa_sv());
            rows.add(sv.getHo_ten());
            rows.add(k.getTieu_de());
            rows.add(k.getNoi_dung());
            rows.add(k.getNgay_tao());
            return rows;
        }).forEachOrdered((rows) -> {
            dtm.addRow(rows);
        });

        tblReport.setModel(dtm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GioiTinhSinhVien = new javax.swing.ButtonGroup();
        jdlDisplayReport = new javax.swing.JDialog();
        jLabel21 = new javax.swing.JLabel();
        lblSrpId = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lblSrpMa = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lblSrpName = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lblSrpDate = new javax.swing.JLabel();
        lblSrpTitle = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txaContent = new javax.swing.JTextArea();
        QLSinhVien = new javax.swing.JTabbedPane();
        listStudent = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStudents = new javax.swing.JTable();
        btnUpd = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnChangeStatus = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        txtSearchStudent = new javax.swing.JTextField();
        btnSeachStudent = new javax.swing.JButton();
        btnGetAllStudent = new javax.swing.JButton();
        AddStudent = new javax.swing.JPanel();
        lblTitleIns = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblIdStud = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNameStud = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cboClass = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        rdoMale = new javax.swing.JRadioButton();
        rdoFemale = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jdcDam = new com.toedter.calendar.JDateChooser();
        txtPhone = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtHomePhone = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaNote = new javax.swing.JTextArea();
        jdcDob = new com.toedter.calendar.JDateChooser();
        btnIns = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        ErrorName = new javax.swing.JLabel();
        ErrorEmail = new javax.swing.JLabel();
        ErrorDob = new javax.swing.JLabel();
        ErrorDam = new javax.swing.JLabel();
        ErrorAddress = new javax.swing.JLabel();
        ErrorUser = new javax.swing.JLabel();
        ErrorPass = new javax.swing.JLabel();
        ErrorPhone = new javax.swing.JLabel();
        ErrorPrtPhone = new javax.swing.JLabel();
        displayPointStudent = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtIdStud = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        cboFilter = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPoint = new javax.swing.JTable();
        jSeparator3 = new javax.swing.JSeparator();
        report = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblReport = new javax.swing.JTable();
        btnReadReport = new javax.swing.JButton();

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("ID:");

        lblSrpId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Mã sinh viên:");

        lblSrpMa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("Tên sinh viên:");

        lblSrpName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("Ngày tạo:");

        lblSrpDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblSrpTitle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setText("Tiêu đề:");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setText("Nội dung:");

        txaContent.setEditable(false);
        txaContent.setColumns(20);
        txaContent.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txaContent.setLineWrap(true);
        txaContent.setRows(5);
        txaContent.setWrapStyleWord(true);
        jScrollPane5.setViewportView(txaContent);

        javax.swing.GroupLayout jdlDisplayReportLayout = new javax.swing.GroupLayout(jdlDisplayReport.getContentPane());
        jdlDisplayReport.getContentPane().setLayout(jdlDisplayReportLayout);
        jdlDisplayReportLayout.setHorizontalGroup(
            jdlDisplayReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdlDisplayReportLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jdlDisplayReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jdlDisplayReportLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(100, 100, 100)
                        .addComponent(lblSrpId, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jdlDisplayReportLayout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(33, 33, 33)
                        .addComponent(lblSrpMa, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jdlDisplayReportLayout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(27, 27, 27)
                        .addComponent(lblSrpName, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jdlDisplayReportLayout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(54, 54, 54)
                        .addComponent(lblSrpDate, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jdlDisplayReportLayout.createSequentialGroup()
                        .addGroup(jdlDisplayReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26))
                        .addGap(54, 54, 54)
                        .addGroup(jdlDisplayReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblSrpTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                            .addComponent(jScrollPane5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jdlDisplayReportLayout.setVerticalGroup(
            jdlDisplayReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdlDisplayReportLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jdlDisplayReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(lblSrpId, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jdlDisplayReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel22)
                    .addComponent(lblSrpMa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jdlDisplayReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23)
                    .addComponent(lblSrpName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jdlDisplayReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel24)
                    .addComponent(lblSrpDate, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jdlDisplayReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25)
                    .addComponent(lblSrpTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jdlDisplayReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        QLSinhVien.setPreferredSize(new java.awt.Dimension(1057, 654));

        listStudent.setPreferredSize(new java.awt.Dimension(1052, 600));

        tblStudents.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblStudents.setModel(new javax.swing.table.DefaultTableModel(
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
        tblStudents.setMaximumSize(new java.awt.Dimension(32767, 32767));
        jScrollPane2.setViewportView(tblStudents);

        btnUpd.setBackground(new java.awt.Color(204, 0, 204));
        btnUpd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pencil-32px.png"))); // NOI18N
        btnUpd.setText("Sửa");
        btnUpd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdActionPerformed(evt);
            }
        });

        btnDel.setBackground(new java.awt.Color(204, 0, 204));
        btnDel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btnDel.setText("Xóa");
        btnDel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 204));
        jLabel3.setText("DANH SÁCH SINH VIÊN");

        btnChangeStatus.setBackground(new java.awt.Color(204, 0, 204));
        btnChangeStatus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnChangeStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/status.png"))); // NOI18N
        btnChangeStatus.setText("Mở / Khóa");
        btnChangeStatus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChangeStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeStatusActionPerformed(evt);
            }
        });

        jLabel19.setText("Tìm kiếm:");

        txtSearchStudent.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchStudentKeyReleased(evt);
            }
        });

        btnSeachStudent.setText("Tìm kiếm");
        btnSeachStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeachStudentActionPerformed(evt);
            }
        });

        btnGetAllStudent.setText("Tất cả");
        btnGetAllStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetAllStudentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout listStudentLayout = new javax.swing.GroupLayout(listStudent);
        listStudent.setLayout(listStudentLayout);
        listStudentLayout.setHorizontalGroup(
            listStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listStudentLayout.createSequentialGroup()
                .addGroup(listStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(listStudentLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1)
                        .addGap(18, 18, 18))
                    .addGroup(listStudentLayout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 194, Short.MAX_VALUE)))
                .addGroup(listStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(listStudentLayout.createSequentialGroup()
                        .addComponent(btnUpd, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDel))
                    .addComponent(btnChangeStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(41, 41, 41))
            .addGroup(listStudentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(listStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(listStudentLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearchStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSeachStudent)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGetAllStudent)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        listStudentLayout.setVerticalGroup(
            listStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listStudentLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(listStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(listStudentLayout.createSequentialGroup()
                        .addComponent(btnChangeStatus)
                        .addGap(10, 10, 10)
                        .addGroup(listStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpd)
                            .addComponent(btnDel)))
                    .addGroup(listStudentLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(listStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(listStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearchStudent, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                        .addComponent(btnSeachStudent)
                        .addComponent(btnGetAllStudent))
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
        );

        QLSinhVien.addTab("Danh sách sinh viên", listStudent);

        AddStudent.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblTitleIns.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTitleIns.setForeground(new java.awt.Color(204, 0, 204));
        lblTitleIns.setText("THÊM MỚI SINH VIÊN");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Mã Sinh Viên:");

        lblIdStud.setText("B8792");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Họ và Tên:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Lớp:");

        cboClass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("Giới tính:");

        GioiTinhSinhVien.add(rdoMale);
        rdoMale.setSelected(true);
        rdoMale.setText("Nam");

        GioiTinhSinhVien.add(rdoFemale);
        rdoFemale.setText("Nữ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("Ngày sinh:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("Ngày nhập học:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setText("Số điện thoại:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setText("ĐT Phụ Huynh:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Email");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Địa chỉ");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("UserName:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("PassWord:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Ghi chú:");

        txaNote.setColumns(20);
        txaNote.setRows(5);
        jScrollPane1.setViewportView(txaNote);

        btnIns.setBackground(new java.awt.Color(204, 0, 204));
        btnIns.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnIns.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Save-icon.png"))); // NOI18N
        btnIns.setText("Lưu");
        btnIns.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(204, 0, 204));
        btnReset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Clear-icon.png"))); // NOI18N
        btnReset.setText("Làm mới");
        btnReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        ErrorName.setForeground(new java.awt.Color(255, 0, 0));

        ErrorEmail.setForeground(new java.awt.Color(255, 0, 0));

        ErrorDob.setForeground(new java.awt.Color(255, 0, 0));

        ErrorDam.setForeground(new java.awt.Color(255, 0, 0));

        ErrorAddress.setForeground(new java.awt.Color(255, 0, 0));

        ErrorUser.setForeground(new java.awt.Color(255, 0, 0));

        ErrorPass.setForeground(new java.awt.Color(255, 0, 0));

        ErrorPhone.setForeground(new java.awt.Color(255, 0, 0));

        ErrorPrtPhone.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout AddStudentLayout = new javax.swing.GroupLayout(AddStudent);
        AddStudent.setLayout(AddStudentLayout);
        AddStudentLayout.setHorizontalGroup(
            AddStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddStudentLayout.createSequentialGroup()
                .addGroup(AddStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 943, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(AddStudentLayout.createSequentialGroup()
                        .addGroup(AddStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AddStudentLayout.createSequentialGroup()
                                .addGroup(AddStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(AddStudentLayout.createSequentialGroup()
                                        .addGap(57, 57, 57)
                                        .addGroup(AddStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(AddStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(AddStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddStudentLayout.createSequentialGroup()
                                                    .addGap(2, 2, 2)
                                                    .addGroup(AddStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddStudentLayout.createSequentialGroup()
                                                            .addComponent(jLabel9)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(AddStudentLayout.createSequentialGroup()
                                                            .addComponent(jLabel10)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addGroup(AddStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(ErrorPrtPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(txtHomePhone))))))
                                            .addGroup(AddStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(AddStudentLayout.createSequentialGroup()
                                                    .addGroup(AddStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel8)
                                                        .addGroup(AddStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(AddStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jdcDam, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(AddStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                            .addComponent(ErrorDob, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(jdcDob, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
                                                        .addComponent(ErrorDam, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(AddStudentLayout.createSequentialGroup()
                                                    .addComponent(rdoMale)
                                                    .addGap(65, 65, 65)
                                                    .addComponent(rdoFemale)
                                                    .addGap(156, 156, 156))
                                                .addGroup(AddStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblIdStud, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cboClass, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(AddStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(ErrorName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(txtNameStud, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE))))))
                                    .addGroup(AddStudentLayout.createSequentialGroup()
                                        .addGap(165, 165, 165)
                                        .addComponent(ErrorPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(80, 80, 80)
                                .addGroup(AddStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(AddStudentLayout.createSequentialGroup()
                                        .addGroup(AddStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(38, 38, 38)
                                        .addGroup(AddStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(AddStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(ErrorPass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(ErrorAddress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(ErrorEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtAddress, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                                            .addComponent(ErrorUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel13)
                                    .addGroup(AddStudentLayout.createSequentialGroup()
                                        .addComponent(btnIns)
                                        .addGap(66, 66, 66)
                                        .addComponent(btnReset))))
                            .addGroup(AddStudentLayout.createSequentialGroup()
                                .addGap(286, 286, 286)
                                .addComponent(lblTitleIns, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        AddStudentLayout.setVerticalGroup(
            AddStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddStudentLayout.createSequentialGroup()
                .addComponent(lblTitleIns, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(AddStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdStud, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AddStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddStudentLayout.createSequentialGroup()
                        .addGroup(AddStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNameStud, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(ErrorName))
                    .addGroup(AddStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ErrorEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AddStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboClass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(ErrorAddress)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AddStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoMale)
                    .addComponent(rdoFemale))
                .addGroup(AddStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddStudentLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(AddStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jdcDob, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(AddStudentLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AddStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ErrorUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ErrorDob)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AddStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(AddStudentLayout.createSequentialGroup()
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ErrorPass))
                    .addGroup(AddStudentLayout.createSequentialGroup()
                        .addGroup(AddStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdcDam, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ErrorDam)))
                .addGroup(AddStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddStudentLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(AddStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ErrorPhone)
                        .addGap(29, 29, 29)
                        .addGroup(AddStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHomePhone, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ErrorPrtPhone)
                        .addGap(18, 18, 18))
                    .addGroup(AddStudentLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(AddStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIns)
                    .addComponent(btnReset))
                .addGap(109, 109, 109))
        );

        QLSinhVien.addTab("Quản lý sinh viên", AddStudent);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 204));
        jLabel1.setText("TRA CỨU ĐIỂM SINH VIÊN");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Mã SV:");

        txtIdStud.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnSearch.setBackground(new java.awt.Color(204, 0, 204));
        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/find.png"))); // NOI18N
        btnSearch.setText("Tra cứu");
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Lọc:");

        cboFilter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đạt", "Không Đạt" }));
        cboFilter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 0, 204));
        jLabel18.setText("BẢNG ĐIỂM SINH VIÊN");

        tblPoint.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblPoint);

        javax.swing.GroupLayout displayPointStudentLayout = new javax.swing.GroupLayout(displayPointStudent);
        displayPointStudent.setLayout(displayPointStudentLayout);
        displayPointStudentLayout.setHorizontalGroup(
            displayPointStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayPointStudentLayout.createSequentialGroup()
                .addGap(265, 265, 265)
                .addComponent(jLabel18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(displayPointStudentLayout.createSequentialGroup()
                .addGroup(displayPointStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(displayPointStudentLayout.createSequentialGroup()
                        .addGroup(displayPointStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(displayPointStudentLayout.createSequentialGroup()
                                .addGap(258, 258, 258)
                                .addComponent(jLabel1))
                            .addGroup(displayPointStudentLayout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(displayPointStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(52, 52, 52)
                                .addGroup(displayPointStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(displayPointStudentLayout.createSequentialGroup()
                                        .addComponent(txtIdStud, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(142, 142, 142)
                                        .addComponent(btnSearch))
                                    .addComponent(cboFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, displayPointStudentLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(displayPointStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        displayPointStudentLayout.setVerticalGroup(
            displayPointStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayPointStudentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(displayPointStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdStud, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(displayPointStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboFilter)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
        );

        QLSinhVien.addTab("Bảng điểm", displayPointStudent);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(204, 0, 204));
        jLabel20.setText("KHIẾU NẠI");

        tblReport.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tblReport);

        btnReadReport.setBackground(new java.awt.Color(204, 0, 204));
        btnReadReport.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReadReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/read.png"))); // NOI18N
        btnReadReport.setText("Đọc");
        btnReadReport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReadReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout reportLayout = new javax.swing.GroupLayout(report);
        report.setLayout(reportLayout);
        reportLayout.setHorizontalGroup(
            reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportLayout.createSequentialGroup()
                .addGroup(reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(reportLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 558, Short.MAX_VALUE)
                        .addComponent(btnReadReport)
                        .addGap(144, 144, 144))
                    .addGroup(reportLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator4))))
                .addContainerGap())
        );
        reportLayout.setVerticalGroup(
            reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(btnReadReport))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(200, Short.MAX_VALUE))
        );

        QLSinhVien.addTab("Khiếu nại", report);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(QLSinhVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(QLSinhVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsActionPerformed
        SinhVien stud = new SinhVien();
        // Mã sinh viên
        stud.setMa_sv(lblIdStud.getText());
        // ID lớp học
        LopHoc lh = cboClass.getItemAt(cboClass.getSelectedIndex());
        stud.setId_lop(lh.getId());
        // Tên Sinh Viên
        if (!txtNameStud.getText().isEmpty()) {
            stud.setHo_ten(txtNameStud.getText());
            ErrorName.setText("");
        } else {
            ErrorName.setText("Tên sinh viên không được để trống!");
        }
        // Giới tính
        if (rdoMale.isSelected()) {
            stud.setGioi_Tinh(true);
        } else {
            stud.setGioi_Tinh(false);
        }
        // Ngày sinh
        Date dob = jdcDob.getDate();
        if (dob == null) {
            ErrorDob.setText("Ngày sinh không hợp lệ!");
        } else {
            java.sql.Date sqlDob = new java.sql.Date(dob.getTime());
            ErrorDob.setText("");
            stud.setNgay_sinh(sqlDob);
        }
        // Ngày nhập học
        Date dam = jdcDam.getDate();
        if (dam == null) {
            ErrorDam.setText("Ngày nhập học không hợp lệ!");
        } else {
            java.sql.Date sqlDam = new java.sql.Date(dam.getTime());
            ErrorDam.setText("");
            stud.setNgay_nhap_hoc(sqlDam);
        }
        // Date of update
        Timestamp ts = new Timestamp(new Date().getTime());
        java.sql.Date sqlDou = new java.sql.Date(ts.getTime());
        stud.setNgay_cap_nhat(sqlDou);

        // Di động
        if (!txtPhone.getText().isEmpty()) {
            stud.setDi_dong(txtPhone.getText());
            ErrorPhone.setText("");
        } else {
            ErrorPhone.setText("Số điện thoại không được để trống!");
        }

        // ĐT gia đình
        if (!txtHomePhone.getText().isEmpty()) {
            stud.setDt_gia_dinh(txtHomePhone.getText());
            ErrorPrtPhone.setText("");
        } else {
            ErrorPrtPhone.setText("ĐT gia đình không được để trống!");
        }

        // Email
        if (!txtEmail.getText().isEmpty()) {
            stud.setEmail(txtEmail.getText());
            ErrorEmail.setText("");
        } else {
            ErrorEmail.setText("Email không được để trống!");
        }

        // Địa chỉ 
        if (!txtAddress.getText().isEmpty()) {
            stud.setDia_chi(txtAddress.getText());
            ErrorAddress.setText("");
        } else {
            ErrorAddress.setText("Địa chỉ không được để trống!");
        }

        // Avatar: Tạm thời để rỗng
        stud.setAvatar("");
        // Tên tài khoản
        if (!txtUsername.getText().isEmpty()) {
            stud.setUsername(txtUsername.getText());
            ErrorUser.setText("");
        } else {
            ErrorUser.setText("Tên tài khoản không được để trống!");
        }
        // Mật khẩu
        if (!txtPassword.getText().isEmpty()) {
            stud.setPassword(txtPassword.getText());
            ErrorPass.setText("");
        } else {
            ErrorPass.setText("Mật khẩu không được để trống!");
        }

        // Ghi chú
        stud.setGhi_chu(txaNote.getText());

        // Kiểm tra nếu điền đầy đủ trường thì thực thi
        if (!txtNameStud.getText().isEmpty() && dob != null && dam != null && !txtPhone.getText().isEmpty()
                && !txtHomePhone.getText().isEmpty() && !txtEmail.getText().isEmpty() && !txtAddress.getText().isEmpty()
                && !txtUsername.getText().isEmpty() && !txtPassword.getText().isEmpty()) {
            if (checkSave) {
                // Trạng thái: Mặc định mở khóa
                stud.setTrang_thai(true);
                // Thêm mới
                sdao.insert(stud);
                JOptionPane.showMessageDialog(this, "Thêm mới thành công!", "Thông báo!", JOptionPane.HEIGHT, new ImageIcon("src/img/tick.png"));
            } else {
                // Cập nhật
                stud.setId(idUpd);
                SinhVien sv = sdao.getById(idUpd);
                stud.setTrang_thai(sv.isTrang_thai());
                sdao.update(stud);
                JOptionPane.showMessageDialog(this, "Cập nhật thành công!", "Thông báo!", JOptionPane.HEIGHT, new ImageIcon("src/img/tick.png"));
                QLSinhVien.setSelectedIndex(0);
            }
            loadFormReset();
        }

        loadDataTableStudent();
    }//GEN-LAST:event_btnInsActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        checkSave = true;
        lblTitleIns.setText("THÊM MỚI SINH VIÊN");
        loadFormReset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        checkSave = true;
        int selectDel = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa!", "Thông Báo!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon("src/img/tick.png"));
        if (selectDel == 0) {
            int rowSelect = tblStudents.getSelectedRow();
            int getValue = (int) tblStudents.getValueAt(rowSelect, 0);
            cdao.delete(getValue);
        }
    }//GEN-LAST:event_btnDelActionPerformed

    private void btnUpdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdActionPerformed
        checkSave = false;
        int selectUpd = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn sửa!", "Thông Báo!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon("src/img/exit-48px.png"));
        if (selectUpd == 0) {
            loadFormReset();
            QLSinhVien.setSelectedIndex(1);
            int rowSelect = tblStudents.getSelectedRow();
            int getValue = (int) tblStudents.getValueAt(rowSelect, 0);
            // Truyền form từ Danh sách -> Thêm mới
            setFormStudUpd(getValue);
            // Truyền ID để cập nhật
            idUpd = getValue;
        }
    }//GEN-LAST:event_btnUpdActionPerformed

    private void btnChangeStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeStatusActionPerformed
        int rowSelect = tblStudents.getSelectedRow();
        int getValue = (int) tblStudents.getValueAt(rowSelect, 0);
        String str = "";
        SinhVien stud = sdao.getById(getValue);
        if (stud.isTrang_thai() == true) {
            str = " Khóa ";
        } else {
            str = " Mở ";
        }
        int selectUpd = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn" + str + "tài khoản!", "Thông Báo!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, new ImageIcon("src/img/alert-warning.png"));
        if (selectUpd == 0) {
            stud.setId(stud.getId());
            stud.setTrang_thai(!stud.isTrang_thai());
            sdao.updateStatus(stud);
            JOptionPane.showMessageDialog(this, str + "tài khoản thành công!", "Thông báo!", JOptionPane.QUESTION_MESSAGE, new ImageIcon("src/img/tick.png"));
            loadDataTableStudent();
        }
    }//GEN-LAST:event_btnChangeStatusActionPerformed

    private void txtSearchStudentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchStudentKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchStudentKeyReleased

    private void btnReadReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadReportActionPerformed
        int rowSelect = tblReport.getSelectedRow();
        int getIdRpt = (int) tblReport.getValueAt(rowSelect, 0);
        KhieuNai k = kndao.getById(getIdRpt);
        jdlDisplayReport.setVisible(true);
        jdlDisplayReport.setLocationRelativeTo(null);
        jdlDisplayReport.setSize(500, 500);
        lblSrpId.setText(String.valueOf(k.getId()));
        SinhVien sv = stdao.getById(k.getId_sinhvien());
        lblSrpMa.setText(sv.getMa_sv());
        lblSrpName.setText(sv.getHo_ten());
        lblSrpTitle.setText(k.getTieu_de());
        Date date = k.getNgay_tao();
        lblSrpDate.setText(date.toString());
        txaContent.setText(k.getNoi_dung());
    }//GEN-LAST:event_btnReadReportActionPerformed

    private void btnSeachStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeachStudentActionPerformed
        // tim kiem thongo tin sinh vien
        loadDataTableStudentSeach();
    }//GEN-LAST:event_btnSeachStudentActionPerformed

    private void btnGetAllStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetAllStudentActionPerformed
        // show tat ca thong tin sinh vien
        loadDataTableStudent();
    }//GEN-LAST:event_btnGetAllStudentActionPerformed

    public void setFormStudUpd(int id) {
        lblTitleIns.setText("SỬA SINH VIÊN");
        SinhVien stud = sdao.getById(id);
        // Mã sinh viên
        lblIdStud.setText(stud.getMa_sv());
        // Tên sinh viên
        txtNameStud.setText(stud.getHo_ten());
        // Combobox lớp học
        LopHoc lh = cdao.getById(stud.getId_lop());
        for (int i = 0; i < cboClass.getItemCount(); i++) {
            if (cboClass.getItemAt(i).getTen_lop().equals(lh.getTen_lop())) {
                cboClass.setSelectedIndex(i);
                break;
            }
        }
        // Giới tính
        if (stud.isGioi_Tinh()) {
            rdoMale.setSelected(true);
        } else {
            rdoFemale.setSelected(true);
        }
        // Ngày sinh
        jdcDob.setDate(stud.getNgay_sinh());
        // Ngày nhập học
        jdcDam.setDate(stud.getNgay_nhap_hoc());
        // Số điện thoại
        txtPhone.setText(stud.getDi_dong());
        // Điện thoại phụ huynh
        txtHomePhone.setText(stud.getDt_gia_dinh());
        // Email
        txtEmail.setText(stud.getEmail());
        // Địa chỉ
        txtAddress.setText(stud.getDia_chi());
        // Username
        txtUsername.setText(stud.getUsername());
        // Password
        txtPassword.setText(stud.getPassword());
        // Ghi chú
        txaNote.setText(stud.getGhi_chu());
    }

    public void loadFormReset() {
        getId();
        txtNameStud.setText("");
        cboClass.setSelectedIndex(0);
        rdoMale.isSelected();
        jdcDob.setCalendar(null);
        jdcDam.setCalendar(null);
        txtPhone.setText("");
        txtHomePhone.setText("");
        txtEmail.setText("");
        txtAddress.setText("");
        txtUsername.setText("");
        txtPassword.setText("");
        txaNote.setText("");
        // Error
        ErrorAddress.setText("");
        ErrorDam.setText("");
        ErrorDob.setText("");
        ErrorEmail.setText("");
        ErrorName.setText("");
        ErrorPass.setText("");
        ErrorPhone.setText("");
        ErrorPrtPhone.setText("");
        ErrorUser.setText("");
        txtNameStud.requestFocus();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddStudent;
    private javax.swing.JLabel ErrorAddress;
    private javax.swing.JLabel ErrorDam;
    private javax.swing.JLabel ErrorDob;
    private javax.swing.JLabel ErrorEmail;
    private javax.swing.JLabel ErrorName;
    private javax.swing.JLabel ErrorPass;
    private javax.swing.JLabel ErrorPhone;
    private javax.swing.JLabel ErrorPrtPhone;
    private javax.swing.JLabel ErrorUser;
    private javax.swing.ButtonGroup GioiTinhSinhVien;
    private javax.swing.JTabbedPane QLSinhVien;
    private javax.swing.JButton btnChangeStatus;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnGetAllStudent;
    private javax.swing.JButton btnIns;
    private javax.swing.JButton btnReadReport;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSeachStudent;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpd;
    private javax.swing.JComboBox<LopHoc> cboClass;
    private javax.swing.JComboBox<String> cboFilter;
    private javax.swing.JPanel displayPointStudent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private com.toedter.calendar.JDateChooser jdcDam;
    private com.toedter.calendar.JDateChooser jdcDob;
    private javax.swing.JDialog jdlDisplayReport;
    private javax.swing.JLabel lblIdStud;
    private javax.swing.JLabel lblSrpDate;
    private javax.swing.JLabel lblSrpId;
    private javax.swing.JLabel lblSrpMa;
    private javax.swing.JLabel lblSrpName;
    private javax.swing.JLabel lblSrpTitle;
    private javax.swing.JLabel lblTitleIns;
    private javax.swing.JPanel listStudent;
    private javax.swing.JRadioButton rdoFemale;
    private javax.swing.JRadioButton rdoMale;
    private javax.swing.JPanel report;
    private javax.swing.JTable tblPoint;
    private javax.swing.JTable tblReport;
    private javax.swing.JTable tblStudents;
    private javax.swing.JTextArea txaContent;
    private javax.swing.JTextArea txaNote;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHomePhone;
    private javax.swing.JTextField txtIdStud;
    private javax.swing.JTextField txtNameStud;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSearchStudent;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    private void loadDataDiem() {
        List<KetQua> kqResault = ketquaDAO.getAll();
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã SV");
        model.addColumn("Tên Sinh Viên");
        model.addColumn("Mã Bộ Đề");
        model.addColumn("Ngày Thi");
        model.addColumn("Tổng Điểm");
        
        KetQua kq = new KetQua();
        Vector rows = new Vector();
        for (KetQua item : kqResault) {
            SinhVien sv = stdao.getById(item.getId_sv());
            rows.add(sv.getMa_sv());
            rows.add(sv.getHo_ten());
            BoDe bd = bodeDAO.getById(item.getId_bode());
            rows.add(bd.getNoi_dung());
            rows.add(item.getNgay_thi());
            rows.add(item.getTong_diem());
            model.addRow(rows);
        }
        tblPoint.setModel(model);
    }
}
