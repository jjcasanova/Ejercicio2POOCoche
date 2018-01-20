
public class coche {
	private String matricula;
	private int velocidad;
	
	public void rellenarmatricula(String matricula) {
		this.matricula=matricula;
	}
	public void rellenarvelocidad(int velocidad) {
		this.velocidad=velocidad;
		
	}
	public String devolvermatricula() {
		return matricula;
		
	}
	public int devolvervelocidad() {
		return velocidad;
	}
	public void acelerar(int velocidad) {
		this.velocidad+=velocidad;
		
	}
	public void frenar(int velocidad) {
		this.velocidad-=velocidad;
		
	}
	
}
