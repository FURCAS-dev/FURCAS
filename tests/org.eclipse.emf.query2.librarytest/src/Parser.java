import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Test;

import library.Book;
import library.Format;
import library.Library;
import library.LibraryFactory;
import library.Manuscript;
import library.Person;
import library.Publisher;

public class Parser {

	@Test
	public void parse() throws Exception {
		ResourceSet rs = new ResourceSetImpl();
		Map<String, Person> authors = new HashMap<String, Person>();
		Map<String, Resource> resources = new HashMap<String, Resource>();

		Publisher dpunkt = createManuscriptsAndAuthors(rs, authors, resources);
		createPersons(rs, authors, resources);
		createLibraries(rs, new ArrayList<Person>(authors.values()), resources, dpunkt.getManuscripts());

		for (Resource r : rs.getResources()) {
			r.save(null);
		}

	}

	private void createPersons(ResourceSet rs, Map<String, Person> authors, Map<String, Resource> resources) {

		for (int i = 0; i < personLastNames.length; i++) {
			String lastName = personLastNames[i];
			Resource resourceForPerson = getResourceForPerson(rs, resources, lastName.substring(0, 1));
			Person person = LibraryFactory.eINSTANCE.createPerson();
			person.setName(lastName);
			resourceForPerson.getContents().add(person);
			authors.put(lastName, person);

		}

	}

	private void createLibraries(ResourceSet rs, List<Person> persons, Map<String, Resource> resources, List<Manuscript> manuscripts) {

		for (int i = 0; i < cities.length; i++) {
			String city = cities[i];
			String pathName = "org.eclipse.emf.query2.librarytest/data/library/" + city + ".xmi";
			Resource r = getResource(rs, pathName);
			Library lib = LibraryFactory.eINSTANCE.createLibrary();
			lib.setLocation(city);
			r.getContents().add(lib);
			Random generator = new Random();

			int totalNumberOfBooks = generator.nextInt(100) * 10;
			while (totalNumberOfBooks-- > 0) {
				int nextBook = generator.nextInt(manuscripts.size());
				Manuscript manuscript = manuscripts.get(nextBook);
				Book book = LibraryFactory.eINSTANCE.createBook();
				book.setInstanceOf(manuscript);
				if (generator.nextInt() % 3 == 0) {
					book.setBorrowedBy(persons.get(generator.nextInt(persons.size())));
				}

				lib.getBooks().add(book);
			}

		}

	}

	private Resource getResource(ResourceSet rs, String pathName) {
		pathName=pathName.replaceAll("�", "oe");
		pathName=pathName.replaceAll("�", "Oe");
		pathName=pathName.replaceAll("�", "ue");
		pathName=pathName.replaceAll("�", "Ue");
		pathName=pathName.replaceAll("�", "ae");
		pathName=pathName.replaceAll("�", "Ae");
		pathName=pathName.replaceAll(",", "-");
		pathName=pathName.replaceAll(" ", "");
		pathName=pathName.replaceAll("�", "a");
		pathName=pathName.replaceAll("�", "o");
		pathName=pathName.replaceAll("�", "e");
		pathName=pathName.replaceAll("'", "");
		Resource r = rs.createResource(URI.createPlatformResourceURI(
				pathName, true));
		return r;
	}

	private Publisher createManuscriptsAndAuthors(ResourceSet rs, Map<String, Person> authors, Map<String, Resource> resources)
			throws FileNotFoundException, IOException {
		LineNumberReader lnr = new LineNumberReader(new FileReader("katalog.TAB"));
		String line = null;

		Publisher dpunkt = LibraryFactory.eINSTANCE.createPublisher();
		dpunkt.setName("DPunkt");

		while ((line = lnr.readLine()) != null) {
			Manuscript currentBook = LibraryFactory.eINSTANCE.createManuscript();
			dpunkt.getManuscripts().add(currentBook);
			StringTokenizer st = new StringTokenizer(line, "\t");
			while (st.hasMoreElements()) {
				String s = (String) st.nextElement();
				int indexOf = s.indexOf(':');
				if (indexOf < 10)
					continue;
				String key = s.substring(10, indexOf);
				if (key.equalsIgnoreCase("TITEL")) {
					currentBook.setTitle(s.substring(indexOf + 1).trim());
				}
				if (key.equalsIgnoreCase("SEITENZAHL")) {
					try {
						Integer pages = Integer.valueOf(s.substring(indexOf + 1).trim());
						currentBook.setPages(pages);
					} catch (Exception e) {
						// ignore
					}
				}
				if (key.equalsIgnoreCase("EINBAND")) {
					currentBook.setFormat(s.substring(indexOf + 1).trim().equals("HC") ? Format.HARDCOVER : Format.SOFTCOVER);
				}
				if (key.equalsIgnoreCase("AUTOR")) {
					String trim = s.substring(indexOf + 1).trim();
					StringTokenizer authorSt = new StringTokenizer(trim, "/");
					while (authorSt.hasMoreTokens()) {
						String author = (String) authorSt.nextToken().trim();
						Person p;
						if ((p = authors.get(author)) == null) {
							p = LibraryFactory.eINSTANCE.createPerson();
							p.setName(author);
							authors.put(author, p);
							Resource r;
							String firstChar = author.substring(0, 1);
							r = getResourceForPerson(rs, resources, firstChar);
							r.getContents().add(p);
						}
						currentBook.getAuthor().add(p);
					}
				}
			}

		}
		lnr.close();

		String pathName = "org.eclipse.emf.query2.librarytest/data/publisher/dpunkt.xmi";
		Resource dpunktRes = getResource(rs, pathName);
		dpunktRes.getContents().add(dpunkt);
		return dpunkt;
	}

	private Resource getResourceForPerson(ResourceSet rs, Map<String, Resource> resources, String firstChar) {
		Resource r;
		String c = firstChar.toUpperCase();
		if ((r = resources.get(c)) == null) {
			String pathName = "org.eclipse.emf.query2.librarytest/data/person/" + c + ".xmi";
			r = getResource(rs, pathName);
			resources.put(c, r);
		}
		return r;
	}

