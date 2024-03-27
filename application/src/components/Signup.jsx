import React, {useState} from 'react'
import Restaurent from '../assets/restaurent.png'
import {signup} from "../utils/restapi.js";
import {ToastContainer, toast, Bounce} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

export const Signup = () => {

    const [showPass,setShowPass] = useState("password")
    const toggleShowPass = () =>{
        const passComp = document.querySelector(".password")
        passComp.type === "password" ? setShowPass("text") : setShowPass("password")
    }

    const signUp = async(e) => {
        e.preventDefault()
        try{
            let name = document.querySelector(".name").value.trim()
            let email = document.querySelector(".email").value.trim()
            let number = document.querySelector(".number").value.trim()
            let password = document.querySelector(".password").value.trim()
            if((name || email || number || password) === ""){
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
                const creds = {
                    "name": name,
                    "email": email,
                    "phoneNumber": number,
                    "password": password
                }
                const res = await signup(creds)
                if(res.status === 201){
                    document.querySelector(".name").value = ""
                    document.querySelector(".email").value = ""
                    document.querySelector(".number").value = ""
                    document.querySelector(".password").value = ""
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
                    <form className="form">
                        <label>
                            <p className="name-p">Name</p>
                            <input required={true} className="name inp" type="text"/>
                        </label>
                        <label>
                            <p className="email-p">Email</p>
                            <input required={true} className="email inp" type="email"/>
                        </label>
                        <label>
                            <p className="number-p">Phone Number</p>
                            <input required={true} className="number inp" type="text"/>
                        </label>
                        <label>
                            <p className="password-p">Password</p>
                            <div className="pass-box">
                                <input required={true} className="password inp" type={showPass}/>
                                <div className="checkbox">
                                    <input className="showpass" onClick={() => toggleShowPass()} type="checkbox"/>
                                    <p>Show password</p>
                                </div>
                            </div>
                        </label>
                        <div className="btn-wrap">
                            <button onClick={(e) => signUp(e)} className="submit-btn">Submit</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    )
}