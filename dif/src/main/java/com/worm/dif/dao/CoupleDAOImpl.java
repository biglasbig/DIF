/**
 * 
 */
package com.worm.dif.dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import com.worm.dif.entity.Couple;
import com.worm.dif.entity.Dif;

/**
 * @author MOATEZ
 *
 */
public class CoupleDAOImpl implements CoupleDAO{

	private DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Override
	public void insert(Couple couple) {
		
		String sql = "INSERT INTO couple " +
				"(key1, key1) VALUES (?, ?)";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, couple.getKey1());
			ps.setString(2, couple.getKey2());
			ps.executeUpdate();
			ps.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	@Override
	public Couple findByKeys(String key1, String key2) {
		
		String sql = "SELECT * FROM couple WHERE key1 = ? AND key2 = ?";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, key1);
			ps.setString(2, key2);
			Couple couple = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Array difs = rs.getArray("difs"); 
				List<Dif> difsList = Arrays.asList((Dif[]) difs.getArray());
				couple = new Couple(
					rs.getString("key1"),
					rs.getString("key2"),
					difsList
				);
			}
			rs.close();
			ps.close();
			return couple;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}
}
