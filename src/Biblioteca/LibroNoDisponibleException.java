package Biblioteca;

public class LibroNoDisponibleException extends Exception {

    public LibroNoDisponibleException(String mensaje) {
        super(mensaje);
    }
}
