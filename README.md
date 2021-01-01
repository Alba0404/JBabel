# JBabel
JBabel est une biblioth�que Java permettant d'ajouter rapidement et facilement un syst�me
multi-langue � un programme. Les diff�rentes langues sont stock�es dans des fichiers .properties
situ�s dans le projet java. Pour ajouter une langue : ajouter un fichier, modifier : modifier le fichier. <br/>
Simple et efficace ce syst�me incorpore �galement un JMenu custom ajoutable � vos GUI, permettant de s�lectionner la langue � utiliser.



## Install
La biblioth�que JBabel se pr�sente sous la forme d'un fichier .jar non ex�cutable. Vous pouvez le t�l�charger dans la partie release de Github. <br/>
JBabel Library is in a no-exe .jar file. You can download it in the release part of Github. <br/>
<br/>
Pour utiliser JBabel dans un projet, il est n�cessaire de cr�er � la racine de celui-ci (m�me niveau que src) un dossier *ressources*. Dans ce dossier cr�er un dossier languages. C'est dans ce dossier que vous doivent se trouver les fichiers *.properties* . <br/>
To use JBabel, you need to create a new folder *ressources* in the same folder as *src*. In this folder add a folder *languages*. Languages files ending with *.properties* have to be there.

### Eclipse
S�lectionner le projet => *Properties* => *Java Build Path* => *Add External JARs...* =>
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
Ce code ajoute le .jar � votre repository local, r�cup�rer la biblioth�que par ce biais. <br/>
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
Le terme *programme* repr�sente le fichier .jar ainsi que ses sources, fichiers binaires et ressources attach�es. <br/>
- Ce programme est distribu� sans aucune garantie.
- Ce programme est la propri�t� intellectuelle de son d�veloppeur : [Alba0404](mailto:alba0404@orange.fr).
- Il est autoris� de t�l�charger et ex�cuter ce programme � des fins commerciales ou non du moment que celles-ci sont l�gales.
- Il est autoris� de faire de la r�tro-ing�ni�rie.
- Il est interdit de vendre ce programme sous une quelconque forme, modifi� ou non.
- **Si le programme est utilis� dans un projet, quelque soit la forme de celui-ci, la citation du d�veloppeur est obligatoire**. De plus ce projet doit respecter les lois en vigueurs.