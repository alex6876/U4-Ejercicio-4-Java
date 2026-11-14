public class Main {

    public static void main(String[] args) {

        CarritoCompras carrito = new CarritoCompras();



        ProcesadorPago tarjeta = new PagoTarjetaCredito(50000);

        ProcesadorPago cripto = new PagoCripto(30000);

        ProcesadorPago billetera = new PagoBilleteraDigital("TOKEN123");


        System.out.println("===== PAGO CON TARJETA =====");

        carrito.finalizarCompra(tarjeta, 15000);




        System.out.println("===== PAGO CON CRIPTOMONEDAS =====");

        carrito.finalizarCompra(cripto, 20000);




        System.out.println("===== PAGO CON BILLETERA DIGITAL =====");

        carrito.finalizarCompra(billetera, 10000);


        System.out.println("===== SEGUNDO PAGO CON TARJETA =====");

        carrito.finalizarCompra(tarjeta, 40000);
    }
}