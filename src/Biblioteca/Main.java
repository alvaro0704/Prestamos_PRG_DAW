package Biblioteca;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UsuarioInvalidoException, UsuarioRepetidoException, PrestamoInvalidoException, UsuarioSancionadoException, LibroNoDisponibleException{
        Scanner in = new Scanner(System.in);
        int menu;
        GestorBiblioteca g1 = new GestorBiblioteca();


            do {
                System.out.println("=======MENU=======");
                System.out.println("1. Registrar nuevo usuario");
                System.out.println("2. Realizar préstamo de libro");
                System.out.println("3. Devolver libro");
                System.out.println("4. Consultar estado de usuario");
                System.out.println("5. Mostrar préstamos activos");
                System.out.println("6. Mostrar usuarios sancionados");
                System.out.println("7. Actualizar sanciones");
                System.out.println("8. Salir");
                System.out.println("-------------------");
                System.out.println("Elige una opción del menú: ");
                menu = Integer.parseInt(in.nextLine());

                if (menu == 1) {
                    try {
                        String nombre;
                        String email;
                        String numerosocio;
                        LocalDate fecharegistro;

                        System.out.println("Introduce el nombre del usuario: ");
                        nombre = in.nextLine();
                        System.out.println("Introduce el mail del usuario: ");
                        email = in.nextLine();
                        System.out.println("Introduce numero de socio: ");
                        numerosocio = in.nextLine();

                        fecharegistro = LocalDate.now();

                        Usuario usuario = new Usuario(nombre, email, numerosocio, fecharegistro);
                        g1.registrarUsuario(usuario);
                    }catch (UsuarioInvalidoException UIE){
                        System.out.println(UIE.getMessage());
                    }
                } else if (menu == 2) {

                    String codigoLibro;
                    String titulo;
                    LocalDate fechaprestamo;
                    Usuario usuario;
                    String numeroSocio;


                    System.out.println("Introduce el codigo del libro: ");
                    codigoLibro = in.nextLine();
                    System.out.println("Introduce el titulo del libro: ");
                    titulo = in.nextLine();
                    System.out.println("Introduce el numero de socio del usuario: ");
                    numeroSocio = in.nextLine();

                    usuario = g1.buscarUsuario(numeroSocio);

                    fechaprestamo = LocalDate.now();

                    g1.realizarPrestamo(codigoLibro,titulo,fechaprestamo,usuario);

                } else if (menu == 3) {
                    String codigoLibro;
                    LocalDate fechaDevolucion;

                    System.out.println("Introduce el codigo del libro a devolver: ");
                    codigoLibro = in.nextLine();
                    fechaDevolucion = LocalDate.now();

                    if (g1.devolverlibro(codigoLibro, fechaDevolucion)) {
                        System.out.println("Libro devuelto correctamente");
                    } else {
                        System.out.println("Error");
                    }

                } else if (menu == 4) {
                    String resultado;
                    String numeroSocio;
                    System.out.println("Introduce el numero de socio del usuario:");
                    numeroSocio = in.nextLine();
                    Usuario usuario;

                    usuario = g1.buscarUsuario(numeroSocio);

                    usuario.estaSacionado();

                } else if (menu == 5) {

                    System.out.println(g1.getPrestamos());

                } else if (menu == 6) {

                    System.out.println(g1.getUsuarios());

                } else if (menu == 7) {

                    g1.getUsuarios();

                    LocalDate fechaact = LocalDate.now();

                    /*if(fechaact.isBefore(usuario.getFechaFinSancion())){
                        u1.levantarSancion();
                    }*/
                }
            } while (menu != 8);
        }

    }





