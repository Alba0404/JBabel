# JBabel-API
JBabel est une bibliothèque Java permettant d'ajouter rapidement et facilement un système
multi-langue à un programme. Les différentes langues sont stockées dans des fichiers .properties
situés dans le projet java. Pour ajouter une langue : ajouter un fichier, modifier : modifier le fichier. <br/>
Simple et efficace ce système incorpore également un JMenu custom ajoutable à vos GUI, permettant de sélectionner la langue à utiliser.



## Install
La bibliothèque JBabel se présente sous la forme d'un fichier .jar non exécutable.

### Eclipse
Sélectionner le projet => Properties => Java Build Path => Add External JARs... <br/>
Choisir le fichier .jar de JBabel => Ouvrir => Apply and Close

### Maven
```
mvn install:install-file \
   -Dfile=<path-to-file> \
   -DgroupId=fr.alba0404 \
   -DartifactId=jbabel \
   -Dversion=<version> \
   -Dpackaging=jar \
   -DgeneratePom=true
```
You need to change **<path-to-file>** with the location of the .jar, and **<version>** with the version of JBabel. <br/>
This code add the .jar file to your local repository, then use it on your project.

### Gradle
```
dependencies {
    compile files('path-to-jar-file')
}
```



## Usage
```java
import fr.alba0404.jbabel.JBabel;
import fr.alba0404.jbabel.JLanguageMenu

JBabel.init("defaultLanguage");		// Init the system with the default language
String s = JBabel.getString("key");	// Return the String corresponding to the key in the selected file
JBabel.reload("newLanguage");		// Reload the system with an other language. Default language is used if error loading the new one.

//Use of JLanguageMenu
JMenuBar bar = new JMenuBar();
bar.add(new JLanguageMenu(parentJFrame);
```



## Licence / License
Le terme *programme* représente le fichier .jar ainsi que ses sources, fichiers binaires et ressources rattachées. <br/>
- Ce programme reste la propriété intellectuelle du développeur : [Alba0404](mailto:alba0404@orange.fr).
- Il est autorisé de télécharger et exécuter ce programme à des fins privées ou commerciales du moment que celles-ci sont légales.
- Il est interdit de vendre ce programme sous une quelconque forme, modifié ou non.
- Si le programme est utilisé dans un projet, la citation du développeur est obligatoire. Ce projet doit respecter les conditions précédentes.
