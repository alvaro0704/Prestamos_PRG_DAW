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

    public void registrarDevolucion(LocalDate fechaDevolucionReal) throws PrestamoInvalidoException{
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






}
