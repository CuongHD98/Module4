import {Link, Outlet} from "react-router-dom";
import {useSelector} from "react-redux";

const Navbar = () => {
    const cartItems = useSelector(state => {
        return state.cart;
    });
    return (<>
        <nav className="navbar navbar-inverse">
            <div className="container-fluid">
                <div className="navbar-header">
                    <Link to={"/"}>
                        <a className="navbar-brand">CuongHD</a>
                    </Link>
                </div>
                <ul className="nav navbar-nav">
                    <li className="active">
                        <Link to={"/"}>
                            <a href="/">Home</a>
                        </Link>
                    </li>
                    <li>
                        <Link to={"/product"}>
                            <a>Product</a>
                        </Link>
                    </li>
                </ul>
                <ul className="nav navbar-nav navbar-right">
                    <li>
                        <Link to={"/cart"}>
                            <a><span className="glyphicon glyphicon-shopping-cart"></span> Cart({cartItems.length})</a>
                        </Link></li>
                </ul>
            </div>
        </nav>
        <Outlet></Outlet>

    </>)

}
export default Navbar;