package Biblioteca;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);
        int menu;
        GestorBiblioteca g1 = new GestorBiblioteca();

        do{
            System.out.println("=======MENU=======");
            System.out.println("1. Registrar nuevo usuario");
            System.out.println("2. Realizar préstamo de libro");
            System.out.println("3. Devolver libro");
            System.out.println("4. Consultar estado de usuario");
            System.out.println("5. Mostrar préstamos activos");
            System.out.println("6. Mostrar usuarios activos");
            System.out.println("7. Actualizar sanciones");
            System.out.println("8. Salir");
            System.out.println("-------------------");
            System.out.println("Elige una opción del menú: ");
            menu = Integer.parseInt(in.nextLine());
            in.nextLine();
        }while(menu != 3);

        if(menu == 1){
            String nombre;
            String email;
            String numerosocio;
            LocalDate fecharegistro;
            System.out.println("Introduce el nombre del usuario: ");



            /*Usuario u1 = new Usuario(nombre,email,numerosocio,fecharegistro);
            System.out.println(g1.registrarUsuario(););*/
        }




    }


}



/*

PRUEBAS, LUEGO QUITAR_________________________________
try {
                Usuario u1 = new Usuario("Alvaro", "alvaro@mail.com", "SOC34346", LocalDate.of(2007, 4, 20));
                System.out.println(u1.toString());
                u1.sancionar(4,LocalDate.of(2026,4,20));
                u1.levantarSancion();
                u1.estaSacionado();
            }
            catch(UsuarioInvalidoException e){
                System.out.println("No se puede crear el usuario");
                System.out.println(e.getMessage());
            }

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



            try{
                Usuario u3 = new Usuario("Maria","Maria@gmail.com","SOC34567", LocalDate.of(2026,5,20));
                Usuario u4 = new Usuario("Juan","Juan@gmail.com","SOC34567", LocalDate.of(2026,5,20));
                GestorBiblioteca g1 = new GestorBiblioteca();

                g1.registrarUsuario(u3);
                g1.registrarUsuario(u4);

                System.out.println(g1.getUsuarios());



                g1.realizarPrestamo("CBC2345","El Quijote",LocalDate.of(2026,2,13),u3);


                System.out.println(g1.getPrestamos());



                System.out.println("__________________________");

                g1.devolverlibro("CBC2345", LocalDate.of(2026,5,15));

                System.out.println(u3.estaSacionado());

                System.out.println("--------------------");

                System.out.println(g1.buscarUsuario("SOC3457"));




        }
        catch (UsuarioInvalidoException | UsuarioRepetidoException | PrestamoInvalidoException |
        UsuarioSancionadoException | LibroNoDisponibleException UIE){
        System.out.println(UIE.getMessage());
        }


        }
 */