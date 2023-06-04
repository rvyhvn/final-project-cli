package com.project.dao;

import com.project.model.Kelas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KelasDAO {
    private Connection connection;

    public KelasDAO(Connection connection) {
        this.connection = connection;
    }

    public void addKelas(Kelas kelas) {
        try {
            String query = "INSERT INTO kelas (id_kelas, tingkat, urutan, is_ipa) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, kelas.getIdKelas());
            preparedStatement.setString(2, kelas.getTingkat());
            preparedStatement.setInt(3, kelas.getUrutan());
            preparedStatement.setBoolean(4, kelas.getIsIpa());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Kelas> getAllKelas() {
        List<Kelas> kelasList = new ArrayList<>();
        try {
            String query = "SELECT * FROM kelas";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idKelas = resultSet.getInt("id_kelas");
                String tingkat = resultSet.getString("tingkat");
                int urutan = resultSet.getInt("urutan");
                boolean isIpa = resultSet.getBoolean("is_ipa");
                Kelas kelas = new Kelas(idKelas, tingkat, urutan, isIpa, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
                kelasList.add(kelas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kelasList;
    }

    public List<Kelas> getKelasByMapelId(int idMapel){
      String query = "SELECT k.* FROM k JOIN kelas_mapel km ON k.id_kelas = km.id_kelas WHERE km.id_mapel = ?";
      List<Kelas> kelasList = new ArrayList<>();

      try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, idMapel);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
          int idKelas = resultSet.getInt("id_kelas");
          String tingkat = resultSet.getString("tingkat");
          int urutan = resultSet.getInt("urutan");
          boolean isIpa = resultSet.getBoolean("is_ipa");
          Kelas kelas = new Kelas(idKelas, tingkat, urutan, isIpa, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
          kelasList.add(kelas);
        }
      } catch (SQLException e){
        e.printStackTrace();
      }

      return kelasList;
    }

    public Kelas getKelasById(int idKelas) {
        String query = "SELECT * FROM kelas WHERE id_kelas = ?";
        Kelas kelas = null;

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idKelas);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String tingkat = resultSet.getString("tingkat");
                    int urutan = resultSet.getInt("urutan");
                    boolean isIpa = resultSet.getBoolean("is_ipa");
                    kelas = new Kelas(idKelas, tingkat, urutan, isIpa, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return kelas;
    }
}
