import React from 'react'
import Navbar from "./Navbar.jsx";
import {getSession} from "../utils/utilityMethods.js";

export const Dashboard = () => {
    const session = getSession();
    return (
        <div className="dashboard">
            <Navbar />
            <div className="hero-section">
                <p>{session?.name}</p>
            </div>
        </div>
    )
}