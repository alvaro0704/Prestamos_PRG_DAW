package Biblioteca;

import java.time.LocalDate;

public class Usuario {
    private String nombre;
    private String email;
    private String numeroSocio;
    private LocalDate fechaRegistro;
    private boolean sancionado=false;
    private LocalDate fechaFinSancion;

    public Usuario(String nombre, String email, String numeroSocio, LocalDate fechaRegistro) throws UsuarioInvalidoException{
        this.nombre=nombre;

        if (email.matches(".+@.+\\..+")){
            this.email=email;
        }
        else{
            throw new UsuarioInvalidoException("Email mal introducido, introduce los caracteres @ y .");
        }

        if (numeroSocio.matches("^SOC[0-9]{5}")){
            this.numeroSocio=numeroSocio;
        }
        else{
            throw new UsuarioInvalidoException("Numero de socio mal introducido el formato es: SOC + 5 números");
        }
        this.fechaRegistro=fechaRegistro;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getNumeroSocio() {
        return numeroSocio;
    }


    public void setNumeroSocio(String numeroSocio) {
        this.numeroSocio = numeroSocio;
    }


    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }


    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }


    public boolean isSancionado() {
        return sancionado;
    }


    public void setSancionado(boolean sancionado) {
        this.sancionado = sancionado;
    }


    public LocalDate getFechaFinSancion() {
        return fechaFinSancion;
    }


    public void setFechaFinSancion(LocalDate fechaFinSancion) {
        this.fechaFinSancion = fechaFinSancion;
    }


    public void sancionar(int diasSancion, LocalDate fechaInicioSancion){
        fechaFinSancion= fechaInicioSancion.plusDays(diasSancion);
        sancionado=true;
    }

    public void levantarSancion(){
        sancionado=false;
        fechaFinSancion=null;
    }

    public boolean estaSacionado(){
        if(sancionado==true){
            System.out.println("EL usuario esta sancionado");
            return true;
        }
        else{
            System.out.println("El usuario no esta sancionado");
            return false;
        }

    }

    @Override
    public String toString(){
        return "Nombre: " + nombre + " Email: " + email + " Numero de socio: " + numeroSocio + " fecha de registro: " + fechaRegistro;
    }




}
