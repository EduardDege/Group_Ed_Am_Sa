package Reversion;

public class Aufgabe {
    
	public static void main(String[] args) {
	
		
		System.out.println(berechne(40));
	}
	
      public static int berechne(int w){
    	   
           if ( w<=0){   
        	   return 0;
           }
           if (w==1 || w==0){
        	   return 1;
           }
          return berechne(w-2)+ berechne(w-1);
      }
	
	

}
