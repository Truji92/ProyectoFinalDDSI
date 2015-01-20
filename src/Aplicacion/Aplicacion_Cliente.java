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
                    conexion.iniciarTransaccion();
                    Menu.insertaPersona(mPersona);
                    conexion.terminarTransaccion();
                    break;
                case 2:
                    conexion.iniciarTransaccion();
                    Menu.eliminaInstitucion(mInstitucion);
                    conexion.terminarTransaccion();
                    break;
                case 3:
                    conexion.iniciarTransaccion();
                    Menu.alimentosRecogidos(mEstablecimiento, mRecoge);
                    conexion.terminarTransaccion();
                    break;
                case 4:
                    conexion.iniciarTransaccion();
                    Menu.RecogidaDeAlimento(mAlimento, mRecoge, mPersona, mInstitucion, mEstablecimiento);
                    conexion.terminarTransaccion();
                    break;
                case 5:
                    conexion.iniciarTransaccion();
                    Menu.actualizarCIF(mInstitucion);
                    conexion.terminarTransaccion();
                    break;
                case 6:
                    conexion.iniciarTransaccion();
                    Menu.alimentosCaducados(mAlimento);
                    conexion.terminarTransaccion();
                    break;
                case 7:
                    conexion.iniciarTransaccion();
                    Menu.productosRecogidosPorVoluntario(mInstitucion, mPersona, mRecoge);
                    conexion.terminarTransaccion();
                    break;
                default:
                    System.out.println("¡Adios!");
            }

        } while (opcion != 0);



        conexion.Desconexion();
    }
}
