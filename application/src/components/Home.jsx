import React from 'react'
import Navbar from "./Navbar.jsx";

export const Home = () => {
    return (
        <div>
            <Navbar />
            <div className="hero-section">
                <div className="bg-img"></div>
                <div className="highlight">
                    <h1>Welcome to Abendessen</h1>
                    <p>Experience the finest dining with us</p>
                </div>
            </div>
        </div>
    )
}