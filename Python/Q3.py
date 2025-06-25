age = 21

first_name = "Isha"
last_name = "Patel"
intro = f"Hello, I'm {first_name} {last_name} and I'm {age} years old."

is_employed = True

hobbies = ["Reading", "Dancing", "Coding", "Traveling"]

birthdate = (2003, 4, 15)

skills = {"Python", "Java", "Public Speaking", "Python"}

contact_info = {
    "email": "isha.patel@example.com",
    "phone": "+91-9876543210",
    "city": "Mumbai"
}

print("Personal Profile")
print(intro)
print(f"Employed      : {is_employed}")
print(f"Hobbies       : {', '.join(hobbies)}")
print(f"Birthdate     : {birthdate[2]}-{birthdate[1]}-{birthdate[0]} (DD-MM-YYYY)")
print(f"Skills        : {', '.join(skills)}")
print("Contact Info  :")
for key, value in contact_info.items():
    print(f"  {key.capitalize()}: {value}")
