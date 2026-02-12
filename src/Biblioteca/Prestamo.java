package Biblioteca;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Prestamo {
    private String codigoLibro;
    private String tituloLibro;
    private Usuario usuario;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucionPrevista;
    private LocalDate fechaDevolucionReal;
    private LocalDate fechaActual= LocalDate.now();

    public Prestamo(String codigoLibro, Usuario usuario, String tituloLibro, LocalDate fechaPrestamo) throws PrestamoInvalidoException{
        if(codigoLibro.matches("^[A-Z]{3}[0-9]{4}")){
            this.codigoLibro=codigoLibro;
        }
        else{
            throw new PrestamoInvalidoException("Codigo del libro incorrecto, la forma correcta es 3 letras mayusculas + 4 dígitos");
        }

        this.usuario=usuario;

        if(tituloLibro==""){
            throw new PrestamoInvalidoException("EL titulo del libro tiene que estar introducido");
        }
        else{
            this.tituloLibro=tituloLibro;
        }

        if(fechaPrestamo==null || fechaPrestamo.isBefore(fechaActual)){
            throw new PrestamoInvalidoException("El valor de la fecha no puede estar vacio, ni se anterior a la fecha actual");
        }
        else{
            this.fechaPrestamo=fechaPrestamo;
        }

        fechaDevolucionPrevista= fechaPrestamo.plusDays(14);
    }


    public String getCodigoLibro() {
        return codigoLibro;
    }


    public void setCodigoLibro(String codigoLibro) {
        this.codigoLibro = codigoLibro;
    }


    public LocalDate getFechaDevolucionReal() {
        return fechaDevolucionReal;
    }


    public void setFechaDevolucionReal(LocalDate fechaDevolucionReal) {
        this.fechaDevolucionReal = fechaDevolucionReal;
    }


    public LocalDate getFechaActual() {
        return fechaActual;
    }


    public void setFechaActual(LocalDate fechaActual) {
        this.fechaActual = fechaActual;
    }


    public LocalDate getFechaDevolucionPrevista() {
        return fechaDevolucionPrevista;
    }


    public void setFechaDevolucionPrevista(LocalDate fechaDevolucionPrevista) {
        this.fechaDevolucionPrevista = fechaDevolucionPrevista;
    }


    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }


    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }


    public void registrarDevolucion(LocalDate fechaDevolucionReal) throws PrestamoInvalidoException{
        this.fechaDevolucionReal = fechaDevolucionReal;
        if(fechaDevolucionReal==null || fechaDevolucionReal.isBefore(fechaPrestamo)){
            throw new PrestamoInvalidoException("El valor de la fecha no puede estar vacio ni ser anterior a la fecha de prestamo");
        }
        else{
            System.out.println("La fecha de devolución es:" + fechaDevolucionReal);;
        }
    }

    public int calcularDiasRetraso(){
        int intervalo = (int) ChronoUnit.DAYS.between(fechaDevolucionPrevista,fechaDevolucionReal);
        if(intervalo == 0){
            return Integer.parseInt("Dias de retraso de la devolucion: " + intervalo);
        }
        else{
            return Integer.parseInt("Dias de retraso: " + intervalo);
        }
    }

    public boolean estaRetrasado(){
        if(fechaDevolucionReal.isAfter(fechaDevolucionPrevista) == true){
            System.out.println("XXXXX El libro ya tiene retraso XXXXX");
            return true;
        }
        else{
            System.out.println("EL libro no tiene retraso");
            return false;
        }
    }

    @Override
    public String toString(){
        return "Codigo del libro: " + codigoLibro + " titulo del libro: " + tituloLibro + " socio: " + usuario + " fecha del prestamo: " + fechaPrestamo + " fecha de devolucion prevista: " + fechaDevolucionPrevista;
    }






}
