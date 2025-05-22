package org.example.parking;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class EstacionamientoTest {

    @Test
    public void testRetirarVehiculo() throws Exception {
        //TODO test
        
        Estacionamiento estacionamiento = new Estacionamiento();
        String dni = "12345678";
        String nombre = "jose";
        Vehiculo vehiculo = new Vehiculo("AAA", "gol", Vehiculo.Tipo.AUTO);
        
        
        boolean ingresado = estacionamiento.ingresarVehiculo(dni, nombre, vehiculo);
        assertTrue(ingresado);
        
        
        Ticket ticket = estacionamiento.retirarVehiculo("AAA");
        assertEquals(vehiculo, ticket.getVehiculo());
        assertEquals(nombre, ticket.getCliente().getNombre());
        assertTrue(ticket.getHoraSalida() != null);
        
        

    }

    @Test
    public void testCalcularPrecio() throws Exception {
        Cliente cliente = new Cliente("44556","jose");
        Vehiculo vehiculo = new Vehiculo("AJT", "gol", Vehiculo.Tipo.AUTO);

        Ticket ticket = new Ticket(cliente, vehiculo);
        ticket.setHoraSalida(ticket.getHoraEntrada().plusMinutes(90));

        double precio = ticket.calcularPrecio();
        assertEquals(200.0, precio);
    }

}