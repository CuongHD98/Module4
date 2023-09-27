import {useDispatch, useSelector} from "react-redux";
import {useEffect, useState} from "react";
import {getProduct, getProducts} from "../../service/productService";
import {Link, useParams} from "react-router-dom";
import {addToCart} from "../../redux/products/cartSlice";

const ViewProduct = () => {
    const dispatch = useDispatch();
    const {idProduct} = useParams();
    const product = useSelector(state => {
        console.log(state.products.product)
        return state.products.product;
    })
    useEffect(() => {
        dispatch(getProduct(idProduct))
    },[]);
    const handleAddToCart = (item) => {
        dispatch(addToCart(item));
    };
    return (<>
        <div className="container">
            <div className="row">
                <div className="col-md-6">
                    <h2 className="text-left">Product Detail</h2>
                </div>
                <div className="col-md-6">
                    <p className="text-right">
                        <Link to={"/product"}>
                            <a  className="btn btn-primary" role="button">Back To List Product</a>
                        </Link>
                    </p>
                </div>
            </div>
            <p>-------------------</p>
            <div className="card">
                <div className="card-body">
                    <p className="card-text"><b>ID</b>: {product.id}</p>
                    <p className="card-text"><b>Title</b>: {product.title}</p>
                    <p className="card-text"><b>Description</b>: {product.description}</p>
                    <p className="card-text"><b>Price</b>: {product.price}</p>
                    <p className="card-text"><b>DiscountPercentage</b>: {product.discountPercentage}</p>
                    <p className="card-text"><b>Rating</b>: {product.rating}</p>
                    <p className="card-text"><b>Stock</b>: {product.stock}</p>
                    <p className="card-text"><b>Brand</b>: {product.brand}</p>
                    <p className="card-text"><b>Category</b>: {product.category}</p>
                    <p className="card-text"><b>Thumbnail</b>: <img src={product.thumbnail} style={{width:'50px', height: '50px'}} alt=""/></p>
                    <p className="card-text"><b>Images</b>: {product.images && product.images.map(image => (
                        <img src={image} style={{width:'50px', height: '50px'}} alt=""/>
                    ))}</p>
                </div>
            </div>
            <p>-------------------</p>
            <button className="btn btn-primary" onClick={()=>{handleAddToCart(product)}}>Add to Cart</button>
        </div>
    </>)

}
export default ViewProduct;