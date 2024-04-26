package app

import munit.FunSuite
import user.{User, Wallet}

class ShoppingAppTest extends FunSuite{

  var user: User = _
  var shoppingApp: ShoppingApp = _

  override def beforeEach(context: BeforeEach): Unit = {
    user = new User
    shoppingApp = new ShoppingApp

    shoppingApp.addStock("Item 1", 2)
    shoppingApp.addStock("Item 2", 3)
    shoppingApp.addStock("Item 3", 5)

    shoppingApp.addPrice("Item 1", 2000)
    shoppingApp.addPrice("Item 2", 4000)
    shoppingApp.addPrice("Item 3", 6000)

    user.addItem("Item 1", 2)
    user.addItem("Item 2", 1)
    user.addItem("Item 3", 2)
  }

  test("It should pay correctly for the items") {
    user.wallet = new Wallet(50000)
    assertEquals(shoppingApp.processTransaction(user), "The operation was successful")
    assertEquals(user.wallet.balance, 30000)
    assertEquals(shoppingApp.stock("Item 1"), 0)
    assertEquals(shoppingApp.stock("Item 2"), 2)
    assertEquals(shoppingApp.stock("Item 3"), 3)
  }

  test("It should throw an exception if the item is not in the store") {
    user.addItem("Item 4", 2)
    assertEquals(shoppingApp.processTransaction(user), "The item was not found in the store")
  }

  test("It should throw an exception if the item is out of stock") {
    user.addItem("Item 1", 20)
    assertEquals(shoppingApp.processTransaction(user), "There's not enough stock for the item")
  }

  test("It should throw an exception if the user is asking for a negative amount") {
    user.addItem("Item 1", -20)
    assertEquals(shoppingApp.processTransaction(user), "You can't buy a negative amount of the item")
  }

  test("It should throw an exception if the user doesn't have enough money") {
    user.wallet = new Wallet(1)
    assertEquals(shoppingApp.processTransaction(user), "You don't have enough money")
  }

  test("It should throw an exception if the user doesn't have a wallet") {
    assertEquals(shoppingApp.processTransaction(user), "You have no wallet")
  }
}
