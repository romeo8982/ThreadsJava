package deafult;
import java.io.File;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main {

	private static ArrayList<Algorithm> getListAlgorithms() throws InstantiationException, IllegalAccessException
	{
		ArrayList<Algorithm> List = new ArrayList<Algorithm>();
		File folder = new File("importClasses/");
        File[] listOfFiles = folder.listFiles();
        
        for (int i = 0; i < listOfFiles.length; i++) 
        {
            if (listOfFiles[i].isFile())
            {
                String[] split = listOfFiles[i].getName().split("\\.");
                if("class".equals(split[1]))
                {
                    try 
                    {
                        Class<?> importedClass = Class.forName(split[0]);
                        Object obj = importedClass.getConstructor().newInstance();
                        List.add((Algorithm)obj);
                    }
                    catch (ClassNotFoundException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) 
                    {
                        //Logger.getLogger(MultiThread.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
		return List;
	}
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		List<Algorithm> algorithmList = getListAlgorithms();
		
	}

}
