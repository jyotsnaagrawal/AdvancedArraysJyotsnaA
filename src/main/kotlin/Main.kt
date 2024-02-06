import kotlin.math.abs

fun main() {
    // List of Variables
    val inventory = arrayOf(
        arrayOf("Hot Dogs", 50),
        arrayOf("Buns", 100),
        arrayOf("Ketchup", 20),
        arrayOf("Mustard", 15),
        arrayOf("Onions", 30)
    )

    // Function to search for an item in the inventory
    fun searchItem(itemName: String): Int {
        for (i in inventory.indices) {
            if (itemName == inventory[i][0]) {
                return i
            }
        }
        return -1 // Return -1 if the item is not found
    }

    // Function to update inventory based on user input
    fun updateInventory(itemIndex: Int, amount: Int) {
        val originalAmount = inventory[itemIndex][1] as Int

        // Check if the inventory will become less than 0
        val adjustedAmount = if (originalAmount + amount < 0) {
            -originalAmount // Set amount to the negative of the original amount
        } else {
            amount
        }

        // Update the inventory
        inventory[itemIndex][1] = originalAmount + adjustedAmount

        // Display information about the update
        println("Item: ${inventory[itemIndex][0]}")
        println("Original Amount: $originalAmount")
        println("Amount ${if (amount >= 0) "Added" else "Subtracted"}: ${abs(adjustedAmount)}")
        println("New Total: ${inventory[itemIndex][1]}")
    }

    // Get user input for the item name
    println("Enter the name of the item:")
    val itemName = readlnOrNull()?.trim()

    // Search for the item in the inventory
    val itemIndex = searchItem(itemName.orEmpty())

    if (itemIndex != -1) {
        // If the item is found, get user input for the amount to be added or subtracted
        println("Enter the amount to add or subtract:")
        val amount = readlnOrNull()?.toIntOrNull() ?: 0

        // Update the inventory based on user input
        updateInventory(itemIndex, amount)
    } else {
        // If the item is not found, display an error message
        println("Error: Item not found in the inventory.")
    }
}
