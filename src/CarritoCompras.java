public class CarritoCompras {

    public void finalizarCompra(ProcesadorPago pasarela, double total) {

        System.out.println("\nProcesando compra...");
        System.out.println("Total a pagar: $" + total);

        boolean resultado = pasarela.efectuarCobro(total);

        if (resultado) {

            System.out.println("COMPRA FINALIZADA CON EXITO.");

        } else {

            System.out.println("NO SE PUDO COMPLETAR LA COMPRA.");
        }

        System.out.println("--------------------------------");
    }
}