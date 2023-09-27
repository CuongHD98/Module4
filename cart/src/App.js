import './App.css';
import Navbar from "./components/navbar";
import {Route, Routes} from "react-router-dom";
import ShowProduct from "./pages/product/showProduct";
import ViewProduct from "./pages/product/viewProduct";
import ShowCart from "./pages/cart/showCart";

function App() {
    return (
        <Routes>
            <Route path="" element={<Navbar/>}>
                <Route path="/product" element={<ShowProduct/>}/>
                <Route path="/product/view/:idProduct" element={<ViewProduct/>}/>
                <Route path="/cart" element={<ShowCart/>}/>
            </Route>
        </Routes>
    );
}

export default App;
