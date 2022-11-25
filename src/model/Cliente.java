package model;

public class Cliente {
	 private int cod_cliente;
	    private String nome;
	    private String cpf;
	    private String email;

	    public Cliente() {
	    }

	    
	    
		public Cliente(String nome, String cpf, String email) {
			super();
			this.nome = nome;
			this.cpf = cpf;
			this.email = email;
		}



		public int getCod_cliente() {
			return cod_cliente;
		}

		public void setCod_cliente(int cod_cliente) {
			this.cod_cliente = cod_cliente;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}


}
