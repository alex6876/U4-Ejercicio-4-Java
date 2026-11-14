public class PagoTarjetaCredito implements ProcesadorPago {

    private double limiteDisponible;

    public PagoTarjetaCredito(double limiteDisponible) {
        this.limiteDisponible = limiteDisponible;
    }

    @Override
    public boolean efectuarCobro(double monto) {

        if (monto <= limiteDisponible && monto > 0) {

            limiteDisponible -= monto;

            System.out.println("Pago realizado con tarjeta de credito.");
            System.out.println("Limite restante: $" + limiteDisponible);

            return true;

        } else {

            System.out.println("Pago rechazado: limite insuficiente.");
            return false;
        }
    }
}