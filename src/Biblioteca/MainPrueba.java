package Biblioteca;

import java.time.LocalDate;

public class MainPrueba {
    public static void main(String[] args) throws UsuarioInvalidoException {

            Usuario u1 = new Usuario("Alvaro","alvaro@mail.com","SOC34346", LocalDate.of(2007,4,20));

            u1.toString();

            u1.sancionar(2,LocalDate.of(2026,2,10));

            u1.levantarSancion();

            u1.estaSacionado();


    }
}
