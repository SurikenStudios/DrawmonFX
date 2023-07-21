package drawmon;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Temporizador {
       
    static Monstruo m;
    
    public void iniciarTemporizador(int tiempoInicial, int tiempoTemp) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Definir la tarea que se ejecutará
        Runnable tarea = () -> {
            System.out.println("¡Tarea ejecutada!");
            m.muerto();
            // Aquí colocas el código que deseas ejecutar cada vez que se cumpla el temporizador.
        };

        // Programar la tarea para que se ejecute cada cierto tiempo
        // tiempoInicial = Delay inicial antes de la primera ejecución (en horas)
        // intervaloTiempo = Intervalo entre ejecuciones (en horas)
        scheduler.scheduleAtFixedRate(tarea, tiempoInicial, tiempoTemp, TimeUnit.HOURS);

        // Esperar un tiempo para ver los resultados
        try {
            Thread.sleep(18000000); // Detener el temporizador después 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Detener el temporizador después de 5 horas
        scheduler.shutdown();
    }
}
