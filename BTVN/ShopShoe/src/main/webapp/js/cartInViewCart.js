var quantityInput1 = document.getElementById("quantity-input1");
var decreaseButton1 = document.querySelector(".quantity-decrease1");
var increaseButton1 = document.querySelector(".quantity-increase1");

decreaseButton1.addEventListener("click", function() {
    if (quantityInput1.value > quantityInput1.min) {
        quantityInput1.value--;
    }
});

increaseButton1.addEventListener("click", function() {
    quantityInput1.value++;
});