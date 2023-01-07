package model;

public class Hora {
		private int hora;
		private int minuto;
		private int segundo;
		
		//constructor overloading
		
		//full constructor
		public Hora(int hora, int minuto, int segundo){
		  sethora(hora);
		  setminuto(minuto); 
		  setsegundo(segundo);
	}
		
		//default constructor: default values are equal to 0
		  //sethora(0);
		  //setminuto(0); 
		  //setsegundo(0);
		//calling the 3 argument constructor
		public Hora () { 
			this(0,0,0);
		}
		
		//constructor only for hora
		public Hora (int hora) {
			this(hora,0,0);
			}
			
		//constructor for hora and minuto
		public Hora(int hora, int minuto) {
				this(hora, minuto, 0);
				}
		
	   //copy constructor: it copies all the attributes of t inside the attributes of the class
		public Hora (Hora t) {
				this(t. hora, t.minuto, t. segundo);  
				}
				
		//getters and setters ----------
		
		public void sethora (int hora) {
			if ((hora >= 0) && (hora < 24) )
			this.hora = hora;
			else throw new IllegalArgumentException ("hora is not correct");
			}
				
		public void setminuto (int minuto) {
			if ((minuto >= 0)&&(minuto < 60))
			this.minuto=minuto;
			else throw new IllegalArgumentException ("minuto is not correct");
		}
				
		public void setsegundo (int segundo) {
				if ((segundo >= 0)&&(segundo < 60))
					this.segundo=segundo;
					else throw new IllegalArgumentException ("segundo is not correct");
				}
				
		public int gethora () {
			return hora;
		}
				
		public int getminuto(){
			return minuto;
		}
		
		public int getsegundo(){
			return segundo;
		}
			
		//method called toUniversalString
		//02 two digits and if it has remain space fill with 0  
		public String toUniversalString() {
			return String.format("%02d:%02d:%02d", hora, minuto, segundo);
		}
		
		//String representation of an object - override: change the definition of the method
		@Override
		//if u only type the object it will print toString by default
		public String toString() {
			return String.format("%02d:%02d:%02d", hora, minuto, segundo);
			
		}
		
		
		
		
					
	}
}