	String[] cities = { "Mumbai (Bombay)", "Karatschi", "Istanbul", "Delhi", "Seoul", "Sao Paulo", "Moskau", "Shanghai", "Lagos",
			"Mexiko-Stadt", "Jakarta", "Tokio", "New York", "Kinshasa", "Kairo", "Teheran", "Peking", "London", "Hongkong", "Lima",
			"Bogot�", "Lahore", "Dhaka", "Bangkok", "Rio de Janeiro", "Bagdad", "Bengaluru (Bangalore)", "Ho-Chi-Minh-Stadt (Saigon)",
			"Santiago de Chile", "Kolkata (Kalkutta)", "Rangun", "Ankara", "Chennai (Madras)", "Wuhan", "Riad",
			"Sankt Petersburg (Leningrad)", "Chongqing", "Chengdu", "Xi'an", "Los Angeles", "Ahmedabad", "Alexandria", "Sydney", "Tianjin",
			"Abidjan", "Busan", "Hyderabad", "Kano", "Singapur", "Yokohama", "Ibadan", "Shenyang", "Berlin", "Melbourne", "Durban",
			"Harbin", "Johannesburg", "Madrid", "Surat", "Pune", "Guangzhou", "Nanjing", "Kanpur", "Omdurman", "Casablanca", "Jaipur",
			"Pj�ngjang", "Chicago", "Addis Abeba", "Dschidda", "Luanda", "Nairobi", "Buenos Aires", "Taiyuan", "Salvador da Bahia",
			"Daressalam", "Kiew", "Osaka", "Taipeh", "Lakhnau", "Faisalabad", "Incheon", "Daegu", "Izmir", "Rom", "Changchun", "Toronto",
			"Quezon City", "Gizeh", "Kabul", "Sana'a", "Kapstadt", "Belo Horizonte", "Surabaya", "Nagpur", "Fortaleza", "Maschhad", "Cali",
			"Santo Domingo", "Nagoya", "Houston", "Havanna", "Paris", "Guayaquil", "Chittagong", "Khartum", "Changsha", "Jinan", "Mosul",
			"Dalian", "Basra", "Zhengzhou", "Dakar", "Shijiazhuang", "Taschkent", "Indore", "Accra", "Medell�n", "Maracaibo", "Yaound�",
			"Douala", "Jilin", "Sapporo", "Hangzhou", "Bukarest", "Nanchang", "Caracas", "Ecatepec de Morelos", "Rawalpindi", "Hamburg",
			"Medan", "Minsk", "Patna", "Curitiba", "Warschau", "Budapest", "Soweto", "Wien", "Bhopal", "Brisbane", "Bandung", "Tsingtao",
			"Guadalajara", "al-Chartum Bahri", "Aleppo", "Ludhiana", "Rabat", "Montreal", "Bekasi", "Pretoria", "Barcelona", "Thane",
			"Manaus", "Tangshan", "Kaduna", "Damaskus", "Manila", "Phoenix", "Isfahan", "Harare", "Kobe", "Agra", "Algier", "Quito",
			"Kaohsiung", "�r�mqi", "Recife", "Daejeon", "Kyoto", "Multan", "Kumasi", "Philadelphia", "Charkiw", "Vadodara", "Bursa",
			"Kuala Lumpur", "Pimpri-Chinchwad", "Karadsch", "Caloocan", "Tangerang", "Hanoi", "T�bris", "Gujranwala", "Nowosibirsk",
			"Lanzhou", "Hyderabad", "Gwangju", "Faridabad", "Bel�m", "Ciudad Ju�rez", "Fushun", "Fukuoka", "Conakry", "Puebla",
			"Antananarivo", "Luoyang", "Hefei", "Valencia", "Makassar", "Tijuana", "Lubumbashi", "Porto Alegre", "Santa Cruz de la Sierra",
			"M�nchen", "Handan", "Kampala", "Suzhou", "Shantou", "Barranquilla", "San Antonio", "Davao City", "Kawasaki", "C�rdoba",
			"Depok", "Phnom Penh", "La Matanza", "Mailand", "Bamako", "Mekka", "Nashik", "Jekaterinburg (Swerdlowsk)", "Semarang",
			"Nischni Nowgorod (Gorki)", "Baotou", "Adana", "Montevideo", "Lusaka", "San Diego", "Kalyan-Dombivli", "Palembang", "Peshawar",
			"Beirut", "Schiraz", "Suwon", "Dallas", "Port-au-Prince", "Perth", "Nezahualc�yotl", "Mogadischu", "Merath", "Amman",
			"Mandalay", "Almaty", "Anshan", "Xuzhou", "Ghaziabad", "Goyang", "Baku", "Maputo", "Prag", "Fuzhou", "Rajkot", "Saitama",
			"Guiyang", "Goiania", "Guarulhos", "Varanasi", "Sofia", "Hiroshima", "Tripolis", "Port Harcourt", "Managua", "Brazzaville",
			"Dubai", "Samara (Kujbyschew)", "Omsk", "Benin-Stadt", "Monterrey", "Le�n", "Belgrad", "Maiduguri", "Wuxi", "Kasan",
			"Gaziantep", "Eriwan", "Amritsar", "Rostow am Don", "Allahabad", "Visakhapatnam", "Tscheljabinsk", "Datong", "Tiflis",
			"Xianyang", "Ufa", "Dnipropetrowsk", "Seongnam", "Campinas", "Ouagadougou", "Jabalpur", "Ulan Bator", "Haora", "Huainan",
			"Sendai", "Kunming", "Taichung", "Adelaide", "Aurangabad", "Qom", "Wolgograd (Stalingrad)", "Odessa", "Shenzhen", "Rongcheng",
			"Birmingham", "Neapel" };

