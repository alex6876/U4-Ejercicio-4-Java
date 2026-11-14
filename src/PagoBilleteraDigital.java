public class PagoBilleteraDigital implements ProcesadorPago {

    private String tokenValido;

    public PagoBilleteraDigital(String tokenValido) {
        this.tokenValido = tokenValido;
    }

    @Override
    public boolean efectuarCobro(double monto) {

        if (monto > 0 && tokenValido.equals("TOKEN123")) {

            System.out.println("Pago realizado con billetera digital.");
            System.out.println("Token validado correctamente.");

            return true;

        } else {

            System.out.println("Pago rechazado: token invalido.");
            return false;
        }
    }
}