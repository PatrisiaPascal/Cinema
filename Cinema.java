import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Cinema {
  static Scanner input = new Scanner(System.in);
  static InputStreamReader textInput = new InputStreamReader(System.in);
  static BufferedReader reader = new BufferedReader(textInput);
  static DecimalFormat currency = new DecimalFormat("€0.00");
  static ArrayList<Director> allDirectors = new ArrayList<Director>();
  static ArrayList<Film> allFilms = new ArrayList<Film>();
  static ArrayList<Exception> bugReport = new ArrayList<Exception>();
              
  static int centralFilmID = 1005;
  static int centralDirectorID = 104;
                  
  public static void main(String[] args) {
	prePopulate();
    menu();
  }
                    
  private static void menu() {
    System.out.println("Press 1 for Director Menu");
    System.out.println("Press 2 for Film Menu");
    System.out.println("Press x to Exit");
    String choice = input.next();
                                      
    switch (choice) {
     case "1": {
       directorMenu();
       break;
     }
     case "2": {
       filmMenu();
       break;
     }
     case "a": {
       admin();
       break;
     }
     case "x", "X": {
       System.exit(0);;
     }
    }
                                          
    menu();
  }  
                      
  private static void admin() {
    System.out.println("Total Number of Films " + allFilms.size());
    System.out.println("Total Number of Directors " + allDirectors.size());
    double stockValue = 0;
                                
    for (Film f : allFilms) {
      stockValue = stockValue + (f.getFilmPrice() * f.getFilmQty());
    }
    System.out.println("Stock Value" + currency.format(stockValue));  
  }
                                        
  private static void filmMenu() {
    System.out.println("(1) - Create New Film");
    System.out.println("(2) - Edit Film");
    System.out.println("(3) - Delete Film");
    System.out.println("(4) - View All Films");
    System.out.println("(5) - View Films By Director");
    System.out.println("(m) - Return to Menu");
                                                                  
    String choice = input.next();
    choice = choice.toLowerCase();

    switch (choice) {
      case "1": {
        try {
          createFilm();
        } catch (Exception e) {
          System.out.println("Error in Create Film");
        }
        break;
      }
      case "2": {
        try {
          editFilm();
        } catch (Exception e) {
          System.out.println("Error in Edit Film");
        }
        break;
      }
      case "3": {
        deleteFilm();
        break;
      }
      case "4": {
        viewAllFilms();
        break;
      }
      case "5": {
        findFilmsByDirector();
        break;
      }
      case "m": {
        menu();
      }
    }  
    filmMenu();
  }   
            
  private static void editFilm() throws Exception {
    Film toEdit = findFilm();
    if (toEdit == null) {
      System.out.println("No Film with ID found");
    } else {
      editFilmMenu(toEdit);
    }
  } 
                                           
  private static void editFilmMenu(Film toEdit) throws Exception {
    System.out.println("Select what you'd like to edit");
    toEdit.print();
    System.out.println("(1) - Title");
    System.out.println("(2) - Director");
    System.out.println("(3) - Price");
    System.out.println("(4) - Quantity");
                                                                      
    switch (input.next()) {
      case "1": {
        System.out.println("Input Title");
        toEdit.setFilmTitle(reader.readLine());
        break;
      }
      case "2": {
        System.out.println("Replace with Existing Director or New Director?");
        System.out.println("(1) - Existing Director");
        System.out.println("(2) - New Director");
        switch (input.next()) {
          case "1": {
            Director d = findDirector();
            toEdit.setFilmDirector(d);
            toEdit.getFilmDirector().removeFilm(toEdit);
            d.addFilm(toEdit);
            break;
          }
          case "2": {
 
          }
        }
        break;
      }
      case "3": {
        System.out.println("Input Price");
        toEdit.setFilmPrice(input.nextDouble());
        break;
      }
      case "4": {
        System.out.println("Input Quantity");
        toEdit.setFilmQty(input.nextInt());       
        break;
      }
    }
  }
                
  private static void deleteFilm() {
    Film toDelete = findFilm();
    if (toDelete == null) {
      System.out.println("No Film with ID number found");
    } else {
      allFilms.remove(toDelete);
      toDelete.getFilmDirector().removeFilm(toDelete);
    }
  }
                                                
  private static void createFilm() throws Exception {
    Film f = new Film();
    f.setFilmID(centralFilmID);
    centralFilmID++;
    System.out.println("Enter Film Title");
    f.setFilmTitle(reader.readLine());
    System.out.println("Enter Film Director");
    Director d = findDirector();
    if (d == null) {
      System.out.println("No matching Director was found. Please try again.");
    } else {
      f.setFilmDirector(d);
    }
    System.out.println("Enter Film Price");
    f.setFilmPrice(input.nextDouble());
    System.out.println("Enter Film Quantity");
    f.setFilmQty(input.nextInt());
    allFilms.add(f);
  }
                   
  private static Film findFilm() {
    viewAllFilms();
    System.out.println("Select Film by ID number");
    int toFind = input.nextInt();
    boolean isFound = false;
    Film foundFilm = null;
                                                                 
    for (Film f : allFilms) {
      if (f.getFilmID() == toFind) {
        isFound = true;
        foundFilm = f;
      }
    }
    if (!isFound) {
      System.out.println("No matching ID found.");
    }
    return foundFilm;
  }
                        
  private static void viewAllFilms() {
    for (Film f : allFilms) {
      f.print();
    }
  }
                                                      
  private static Director findDirector() {
    viewAllDirectors();
    System.out.println("Enter the ID Number of the Director");
    int toFind = input.nextInt();
    boolean isFound = false;
    Director foundDirector = null;
                                                                            
    for (Director d : allDirectors) {
      if (d.getDirectorID() == toFind) {
        isFound = true;
        foundDirector = d;
      }
    }
                                                                                
    if (!isFound) {
      System.out.println("No matching ID found.");
    }
    return foundDirector;
  }
                  
  private static void directorMenu() {
    System.out.println("(1) - Create New Director");
    System.out.println("(2) - Edit Existing Director");
    System.out.println("(3) - Delete Director");
    System.out.println("(4) - View All Directors");
    System.out.println("(5) - View Films By Director");
    System.out.println("(m) - Return to Menu");
    
    String choice = input.next();
    choice = choice.toLowerCase();
                                                                                          
    switch (choice) {
      case "1": {
        try {
          createDirector();
        } catch (Exception e) {
          System.out.println("Error in Create Director");
        }
        break;
      }
      case "2": {
        try {
          editDirector();
        } catch (Exception e) {
          System.out.println("Error in Edit Director");
        }
        break;
      }
      case "3": {
        deleteDirector();
        break;
      }
      case "4": {
        viewAllDirectors();
        break;
      }
      case "5": {
        findFilmsByDirector();
        break;
      }
      case "m": {
        menu();
        break;
      }
    }
    directorMenu();
  }
                                     
  private static void findFilmsByDirector() {
    Director toFind = findDirector();
    toFind.printDirectedFilms();
  }
                                                            
  private static void editDirector() throws Exception {
    Director toEdit = findDirector();
    System.out.println("Select what you'd like to edit");
    toEdit.printDirectorDetails();
    System.out.println("\t (1) \t Name");
    switch (input.next()) {
      case "1": {
        System.out.println("Input New Name:");
        toEdit.setDirectorName(reader.readLine());
        break;
      }
    }
  }
                                                              
  private static void deleteDirector() {
    Director toDelete = findDirector();
    allDirectors.remove(toDelete);
  }
                                                                
  private static void createDirector() throws Exception {
    Director d = new Director();
    d.setDirectorID(centralDirectorID);
    centralDirectorID++;
    System.out.println("Enter Director Name");
    d.setDirectorName(reader.readLine());
    allDirectors.add(d);
  }
                                                                  
  private static void viewAllDirectors() {
    for (Director d : allDirectors) {
      d.printDirectorDetails();
    }
  }
                                                                    
  private static void prePopulate() {
    Director greatGerwig = new Director(100, "Great Gerwig");
    Director jamesCameron = new Director(101, "James Cameron");
                                                                              
	Film barbie = new Film(1001, "Barbie", greatGerwig, 9.99, 10);
	Film ladyBird = new Film(1002, "Lady Bird", greatGerwig, 14.99, 8);
	Film avatar = new Film(1003, "Avatar", jamesCameron, 12.99, 15);
    Film titanic = new Film(1004, "Titanic", jamesCameron, 12.99, 12);
                                                                                              
    greatGerwig.addFilm(barbie);
    greatGerwig.addFilm(ladyBird);
    jamesCameron.addFilm(avatar);
    jamesCameron.addFilm(titanic);
                                                                                                              
    allFilms.add(barbie);
    allFilms.add(ladyBird);
    allFilms.add(avatar);
    allFilms.add(titanic);
                                                                                                                              
    allDirectors.add(greatGerwig);
    allDirectors.add(jamesCameron);
  }
}
