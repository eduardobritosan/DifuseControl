import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;


public class Simulator {

	private static int timeRunning;
	
	public Simulator() 
	{
		timeRunning = 18000;
	}
	
	public static int getTimeRunning()
	{
		return timeRunning;
	}

	public static void main(String[] args) 
	{
		WaterSystem embalse = new WaterSystem();;
		DifuseControl sistemaLogico = new DifuseControl();
		
		for (int i = 0; i <= 18000 ; i++) 
		{
			embalse.setApertura(sistemaLogico.mathFunction(embalse.getError()));
			embalse.calcWaterLevel();
			System.out.println(i + " " + embalse.getNivelActual());
		}
	}
	static PrintStream openStreamToFile(String  filename){
		try
		{
			return new PrintStream(new FileOutputStream(filename));
		}catch(IOException e){
			System.err.println("Error abriendo el fichero");
			System.exit(-1);
		}
		return null;
	}
}
