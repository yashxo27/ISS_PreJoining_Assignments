balance = 5000

password = "1234"
user_input = input("Enter your ATM PIN: ")

if user_input == password:
    print("Access Granted")
else:
    print("Incorrect PIN")
    exit()

while True:
    print("\n--- ATM MENU ---")
    print("1. Check Balance")
    print("2. Deposit Money")
    print("3. Withdraw Money")
    print("4. Exit")
    
    choice = input("Choose an option (1-4): ")
    
    print("Processing", end="")
    for _ in range(3):
        print(".", end="")
    print()

    if choice == "1":
        print(f"Your balance is ₹{balance}")
        continue

    elif choice == "2":
        deposit = int(input("Enter amount to deposit: "))
        if deposit <= 0:
            print("Invalid amount.")
            continue
        balance += deposit
        print(f"₹{deposit} deposited successfully.")
    
    elif choice == "3":
        withdraw = int(input("Enter amount to withdraw: "))
        if withdraw > balance:
            print("Insufficient funds.")
            continue
        balance -= withdraw
        print(f"₹{withdraw} withdrawn successfully.")
    
    elif choice == "4":
        print("Thank you for using the ATM. Goodbye!")
        break

    else:
        print("Invalid choice. Try again.")
        pass

else:
    print("Session ended without exit.")
