package drawmon;

import java.util.Timer;
import java.util.TimerTask;

public class Monstruo {

    private String nombre;
    protected int salud = 100;
    protected int energia = 100;
    protected int humor = 100;
    protected int sabiduria = 0;
    protected int atletismo = 0;
    protected int hambre = 100;
    protected int peso = 10;
    protected boolean enfermo = false;
    protected boolean aburrido = false;
    protected boolean muerto = false;
    protected boolean hambriento = false;
    protected boolean cansado = false;
    protected boolean dormido = false;

    Timer restaSalud;
    Timer restaHambre;
    
    public Monstruo() {
        resta10HambreXHora();
    }

    public Monstruo(String nombre) {
        this.nombre = nombre;
        this.salud = salud;
        this.energia = energia;
        this.humor = humor;
        this.sabiduria = sabiduria;
        this.atletismo = atletismo;
        this.hambre = hambre;
        
        resta10HambreXHora();
    }

    // Metodo resta 10 de salud cada hora -----------------------------------------------------------------------------------
    
    public void resta10SaludXHora() {
        restaSalud = new Timer();
        restaSalud.schedule(new RemindTaskSalud(), 0, 60*60*1000);
    }

    class RemindTaskSalud extends TimerTask {
        public void run() {
            salud -= 10;
        }
    }
   
    // Metodo resta 10 de hambre cada hora -------------------------------------------------------------------------------------
    
  private void resta10HambreXHora(){
      restaHambre = new Timer();
      restaHambre.schedule(new RemindTaskHambre(), 0, 60*60*1000);
  }
  
  class RemindTaskHambre extends TimerTask {
      public void run(){
          hambre -=10;
      }
  }
  
  // GETTERS Y SETTERS -----------------------------------------------------------------------------------------------------------
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHambre() {
        return hambre;
    }

    public void setHambre(int hambre) {
        this.hambre = hambre;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
        if (salud > 100) {
            salud = 100;
        }
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
        if (energia > 100) {
            energia = 100;
        }
    }

    public int getHumor() {
        return humor;
    }

    public void setHumor(int humor) {
        this.humor = humor;
        if (humor > 100) {
            humor = 100;
        }
    }

    public int getSabiduria() {
        return sabiduria;
    }

    public void setSabiduria(int sabiduria) {
        this.sabiduria = sabiduria;
    }

    public int getAtletismo() {
        return atletismo;
    }

