Aquí tienes la estructura en formato Markdown lista para el `README.md` de este código de **Simulación de Pasarela de Pagos mediante Interfaces y Polimorfismo en Java**, manteniendo el enfoque exclusivo de **Programación Orientada a Objetos en memoria** (sin bases de datos):

---

# 💳 Simulación de Pasarela de Pagos Multicanal (Interfaces y Polimorfismo en Java)

Este proyecto es una aplicación en Java que modela un sistema e-commerce de procesamiento de pagos, implementando una arquitectura basada en **interfaces (`interface`)** para desacoplar completamente el carrito de compras de las pasarelas transaccionales (tarjetas de crédito, criptomonedas y billeteras digitales). Pone en práctica conceptos fundamentales de la **Programación Orientada a Objetos (POO)** como la **implementación obligatoria de contratos de interfaces**, la inyección de dependencias polimórfica, el manejo de estados internos en memoria y la validación defensiva de saldos y tokens.

---

## 🧩 Clases y Estructura del Sistema

El diseño del software se organiza a través de una interfaz de contrato, sus respectivas clases implementadoras, un componente controlador de compras y un punto de ejecución:

* **`ProcesadorPago` (Interfaz)**: Define el contrato estándar que cualquier pasarela de pagos del sistema debe cumplir obligatoriamente.
* **Método abstracto**: `boolean efectuarCobro(double monto)`: Obliga a las clases implementadoras a definir la lógica de validación y descuento de fondos, retornando un indicador booleano de éxito.


* **`PagoTarjetaCredito`**: Implementa la interfaz `ProcesadorPago` para procesar cobros bancarios con límites de crédito configurables.
* **Atributo privado (`private`)**: `limiteDisponible`.
* **Constructor**: Inicializa el límite máximo de crédito de la tarjeta.
* **Sobrescritura (`@Override`)**:
* `efectuarCobro(double monto)`: Valida que el monto sea positivo y no supere el límite disponible, descuenta los fondos y confirma el estado operativo de la cuenta.




* **`PagoCripto`**: Implementa `ProcesadorPago` para gestionar transacciones mediante activos digitales y saldos de criptomonedas.
* **Atributo privado (`private`)**: `saldoCripto`.
* **Constructor**: Configura el saldo inicial en criptoactivos.
* **Sobrescritura (`@Override`)**:
* `efectuarCobro(double monto)`: Comprueba la disponibilidad de fondos en la wallet, ejecuta la deducción correspondiente e informa el saldo remanente.




* **`PagoBilleteraDigital`**: Implementa `ProcesadorPago` para validar transacciones mediante tokens de seguridad en aplicaciones móviles.
* **Atributo privado (`private`)**: `tokenValido`.
* **Constructor**: Asigna el token de autenticación autorizado.
* **Sobrescritura (`@Override`)**:
* `efectuarCobro(double monto)`: Verifica la validez estricta del token de acceso (comparándolo con `"TOKEN123"`) y autoriza o rechaza el pago.




* **`CarritoCompras`**: Componente controlador encargado de gestionar el flujo de finalización de transacciones.
* **Método operativo**: `finalizarCompra(ProcesadorPago pasarela, double total)`: Recibe de forma polimórfica cualquier objeto que implemente la interfaz `ProcesadorPago`, imprime los datos del total a pagar, invoca al método de cobro y emite el comprobante de éxito o rechazo.


* **`Main`**: Punto de entrada del programa. Instancia un carrito de compras y tres procesadores de pago distintos (tarjeta, cripto y billetera digital), ejecuta múltiples operaciones transaccionales (incluyendo una prueba de rechazo por límite insuficiente en la tarjeta) y genera por consola el historial completo de la sesión.

---

## ⚙️ Reglas de Negocio y Control de Validación

1. **Desacoplamiento Mediante Interfaces:** La clase `CarritoCompras` desconoce por completo las implementaciones concretas de pago (`PagoTarjetaCredito`, `PagoCripto`, etc.); interactúa exclusivamente con el contrato genérico `ProcesadorPago`, logrando un diseño sumamente flexible y escalable.
2. **Validación Defensiva de Fondos y Autenticación:** Cada medio de pago implementa sus propios controles de seguridad en memoria (verificación de límites disponibles, saldos de criptomonedas o tokens de validación digital).
3. **Inyección de Dependencias Polimórfica:** El controlador de compras recibe la pasarela de pago como parámetro en tiempo de ejecución, permitiendo cambiar dinámicamente el medio de cobro sin modificar la lógica del carrito.

---

## 💻 Salida por Consola

Al ejecutar la clase `Main`, el programa genera el siguiente resultado:

```text
===== PAGO CON TARJETA =====

Procesando compra...
Total a pagar: $15000.0
Pago realizado con tarjeta de credito.
Limite restante: $35000.0
COMPRA FINALIZADA CON EXITO.
--------------------------------
===== PAGO CON CRIPTOMONEDAS =====

Procesando compra...
Total a pagar: $20000.0
Pago realizado con criptomonedas.
Saldo restante: $10000.0
COMPRA FINALIZADA CON EXITO.
--------------------------------
===== PAGO CON BILLETERA DIGITAL =====

Procesando compra...
Total a pagar: $10000.0
Pago realizado con billetera digital.
Token validado correctamente.
COMPRA FINALIZADA CON EXITO.
--------------------------------
===== SEGUNDO PAGO CON TARJETA =====

Procesando compra...
Total a pagar: $40000.0
Pago rechazado: limite insuficiente.
NO SE PUDO COMPLETAR LA COMPRA.
--------------------------------

```

---

## 🚀 Conceptos de Programación Aplicados

* **Polimorfismo de Interfaces:** Uso de contratos abstractos (`interface`) para unificar el comportamiento de pasarelas de pago heterogéneas bajo una misma referencia tipada.
* **Principio de Inversión de Dependencias:** El componente de negocio (`CarritoCompras`) depende de abstracciones y no de implementaciones concretas.
* **Diseño Modular y Extensible:** Capacidad absoluta para incorporar nuevos procesadores de pago (como PayPal o transferencias bancarias) al sistema simplemente implementando la interfaz `ProcesadorPago`, sin alterar el código existente.
