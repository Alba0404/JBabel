# JBabel
JBabel est une bibliothèque Java permettant d'ajouter rapidement et facilement un système
multi-langue à un programme. Les différentes langues sont stockées dans des fichiers .properties
situés dans le projet java. Pour ajouter une langue : ajouter un fichier, modifier : modifier le fichier. <br/>
Simple et efficace ce système incorpore également un JMenu custom ajoutable à vos GUI, permettant de sélectionner la langue à utiliser.



## Install
La bibliothèque JBabel se présente sous la forme d'un fichier .jar non exécutable. Vous pouvez le télécharger dans la partie release de Github. <br/>
JBabel Library is in a no-exe .jar file. You can download it in the release part of Github. <br/>
<br/>
Pour utiliser JBabel dans un projet, il est nécessaire de créer à la racine de celui-ci (même niveau que src) un dossier *ressources*. Dans ce dossier créer un dossier languages. C'est dans ce dossier que vous doivent se trouver les fichiers *.properties* . <br/>
To use JBabel, you need to create a new folder *ressources* in the same folder as *src*. In this folder add a folder *languages*. Languages files ending with *.properties* have to be there.

### Eclipse
Sélectionner le projet => *Properties* => *Java Build Path* => *Add External JARs...* =>
Choisir le fichier .jar de JBabel => *Ouvrir* => *Apply and Close* <br/>
Select your project => *Properties* => *Java Build Path* => *Add External JARs...* =>
Choose JBabel jar file => *Open* => *Apply and Close* <br/>

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
Changez **\<path-to-file>** par le chemin vers le .jar, et **\<version>** par la version de JBabel.
Ce code ajoute le .jar à votre repository local, récupérer la bibliothèque par ce biais. <br/>
Change **\<path-to-file>** with the location of the .jar, and **\<version>** with the version of JBabel.
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

//Core
JBabel.init("Fr.properties");			// Init the system with the default language. The String is the name of the .properties file.
String s = JBabel.getString("message.welcome");	// Return "Bienvenue sur mon Programme !"
JBabel.reload("newLanguage");			// Reload the system with an other language. Default language is used if error loading the new one. The String is the name of the .properties file.

@since 1.1
//Graphic part (need init)
JFrame frame = new JFrame();		// Create a JFrame
JMenuBar bar = new JMenuBar();		// Create a JMenuBar
bar.add(new JLanguageMenu(frame));	// Add the JMenu used to choose the language to the JMenuBar.
frame.setJMenuBar(bar);			// Attach the JMenuBar to the JFrame
```

```
#===============#
# Fr.properties #
#===============#

message.welcome = Bienvenue sur mon Programme !

```


## License
Le terme *programme* représente le fichier .jar ainsi que ses sources, fichiers binaires et ressources attachées. <br/>
- Ce programme est distribué sans aucune garantie.
- Ce programme est la propriété intellectuelle de son développeur : [Alba0404](mailto:alba0404@orange.fr).
- Il est autorisé de télécharger et exécuter ce programme à des fins commerciales ou non du moment que celles-ci sont légales.
- Il est autorisé de faire de la rétro-ingéniérie.
- Il est interdit de vendre ce programme sous une quelconque forme, modifié ou non.
- **Si le programme est utilisé dans un projet, quelque soit la forme de celui-ci, la citation du développeur est obligatoire**. De plus ce projet doit respecter les lois en vigueurs.