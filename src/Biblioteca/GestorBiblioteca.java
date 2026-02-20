package Biblioteca;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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
            if(usuarios[i].equals(usuarioR) ){
                throw new UsuarioRepetidoException("El usuario esta repetido, porfavor introduzca un usuario valido");
            }
        }
        usuarios[numeroUsuario]=usuarioR;
        numeroUsuario++;
    }


    public void setUsuarios(Usuario[] usuarios) {
        this.usuarios = usuarios;
    }



    public void setPrestamos(Prestamo[] prestamos) {
        this.prestamos = prestamos;
    }


    public int getNumeroUsuario() {
        return numeroUsuario;
    }


    public int getNumeroPrestamos() {
        return numeroPrestamos;
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

    public boolean devolverlibro(String codigoLibro, LocalDate fechaDevolucion) throws PrestamoInvalidoException {

        for (int i = 0; i < numeroPrestamos; i++){
            if(prestamos[i].getCodigoLibro().equals(codigoLibro)){
                prestamos[i].registrarDevolucion(fechaDevolucion);
                return false;
            }
            if(fechaDevolucion.isAfter(prestamos[i].getFechaDevolucionPrevista())){
                int diasretraso = (int) ChronoUnit.DAYS.between(prestamos[i].getFechaDevolucionPrevista(),fechaDevolucion);
                prestamos[i].getUsuario().sancionar(diasretraso, LocalDate.now());
            }
            return true;
        }
        return false;
    }

    public Usuario buscarUsuario(String numeroSocio){
        for(int i = 0; i < numeroUsuario; i++){
            if(usuarios[i].getNumeroSocio().equals(numeroSocio)){
                return usuarios[i];
            }
        }
        return null;
    }

    public Prestamo[] getPrestamos(){
        Prestamo[] listaPrestamos = new Prestamo[numeroPrestamos] ;
        for(int i = 0; i < numeroPrestamos; i++){
            listaPrestamos[i]= prestamos[i];
        }
        return listaPrestamos;
    }

    public Usuario[] getUsuarios(){
        Usuario[] listaUsuarios=new Usuario[numeroUsuario];
        for(int i = 0; i < numeroUsuario; i++){
            listaUsuarios[i] = usuarios[i];
        }
        return listaUsuarios;
    }

    @Override
    public String toString(){
        return "Lista de usuarios: " + getUsuarios() + "\n" + "\n"+ "Lista de Prestamos: " + getPrestamos();
    }





}
