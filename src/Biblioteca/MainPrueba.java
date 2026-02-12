package Biblioteca;

import java.sql.SQLOutput;
import java.time.LocalDate;

public class MainPrueba {
    public static void main(String[] args) throws UsuarioInvalidoException {

            /*try {
                Usuario u1 = new Usuario("Alvaro", "alvaro@mail.com", "SOC34346", LocalDate.of(2007, 4, 20));
                System.out.println(u1.toString());
                u1.sancionar(4,LocalDate.of(2026,4,20));
                u1.levantarSancion();
                u1.estaSacionado();
            }
            catch(UsuarioInvalidoException e){
                System.out.println("No se puede crear el usuario");
                System.out.println(e.getMessage());
            }*/

            System.out.println("---------------------------------------------------");

            try{
                Usuario u2 = new Usuario("Lara","Lara@gmail.com", "SOC45876", LocalDate.of(2010,5,13));

                Prestamo p1 = new Prestamo("LIB0011", u2, "Hunger Games", LocalDate.of(2026,2,18));

                System.out.println(p1.toString());

                p1.registrarDevolucion(LocalDate.of(2026,3,20));



                System.out.println(p1.estaRetrasado());
            }
            catch (PrestamoInvalidoException PIE){
                System.out.println(PIE.getMessage());
            }













    }
}
