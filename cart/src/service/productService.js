import {createAsyncThunk} from "@reduxjs/toolkit";
import axios from "axios";

export const getProducts = createAsyncThunk(
    "products/getProducts",
    async (skip) => {
        const res = await axios.get("https://dummyjson.com/products?limit=10&skip=" + skip);
        return res.data;
    }
)
export const getProduct = createAsyncThunk(
    "products/getProduct",
    async (idProduct) => {
        const res = await axios.get("https://dummyjson.com/products/" + idProduct);
        return res.data;
    }
)