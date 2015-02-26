
public class WaterSystem {

	private double nivelDeseado;
	private double nivelActual;
	private double ladoDeposito;
	private double velocidadEntrada;
	private double velocidadSalida;
	private double apertura;
	
	public WaterSystem() 
	{
		nivelDeseado = 20;
		nivelActual = 15;
		ladoDeposito = 10;
		velocidadEntrada = 0.4;
		velocidadSalida = 0.1;
		apertura = 1;
	}
	
	public double getWaterIn()
	{
		return velocidadEntrada * apertura;
	}
	
	public double getWaterOut()
	{
		return velocidadSalida;
	}
	
	public double getError()
	{
		return nivelDeseado - nivelActual;
	}
	
	public void calcWaterLevel()
	{
		nivelActual += (getWaterIn() - getWaterOut()) / (ladoDeposito * ladoDeposito);
	}
	
	public void setApertura(double paramApertura)
	{
		apertura = paramApertura;
	}
	
	public double getNivelActual()
	{
		return nivelActual;
	}
}
