package controller;

import java.sql.SQLException;
import model.Cliente;
import model.ClienteDAO;

public class frmClienteC {

    private ClienteDAO dao;

    public frmClienteC(Cliente cli)  throws SQLException {
        this.dao = new ClienteDAO(cli);
    }

    public String fInsere() throws SQLException {     
        try {
            if (this.dao.inserir()) {
                return "Cliente inserido com sucesso";
            } else {
                return "Erro ao inserir cliente";
            }

        } catch (SQLException e) {
            return "Erro ao cadastrar " + e.getMessage();
        }
    }
    public String fAtualiza() throws SQLException{
        try {
            if (this.dao.atualizar()) {
                return "Cliente atualizado com sucesso!";
            } else {
                return "Erro ao atualizar cliente";
            }
        } catch (SQLException e){
            return "Erro ao atualizar cliente" + e.getMessage();
        }
    }
    
    public String fExclui() throws SQLException{
        if (this.dao.apagar()){
            return "Cliente excluído com sucesso!";
        } else{
            return "Erro ao exlcuir cliente!";
        }
    }    
}