import {configureStore} from "@reduxjs/toolkit";
import productReducer from "./products/productsSlice";
import cartReducer from "./products/cartSlice";


export const store = configureStore({
    reducer: {
        products: productReducer,
        cart: cartReducer
    }
})
