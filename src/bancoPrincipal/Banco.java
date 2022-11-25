package bancoPrincipal;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.Cliente;
import model.ClienteDAO;
import model.Conexao;

public class Banco {
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
	    Connection con = Conexao.Conectar();
	    Conexao.Desconectar(con);
	    
	    //ENCAPSULAMENTO dos dados
		ClienteDAO cliDAO = new ClienteDAO(new Cliente("Pedrin ligeirao", "123123123", "ped@email.com"));
	    cliDAO.inserir();
	    
	    /*List<Cliente> resultado = cliDAO.Listar();
	    
	    for (int i=0; i< resultado.size(); i++) {
	    	Cliente cli = new Cliente();
	        System.out.println("Código: " + resultado.get(i).getCod_cliente());
	        System.out.println("Nome: " + resultado.get(i).getNome());
	        System.out.println("CPF: " + resultado.get(i).getCpf());
	        System.out.println("Email: " + resultado.get(i).getEmail());
	        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
	    
	    }*/
	    
	}
    
}
