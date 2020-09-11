package br.com.rest.clima.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.google.gson.Gson;

import br.com.rest.clima.factory.ConnectionFactory;
import br.com.rest.clima.model.MunicipiosModel;

public class MunicipiosDAO extends ConnectionFactory {

	private static MunicipiosDAO instance;

	public static MunicipiosDAO getInstance() {
		if (instance == null)
			instance = new MunicipiosDAO();
		return instance;
	}

	public String listMunicipios() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MunicipiosModel> municipios = new ArrayList<MunicipiosModel>();

		conn = createConnection();

		String sql = "SELECT * FROM climaws.municipios";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MunicipiosModel mun = new MunicipiosModel();
				mun.setId_municipio(rs.getInt("id_municipio"));
				mun.setMunicipio(rs.getString("municipio"));
				mun.setEstado(rs.getString("estado"));

				municipios.add(mun);
			}
			Gson gson = new Gson();

			return gson.toJson(municipios);
		} catch (Exception e) {
			System.out.println("Erro ao listar municipios");
			e.printStackTrace();
			return null;
		} finally {
			closeConnection(conn, pstmt, rs);
		}
	}
}
