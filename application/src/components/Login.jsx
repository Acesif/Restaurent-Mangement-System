import React, {useState} from 'react'
import Restaurent from '../assets/restaurent.png'
import {login} from "../utils/restapi.js";
import {ToastContainer, toast, Bounce} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import {saveSession} from "../utils/utilityMethods.js";
import {useNavigate} from "react-router-dom";
export const Login = () => {

    const navigateTo = useNavigate();
    const [showPass, setShowPass] = useState("password");
    const [formData, setFormData] = useState({
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
            const {email,password} = formData;
            const res = await login(formData)
            if(res.status === 200){
                saveSession(res);
                setFormData({
                    email: '',
                    password: ''
                })
                toast.success("Login successful", {
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
                res?.data?.role === "ADMIN"
                    ? navigateTo("/admin/dashboard")
                    : navigateTo("/")
            } else {
                toast.error("Enter valid credentials", {
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
            }
        } catch (e) {
            toast(e)
        }
    }

    return(
        <div className="signup">
            <ToastContainer />
            <div className="container">
                <div className="card-body">
                    <h2>Login</h2>
                    <form className="form" onSubmit={handleSubmit}>
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
                                minLength="8"
                                value={formData.password}
                                onChange={handleChange}
                            />
                        </label>
                        <div className="pass-box">
                            <input className="showpass" onClick={() => toggleShowPass()} type="checkbox"/>
                            <p>Show password</p>
                        </div>
                        <a href="/signup">Don't have an account?</a>
                        <button className="submit-btn" type="submit">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    )
}