package it.unical.ingsw;

public class ContoCorrente {

	private int saldo;

	public ContoCorrente() {
		this.saldo = 0;
	}

	public void deposita(int deposito) {
		if(deposito > 0){
			this.saldo += deposito;
		}
		else
			throw new IllegalArgumentException("L'importo che vuoi depositare è negativo, NON PUOI FARLO!");
	}
	
	public void preleva(int prelievo){
		if(prelievo <= this.saldo && prelievo >= 0){
			this.saldo -= prelievo;
		}
		else{
			throw new IllegalArgumentException("L'importo che vuoi prelevare è maggiore del tuo saldo.");
		}
	}
	
	public int getSaldo() {
		return saldo;
	}
}
