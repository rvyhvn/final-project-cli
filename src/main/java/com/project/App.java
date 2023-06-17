package com.project;

import com.project.model.*;
import com.project.controller.SiswaController;
import com.project.util.DatabaseUtil;

import java.sql.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.postgresql.Driver;

public class App {
    public static void main(String[] args) {
        testDatabaseConnection();
    }


