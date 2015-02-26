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

	public float mathFunction(float error)
	{
		float numerador = 0;
		float denominador = 0;
		float aux,salida;
		for(int i = -25; i <= 100; ++i){
			aux = Math.max(Math.max(Math.min(errorNegativo(error), aperturaCerrar(error)),
						Math.min(errorCero(error), aperturaCerrar(error))),
						Math.min(errorPositivo(error), aperturaAbrir(error)));
			numerador += aux * i;
			denominador += aux;
		}
		salida = numerador / denominador;
		return salida;
	}
	private float errorNegativo (float input)
	{
		float error;

		if (input <= -10 && input >= -15)
			error = 1;
		else if (input <= 0 && input >= -10)
			error = -input / 10;
		else 
			error = 0;
		return error;
	}

	private float errorPositivo (float input)
	{
		float error;
		
		if (input <= 10 && input >= 0)
			error = input/50;
		else if (input <= 15 && input >= 10)
			error = 1;
		else 
			error = 0;
		return error;
	}
	
	private float errorCero (float input)
	{
		float error;
		
		if (input <= 0 && input >= -5)
			error = (5+input)/5;
		else if (input <= 5 && input >= 0)
			error = (5-input)/5;
		else 
			error = 0;
		return error;
	}

	private float aperturaAbrir(float input)
	{
		float apertura;

		if (input <= 50 && input >= 0)
			apertura = input/50;
		else if(input <= 50)
			apertura = 1;
		else
			apertura = 0;
		return apertura;
	}

	private float aperturaCerrar(float input)
	{
		float apertura;

		if (input <= 0 && input >= -25)
			apertura = 25+input/25;
		else if(input <= 25 && input >= 0)
			apertura = 25-input/25;
		else
			apertura = 0;
		return apertura;
	}	
	
}

