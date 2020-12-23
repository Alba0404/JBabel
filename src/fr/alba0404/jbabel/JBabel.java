package fr.alba0404.jbabel;

import java.io.File;
import java.io.FileReader;
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
	 * Reader for the properties
	 */
	private static FileReader reader;
	
	/**
	 * Properties of the language
	 */
	private static Properties properties;
	
	/**
	 * Path of the folder with languages
	 */
	private final static String languageFolder = "ressources/languages/";
	
	/**
	 * If the system is initialised.
	 */
	private static boolean isInit = false;
	
	
	
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
		isInit = true;
	}
	
	
	/**
	 * Return the String link to the key in the language file loaded.
	 * 
	 * @param key The key of the String you want.
	 * @return The String corresponding in the language file loaded.
	 */
	public static String getString(String key) {
		String s = "";
		if(isInit) s = properties.getProperty(key);
		return s;
	}
	
	
	/**
	 * Reload the API with a new language.
	 * 
	 * @param newLanguage The new language to load.
	 */
	public static void reload(String newLanguage) {
		if(isInit && language != newLanguage) {
			language = newLanguage;
			loadLangage();
		}
	}
	
	
	/**
	 * Load the file corresponding to the actual language.
	 * If error, load the default language file entered in the init.
	 */
	private static void loadLangage() {
		try {
			// Loading the language file
			reader = new FileReader(languageFolder + language + ".properties");
			properties.load(reader);
			info("Language '" + language + "' succesfully load !", false);
		}
		catch (Exception e) {
			// Loading the default language file if error when loading the language
			try {
				reader = new FileReader(languageFolder + defaultLanguage + ".properties");
				properties.load(reader);
			}
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
	
	
	/**
	 * Getter for the languages folder.
	 * 
	 * @return The folder where are languages files.
	 */
	static String getLanguageFolder() {
		return languageFolder;
	}

}
