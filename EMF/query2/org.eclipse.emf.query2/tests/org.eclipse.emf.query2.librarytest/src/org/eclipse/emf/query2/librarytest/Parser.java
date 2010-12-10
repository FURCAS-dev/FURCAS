package org.eclipse.emf.query2.librarytest;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

import library.Book;
import library.Format;
import library.Library;
import library.LibraryFactory;
import library.Manuscript;
import library.Person;
import library.Publisher;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Ignore;
import org.junit.Test;

public class Parser {

	@Test @Ignore
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
	
	public void loadResources(ResourceSet rs) {
		Map<String, Resource> resources = new HashMap<String, Resource>();
		String pathName = "platform:/plugin/org.eclipse.emf.query2.librarytest/data/publisher/dpunkt.xmi";
		Resource r = rs.createResource(URI.createURI(pathName, true));
		loadPersons(rs, resources);
		loadLibraries(rs, resources);
	}

	private void loadLibraries(ResourceSet rs, Map<String, Resource> resources) {
		for (int i = 0; i < cities.length; i++) {
			String city = cities[i];
			String pathName = "platform:/plugin/org.eclipse.emf.query2.librarytest/data/library/"
					+ city + ".xmi";
			Resource r = getResource(rs, pathName);
		}

	}

	private void loadPersons(ResourceSet rs, Map<String, Resource> resources) {
		for (int i = 0; i < personLastNames.length; i++) {
			String lastName = personLastNames[i];
			Resource resourceForPerson = getResourceForPerson(rs, resources,
					lastName.substring(0, 1));
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
			String pathName = "platform:/plugin/org.eclipse.emf.query2.librarytest/data/library/" + city + ".xmi";
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
		pathName=pathName.replaceAll("ö", "oe");
		pathName=pathName.replaceAll("Ö", "Oe");
		pathName=pathName.replaceAll("ü", "ue");
		pathName=pathName.replaceAll("Ü", "Ue");
		pathName=pathName.replaceAll("ä", "ae");
		pathName=pathName.replaceAll("Ä", "Ae");
		pathName=pathName.replaceAll(",", "-");
		pathName=pathName.replaceAll(" ", "");
		pathName=pathName.replaceAll("á", "a");
		pathName=pathName.replaceAll("ó", "o");
		pathName=pathName.replaceAll("í", "i");
		pathName=pathName.replaceAll("é", "e");
		pathName=pathName.replaceAll("'", "");
		pathName=pathName.replaceAll("\\(.*\\)", "");
		Resource r = rs.createResource(URI.createURI(
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

		String pathName = "org.eclipse.emf.query2.syntax.librarytest/data/publisher/dpunkt.xmi";
		Resource dpunktRes = getResource(rs, pathName);
		dpunktRes.getContents().add(dpunkt);
		return dpunkt;
	}

	private Resource getResourceForPerson(ResourceSet rs, Map<String, Resource> resources, String firstChar) {
		Resource r;
		String c = firstChar.toUpperCase();
		if ((r = resources.get(c)) == null) {
			String pathName = "platform:/plugin/org.eclipse.emf.query2.librarytest/data/person/" + c + ".xmi";
			r = getResource(rs, pathName);
			resources.put(c, r);
		}
		return r;
	}

	String[] cities = { "Mumbai (Bombay)", "Karatschi", "Istanbul", "Delhi", "Seoul", "Sao Paulo", "Moskau", "Shanghai", "Lagos",
			"Mexiko-Stadt", "Jakarta", "Tokio", "New York", "Kinshasa", "Kairo", "Teheran", "Peking", "London", "Hongkong", "Lima",
			"Bogotá", "Lahore", "Dhaka", "Bangkok", "Rio de Janeiro", "Bagdad", "Bengaluru (Bangalore)", "Ho-Chi-Minh-Stadt (Saigon)",
			"Santiago de Chile", "Kolkata (Kalkutta)", "Rangun", "Ankara", "Chennai (Madras)", "Wuhan", "Riad",
			"Sankt Petersburg (Leningrad)", "Chongqing", "Chengdu", "Xi'an", "Los Angeles", "Ahmedabad", "Alexandria", "Sydney", "Tianjin",
			"Abidjan", "Busan", "Hyderabad", "Kano", "Singapur", "Yokohama", "Ibadan", "Shenyang", "Berlin", "Melbourne", "Durban",
			"Harbin", "Johannesburg", "Madrid", "Surat", "Pune", "Guangzhou", "Nanjing", "Kanpur", "Omdurman", "Casablanca", "Jaipur",
			"Pjöngjang", "Chicago", "Addis Abeba", "Dschidda", "Luanda", "Nairobi", "Buenos Aires", "Taiyuan", "Salvador da Bahia",
			"Daressalam", "Kiew", "Osaka", "Taipeh", "Lakhnau", "Faisalabad", "Incheon", "Daegu", "Izmir", "Rom", "Changchun", "Toronto",
			"Quezon City", "Gizeh", "Kabul", "Sana'a", "Kapstadt", "Belo Horizonte", "Surabaya", "Nagpur", "Fortaleza", "Maschhad", "Cali",
			"Santo Domingo", "Nagoya", "Houston", "Havanna", "Paris", "Guayaquil", "Chittagong", "Khartum", "Changsha", "Jinan", "Mosul",
			"Dalian", "Basra", "Zhengzhou", "Dakar", "Shijiazhuang", "Taschkent", "Indore", "Accra", "Medellín", "Maracaibo", "Yaoundé",
			"Douala", "Jilin", "Sapporo", "Hangzhou", "Bukarest", "Nanchang", "Caracas", "Ecatepec de Morelos", "Rawalpindi", "Hamburg",
			"Medan", "Minsk", "Patna", "Curitiba", "Warschau", "Budapest", "Soweto", "Wien", "Bhopal", "Brisbane", "Bandung", "Tsingtao",
			"Guadalajara", "al-Chartum Bahri", "Aleppo", "Ludhiana", "Rabat", "Montreal", "Bekasi", "Pretoria", "Barcelona", "Thane",
			"Manaus", "Tangshan", "Kaduna", "Damaskus", "Manila", "Phoenix", "Isfahan", "Harare", "Kobe", "Agra", "Algier", "Quito",
			"Kaohsiung", "Ürümqi", "Recife", "Daejeon", "Kyoto", "Multan", "Kumasi", "Philadelphia", "Charkiw", "Vadodara", "Bursa",
			"Kuala Lumpur", "Pimpri-Chinchwad", "Karadsch", "Caloocan", "Tangerang", "Hanoi", "Täbris", "Gujranwala", "Nowosibirsk",
			"Lanzhou", "Hyderabad", "Gwangju", "Faridabad", "Belém", "Ciudad Juárez", "Fushun", "Fukuoka", "Conakry", "Puebla",
			"Antananarivo", "Luoyang", "Hefei", "Valencia", "Makassar", "Tijuana", "Lubumbashi", "Porto Alegre", "Santa Cruz de la Sierra",
			"München", "Handan", "Kampala", "Suzhou", "Shantou", "Barranquilla", "San Antonio", "Davao City", "Kawasaki", "Córdoba",
			"Depok", "Phnom Penh", "La Matanza", "Mailand", "Bamako", "Mekka", "Nashik", "Jekaterinburg (Swerdlowsk)", "Semarang",
			"Nischni Nowgorod (Gorki)", "Baotou", "Adana", "Montevideo", "Lusaka", "San Diego", "Kalyan-Dombivli", "Palembang", "Peshawar",
			"Beirut", "Schiraz", "Suwon", "Dallas", "Port-au-Prince", "Perth", "Nezahualcóyotl", "Mogadischu", "Merath", "Amman",
			"Mandalay", "Almaty", "Anshan", "Xuzhou", "Ghaziabad", "Goyang", "Baku", "Maputo", "Prag", "Fuzhou", "Rajkot", "Saitama",
			"Guiyang", "Goiania", "Guarulhos", "Varanasi", "Sofia", "Hiroshima", "Tripolis", "Port Harcourt", "Managua", "Brazzaville",
			"Dubai", "Samara (Kujbyschew)", "Omsk", "Benin-Stadt", "Monterrey", "León", "Belgrad", "Maiduguri", "Wuxi", "Kasan",
			"Gaziantep", "Eriwan", "Amritsar", "Rostow am Don", "Allahabad", "Visakhapatnam", "Tscheljabinsk", "Datong", "Tiflis",
			"Xianyang", "Ufa", "Dnipropetrowsk", "Seongnam", "Campinas", "Ouagadougou", "Jabalpur", "Ulan Bator", "Haora", "Huainan",
			"Sendai", "Kunming", "Taichung", "Adelaide", "Aurangabad", "Qom", "Wolgograd (Stalingrad)", "Odessa", "Shenzhen", "Rongcheng",
			"Birmingham", "Neapel" };

	String[] personLastNames = { "Müller", "Schmidt", "Schneider", "Fischer", "Weber", "Meyer", "Wagner", "Becker", "Schulz", "Hoffmann",
			"Schäfer", "Bauer", "Koch", "Richter", "Klein", "Wolf", "Schröder", "Neumann", "Schwarz", "Braun", "Hofmann", "Zimmermann",
			"Schmitt", "Hartmann", "Krüger", "Schmid", "Werner", "Lange", "Schmitz", "Meier", "Krause", "Maier", "Lehmann", "Huber",
			"Mayer", "Herrmann", "Köhler", "Walter", "König", "Schulze", "Fuchs", "Kaiser", "Lang", "Weiß", "Peters", "Scholz", "Jung",
			"Möller", "Hahn", "Keller", "Vogel", "Schubert", "Roth", "Frank", "Friedrich", "Beck", "Günther", "Berger", "Winkler",
			"Lorenz", "Baumann", "Schuster", "Kraus", "Böhm", "Simon", "Franke", "Albrecht", "Winter", "Ludwig", "Martin", "Krämer",
			"Schumacher", "Vogt", "Jäger", "Stein", "Otto", "Groß", "Sommer", "Haas", "Graf", "Heinrich", "Seidel", "Schreiber", "Ziegler",
			"Brandt", "Kuhn", "Schulte", "Dietrich", "Kühn", "Engel", "Pohl", "Horn", "Sauer", "Arnold", "Thomas", "Bergmann", "Busch",
			"Pfeiffer", "Voigt", "Götz", "Seifert", "Lindner", "Ernst", "Hübner", "Kramer", "Franz", "Beyer", "Wolff", "Peter", "Jansen",
			"Kern", "Barth", "Wenzel", "Hermann", "Ott", "Paul", "Riedel", "Wilhelm", "Hansen", "Nagel", "Grimm", "Lenz", "Ritter", "Bock",
			"Langer", "Kaufmann", "Mohr", "Förster", "Zimmer", "Haase", "Lutz", "Kruse", "Jahn", "Schumann", "Fiedler", "Thiel", "Hoppe",
			"Kraft", "Michel", "Marx", "Fritz", "Arndt", "Eckert", "Schütz", "Walther", "Petersen", "Berg", "Schindler", "Kunz", "Reuter",
			"Sander", "Schilling", "Reinhardt", "Frey", "Ebert", "Böttcher", "Thiele", "Gruber", "Schramm", "Hein", "Bayer", "Fröhlich",
			"Voß", "Herzog", "Hesse", "Maurer", "Rudolph", "Nowak", "Geiger", "Beckmann", "Kunze", "Seitz", "Stephan", "Büttner", "Bender",
			"Gärtner", "Bachmann", "Behrens", "Scherer", "Adam", "Stahl", "Steiner", "Kurz", "Dietz", "Brunner", "Witt", "Moser", "Fink",
			"Ullrich", "Kirchner", "Löffler", "Heinz", "Schultz", "Ulrich", "Reichert", "Schwab", "Breuer", "Gerlach", "Brinkmann",
			"Göbel", "Blum", "Brand", "Naumann", "Stark", "Wirth", "Schenk", "Binder", "Körner", "Schlüter", "Rieger", "Urban", "Böhme",
			"Jakob", "Schröter", "Krebs", "Wegner", "Heller", "Kopp", "Link", "Wittmann", "Unger", "Reimann", "Ackermann", "Hirsch",
			"Schiller", "Döring", "May", "Bruns", "Wendt", "Wolter", "Menzel", "Pfeifer", "Sturm", "Buchholz", "Rose", "Meißner",
			"Janssen", "Bach", "Engelhardt", "Bischoff", "Bartsch", "John", "Kohl", "Kolb", "Münch", "Vetter", "Hildebrandt", "Renner",
			"Weiss", "Kiefer", "Rau", "Hinz", "Wilke", "Gebhardt", "Siebert", "Baier", "Köster", "Rohde", "Will", "Fricke", "Freitag",
			"Nickel", "Reich", "Funk", "Linke", "Keil", "Hennig", "Witte", "Stoll", "Schreiner", "Held", "Noack", "Brückner", "Decker",
			"Neubauer", "Westphal", "Heinze", "Baum", "Schön", "Wimmer", "Marquardt", "Stadler", "Schlegel", "Kremer", "Ahrens", "Hammer",
			"Röder", "Pieper", "Kirsch", "Fuhrmann", "Henning", "Krug", "Popp", "Conrad", "Karl", "Krieger", "Mann", "Wiedemann", "Lemke",
			"Erdmann", "Mertens", "Heß", "Esser", "Hanke", "Strauß", "Miller", "Berndt", "Konrad", "Jacob", "Philipp", "Metzger", "Henke",
			"Wiese", "Hauser", "Dittrich", "Albert", "Klose", "Bader", "Herbst", "Henkel", "Kröger", "Wahl", "Bartels", "Harms", "Fritsch",
			"Adler", "Großmann", "Burger", "Schrader", "Probst", "Martens", "Baur", "Burkhardt", "Hess", "Mayr", "Nolte", "Heine",
			"Kuhlmann", "Klaus", "Kühne", "Kluge", "Bernhardt", "Blank", "Hamann", "Steffen", "Brenner", "Rauch", "Reiter", "Preuß",
			"Jost", "Wild", "Hummel", "Beier", "Krauß", "Lindemann", "Herold", "Christ", "Niemann", "Funke", "Haupt", "Janßen", "Vollmer",
			"Straub", "Strobel", "Wiegand", "Merz", "Haag", "Holz", "Knoll", "Zander", "Rausch", "Bode", "Beer", "Betz", "Anders",
			"Wetzel", "Hartung", "Glaser", "Fleischer", "Rupp", "Reichel", "Lohmann", "Diehl", "Jordan", "Eder", "Rothe", "Weis",
			"Heinemann", "Dörr", "Metz", "Kroll", "Freund", "Wegener", "Hohmann", "Geißler", "Schüler", "Schade", "Raab", "Feldmann",
			"Zeller", "Neubert", "Rapp", "Kessler", "Heck", "Meister", "Stock", "Römer", "Seiler", "Altmann", "Behrendt", "Jacobs", "Mai",
			"Bär", "Wunderlich", "Schütte", "Lauer", "Benz", "Weise", "Völker", "Sonntag", "Bühler", "Gerber", "Kellner", "Bittner",
			"Schweizer", "Keßler", "Hagen", "Wieland", "Born", "Merkel", "Falk", "Busse", "Gross", "Eichhorn", "Greiner", "Moritz",
			"Forster", "Stumpf", "Seidl", "Scharf", "Hentschel", "Buck", "Voss", "Hartwig", "Heil", "Eberhardt", "Oswald", "Lechner",
			"Block", "Heim", "Steffens", "Weigel", "Pietsch", "Brandl", "Schott", "Gottschalk", "Bertram", "Ehlers", "Fleischmann",
			"Albers", "Weidner", "Hiller", "Seeger", "Geyer", "Jürgens", "Baumgartner", "Mack", "Schuler", "Appel", "Pape", "Dorn", "Wulf",
			"Opitz", "Wiesner", "Hecht", "Moll", "Gabriel", "Auer", "Engelmann", "Singer", "Neuhaus", "Giese", "Schütze", "Geisler", "Ruf",
			"Heuer", "Noll", "Scheffler", "Sauter", "Reimer", "Klemm", "Schaller", "Hempel", "Kretschmer", "Runge", "Springer", "Riedl",
			"Steinbach", "Michels", "Barthel", "Pfaff", "Kohler", "Zahn", "Radtke", "Neugebauer", "Hensel", "Winkelmann", "Gebauer",
			"Engels", "Wichmann", "Eichler", "Schnell", "Weller", "Brüggemann", "Scholl", "Timm", "Siegel", "Heise", "Rösch", "Bürger",
			"Hinrichs", "Stolz", "Walz", "Specht", "Dick", "Geier", "Volk", "Junker", "Prinz", "Otte", "Schick", "Klotz", "Haller",
			"Rother", "Koller", "Börner", "Thoma", "Drescher", "Kempf", "Schirmer", "Faber", "Frenzel", "Uhlig", "Schnabel", "Wirtz",
			"Dürr", "Kranz", "Kasper", "Hausmann", "Hagemann", "Gerhardt", "Lux", "Fries", "Haug", "Endres", "Maas", "Schürmann", "Eberle",
			"Knapp", "Eggert", "Brauer", "Finke", "Paulus", "Petzold", "Hauck", "Rath", "Elsner", "Dreyer", "Sievers", "Faust", "Dittmann",
			"Wehner", "Kilian", "Sattler", "Reichelt", "Langner", "Rabe", "Bremer", "Abel", "Pütz", "Wittig", "Kühl", "Schober", "Maaß",
			"Cordes", "Uhl", "Kahl", "Korn", "Harder", "Bernhard", "Ullmann", "Thieme", "Klinger", "Bohn", "Biermann", "Vogl", "Schütt",
			"Schaefer", "Kemper", "Knorr", "Michaelis", "Große", "Gerdes", "Stöhr", "Hartl", "Lehner", "Mielke", "Eggers", "Schaaf",
			"Sieber", "Melzer", "Behr", "Weiler", "Lippert", "Eckhardt", "Höfer", "Fritzsche", "Helbig", "Theis", "Schlosser", "Leonhardt",
			"Ries", "Reinhold", "Rademacher", "Evers", "Rudolf", "Rost", "Horstmann", "Hecker", "Dreher", "Pilz", "Junge", "Ehrhardt",
			"Matthes", "Klug", "Kunkel", "Steinmetz", "Heitmann", "Bahr", "Augustin", "Höhne", "Hering", "Hellmann", "Hildebrand",
			"Trautmann", "Amann", "Heinrichs", "Höhn", "Heimann", "Lück", "Nitsche", "Sprenger", "Vogler", "Claus", "Jensen", "Blume",
			"Drews", "Damm", "Hofer", "Kurth", "Groth", "Janke", "Heilmann", "Hellwig", "Just", "Wacker", "Huth", "Jahnke", "Strauch",
			"Stenzel", "Böhmer", "Hertel", "Hornung", "Götze", "Reinhard", "Ruppert", "Lau", "Renz", "Sperling", "Teichmann", "Schönfeld",
			"Späth", "Hafner", "Alt", "Borchert", "Rehm", "Pohlmann", "Pfister", "Zink", "Roos", "Mader", "Wille", "Schroeder", "Heinen",
			"Lotz", "Balzer", "Schwarze", "Westermann", "Ebner", "Krieg", "Schweiger", "Bosch", "Engler", "Schleicher", "Pfeffer",
			"Gehrke", "Kaminski", "Schuh", "Clemens", "Liedtke", "Wessel", "Friedrichs", "Eisele", "Kirchhoff", "Reiß", "Brockmann",
			"Schöne", "Frick", "Ulbrich", "Trapp", "Rößler", "Hoyer", "Thomsen", "Scheer", "Wagener", "Starke", "Korte", "Baumeister",
			"Kretzschmar", "Veit", "Grote", "Sachs", "Nitschke", "Bartel", "Schwarzer", "Hampel", "Bischof", "Schweitzer", "Seemann",
			"Grau", "Lehnert", "Orth", "Süß", "Loos", "Stiller", "Henze", "Lohse", "Küster", "Baumgärtner", "Oppermann", "Brendel",
			"Kirschner", "Schüller", "Wendel", "Burmeister", "Kastner", "Daniel", "Menke", "Seibert", "Widmann", "David", "Reitz",
			"Kühnel", "Diekmann", "Steinert", "Klatt", "Wörner", "Wolters", "Fürst", "Lampe", "Heckmann", "Wilde", "Buchner", "Becher",
			"Heider", "Grundmann", "Schwabe", "Hager", "Buschmann", "Keck", "Mühlbauer", "Schauer", "Petri", "Rühl", "Eckstein", "Schatz",
			"Kolbe", "Kling", "Knobloch", "Otten", "Muth", "Reinke", "Baumgart", "Horst", "Doll", "Kugler", "Gläser", "Stange", "Tietz",
			"Schell", "Brüning", "Helm", "Hacker", "Cremer", "Riemer", "Behnke", "Heyer", "Reiser", "Steinke", "Ostermann", "Büchner",
			"Häusler", "Jacobi", "Heuser", "Obermeier", "Herr", "Kübler", "Spies", "Spindler", "Schmidtke", "Hermes", "Kreuzer", "Kock",
			"Stamm", "Pauli", "Ewald", "Hagedorn", "Kersten", "Weiland", "Resch", "Neu", "Pabst", "Kleine", "Grün", "Janzen", "Berthold",
			"Apel", "Löhr", "Jakobs", "Friedl", "Ehlert", "Bastian", "Volz", "Fritsche", "Cramer", "Weinert", "Frisch", "Grund", "Wilms",
			"Scheller", "Enders", "Mahler", "Brandes", "Hamm", "Wieczorek", "Burghardt", "Schwartz", "Thies", "Brück", "Stern", "Lukas",
			"Rode", "Hanisch", "Lauterbach", "Gehrmann", "Yilmaz", "Adams", "Henn", "Merten", "Gottwald", "Petry", "Gehring", "Hack",
			"Niemeyer", "Backhaus", "Rupprecht", "Heidrich", "Heidenreich", "Mende", "Volkmann", "Hille", "Herz", "Böttger", "Knauer",
			"Körber", "Baumgarten", "Bucher", "Schaub", "Michael", "Eckardt", "Lerch", "Jonas", "Rahn", "Budde", "Rösler", "Hannemann",
			"Seidler", "Schiffer", "Sachse", "Ochs", "Brehm", "Hillebrand", "Hardt", "Zeidler", "Wüst", "Küpper", "Ebeling", "Hölscher",
			"Grünewald", "Kowalski", "Thiemann", "Reis", "Welsch", "Schultze", "Sailer", "Haack", "Ortmann", "Meurer", "Ebel", "Seibel",
			"Kellermann", "Köhn", "Tiedemann", "Kunert", "Bräuer", "Schaper", "Ehrlich", "Reif", "Aigner", "Wulff", "Berner", "Bormann",
			"Schröer", "Armbruster", "Eilers", "Raabe", "Fichtner", "Thelen", "Bolz", "Pahl", "Mangold", "Scheel", "Kratz", "Hoch",
			"Backes", "Schuhmacher", "Reinecke", "Zöller", "Johannsen", "Dieckmann", "Drechsler", "Emmerich", "Rauscher", "Post",
			"Weigand", "Hill", "Andres", "Wächter", "Stratmann", "Wallner", "Spengler", "Metzner", "Merk", "Palm", "Hopf", "Dietze",
			"Kammerer", "Krohn", "Kleinert", "Linder", "Henrich", "Morgenstern", "Rogge", "Grube", "Grabowski", "Wurm", "Kummer", "Hoff",
			"Paulsen", "Ertl", "Zorn", "Petermann", "Küppers", "Buchmann", "Dreier", "Sommerfeld", "Bähr", "Rosenberger", "Reichardt",
			"Reimers", "März", "Heger", "Lenk", "Jaeger", "Hopp", "Habermann", "Boldt", "Schreier", "Ewert", "Pusch", "Boos", "Finger",
			"Christmann", "Weiser", "Wendler", "Maul", "Holzer", "Franzen", "Wachter", "Lorenzen", "Siegert", "Hollmann", "Ahlers",
			"Exner", "Grunwald", "Daum", "Struck", "Schönberger", "Waldmann", "Kießling", "Büscher", "Rein", "Hock", "Holzapfel",
			"Kästner", "Rasch", "Lüdtke", "Homann", "Steiger", "Gräf", "Stöcker", "Strobl", "Metzler", "Fleck", "Fey", "Hörmann", "Lehr",
			"Arlt", "Rückert", "Rohr", "Friese", "Fechner", "Eck", "Tillmann", "Englert", "Klee", "Steger", "Bäcker", "Fiebig", "Löw",
			"Hermanns", "Zech", "Borchers", "Weinmann", "Rieck", "Markert", "Lücke", "Butz", "Friedel", "Aust", "Möbius", "Härtel",
			"Clausen", "Deutsch", "Wessels", "Zeitler", "Heidemann", "Röhrig", "Siegmund", "Oertel", "Rüdiger", "Marschall", "Schäffer",
			"Henschel", "Hunger", "Sell", "Pfeil", "Goebel", "Edelmann", "Gerhard", "Rosenthal", "Rosenkranz", "Hain", "Zöllner", "Künzel",
			"Kleinschmidt", "Färber", "Schacht", "Schwenk", "Rösner", "Böck", "Töpfer", "Grüner", "Spiegel", "Weigl", "Georgi", "Bruhn",
			"Hubert", "Holzmann", "Drexler", "Steinmann", "Groh", "Schmieder", "Kober", "Huhn", "Hinze", "Gebhard", "Zapf", "Lederer",
			"Birk", "Landgraf", "Raschke", "Leitner", "Schüßler", "Kuhl", "Bosse", "Laux", "Rauh", "Christiansen", "Trost", "Reinert",
			"Klink", "Schuhmann", "Fabian", "Rieder", "Fromm", "Holst", "Bauch", "Jäckel", "Gutmann", "Freese", "Weigelt", "Buhl",
			"Steinberg", "Poppe", "Stier", "Jakobi", "Seibold", "Reiner", "Wortmann", "Luft", "Faßbender", "Wilken", "Schmelzer",
			"Schönherr", "Maus", "Hofmeister", "Heide", "Wilkens", "Wolfram", "Stelzer", "Quast", "Bothe", "Lachmann", "Schnitzler",
			"Gröger", "Mücke", "Liebig", "Kreutz", "Nitsch", "Glück", "Häfner", "Kohn", "Wegmann", "Olbrich", "Völkel", "Scheibe",
			"Herbert", "Erhardt", "Sasse", "Giesen", "Jeske", "Lübke", "Reck", "Kleemann", "Frei", "Roß", "Stricker", "Marks", "Kamp",
			"Denk", "Obst", "Glöckner", "Winkel", "Rink", "Reese", "Baron", "Preiß", "Riemann", "Gebert", "Kayser", "Hülsmann", "Sänger",
			"Meinhardt", "Loch", "Storch", "Egger", "Degen", "Dittmar", "Diener", "Salzmann", "Stolle", "Zabel", "Goldmann", "Schuller",
			"Höppner", "Uhlmann", "Biedermann", "Stegemann", "Manz", "Weidemann", "Mattern", "Hamacher", "Kropp", "Schönfelder", "Pätzold",
			"Dahmen", "Welter", "Pelz", "Pelzer", "Schmalz", "Donath", "Eichner", "Niedermeier", "Scheuermann", "Dengler", "Stork", "Hirt",
			"Lamprecht", "Bartl", "Ley", "Timmermann", "Strasser", "Kleiner", "Lohr", "Knecht", "Mundt", "Klassen", "Stegmann", "Pohle",
			"Kiel", "Rommel", "Münster", "Bornemann", "Andresen", "Tiemann", "Stangl", "Knop", "Carl", "Merkle", "Gall", "Schild", "Hans",
			"Bieber", "Jankowski", "Rust", "Neumeier", "Beckers", "Greve", "Engelke", "Rüger", "Zielke", "Streit", "Lammers", "Anton",
			"Abraham", "Gries", "Kempe", "Franken", "Bräutigam", "Nissen", "Janz", "Reiche", "Linden", "Ring", "Luther", "Stengel",
			"Gabler", "Karg", "Weinhold", "Radke", "Liebl", "Ecker", "Kopf", "Danner", "Weimer", "Holl", "Welz", "Schlösser", "Weil",
			"Jeschke", "Bretschneider", "Siewert", "Bartz", "Willmann", "Strecker", "Wrobel", "Jacobsen", "Wieser", "Dombrowski",
			"Carstens", "Schreck", "Rücker", "Häring", "Mager", "Aßmann", "Warnecke", "Benner", "Wenz", "Deppe", "Bollmann", "Gerken",
			"Bott", "Heiß", "Meissner", "Eberl", "Spieß", "Matthies", "Keim", "Hauke", "Erb", "Tischer", "Kreis", "Grothe", "Ulbricht",
			"Senger", "Brandenburg", "Friesen", "Matz", "Vogelsang", "Hofbauer", "Manthey", "Arens", "Christoph", "Schult", "Knopp",
			"Dreßler", "Brill", "Kuhnert", "Bergner", "Maiwald", "Braune", "Hoffmeister", "Aschenbrenner", "Borchardt", "Gast", "Schwan",
			"Teichert", "Sack", "Möckel", "Brune", "Wende", "Gerke", "Kress", "Kahle", "Gruner", "Spitzer", "Dietl", "Rott", "Oster",
			"Gerstner", "Erler", "Lucas", "Heymann", "Buß", "Steuer", "Hirschmann", "Geis", "Dunkel", "Tröger", "Pauly", "Kreutzer", "Haß",
			"Hauschild", "Hillmann", "Pfau", "Strack", "Eberhard", "Preis", "Kaya", "Willms", "Tietze", "Guth", "Buchwald", "Willems",
			"Röhl", "Fuß", "Hartig", "Wünsch", "Huck", "Reschke", "Reith", "Jentsch", "Speck", "Häußler", "Rotter", "Schuldt", "Martini",
			"Kretschmann", "Geppert", "Lösch", "Bloch", "Koslowski", "Georg", "Sahin", "Geist", "Pagel", "Rosenberg", "Frings", "Semmler",
			"Hilger", "Günter", "Dahm", "Drees", "Hauptmann", "Leopold", "Wunder", "Kreß", "Lipp", "Best", "Wendland", "Landwehr",
			"Melcher", "Gräfe", "Bäuerle", "Laube", "Hauer", "Kaul", "Hackl", "Mahr", "Ludewig", "Feil", "Engelbrecht", "Eich", "Grunert",
			"Veith", "Bruder", "Nitzsche", "Knopf", "Schlichting", "Salomon", "Bork", "Hilbert", "Arendt", "Dirks", "Blanke", "Droste",
			"Strunk", "Traub", "Theobald", "Eger", "Krauss", "List", "Jäkel", "Zobel", "Carstensen", "Stocker", "Schiemann", "Neufeld",
			"Czech", "Brauner", "Wick", "Peschel", "Rettig", "Löwe", "Suhr", "Grewe", "Holler", "Scheid", "Ruhland", "Reindl", "Ritz",
			"Grebe", "Koop", "Esch", "Meixner", "Brock", "Schall", "Rottmann", "Reusch", "Donner", "Fischbach", "Kehl", "Diedrich",
			"Böhler", "Ramm", "Theisen", "Sandner", "Pflüger", "Buch", "Hof", "Scherf", "Henne", "Feller", "Rödel", "Munz", "Hänsel",
			"Sandmann", "Schwaiger", "Herzig", "Ross", "Schünemann", "Dahl", "Zeh", "Kühner", "Kasten", "Böcker", "Rickert", "Dörfler",
			"Euler", "Neumaier", "Menz", "Jobst", "Rieß", "Kersting", "Thamm", "Knappe", "Gericke", "Wanner", "Kupfer", "Teuber", "Görtz",
			"Wunsch", "Thiede", "Kirsten", "Schiele", "Bolte", "Kleber", "Gerhards", "Molitor", "Heid", "Hägele", "Kiesel", "Heckel",
			"Rusch", "Behrend", "Mattes", "Demir", "Abele", "Röttger", "Johann", "Hug", "Baldauf", "Schoch", "Heigl", "Blümel", "Dräger",
			"Paschke", "Peschke", "Jungmann", "Hell", "Glas", "Staudt", "Ulmer", "Wiedmann", "Schroth", "Reuß", "Flohr", "Dorsch", "Werth",
			"Reichenbach", "Zenker", "Wohlgemuth", "Simons", "Celik", "Steinhauer", "Eickhoff", "Kratzer", "Hasse", "Wiemann", "Walker",
			"Drewes", "Helms", "Nowack", "Montag", "Dörner", "Pesch", "Weimann", "Türk", "Titze", "Stroh", "Hörner", "Brecht", "Althoff",
			"Barz", "Steinhoff", "Jessen", "Scholze", "Grünwald", "Kaden", "Faller", "Wünsche", "Reuther", "Hönig", "Mair", "Jörg",
			"Möhring", "Haak", "Mehl", "Grohmann", "Gerth", "Wölfel", "Dammann", "Schupp", "Schad", "Markus", "Hilgers", "Blaschke",
			"Rosenbaum", "Borgmann", "Leicht", "Eichinger", "Lüders", "Frese", "Wrede", "Linde", "Höpfner", "Kube", "Nestler", "Joos",
			"Penner", "Lieb", "Schaal", "Drechsel", "Kessel", "Seiffert", "Bellmann", "Stolze", "Ruff", "Weinberger", "Schuck", "Rummel",
			"Seel", "Sonnenberg", "Hüttner", "Schmidbauer", "Neff", "Klement", "Wittke", "Schmiedel", "Liebscher", "Bogner", "Erhard",
			"Burkert", "Boll", "Stehle", "Krings", "Baumbach", "Schöning", "Kohlmann", "Schwarzkopf", "Schaffer", "Mehnert", "Kreft",
			"Schreiter", "Junghans", "Hilpert", "Althaus", "Messerschmidt", "Marten", "Haake", "Rech", "Böse", "Panzer", "Schlicht",
			"Höfler", "Köppen", "Eberlein", "Schillinger", "Falke", "Klos", "Belz", "Michalski", "Borowski", "Pott", "Loose", "Mauer",
			"Kurtz", "Taubert", "Heindl", "Mock", "Krull", "Hammerschmidt", "Hahne", "Bickel", "Rautenberg", "Koll", "Hähnel", "Göpfert",
			"Küchler", "Stöckl", "Goller", "Korb", "Söllner", "Hornig", "Dressel", "Wuttke", "Schiefer", "Heinzelmann", "Rank", "Staab",
			"Wiebe", "Holtz", "Richert", "Frerichs", "Flemming", "Hepp", "Both", "Degenhardt", "Lippmann", "Utz", "Kittel", "Eckl",
			"Yildirim", "Schmied", "Köpke", "Geiß", "Dohmen", "Zielinski", "Kautz", "Burmester", "Bluhm", "Krone", "Thiem", "Kindler",
			"Potthoff", "Mueller", "Bell", "Aydin", "Straube", "Klar", "Riegel", "Reichmann", "Kluth", "Dittmer", "Welzel", "Kümmel",
			"Holland", "Bücker", "Imhof", "Lewandowski", "Beckert", "Schreyer", "Ehret", "Ruppel", "Kaczmarek", "Wiegmann", "Feige",
			"Träger", "Buss", "Brugger", "Assmann", "Olschewski", "Meinert", "Gundlach", "Zacharias", "Straßer", "Risse", "Pauls", "Heins",
			"Stelter", "Speer", "Bier", "Teske", "Knebel", "Hufnagel", "Mewes", "Windisch", "Warnke", "Frost", "Volkmer", "Schwind",
			"Reisinger", "Debus", "Bopp", "Schill", "Bley", "Mischke", "Böhnke", "Meinecke", "Flach", "Günzel", "Klier", "Bausch",
			"Teufel", "Brühl", "Schultheiß", "Oehler", "Hallmann", "Stich", "Meisel", "Krumm", "Hänel", "Rathmann", "Leistner", "Domke",
			"Sigl", "Wenk", "Weigert", "Laue", "Schlecht", "Reiners", "Krenz", "Baer", "Kirstein", "Bußmann", "Ganz", "Rössler", "Dietzel",
			"Karsten", "Schäfers", "Böckmann", "Pöhlmann", "Kampmann", "Yildiz", "Borrmann", "Kähler", "Kettner", "Kollmann", "Platz",
			"Feist", "Weyer", "Oldenburg", "Niehaus", "Kölbl", "Weinzierl", "Gutsche", "Dressler", "Zuber", "Buhr", "Garbe", "Swoboda",
			"Moos", "Kröner", "Holzner", "Abt", "Reichl", "Nielsen", "Schanz", "Pollmann", "Hipp", "Schimmel", "Thielen", "Schultheis",
			"Nebel", "Steininger", "Jürgensen", "Zinke", "Behringer", "Wald", "Matzke", "Stiegler", "Schmuck", "Dobler", "Bürkle",
			"Rasche", "Eller", "Bade", "Stenger", "Knuth", "Seufert", "Jehle", "Saß", "Roller", "Taube", "Linnemann", "Neuner", "Neuber",
			"Mathes", "Fetzer", "Röhr", "Knauf", "Holstein", "Haufe", "Fleckenstein", "Risch", "Philippi", "Merker", "Kerber", "Weitzel",
			"Scheuer", "Klenk", "Keppler", "Özdemir", "Ostermeier", "Tesch", "Steck", "Knoop", "Kircher", "Ehmann", "Knoblauch", "Öztürk",
			"Rühle", "Koopmann", "Leuschner", "Laufer", "Schorn", "Friebe", "Mark", "Knabe", "Leber", "Lauber", "Stürmer", "Putz",
			"Nägele", "Meiners", "Weidlich", "Püschel", "Beermann", "Sippel", "Schalk", "Reger", "Heumann", "Stang", "Zühlke", "Milde",
			"Kindermann", "Weingärtner", "Harnisch", "Groll", "Waibel", "Grosch", "Priebe", "Wellmann", "Marek", "Freier", "Schießl",
			"Kelm", "Hetzel", "Langen", "Kusch", "Hild", "Grosser", "Fehr", "Geßner", "Bruch", "Bohne", "Duda", "Tewes", "Stockmann",
			"Roscher", "Sievert", "Deckert", "Bethke", "Kirch", "Kraemer", "Gürtler", "Sperber", "Valentin", "Rüter", "Lippold", "Beil",
			"Schorr", "Kind", "Ziemann", "Wiechmann", "Schuchardt", "Kuntz", "Burkart", "Holtmann", "Welker", "Leipold", "Kistner",
			"Kaspar", "Griese", "Schimpf", "Schier", "Lenzen", "Polster", "Wichert", "Klumpp", "Hintze", "Staiger", "Gabel", "Balke",
			"Severin", "Kipp", "Dogan", "Hintz", "Goldbach", "Stecher", "Meindl", "Pflug", "Lamm", "Witzel", "Thaler", "Rumpf", "Demuth",
			"Plank", "Pick", "Obermaier", "Kloos", "Deutschmann", "Bongartz", "Biehl", "Löser", "Teschner", "Roloff", "Kahlert", "Lietz",
			"Distler", "Breitenbach", "Thoms", "Kloss", "Hutter", "Gaiser", "Pichler", "Krahl", "Brink", "Spielmann", "Seibt", "Kunath",
			"Stüber", "Zellner", "Scholten", "Reinartz", "Ihle", "Wernicke", "Kirschbaum", "Moldenhauer", "Schuch", "Hansmann", "Burkard",
			"Back", "Bitter", "Licht", "Kapp", "Stracke", "Heinisch", "Grossmann", "Weichert", "Sutter", "Matt", "Hielscher", "Clasen",
			"Adolph", "Steinbrecher", "Kothe", "Hey", "Grill", "Brümmer", "Voit", "Vater", "Fuhr", "Eisenmann", "Storz", "Herwig",
			"Nordmann", "George", "Kappes", "Beutel", "Stender", "Klöckner", "Angerer", "Kast", "Flügel", "Gold", "Steinberger", "Heyne",
			"Handke", "Brose", "Stolte", "Lutter", "Roll", "Kalb", "Spangenberg", "Ilg", "Behrends", "Daub", "Rüther", "Goldschmidt",
			"Rinke", "Menge", "Greif", "Wehrle", "Riese", "Pries", "Lambrecht", "Gerling", "Michl", "Emrich", "Jentzsch", "Sorg", "Hundt",
			"Kamm", "Holzinger", "Wohlfahrt", "Knittel", "Freyer", "Wedel", "Mönch", "Offermann", "Schaarschmidt", "Kaufhold", "Wurster",
			"Tetzlaff", "Schug", "Köllner", "Pfisterer", "Salewski", "Schnelle", "Ertel", "Thom", "Kloß", "Epp", "Friedmann", "Fenske",
			"Rehberg", "Knaus", "Gräber", "Wittenberg", "Plate", "Mittag", "Junk", "Strube", "Mäder", "Köhne", "Bäumer", "Maschke",
			"Kuschel", "Kerner", "Herter", "Stemmer", "Nürnberger", "Nicolai", "Claßen", "Stefan", "Puls", "Gerner", "Radermacher",
			"Germann", "Flick", "Zwick", "Clauß", "Wiest", "Storm", "Harrer", "Lüdemann", "Kögel", "Kullmann", "Sieg", "Schäffler",
			"Schenkel", "Jahns", "Dierks", "Leder", "Franzke", "Retzlaff", "Marschner", "Hölzel", "Weidmann", "Ohm", "Helfrich", "Böker",
			"Reiss", "Nau", "Mehlhorn", "Lambert", "Herzberg", "Bechtold", "Dahms", "Hannig", "Biller", "Wollny", "Meiser", "Raddatz",
			"Blessing", "Scheidt", "Lennartz", "Kunzmann", "Falkenberg", "Naujoks", "Maaßen", "Kaltenbach", "Göhring", "Arend", "Köppe",
			"Jochum", "Rist", "Mauch", "Bernard", "Thum", "Oltmanns", "Limmer", "Gunkel", "Wall", "Niebuhr", "Leis", "Wedekind", "Völkl",
			"Alber", "Weitz", "Reh", "Kerscher", "Ruß", "Hammes", "Alexander", "Andreas", "Wassermann", "Roßmann", "Freudenberg", "Stach",
			"Klostermann", "Johannes", "Heinzmann", "Bertsch", "de Vries", "Greulich", "Piel", "Brosch", "Galle", "Cornelius", "Seubert",
			"Plath", "Dröge", "Birkner", "Thome", "Nießen", "Bäumler", "Scheffel", "Sanders", "Klingler", "Eckel", "Schlenker", "Spahn",
			"Mühl", "Heyn", "Grams", "Brummer", "Bacher", "Tischler", "Acker", "Hohl", "Diederich", "Knoche", "Schöbel", "Schätzle",
			"Lind", "Krupp", "Klasen", "Klaas", "Streicher", "Scheele", "Heer", "Felber", "Schellenberg", "Heiden", "Haberland", "Rosin",
			"Holm", "Rump", "Büchler", "Plum", "Matheis", "Härtl", "Frahm", "Meder", "Epple", "Görlich", "Arslan", "Rehbein", "Freytag",
			"Kötter", "Ferber", "Amend", "Mau", "Neitzel", "Lautenschläger", "Dahlke", "Adrian", "Scheck", "Reinsch", "Plötz", "Wilk",
			"Wenger", "Kutscher", "Kappel", "Mund", "Mandel", "Wehr", "Menges", "Zoller", "Schewe", "Zeiler", "Wehrmann", "Kutz", "Häuser",
			"Faulhaber", "Schunk", "Bast", "Sternberg", "Kienle", "Stehr", "Mahnke", "Dill", "Achenbach", "Hartwich", "Kley", "Kölsch",
			"Baltes", "Selzer", "Gronau", "Pfennig", "Köhl", "Erbe", "Pech", "Hellmich", "Rolf", "Köller", "Schädlich", "Mast", "Ortner",
			"Knoch", "Mey", "Steinborn", "Nienhaus", "Steinhauser", "Nitz", "Göhler", "Hillenbrand", "Gilles", "Eichmann", "Wiemer",
			"Hirth", "Steinle", "Gregor", "Sondermann", "Görgen", "Ringel", "Velten", "Görner", "Griebel", "Reim", "Henninger", "Bonk",
			"Voges", "Bergemann", "Hammel", "Nehring", "Prange", "Klett", "Kegel", "Dillmann", "Denker", "Bitzer", "Niehoff", "Hölzl",
			"Sand", "Wein", "Hampe", "Bunk", "Feld", "Meinel", "Hilbig", "Hennemann", "Reineke", "Güttler", "Bensch", "Oestreich", "Engl",
			"Escher", "Bartelt", "Dieterle", "Brückmann", "Voll", "Loibl", "Graupner", "Knott", "Franck", "Uhlemann", "Kilic",
			"Blechschmidt", "Kämmerer", "Schwager", "Klinge", "Siegl", "Menne", "Burk", "Loth", "Leonhard", "Kögler", "Kick", "Zacher",
			"Bohl", "Boden", "Trautwein", "Heinecke", "Lüke", "Kutzner", "Benecke", "Ruhl", "Schneiders", "Kettler", "Eßer", "Hagel",
			"Glatz", "Schüssler", "Matthias", "Hass", "Dettmer", "Schüle", "Rosner", "Hinkel", "Breit", "Lanz", "Klinke", "Grafe",
			"Schock", "Kappler", "Hackenberg", "Grahl", "Unruh", "Großer", "Breu", "Hammann", "Möllmann", "Hütter", "Hegemann", "Döll",
			"Lehnen", "Ehrmann", "Kracht", "Klocke", "Herber", "Gleich", "Förtsch", "Pötzsch", "Grosse", "Gebel", "Dahlmann", "Christian",
			"Oberle", "Kösters", "Linz", "Scheurer", "Busche", "Wittek", "Reischl", "Wiens", "Pöschl", "Preuss", "Jäschke", "Mehler",
			"Fox", "Dudek", "Wischnewski", "Ridder", "Weiner", "Dehn", "Ostertag", "Lochner", "Stutz", "Schwerdtfeger", "Holtkamp",
			"Bülow", "Zieger", "Hirschfeld", "Emde", "Tölle", "Streich", "Katz", "Hinrichsen", "Hellmuth", "Reisch", "Mühle", "Reinhart",
			"Höft", "Dippel", "Schwalm", "Patzelt", "Kimmel", "Heilig", "Schneck", "Schleich", "Engelhard", "Kammer", "Hölzer",
			"Berberich", "Weisser", "Siemer", "Renken", "Schönemann", "Möllers", "Blohm", "Treiber", "Reil", "Bienert", "Schultes",
			"Heinlein", "Stegmaier", "Israel", "Zell", "Bichler", "Mengel", "Lucht", "Kamps", "Wittwer", "Prause", "Helbing", "Gaul",
			"Bröker", "Dunker", "Bechtel", "Zettl", "Döhler", "Kück", "Heintz", "Birke", "Nies", "Vieth", "Pingel", "Haubold", "Brust",
			"Krell", "Heinicke", "Breyer", "Kinzel", "Breunig", "Oehme", "Diederichs", "Sacher", "Rütten", "Niemeier", "Ketterer",
			"Jasper", "Weidinger", "Sohn", "Schöler", "Rudloff", "Nehls", "Grieger", "Burg", "Wölk", "Spitz", "Schöner", "Mück",
			"Böhringer", "Ruck", "Holzwarth", "Riehl", "Wollmann", "Laub", "Klaiber", "Weck", "Rutz", "Büchel", "Brandner", "Klages",
			"Henseler", "Zinn", "Nagler", "Mang", "Lex", "Bangert", "Wurst", "Philipps", "Leupold", "Raith", "Joachim", "Haberkorn",
			"Dickmann", "Gellert", "Greger", "Diel", "Hollstein", "Wilhelmi", "Schümann", "Jüttner", "Höller", "Graßl", "Derksen",
			"Brennecke", "Tremmel", "Götte", "Schardt", "Koppe", "Gutjahr", "Burkhard", "Berens", "Hommel", "Gaida", "Piontek", "Stief",
			"Spiller", "Prager", "Kiesewetter", "Brix", "Temme", "Schepers", "Landmann", "Jünger", "Gaus", "Appelt", "Neuberger", "Helmer",
			"Rohleder", "Pawlik", "Angermann", "Kirchhof", "Birkholz", "Steigerwald", "Möhle", "Schönberg", "Lichtenberg", "Hennings",
			"Dannenberg", "Benning", "Wanke", "Schnur", "Rauer", "Lesch", "Häcker", "Blome", "Oberländer", "Kürschner", "Führer", "Edler",
			"Kröll", "Hofstetter", "Peukert", "Frech", "Fisch", "Werle", "Greb", "Papke", "Krey", "Hohn", "Gassner", "Buse", "Wölfle",
			"Senft", "Schlag", "Karger", "Göring", "Glock", "Tietjen", "Sautter", "Beutler", "Guse", "Weinrich", "Heldt", "Gutzeit",
			"Tews", "Schaar", "Oßwald", "Mitschke", "Meinke", "Staub", "Hase", "Dold", "Traut", "Ney", "Stoffel", "Siefert", "Jablonski",
			"Brettschneider", "Zach", "Kehrer", "Heinke", "Selle", "Schipper", "Pongratz", "Kost", "Kienzle", "Findeisen", "Häberle",
			"Habel", "Eibl", "Asmus", "Wege", "Korth", "Fast", "Roßbach", "Vaupel", "Tempel", "Sowa", "Häfele", "Zitzmann", "Fleischhauer",
			"Eitel", "Jüngling", "Jauch", "Ganter", "Sebastian", "Schlemmer", "Wöhrle", "Wolfrum", "Schüttler", "Schmidl", "Kämpf",
			"Seliger", "Neumeister", "Mittelstädt", "Ender", "Wicke", "Diefenbach", "Schlesinger", "Scheerer", "Pawlowski", "Flaig",
			"Scheu", "Lambertz", "Grünberg", "Baumert", "Hund", "Gohlke", "Bracht", "Willer", "Kuck", "Finkbeiner", "Nadler", "Emmert",
			"Mildner", "Ammon", "Abels", "Schrade", "Rolle", "Hennecke", "Heidt", "Thormann", "Saller", "Hausner", "Dierkes", "Redlich",
			"Edel", "Dorner", "Schwenke", "Reber", "Markgraf", "Herb", "Bartmann", "Walch", "Stöber", "Neef", "Anger", "Stobbe",
			"Klingenberg", "Hotz", "Wittich", "Behm", "Haberl", "Weyand", "Wenig", "Siekmann", "Haustein", "Staudinger", "Schmoll",
			"Rößner", "Genz", "Frühauf", "Fellner", "Coenen", "Bohlen", "Berlin", "Sperlich", "Breidenbach", "Schwinn", "Zipfel", "Mainka",
			"Vögele", "Trommer", "Runkel", "Rohmann", "Moog", "Kehr", "Deininger", "Thimm", "Hauk", "Weißer", "Ladwig", "Scheler",
			"Jünemann", "Heber", "Gessner", "Göller", "Fix", "Eckart", "Karle", "Rohrbach", "Messer", "Kölling", "Hieber", "Dinter",
			"Hauber", "Denecke", "Dettmann", "Wenzl", "Siemens", "Rebmann", "Huppertz", "Theiß", "Seewald", "Lay", "Meuser", "Erben",
			"Blau", "Röser", "Köppel", "Schurig", "Peetz", "Störmer", "Hümmer", "Engert", "Pietschmann", "Merkl", "Büsing", "Orlowski",
			"Langhammer", "Kirst", "Hildenbrand", "Sieger", "Schulten", "Theil", "Leinweber", "Krapf", "Strauss", "Pitz", "Blumenthal",
			"Großkopf", "Fels", "Schaible", "Röhm", "Piotrowski", "Stemmler", "Reinicke", "Pflaum", "Hemmer", "Saur", "Limbach", "Sorge",
			"Russ", "Rhein", "Ostendorf", "Topp", "Krafft", "Giebel", "Daniels", "Bohr", "Hassel", "Schenke", "Hochmuth", "Rombach",
			"Niggemann", "Jungbluth", "Feldhaus", "Janson", "Hüther", "Tauber", "Neher", "Moor", "Behrmann", "Sager", "Thielemann",
			"Stumm", "Meusel", "Feiler", "Stauch", "Pfeuffer", "Niermann", "Lüdecke", "Seelig", "Kissel", "Eifler", "Bünger",
			"Blankenburg", "Rohe", "Prüfer", "Herget", "Grunewald", "Laumann", "Schwanke", "Maack", "Leibold", "Heinzel", "Dieterich",
			"Naß", "Haider", "Beetz", "Sauermann", "Böning", "Schroer", "Heiser", "Tolksdorf", "Strohmeier", "Happel", "Graß",
			"Gottschling", "Gotthardt", "Achatz", "Wohlfarth", "Vollrath", "Liebe", "Szymanski", "Mertes", "Knödler", "Heppner", "Demmer",
			"Alex", "Tappe", "Storck", "Köppl", "Hertlein", "Wiesmann", "Mies", "Kuntze", "Köcher", "Kaluza", "Fick", "Weniger", "Spieker",
			"Schnoor", "Bamberger", "Middendorf", "Heßler", "Haus", "Hackmann", "Eichholz", "Woll", "Kromer", "Brack", "Schnitzer",
			"Pietzsch", "Milz", "Liese", "Karcher", "Bendel", "Adolf", "Strehl", "Gaßner", "Thielmann", "Speicher", "Michler",
			"Matthiesen", "Bergen", "Schaffner", "Pausch", "Kastl", "Goertz", "Bruckner", "Steinkamp", "Heizmann", "Ruge", "Rahm", "Poth",
			"Kortmann", "Egner", "Rempel", "Kolberg", "Burkhart", "Plöger", "Irmer", "Würfel", "Löwen", "Tröster", "Stöckel", "Niehues",
			"Münz", "Kruppa", "Teubner", "Brinker", "Brucker", "Stoiber", "Fritzsch", "Sieben", "Rieke", "Schroll", "Winzer", "Thomann",
			"Schönborn", "Quade", "Gruhn", "Gottfried", "Basler", "Rödiger", "Dück", "Kügler", "Kleinhans", "Freiberg", "Weishaupt",
			"Nolting", "Geissler", "Majewski", "Weihrauch", "Hendricks", "Grätz", "Wesemann", "Geib", "Weißmann", "Dewald", "Bachmeier",
			"Saathoff", "Hüls", "Haußmann", "Grabow", "Seyfarth", "Hense", "Sperl", "Rosendahl", "Lembke", "Jesse" };

}
