import React, { useState, useEffect } from 'react';
import Navbar from "./Navbar.jsx";
import { toast, ToastContainer } from "react-toastify";
import {deleteCategory, getCategories} from "../utils/restapi.js";

const handleDelete = async(id) => {
    await deleteCategory(id);
}

const ViewCategories = () => {
    const [categories, setCategories] = useState([]);
    const [loading, setLoading] = useState(true);

    const menu = [
        {
            "name": "Manage Categories",
            "link": "http://localhost:5173/admin/category/manage"
        },
        {
            "name": "Create Category",
            "link": "http://localhost:5173/admin/category"
        }
    ];

    useEffect(() => {
        const fetchCategories = async () => {
            try {
                const response = await getCategories();
                response?.data?.map(e => {
                    e.image = `data:image/jpeg;base64,${e.returnedImage}`
                })
                setCategories(response.data);
                setLoading(false);
            } catch (error) {
                console.error("Error fetching categories:", error);
                toast.error("Failed to fetch categories", { position: "top-center" });
            }
        };

        fetchCategories();
    }, [categories]);

    return (
        <div>
            <Navbar />
            <ToastContainer />
            <div className="section">
                <div className="categories-page">
                    {loading ? (
                        <p>Loading categories...</p>
                    ) : (
                        <div className="category-section">
                            {categories.map(category => (
                                <div key={category.id}>
                                    <div className="crud-container">
                                        <div>
                                            <h3>{category.name}</h3>
                                            <p>{category.description}</p>
                                        </div>
                                        <div>
                                            <button className="submit-btn view-prod">View Product
                                            </button>
                                            <button className="submit-btn post-prod">Post Product
                                            </button>
                                        </div>
                                    </div>
                                    <img width="300px" height="300px" src={category.image} alt={category.description}/>
                                    <div>
                                        <button className="submit-btn delete"
                                                onClick={() => handleDelete(category.id)}>Delete
                                        </button>
                                    </div>
                                </div>
                            ))}
                        </div>
                    )}
                </div>
            </div>
        </div>
    );
};

export default ViewCategories;
