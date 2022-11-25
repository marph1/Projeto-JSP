package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {           //DAO - Data Access Object

    private Connection con;
    private PreparedStatement cmd;
    private Cliente cli;

    public ClienteDAO(Cliente c) throws SQLException {
        this.cli = c;
        this.con = Conexao.Conectar();
        this.con.setAutoCommit(false);
    }

    public boolean inserir() throws SQLException {
        try {
            String sql = "INSERT INTO cliente (nome, cpf, email) VALUES (?,?,?);";
            this.cmd = this.con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            this.cmd.setString(1, this.cli.getNome());
            this.cmd.setString(2, this.cli.getCpf());
            this.cmd.setString(3, this.cli.getEmail());
            if (cmd.executeUpdate() == 1) {
                this.con.commit();
                return true;
            } else {
                this.con.rollback();
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return false;
        } finally {
            Conexao.Desconectar(con);
        }
    }

    public boolean atualizar() throws SQLException {
        try {
            String sql = "UPDATE cliente SET nome=?, cpf=?, email=? WHERE cod_cliente=?";
            this.cmd = this.con.prepareStatement(sql);
            this.cmd.setString(1, this.cli.getNome());
            this.cmd.setString(2, this.cli.getCpf());
            this.cmd.setString(3, this.cli.getEmail());
            this.cmd.setInt(4, this.cli.getCod_cliente());

            if (cmd.executeUpdate() > 0) {
                this.con.commit();
                return true;
            } else {
                this.con.rollback();
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return false;
        } finally {
            Conexao.Desconectar(con);
        }
    }

    public boolean apagar() {
        try {
            String sql = "DELETE FROM cliente WHERE idcli=?";
            this.cmd = this.con.prepareStatement(sql);
            this.cmd.setInt(1, this.cli.getCod_cliente());

            if (cmd.executeUpdate() == 1) {
                this.con.commit();
                return true;
            } else {
                this.con.rollback();
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return false;
        } finally {
            Conexao.Desconectar(con);
        }
    }

    public List<Cliente> Listar() throws SQLException {
        try{
        String sql = "SELECT IDCLI AS ID, NOME, CPF, EMAIL FROM cliente ORDER BY idcli";

        this.cmd = this.con.prepareStatement(sql);

        ResultSet rs = this.cmd.executeQuery();

        List<Cliente> Lista = new ArrayList<>();

        while (rs.next()) {
            this.cli.setCod_cliente(rs.getInt("CODIGO"));
            this.cli.setNome(rs.getString("NOME"));
            this.cli.setCpf(rs.getString("CPF"));
            this.cli.setEmail(rs.getString("EMAIL"));

            //Lista.add(new Cliente(rs.getInt(), rs.getString(), rs.getInt(), rs.getBoolean()))
            Lista.add(this.cli);
        }
        

        return Lista;

    }catch (SQLException e) {
        System.out.println("ERRO: " + e.getMessage());
        
        return null;
    }finally {
        Conexao.Desconectar(this.con);
    }
    }
}
    