import com.project.model.MapelKelas;
import com.project.model.MataPelajaran;
import com.project.model.Kelas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MapelKelasDAO {
    private Connection connection;

    public MapelKelasDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(MapelKelas mapelKelas) throws SQLException {
        String query = "INSERT INTO mapel_kelas (id_mapel_kelas, mapel_id, kelas_id) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, mapelKelas.getIdMapelKelas());
            statement.setInt(2, mapelKelas.getMapel().getIdMapel());
            statement.setInt(3, mapelKelas.getKelas().getIdKelas());
            statement.executeUpdate();
        }
    }

    public List<MapelKelas> getByKelasId(int kelasId) throws SQLException {
        List<MapelKelas> mapelKelasList = new ArrayList<>();
        String query = "SELECT id_mapel_kelas, mapel_id, kelas_id FROM mapel_kelas WHERE kelas_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, kelasId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int idMapelKelas = resultSet.getInt("id_mapel_kelas");
                    int mapelId = resultSet.getInt("mapel_id");
                    MataPelajaran mapel = getMataPelajaranById(mapelId);
                    Kelas kelas = getKelasById(kelasId);
                    MapelKelas mapelKelas = new MapelKelas(idMapelKelas, mapel, kelas);
                    mapelKelasList.add(mapelKelas);
                }
            }
        }
        return mapelKelasList;
    }

    public List<MapelKelas> getByMapelId(int mapelId) throws SQLException {
        List<MapelKelas> mapelKelasList = new ArrayList<>();
        String query = "SELECT id_mapel_kelas, mapel_id, kelas_id FROM mapel_kelas WHERE mapel_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, mapelId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int idMapelKelas = resultSet.getInt("id_mapel_kelas");
                    int kelasId = resultSet.getInt("kelas_id");
                    MataPelajaran mapel = getMataPelajaranById(mapelId);
                    Kelas kelas = getKelasById(kelasId);
                    MapelKelas mapelKelas = new MapelKelas(idMapelKelas, mapel, kelas);
                    mapelKelasList.add(mapelKelas);
                }
            }
        }
        return mapelKelasList;
    }

    public void delete(MapelKelas mapelKelas) throws SQLException {
        String query = "DELETE FROM mapel_kelas WHERE id_mapel_kelas = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, mapelKelas.getIdMapelKelas());
            statement.executeUpdate();
        }
    }

    private MataPelajaran getMataPelajaranById(int mapelId) throws SQLException {
        // Implementasi metode untuk mendapatkan objek MataPelajaran berdasarkan mapelId
        // Anda dapat menggunakan koneksi database untuk melakukan query atau mengakses data dari sumber lain
        // Contoh implementasi:
        // String query = "SELECT mapel_id, mapel_name FROM mata_pelajaran WHERE mapel_id = ?";
        // try (PreparedStatement statement = connection.prepareStatement(query)) {
        //     statement.setInt(1, mapelId);
        //     try (ResultSet resultSet = statement.executeQuery()) {
        //         if (resultSet.next()) {
        //             String mapelName = resultSet.getString("mapel_name");
        //             return new MataPelajaran(mapelId, mapelName);
        //         }
        //     }
        // }
        // return null;
        return null;
    }

    private Kelas getKelasById(int kelasId) throws SQLException {
        // Implementasi metode untuk mendapatkan objek Kelas berdasarkan kelasId
        // Anda dapat menggunakan koneksi database untuk melakukan query atau mengakses data dari sumber lain
        // Contoh implementasi:
        // String query = "SELECT kelas_id, kelas_name FROM kelas WHERE kelas_id = ?";
        // try (PreparedStatement statement = connection.prepareStatement(query)) {
        //     statement.setInt(1, kelasId);
        //     try (ResultSet resultSet = statement.executeQuery()) {
        //         if (resultSet.next()) {
        //             String kelasName = resultSet.getString("kelas_name");
        //             return new Kelas(kelasId, kelasName);
        //         }
        //     }
        // }
        // return null;
        return null;
    }
}
