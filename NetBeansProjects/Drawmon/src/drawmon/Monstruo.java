package drawmon;

public class Monstruo {

    String nombre;
    int salud;
    int energia;
    int humor;
    int sabiduria;
    int atletismo;

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
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getHumor() {
        return humor;
    }

    public void setHumor(int humor) {
        this.humor = humor;
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
    private void muerto(){
        //resetea la creacion del monstruo pero no se hacerlo ahora mismo manu xD
        System.out.println("Descansa en paz" + nombre);
    }
    
    //Metodo
}
