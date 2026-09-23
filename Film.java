public class Film {
  private int filmID;
  private String filmTitle;
  private Director filmDirector;
  private double filmPrice;
  private int filmQty;
          
  public Film() {
  }
            
  public Film(int filmID, String filmTitle, Director filmDirector, double filmPrice, int filmQty) {
    super();
    this.filmID = filmID;
    this.filmTitle = filmTitle;
    this.filmDirector = filmDirector;
    this.filmPrice = filmPrice;
    this.filmQty = filmQty;
  }
              
  public int getFilmID() {
    return filmID;
  }
                
  public String getFilmTitle() {
    return filmTitle;
  }
                  
  public Director getFilmDirector() {
    return filmDirector;
  }
                    
   public double getFilmPrice() {
     return filmPrice;
   }
                      
   public int getFilmQty() {
      return filmQty;
   }
                        
   public void setFilmID(int filmID) {
     this.filmID = filmID;
   }
                          
   public void setFilmTitle(String filmTitle) {
     this.filmTitle = filmTitle;
   }
                            
   public void setFilmDirector(Director filmDirector) {
     this.filmDirector = filmDirector;
   }
                              
   public void setFilmPrice(double filmPrice) {
     this.filmPrice = filmPrice;
   }
                                
   public void setFilmQty(int filmQty) {
     this.filmQty = filmQty;
   }
                                  
   public void print() {
     double productionCost = filmQty * filmPrice;
     System.out.println("---------------------------------------------");
     System.out.println("Film ID \t" + filmID);
     System.out.println("Film Title \t" + filmTitle);
     System.out.println("Film Director \t" + filmDirector.getDirectorName());
     System.out.println("Film Price \t" + filmPrice);
     System.out.println("Film Quantity \t" + filmQty);
     System.out.println("Production Cost \t" + productionCost + "million");
     System.out.println("---------------------------------------------");
  }
}
