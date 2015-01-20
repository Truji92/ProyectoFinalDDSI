package Aplicacion;

import Interfaz.Menu;
import Persistencia.ManejaAlimento;
import Persistencia.ManejaEstablecimiento;
import Persistencia.ManejaInstitucion;
import Persistencia.ManejaPersona;
import Persistencia.ManejaRecoge;

public class Aplicacion_Cliente {

    public static void main(String[] args) {
        ConexionOracle conexion = new ConexionOracle();
        System.out.println("conectando...");
        conexion.Conexion();
        System.out.println("conectado !!");

        int opcion;
        do {
            opcion = Menu.principal();
            ManejaPersona mPersona = new ManejaPersona(conexion);
            ManejaRecoge mRecoge = new ManejaRecoge(conexion);
            ManejaEstablecimiento mEstablecimiento = new ManejaEstablecimiento(conexion);
            ManejaAlimento mAlimento = new ManejaAlimento(conexion);
            ManejaInstitucion mInstitucion = new ManejaInstitucion(conexion);
            switch (opcion) {
                case 1:
                    Menu.insertaPersona(mPersona);
                    break;
                case 2:
                    Menu.eliminaInstitucion(mInstitucion);
                    break;
                case 3:
                    Menu.alimentosRecogidos(mEstablecimiento, mRecoge);
                    break;
                case 4:
                    Menu.RecogidaDeAlimento(mAlimento, mRecoge, mPersona, mInstitucion, mEstablecimiento);
                    break;
                case 5:
                    Menu.actualizarCIF(mInstitucion);
                    break;
                case 6:
                    break;
                case 7:
                    break;
                default:
                    System.out.println("¡Adios!");
            }

        } while (opcion != 0);



        conexion.Desconexion();
    }
}
