# JBabel-API
JBabel est une biblioth�que Java permettant d'ajouter rapidement et facilement un syst�me
multi-langue � un programme. Les diff�rentes langues sont stock�es dans des fichiers .properties
situ�s dans le projet java. Pour ajouter une langue : ajouter un fichier, modifier : modifier le fichier. <br/>
Simple et efficace ce syst�me incorpore �galement un JMenu custom ajoutable � vos GUI, permettant de s�lectionner la langue � utiliser.



## Install
La biblioth�que JBabel se pr�sente sous la forme d'un fichier .jar non ex�cutable.

### Eclipse
S�lectionner le projet => Properties => Java Build Path => Add External JARs... <br/>
Choisir le fichier .jar de JBabel => Ouvrir => Apply and Close

### Maven
A faire

### Graddle
A faire



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
Le terme *programme* repr�sente le fichier .jar ainsi que ses sources, fichiers binaires et ressources rattach�es. <br/>
Ce programme reste la propri�t� intellectuelle du d�veloppeur : [Alba0404](mailto:alba0404@orange.fr). <br/>
Il est autoris� de t�l�charger et ex�cuter ce programme � des fins priv�es ou commerciales du moment que celles-ci sont l�gales. <br/>
Il est interdit de vendre ce programme sous une quelconque forme, modifi� ou non. <br/>
Si le programme est utilis� dans un projet, la citation du d�veloppeur est obligatoire. Ce projet doit respecter les conditions pr�c�dentes.
