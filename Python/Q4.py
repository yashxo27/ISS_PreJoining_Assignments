item_name = input("Enter the item name: ")                      
item_price = input("Enter the price of one item (₹): ")         
item_quantity = input("Enter the quantity you want to buy: ")  

price = float(item_price)       
quantity = int(item_quantity)    

total_cost = price * quantity

is_cart_empty = bool(quantity == 0)  # Returns True if quantity is 0

print("\nBILL RECEIPT")
print(f"Item       : {item_name}")
print(f"Unit Price : ₹{price:.2f}")
print(f"Quantity   : {quantity}")
print(f"Total Cost : ₹{total_cost:.2f}")
print(f"Cart Empty : {is_cart_empty}")
