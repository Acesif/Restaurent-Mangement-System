import './App.css'
import { BrowserRouter, Route, Routes, Link } from 'react-router-dom';
import {Signup} from "./components/Signup.jsx";
import {Home} from "./components/Home.jsx";
import {Login} from "./components/Login.jsx";
import {Dashboard} from './components/Dashboard.jsx'
import {Category} from "./components/Category.jsx";
import ManageCategory from "./components/ManageCategory.jsx";

function App() {

  return (
    <BrowserRouter>
        <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/signup" element={<Signup />} />
            <Route path="/login" element={<Login />} />
            <Route path="/admin/dashboard" element={<Dashboard />} />
            <Route path="/admin/category" element={<Category />} />
            <Route path="/admin/category/manage" element={<ManageCategory />} />
        </Routes>
    </BrowserRouter>
  )
}

export default App
