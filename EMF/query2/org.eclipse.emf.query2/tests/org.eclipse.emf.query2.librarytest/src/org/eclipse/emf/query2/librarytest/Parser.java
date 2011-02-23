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
		String pathName = "platform:/plugin/org.eclipse.emf.query2.librarytest/data/publisher/dpunkt.xmi"; //$NON-NLS-1$
		Resource r = rs.createResource(URI.createURI(pathName, true));
		loadPersons(rs, resources);
		loadLibraries(rs, resources);
	}

	private void loadLibraries(ResourceSet rs, Map<String, Resource> resources) {
		for (int i = 0; i < cities.length; i++) {
			String city = cities[i];
			String pathName = "platform:/plugin/org.eclipse.emf.query2.librarytest/data/library/" //$NON-NLS-1$
					+ city + ".xmi"; //$NON-NLS-1$
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
			String pathName = "platform:/plugin/org.eclipse.emf.query2.librarytest/data/library/" + city + ".xmi"; //$NON-NLS-1$ //$NON-NLS-2$
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
		pathName=pathName.replaceAll("�", "oe");  //$NON-NLS-1$//$NON-NLS-2$
		pathName=pathName.replaceAll("�", "Oe");  //$NON-NLS-1$//$NON-NLS-2$
		pathName=pathName.replaceAll("�", "ue");  //$NON-NLS-1$//$NON-NLS-2$
		pathName=pathName.replaceAll("�", "Ue");  //$NON-NLS-1$//$NON-NLS-2$
		pathName=pathName.replaceAll("�", "ae");  //$NON-NLS-1$//$NON-NLS-2$
		pathName=pathName.replaceAll("�", "Ae");  //$NON-NLS-1$//$NON-NLS-2$
		pathName=pathName.replaceAll(",", "-");  //$NON-NLS-1$//$NON-NLS-2$
		pathName=pathName.replaceAll(" ", "");  //$NON-NLS-1$//$NON-NLS-2$
		pathName=pathName.replaceAll("�", "a");  //$NON-NLS-1$//$NON-NLS-2$
		pathName=pathName.replaceAll("�", "o");  //$NON-NLS-1$//$NON-NLS-2$
		pathName=pathName.replaceAll("�", "i");  //$NON-NLS-1$//$NON-NLS-2$
		pathName=pathName.replaceAll("�", "e");  //$NON-NLS-1$//$NON-NLS-2$
		pathName=pathName.replaceAll("'", "");  //$NON-NLS-1$//$NON-NLS-2$
		pathName=pathName.replaceAll("\\(.*\\)", "");  //$NON-NLS-1$//$NON-NLS-2$
		Resource r = rs.createResource(URI.createURI(
				pathName, true));
		return r;
	}

	private Publisher createManuscriptsAndAuthors(ResourceSet rs, Map<String, Person> authors, Map<String, Resource> resources)
			throws FileNotFoundException, IOException {
		LineNumberReader lnr = new LineNumberReader(new FileReader("katalog.TAB")); //$NON-NLS-1$
		String line = null;

		Publisher dpunkt = LibraryFactory.eINSTANCE.createPublisher();
		dpunkt.setName("DPunkt"); //$NON-NLS-1$

		while ((line = lnr.readLine()) != null) {
			Manuscript currentBook = LibraryFactory.eINSTANCE.createManuscript();
			dpunkt.getManuscripts().add(currentBook);
			StringTokenizer st = new StringTokenizer(line, "\t"); //$NON-NLS-1$
			while (st.hasMoreElements()) {
				String s = (String) st.nextElement();
				int indexOf = s.indexOf(':');
				if (indexOf < 10)
					continue;
				String key = s.substring(10, indexOf);
				if (key.equalsIgnoreCase("TITEL")) { //$NON-NLS-1$
					currentBook.setTitle(s.substring(indexOf + 1).trim());
				}
				if (key.equalsIgnoreCase("SEITENZAHL")) { //$NON-NLS-1$
					try {
						Integer pages = Integer.valueOf(s.substring(indexOf + 1).trim());
						currentBook.setPages(pages);
					} catch (Exception e) {
						// ignore
					}
				}
				if (key.equalsIgnoreCase("EINBAND")) { //$NON-NLS-1$
					currentBook.setFormat(s.substring(indexOf + 1).trim().equals("HC") ? Format.HARDCOVER : Format.SOFTCOVER); //$NON-NLS-1$
				}
				if (key.equalsIgnoreCase("AUTOR")) { //$NON-NLS-1$
					String trim = s.substring(indexOf + 1).trim();
					StringTokenizer authorSt = new StringTokenizer(trim, "/"); //$NON-NLS-1$
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

		String pathName = "org.eclipse.emf.query2.syntax.librarytest/data/publisher/dpunkt.xmi"; //$NON-NLS-1$
		Resource dpunktRes = getResource(rs, pathName);
		dpunktRes.getContents().add(dpunkt);
		return dpunkt;
	}

	private Resource getResourceForPerson(ResourceSet rs, Map<String, Resource> resources, String firstChar) {
		Resource r;
		String c = firstChar.toUpperCase();
		if ((r = resources.get(c)) == null) {
			String pathName = "platform:/plugin/org.eclipse.emf.query2.librarytest/data/person/" + c + ".xmi"; //$NON-NLS-1$ //$NON-NLS-2$
			r = getResource(rs, pathName);
			resources.put(c, r);
		}
		return r;
	}

	String[] cities = { "Mumbai (Bombay)", "Karatschi", "Istanbul", "Delhi", "Seoul", "Sao Paulo", "Moskau", "Shanghai", "Lagos",        //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$
			"Mexiko-Stadt", "Jakarta", "Tokio", "New York", "Kinshasa", "Kairo", "Teheran", "Peking", "London", "Hongkong", "Lima",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$
			"Bogot�", "Lahore", "Dhaka", "Bangkok", "Rio de Janeiro", "Bagdad", "Bengaluru (Bangalore)", "Ho-Chi-Minh-Stadt (Saigon)",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$
			"Santiago de Chile", "Kolkata (Kalkutta)", "Rangun", "Ankara", "Chennai (Madras)", "Wuhan", "Riad",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$
			"Sankt Petersburg (Leningrad)", "Chongqing", "Chengdu", "Xi'an", "Los Angeles", "Ahmedabad", "Alexandria", "Sydney", "Tianjin",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$
			"Abidjan", "Busan", "Hyderabad", "Kano", "Singapur", "Yokohama", "Ibadan", "Shenyang", "Berlin", "Melbourne", "Durban", //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$
			"Harbin", "Johannesburg", "Madrid", "Surat", "Pune", "Guangzhou", "Nanjing", "Kanpur", "Omdurman", "Casablanca", "Jaipur",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$
			"Pj�ngjang", "Chicago", "Addis Abeba", "Dschidda", "Luanda", "Nairobi", "Buenos Aires", "Taiyuan", "Salvador da Bahia",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$
			"Daressalam", "Kiew", "Osaka", "Taipeh", "Lakhnau", "Faisalabad", "Incheon", "Daegu", "Izmir", "Rom", "Changchun", "Toronto",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Quezon City", "Gizeh", "Kabul", "Sana'a", "Kapstadt", "Belo Horizonte", "Surabaya", "Nagpur", "Fortaleza", "Maschhad", "Cali",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$
			"Santo Domingo", "Nagoya", "Houston", "Havanna", "Paris", "Guayaquil", "Chittagong", "Khartum", "Changsha", "Jinan", "Mosul",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$
			"Dalian", "Basra", "Zhengzhou", "Dakar", "Shijiazhuang", "Taschkent", "Indore", "Accra", "Medell�n", "Maracaibo", "Yaound�",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$
			"Douala", "Jilin", "Sapporo", "Hangzhou", "Bukarest", "Nanchang", "Caracas", "Ecatepec de Morelos", "Rawalpindi", "Hamburg",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
			"Medan", "Minsk", "Patna", "Curitiba", "Warschau", "Budapest", "Soweto", "Wien", "Bhopal", "Brisbane", "Bandung", "Tsingtao",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Guadalajara", "al-Chartum Bahri", "Aleppo", "Ludhiana", "Rabat", "Montreal", "Bekasi", "Pretoria", "Barcelona", "Thane",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
			"Manaus", "Tangshan", "Kaduna", "Damaskus", "Manila", "Phoenix", "Isfahan", "Harare", "Kobe", "Agra", "Algier", "Quito",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Kaohsiung", "�r�mqi", "Recife", "Daejeon", "Kyoto", "Multan", "Kumasi", "Philadelphia", "Charkiw", "Vadodara", "Bursa",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$
			"Kuala Lumpur", "Pimpri-Chinchwad", "Karadsch", "Caloocan", "Tangerang", "Hanoi", "T�bris", "Gujranwala", "Nowosibirsk",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$
			"Lanzhou", "Hyderabad", "Gwangju", "Faridabad", "Bel�m", "Ciudad Ju�rez", "Fushun", "Fukuoka", "Conakry", "Puebla",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
			"Antananarivo", "Luoyang", "Hefei", "Valencia", "Makassar", "Tijuana", "Lubumbashi", "Porto Alegre", "Santa Cruz de la Sierra",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$
			"M�nchen", "Handan", "Kampala", "Suzhou", "Shantou", "Barranquilla", "San Antonio", "Davao City", "Kawasaki", "C�rdoba",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
			"Depok", "Phnom Penh", "La Matanza", "Mailand", "Bamako", "Mekka", "Nashik", "Jekaterinburg (Swerdlowsk)", "Semarang",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$
			"Nischni Nowgorod (Gorki)", "Baotou", "Adana", "Montevideo", "Lusaka", "San Diego", "Kalyan-Dombivli", "Palembang", "Peshawar",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$
			"Beirut", "Schiraz", "Suwon", "Dallas", "Port-au-Prince", "Perth", "Nezahualc�yotl", "Mogadischu", "Merath", "Amman",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
			"Mandalay", "Almaty", "Anshan", "Xuzhou", "Ghaziabad", "Goyang", "Baku", "Maputo", "Prag", "Fuzhou", "Rajkot", "Saitama",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Guiyang", "Goiania", "Guarulhos", "Varanasi", "Sofia", "Hiroshima", "Tripolis", "Port Harcourt", "Managua", "Brazzaville",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
			"Dubai", "Samara (Kujbyschew)", "Omsk", "Benin-Stadt", "Monterrey", "Le�n", "Belgrad", "Maiduguri", "Wuxi", "Kasan",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
			"Gaziantep", "Eriwan", "Amritsar", "Rostow am Don", "Allahabad", "Visakhapatnam", "Tscheljabinsk", "Datong", "Tiflis",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$
			"Xianyang", "Ufa", "Dnipropetrowsk", "Seongnam", "Campinas", "Ouagadougou", "Jabalpur", "Ulan Bator", "Haora", "Huainan",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
			"Sendai", "Kunming", "Taichung", "Adelaide", "Aurangabad", "Qom", "Wolgograd (Stalingrad)", "Odessa", "Shenzhen", "Rongcheng",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
			"Birmingham", "Neapel" };  //$NON-NLS-1$//$NON-NLS-2$

	String[] personLastNames = { "M�ller", "Schmidt", "Schneider", "Fischer", "Weber", "Meyer", "Wagner", "Becker", "Schulz", "Hoffmann",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
			"Sch�fer", "Bauer", "Koch", "Richter", "Klein", "Wolf", "Schr�der", "Neumann", "Schwarz", "Braun", "Hofmann", "Zimmermann",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Schmitt", "Hartmann", "Kr�ger", "Schmid", "Werner", "Lange", "Schmitz", "Meier", "Krause", "Maier", "Lehmann", "Huber",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Mayer", "Herrmann", "K�hler", "Walter", "K�nig", "Schulze", "Fuchs", "Kaiser", "Lang", "Wei�", "Peters", "Scholz", "Jung",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"M�ller", "Hahn", "Keller", "Vogel", "Schubert", "Roth", "Frank", "Friedrich", "Beck", "G�nther", "Berger", "Winkler",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Lorenz", "Baumann", "Schuster", "Kraus", "B�hm", "Simon", "Franke", "Albrecht", "Winter", "Ludwig", "Martin", "Kr�mer",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Schumacher", "Vogt", "J�ger", "Stein", "Otto", "Gro�", "Sommer", "Haas", "Graf", "Heinrich", "Seidel", "Schreiber", "Ziegler",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Brandt", "Kuhn", "Schulte", "Dietrich", "K�hn", "Engel", "Pohl", "Horn", "Sauer", "Arnold", "Thomas", "Bergmann", "Busch",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Pfeiffer", "Voigt", "G�tz", "Seifert", "Lindner", "Ernst", "H�bner", "Kramer", "Franz", "Beyer", "Wolff", "Peter", "Jansen",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Kern", "Barth", "Wenzel", "Hermann", "Ott", "Paul", "Riedel", "Wilhelm", "Hansen", "Nagel", "Grimm", "Lenz", "Ritter", "Bock",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$ //$NON-NLS-14$
			"Langer", "Kaufmann", "Mohr", "F�rster", "Zimmer", "Haase", "Lutz", "Kruse", "Jahn", "Schumann", "Fiedler", "Thiel", "Hoppe",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Kraft", "Michel", "Marx", "Fritz", "Arndt", "Eckert", "Sch�tz", "Walther", "Petersen", "Berg", "Schindler", "Kunz", "Reuter",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Sander", "Schilling", "Reinhardt", "Frey", "Ebert", "B�ttcher", "Thiele", "Gruber", "Schramm", "Hein", "Bayer", "Fr�hlich",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ 
			"Vo�", "Herzog", "Hesse", "Maurer", "Rudolph", "Nowak", "Geiger", "Beckmann", "Kunze", "Seitz", "Stephan", "B�ttner", "Bender",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$ 
			"G�rtner", "Bachmann", "Behrens", "Scherer", "Adam", "Stahl", "Steiner", "Kurz", "Dietz", "Brunner", "Witt", "Moser", "Fink",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$ 
			"Ullrich", "Kirchner", "L�ffler", "Heinz", "Schultz", "Ulrich", "Reichert", "Schwab", "Breuer", "Gerlach", "Brinkmann",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"G�bel", "Blum", "Brand", "Naumann", "Stark", "Wirth", "Schenk", "Binder", "K�rner", "Schl�ter", "Rieger", "Urban", "B�hme",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Jakob", "Schr�ter", "Krebs", "Wegner", "Heller", "Kopp", "Link", "Wittmann", "Unger", "Reimann", "Ackermann", "Hirsch",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ 
			"Schiller", "D�ring", "May", "Bruns", "Wendt", "Wolter", "Menzel", "Pfeifer", "Sturm", "Buchholz", "Rose", "Mei�ner",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ 
			"Janssen", "Bach", "Engelhardt", "Bischoff", "Bartsch", "John", "Kohl", "Kolb", "M�nch", "Vetter", "Hildebrandt", "Renner",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ 
			"Weiss", "Kiefer", "Rau", "Hinz", "Wilke", "Gebhardt", "Siebert", "Baier", "K�ster", "Rohde", "Will", "Fricke", "Freitag",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$ 
			"Nickel", "Reich", "Funk", "Linke", "Keil", "Hennig", "Witte", "Stoll", "Schreiner", "Held", "Noack", "Br�ckner", "Decker",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Neubauer", "Westphal", "Heinze", "Baum", "Sch�n", "Wimmer", "Marquardt", "Stadler", "Schlegel", "Kremer", "Ahrens", "Hammer",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ 
			"R�der", "Pieper", "Kirsch", "Fuhrmann", "Henning", "Krug", "Popp", "Conrad", "Karl", "Krieger", "Mann", "Wiedemann", "Lemke",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$ 
			"Erdmann", "Mertens", "He�", "Esser", "Hanke", "Strau�", "Miller", "Berndt", "Konrad", "Jacob", "Philipp", "Metzger", "Henke",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$ 
			"Wiese", "Hauser", "Dittrich", "Albert", "Klose", "Bader", "Herbst", "Henkel", "Kr�ger", "Wahl", "Bartels", "Harms", "Fritsch",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Adler", "Gro�mann", "Burger", "Schrader", "Probst", "Martens", "Baur", "Burkhardt", "Hess", "Mayr", "Nolte", "Heine",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ 
			"Kuhlmann", "Klaus", "K�hne", "Kluge", "Bernhardt", "Blank", "Hamann", "Steffen", "Brenner", "Rauch", "Reiter", "Preu�",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Jost", "Wild", "Hummel", "Beier", "Krau�", "Lindemann", "Herold", "Christ", "Niemann", "Funke", "Haupt", "Jan�en", "Vollmer",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Straub", "Strobel", "Wiegand", "Merz", "Haag", "Holz", "Knoll", "Zander", "Rausch", "Bode", "Beer", "Betz", "Anders",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$ 
			"Wetzel", "Hartung", "Glaser", "Fleischer", "Rupp", "Reichel", "Lohmann", "Diehl", "Jordan", "Eder", "Rothe", "Weis",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ 
			"Heinemann", "D�rr", "Metz", "Kroll", "Freund", "Wegener", "Hohmann", "Gei�ler", "Sch�ler", "Schade", "Raab", "Feldmann",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ 
			"Zeller", "Neubert", "Rapp", "Kessler", "Heck", "Meister", "Stock", "R�mer", "Seiler", "Altmann", "Behrendt", "Jacobs", "Mai",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$ 
			"B�r", "Wunderlich", "Sch�tte", "Lauer", "Benz", "Weise", "V�lker", "Sonntag", "B�hler", "Gerber", "Kellner", "Bittner",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ 
			"Schweizer", "Ke�ler", "Hagen", "Wieland", "Born", "Merkel", "Falk", "Busse", "Gross", "Eichhorn", "Greiner", "Moritz",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ 
			"Forster", "Stumpf", "Seidl", "Scharf", "Hentschel", "Buck", "Voss", "Hartwig", "Heil", "Eberhardt", "Oswald", "Lechner",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ 
			"Block", "Heim", "Steffens", "Weigel", "Pietsch", "Brandl", "Schott", "Gottschalk", "Bertram", "Ehlers", "Fleischmann",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"Albers", "Weidner", "Hiller", "Seeger", "Geyer", "J�rgens", "Baumgartner", "Mack", "Schuler", "Appel", "Pape", "Dorn", "Wulf",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Opitz", "Wiesner", "Hecht", "Moll", "Gabriel", "Auer", "Engelmann", "Singer", "Neuhaus", "Giese", "Sch�tze", "Geisler", "Ruf",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Heuer", "Noll", "Scheffler", "Sauter", "Reimer", "Klemm", "Schaller", "Hempel", "Kretschmer", "Runge", "Springer", "Riedl",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ 
			"Steinbach", "Michels", "Barthel", "Pfaff", "Kohler", "Zahn", "Radtke", "Neugebauer", "Hensel", "Winkelmann", "Gebauer",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"Engels", "Wichmann", "Eichler", "Schnell", "Weller", "Br�ggemann", "Scholl", "Timm", "Siegel", "Heise", "R�sch", "B�rger",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Hinrichs", "Stolz", "Walz", "Specht", "Dick", "Geier", "Volk", "Junker", "Prinz", "Otte", "Schick", "Klotz", "Haller",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Rother", "Koller", "B�rner", "Thoma", "Drescher", "Kempf", "Schirmer", "Faber", "Frenzel", "Uhlig", "Schnabel", "Wirtz",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ 
			"D�rr", "Kranz", "Kasper", "Hausmann", "Hagemann", "Gerhardt", "Lux", "Fries", "Haug", "Endres", "Maas", "Sch�rmann", "Eberle",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$ 
			"Knapp", "Eggert", "Brauer", "Finke", "Paulus", "Petzold", "Hauck", "Rath", "Elsner", "Dreyer", "Sievers", "Faust", "Dittmann",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Wehner", "Kilian", "Sattler", "Reichelt", "Langner", "Rabe", "Bremer", "Abel", "P�tz", "Wittig", "K�hl", "Schober", "Maa�",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Cordes", "Uhl", "Kahl", "Korn", "Harder", "Bernhard", "Ullmann", "Thieme", "Klinger", "Bohn", "Biermann", "Vogl", "Sch�tt",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Schaefer", "Kemper", "Knorr", "Michaelis", "Gro�e", "Gerdes", "St�hr", "Hartl", "Lehner", "Mielke", "Eggers", "Schaaf",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Sieber", "Melzer", "Behr", "Weiler", "Lippert", "Eckhardt", "H�fer", "Fritzsche", "Helbig", "Theis", "Schlosser", "Leonhardt",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Ries", "Reinhold", "Rademacher", "Evers", "Rudolf", "Rost", "Horstmann", "Hecker", "Dreher", "Pilz", "Junge", "Ehrhardt",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Matthes", "Klug", "Kunkel", "Steinmetz", "Heitmann", "Bahr", "Augustin", "H�hne", "Hering", "Hellmann", "Hildebrand",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"Trautmann", "Amann", "Heinrichs", "H�hn", "Heimann", "L�ck", "Nitsche", "Sprenger", "Vogler", "Claus", "Jensen", "Blume",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ 
			"Drews", "Damm", "Hofer", "Kurth", "Groth", "Janke", "Heilmann", "Hellwig", "Just", "Wacker", "Huth", "Jahnke", "Strauch",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$ 
			"Stenzel", "B�hmer", "Hertel", "Hornung", "G�tze", "Reinhard", "Ruppert", "Lau", "Renz", "Sperling", "Teichmann", "Sch�nfeld",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Sp�th", "Hafner", "Alt", "Borchert", "Rehm", "Pohlmann", "Pfister", "Zink", "Roos", "Mader", "Wille", "Schroeder", "Heinen",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Lotz", "Balzer", "Schwarze", "Westermann", "Ebner", "Krieg", "Schweiger", "Bosch", "Engler", "Schleicher", "Pfeffer",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"Gehrke", "Kaminski", "Schuh", "Clemens", "Liedtke", "Wessel", "Friedrichs", "Eisele", "Kirchhoff", "Rei�", "Brockmann",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$
			"Sch�ne", "Frick", "Ulbrich", "Trapp", "R��ler", "Hoyer", "Thomsen", "Scheer", "Wagener", "Starke", "Korte", "Baumeister",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Kretzschmar", "Veit", "Grote", "Sachs", "Nitschke", "Bartel", "Schwarzer", "Hampel", "Bischof", "Schweitzer", "Seemann",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"Grau", "Lehnert", "Orth", "S��", "Loos", "Stiller", "Henze", "Lohse", "K�ster", "Baumg�rtner", "Oppermann", "Brendel",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ 
			"Kirschner", "Sch�ller", "Wendel", "Burmeister", "Kastner", "Daniel", "Menke", "Seibert", "Widmann", "David", "Reitz",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"K�hnel", "Diekmann", "Steinert", "Klatt", "W�rner", "Wolters", "F�rst", "Lampe", "Heckmann", "Wilde", "Buchner", "Becher",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ 
			"Heider", "Grundmann", "Schwabe", "Hager", "Buschmann", "Keck", "M�hlbauer", "Schauer", "Petri", "R�hl", "Eckstein", "Schatz",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ 
			"Kolbe", "Kling", "Knobloch", "Otten", "Muth", "Reinke", "Baumgart", "Horst", "Doll", "Kugler", "Gl�ser", "Stange", "Tietz",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Schell", "Br�ning", "Helm", "Hacker", "Cremer", "Riemer", "Behnke", "Heyer", "Reiser", "Steinke", "Ostermann", "B�chner",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ 
			"H�usler", "Jacobi", "Heuser", "Obermeier", "Herr", "K�bler", "Spies", "Spindler", "Schmidtke", "Hermes", "Kreuzer", "Kock",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ 
			"Stamm", "Pauli", "Ewald", "Hagedorn", "Kersten", "Weiland", "Resch", "Neu", "Pabst", "Kleine", "Gr�n", "Janzen", "Berthold",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Apel", "L�hr", "Jakobs", "Friedl", "Ehlert", "Bastian", "Volz", "Fritsche", "Cramer", "Weinert", "Frisch", "Grund", "Wilms",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$ 
			"Scheller", "Enders", "Mahler", "Brandes", "Hamm", "Wieczorek", "Burghardt", "Schwartz", "Thies", "Br�ck", "Stern", "Lukas",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Rode", "Hanisch", "Lauterbach", "Gehrmann", "Yilmaz", "Adams", "Henn", "Merten", "Gottwald", "Petry", "Gehring", "Hack",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Niemeyer", "Backhaus", "Rupprecht", "Heidrich", "Heidenreich", "Mende", "Volkmann", "Hille", "Herz", "B�ttger", "Knauer",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"K�rber", "Baumgarten", "Bucher", "Schaub", "Michael", "Eckardt", "Lerch", "Jonas", "Rahn", "Budde", "R�sler", "Hannemann",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Seidler", "Schiffer", "Sachse", "Ochs", "Brehm", "Hillebrand", "Hardt", "Zeidler", "W�st", "K�pper", "Ebeling", "H�lscher",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Gr�newald", "Kowalski", "Thiemann", "Reis", "Welsch", "Schultze", "Sailer", "Haack", "Ortmann", "Meurer", "Ebel", "Seibel",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Kellermann", "K�hn", "Tiedemann", "Kunert", "Br�uer", "Schaper", "Ehrlich", "Reif", "Aigner", "Wulff", "Berner", "Bormann",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Schr�er", "Armbruster", "Eilers", "Raabe", "Fichtner", "Thelen", "Bolz", "Pahl", "Mangold", "Scheel", "Kratz", "Hoch",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Backes", "Schuhmacher", "Reinecke", "Z�ller", "Johannsen", "Dieckmann", "Drechsler", "Emmerich", "Rauscher", "Post",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ 
			"Weigand", "Hill", "Andres", "W�chter", "Stratmann", "Wallner", "Spengler", "Metzner", "Merk", "Palm", "Hopf", "Dietze",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Kammerer", "Krohn", "Kleinert", "Linder", "Henrich", "Morgenstern", "Rogge", "Grube", "Grabowski", "Wurm", "Kummer", "Hoff",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Paulsen", "Ertl", "Zorn", "Petermann", "K�ppers", "Buchmann", "Dreier", "Sommerfeld", "B�hr", "Rosenberger", "Reichardt",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$
			"Reimers", "M�rz", "Heger", "Lenk", "Jaeger", "Hopp", "Habermann", "Boldt", "Schreier", "Ewert", "Pusch", "Boos", "Finger",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Christmann", "Weiser", "Wendler", "Maul", "Holzer", "Franzen", "Wachter", "Lorenzen", "Siegert", "Hollmann", "Ahlers",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"Exner", "Grunwald", "Daum", "Struck", "Sch�nberger", "Waldmann", "Kie�ling", "B�scher", "Rein", "Hock", "Holzapfel",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"K�stner", "Rasch", "L�dtke", "Homann", "Steiger", "Gr�f", "St�cker", "Strobl", "Metzler", "Fleck", "Fey", "H�rmann", "Lehr",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Arlt", "R�ckert", "Rohr", "Friese", "Fechner", "Eck", "Tillmann", "Englert", "Klee", "Steger", "B�cker", "Fiebig", "L�w",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Hermanns", "Zech", "Borchers", "Weinmann", "Rieck", "Markert", "L�cke", "Butz", "Friedel", "Aust", "M�bius", "H�rtel",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Clausen", "Deutsch", "Wessels", "Zeitler", "Heidemann", "R�hrig", "Siegmund", "Oertel", "R�diger", "Marschall", "Sch�ffer",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$
			"Henschel", "Hunger", "Sell", "Pfeil", "Goebel", "Edelmann", "Gerhard", "Rosenthal", "Rosenkranz", "Hain", "Z�llner", "K�nzel",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Kleinschmidt", "F�rber", "Schacht", "Schwenk", "R�sner", "B�ck", "T�pfer", "Gr�ner", "Spiegel", "Weigl", "Georgi", "Bruhn",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Hubert", "Holzmann", "Drexler", "Steinmann", "Groh", "Schmieder", "Kober", "Huhn", "Hinze", "Gebhard", "Zapf", "Lederer",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Birk", "Landgraf", "Raschke", "Leitner", "Sch��ler", "Kuhl", "Bosse", "Laux", "Rauh", "Christiansen", "Trost", "Reinert",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Klink", "Schuhmann", "Fabian", "Rieder", "Fromm", "Holst", "Bauch", "J�ckel", "Gutmann", "Freese", "Weigelt", "Buhl",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Steinberg", "Poppe", "Stier", "Jakobi", "Seibold", "Reiner", "Wortmann", "Luft", "Fa�bender", "Wilken", "Schmelzer",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$
			"Sch�nherr", "Maus", "Hofmeister", "Heide", "Wilkens", "Wolfram", "Stelzer", "Quast", "Bothe", "Lachmann", "Schnitzler",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"Gr�ger", "M�cke", "Liebig", "Kreutz", "Nitsch", "Gl�ck", "H�fner", "Kohn", "Wegmann", "Olbrich", "V�lkel", "Scheibe",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Herbert", "Erhardt", "Sasse", "Giesen", "Jeske", "L�bke", "Reck", "Kleemann", "Frei", "Ro�", "Stricker", "Marks", "Kamp",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Denk", "Obst", "Gl�ckner", "Winkel", "Rink", "Reese", "Baron", "Prei�", "Riemann", "Gebert", "Kayser", "H�lsmann", "S�nger",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Meinhardt", "Loch", "Storch", "Egger", "Degen", "Dittmar", "Diener", "Salzmann", "Stolle", "Zabel", "Goldmann", "Schuller",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"H�ppner", "Uhlmann", "Biedermann", "Stegemann", "Manz", "Weidemann", "Mattern", "Hamacher", "Kropp", "Sch�nfelder", "P�tzold",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"Dahmen", "Welter", "Pelz", "Pelzer", "Schmalz", "Donath", "Eichner", "Niedermeier", "Scheuermann", "Dengler", "Stork", "Hirt",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Lamprecht", "Bartl", "Ley", "Timmermann", "Strasser", "Kleiner", "Lohr", "Knecht", "Mundt", "Klassen", "Stegmann", "Pohle",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Kiel", "Rommel", "M�nster", "Bornemann", "Andresen", "Tiemann", "Stangl", "Knop", "Carl", "Merkle", "Gall", "Schild", "Hans",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Bieber", "Jankowski", "Rust", "Neumeier", "Beckers", "Greve", "Engelke", "R�ger", "Zielke", "Streit", "Lammers", "Anton",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Abraham", "Gries", "Kempe", "Franken", "Br�utigam", "Nissen", "Janz", "Reiche", "Linden", "Ring", "Luther", "Stengel",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Gabler", "Karg", "Weinhold", "Radke", "Liebl", "Ecker", "Kopf", "Danner", "Weimer", "Holl", "Welz", "Schl�sser", "Weil",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Jeschke", "Bretschneider", "Siewert", "Bartz", "Willmann", "Strecker", "Wrobel", "Jacobsen", "Wieser", "Dombrowski",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ 
			"Carstens", "Schreck", "R�cker", "H�ring", "Mager", "A�mann", "Warnecke", "Benner", "Wenz", "Deppe", "Bollmann", "Gerken",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Bott", "Hei�", "Meissner", "Eberl", "Spie�", "Matthies", "Keim", "Hauke", "Erb", "Tischer", "Kreis", "Grothe", "Ulbricht",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Senger", "Brandenburg", "Friesen", "Matz", "Vogelsang", "Hofbauer", "Manthey", "Arens", "Christoph", "Schult", "Knopp",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$
			"Dre�ler", "Brill", "Kuhnert", "Bergner", "Maiwald", "Braune", "Hoffmeister", "Aschenbrenner", "Borchardt", "Gast", "Schwan",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"Teichert", "Sack", "M�ckel", "Brune", "Wende", "Gerke", "Kress", "Kahle", "Gruner", "Spitzer", "Dietl", "Rott", "Oster",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Gerstner", "Erler", "Lucas", "Heymann", "Bu�", "Steuer", "Hirschmann", "Geis", "Dunkel", "Tr�ger", "Pauly", "Kreutzer", "Ha�",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Hauschild", "Hillmann", "Pfau", "Strack", "Eberhard", "Preis", "Kaya", "Willms", "Tietze", "Guth", "Buchwald", "Willems",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"R�hl", "Fu�", "Hartig", "W�nsch", "Huck", "Reschke", "Reith", "Jentsch", "Speck", "H�u�ler", "Rotter", "Schuldt", "Martini",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Kretschmann", "Geppert", "L�sch", "Bloch", "Koslowski", "Georg", "Sahin", "Geist", "Pagel", "Rosenberg", "Frings", "Semmler",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Hilger", "G�nter", "Dahm", "Drees", "Hauptmann", "Leopold", "Wunder", "Kre�", "Lipp", "Best", "Wendland", "Landwehr",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Melcher", "Gr�fe", "B�uerle", "Laube", "Hauer", "Kaul", "Hackl", "Mahr", "Ludewig", "Feil", "Engelbrecht", "Eich", "Grunert",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Veith", "Bruder", "Nitzsche", "Knopf", "Schlichting", "Salomon", "Bork", "Hilbert", "Arendt", "Dirks", "Blanke", "Droste",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Strunk", "Traub", "Theobald", "Eger", "Krauss", "List", "J�kel", "Zobel", "Carstensen", "Stocker", "Schiemann", "Neufeld",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Czech", "Brauner", "Wick", "Peschel", "Rettig", "L�we", "Suhr", "Grewe", "Holler", "Scheid", "Ruhland", "Reindl", "Ritz",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Grebe", "Koop", "Esch", "Meixner", "Brock", "Schall", "Rottmann", "Reusch", "Donner", "Fischbach", "Kehl", "Diedrich",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"B�hler", "Ramm", "Theisen", "Sandner", "Pfl�ger", "Buch", "Hof", "Scherf", "Henne", "Feller", "R�del", "Munz", "H�nsel",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Sandmann", "Schwaiger", "Herzig", "Ross", "Sch�nemann", "Dahl", "Zeh", "K�hner", "Kasten", "B�cker", "Rickert", "D�rfler",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Euler", "Neumaier", "Menz", "Jobst", "Rie�", "Kersting", "Thamm", "Knappe", "Gericke", "Wanner", "Kupfer", "Teuber", "G�rtz",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Wunsch", "Thiede", "Kirsten", "Schiele", "Bolte", "Kleber", "Gerhards", "Molitor", "Heid", "H�gele", "Kiesel", "Heckel",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Rusch", "Behrend", "Mattes", "Demir", "Abele", "R�ttger", "Johann", "Hug", "Baldauf", "Schoch", "Heigl", "Bl�mel", "Dr�ger",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Paschke", "Peschke", "Jungmann", "Hell", "Glas", "Staudt", "Ulmer", "Wiedmann", "Schroth", "Reu�", "Flohr", "Dorsch", "Werth",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Reichenbach", "Zenker", "Wohlgemuth", "Simons", "Celik", "Steinhauer", "Eickhoff", "Kratzer", "Hasse", "Wiemann", "Walker",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"Drewes", "Helms", "Nowack", "Montag", "D�rner", "Pesch", "Weimann", "T�rk", "Titze", "Stroh", "H�rner", "Brecht", "Althoff",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Barz", "Steinhoff", "Jessen", "Scholze", "Gr�nwald", "Kaden", "Faller", "W�nsche", "Reuther", "H�nig", "Mair", "J�rg",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"M�hring", "Haak", "Mehl", "Grohmann", "Gerth", "W�lfel", "Dammann", "Schupp", "Schad", "Markus", "Hilgers", "Blaschke",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Rosenbaum", "Borgmann", "Leicht", "Eichinger", "L�ders", "Frese", "Wrede", "Linde", "H�pfner", "Kube", "Nestler", "Joos",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Penner", "Lieb", "Schaal", "Drechsel", "Kessel", "Seiffert", "Bellmann", "Stolze", "Ruff", "Weinberger", "Schuck", "Rummel",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Seel", "Sonnenberg", "H�ttner", "Schmidbauer", "Neff", "Klement", "Wittke", "Schmiedel", "Liebscher", "Bogner", "Erhard",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"Burkert", "Boll", "Stehle", "Krings", "Baumbach", "Sch�ning", "Kohlmann", "Schwarzkopf", "Schaffer", "Mehnert", "Kreft",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"Schreiter", "Junghans", "Hilpert", "Althaus", "Messerschmidt", "Marten", "Haake", "Rech", "B�se", "Panzer", "Schlicht",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"H�fler", "K�ppen", "Eberlein", "Schillinger", "Falke", "Klos", "Belz", "Michalski", "Borowski", "Pott", "Loose", "Mauer",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Kurtz", "Taubert", "Heindl", "Mock", "Krull", "Hammerschmidt", "Hahne", "Bickel", "Rautenberg", "Koll", "H�hnel", "G�pfert",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"K�chler", "St�ckl", "Goller", "Korb", "S�llner", "Hornig", "Dressel", "Wuttke", "Schiefer", "Heinzelmann", "Rank", "Staab",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Wiebe", "Holtz", "Richert", "Frerichs", "Flemming", "Hepp", "Both", "Degenhardt", "Lippmann", "Utz", "Kittel", "Eckl",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Yildirim", "Schmied", "K�pke", "Gei�", "Dohmen", "Zielinski", "Kautz", "Burmester", "Bluhm", "Krone", "Thiem", "Kindler",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Potthoff", "Mueller", "Bell", "Aydin", "Straube", "Klar", "Riegel", "Reichmann", "Kluth", "Dittmer", "Welzel", "K�mmel",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Holland", "B�cker", "Imhof", "Lewandowski", "Beckert", "Schreyer", "Ehret", "Ruppel", "Kaczmarek", "Wiegmann", "Feige",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"Tr�ger", "Buss", "Brugger", "Assmann", "Olschewski", "Meinert", "Gundlach", "Zacharias", "Stra�er", "Risse", "Pauls", "Heins",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Stelter", "Speer", "Bier", "Teske", "Knebel", "Hufnagel", "Mewes", "Windisch", "Warnke", "Frost", "Volkmer", "Schwind",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Reisinger", "Debus", "Bopp", "Schill", "Bley", "Mischke", "B�hnke", "Meinecke", "Flach", "G�nzel", "Klier", "Bausch",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Teufel", "Br�hl", "Schulthei�", "Oehler", "Hallmann", "Stich", "Meisel", "Krumm", "H�nel", "Rathmann", "Leistner", "Domke",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Sigl", "Wenk", "Weigert", "Laue", "Schlecht", "Reiners", "Krenz", "Baer", "Kirstein", "Bu�mann", "Ganz", "R�ssler", "Dietzel",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Karsten", "Sch�fers", "B�ckmann", "P�hlmann", "Kampmann", "Yildiz", "Borrmann", "K�hler", "Kettner", "Kollmann", "Platz",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"Feist", "Weyer", "Oldenburg", "Niehaus", "K�lbl", "Weinzierl", "Gutsche", "Dressler", "Zuber", "Buhr", "Garbe", "Swoboda",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Moos", "Kr�ner", "Holzner", "Abt", "Reichl", "Nielsen", "Schanz", "Pollmann", "Hipp", "Schimmel", "Thielen", "Schultheis",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Nebel", "Steininger", "J�rgensen", "Zinke", "Behringer", "Wald", "Matzke", "Stiegler", "Schmuck", "Dobler", "B�rkle",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"Rasche", "Eller", "Bade", "Stenger", "Knuth", "Seufert", "Jehle", "Sa�", "Roller", "Taube", "Linnemann", "Neuner", "Neuber",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Mathes", "Fetzer", "R�hr", "Knauf", "Holstein", "Haufe", "Fleckenstein", "Risch", "Philippi", "Merker", "Kerber", "Weitzel",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Scheuer", "Klenk", "Keppler", "�zdemir", "Ostermeier", "Tesch", "Steck", "Knoop", "Kircher", "Ehmann", "Knoblauch", "�zt�rk",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"R�hle", "Koopmann", "Leuschner", "Laufer", "Schorn", "Friebe", "Mark", "Knabe", "Leber", "Lauber", "St�rmer", "Putz",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"N�gele", "Meiners", "Weidlich", "P�schel", "Beermann", "Sippel", "Schalk", "Reger", "Heumann", "Stang", "Z�hlke", "Milde",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Kindermann", "Weing�rtner", "Harnisch", "Groll", "Waibel", "Grosch", "Priebe", "Wellmann", "Marek", "Freier", "Schie�l",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"Kelm", "Hetzel", "Langen", "Kusch", "Hild", "Grosser", "Fehr", "Ge�ner", "Bruch", "Bohne", "Duda", "Tewes", "Stockmann",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Roscher", "Sievert", "Deckert", "Bethke", "Kirch", "Kraemer", "G�rtler", "Sperber", "Valentin", "R�ter", "Lippold", "Beil",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Schorr", "Kind", "Ziemann", "Wiechmann", "Schuchardt", "Kuntz", "Burkart", "Holtmann", "Welker", "Leipold", "Kistner",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"Kaspar", "Griese", "Schimpf", "Schier", "Lenzen", "Polster", "Wichert", "Klumpp", "Hintze", "Staiger", "Gabel", "Balke",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Severin", "Kipp", "Dogan", "Hintz", "Goldbach", "Stecher", "Meindl", "Pflug", "Lamm", "Witzel", "Thaler", "Rumpf", "Demuth",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Plank", "Pick", "Obermaier", "Kloos", "Deutschmann", "Bongartz", "Biehl", "L�ser", "Teschner", "Roloff", "Kahlert", "Lietz",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Distler", "Breitenbach", "Thoms", "Kloss", "Hutter", "Gaiser", "Pichler", "Krahl", "Brink", "Spielmann", "Seibt", "Kunath",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"St�ber", "Zellner", "Scholten", "Reinartz", "Ihle", "Wernicke", "Kirschbaum", "Moldenhauer", "Schuch", "Hansmann", "Burkard",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"Back", "Bitter", "Licht", "Kapp", "Stracke", "Heinisch", "Grossmann", "Weichert", "Sutter", "Matt", "Hielscher", "Clasen",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Adolph", "Steinbrecher", "Kothe", "Hey", "Grill", "Br�mmer", "Voit", "Vater", "Fuhr", "Eisenmann", "Storz", "Herwig",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Nordmann", "George", "Kappes", "Beutel", "Stender", "Kl�ckner", "Angerer", "Kast", "Fl�gel", "Gold", "Steinberger", "Heyne",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Handke", "Brose", "Stolte", "Lutter", "Roll", "Kalb", "Spangenberg", "Ilg", "Behrends", "Daub", "R�ther", "Goldschmidt",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Rinke", "Menge", "Greif", "Wehrle", "Riese", "Pries", "Lambrecht", "Gerling", "Michl", "Emrich", "Jentzsch", "Sorg", "Hundt",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Kamm", "Holzinger", "Wohlfahrt", "Knittel", "Freyer", "Wedel", "M�nch", "Offermann", "Schaarschmidt", "Kaufhold", "Wurster",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$
			"Tetzlaff", "Schug", "K�llner", "Pfisterer", "Salewski", "Schnelle", "Ertel", "Thom", "Klo�", "Epp", "Friedmann", "Fenske",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Rehberg", "Knaus", "Gr�ber", "Wittenberg", "Plate", "Mittag", "Junk", "Strube", "M�der", "K�hne", "B�umer", "Maschke",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Kuschel", "Kerner", "Herter", "Stemmer", "N�rnberger", "Nicolai", "Cla�en", "Stefan", "Puls", "Gerner", "Radermacher",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$
			"Germann", "Flick", "Zwick", "Clau�", "Wiest", "Storm", "Harrer", "L�demann", "K�gel", "Kullmann", "Sieg", "Sch�ffler",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Schenkel", "Jahns", "Dierks", "Leder", "Franzke", "Retzlaff", "Marschner", "H�lzel", "Weidmann", "Ohm", "Helfrich", "B�ker",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Reiss", "Nau", "Mehlhorn", "Lambert", "Herzberg", "Bechtold", "Dahms", "Hannig", "Biller", "Wollny", "Meiser", "Raddatz",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Blessing", "Scheidt", "Lennartz", "Kunzmann", "Falkenberg", "Naujoks", "Maa�en", "Kaltenbach", "G�hring", "Arend", "K�ppe",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"Jochum", "Rist", "Mauch", "Bernard", "Thum", "Oltmanns", "Limmer", "Gunkel", "Wall", "Niebuhr", "Leis", "Wedekind", "V�lkl",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Alber", "Weitz", "Reh", "Kerscher", "Ru�", "Hammes", "Alexander", "Andreas", "Wassermann", "Ro�mann", "Freudenberg", "Stach",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Klostermann", "Johannes", "Heinzmann", "Bertsch", "de Vries", "Greulich", "Piel", "Brosch", "Galle", "Cornelius", "Seubert",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"Plath", "Dr�ge", "Birkner", "Thome", "Nie�en", "B�umler", "Scheffel", "Sanders", "Klingler", "Eckel", "Schlenker", "Spahn",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"M�hl", "Heyn", "Grams", "Brummer", "Bacher", "Tischler", "Acker", "Hohl", "Diederich", "Knoche", "Sch�bel", "Sch�tzle",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Lind", "Krupp", "Klasen", "Klaas", "Streicher", "Scheele", "Heer", "Felber", "Schellenberg", "Heiden", "Haberland", "Rosin",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Holm", "Rump", "B�chler", "Plum", "Matheis", "H�rtl", "Frahm", "Meder", "Epple", "G�rlich", "Arslan", "Rehbein", "Freytag",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"K�tter", "Ferber", "Amend", "Mau", "Neitzel", "Lautenschl�ger", "Dahlke", "Adrian", "Scheck", "Reinsch", "Pl�tz", "Wilk",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Wenger", "Kutscher", "Kappel", "Mund", "Mandel", "Wehr", "Menges", "Zoller", "Schewe", "Zeiler", "Wehrmann", "Kutz", "H�user",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Faulhaber", "Schunk", "Bast", "Sternberg", "Kienle", "Stehr", "Mahnke", "Dill", "Achenbach", "Hartwich", "Kley", "K�lsch",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Baltes", "Selzer", "Gronau", "Pfennig", "K�hl", "Erbe", "Pech", "Hellmich", "Rolf", "K�ller", "Sch�dlich", "Mast", "Ortner",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Knoch", "Mey", "Steinborn", "Nienhaus", "Steinhauser", "Nitz", "G�hler", "Hillenbrand", "Gilles", "Eichmann", "Wiemer",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"Hirth", "Steinle", "Gregor", "Sondermann", "G�rgen", "Ringel", "Velten", "G�rner", "Griebel", "Reim", "Henninger", "Bonk",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Voges", "Bergemann", "Hammel", "Nehring", "Prange", "Klett", "Kegel", "Dillmann", "Denker", "Bitzer", "Niehoff", "H�lzl",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Sand", "Wein", "Hampe", "Bunk", "Feld", "Meinel", "Hilbig", "Hennemann", "Reineke", "G�ttler", "Bensch", "Oestreich", "Engl",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Escher", "Bartelt", "Dieterle", "Br�ckmann", "Voll", "Loibl", "Graupner", "Knott", "Franck", "Uhlemann", "Kilic",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"Blechschmidt", "K�mmerer", "Schwager", "Klinge", "Siegl", "Menne", "Burk", "Loth", "Leonhard", "K�gler", "Kick", "Zacher",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Bohl", "Boden", "Trautwein", "Heinecke", "L�ke", "Kutzner", "Benecke", "Ruhl", "Schneiders", "Kettler", "E�er", "Hagel",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Glatz", "Sch�ssler", "Matthias", "Hass", "Dettmer", "Sch�le", "Rosner", "Hinkel", "Breit", "Lanz", "Klinke", "Grafe",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Schock", "Kappler", "Hackenberg", "Grahl", "Unruh", "Gro�er", "Breu", "Hammann", "M�llmann", "H�tter", "Hegemann", "D�ll",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Lehnen", "Ehrmann", "Kracht", "Klocke", "Herber", "Gleich", "F�rtsch", "P�tzsch", "Grosse", "Gebel", "Dahlmann", "Christian",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Oberle", "K�sters", "Linz", "Scheurer", "Busche", "Wittek", "Reischl", "Wiens", "P�schl", "Preuss", "J�schke", "Mehler",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Fox", "Dudek", "Wischnewski", "Ridder", "Weiner", "Dehn", "Ostertag", "Lochner", "Stutz", "Schwerdtfeger", "Holtkamp",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"B�low", "Zieger", "Hirschfeld", "Emde", "T�lle", "Streich", "Katz", "Hinrichsen", "Hellmuth", "Reisch", "M�hle", "Reinhart",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"H�ft", "Dippel", "Schwalm", "Patzelt", "Kimmel", "Heilig", "Schneck", "Schleich", "Engelhard", "Kammer", "H�lzer",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"Berberich", "Weisser", "Siemer", "Renken", "Sch�nemann", "M�llers", "Blohm", "Treiber", "Reil", "Bienert", "Schultes",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"Heinlein", "Stegmaier", "Israel", "Zell", "Bichler", "Mengel", "Lucht", "Kamps", "Wittwer", "Prause", "Helbing", "Gaul",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Br�ker", "Dunker", "Bechtel", "Zettl", "D�hler", "K�ck", "Heintz", "Birke", "Nies", "Vieth", "Pingel", "Haubold", "Brust",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Krell", "Heinicke", "Breyer", "Kinzel", "Breunig", "Oehme", "Diederichs", "Sacher", "R�tten", "Niemeier", "Ketterer",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"Jasper", "Weidinger", "Sohn", "Sch�ler", "Rudloff", "Nehls", "Grieger", "Burg", "W�lk", "Spitz", "Sch�ner", "M�ck",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"B�hringer", "Ruck", "Holzwarth", "Riehl", "Wollmann", "Laub", "Klaiber", "Weck", "Rutz", "B�chel", "Brandner", "Klages",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Henseler", "Zinn", "Nagler", "Mang", "Lex", "Bangert", "Wurst", "Philipps", "Leupold", "Raith", "Joachim", "Haberkorn",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Dickmann", "Gellert", "Greger", "Diel", "Hollstein", "Wilhelmi", "Sch�mann", "J�ttner", "H�ller", "Gra�l", "Derksen",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"Brennecke", "Tremmel", "G�tte", "Schardt", "Koppe", "Gutjahr", "Burkhard", "Berens", "Hommel", "Gaida", "Piontek", "Stief",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Spiller", "Prager", "Kiesewetter", "Brix", "Temme", "Schepers", "Landmann", "J�nger", "Gaus", "Appelt", "Neuberger", "Helmer",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Rohleder", "Pawlik", "Angermann", "Kirchhof", "Birkholz", "Steigerwald", "M�hle", "Sch�nberg", "Lichtenberg", "Hennings",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ 
			"Dannenberg", "Benning", "Wanke", "Schnur", "Rauer", "Lesch", "H�cker", "Blome", "Oberl�nder", "K�rschner", "F�hrer", "Edler",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Kr�ll", "Hofstetter", "Peukert", "Frech", "Fisch", "Werle", "Greb", "Papke", "Krey", "Hohn", "Gassner", "Buse", "W�lfle",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Senft", "Schlag", "Karger", "G�ring", "Glock", "Tietjen", "Sautter", "Beutler", "Guse", "Weinrich", "Heldt", "Gutzeit",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Tews", "Schaar", "O�wald", "Mitschke", "Meinke", "Staub", "Hase", "Dold", "Traut", "Ney", "Stoffel", "Siefert", "Jablonski",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Brettschneider", "Zach", "Kehrer", "Heinke", "Selle", "Schipper", "Pongratz", "Kost", "Kienzle", "Findeisen", "H�berle",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"Habel", "Eibl", "Asmus", "Wege", "Korth", "Fast", "Ro�bach", "Vaupel", "Tempel", "Sowa", "H�fele", "Zitzmann", "Fleischhauer",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Eitel", "J�ngling", "Jauch", "Ganter", "Sebastian", "Schlemmer", "W�hrle", "Wolfrum", "Sch�ttler", "Schmidl", "K�mpf",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"Seliger", "Neumeister", "Mittelst�dt", "Ender", "Wicke", "Diefenbach", "Schlesinger", "Scheerer", "Pawlowski", "Flaig",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ 
			"Scheu", "Lambertz", "Gr�nberg", "Baumert", "Hund", "Gohlke", "Bracht", "Willer", "Kuck", "Finkbeiner", "Nadler", "Emmert",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Mildner", "Ammon", "Abels", "Schrade", "Rolle", "Hennecke", "Heidt", "Thormann", "Saller", "Hausner", "Dierkes", "Redlich",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Edel", "Dorner", "Schwenke", "Reber", "Markgraf", "Herb", "Bartmann", "Walch", "St�ber", "Neef", "Anger", "Stobbe",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Klingenberg", "Hotz", "Wittich", "Behm", "Haberl", "Weyand", "Wenig", "Siekmann", "Haustein", "Staudinger", "Schmoll",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"R��ner", "Genz", "Fr�hauf", "Fellner", "Coenen", "Bohlen", "Berlin", "Sperlich", "Breidenbach", "Schwinn", "Zipfel", "Mainka",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"V�gele", "Trommer", "Runkel", "Rohmann", "Moog", "Kehr", "Deininger", "Thimm", "Hauk", "Wei�er", "Ladwig", "Scheler",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"J�nemann", "Heber", "Gessner", "G�ller", "Fix", "Eckart", "Karle", "Rohrbach", "Messer", "K�lling", "Hieber", "Dinter",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Hauber", "Denecke", "Dettmann", "Wenzl", "Siemens", "Rebmann", "Huppertz", "Thei�", "Seewald", "Lay", "Meuser", "Erben",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Blau", "R�ser", "K�ppel", "Schurig", "Peetz", "St�rmer", "H�mmer", "Engert", "Pietschmann", "Merkl", "B�sing", "Orlowski",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Langhammer", "Kirst", "Hildenbrand", "Sieger", "Schulten", "Theil", "Leinweber", "Krapf", "Strauss", "Pitz", "Blumenthal",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"Gro�kopf", "Fels", "Schaible", "R�hm", "Piotrowski", "Stemmler", "Reinicke", "Pflaum", "Hemmer", "Saur", "Limbach", "Sorge",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Russ", "Rhein", "Ostendorf", "Topp", "Krafft", "Giebel", "Daniels", "Bohr", "Hassel", "Schenke", "Hochmuth", "Rombach",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Niggemann", "Jungbluth", "Feldhaus", "Janson", "H�ther", "Tauber", "Neher", "Moor", "Behrmann", "Sager", "Thielemann",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"Stumm", "Meusel", "Feiler", "Stauch", "Pfeuffer", "Niermann", "L�decke", "Seelig", "Kissel", "Eifler", "B�nger",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"Blankenburg", "Rohe", "Pr�fer", "Herget", "Grunewald", "Laumann", "Schwanke", "Maack", "Leibold", "Heinzel", "Dieterich",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$
			"Na�", "Haider", "Beetz", "Sauermann", "B�ning", "Schroer", "Heiser", "Tolksdorf", "Strohmeier", "Happel", "Gra�",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"Gottschling", "Gotthardt", "Achatz", "Wohlfarth", "Vollrath", "Liebe", "Szymanski", "Mertes", "Kn�dler", "Heppner", "Demmer",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"Alex", "Tappe", "Storck", "K�ppl", "Hertlein", "Wiesmann", "Mies", "Kuntze", "K�cher", "Kaluza", "Fick", "Weniger", "Spieker",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
			"Schnoor", "Bamberger", "Middendorf", "He�ler", "Haus", "Hackmann", "Eichholz", "Woll", "Kromer", "Brack", "Schnitzer",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"Pietzsch", "Milz", "Liese", "Karcher", "Bendel", "Adolf", "Strehl", "Ga�ner", "Thielmann", "Speicher", "Michler",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-11
			"Matthiesen", "Bergen", "Schaffner", "Pausch", "Kastl", "Goertz", "Bruckner", "Steinkamp", "Heizmann", "Ruge", "Rahm", "Poth",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Kortmann", "Egner", "Rempel", "Kolberg", "Burkhart", "Pl�ger", "Irmer", "W�rfel", "L�wen", "Tr�ster", "St�ckel", "Niehues",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"M�nz", "Kruppa", "Teubner", "Brinker", "Brucker", "Stoiber", "Fritzsch", "Sieben", "Rieke", "Schroll", "Winzer", "Thomann",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
			"Sch�nborn", "Quade", "Gruhn", "Gottfried", "Basler", "R�diger", "D�ck", "K�gler", "Kleinhans", "Freiberg", "Weishaupt",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"Nolting", "Geissler", "Majewski", "Weihrauch", "Hendricks", "Gr�tz", "Wesemann", "Geib", "Wei�mann", "Dewald", "Bachmeier",//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ 
			"Saathoff", "H�ls", "Hau�mann", "Grabow", "Seyfarth", "Hense", "Sperl", "Rosendahl", "Lembke", "Jesse" };//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$//$NON-NLS-6$//$NON-NLS-7$//$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$

}
