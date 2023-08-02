var quantityInput = document.getElementById("quantity-input");
var decreaseButton = document.querySelector(".quantity-decrease");
var increaseButton = document.querySelector(".quantity-increase");

decreaseButton.addEventListener("click", function() {
    if (quantityInput.value > quantityInput.min) {
        quantityInput.value--;
    }
});

increaseButton.addEventListener("click", function() {
    quantityInput.value++;
});