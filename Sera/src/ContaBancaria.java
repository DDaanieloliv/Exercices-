

/*
Crie uma classe chamada ContaBancaria 
que represente uma conta bancária simples. 
A classe deve ter atributos como número da conta, 
nome do titular, saldo e métodos para depositar, sacar e exibir o saldo.

Tente criar instâncias dessa classe e realizar algumas 
operações de depósito e saque para testar o funcionamento. 
Considere a validação de saques para garantir que o saldo não fique negativo. 
 */



public class ContaBancaria implements Operacao{
	private int NumConta;
	private String NomeTitular;
	private	float Saldo;
	private boolean Status;
	
	
	public ContaBancaria (int NumConta, String NomeTitular, float Saldo, boolean Status) {
		this.NomeTitular = NomeTitular;
		this.NumConta = NumConta;
		this.Saldo = Saldo;
		this.Status = Status;
	}
	
	public ContaBancaria () {
		
	}
	
	
	
	public	void setStatus(boolean Status) {
		this.Status = Status;
	}
	
	public boolean getStatus() {
		return Status;
	}
	
	
	
	public void setNumeroConta(int NumConta) {
		this.NumConta = NumConta;
	}
	
	public int getNumeroConta() {
		return NumConta;
	}
	
	
	
	public void setNomeTitular(String NomeTitular) {
		this.NomeTitular = NomeTitular;
	}
	
	public String getNomeTitular() {
		return NomeTitular;
	}
	
	
	public void setSaldo(float Saldo) {
		this.Saldo = Saldo;
	}
	
	public float getSaldo() {
		return Saldo;
	}
	

	
	@Override
	public void Saque() {
	
	}
	
	@Override
	public void Deposito() {
		// TODO Auto-generated method stub

	}
		
		public static void main(String[] args) {
		

	}

	
		
	

}