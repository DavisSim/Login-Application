import { useState } from "react";
import axios from 'axios';

function LoginPage({ setUserData }) {
    const [userId, setUserId] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/api/login', {
                userId,
                password
            });
            if (response.data) {
                sessionStorage.setItem('user', JSON.stringify(response.data))
                if (response.data.role === 'manager') {
                    window.location.href = '/homepage';
                    alert(`Welcome ${response.data.name}`);
                } else if (response.data.role === 'user') {
                    window.location.href = '/homepage';
                    alert(`Welcome ${response.data.name}`);
                }
            } else {
                setError('Invalid userId or password');
            }
        } catch (error) {
            setError('Invalid userId or password');
        }
    };

    return (
        <div className="App">
            <div className="login-container">
                <h1>Login</h1>
                {error && <div className="error-message">{error}</div>}
                <form onSubmit={handleSubmit}>
                    <div className="input-group">
                        <input type="text" placeholder="User ID" value={userId} onChange={(e) => setUserId(e.target.value)} />
                    </div>
                    <div className="input-group">
                        <input type="password" placeholder="Password" value={password} onChange={(e) => setPassword(e.target.value)} />
                    </div>
                    <button type="submit">Login</button>
                </form>
            </div>
        </div>
    );
}

export default LoginPage;
