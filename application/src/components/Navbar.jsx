import React, {useEffect, useState} from 'react';
import { Link } from 'react-router-dom';
import Logo from '../assets/logo.png'
import {endSession, getSession} from "../utils/utilityMethods.js";
const Navbar = () => {
    const [isOpen, setIsOpen] = useState(false)
    const [session, setSession] = useState()
    const [loggedIn, setLoggedIn] = useState(false)
    const toggleMenu = () => {
        setIsOpen(!isOpen);
    }
    const logOut = () => {
        toggleMenu()
        endSession()
        setLoggedIn(false)
    }
    useEffect(() => {
        const sessionData = getSession()
        setSession(sessionData)
        sessionData === null ? setLoggedIn(false) : setLoggedIn(true)
    }, []);
    return (
        <nav>
            <div className="container">
                <Link to="/" className="logo">
                    <img className="logo-img" src={Logo}/>
                    <h3>Abendessen</h3>
                </Link>
                <div className={`menu-icon ${isOpen ? 'open' : ''}`} onClick={toggleMenu}>
                    <div className="bar"></div>
                    <div className="bar"></div>
                    <div className="bar"></div>
                </div>
                <ul className={`nav-links ${isOpen ? 'open' : ''}`}>
                    <li><Link to="/" onClick={toggleMenu}>Home</Link></li>
                    {(session?.role === "USER") && loggedIn &&
                        <li><Link to="/menu" onClick={toggleMenu}>Menu</Link></li>
                    }
                    {(session?.role === "ADMIN") && loggedIn &&
                        <>
                            <li><Link to="/admin/dashboard" onClick={toggleMenu}>Dashboard</Link></li>
                            <li><Link to="/admin/category" onClick={toggleMenu}>Category</Link></li>
                        </>
                    }
                    {!loggedIn &&
                        <>
                        <li><Link to="/signup" onClick={toggleMenu}>Sign up</Link></li>
                            <li><Link to="/login" onClick={toggleMenu}>Login</Link></li>
                        </>
                    }
                    {loggedIn &&
                        <li><Link to="/" onClick={logOut}>Log out</Link></li>
                    }
                </ul>
            </div>
        </nav>
    );
}

export default Navbar;