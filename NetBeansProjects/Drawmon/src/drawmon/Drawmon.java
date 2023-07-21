package drawmon;

import java.util.Scanner;

public class Drawmon {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Monstruo m = new Monstruo();
        
        System.out.println("Ponle nombre");
        m.setNombre("Pepe");
        
        m.setHambre(10);
        m.hambriento();
        System.out.println(m.toString());

    }

}
