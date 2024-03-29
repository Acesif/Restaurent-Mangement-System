import './App.css'
import { BrowserRouter, Route, Routes, Link } from 'react-router-dom';
import {Signup} from "./components/Signup.jsx";
import {Home} from "./components/Home.jsx";

function App() {

  return (
    <BrowserRouter>
        <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/signup" element={<Signup />} />
        </Routes>
    </BrowserRouter>
  )
}

export default App
