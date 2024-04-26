package app

import user.User

import scala.collection.mutable

/**
 * Represents the app. This class manages the stock and
 * prices of the items.
 */
class ShoppingApp {

  private val _stock: mutable.Map[String, Int] = mutable.Map()
  private val _prices: mutable.Map[String, Int] = mutable.Map()

  /**
   * @return The item's stock.
   */
  def stock: mutable.Map[String, Int] = _stock

  /**
   * @return The item's prices.
   */
  def prices: mutable.Map[String, Int] = _prices

  /**
   * Adds more stock to an item. If the item is new, it creates
   * a new reference to it, but if it's already present, it will
   * update the amount registered.
   *
   * @param item The item being updated.
   * @param amount The amount to be added.
   */
  def addStock(item: String, amount: Int): Unit = {
    if (stock contains item) {
      _stock(item) += amount
    } else {
      _stock += (item -> amount)
    }
  }

  /**
   * Updates the price of an item. If the item is new, it creates
   * a new reference to it, but if it's already present, it will
   * update the price registered.
   *
   * @param item The item being updated.
   * @param price The new price.
   */
  def addPrice(item: String, price: Int): Unit = {
    if (prices contains item) {
      _prices(item) = price
    } else {
      _prices += (item -> price)
    }
  }

  /**
   * It processes a transaction between a user and the app.
   * This method will check the items, calculate the price,
   * pay and update the stock.
   *
   * @param user The user buying the items.
   * @return A message indicating the result of the transaction.
   */
  def processTransaction(user: User): String = {

    // Completar implementación acá
    // 1. Validar los items
    // 2. Calcular precio a pagar
    // 3. Pagar
    // 4. Actualizar el stock

    null
  }

  /**
   * Checks if the items can be purchased. It verifies the items
   * exists, that there's enough stock, and if the user is asking
   * for a valid amount of items.
   *
   * @param items The items being purchased.
   */
  private def checkItems(items: mutable.Map[String, Int]): Unit = {

    // Completar implementación acá

  }

  /**
   * It updates the current stock based on a list of purchased items.
   *
   * @param items The purchased items.
   */
  private def updateStock(items: mutable.Map[String, Int]): Unit = {
    for ((k, v) <- items) {
      _stock(k) -= v
    }
  }

  /**
   * Calculates the total price of a list of items.
   *
   * @param items The items being purchased.
   * @return The total price.
   */
  private def calculatePrice(items: mutable.Map[String, Int]): Int = {
    var finalPrice: Int = 0

    for ((k, v) <- items) {
      finalPrice += _prices(k)*v
    }

    finalPrice
  }
}
