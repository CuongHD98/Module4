// Lấy danh sách tất cả các nút xóa sản phẩm
const removeButtons = document.querySelectorAll('.remove-cart');

// Thêm sự kiện 'click' cho từng nút xóa sản phẩm
removeButtons.forEach(button => {
    button.addEventListener('click', function() {
        // Lấy phần tử cha của nút xóa sản phẩm, tức là thẻ 'tr' chứa thông tin sản phẩm
        const productRow = this.closest('tr');

        // Ẩn thẻ 'tr' chứa thông tin sản phẩm
        productRow.style.display = 'none';
    });
});