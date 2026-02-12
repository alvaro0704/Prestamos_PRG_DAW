package Biblioteca;

public class GestorBiblioteca {
    private static final int max_Usuarios= 50;
    private static final int max_Prestamos= 200;
    private Usuario[] usuarios;
    private Prestamo[] prestamos;
    private int numeroUsuario;
    private int numeroPrestamos;

    public GestorBiblioteca(){
        usuarios = new Usuario[max_Usuarios];
        prestamos = new Prestamo[max_Prestamos];
        numeroUsuario=0;
        numeroPrestamos=0;
    }






}
