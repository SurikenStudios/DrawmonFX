package drawmon;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Monstruo {

    private String nombre;
    protected int salud = 100;
    protected int energia = 100;
    protected int humor = 100;
    protected int sabiduria = 0;
    protected int atletismo = 0;
    protected int hambre = 100;
    protected boolean enfermo = false;
    protected boolean aburrido = false;
    protected boolean muerto = false;
    protected boolean hambriento = false;
    protected boolean cansado = false;
    protected boolean dormido = false;
    
    public Monstruo() {
    }

    public Monstruo(String nombre) {
        this.nombre = nombre;
        this.salud = salud;
        this.energia = energia;
        this.humor = humor;
        this.sabiduria = sabiduria;
        this.atletismo = atletismo;
        this.hambre = hambre;
    }

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

    public boolean isCansado() {
        if(energia <= 30 && energia > 0) {
            
        }
        return cansado;
    }

    public void setCansado(boolean cansado) {
        this.cansado = cansado;
    }

    
    //Metodo para randomizar enfermedad 50%
    
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

    public void entAtletismo(Monstruo m) {

        if (m.enfermo = true) {
            m.energia -= 20;
            m.atletismo = m.atletismo + met33porCiento() - 1;
            m.hambre -= 15;
        } else if (m.aburrido = true) {
            m.energia -= 15;
            m.atletismo = m.atletismo + met33porCiento();
            m.hambre -= 15;
            m.humor += 10;
        } else if (m.cansado = true) {
            m.energia -= 15;
            m.atletismo = m.atletismo + met33porCiento() - 1;
            m.hambre -= 10;
            posibleEnfermo();
        } else if (m.hambriento = true) {
            m.energia -= 20;
            m.atletismo = m.atletismo + met33porCiento() - 1;
            m.hambre -= 20;
        }
    }

    @Override
    public String toString() {
        return "Monstruo{" + "nombre=" + nombre + ", salud=" + salud + ", energia=" + energia + ", humor=" + humor + ", sabiduria=" + sabiduria + ", atletismo=" + atletismo + ", hambre=" + hambre + ", enfermo=" + enfermo + ", aburrido=" + isAburrido() + '}';
    }

}
