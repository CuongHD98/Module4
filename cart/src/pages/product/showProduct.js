import {useDispatch, useSelector} from "react-redux";
import {useEffect, useState} from "react";
import {getProducts} from "../../service/productService";
import {Link} from "react-router-dom";
import {addToCart, clearCart} from "../../redux/products/cartSlice";



const ShowProduct = () => {
    const dispatch = useDispatch();
    const products = useSelector(state => {
        return state.products.products;
    })
    let [count, setCount] = useState(0);
    useEffect(() => {
        dispatch(getProducts(count))
    },[count]);
    const previousPage = () => {
        if (count > 0) {
            setCount(count - 10);
        }
    }
    const nextPage = () => {
        if ((count + 10) < products.total) {
            setCount(count + 10);
        }
    }
    const handleAddToCart = (item) => {
        dispatch(addToCart(item));
    };
    return (<>
        <div className="container">
            <div className="row">
                <div className="col-md-6">
                    <h2 className="text-left">List Product</h2>
                </div>
            </div>
            <table className="table table-striped">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>DiscountPercentage</th>
                    <th>Rating</th>
                    <th>Stock</th>
                    <th>Brand</th>
                    <th>Category</th>
                    <th>Thumbnail</th>

                    <th className="disabled-sorting text-right">Actions</th>
                </tr>
                </thead>
                <tbody>
                {
                    products.products && products.products.map(product => (
                        <tr>
                            <td>{product.id}</td>
                            <td><Link to={"/product/view/" + product.id}>
                                <a>{product.title}</a>
                            </Link></td>
                            <td>{product.description}</td>
                            <td>{product.price}</td>
                            <td>{product.discountPercentage}</td>
                            <td>{product.rating}</td>
                            <td>{product.stock}</td>
                            <td>{product.brand}</td>
                            <td>{product.category}</td>
                            <td><img src={product.thumbnail} style={{width:'50px', height:'50px'}} alt=""/></td>
                            <td className="disabled-sorting text-right">
                                <button className="btn btn-primary" onClick={()=>{handleAddToCart(product)}}>Add to Cart</button>
                            </td>
                        </tr>
                    ))
                }
                </tbody>
            </table>
            <ul className="pager">
                <li><button onClick={previousPage} className="btn btn-info">Previous</button></li> &nbsp;
                <li><button onClick={nextPage} className="btn btn-info">Next</button></li>
            </ul>
        </div>
    </>)

}
export default ShowProduct;