    public void setAtletismo(int atletismo) {
        this.atletismo = atletismo;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    // ENFERMO ----------------------------------------------------------------------------------------------------------
    public boolean isEnfermo() {
        if (enfermo = true) {
            System.out.println("Estoy malito");
            resta10SaludXHora();
        }
        return enfermo;
    }

    public void setEnfermo(boolean enfermo) {
        this.enfermo = enfermo;
    }

    // MUERTO ---------------------------------------------------------------------------------------------------------- SIN TERMINAR
    
    public boolean isMuerto() {
        if (muerto = true) {
            System.out.println("Descansa en paz " + nombre);

        }
        return muerto;
    }

    public void setMuerto(boolean muerto) {
        this.muerto = muerto;
        if (muerto = true) {
            isMuerto();
        }
    }

    // ABURRIDO ----------------------------------------------------------------------------------------------------------
    
    public boolean isAburrido() {
        if (humor <= 30 && humor > 0) {
            aburrido = true;
            System.out.println("¡Me aburro!");
        } else if (humor <= 0) {
            setMuerto(true);
        }
        return aburrido;
    }

    public void setAburrido(boolean aburrido) {
        this.aburrido = aburrido;
        if (aburrido = true) {
            isAburrido();
        }
    }

    // HAMBRIENTO ----------------------------------------------------------------------------------------------------------
    public boolean isHambriento() {
        if (hambre <= 70 && hambre > 40) {
            System.out.println("Tengo algo de hambre");
        } else if (hambre <= 30 && hambre > 15) {
            hambriento = true;
            System.out.println("Tengo hambre");
        } else if (hambre <= 15 && hambre > 0) {
            System.out.println("Tengo que comer pronto");
            hambriento = true;
            posibleEnfermo();
        } else if (hambre <= 0) {
            System.out.println("Ay mi panza... Agh");
            setMuerto(true);
        }
        return hambriento;
    }

    public void setHambriento(boolean hambriento) {
        this.hambriento = hambriento;
    }

    // CANSADO ----------------------------------------------------------------------------------------------------------
    public boolean isCansado() {
        if (energia <= 30 && energia > 0) {
            cansado = true;
        } else if (energia <= 0) {
            setDormido(true);
        }
        return cansado;
    }

    public void setCansado(boolean cansado) {
        this.cansado = cansado;
        if (cansado = true) {
            isCansado();
        }
    }

    // DORMIDO ---------------------------------------------------------------------------------------------------------- SIN TERMINAR 
    public boolean isDormido() {

        return dormido;
    }

    public void setDormido(boolean dormido) {
        this.dormido = dormido;
    }

    //Metodo para randomizar enfermedad 50% -------------------------------------------------------------------------------------
    
    public void posibleEnfermo() {
        int x = (int) (Math.random() * 2 + 1);
        switch (x) {
            case 1 ->
                setEnfermo(true);
            case 2 ->
                System.out.println("");
        }
    }

    public static int met33porCiento() {
        int x = (int) (Math.random() * 3 + 1);
        return x;
    }
    
    

    // ENTRENAR ATLETISMO --------------------------------------------------------------------------------------------------------
    
    public void entAtletismo() {

        if (enfermo = true) {
            energia -= 20;
            atletismo = atletismo + met33porCiento() - 1;
            hambre -= 15;
            humor += 10;
            peso -= 5;
        } else if (aburrido = true) {
            energia -= 15;
            atletismo = atletismo + met33porCiento();
            hambre -= 15;
            humor += 10;
            peso -= 5;
        } else if (cansado = true) {
            energia -= 15;
            atletismo = atletismo + met33porCiento() - 2;
            hambre -= 10;
            humor += 10;
            peso -= 5;
            posibleEnfermo();
        } else if (hambriento = true) {
            energia -= 20;
            atletismo = atletismo + met33porCiento() - 1;
            hambre -= 20;
            humor += 10;
            peso -= 5;
        } else 
            energia -= 15;
            atletismo = atletismo + met33porCiento();
            hambre -= 15;
            humor += 10;
            peso -= 10;
    }
    
    // ENTRENAR SABIDURIA -------------------------------------------------------------------------------------------------------- SIN TERMINAR

    public void entSabiduria() {
        if (enfermo = true) {
            energia -= 20;
            sabiduria = sabiduria + met33porCiento() - 1;
            hambre -= 15;
            humor += 10;
        } else if (aburrido = true) {
            energia -= 15;
            sabiduria = sabiduria + met33porCiento() - 2;
            hambre -= 15;
        } else if (cansado = true) {
            energia -= 15;
            sabiduria = sabiduria + met33porCiento();
            hambre -= 10;
            humor += 10;
        } else if (hambriento = true) {
            energia -= 20;
            sabiduria = sabiduria + met33porCiento() - 1;
            hambre -= 20;
            humor += 10;
        } else 
            energia -= 20;
            sabiduria = sabiduria + met33porCiento() - 1;
            hambre -= 20;
            humor += 10;
    }
    
    // JUGAR -------------------------------------------------------------------------------------------------------- SIN TERMINAR
    
    public void jugar(){
         if (enfermo = true) {
            
        } else if (cansado = true) {
         
        } else if (hambriento = true) {
           
        } else 
            
    }
    
    //  DORMIR -------------------------------------------------------------------------------------------------------- SIN TERMINAR
    
    public void dormir (){
            if (enfermo = true) {
            
        }  else 
    }
    
    // ALIMENTAR -------------------------------------------------------------------------------------------------------- SIN TERMINAR
    
    public void alimentar(){
          
    }
    
    // HIGIENIZAR -------------------------------------------------------------------------------------------------------- SIN TERMINAR
    
    public void higienizar(){
        
    }
    
    
    @Override
    public String toString() {
        return "Monstruo{" + "nombre=" + nombre + ", salud=" + salud + ", energia=" + energia + ", humor=" + humor + ", sabiduria=" + sabiduria + ", atletismo=" + atletismo + ", hambre=" + hambre + ", enfermo=" + enfermo + ", aburrido=" + isAburrido() + '}';
    }

}
