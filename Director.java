import java.util.ArrayList;

public class Director {
  /**
   * Instance variables
   */
  private int directorID; 
  private String directorName; 
  private ArrayList<Film> directedFilms = new ArrayList<Film>(); 
        
  /**
  * constructor
  */
  public Director() {
  } 
  /**
   * 
   * constructor directorID
   * constructor directorName
   */
  public Director(int directorID, String directorName) {
  this.directorID = directorID;
  this.directorName = directorName;
  }
  /**
   * 
   * constructor directorID
   * constructor directorName
   * constructor directedFilms
   */
  public Director(int directorID, String directorName, ArrayList<Film> directedFilms) {
    this.directorID = directorID;
    this.directorName = directorName;
    this.directedFilms = directedFilms;
  }
   /**
   * Getter directorId
   * 
   */
  public int getDirectorID() {
    return directorID;
  }
  /**
   * 
   * setter directorID
   */
  public void setDirectorID(int directorID) {
    this.directorID = directorID;
  }
  /**
   * 
   * getter directorName
   */
  public String getDirectorName() {
    return directorName;
  }
  /**
   * 
   * setter directorName
   */
  public void setDirectorName(String directorName) {
    this.directorName = directorName;
  }
  /**
   * 
   * Getter directedFilms
   */
  public ArrayList<Film> getDirectedFilms() {
    return directedFilms;
  }
  /**
   * 
   *Setter directedFilms
   */
  public void setDirectedFilms(ArrayList<Film> directedFilms) {
     this.directedFilms = directedFilms;
  }
  /**
   * 
   * Method to add a film to the list of directedFilms
   */
  public void addFilm(Film f) {
    directedFilms.add(f);
  }
  /**
   *                                              
   * Method to remove a film from the list of directedFilms
   */
  public void removeFilm(Film f) {
    directedFilms.remove(f);
  }
  /**
   * // Method to remove all films from the list of directedFilms
   */
  public void removeAllFilms() {
    directedFilms.clear();
  }
  /**
   * // Method to print details of all films directed by the director
   */
  public void printDirectedFilms() {
    for (Film f : directedFilms) {
      f.print();
    }
  }
  /**
   * // Method to print details of the director
   */
  public void printDirectorDetails() {
    System.out.println(directorID + " \t Name: " + directorName);
  }
}