	String[] personLastNames = { "M�ller", "Schmidt", "Schneider", "Fischer", "Weber", "Meyer", "Wagner", "Becker", "Schulz", "Hoffmann",
			"Sch�fer", "Bauer", "Koch", "Richter", "Klein", "Wolf", "Schr�der", "Neumann", "Schwarz", "Braun", "Hofmann", "Zimmermann",
			"Schmitt", "Hartmann", "Kr�ger", "Schmid", "Werner", "Lange", "Schmitz", "Meier", "Krause", "Maier", "Lehmann", "Huber",
			"Mayer", "Herrmann", "K�hler", "Walter", "K�nig", "Schulze", "Fuchs", "Kaiser", "Lang", "Wei�", "Peters", "Scholz", "Jung",
			"M�ller", "Hahn", "Keller", "Vogel", "Schubert", "Roth", "Frank", "Friedrich", "Beck", "G�nther", "Berger", "Winkler",
			"Lorenz", "Baumann", "Schuster", "Kraus", "B�hm", "Simon", "Franke", "Albrecht", "Winter", "Ludwig", "Martin", "Kr�mer",
			"Schumacher", "Vogt", "J�ger", "Stein", "Otto", "Gro�", "Sommer", "Haas", "Graf", "Heinrich", "Seidel", "Schreiber", "Ziegler",
			"Brandt", "Kuhn", "Schulte", "Dietrich", "K�hn", "Engel", "Pohl", "Horn", "Sauer", "Arnold", "Thomas", "Bergmann", "Busch",
			"Pfeiffer", "Voigt", "G�tz", "Seifert", "Lindner", "Ernst", "H�bner", "Kramer", "Franz", "Beyer", "Wolff", "Peter", "Jansen",
			"Kern", "Barth", "Wenzel", "Hermann", "Ott", "Paul", "Riedel", "Wilhelm", "Hansen", "Nagel", "Grimm", "Lenz", "Ritter", "Bock",
			"Langer", "Kaufmann", "Mohr", "F�rster", "Zimmer", "Haase", "Lutz", "Kruse", "Jahn", "Schumann", "Fiedler", "Thiel", "Hoppe",
			"Kraft", "Michel", "Marx", "Fritz", "Arndt", "Eckert", "Sch�tz", "Walther", "Petersen", "Berg", "Schindler", "Kunz", "Reuter",
			"Sander", "Schilling", "Reinhardt", "Frey", "Ebert", "B�ttcher", "Thiele", "Gruber", "Schramm", "Hein", "Bayer", "Fr�hlich",
			"Vo�", "Herzog", "Hesse", "Maurer", "Rudolph", "Nowak", "Geiger", "Beckmann", "Kunze", "Seitz", "Stephan", "B�ttner", "Bender",
			"G�rtner", "Bachmann", "Behrens", "Scherer", "Adam", "Stahl", "Steiner", "Kurz", "Dietz", "Brunner", "Witt", "Moser", "Fink",
			"Ullrich", "Kirchner", "L�ffler", "Heinz", "Schultz", "Ulrich", "Reichert", "Schwab", "Breuer", "Gerlach", "Brinkmann",
			"G�bel", "Blum", "Brand", "Naumann", "Stark", "Wirth", "Schenk", "Binder", "K�rner", "Schl�ter", "Rieger", "Urban", "B�hme",
			"Jakob", "Schr�ter", "Krebs", "Wegner", "Heller", "Kopp", "Link", "Wittmann", "Unger", "Reimann", "Ackermann", "Hirsch",
			"Schiller", "D�ring", "May", "Bruns", "Wendt", "Wolter", "Menzel", "Pfeifer", "Sturm", "Buchholz", "Rose", "Mei�ner",
			"Janssen", "Bach", "Engelhardt", "Bischoff", "Bartsch", "John", "Kohl", "Kolb", "M�nch", "Vetter", "Hildebrandt", "Renner",
			"Weiss", "Kiefer", "Rau", "Hinz", "Wilke", "Gebhardt", "Siebert", "Baier", "K�ster", "Rohde", "Will", "Fricke", "Freitag",
			"Nickel", "Reich", "Funk", "Linke", "Keil", "Hennig", "Witte", "Stoll", "Schreiner", "Held", "Noack", "Br�ckner", "Decker",
			"Neubauer", "Westphal", "Heinze", "Baum", "Sch�n", "Wimmer", "Marquardt", "Stadler", "Schlegel", "Kremer", "Ahrens", "Hammer",
			"R�der", "Pieper", "Kirsch", "Fuhrmann", "Henning", "Krug", "Popp", "Conrad", "Karl", "Krieger", "Mann", "Wiedemann", "Lemke",
			"Erdmann", "Mertens", "He�", "Esser", "Hanke", "Strau�", "Miller", "Berndt", "Konrad", "Jacob", "Philipp", "Metzger", "Henke",
			"Wiese", "Hauser", "Dittrich", "Albert", "Klose", "Bader", "Herbst", "Henkel", "Kr�ger", "Wahl", "Bartels", "Harms", "Fritsch",
			"Adler", "Gro�mann", "Burger", "Schrader", "Probst", "Martens", "Baur", "Burkhardt", "Hess", "Mayr", "Nolte", "Heine",
			"Kuhlmann", "Klaus", "K�hne", "Kluge", "Bernhardt", "Blank", "Hamann", "Steffen", "Brenner", "Rauch", "Reiter", "Preu�",
			"Jost", "Wild", "Hummel", "Beier", "Krau�", "Lindemann", "Herold", "Christ", "Niemann", "Funke", "Haupt", "Jan�en", "Vollmer",
			"Straub", "Strobel", "Wiegand", "Merz", "Haag", "Holz", "Knoll", "Zander", "Rausch", "Bode", "Beer", "Betz", "Anders",
			"Wetzel", "Hartung", "Glaser", "Fleischer", "Rupp", "Reichel", "Lohmann", "Diehl", "Jordan", "Eder", "Rothe", "Weis",
			"Heinemann", "D�rr", "Metz", "Kroll", "Freund", "Wegener", "Hohmann", "Gei�ler", "Sch�ler", "Schade", "Raab", "Feldmann",
			"Zeller", "Neubert", "Rapp", "Kessler", "Heck", "Meister", "Stock", "R�mer", "Seiler", "Altmann", "Behrendt", "Jacobs", "Mai",
			"B�r", "Wunderlich", "Sch�tte", "Lauer", "Benz", "Weise", "V�lker", "Sonntag", "B�hler", "Gerber", "Kellner", "Bittner",
			"Schweizer", "Ke�ler", "Hagen", "Wieland", "Born", "Merkel", "Falk", "Busse", "Gross", "Eichhorn", "Greiner", "Moritz",
			"Forster", "Stumpf", "Seidl", "Scharf", "Hentschel", "Buck", "Voss", "Hartwig", "Heil", "Eberhardt", "Oswald", "Lechner",
			"Block", "Heim", "Steffens", "Weigel", "Pietsch", "Brandl", "Schott", "Gottschalk", "Bertram", "Ehlers", "Fleischmann",
			"Albers", "Weidner", "Hiller", "Seeger", "Geyer", "J�rgens", "Baumgartner", "Mack", "Schuler", "Appel", "Pape", "Dorn", "Wulf",
			"Opitz", "Wiesner", "Hecht", "Moll", "Gabriel", "Auer", "Engelmann", "Singer", "Neuhaus", "Giese", "Sch�tze", "Geisler", "Ruf",
			"Heuer", "Noll", "Scheffler", "Sauter", "Reimer", "Klemm", "Schaller", "Hempel", "Kretschmer", "Runge", "Springer", "Riedl",
			"Steinbach", "Michels", "Barthel", "Pfaff", "Kohler", "Zahn", "Radtke", "Neugebauer", "Hensel", "Winkelmann", "Gebauer",
			"Engels", "Wichmann", "Eichler", "Schnell", "Weller", "Br�ggemann", "Scholl", "Timm", "Siegel", "Heise", "R�sch", "B�rger",
			"Hinrichs", "Stolz", "Walz", "Specht", "Dick", "Geier", "Volk", "Junker", "Prinz", "Otte", "Schick", "Klotz", "Haller",
			"Rother", "Koller", "B�rner", "Thoma", "Drescher", "Kempf", "Schirmer", "Faber", "Frenzel", "Uhlig", "Schnabel", "Wirtz",
			"D�rr", "Kranz", "Kasper", "Hausmann", "Hagemann", "Gerhardt", "Lux", "Fries", "Haug", "Endres", "Maas", "Sch�rmann", "Eberle",
			"Knapp", "Eggert", "Brauer", "Finke", "Paulus", "Petzold", "Hauck", "Rath", "Elsner", "Dreyer", "Sievers", "Faust", "Dittmann",
			"Wehner", "Kilian", "Sattler", "Reichelt", "Langner", "Rabe", "Bremer", "Abel", "P�tz", "Wittig", "K�hl", "Schober", "Maa�",
			"Cordes", "Uhl", "Kahl", "Korn", "Harder", "Bernhard", "Ullmann", "Thieme", "Klinger", "Bohn", "Biermann", "Vogl", "Sch�tt",
			"Schaefer", "Kemper", "Knorr", "Michaelis", "Gro�e", "Gerdes", "St�hr", "Hartl", "Lehner", "Mielke", "Eggers", "Schaaf",
			"Sieber", "Melzer", "Behr", "Weiler", "Lippert", "Eckhardt", "H�fer", "Fritzsche", "Helbig", "Theis", "Schlosser", "Leonhardt",
			"Ries", "Reinhold", "Rademacher", "Evers", "Rudolf", "Rost", "Horstmann", "Hecker", "Dreher", "Pilz", "Junge", "Ehrhardt",
			"Matthes", "Klug", "Kunkel", "Steinmetz", "Heitmann", "Bahr", "Augustin", "H�hne", "Hering", "Hellmann", "Hildebrand",
			"Trautmann", "Amann", "Heinrichs", "H�hn", "Heimann", "L�ck", "Nitsche", "Sprenger", "Vogler", "Claus", "Jensen", "Blume",
			"Drews", "Damm", "Hofer", "Kurth", "Groth", "Janke", "Heilmann", "Hellwig", "Just", "Wacker", "Huth", "Jahnke", "Strauch",
			"Stenzel", "B�hmer", "Hertel", "Hornung", "G�tze", "Reinhard", "Ruppert", "Lau", "Renz", "Sperling", "Teichmann", "Sch�nfeld",
			"Sp�th", "Hafner", "Alt", "Borchert", "Rehm", "Pohlmann", "Pfister", "Zink", "Roos", "Mader", "Wille", "Schroeder", "Heinen",
			"Lotz", "Balzer", "Schwarze", "Westermann", "Ebner", "Krieg", "Schweiger", "Bosch", "Engler", "Schleicher", "Pfeffer",
			"Gehrke", "Kaminski", "Schuh", "Clemens", "Liedtke", "Wessel", "Friedrichs", "Eisele", "Kirchhoff", "Rei�", "Brockmann",
			"Sch�ne", "Frick", "Ulbrich", "Trapp", "R��ler", "Hoyer", "Thomsen", "Scheer", "Wagener", "Starke", "Korte", "Baumeister",
			"Kretzschmar", "Veit", "Grote", "Sachs", "Nitschke", "Bartel", "Schwarzer", "Hampel", "Bischof", "Schweitzer", "Seemann",
			"Grau", "Lehnert", "Orth", "S��", "Loos", "Stiller", "Henze", "Lohse", "K�ster", "Baumg�rtner", "Oppermann", "Brendel",
			"Kirschner", "Sch�ller", "Wendel", "Burmeister", "Kastner", "Daniel", "Menke", "Seibert", "Widmann", "David", "Reitz",
			"K�hnel", "Diekmann", "Steinert", "Klatt", "W�rner", "Wolters", "F�rst", "Lampe", "Heckmann", "Wilde", "Buchner", "Becher",
			"Heider", "Grundmann", "Schwabe", "Hager", "Buschmann", "Keck", "M�hlbauer", "Schauer", "Petri", "R�hl", "Eckstein", "Schatz",
			"Kolbe", "Kling", "Knobloch", "Otten", "Muth", "Reinke", "Baumgart", "Horst", "Doll", "Kugler", "Gl�ser", "Stange", "Tietz",
			"Schell", "Br�ning", "Helm", "Hacker", "Cremer", "Riemer", "Behnke", "Heyer", "Reiser", "Steinke", "Ostermann", "B�chner",
			"H�usler", "Jacobi", "Heuser", "Obermeier", "Herr", "K�bler", "Spies", "Spindler", "Schmidtke", "Hermes", "Kreuzer", "Kock",
			"Stamm", "Pauli", "Ewald", "Hagedorn", "Kersten", "Weiland", "Resch", "Neu", "Pabst", "Kleine", "Gr�n", "Janzen", "Berthold",
			"Apel", "L�hr", "Jakobs", "Friedl", "Ehlert", "Bastian", "Volz", "Fritsche", "Cramer", "Weinert", "Frisch", "Grund", "Wilms",
			"Scheller", "Enders", "Mahler", "Brandes", "Hamm", "Wieczorek", "Burghardt", "Schwartz", "Thies", "Br�ck", "Stern", "Lukas",
			"Rode", "Hanisch", "Lauterbach", "Gehrmann", "Yilmaz", "Adams", "Henn", "Merten", "Gottwald", "Petry", "Gehring", "Hack",
			"Niemeyer", "Backhaus", "Rupprecht", "Heidrich", "Heidenreich", "Mende", "Volkmann", "Hille", "Herz", "B�ttger", "Knauer",
			"K�rber", "Baumgarten", "Bucher", "Schaub", "Michael", "Eckardt", "Lerch", "Jonas", "Rahn", "Budde", "R�sler", "Hannemann",
			"Seidler", "Schiffer", "Sachse", "Ochs", "Brehm", "Hillebrand", "Hardt", "Zeidler", "W�st", "K�pper", "Ebeling", "H�lscher",
			"Gr�newald", "Kowalski", "Thiemann", "Reis", "Welsch", "Schultze", "Sailer", "Haack", "Ortmann", "Meurer", "Ebel", "Seibel",
			"Kellermann", "K�hn", "Tiedemann", "Kunert", "Br�uer", "Schaper", "Ehrlich", "Reif", "Aigner", "Wulff", "Berner", "Bormann",
			"Schr�er", "Armbruster", "Eilers", "Raabe", "Fichtner", "Thelen", "Bolz", "Pahl", "Mangold", "Scheel", "Kratz", "Hoch",
			"Backes", "Schuhmacher", "Reinecke", "Z�ller", "Johannsen", "Dieckmann", "Drechsler", "Emmerich", "Rauscher", "Post",
			"Weigand", "Hill", "Andres", "W�chter", "Stratmann", "Wallner", "Spengler", "Metzner", "Merk", "Palm", "Hopf", "Dietze",
			"Kammerer", "Krohn", "Kleinert", "Linder", "Henrich", "Morgenstern", "Rogge", "Grube", "Grabowski", "Wurm", "Kummer", "Hoff",
			"Paulsen", "Ertl", "Zorn", "Petermann", "K�ppers", "Buchmann", "Dreier", "Sommerfeld", "B�hr", "Rosenberger", "Reichardt",
			"Reimers", "M�rz", "Heger", "Lenk", "Jaeger", "Hopp", "Habermann", "Boldt", "Schreier", "Ewert", "Pusch", "Boos", "Finger",
			"Christmann", "Weiser", "Wendler", "Maul", "Holzer", "Franzen", "Wachter", "Lorenzen", "Siegert", "Hollmann", "Ahlers",
			"Exner", "Grunwald", "Daum", "Struck", "Sch�nberger", "Waldmann", "Kie�ling", "B�scher", "Rein", "Hock", "Holzapfel",
			"K�stner", "Rasch", "L�dtke", "Homann", "Steiger", "Gr�f", "St�cker", "Strobl", "Metzler", "Fleck", "Fey", "H�rmann", "Lehr",
			"Arlt", "R�ckert", "Rohr", "Friese", "Fechner", "Eck", "Tillmann", "Englert", "Klee", "Steger", "B�cker", "Fiebig", "L�w",
			"Hermanns", "Zech", "Borchers", "Weinmann", "Rieck", "Markert", "L�cke", "Butz", "Friedel", "Aust", "M�bius", "H�rtel",
			"Clausen", "Deutsch", "Wessels", "Zeitler", "Heidemann", "R�hrig", "Siegmund", "Oertel", "R�diger", "Marschall", "Sch�ffer",
			"Henschel", "Hunger", "Sell", "Pfeil", "Goebel", "Edelmann", "Gerhard", "Rosenthal", "Rosenkranz", "Hain", "Z�llner", "K�nzel",
			"Kleinschmidt", "F�rber", "Schacht", "Schwenk", "R�sner", "B�ck", "T�pfer", "Gr�ner", "Spiegel", "Weigl", "Georgi", "Bruhn",
			"Hubert", "Holzmann", "Drexler", "Steinmann", "Groh", "Schmieder", "Kober", "Huhn", "Hinze", "Gebhard", "Zapf", "Lederer",
			"Birk", "Landgraf", "Raschke", "Leitner", "Sch��ler", "Kuhl", "Bosse", "Laux", "Rauh", "Christiansen", "Trost", "Reinert",
			"Klink", "Schuhmann", "Fabian", "Rieder", "Fromm", "Holst", "Bauch", "J�ckel", "Gutmann", "Freese", "Weigelt", "Buhl",
			"Steinberg", "Poppe", "Stier", "Jakobi", "Seibold", "Reiner", "Wortmann", "Luft", "Fa�bender", "Wilken", "Schmelzer",
			"Sch�nherr", "Maus", "Hofmeister", "Heide", "Wilkens", "Wolfram", "Stelzer", "Quast", "Bothe", "Lachmann", "Schnitzler",
			"Gr�ger", "M�cke", "Liebig", "Kreutz", "Nitsch", "Gl�ck", "H�fner", "Kohn", "Wegmann", "Olbrich", "V�lkel", "Scheibe",
			"Herbert", "Erhardt", "Sasse", "Giesen", "Jeske", "L�bke", "Reck", "Kleemann", "Frei", "Ro�", "Stricker", "Marks", "Kamp",
			"Denk", "Obst", "Gl�ckner", "Winkel", "Rink", "Reese", "Baron", "Prei�", "Riemann", "Gebert", "Kayser", "H�lsmann", "S�nger",
			"Meinhardt", "Loch", "Storch", "Egger", "Degen", "Dittmar", "Diener", "Salzmann", "Stolle", "Zabel", "Goldmann", "Schuller",
			"H�ppner", "Uhlmann", "Biedermann", "Stegemann", "Manz", "Weidemann", "Mattern", "Hamacher", "Kropp", "Sch�nfelder", "P�tzold",
			"Dahmen", "Welter", "Pelz", "Pelzer", "Schmalz", "Donath", "Eichner", "Niedermeier", "Scheuermann", "Dengler", "Stork", "Hirt",
			"Lamprecht", "Bartl", "Ley", "Timmermann", "Strasser", "Kleiner", "Lohr", "Knecht", "Mundt", "Klassen", "Stegmann", "Pohle",
			"Kiel", "Rommel", "M�nster", "Bornemann", "Andresen", "Tiemann", "Stangl", "Knop", "Carl", "Merkle", "Gall", "Schild", "Hans",
			"Bieber", "Jankowski", "Rust", "Neumeier", "Beckers", "Greve", "Engelke", "R�ger", "Zielke", "Streit", "Lammers", "Anton",
			"Abraham", "Gries", "Kempe", "Franken", "Br�utigam", "Nissen", "Janz", "Reiche", "Linden", "Ring", "Luther", "Stengel",
			"Gabler", "Karg", "Weinhold", "Radke", "Liebl", "Ecker", "Kopf", "Danner", "Weimer", "Holl", "Welz", "Schl�sser", "Weil",
			"Jeschke", "Bretschneider", "Siewert", "Bartz", "Willmann", "Strecker", "Wrobel", "Jacobsen", "Wieser", "Dombrowski",
			"Carstens", "Schreck", "R�cker", "H�ring", "Mager", "A�mann", "Warnecke", "Benner", "Wenz", "Deppe", "Bollmann", "Gerken",
			"Bott", "Hei�", "Meissner", "Eberl", "Spie�", "Matthies", "Keim", "Hauke", "Erb", "Tischer", "Kreis", "Grothe", "Ulbricht",
			"Senger", "Brandenburg", "Friesen", "Matz", "Vogelsang", "Hofbauer", "Manthey", "Arens", "Christoph", "Schult", "Knopp",
			"Dre�ler", "Brill", "Kuhnert", "Bergner", "Maiwald", "Braune", "Hoffmeister", "Aschenbrenner", "Borchardt", "Gast", "Schwan",
			"Teichert", "Sack", "M�ckel", "Brune", "Wende", "Gerke", "Kress", "Kahle", "Gruner", "Spitzer", "Dietl", "Rott", "Oster",
			"Gerstner", "Erler", "Lucas", "Heymann", "Bu�", "Steuer", "Hirschmann", "Geis", "Dunkel", "Tr�ger", "Pauly", "Kreutzer", "Ha�",
			"Hauschild", "Hillmann", "Pfau", "Strack", "Eberhard", "Preis", "Kaya", "Willms", "Tietze", "Guth", "Buchwald", "Willems",
			"R�hl", "Fu�", "Hartig", "W�nsch", "Huck", "Reschke", "Reith", "Jentsch", "Speck", "H�u�ler", "Rotter", "Schuldt", "Martini",
			"Kretschmann", "Geppert", "L�sch", "Bloch", "Koslowski", "Georg", "Sahin", "Geist", "Pagel", "Rosenberg", "Frings", "Semmler",
			"Hilger", "G�nter", "Dahm", "Drees", "Hauptmann", "Leopold", "Wunder", "Kre�", "Lipp", "Best", "Wendland", "Landwehr",
			"Melcher", "Gr�fe", "B�uerle", "Laube", "Hauer", "Kaul", "Hackl", "Mahr", "Ludewig", "Feil", "Engelbrecht", "Eich", "Grunert",
			"Veith", "Bruder", "Nitzsche", "Knopf", "Schlichting", "Salomon", "Bork", "Hilbert", "Arendt", "Dirks", "Blanke", "Droste",
			"Strunk", "Traub", "Theobald", "Eger", "Krauss", "List", "J�kel", "Zobel", "Carstensen", "Stocker", "Schiemann", "Neufeld",
			"Czech", "Brauner", "Wick", "Peschel", "Rettig", "L�we", "Suhr", "Grewe", "Holler", "Scheid", "Ruhland", "Reindl", "Ritz",
			"Grebe", "Koop", "Esch", "Meixner", "Brock", "Schall", "Rottmann", "Reusch", "Donner", "Fischbach", "Kehl", "Diedrich",
			"B�hler", "Ramm", "Theisen", "Sandner", "Pfl�ger", "Buch", "Hof", "Scherf", "Henne", "Feller", "R�del", "Munz", "H�nsel",
			"Sandmann", "Schwaiger", "Herzig", "Ross", "Sch�nemann", "Dahl", "Zeh", "K�hner", "Kasten", "B�cker", "Rickert", "D�rfler",
			"Euler", "Neumaier", "Menz", "Jobst", "Rie�", "Kersting", "Thamm", "Knappe", "Gericke", "Wanner", "Kupfer", "Teuber", "G�rtz",
			"Wunsch", "Thiede", "Kirsten", "Schiele", "Bolte", "Kleber", "Gerhards", "Molitor", "Heid", "H�gele", "Kiesel", "Heckel",
			"Rusch", "Behrend", "Mattes", "Demir", "Abele", "R�ttger", "Johann", "Hug", "Baldauf", "Schoch", "Heigl", "Bl�mel", "Dr�ger",
			"Paschke", "Peschke", "Jungmann", "Hell", "Glas", "Staudt", "Ulmer", "Wiedmann", "Schroth", "Reu�", "Flohr", "Dorsch", "Werth",
			"Reichenbach", "Zenker", "Wohlgemuth", "Simons", "Celik", "Steinhauer", "Eickhoff", "Kratzer", "Hasse", "Wiemann", "Walker",
			"Drewes", "Helms", "Nowack", "Montag", "D�rner", "Pesch", "Weimann", "T�rk", "Titze", "Stroh", "H�rner", "Brecht", "Althoff",
			"Barz", "Steinhoff", "Jessen", "Scholze", "Gr�nwald", "Kaden", "Faller", "W�nsche", "Reuther", "H�nig", "Mair", "J�rg",
			"M�hring", "Haak", "Mehl", "Grohmann", "Gerth", "W�lfel", "Dammann", "Schupp", "Schad", "Markus", "Hilgers", "Blaschke",
			"Rosenbaum", "Borgmann", "Leicht", "Eichinger", "L�ders", "Frese", "Wrede", "Linde", "H�pfner", "Kube", "Nestler", "Joos",
			"Penner", "Lieb", "Schaal", "Drechsel", "Kessel", "Seiffert", "Bellmann", "Stolze", "Ruff", "Weinberger", "Schuck", "Rummel",
			"Seel", "Sonnenberg", "H�ttner", "Schmidbauer", "Neff", "Klement", "Wittke", "Schmiedel", "Liebscher", "Bogner", "Erhard",
			"Burkert", "Boll", "Stehle", "Krings", "Baumbach", "Sch�ning", "Kohlmann", "Schwarzkopf", "Schaffer", "Mehnert", "Kreft",
			"Schreiter", "Junghans", "Hilpert", "Althaus", "Messerschmidt", "Marten", "Haake", "Rech", "B�se", "Panzer", "Schlicht",
			"H�fler", "K�ppen", "Eberlein", "Schillinger", "Falke", "Klos", "Belz", "Michalski", "Borowski", "Pott", "Loose", "Mauer",
			"Kurtz", "Taubert", "Heindl", "Mock", "Krull", "Hammerschmidt", "Hahne", "Bickel", "Rautenberg", "Koll", "H�hnel", "G�pfert",
			"K�chler", "St�ckl", "Goller", "Korb", "S�llner", "Hornig", "Dressel", "Wuttke", "Schiefer", "Heinzelmann", "Rank", "Staab",
			"Wiebe", "Holtz", "Richert", "Frerichs", "Flemming", "Hepp", "Both", "Degenhardt", "Lippmann", "Utz", "Kittel", "Eckl",
			"Yildirim", "Schmied", "K�pke", "Gei�", "Dohmen", "Zielinski", "Kautz", "Burmester", "Bluhm", "Krone", "Thiem", "Kindler",
			"Potthoff", "Mueller", "Bell", "Aydin", "Straube", "Klar", "Riegel", "Reichmann", "Kluth", "Dittmer", "Welzel", "K�mmel",
			"Holland", "B�cker", "Imhof", "Lewandowski", "Beckert", "Schreyer", "Ehret", "Ruppel", "Kaczmarek", "Wiegmann", "Feige",
			"Tr�ger", "Buss", "Brugger", "Assmann", "Olschewski", "Meinert", "Gundlach", "Zacharias", "Stra�er", "Risse", "Pauls", "Heins",
			"Stelter", "Speer", "Bier", "Teske", "Knebel", "Hufnagel", "Mewes", "Windisch", "Warnke", "Frost", "Volkmer", "Schwind",
			"Reisinger", "Debus", "Bopp", "Schill", "Bley", "Mischke", "B�hnke", "Meinecke", "Flach", "G�nzel", "Klier", "Bausch",
			"Teufel", "Br�hl", "Schulthei�", "Oehler", "Hallmann", "Stich", "Meisel", "Krumm", "H�nel", "Rathmann", "Leistner", "Domke",
			"Sigl", "Wenk", "Weigert", "Laue", "Schlecht", "Reiners", "Krenz", "Baer", "Kirstein", "Bu�mann", "Ganz", "R�ssler", "Dietzel",
			"Karsten", "Sch�fers", "B�ckmann", "P�hlmann", "Kampmann", "Yildiz", "Borrmann", "K�hler", "Kettner", "Kollmann", "Platz",
			"Feist", "Weyer", "Oldenburg", "Niehaus", "K�lbl", "Weinzierl", "Gutsche", "Dressler", "Zuber", "Buhr", "Garbe", "Swoboda",
			"Moos", "Kr�ner", "Holzner", "Abt", "Reichl", "Nielsen", "Schanz", "Pollmann", "Hipp", "Schimmel", "Thielen", "Schultheis",
			"Nebel", "Steininger", "J�rgensen", "Zinke", "Behringer", "Wald", "Matzke", "Stiegler", "Schmuck", "Dobler", "B�rkle",
			"Rasche", "Eller", "Bade", "Stenger", "Knuth", "Seufert", "Jehle", "Sa�", "Roller", "Taube", "Linnemann", "Neuner", "Neuber",
			"Mathes", "Fetzer", "R�hr", "Knauf", "Holstein", "Haufe", "Fleckenstein", "Risch", "Philippi", "Merker", "Kerber", "Weitzel",
			"Scheuer", "Klenk", "Keppler", "�zdemir", "Ostermeier", "Tesch", "Steck", "Knoop", "Kircher", "Ehmann", "Knoblauch", "�zt�rk",
			"R�hle", "Koopmann", "Leuschner", "Laufer", "Schorn", "Friebe", "Mark", "Knabe", "Leber", "Lauber", "St�rmer", "Putz",
			"N�gele", "Meiners", "Weidlich", "P�schel", "Beermann", "Sippel", "Schalk", "Reger", "Heumann", "Stang", "Z�hlke", "Milde",
			"Kindermann", "Weing�rtner", "Harnisch", "Groll", "Waibel", "Grosch", "Priebe", "Wellmann", "Marek", "Freier", "Schie�l",
			"Kelm", "Hetzel", "Langen", "Kusch", "Hild", "Grosser", "Fehr", "Ge�ner", "Bruch", "Bohne", "Duda", "Tewes", "Stockmann",
			"Roscher", "Sievert", "Deckert", "Bethke", "Kirch", "Kraemer", "G�rtler", "Sperber", "Valentin", "R�ter", "Lippold", "Beil",
			"Schorr", "Kind", "Ziemann", "Wiechmann", "Schuchardt", "Kuntz", "Burkart", "Holtmann", "Welker", "Leipold", "Kistner",
			"Kaspar", "Griese", "Schimpf", "Schier", "Lenzen", "Polster", "Wichert", "Klumpp", "Hintze", "Staiger", "Gabel", "Balke",
			"Severin", "Kipp", "Dogan", "Hintz", "Goldbach", "Stecher", "Meindl", "Pflug", "Lamm", "Witzel", "Thaler", "Rumpf", "Demuth",
			"Plank", "Pick", "Obermaier", "Kloos", "Deutschmann", "Bongartz", "Biehl", "L�ser", "Teschner", "Roloff", "Kahlert", "Lietz",
			"Distler", "Breitenbach", "Thoms", "Kloss", "Hutter", "Gaiser", "Pichler", "Krahl", "Brink", "Spielmann", "Seibt", "Kunath",
			"St�ber", "Zellner", "Scholten", "Reinartz", "Ihle", "Wernicke", "Kirschbaum", "Moldenhauer", "Schuch", "Hansmann", "Burkard",
			"Back", "Bitter", "Licht", "Kapp", "Stracke", "Heinisch", "Grossmann", "Weichert", "Sutter", "Matt", "Hielscher", "Clasen",
			"Adolph", "Steinbrecher", "Kothe", "Hey", "Grill", "Br�mmer", "Voit", "Vater", "Fuhr", "Eisenmann", "Storz", "Herwig",
			"Nordmann", "George", "Kappes", "Beutel", "Stender", "Kl�ckner", "Angerer", "Kast", "Fl�gel", "Gold", "Steinberger", "Heyne",
			"Handke", "Brose", "Stolte", "Lutter", "Roll", "Kalb", "Spangenberg", "Ilg", "Behrends", "Daub", "R�ther", "Goldschmidt",
			"Rinke", "Menge", "Greif", "Wehrle", "Riese", "Pries", "Lambrecht", "Gerling", "Michl", "Emrich", "Jentzsch", "Sorg", "Hundt",
			"Kamm", "Holzinger", "Wohlfahrt", "Knittel", "Freyer", "Wedel", "M�nch", "Offermann", "Schaarschmidt", "Kaufhold", "Wurster",
			"Tetzlaff", "Schug", "K�llner", "Pfisterer", "Salewski", "Schnelle", "Ertel", "Thom", "Klo�", "Epp", "Friedmann", "Fenske",
			"Rehberg", "Knaus", "Gr�ber", "Wittenberg", "Plate", "Mittag", "Junk", "Strube", "M�der", "K�hne", "B�umer", "Maschke",
			"Kuschel", "Kerner", "Herter", "Stemmer", "N�rnberger", "Nicolai", "Cla�en", "Stefan", "Puls", "Gerner", "Radermacher",
			"Germann", "Flick", "Zwick", "Clau�", "Wiest", "Storm", "Harrer", "L�demann", "K�gel", "Kullmann", "Sieg", "Sch�ffler",
			"Schenkel", "Jahns", "Dierks", "Leder", "Franzke", "Retzlaff", "Marschner", "H�lzel", "Weidmann", "Ohm", "Helfrich", "B�ker",
			"Reiss", "Nau", "Mehlhorn", "Lambert", "Herzberg", "Bechtold", "Dahms", "Hannig", "Biller", "Wollny", "Meiser", "Raddatz",
			"Blessing", "Scheidt", "Lennartz", "Kunzmann", "Falkenberg", "Naujoks", "Maa�en", "Kaltenbach", "G�hring", "Arend", "K�ppe",
			"Jochum", "Rist", "Mauch", "Bernard", "Thum", "Oltmanns", "Limmer", "Gunkel", "Wall", "Niebuhr", "Leis", "Wedekind", "V�lkl",
			"Alber", "Weitz", "Reh", "Kerscher", "Ru�", "Hammes", "Alexander", "Andreas", "Wassermann", "Ro�mann", "Freudenberg", "Stach",
			"Klostermann", "Johannes", "Heinzmann", "Bertsch", "de Vries", "Greulich", "Piel", "Brosch", "Galle", "Cornelius", "Seubert",
			"Plath", "Dr�ge", "Birkner", "Thome", "Nie�en", "B�umler", "Scheffel", "Sanders", "Klingler", "Eckel", "Schlenker", "Spahn",
			"M�hl", "Heyn", "Grams", "Brummer", "Bacher", "Tischler", "Acker", "Hohl", "Diederich", "Knoche", "Sch�bel", "Sch�tzle",
			"Lind", "Krupp", "Klasen", "Klaas", "Streicher", "Scheele", "Heer", "Felber", "Schellenberg", "Heiden", "Haberland", "Rosin",
			"Holm", "Rump", "B�chler", "Plum", "Matheis", "H�rtl", "Frahm", "Meder", "Epple", "G�rlich", "Arslan", "Rehbein", "Freytag",
			"K�tter", "Ferber", "Amend", "Mau", "Neitzel", "Lautenschl�ger", "Dahlke", "Adrian", "Scheck", "Reinsch", "Pl�tz", "Wilk",
			"Wenger", "Kutscher", "Kappel", "Mund", "Mandel", "Wehr", "Menges", "Zoller", "Schewe", "Zeiler", "Wehrmann", "Kutz", "H�user",
			"Faulhaber", "Schunk", "Bast", "Sternberg", "Kienle", "Stehr", "Mahnke", "Dill", "Achenbach", "Hartwich", "Kley", "K�lsch",
			"Baltes", "Selzer", "Gronau", "Pfennig", "K�hl", "Erbe", "Pech", "Hellmich", "Rolf", "K�ller", "Sch�dlich", "Mast", "Ortner",
			"Knoch", "Mey", "Steinborn", "Nienhaus", "Steinhauser", "Nitz", "G�hler", "Hillenbrand", "Gilles", "Eichmann", "Wiemer",
			"Hirth", "Steinle", "Gregor", "Sondermann", "G�rgen", "Ringel", "Velten", "G�rner", "Griebel", "Reim", "Henninger", "Bonk",
			"Voges", "Bergemann", "Hammel", "Nehring", "Prange", "Klett", "Kegel", "Dillmann", "Denker", "Bitzer", "Niehoff", "H�lzl",
			"Sand", "Wein", "Hampe", "Bunk", "Feld", "Meinel", "Hilbig", "Hennemann", "Reineke", "G�ttler", "Bensch", "Oestreich", "Engl",
			"Escher", "Bartelt", "Dieterle", "Br�ckmann", "Voll", "Loibl", "Graupner", "Knott", "Franck", "Uhlemann", "Kilic",
			"Blechschmidt", "K�mmerer", "Schwager", "Klinge", "Siegl", "Menne", "Burk", "Loth", "Leonhard", "K�gler", "Kick", "Zacher",
			"Bohl", "Boden", "Trautwein", "Heinecke", "L�ke", "Kutzner", "Benecke", "Ruhl", "Schneiders", "Kettler", "E�er", "Hagel",
			"Glatz", "Sch�ssler", "Matthias", "Hass", "Dettmer", "Sch�le", "Rosner", "Hinkel", "Breit", "Lanz", "Klinke", "Grafe",
			"Schock", "Kappler", "Hackenberg", "Grahl", "Unruh", "Gro�er", "Breu", "Hammann", "M�llmann", "H�tter", "Hegemann", "D�ll",
			"Lehnen", "Ehrmann", "Kracht", "Klocke", "Herber", "Gleich", "F�rtsch", "P�tzsch", "Grosse", "Gebel", "Dahlmann", "Christian",
			"Oberle", "K�sters", "Linz", "Scheurer", "Busche", "Wittek", "Reischl", "Wiens", "P�schl", "Preuss", "J�schke", "Mehler",
			"Fox", "Dudek", "Wischnewski", "Ridder", "Weiner", "Dehn", "Ostertag", "Lochner", "Stutz", "Schwerdtfeger", "Holtkamp",
			"B�low", "Zieger", "Hirschfeld", "Emde", "T�lle", "Streich", "Katz", "Hinrichsen", "Hellmuth", "Reisch", "M�hle", "Reinhart",
			"H�ft", "Dippel", "Schwalm", "Patzelt", "Kimmel", "Heilig", "Schneck", "Schleich", "Engelhard", "Kammer", "H�lzer",
			"Berberich", "Weisser", "Siemer", "Renken", "Sch�nemann", "M�llers", "Blohm", "Treiber", "Reil", "Bienert", "Schultes",
			"Heinlein", "Stegmaier", "Israel", "Zell", "Bichler", "Mengel", "Lucht", "Kamps", "Wittwer", "Prause", "Helbing", "Gaul",
			"Br�ker", "Dunker", "Bechtel", "Zettl", "D�hler", "K�ck", "Heintz", "Birke", "Nies", "Vieth", "Pingel", "Haubold", "Brust",
			"Krell", "Heinicke", "Breyer", "Kinzel", "Breunig", "Oehme", "Diederichs", "Sacher", "R�tten", "Niemeier", "Ketterer",
			"Jasper", "Weidinger", "Sohn", "Sch�ler", "Rudloff", "Nehls", "Grieger", "Burg", "W�lk", "Spitz", "Sch�ner", "M�ck",
			"B�hringer", "Ruck", "Holzwarth", "Riehl", "Wollmann", "Laub", "Klaiber", "Weck", "Rutz", "B�chel", "Brandner", "Klages",
			"Henseler", "Zinn", "Nagler", "Mang", "Lex", "Bangert", "Wurst", "Philipps", "Leupold", "Raith", "Joachim", "Haberkorn",
			"Dickmann", "Gellert", "Greger", "Diel", "Hollstein", "Wilhelmi", "Sch�mann", "J�ttner", "H�ller", "Gra�l", "Derksen",
			"Brennecke", "Tremmel", "G�tte", "Schardt", "Koppe", "Gutjahr", "Burkhard", "Berens", "Hommel", "Gaida", "Piontek", "Stief",
			"Spiller", "Prager", "Kiesewetter", "Brix", "Temme", "Schepers", "Landmann", "J�nger", "Gaus", "Appelt", "Neuberger", "Helmer",
			"Rohleder", "Pawlik", "Angermann", "Kirchhof", "Birkholz", "Steigerwald", "M�hle", "Sch�nberg", "Lichtenberg", "Hennings",
			"Dannenberg", "Benning", "Wanke", "Schnur", "Rauer", "Lesch", "H�cker", "Blome", "Oberl�nder", "K�rschner", "F�hrer", "Edler",
			"Kr�ll", "Hofstetter", "Peukert", "Frech", "Fisch", "Werle", "Greb", "Papke", "Krey", "Hohn", "Gassner", "Buse", "W�lfle",
			"Senft", "Schlag", "Karger", "G�ring", "Glock", "Tietjen", "Sautter", "Beutler", "Guse", "Weinrich", "Heldt", "Gutzeit",
			"Tews", "Schaar", "O�wald", "Mitschke", "Meinke", "Staub", "Hase", "Dold", "Traut", "Ney", "Stoffel", "Siefert", "Jablonski",
			"Brettschneider", "Zach", "Kehrer", "Heinke", "Selle", "Schipper", "Pongratz", "Kost", "Kienzle", "Findeisen", "H�berle",
			"Habel", "Eibl", "Asmus", "Wege", "Korth", "Fast", "Ro�bach", "Vaupel", "Tempel", "Sowa", "H�fele", "Zitzmann", "Fleischhauer",
			"Eitel", "J�ngling", "Jauch", "Ganter", "Sebastian", "Schlemmer", "W�hrle", "Wolfrum", "Sch�ttler", "Schmidl", "K�mpf",
			"Seliger", "Neumeister", "Mittelst�dt", "Ender", "Wicke", "Diefenbach", "Schlesinger", "Scheerer", "Pawlowski", "Flaig",
			"Scheu", "Lambertz", "Gr�nberg", "Baumert", "Hund", "Gohlke", "Bracht", "Willer", "Kuck", "Finkbeiner", "Nadler", "Emmert",
			"Mildner", "Ammon", "Abels", "Schrade", "Rolle", "Hennecke", "Heidt", "Thormann", "Saller", "Hausner", "Dierkes", "Redlich",
			"Edel", "Dorner", "Schwenke", "Reber", "Markgraf", "Herb", "Bartmann", "Walch", "St�ber", "Neef", "Anger", "Stobbe",
			"Klingenberg", "Hotz", "Wittich", "Behm", "Haberl", "Weyand", "Wenig", "Siekmann", "Haustein", "Staudinger", "Schmoll",
			"R��ner", "Genz", "Fr�hauf", "Fellner", "Coenen", "Bohlen", "Berlin", "Sperlich", "Breidenbach", "Schwinn", "Zipfel", "Mainka",
			"V�gele", "Trommer", "Runkel", "Rohmann", "Moog", "Kehr", "Deininger", "Thimm", "Hauk", "Wei�er", "Ladwig", "Scheler",
			"J�nemann", "Heber", "Gessner", "G�ller", "Fix", "Eckart", "Karle", "Rohrbach", "Messer", "K�lling", "Hieber", "Dinter",
			"Hauber", "Denecke", "Dettmann", "Wenzl", "Siemens", "Rebmann", "Huppertz", "Thei�", "Seewald", "Lay", "Meuser", "Erben",
			"Blau", "R�ser", "K�ppel", "Schurig", "Peetz", "St�rmer", "H�mmer", "Engert", "Pietschmann", "Merkl", "B�sing", "Orlowski",
			"Langhammer", "Kirst", "Hildenbrand", "Sieger", "Schulten", "Theil", "Leinweber", "Krapf", "Strauss", "Pitz", "Blumenthal",
			"Gro�kopf", "Fels", "Schaible", "R�hm", "Piotrowski", "Stemmler", "Reinicke", "Pflaum", "Hemmer", "Saur", "Limbach", "Sorge",
			"Russ", "Rhein", "Ostendorf", "Topp", "Krafft", "Giebel", "Daniels", "Bohr", "Hassel", "Schenke", "Hochmuth", "Rombach",
			"Niggemann", "Jungbluth", "Feldhaus", "Janson", "H�ther", "Tauber", "Neher", "Moor", "Behrmann", "Sager", "Thielemann",
			"Stumm", "Meusel", "Feiler", "Stauch", "Pfeuffer", "Niermann", "L�decke", "Seelig", "Kissel", "Eifler", "B�nger",
			"Blankenburg", "Rohe", "Pr�fer", "Herget", "Grunewald", "Laumann", "Schwanke", "Maack", "Leibold", "Heinzel", "Dieterich",
			"Na�", "Haider", "Beetz", "Sauermann", "B�ning", "Schroer", "Heiser", "Tolksdorf", "Strohmeier", "Happel", "Gra�",
			"Gottschling", "Gotthardt", "Achatz", "Wohlfarth", "Vollrath", "Liebe", "Szymanski", "Mertes", "Kn�dler", "Heppner", "Demmer",
			"Alex", "Tappe", "Storck", "K�ppl", "Hertlein", "Wiesmann", "Mies", "Kuntze", "K�cher", "Kaluza", "Fick", "Weniger", "Spieker",
			"Schnoor", "Bamberger", "Middendorf", "He�ler", "Haus", "Hackmann", "Eichholz", "Woll", "Kromer", "Brack", "Schnitzer",
			"Pietzsch", "Milz", "Liese", "Karcher", "Bendel", "Adolf", "Strehl", "Ga�ner", "Thielmann", "Speicher", "Michler",
			"Matthiesen", "Bergen", "Schaffner", "Pausch", "Kastl", "Goertz", "Bruckner", "Steinkamp", "Heizmann", "Ruge", "Rahm", "Poth",
			"Kortmann", "Egner", "Rempel", "Kolberg", "Burkhart", "Pl�ger", "Irmer", "W�rfel", "L�wen", "Tr�ster", "St�ckel", "Niehues",
			"M�nz", "Kruppa", "Teubner", "Brinker", "Brucker", "Stoiber", "Fritzsch", "Sieben", "Rieke", "Schroll", "Winzer", "Thomann",
			"Sch�nborn", "Quade", "Gruhn", "Gottfried", "Basler", "R�diger", "D�ck", "K�gler", "Kleinhans", "Freiberg", "Weishaupt",
			"Nolting", "Geissler", "Majewski", "Weihrauch", "Hendricks", "Gr�tz", "Wesemann", "Geib", "Wei�mann", "Dewald", "Bachmeier",
			"Saathoff", "H�ls", "Hau�mann", "Grabow", "Seyfarth", "Hense", "Sperl", "Rosendahl", "Lembke", "Jesse" };

}
