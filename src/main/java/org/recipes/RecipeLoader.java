package org.recipes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.*;

import org.db.DbException;
import org.materials.Resources;
import org.db.DB;

public class RecipeLoader {

    Connection con = DB.getConnection();

    List<String> raw_materials = new ArrayList<>();

    public List<String> recipeLoader(){

        String query = "SELECT name FROM raw_materials";

        try(PreparedStatement stmt = con.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                raw_materials.add(rs.getString("name"));
            }

            return raw_materials;

        }catch(SQLException e){

            throw new DbException(e.getMessage());

        }


    }

    public void addRecipe(String name) {
        String query = "INSERT INTO raw_materials (name) VALUES (?)";

        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public void removeRecipe(String name) {
        String query = "DELETE FROM raw_materials WHERE name = ?";

        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }
}
