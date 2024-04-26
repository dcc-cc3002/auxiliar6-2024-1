package user

import scala.collection.mutable

/**
 * Represents a user that uses the shopping app.
 *
 * This user has a shopping list, which contains all the items
 * they want to buy, and the amount of each item. They also
 * have a wallet, which is a registry of their form of payment.
 */
class User {

  private var _wallet: Wallet = _
  private val _shoppingList: mutable.Map[String, Int] = mutable.Map[String, Int]()

  /**
   * @return This user's wallet.
   */
  def wallet: Wallet = _wallet

  /**
   * Sets a new wallet.
   *
   * @param wallet The new wallet being set.
   */
  def wallet_=(wallet: Wallet): Unit = _wallet = wallet

  /**
   * @return This user's shopping list.
   */
  def shoppingList: mutable.Map[String, Int] = {
    _shoppingList
  }

  /**
   * Adds an item to the shopping list.
   *
   * @param name The item's name.
   * @param amount The amount wanted.
   */
  def addItem(name: String, amount: Int): Unit = {
    if (_shoppingList contains name)
      _shoppingList(name) += amount
    else
      _shoppingList += (name -> amount)
  }

  /**
   * Pays an specified amount using their wallet.
   *
   * @param price The amount to pay.
   */
  def pay(price: Int): Unit = {

    // Completar implementación acá

  }
}
