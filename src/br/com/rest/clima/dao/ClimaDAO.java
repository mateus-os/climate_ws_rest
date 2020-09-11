package br.com.rest.clima.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.com.rest.clima.factory.ConnectionFactory;
import br.com.rest.clima.model.ClimaModel;

public class ClimaDAO extends ConnectionFactory {

	private static ClimaDAO instance;

	public static ClimaDAO getInstance() {
		if (instance == null)
			instance = new ClimaDAO();
		return instance;
	}

	public String listAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ClimaModel> climas = new ArrayList<ClimaModel>();

		conn = createConnection();

		String sql = "SELECT * FROM climaws.climas";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ClimaModel clima = new ClimaModel();
				clima.setId_clima(rs.getInt("id_clima"));
				clima.setMunicipio(rs.getString("municipio"));
				clima.setEstado(rs.getString("estado"));
				clima.setTemp_max(rs.getString("temp_max"));
				clima.setTemp_min(rs.getString("temp_min"));
				clima.setSens_term(rs.getString("sens_term"));
				clima.setTemp_atual(rs.getString("temp_atual"));
				clima.setUmidade(rs.getString("umidade"));
				clima.setDate_ins(rs.getString("date_ins"));

				climas.add(clima);
			}
			Gson gson = new Gson();

			return gson.toJson(climas);
		} catch (Exception e) {
			System.out.println("Erro ao listar clientes");
			e.printStackTrace();
			return null;
		} finally {
			closeConnection(conn, pstmt, rs);
		}
	}

	public ClimaModel consultarClima(ClimaModel clima) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = createConnection();

		String sql = "select * from climaws.consultarClima(?, ?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, clima.getMunicipio());
			pstmt.setString(2, clima.getEstado());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				clima = new ClimaModel();
				clima.setId_clima(rs.getInt("id_clima"));
				clima.setMunicipio(rs.getString("municipio"));
				clima.setEstado(rs.getString("estado"));
				clima.setTemp_max(rs.getString("temp_max"));
				clima.setTemp_min(rs.getString("temp_min"));
				clima.setSens_term(rs.getString("sens_term"));
				clima.setTemp_atual(rs.getString("temp_atual"));
				clima.setUmidade(rs.getString("umidade"));
				clima.setDate_ins(rs.getString("date_ins"));
			}
			return clima;
		} catch (Exception e) {
			System.out.println("Erro ao listar climas");
			e.printStackTrace();
			return null;
		} finally {
			closeConnection(conn, pstmt, rs);
		}

	}

	public Response inserirClima(ClimaModel clima) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = createConnection();

		String sql = "SELECT climaws.inserirclima(?,?,?,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, clima.getMunicipio());
			pstmt.setString(2, clima.getEstado());
			pstmt.setString(3, clima.getTemp_max());
			pstmt.setString(4, clima.getTemp_min());
			pstmt.setString(5, clima.getSens_term());
			pstmt.setString(6, clima.getTemp_atual());
			pstmt.setString(7, clima.getUmidade());
			pstmt.executeQuery();
			return Response.status(Response.Status.OK).type(MediaType.TEXT_HTML).build();
		} catch (Exception e) {
			e.printStackTrace();
//			System.out.println(e.toString());
			return Response.status(Response.Status.BAD_REQUEST).build();
		} finally {
			closeConnection(conn, pstmt, rs);
		}
	}

	public Response atualizarClima(ClimaModel clima) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = createConnection();

		String sql = "SELECT climaws.atualizarClima(?,?,?,?,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, clima.getId_clima());
			pstmt.setString(2, clima.getMunicipio());
			pstmt.setString(3, clima.getEstado());
			pstmt.setString(4, clima.getTemp_max());
			pstmt.setString(5, clima.getTemp_min());
			pstmt.setString(6, clima.getSens_term());
			pstmt.setString(7, clima.getTemp_atual());
			pstmt.setString(8, clima.getUmidade());
			pstmt.executeQuery();

			return Response.status(Response.Status.OK).type(MediaType.TEXT_HTML).build();
		} catch (Exception e) {
			System.out.println("Erro ao inserir clima");
			e.printStackTrace();
			return Response.status(Response.Status.NOT_FOUND).build();
		} finally {
			closeConnection(conn, pstmt, rs);
		}
	}

	public Response excluirClima(int id_clima) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = createConnection();

		String sql = "SELECT climaws.excluirClima(?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id_clima);
			pstmt.executeQuery();
			return Response.status(Response.Status.OK).type(MediaType.TEXT_HTML).build();
		} catch (Exception e) {
			System.out.println("Erro ao excluir clima");
			e.printStackTrace();
			return Response.status(Response.Status.NOT_FOUND).build();
		} finally {
			closeConnection(conn, pstmt, rs);
		}
	}
}
