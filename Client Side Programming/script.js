const sizeInputs = document.querySelectorAll('input[name="size"]');
const toppingInputs = document.querySelectorAll('.topping');
const totalPriceDisplay = document.getElementById("totalPrice");

function calculatePrice() {
  let price = 0;

  // Pizza size price
  sizeInputs.forEach(input => {
    if (input.checked) {
      price += parseInt(input.getAttribute("data-price"));
    }
  });

  // Toppings price
  toppingInputs.forEach(input => {
    if (input.checked) {
      price += 50;
    }
  });

  totalPriceDisplay.textContent = "Total Price: ₹" + price;
}

sizeInputs.forEach(input => input.addEventListener('change', calculatePrice));
toppingInputs.forEach(input => input.addEventListener('change', calculatePrice));

function validateForm() {
  const address = document.getElementById("address").value.trim();
  const contact = document.getElementById("contact").value.trim();

  if (address === "" || contact === "") {
    alert("Please fill in all required fields.");
    return false;
  }

  if (!document.querySelector('input[name="size"]:checked')) {
    alert("Please select a pizza size.");
    return false;
  }

  alert("Order placed successfully!");
  return true;
}
