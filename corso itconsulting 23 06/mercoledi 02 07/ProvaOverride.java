class  Veicolo{  
  // //Creazione di una classe genitore.  definire un metodo  
  void  run(){System.out.println( "Il veicolo è in marcia" );}  
}  

 class Bike extends Veicolo{    
 void run() {
    System.out.println("Il veicolo è una bicicletta");
 }
  
}  
 
class ProvaOverride  extends  Veicolo{  
  void  run(){System.out.println( "La bici sta correndo in sicurezza" );} //metodo della classe genitore 
  public static void  main(String args[]){    
     ProvaOverride obj =  new  ProvaOverride(); //crea oggetto  
     obj.run();  
      Bike obj2 = new Bike();  
      obj2.run(); 
  }  } 
