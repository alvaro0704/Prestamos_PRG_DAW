package Biblioteca;

import java.time.LocalDate;

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

    public void registrarUsuario(Usuario usuarioR) throws UsuarioRepetidoException {
        for (int i = 0; i < numeroUsuario; i++){
            if(usuarios[i].equals(usuarioR) == false){
                usuarios[numeroUsuario]=usuarioR;
                numeroUsuario++;

            }
            else{
                throw new UsuarioRepetidoException("El usuario esta repetido, porfavor introduzca un usuario valido");
            }
        }
    }

    public Prestamo realizarPrestamo(String codigoLibro, String titulo, LocalDate fechaprestamo, Usuario usuario) throws PrestamoInvalidoException, UsuarioSancionadoException, LibroNoDisponibleException {
        Prestamo prestamoIn = new Prestamo(codigoLibro, usuario, titulo, fechaprestamo);

        if (usuario.estaSacionado()) {
            throw new UsuarioSancionadoException("El usuario esta sancionado, no puede realizar prestamos");
        }

        for (int i = 0; i < numeroPrestamos; i++) {
            if (prestamos[i].getCodigoLibro().equals(codigoLibro) && prestamos[i].getFechaDevolucionReal() == null) {
                throw new LibroNoDisponibleException("El libro está actualmente prestado");
            }
        }
        prestamos[numeroPrestamos] = prestamoIn;
        numeroPrestamos++;
        return prestamoIn;
    }

    /*public boolean devolverlibro(String codigoLibro, LocalDate fechaDevolucion) throws PrestamoInvalidoException {
        for (int i = 0; i < numeroPrestamos; i++){
            if(prestamos[i].getCodigoLibro().equals(codigoLibro)){
                prestamos[i].registrarDevolucion(fechaDevolucion);
            }
            else if(fechaDevolucion.isAfter(prestamos[i].getFechaDevolucionPrevista())){

            }
        }
    }
    */





}
