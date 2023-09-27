import {useDispatch, useSelector} from "react-redux";
import {Link} from "react-router-dom";
import {addToCart, clearCart, removeFromCart} from "../../redux/products/cartSlice";

const ShowCart = () => {
    const cartItems = useSelector(state => {
        console.log(state.cart)
        return state.cart;
    });
    const dispatch = useDispatch();
    const handleDeleteToCart = (item) => {
        dispatch(removeFromCart(item));
    };
    const handleClearToCart = () => {
        dispatch(clearCart());
    };
    return (<>
        <div className="container">
            <div className="row">
                <div className="col-md-6">
                    <h2 className="text-left">Cart Product</h2>
                </div>
            </div>
            <table className="table table-striped">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Price</th>
                    <th>DiscountPercentage</th>
                    <th>Rating</th>
                    <th>Stock</th>
                    <th>Brand</th>
                    <th>Thumbnail</th>

                    <th className="disabled-sorting text-right">Actions</th>
                </tr>
                </thead>
                <tbody>
                {
                    cartItems && cartItems.map(item => (
                        <tr>
                            <td>{item.id}</td>
                            <td>{item.title}</td>
                            <td>{item.price}</td>
                            <td>{item.discountPercentage}</td>
                            <td>{item.rating}</td>
                            <td>{item.stock}</td>
                            <td>{item.brand}</td>
                            <td><img src={item.thumbnail} style={{width:'50px', height:'50px'}} alt=""/></td>
                            <td className="disabled-sorting text-right">
                                <button className="btn btn-danger" onClick={() => {handleDeleteToCart(item)}}>Delete</button>
                            </td>
                        </tr>
                    ))
                }
                </tbody>
            </table>
            <br/>
            <button onClick={handleClearToCart} className="btn btn-info">Clear</button>
        </div>
    </>)

}
export default ShowCart;