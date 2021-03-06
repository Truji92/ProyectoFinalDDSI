/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consola;

import Datos.Alimento;
import Datos.Establecimiento;
import Datos.Institucion;
import Datos.Persona;
import Persistencia.*;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class Menu {

    public static int principal() {
        System.out.println("### MENU ###");
        System.out.println("1. Insertar Voluntario (Persona)");
        System.out.println("2. Eliminar Voluntario (Institución)");
        System.out.println("3. Obtener listado de alimentos recogidos entre"
                + " dos fechas en un establecimiento");
        System.out.println("4. Insertar la información de la recogida de un "
                + "alimento por parte de un voluntario en "
                + "un determinado establecimiento");
        System.out.println("5. Actualizar el CIF de una institución ");
        System.out.println("6. Mostrar y eliminar alimentos caducados");
        System.out.println("7. Mostrar el número total de productos recogidos"
                + " por un voluntario");
        System.out.println("0. Salir");
        int eleccion = -1;
        do {
            if (eleccion != -1) {
                System.out.println("Opcion incorrecta.");
            }
            System.out.println("Opción: ");
            eleccion = Teclado.readInt();
        } while (eleccion < 0 || eleccion > 7);
        return eleccion;
    }

    public static void insertaPersona(ManejaPersona mPersona) {
        Persona persona = new Persona();

        String dni = null;
        do {
            if (dni != null) {
                System.out.println("DNI Incorrecto");
            }
            System.out.println("Introduzca DNI (con letra en mayuscula): ");
            dni = Teclado.readString();
        } while (!dni.matches("(\\d{8})([A-Z])"));
        persona.setDni(dni);

        String nombre = null;
        do {
            if (nombre != null) {
                System.out.println("El nombre no puede estar vacío.");
            }
            System.out.println("Introduzca nombre: ");
            nombre = Teclado.readString();
        } while (nombre.isEmpty());
        persona.setNombre(nombre);

        String apellido1 = null;
        do {
            if (apellido1 != null) {
                System.out.println("El apellido no puede estar vacío.");
            }
            System.out.println("Introduzca primer apellido: ");
            apellido1 = Teclado.readString();
        } while (apellido1.isEmpty());
        persona.setApellido1(apellido1);

        String apellido2 = null;
        do {
            if (apellido2 != null) {
                System.out.println("El apellido no puede estar vacío.");
            }
            System.out.println("Introduzca segundo apellido: ");
            apellido2 = Teclado.readString();
        } while (apellido2.isEmpty());
        persona.setApellido2(apellido2);

        String telefono = null;
        do {
            if (telefono != null) {
                System.out.println("El teléfono no es correcto");
            }
            System.out.println("Introduzca telefono: ");
            telefono = Teclado.readString();
        } while (!telefono.matches("(\\d{9})"));
        persona.setTelefono(telefono);

        String email = null;
        do {
            if (email != null) {
                System.out.println("El email es incorrecto.");
            }
            System.out.println("Introduzca email: ");
            email = Teclado.readString();
        } while (!email.matches("([_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,3}))"));
        persona.setEmail(email);

        int edad = Integer.MIN_VALUE;
        do {
            if (edad != Integer.MIN_VALUE) {
                System.out.println("Edad incorrecta.");
            }
            System.out.println("Introduzca edad: ");
            edad = Teclado.readInt();
        } while (edad <= 0);
        persona.setEdad(edad);

        String localidad = null;
        do {
            if (localidad != null) {
                System.out.println("La localidad no puede estar vacía.");
            }
            System.out.println("Introduzca localidad: ");
            localidad = Teclado.readString();
        } while (localidad.isEmpty());
        persona.setLocalidad(localidad);

        mPersona.insertaPersona(persona);
    }

    public static void eliminaInstitucion(ManejaInstitucion mInst) {
        List<Institucion> instituciones = mInst.getInstituciones();
        System.out.println("Instituciones actualmente en la base de datos: ");
        System.out.println("CIF - Nombre - Razón Social - Teléfono");
        for (Institucion i : instituciones) {
            System.out.println(i);
        }
        String CIF = null;
        do {
            if (CIF != null) {
                System.out.println("CIF no valido");
            }
            System.out.println("Introduce el CIF de la Institución a eliminar: ");
            CIF = Teclado.readString();
        } while (!CIF.matches("([A-Z])(\\d{8})"));

        mInst.eliminaInstitucion(CIF);
    }

    public static void alimentosRecogidos(ManejaEstablecimiento mEstablecimiento, ManejaRecoge mRecoge) {
        List<Establecimiento> establecimientos = mEstablecimiento.getEstablecimientos();
        System.out.println("Establecimientos registrados en la base de datos: ");
        System.out.println("id - nombre - dirección - localidad");
        for (Establecimiento e : establecimientos) {
            System.out.println(e);
        }


        System.out.println("Introduce el id del establecimiento a consultar: ");
        int id = Teclado.readInt();

        String fecha1 = null;
        do {
            System.out.println("Introduce fecha inicial (dd/mm/aaaa): ");
            fecha1 = Teclado.readString();
        } while (!fecha1.matches("([0][1-9]|[12][0-9]|3[01])(/|-)([0][1-9]|[1][0-2])\\2(\\d{4})"));
        String[] f1 = fecha1.split("/");
        Date date1 = new Date();

        /*date1.setYear(Integer.parseInt(f1[2]) - 1900);
        date1.setMonth(Integer.parseInt(f1[1]) - 1);
        date1.setDate(Integer.parseInt(f1[0]));
*/
        String fecha2 = null;
        do {
            System.out.println("Introduce fecha final (dd/mm/aaaa): ");
            fecha2 = Teclado.readString();
        } while (!fecha1.matches("([0][1-9]|[12][0-9]|3[01])(\\/|-)([0][1-9]|[1][0-2])\\2(\\d{4})"));
        String[] f2 = fecha2.split("/");
        Date date2 = new Date();

        date2.setYear(Integer.parseInt(f2[2]) - 1900);
        date2.setMonth(Integer.parseInt(f2[1]) - 1);
        date2.setDate(Integer.parseInt(f2[0]));

        System.out.println("Alimentos recogidos: ");
        List<Alimento> alimentos = mRecoge.listadoAlimentos(id, fecha1, fecha2);
        for (Alimento a : alimentos) {
            System.out.println(a);
        }
    }

        public static void RecogidaDeAlimento(ManejaAlimento mAlimento, ManejaRecoge mRecoge, ManejaPersona mPersona, ManejaInstitucion mInstitucion, ManejaEstablecimiento mEstablecimiento) {
        String descripcion;
        System.out.println("Introduzca descripción del alimento: ");
        descripcion = Teclado.readString();

        String fecha = null;
        do {
            System.out.println("Introduce fecha de caducidad (dd/mm/aaaa): ");
            fecha = Teclado.readString();
        } while (!fecha.matches("([0][1-9]|[12][0-9]|3[01])(\\/|-)([0][1-9]|[1][0-2])\\2(\\d{4})"));
        String[] arrayFecha = fecha.split("/");
        Date date = new Date();

       // date.setYear(Integer.parseInt(arrayFecha[2]) - 1900);
        //date.setMonth(Integer.parseInt(arrayFecha[1]) - 1);
        //date.setDate(Integer.parseInt(arrayFecha[0]));

        Alimento alimento = new Alimento(mAlimento.generarClave(), descripcion, fecha);

        List<Persona> personas = mPersona.getPersonas();
        List<Institucion> instituciones = mInstitucion.getInstituciones();
        List<Integer> idsVoluntarios = new LinkedList<>();
        List<Integer> idsEstablecimientos = new LinkedList<>();

        System.out.println("Instituciones actualmente en la base de datos: ");
        System.out.println("id - CIF - Nombre - Razón Social - Teléfono");
        for (Institucion i : instituciones) {
            int idv = i.getIdVoluntario();
            System.out.println(idv +", "+ i.toString());
            idsVoluntarios.add(i.getIdVoluntario());
        }

        System.out.println("\nPersonas actualmente en la base de datos: ");
        System.out.println("id - dni - nombre - apellido1 - apellido2 - tlf - email -  edad - localidad");
        for (Persona p : personas) {
            int idv = p.getIdVoluntario();
            System.out.println(idv +", "+ p.toString());
            idsVoluntarios.add(p.getIdVoluntario());
        }


        int idVoluntario;
        boolean primero = true;
        do {
            if (!primero) System.out.println("id erroneo");
            primero = false;
            System.out.println("Introduzca el id del voluntario (persona o institución) que realiza la recogida: ");
            idVoluntario = Teclado.readInt();
        } while (!idsVoluntarios.contains(idVoluntario));

        List<Establecimiento> establecimientos = mEstablecimiento.getEstablecimientos();
        System.out.println("Establecimientos registrados en la base de datos: ");
        System.out.println("id - nombre - dirección - localidad");
        for (Establecimiento e : establecimientos) {
            System.out.println(e);
            idsEstablecimientos.add(e.getId());
        }


        int idEstablecimiento;
        primero = true;
        do {
            if (!primero) System.out.println("Id erroneo.");
            primero = false;
            System.out.println("Introduzca el id del establecimiento en el que se ha recogido el alimento: ");
            idEstablecimiento = Teclado.readInt();
        } while (!idsEstablecimientos.contains(idEstablecimiento));

        mRecoge.registraRecogida(idVoluntario, idEstablecimiento, alimento);

    }

    public static void actualizarCIF(ManejaInstitucion mInstitucion) {
        List<Institucion> instituciones = mInstitucion.getInstituciones();

        System.out.println("Instituciones actualmente en la base de datos: ");
        System.out.println("id - CIF - Nombre - Razón Social - Teléfono");
        for (Institucion i : instituciones) {
            System.out.println(i.getIdVoluntario() +", "+ i.toString());
        }

        String cif = null;
        do {
            if (cif != null) {
                System.out.println("CIF Incorrecto");
            }
            System.out.println("Introduzca CIF de la institución que desea modificar (con letra en mayuscula): ");
            cif = Teclado.readString();
        } while (!cif.matches("([A-Z])(\\d{8})"));

        String cifNuevo = null;
        do {
            if (cifNuevo != null) {
                System.out.println("CIF Incorrecto");
            }
            System.out.println("Introduzca nuevo CIF (con letra en mayuscula): ");
            cifNuevo = Teclado.readString();
        } while (!cifNuevo.matches("([A-Z])(\\d{8})"));

        mInstitucion.cambiaCIF(cif, cifNuevo);
    }

    public static void alimentosCaducados(ManejaAlimento mAlimento) {
        System.out.println("Eliminando alimentos caducados: ");
        List<Alimento> alimentos = mAlimento.alimentosCaducados();
        for (Alimento a : alimentos) {
            System.out.println(a);
        }

        for (Alimento a : alimentos) {
            mAlimento.eliminaAlimento(a.getId());
        }

    }

    public static void productosRecogidosPorVoluntario(ManejaInstitucion mInstitucion, ManejaPersona mPersona, ManejaRecoge mRecoge) {

        List<Persona> personas = mPersona.getPersonas();
        List<Institucion> instituciones = mInstitucion.getInstituciones();
        List<Integer> idsVoluntarios = new LinkedList<>();

        System.out.println("Instituciones actualmente en la base de datos: ");
        System.out.println("id - CIF - Nombre - Razón Social - Teléfono");
        for (Institucion i : instituciones) {
            System.out.println(i.getIdVoluntario() + ", "+i.toString());
            idsVoluntarios.add(i.getIdVoluntario());
        }

        System.out.println("\nPersonas actualmente en la base de datos: ");
        System.out.println("id - dni - nombre - apellido1 - apellido2 - tlf - email -  edad - localidad");
        for (Persona p : personas) {
            System.out.println(p.getIdVoluntario() + ", "+p.toString());
            idsVoluntarios.add(p.getIdVoluntario());
        }


        int idVoluntario;
        boolean primero = true;
        do {
            if (!primero) System.out.println("id erroneo");
            primero = false;
            System.out.println("Introduzca el id del voluntario (persona o institución) que desea consultar: ");
            idVoluntario = Teclado.readInt();
        } while (!idsVoluntarios.contains(idVoluntario));

        List<Alimento> alimentos = new LinkedList<>();
        List<Establecimiento> establecimientos = new LinkedList<>();

        mRecoge.productosRecogidos(idVoluntario, alimentos, establecimientos);

        Persona persona;
        Institucion institucion;
        if (alimentos.size() <= 5) {
            if (!mPersona.existeVoluntario(idVoluntario)) {
                institucion = mInstitucion.getVoluntario(idVoluntario);
                System.out.println(institucion);
            } else {
                persona = mPersona.getVoluntario(idVoluntario);
                System.out.println(persona);
            }
        } else {
            for (int i = 0; i < alimentos.size(); i++) {
                System.out.println(alimentos.get(i).toString() + establecimientos.get(i).toString());
            }
        }

    }
}
