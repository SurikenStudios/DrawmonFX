package drawmon;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Monstruo {

    private String nombre;
    private int salud;
    private int energia;
    private int humor;
    private int sabiduria;
    private int atletismo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Monstruo() {
    }

    public Monstruo(String nombre) {
        salud = 100;
        energia = 100;
        humor = 100;
        sabiduria = 0;
        atletismo = 0;
    }

    //Metodo booleano aburrido
    private boolean aburrido() {
        boolean aburridoOk = false;
        if (humor <= 30) {
            aburridoOk = true;
            System.out.println("¡Me aburro!");
        } else if (humor <= 0) {
            muerto();
        }
        return aburridoOk;
    }

    //Metodo muerto
    private void muerto() {
        //resetea la creacion del monstruo pero no se hacerlo ahora mismo manu xD
        System.out.println("Descansa en paz" + nombre);
    }

    //Metodo hambre 
    private void hambriento() {
        if (energia <= 70) {
            System.out.println("Tengo algo de hambre");
        } else if (energia <= 40) {
            System.out.println("Tengo hambre");
        } else if (energia <= 15) {
            System.out.println("Tengo que comer pronto");
        } else {
            System.out.println("Ay mi panza... Agh");
            muerto();
        }
    }

    //Metodo enfermo
    private void enfermo() {

    }

    //Metodo para randomizar otro metodo xD
    public void met50porCiento() {
        Random random = new Random();
        double probabilidad = random.nextDouble(); // Genera un número aleatorio entre 0 (inclusive) y 1 (exclusive)

        if (probabilidad < 0.5) {
            enfermo(); }
    }

    // TEMPORIZADOR
    public void iniciarTemporizador(int tiempoInicial, int tiempoTemp) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Definir la tarea que se ejecutará
        Runnable tarea = () -> {
            System.out.println("¡Tarea ejecutada!");
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
}
