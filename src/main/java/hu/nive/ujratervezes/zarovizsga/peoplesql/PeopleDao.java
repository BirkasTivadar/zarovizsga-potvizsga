package hu.nive.ujratervezes.zarovizsga.peoplesql;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleDao {

    private DataSource dataSource;

    public PeopleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String findIpByName(String firstName, String lastName) {
        String result;
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT ip_address FROM people WHERE first_name = ? AND last_name = ?;")
        ) {
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            result = getIpAdress(ps);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            throw new IllegalStateException("Connection failed", sqlException);
        }
        return result;
    }

    private String getIpAdress(PreparedStatement ps) {
        String result = null;
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                result = rs.getString("ip_address");
            }
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot query", sqlException);
        }
        return result;
    }
}
