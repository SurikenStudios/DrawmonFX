package drawmon;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Monstruo {

    private String nombre;
    protected int salud = 100;
    protected int energia = 100;
    protected  int humor = 100;
    protected  int sabiduria = 0;
    protected  int atletismo = 0;
    protected  int hambre = 100;
    protected boolean enfermo = false;
    protected boolean aburrido = false;
    protected boolean muerto = false;
    
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

        public boolean isEnfermo() {
        return enfermo;
    }

    public void setEnfermo(boolean enfermo) {
        this.enfermo = enfermo;
    }

    public boolean isMuerto() {
        if (muerto = true){
        System.out.println("Descansa en paz " + nombre);
        
        }
        return muerto;
    }

    public void setMuerto(boolean muerto) {
        this.muerto = muerto;
        if( muerto = true) {
            isMuerto();
        }
    }

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
    }
    
    public Monstruo() {
    }

    public Monstruo(String nombre) {
        this.nombre = nombre;
        this.salud = salud;
        this.energia = energia;
        this.humor = humor;
        this.sabiduria = sabiduria;
        this.atletismo = atletismo;
        this.hambre=hambre;
    }


    //Metodo hambre 
    public String hambriento() {
        if (hambre <= 70 && hambre > 40) {
            System.out.println("Tengo algo de hambre");
            
        } else if (hambre <= 40 && hambre > 15) {
            System.out.println("Tengo hambre");
        } else if (hambre <= 15 && hambre > 0) {
            System.out.println("Tengo que comer pronto");
            met50porCiento();
        } else if (hambre <= 0){
            System.out.println("Ay mi panza... Agh");
            setMuerto(true);
            }
        return null;
    }



    //Metodo para randomizar otro metodo xD
   
    public void met50porCiento() {
    int x = (int) (Math.random() * 2 + 1);
        switch (x) {
            case 1 -> setEnfermo(true);
            case 2 -> System.out.println("Y me duele");
        }
    }
    
    // TEMPORIZADOR
    public void iniciarTemporizador(int tiempoInicial, int tiempoTemp) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Definir la tarea que se ejecutará
        Runnable tarea = () -> {
            System.out.println("¡Tarea ejecutada!");
            setMuerto(true);
            // Aquí colocas el código que deseas ejecutar cada vez que se cumpla el temporizador.
        };

        // Programar la tarea para que se ejecute cada cierto tiempo
        // tiempoInicial = Delay inicial antes de la primera ejecución (en horas)
        // intervaloTiempo = Intervalo entre ejecuciones (en horas)
        scheduler.scheduleAtFixedRate(tarea, tiempoInicial, tiempoTemp, TimeUnit.HOURS);

        // Esperar un tiempo para ver los resultados
        try {
            Thread.sleep(5); // Detener el temporizador después de 5 horas para que no siga ejecutándose indefinidamente
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Detener el temporizador después de 5 horas
        scheduler.shutdown();
    }

    @Override
    public String toString() {
        return "Monstruo{" + "nombre=" + nombre + ", salud=" + salud + ", energia=" + energia + ", humor=" + humor + ", sabiduria=" + sabiduria + ", atletismo=" + atletismo + ", hambre=" + hambre + ", enfermo=" + enfermo + ", aburrido=" + isAburrido() + '}';
    }
}
