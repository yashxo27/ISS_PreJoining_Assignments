student_name = "Aarav Mehta"
student_class = "10th Grade"
roll_number = 23

math_marks = 87
science_marks = 92
english_marks = 78
history_marks = 85
computer_marks = 95

total_marks = math_marks + science_marks + english_marks + history_marks + computer_marks
average_marks = total_marks / 5

if average_marks >= 90:
    grade = "A+"
elif average_marks >= 80:
    grade = "A"
elif average_marks >= 70:
    grade = "B"
elif average_marks >= 60:
    grade = "C"
else:
    grade = "D"

print("Student Report Card:")
print(f"Name       : {student_name}")
print(f"Class      : {student_class}")
print(f"Roll No.   : {roll_number}")
print()
print(f"Math       : {math_marks}")
print(f"Science    : {science_marks}")
print(f"English    : {english_marks}")
print(f"History    : {history_marks}")
print(f"Computer   : {computer_marks}")
print()
print(f"Total Marks: {total_marks} / 500")
print(f"Average    : {average_marks:.2f}")
print(f"Grade      : {grade}")
