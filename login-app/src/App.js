import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import LoginPage from './login';
import RestrictedPage from './restricted'; 
import HomePage from './homepage';
import { useState } from "react";
import "./App.css";

function App() {
    const [userData, setUserData] = useState(null);

    return (
        <Router>
            <div className="App">
                <Routes>
                    <Route path="/restricted" element={<RestrictedPage userData={userData}/>} />
                    <Route path="/homepage" element={<HomePage userData={userData}/>} />
                    <Route path="/" element={<LoginPage setUserData={setUserData}/>} />
                </Routes>
            </div>
        </Router>
    );
}
export default App;