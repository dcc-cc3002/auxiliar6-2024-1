package user

import exceptions.InsufficientBalanceException

/**
 * Represents a form of payment in the shopping app.
 *
 * @param initBalance the initial balance in the wallet.
 */
class Wallet(initBalance: Int) {

  private var _balance: Int = initBalance

  /**
   * @return The current balance in the wallet.
   */
  def balance: Int = _balance

  /**
   * Subtracts a specified amount from the wallet.
   *
   * @param price The price to pay.
   */
  def pay(price: Int): Unit = {
    if (_balance < price) throw new InsufficientBalanceException
    _balance -= price
  }
}
