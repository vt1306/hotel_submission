package insurance_sample;


import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import Model.Branch;
import util.GenerateOutputFile;
import util.JSONFileParser;
import util.XMLFileParser;


public class MyTimerTask extends TimerTask {

    private final static int ELEVEN = 23;
    private final static int FIFTY_NINE = 59;
    public static List<Branch> success = new ArrayList<Branch>();
	public static List<Branch> failure = new ArrayList<Branch>();
	Logger logger = Logger.getLogger("MyTimerTask");  
    @Override
    public void run() {
        long currennTime = System.currentTimeMillis();
        long stopTime = currennTime + 2000;//provide the 2hrs time it should execute 1000*60*60*2
		while (stopTime != System.currentTimeMillis()) {
			MyTimerTask p = new MyTimerTask();
			try {
				File folder = new File("C:\\Users\\Vikas\\eclipse-workspace\\insurance_sample\\src\\main\\resources");
				File[] listOfFiles = folder.listFiles();

				for (int i = 0; i < listOfFiles.length; i++) {
					if (listOfFiles[i].isFile()) {
						p.readFile(listOfFiles[i].getName());
            		    logger.log(Level.WARNING, listOfFiles[i].getName());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			GenerateOutputFile.writeToFile(success, failure);

		}
    }
    private static Date getTomorrowMorning1159PM(){

        Date date1159pm = new java.util.Date(); 
        date1159pm.setHours(ELEVEN); 
        date1159pm.setMinutes(FIFTY_NINE); 

           return date1159pm;
      }
    //call this method from your servlet init method
    public static void startTask(){
        MyTimerTask task = new MyTimerTask();
        Timer timer = new Timer();  
        timer.schedule(task,getTomorrowMorning1159PM(),1000*10);// for your case u need to give 1000*60*60*24
    }
    public static void main(String args[]){
        startTask();
    }
    public void readFile(String name) throws Exception {
		if (Objects.isNull(name) || name.isEmpty()) {
			return;
		}
		String extension = null;
		int i = name.lastIndexOf('.');
		if (i > 0) {
			extension = name.substring(i + 1);
		}

		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(name).getFile());

		if (!file.exists()) {

		} else {
			if(extension!=null)
			{
				if ("xml".equalsIgnoreCase(extension)) {
					XMLFileParser.readXMLFile(file, success, failure);
				} else if ("json".equalsIgnoreCase(extension)) {
					JSONFileParser.readJSONFile(file, success, failure);
				}
			}
		}
	}


}

