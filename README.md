# Auxiliar 6: Excepciones

## Contexto

Usted está implementando una aplicación de e-commerce. En esta etapa le toca programar la funcionalidad de pago de la aplicación.
En esta, usted deberá manejar todos los casos bordes para evitar problemas durante la transacción.

La operación de pago se divide en estas etapas:

1. Procesar los items en el carrito
2. Calcular el precio total
3. Pagar
4. Actualizar el stock

## Actividad

Usted debe completar la implementación de las siguientes funciones usando excepciones para manejar los casos
borde.

### User

El método `pay` paga un precio determinado usando la billetera del usuario. Para descontar el monto en la
billetera se recomienda usar los métodos de `Wallet`. Si el usuario no tiene una biletera registrada, no 
puede completar la transacción.

```scala
def pay(price: Int): Unit = {
  // Completar implementación acá
}
```

### Wallet

El método `pay` descuenta una cantidad determina de dinero del balance actual. Si no tiene saldo suficiente,
no debería poder hacer la transacción.

```scala
def pay(price: Int): Unit = {
  // Completar implementación acá
}
```

### ShoppingApp

El método `checkItems` se encarga de verificar que la información entregada sea válida. Una lista de compra
válida debe tener solo elementos que estén registrados en la aplicación, debe solicitar una cantidad
disponible de cada item, y debe solicitar una cantidad no negativa de cada item. Si no es válida, no puede
realizar la transacción.

```scala
private def checkItems(items: mutable.Map[String, Int]): Unit = {
  // Completar implementación acá
}
```

Para recorrer los items en el `Map` pueden usar el siguiente código:

```scala
for ((k, v) <- items) {
  ...
}
```

Donde `k` es la llave, y `v` el valor asociado.

### Try / Catch

En `ShoppingApp`, debe completar el método `processTransaction`, el cual debe realizar todos los pasos necesarios
para completar la transacción (revise la sección del contexto). Este método debe manejar los errores usando
try/catch de forma que retorne un mensaje distinto dependiendo del resultado de la transacción.

```scala
def processTransaction(user: User): String = {

  // Completar implementación acá
  // 1. Validar los items
  // 2. Calcular precio a pagar
  // 3. Pagar
  // 4. Actualizar el stock

  null
}
```

**Nota:** Revise los mensajes esperados en los tests. Si quiere usar otros, actualicelos en los tests para que
pueda evaluar su solución.