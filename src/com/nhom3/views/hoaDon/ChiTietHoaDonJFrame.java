/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.views.hoaDon;

import com.nhom3.controller.ExportFileExcel;
import com.nhom3.entity.ChiTietHoaDon;
import com.nhom3.entity.HoaDon;
import com.nhom3.service.ChiTietHoaDonService;
import com.nhom3.service.HoaDonService;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.TableRowAlign;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

/**
 *
 * @author Hoang Viet
 */
public class ChiTietHoaDonJFrame extends javax.swing.JFrame {

    /**
     * Creates new form ChiTietHoaDonJFrame
     */
    DefaultTableModel defaultTableModel;
    int thuTuMuonTra;
    ArrayList<HoaDon> hoaDons;
    ArrayList<ChiTietHoaDon> chiTietHoaDons;
    JLabel label;
    HoaDon hoaDon;
    //NhanVien currentNhanVien;
    HoaDonService hoaDonService;
    ChiTietHoaDonService chiTietHoaDonService;
    //NhanVienServices nhanVienServices;
    //ArrayList<DocGia> docGias;
    FileNameExtensionFilter fileNameExtensionFilter;
    ExportFileExcel exportFileExcel;
    int currentMaHoaDon;

    public ChiTietHoaDonJFrame(int maHoaDon) {
        initComponents();
        setLocationRelativeTo(null);
        currentMaHoaDon = maHoaDon;
        //add column for table
        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        chiTietHoaDonTable.setModel(defaultTableModel);
        defaultTableModel.addColumn("Mã hóa đơn");
        defaultTableModel.addColumn("Mã sách");
        defaultTableModel.addColumn("Số lượng");
        defaultTableModel.addColumn("Lãi suất");
        chiTietHoaDonService = new ChiTietHoaDonService();
        setData(chiTietHoaDonService.getAllChiTietHoaDon(maHoaDon));
    }

