import React, { useState } from 'react';
import Navbar from "./Navbar.jsx";
import {Bounce, toast, ToastContainer} from "react-toastify";
import {upload} from "../utils/restapi.js";
import {Sidebar} from "./Sidebar.jsx";

export const Category = () => {
    const [formData, setFormData] = useState({
        name: '',
        description: '',
        image: null,
    });
    const [imagePreview, setImagePreview] = useState(null);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value,
        });
    };

    const handleImageChange = (e) => {
        const file = e.target.files[0];
        setFormData({
            ...formData,
            image: file,
        });

        const reader = new FileReader();
        reader.onload = () => {
            setImagePreview(reader.result);
        };
        reader.readAsDataURL(file);
    };
    const handleRemoveImage = () => {
        setFormData({
            ...formData,
            image: null,
        });
        setImagePreview(null);
    };

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

    const handleSubmit = async(e) => {
        e.preventDefault();
        try{
            const {name,description,image} = formData;
            if((name.trim() || description.trim() ) === ""){
                toast.error("Please Fill up the form", {
                    position: "top-center",
                    autoClose: 1000,
                    hideProgressBar: false,
                    closeOnClick: true,
                    pauseOnHover: true,
                    draggable: true,
                    progress: undefined,
                    theme: "dark",
                    transition: Bounce
                });
            } else {
                const formDataToSend = new FormData();
                formDataToSend.append("name", name);
                formDataToSend.append("description", description);
                formDataToSend.append("image", image);
                const res = await upload(formDataToSend)
                if(res.status === 201){
                    setFormData({
                        name: '',
                        description: '',
                        image: null,
                    });
                    setImagePreview(null);
                    toast.success("Category upload successful", {
                        position: "top-center",
                        autoClose: 1000,
                        hideProgressBar: false,
                        closeOnClick: true,
                        pauseOnHover: true,
                        draggable: true,
                        progress: undefined,
                        theme: "dark",
                        transition: Bounce,
                    });
                }
            }
        } catch (e) {
            toast(e)
        }
    };

    return (
        <>
            <Navbar />
            <ToastContainer />
            <div className="section">
                <div className="wrapper">
                    <Sidebar menu={menu}/>
                </div>
                <div className="upload-page">
                    <h2>Upload Item</h2>
                    <form onSubmit={handleSubmit}>
                        <div>
                            <label htmlFor="name">Name:</label>
                            <input
                                type="text"
                                id="name"
                                name="name"
                                value={formData.name}
                                onChange={handleChange}
                                required
                            />
                        </div>
                        <div>
                            <label htmlFor="description">Description:</label>
                            <textarea
                                id="description"
                                name="description"
                                value={formData.description}
                                onChange={handleChange}
                                required
                            ></textarea>
                        </div>
                        <div>
                            <label htmlFor="image">Image:</label>
                            <div className="img-up-container">
                                <input
                                    type="file"
                                    id="image"
                                    name="image"
                                    accept="image/*"
                                    onChange={handleImageChange}
                                    required
                                />
                                {imagePreview &&
                                    <button onClick={handleRemoveImage} className="submit-btn remove-button">
                                        Remove
                                    </button>
                                }
                            </div>
                        </div>
                        {imagePreview && (
                            <div>
                                <img src={imagePreview} alt="Preview" style={{maxWidth: '100%', marginTop: '10px' }} />
                            </div>
                        )}
                        <button className="submit-btn" type="submit">Upload</button>
                    </form>
                </div>
            </div>
        </>
    );
};

