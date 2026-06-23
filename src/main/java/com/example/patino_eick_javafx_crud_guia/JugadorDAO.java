package com.example.patino_eick_javafx_crud_guia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JugadorDAO {

    public void insertar(Jugador j) {

        String sql = """
                INSERT INTO jugadores
                (cedula,nombre,apellido,edad,correo,posicion,pierna_habil,equipo,observaciones)
                VALUES (?,?,?,?,?,?,?,?,?)
                """;

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, j.getCedula());
            ps.setString(2, j.getNombre());
            ps.setString(3, j.getApellido());
            ps.setInt(4, j.getEdad());
            ps.setString(5, j.getCorreo());
            ps.setString(6, j.getPosicion());
            ps.setString(7, j.getPiernaHabil());
            ps.setString(8, j.getEquipo());
            ps.setString(9, j.getObservaciones());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Jugador> listar() {

        List<Jugador> lista = new ArrayList<>();

        String sql = "SELECT * FROM jugadores ORDER BY id";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Jugador j = new Jugador(
                        rs.getInt("id"),
                        rs.getString("cedula"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("edad"),
                        rs.getString("correo"),
                        rs.getString("posicion"),
                        rs.getString("pierna_habil"),
                        rs.getString("equipo"),
                        rs.getString("observaciones")
                );

                lista.add(j);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void eliminar(int id) {

        String sql = "DELETE FROM jugadores WHERE id=?";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}