    private void setData(ArrayList<ChiTietHoaDon> chiTietHoaDons) {
        for (ChiTietHoaDon chiTietHoaDon : chiTietHoaDons) {
            defaultTableModel.addRow(new Object[]{chiTietHoaDon.getMaHoaDon(), chiTietHoaDon.getMaSach(),
                chiTietHoaDon.getSoLuong(), chiTietHoaDon.getLaiSuat()});
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

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        chiTietHoaDonTable = new javax.swing.JTable();
        timKiemTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        exportFileButton = new javax.swing.JButton();
        fileNameTextField = new javax.swing.JTextField();
        typeSearchJCombobox = new javax.swing.JComboBox<>();
        timKiemComboBox = new javax.swing.JComboBox<>();
        exportFileButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        updateButton = new javax.swing.JButton();
        refeshButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        chiTietHoaDonTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        chiTietHoaDonTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã sách", "Tên sách", "Thể loại", "Tác giả", "Số lượng"
            }
        ));
        chiTietHoaDonTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(chiTietHoaDonTable);

        timKiemTextField.setText("Nhập từ khóa tìm kiếm.");
        timKiemTextField.setToolTipText("");

        searchButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        searchButton.setText("Tìm Kiếm");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        exportFileButton.setBackground(new java.awt.Color(51, 0, 153));
        exportFileButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        exportFileButton.setForeground(new java.awt.Color(255, 255, 255));
        exportFileButton.setText("Xuất File");
        exportFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportFileButtonActionPerformed(evt);
            }
        });

        fileNameTextField.setText("Tên File");

        typeSearchJCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        timKiemComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã sách", "Số lượng", "Lãi suất" }));

        exportFileButton1.setBackground(new java.awt.Color(51, 0, 153));
        exportFileButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        exportFileButton1.setForeground(new java.awt.Color(255, 255, 255));
        exportFileButton1.setText("Thêm File");
        exportFileButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportFileButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(exportFileButton1)
                        .addGap(18, 18, 18)
                        .addComponent(fileNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(exportFileButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(timKiemComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(timKiemTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(typeSearchJCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(timKiemTextField)
                        .addComponent(timKiemComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(exportFileButton, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fileNameTextField)
                        .addComponent(exportFileButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(typeSearchJCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        updateButton.setBackground(new java.awt.Color(0, 153, 0));
        updateButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setText("Cập Nhật");
        updateButton.setBorderPainted(false);
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        refeshButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        refeshButton.setText("Refesh");
        refeshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refeshButtonActionPerformed(evt);
            }
        });

        addButton.setBackground(new java.awt.Color(0, 153, 0));
        addButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Thêm");
        addButton.setBorderPainted(false);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(153, 0, 0));
        deleteButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("Xóa");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(refeshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deleteButton)
                .addGap(18, 18, 18)
                .addComponent(updateButton)
                .addGap(18, 18, 18)
                .addComponent(addButton)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refeshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        chiTietHoaDonService = new ChiTietHoaDonService();
        switch (String.valueOf(timKiemComboBox.getSelectedItem())) {
            case "Mã sách":
                chiTietHoaDons = chiTietHoaDonService.searchChiTietHoaDon(currentMaHoaDon, "MaSach", String.valueOf(timKiemTextField.getText()));
                if (chiTietHoaDons.size() == 0) {
                    label = new JLabel("Không tìm thấy kết quả");
                    label.setFont(new Font("Tahoma", Font.PLAIN, 18));
                    JOptionPane.showMessageDialog(ChiTietHoaDonJFrame.this, label, "Error", JOptionPane.ERROR_MESSAGE);
                    defaultTableModel.setRowCount(0);
                } else {
                    defaultTableModel.setRowCount(0);
                    setData(chiTietHoaDons);
                }
                break;
            case "Số lượng":
                chiTietHoaDons = chiTietHoaDonService.searchChiTietHoaDon(currentMaHoaDon, "SoLuong", String.valueOf(timKiemTextField.getText()));
                if (chiTietHoaDons.size() == 0) {
                    label = new JLabel("Không tìm thấy kết quả");
                    label.setFont(new Font("Tahoma", Font.PLAIN, 18));
                    JOptionPane.showMessageDialog(ChiTietHoaDonJFrame.this, label, "Error", JOptionPane.ERROR_MESSAGE);
                    defaultTableModel.setRowCount(0);
                } else {
                    defaultTableModel.setRowCount(0);
                    setData(chiTietHoaDons);
                }
                break;
            case "Lãi suất":
                chiTietHoaDons = chiTietHoaDonService.searchChiTietHoaDon(currentMaHoaDon, "LaiSuat", String.valueOf(timKiemTextField.getText()));
                if (chiTietHoaDons.size() == 0) {
                    label = new JLabel("Không tìm thấy kết quả");
                    label.setFont(new Font("Tahoma", Font.PLAIN, 18));
                    JOptionPane.showMessageDialog(ChiTietHoaDonJFrame.this, label, "Error", JOptionPane.ERROR_MESSAGE);
                    defaultTableModel.setRowCount(0);
                } else {
                    defaultTableModel.setRowCount(0);
                    setData(chiTietHoaDons);
                }
                break;
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void exportFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportFileButtonActionPerformed
        StringBuffer path = new StringBuffer();
        path.append("D://");
        path.append(fileNameTextField.getText());
        path.append(".doc");
        String path2 = path.toString();

        try {
            ExportFileWord(chiTietHoaDonTable, path2);
            JOptionPane.showMessageDialog(null, "Lưu file thành công!");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lưu file không thành công!");
        }
    }//GEN-LAST:event_exportFileButtonActionPerformed

    private void exportFileButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportFileButton1ActionPerformed
        // TODO add your handling code here:
        JFileChooser jFileChooser = new JFileChooser();
        fileNameExtensionFilter = new FileNameExtensionFilter("excel", "xls");//chỉ chọn file xls(excel)
        jFileChooser.setFileFilter(fileNameExtensionFilter);//lọc file xls
        jFileChooser.setMultiSelectionEnabled(false);
        int x = jFileChooser.showDialog(this, "Chọn file");//hiển thị bảng chọn file
        if (x == JFileChooser.APPROVE_OPTION) {
            try {
                File file = jFileChooser.getSelectedFile();
                Workbook workBook = Workbook.getWorkbook(file);
                Sheet s = workBook.getSheet(0);
                int row = s.getRows();
                int col = s.getColumns();
                ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
                for (int i = 1; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        Cell c = s.getCell(j, i);
                        switch (j) {
                            case 0:
                                chiTietHoaDon.setMaHoaDon(Integer.parseInt(c.getContents()));
                                break;
                            case 1:
                                chiTietHoaDon.setMaSach(Integer.parseInt(c.getContents()));
                                break;
                            case 2:
                                chiTietHoaDon.setSoLuong(Integer.parseInt(c.getContents()));
                                break;
                            case 3:
                                chiTietHoaDon.setLaiSuat(Float.parseFloat(c.getContents()));
                                break;
                        }
                    }
                    //add one record into database
                    chiTietHoaDonService.addChiTietHoaDon(chiTietHoaDon);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (BiffException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_exportFileButton1ActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        int row = chiTietHoaDonTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn chi tiết hóa đơn trước!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
            chiTietHoaDon.setMaHoaDon(Integer.valueOf(String.valueOf(chiTietHoaDonTable.getValueAt(row, 0))));
            chiTietHoaDon.setMaSach(Integer.valueOf(String.valueOf(chiTietHoaDonTable.getValueAt(row, 1))));
            chiTietHoaDon.setSoLuong(Integer.valueOf(String.valueOf(chiTietHoaDonTable.getValueAt(row, 2))));
            chiTietHoaDon.setLaiSuat(Float.parseFloat(String.valueOf(chiTietHoaDonTable.getValueAt(row, 3))));
            new UpdateChiTietHoaDonJFrame(chiTietHoaDon).setVisible(true);
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void refeshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refeshButtonActionPerformed
        defaultTableModel.setRowCount(0);
        chiTietHoaDonService = new ChiTietHoaDonService();
        setData(chiTietHoaDonService.getAllChiTietHoaDon(currentMaHoaDon));
    }//GEN-LAST:event_refeshButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        int maHoaDon = Integer.parseInt(String.valueOf(chiTietHoaDonTable.getValueAt(0, 0)));
        new AddChiTietHoaDonJFrame(maHoaDon).setVisible(true);
    }//GEN-LAST:event_addButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int row = chiTietHoaDonTable.getSelectedRow();
        chiTietHoaDonService = new ChiTietHoaDonService();
        int confirm = JOptionPane.showConfirmDialog(ChiTietHoaDonJFrame.this, "Bạn có chắc chắn muốn xóa không?");
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                int maHoaDon = Integer.valueOf(String.valueOf(chiTietHoaDonTable.getValueAt(row, 0)));
                int maSach = Integer.valueOf(String.valueOf(chiTietHoaDonTable.getValueAt(row, 1)));
                chiTietHoaDonService.deleteChiTietHoaDon(maHoaDon, maSach);
                JOptionPane.showMessageDialog(null, "Đã xóa!");
                defaultTableModel.setRowCount(0);
                setData(chiTietHoaDonService.getAllChiTietHoaDon(maHoaDon));
            } catch (SQLException ex) {
                Logger.getLogger(hoaDonJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    public void ExportFileWord(JTable table, String fileName) {
        try {

            //Bước 1: Khởi tạo đối tượng để sinh ra file word
            XWPFDocument document = new XWPFDocument();

            //Bước 2: Tạo tiêu đề bài viết
            XWPFParagraph titleGraph = document.createParagraph();

            //titleGraph.setAlignment(ParagraphAlignment.CENTER);
            String quocHieu = "THƯ VIỆN TẠ QUANG BỬU      		          CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM";

            XWPFRun titleRun = titleGraph.createRun();

            titleRun.setBold(true);

            titleRun.setText(quocHieu);
            titleRun.setFontSize(12);
            titleRun.setFontFamily("Times New Roman");

            XWPFParagraph paragraph1 = document.createParagraph();
            XWPFRun run = paragraph1.createRun();
            run.setText("              NHÓM 3				     Độc lập - Tự do – Hạnh phúc");
            run.setFontSize(12);
            run.setBold(true);
            run.setFontFamily("Times New Roman");

            XWPFParagraph ngayThang = document.createParagraph();
            XWPFRun run2 = ngayThang.createRun();
            ngayThang.setAlignment(ParagraphAlignment.RIGHT);
            run2.setText("Ngày 16 tháng 5 năm 2019       ");
            run2.setFontSize(12);
            run2.setItalic(true);
            run2.setFontFamily("Times New Roman");

            XWPFParagraph khoangTrang = document.createParagraph();
            XWPFRun run3 = ngayThang.createRun();
            run3.setText("");

            XWPFParagraph tenBieuMau = document.createParagraph();
            XWPFRun run4 = tenBieuMau.createRun();
            tenBieuMau.setAlignment(ParagraphAlignment.CENTER);
            run4.setText("\n\nTHÔNG TIN CHI TIẾT HÓA ĐƠN  \n\n");
            run4.setFontSize(12);
            run4.setFontFamily("Times New Roman");
            run4.setBold(true);

            XWPFParagraph khoangTrang2 = document.createParagraph();
            XWPFRun run5 = ngayThang.createRun();
            run5.setText("");

            XWPFTable createTable = document.createTable();
            createTable.setTableAlignment(TableRowAlign.CENTER);
            createTable.getCellMarginLeft();
            //create first row
            XWPFTableRow tableRowOne = createTable.getRow(0);
            tableRowOne.getCell(0).setText(" STT ");
            tableRowOne.addNewTableCell().setText(" Mã hóa đơn ");
            tableRowOne.addNewTableCell().setText(" Mã sách ");
            tableRowOne.addNewTableCell().setText(" Số lượng ");
            tableRowOne.addNewTableCell().setText(" Lãi suất ");

            TableModel model = table.getModel();

            int stt = 1;
            for (int rows = 0; rows < model.getRowCount(); rows++) { //For each table row
                XWPFTableRow tableRowTwo = createTable.createRow();
                tableRowTwo.getCell(0).setText(" " + String.valueOf(stt));
                for (int cols = 0; cols < model.getColumnCount(); cols++) { //For each table column
                    tableRowTwo.getCell(cols + 1).setText(" " + model.getValueAt(rows, cols).toString());
                }
                stt++;
            }

            XWPFParagraph khoangTrang3 = document.createParagraph();
            XWPFRun run6 = khoangTrang3.createRun();
            run6.setText("");

            XWPFParagraph chuKy = document.createParagraph();
            XWPFRun run7 = chuKy.createRun();
            run7.setText("Người lập \n														                                Xác nhận của thủ thư");
            run7.setFontSize(12);
            run7.setFontFamily("Times New Roman");
            run7.setBold(true);
            chuKy.setAlignment(ParagraphAlignment.CENTER);

            //Ghi dữ liệu ra file word
            FileOutputStream out = new FileOutputStream(fileName);

            document.write(out);

            out.close();

            document.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

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
            java.util.logging.Logger.getLogger(ChiTietHoaDonJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiTietHoaDonJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiTietHoaDonJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiTietHoaDonJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTable chiTietHoaDonTable;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton exportFileButton;
    private javax.swing.JButton exportFileButton1;
    private javax.swing.JTextField fileNameTextField;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refeshButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JComboBox<String> timKiemComboBox;
    private javax.swing.JTextField timKiemTextField;
    private javax.swing.JComboBox<String> typeSearchJCombobox;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
