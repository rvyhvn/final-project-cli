package com.project.dao;

import com.project.model.Kelas;
import com.project.model.MataPelajaran;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MataPelajaranDAO {
    private Connection connection;

    public MataPelajaranDAO(Connection connection) {
        this.connection = connection;
    }

    public void saveMataPelajaran(MataPelajaran mataPelajaran) {
        String query = "INSERT INTO mata_pelajaran (id_mapel, nama_mapel) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, mataPelajaran.getIdMapel());
            statement.setString(2, mataPelajaran.getNamaMapel());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<MataPelajaran> getAllMataPelajaran() {
        String query = "SELECT * FROM mata_pelajaran";
        List<MataPelajaran> mataPelajaranList = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                MataPelajaran mataPelajaran = mapResultSetToMataPelajaran(resultSet);
                mataPelajaranList.add(mataPelajaran);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mataPelajaranList;
    }

    private MataPelajaran mapResultSetToMataPelajaran(ResultSet resultSet) throws SQLException {
        int idMapel = resultSet.getInt("id_mapel");
        String namaMapel = resultSet.getString("nama_mapel");

        // Dapatkan daftar Kelas untuk MataPelajaran dengan menggunakan DAO yang sesuai
        KelasDAO kelasDAO = new KelasDAO(connection);
        ArrayList<Kelas> kelasList = kelasDAO.getKelasByMapelId(idMapel);

        return new MataPelajaran(idMapel, namaMapel, kelasList);
    }
}
