/**
 * 
 */

/**
 * @author eebritos
 *
 */
public class DifuseControl 
{
	public DifuseControl()
	{}

	public double mathFunction(double error)
	{
		double numerador = 0;
		double denominador = 0;
		double aux,salida;
		for(int i = -25; i <= 100; ++i){
			aux = Math.max(Math.max(Math.min(errorNegativo(error), aperturaCerrar(i)),
						Math.min(errorCero(error), aperturaCerrar(i))),
						Math.min(errorPositivo(error), aperturaAbrir(i)));
			numerador += aux * i;
			denominador += aux;
		}
		salida = numerador / denominador;
		return (salida);
	}
	private double errorNegativo (double input)
	{
		double error;

		if (input <= -10 && input >= -15)
			error = 1;
		else if (input <= 0 && input >= -10)
			error = -input / 10;
		else 
			error = 0;
		return error;
	}

	private double errorPositivo (double input)
	{
		double error;
		
		if (input <= 10 && input >= 0)
			error = input/10;
		else if (input <= 15 && input >= 10)
			error = 1;
		else 
			error = 0;
		return error;
	}
	
	private double errorCero (double input)
	{
		double error;
		
		if (input <= 0 && input >= -5)
			error = (5+input)/5;
		else if (input <= 5 && input >= 0)
			error = (5-input)/5;
		else 
			error = 0;
		return error;
	}

	private double aperturaAbrir(double input)
	{
		double apertura;

		if (input <= 50 && input >= 0)
			apertura = input/50;
		else if(input >= 50)
			apertura = 1;
		else
			apertura = 0;
		return apertura;
	}

	private double aperturaCerrar(double input)
	{
		double apertura;

		if (input <= 0 && input >= -25)
			apertura = (25+input)/25;
		else if(input <= 25 && input >= 0)
			apertura = (25-input)/25;
		else
			apertura = 0;
		return apertura;
	}	
	
}

