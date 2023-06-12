package com.project.controller;

import com.project.model.MapelKelas;
import com.project.util.DatabaseUtil;
import com.project.dao.MapelKelasDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MapelKelasController {

    private MapelKelasDAO mapelKelasDAO;

    public MapelKelasController() {
        try {
            Connection connection = DatabaseUtil.getConnection();
            mapelKelasDAO = new MapelKelasDAO(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createMapelKelas(MapelKelas mapelKelas) {
        try {
            mapelKelasDAO.create(mapelKelas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<MapelKelas> getMapelKelasByKelasId(int kelasId) {
        try {
            return mapelKelasDAO.getMapelKelasByKelasId(kelasId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteMapelKelas(MapelKelas mapelKelas) {
        try {
            mapelKelasDAO.delete(mapelKelas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
