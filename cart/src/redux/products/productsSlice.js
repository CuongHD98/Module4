import {createSlice} from "@reduxjs/toolkit";
import {getProduct, getProducts} from "../../service/productService";
const initialState = {
    products: [],
    product: {}
}
const productsSlice = createSlice({
    name: "products",
    initialState,
    reducers: {},
    extraReducers: builder => {
        builder.addCase(getProducts.fulfilled,(state,action) => {
            state.products = action.payload;
        })
        builder.addCase(getProduct.fulfilled,(state,action) => {
            state.product = action.payload;
        })
    }
})
export default productsSlice.reducer;