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

                        System.out.println("Usuario registrado correctamente");
                    }catch (UsuarioInvalidoException UIE){
                        System.out.println(UIE.getMessage());
                    }
                    catch (UsuarioRepetidoException URE){
                        System.out.println(URE.getMessage());
                    }
                } else if (menu == 2) {
                    try {

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

                        g1.realizarPrestamo(codigoLibro, titulo, fechaprestamo, usuario);

                        System.out.println("Prestamo realizado");
                        System.out.println("Devolución prevista: " + g1.realizarPrestamo(codigoLibro, titulo, fechaprestamo, usuario).getFechaDevolucionPrevista());

                    }
                    catch (LibroNoDisponibleException LNDE) {
                        System.out.println(LNDE.getMessage());
                    }
                    catch (PrestamoInvalidoException PIE){
                        System.out.println(PIE.getMessage());
                    }

                } else if (menu == 3) {
                    try {
                        String codigoLibro;
                        LocalDate fechaDevolucion;

                        System.out.println("Introduce el codigo del libro a devolver: ");
                        codigoLibro = in.nextLine();
                        fechaDevolucion = LocalDate.now();

                        if (g1.devolverlibro(codigoLibro, fechaDevolucion)) {
                            System.out.println("error, ese libro no esta registrado como prestado");
                        } else {
                            System.out.println("Libro devuelto corretamente");
                        }
                    }catch (PrestamoInvalidoException PIE){
                        System.out.println(PIE.getMessage());
                    }


                } else if (menu == 4) {
                    String resultado;
                    String numeroSocio;
                    System.out.println("Introduce el numero de socio del usuario:");
                    numeroSocio = in.nextLine();
                    Usuario usuario;

                    usuario = g1.buscarUsuario(numeroSocio);

                    if(usuario.estaSacionado()== false){
                        System.out.println("El Usuario no esta sancionado");
                    }
                    else{
                        System.out.println("El Usuario esta SANCIONADO");
                    }


                } else if (menu == 5) {

                    System.out.println(g1.getPrestamos());

                } else if (menu == 6) {

                    System.out.println("--- USUARIOS SANCIONADOS ---");
                    boolean sancionados = false;

                    Usuario[] listaUsuarios = g1.getUsuarios();

                    for (int i = 0; i < g1.getNumeroUsuario(); i++) {
                        if (listaUsuarios[i].estaSacionado()) {
                            System.out.println(listaUsuarios[i].toString());
                            sancionados = true;
                        }
                    }
                    if (!sancionados) {
                        System.out.println("No hay usuarios sancionados actualmente.");
                    }

                } else if (menu == 7) {
                    Usuario[] listaUsuarios = g1.getUsuarios();
                    LocalDate actual = LocalDate.now();
                    int cont= 0;

                    for (int i = 0; i < listaUsuarios.length; i++){
                        Usuario u1 = listaUsuarios[i];

                        if(u1.estaSacionado() && u1.getFechaFinSancion().isBefore(actual)){
                            u1.levantarSancion();
                            cont++;
                        }
                    }
                    if(cont > 0){
                        System.out.println("Todas las sanciones levantadas");
                    }
                    else{
                        System.out.println("No se han levantado sanciones");
                    }

                }
            } while (menu != 8);
        }

    }





