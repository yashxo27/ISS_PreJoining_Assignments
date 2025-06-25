def greet_customer(name):
    return f"Welcome, {name}! Let's order your pizza."

def calculate_bill(size, crust, price_per_inch=20):
    diameter = int(size.replace("inch", ""))
    return diameter * price_per_inch if crust == "regular" else diameter * (price_per_inch + 5)

def list_toppings(*toppings):
    return f"Toppings chosen: {', '.join(toppings)}"

def order_summary(customer, size, crust, *toppings, **extras):
    print(greet_customer(customer))
    print(list_toppings(*toppings))
    if extras:
        print("Extra Options:")
        for key, value in extras.items():
            print(f" - {key.capitalize()}: {value}")
    bill = calculate_bill(size, crust)
    print(f"Total bill: ₹{bill}")

order_summary(
    "Aryan",
    "12inch",
    "cheese burst",
    "olives",
    "jalapenos",
    "sweet corn",
    delivery="Yes",
    drinks="Pepsi",
    coupon="WELCOME100"
)
