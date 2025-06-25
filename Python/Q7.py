def book_ticket(age):
    try:
        if not isinstance(age, int):
            raise TypeError("Age must be an integer.")
        if age < 0:
            raise ValueError("Age cannot be negative.")
    except (TypeError, ValueError) as e:
        print(f"Error: {e}")
    else:
        if age < 18:
            print("Ticket booked for child.")
        else:
            print("Ticket booked for adult.")
    finally:
        print("Booking process ended.")

book_ticket(16)
book_ticket("twenty")
book_ticket(-5)
