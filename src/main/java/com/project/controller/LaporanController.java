package com.project.controller;

import com.project.model.Laporan;
import com.project.util.ExcelExporter;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class LaporanController {
    private List<Laporan> laporanList;

    public LaporanController(List<Laporan> laporanList) {
        this.laporanList = laporanList;
    }

    public void generateExcelReport(String filePath) {
        // Menggunakan library atau API untuk membuat file Excel
        ExcelExporter excelExporter = new ExcelExporter();

        // Mendapatkan data dari objek Laporan dan mengkonversinya menjadi format yang sesuai
        Object[][] data = convertLaporanToDataArray(laporanList);

        // Menentukan kolom-kolom yang akan ada di file Excel
        String[] columns = { "ID Laporan", "Tanggal", "Kelas", "Siswa", "Guru", "Nilai" };

        // Membuat file Excel dengan menggunakan library atau API yang sesuai
        File excelFile = excelExporter.exportToExcel(columns, data, filePath);

        if (excelFile != null) {
            System.out.println("File Excel berhasil dibuat: " + excelFile.getAbsolutePath());
        } else {
            System.out.println("Gagal membuat file Excel.");
        }
    }

    private Object[][] convertLaporanToDataArray(List<Laporan> laporanList) {
        Object[][] data = new Object[laporanList.size()][6];

        for (int i = 0; i < laporanList.size(); i++) {
            Laporan laporan = laporanList.get(i);

            data[i][0] = laporan.getIdLaporan();
            data[i][1] = laporan.getTanggal();
            data[i][2] = laporan.getKelas().getNamaKelas();
            data[i][3] = laporan.getSiswa().getNama();
            data[i][4] = laporan.getGuru().getNama();
            data[i][5] = laporan.getNilai().getNilai();
        }

        return data;
    }
}
