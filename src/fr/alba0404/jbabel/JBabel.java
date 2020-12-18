package fr.alba0404.jbabel;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;
import java.util.Properties;

public class JBabel {
	
	/**
	 * Default language, loaded when fail to load a language.
	 */
	private static String defaultLanguage;
	
	/**
	 * Actual language
	 */
	private static String language;
	
	/**
	 * Name of the log file.
	 */
	private static  final String logFileName = "JBabel.log";
	
	/**
	 * PrintStream of the log file. Used to save Exception and messages.
	 */
	private static PrintStream logFile;
	
	/**
	 * Properties of the language
	 */
	private static Properties properties;
	
	
	/**
	 * Constructor of the API. Save and load the default language.
	 * Load the log file.
	 * 
	 * @param firstLanguage Default language of the system.
	 */
	public static void init(String firstLanguage) {
		properties = new Properties();
		try { logFile = new PrintStream(new File(logFileName)); }
		catch (IOException e) {}
		defaultLanguage = firstLanguage;
		language = firstLanguage;
		loadLangage();
	}
	
	
	/**
	 * Return the String link to the key in the language file loaded.
	 * 
	 * @param key The key of the String you want.
	 * @return The String corresponding in the language file loaded.
	 */
	public static String getString(String key) {
		return properties.getProperty(key);
	}
	
	
	/**
	 * Reload the API with a new language.
	 * 
	 * @param newLanguage The new language.
	 */
	public static void reload(String newLanguage) {
		language = newLanguage;
		loadLangage();
	}
	
	
	/**
	 * Load the file corresponding to the actual language.
	 * If error, load the default language file entered in the init.
	 */
	private static void loadLangage() {
		try {
			// Loading the language file
			properties.load(JBabel.class.getResourceAsStream("languages/" + language + ".properties"));
			info("Language '" + language + "' succesfully load !", false);
		}
		catch (Exception e) {
			// Loading the default language file if error when loading the language
			try { properties.load(JBabel.class.getResourceAsStream("languages/" + defaultLanguage + ".properties")); }
			catch (IOException ex) {}
			info("Failed to load '" + language + "' , loading default language '" + defaultLanguage + "' !", true);
			e.printStackTrace(logFile);
		}
		
	}
	
	
	/**
	 * Display the message in the console as error or information.
	 * And save it in the log file.
	 * 
	 * @param message Message to save and display.
	 * @param error If the message is an error.
	 */
	@SuppressWarnings("deprecation")
	private static void info(String message, boolean error) {
		Date date = new Date();
		message = date.getDate() + "/"
				+ date.getMonth() + "/"
				+ date.getYear() + "-"
				+ date.getHours() + ":"
				+ date.getMinutes() + ":"
				+ date.getSeconds() + " "
				+"[JBabel] " + message;
		logFile.println(message);
		if(error) System.err.println(message);
		else System.out.println(message);
	}

}
