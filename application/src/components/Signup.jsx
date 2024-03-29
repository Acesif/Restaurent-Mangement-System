import React, {useState} from 'react'
import Restaurent from '../assets/restaurent.png'
import {signup} from "../utils/restapi.js";
import {ToastContainer, toast, Bounce} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { useNavigate } from 'react-router-dom';

export const Signup = () => {

    const navigateTo = useNavigate();
    const [showPass, setShowPass] = useState("password");
    const [formData, setFormData] = useState({
        name: '',
        phoneNumber: '',
        email: '',
        password: ''
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value,
        });
    };
    const toggleShowPass = () =>{
        const passComp = document.querySelector(".password")
        passComp.type === "password" ? setShowPass("text") : setShowPass("password")
    }

    const handleSubmit = async(e) => {
        e.preventDefault()
        try{
            const {name,phoneNumber,email,password} = formData;
            if((name || email || phoneNumber || password) === ""){
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
                const res = await signup(formData)
                if(res.status === 201){
                    setFormData({
                        name: '',
                        phoneNumber: '',
                        email: '',
                        password: ''
                    })
                    toast.success("Sign up successful", {
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
                    navigateTo("https://google.com")
                }
            }
        } catch (e) {
            toast(e)
        }
    }

    return(
        <div className="signup">
            <ToastContainer />
            <div className="container">
                <div className="card-img">
                    <img src={Restaurent} alt="restaurent-banner"/>
                </div>
                <div className="card-body">
                    <h2>Sign Up</h2>
                    <form className="form" onSubmit={handleSubmit}>
                        <label>
                            <p className="name-p">Name</p>
                            <input
                                required={true}
                                className="name inp"
                                type="text"
                                name="name"
                                value={formData.name}
                                onChange={handleChange}
                            />
                        </label>
                        <label>
                            <p className="number-p">Phone Number</p>
                            <input
                                required={true}
                                className="number inp"
                                type="text"
                                name="phoneNumber"
                                value={formData.phoneNumber}
                                onChange={handleChange}
                            />
                        </label>
                        <label>
                            <p className="email-p">Email</p>
                            <input
                                required={true}
                                className="email inp"
                                type="email"
                                name="email"
                                value={formData.email}
                                onChange={handleChange}
                            />
                        </label>
                        <label>
                            <p className="password-p">Password</p>
                            <input
                                required={true}
                                className="password inp"
                                type={showPass}
                                name="password"
                                value={formData.password}
                                onChange={handleChange}
                            />
                        </label>
                        <div className="pass-box">
                            <input className="showpass" onClick={() => toggleShowPass()} type="checkbox"/>
                            <p>Show password</p>
                        </div>
                        <button className="submit-btn" type="submit">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    )
}